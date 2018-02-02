/**
 * Created by dev on 2017/9/26.
 *
 *
 * 模块：屠宰管理
 */
$(document).ready(function() {
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var pTitle ;
	if($(parent.$("#butcherBeforReport")[0]).parent().text()!=""){
		pTitle = $(parent.$("#butcherBeforReport")[0]).parent().text();
		table = $(parent.$("#butcherBeforReport")[0]).parents();
	}else{
		pTitle = $(parent.$("#butcher_layer")[0]).parent().text();
		table = $(parent.$("#butcher_layer")[0]).parents();
	}
	
	var index = parent.layer.getFrameIndex(window.name);
	var table,butcherDataArr,pigListData;
	var butcher_details_rowData = $(table.find('#butcher_details_rowData')).text();
	if(butcher_details_rowData){
		pigListData = JSON.parse(butcher_details_rowData);
	}
	
	
	var addEntryOutNum='新增出入库单屠宰数';
	var addPig='新增生猪'
	if(pTitle == addPig) {
		$('.addPIgLayer').removeClass('none');
		
		
	};
	if(pTitle == '宰前检查报告'||pTitle == '宰后检查报告') {
		$.inspectorList(allUrl.butcherGetInspectionList, '#butcherInspectorList');
			$('input[name=quarantineResult]').get(0).checked = true;
			$('.reportInputLayer').css({'display':'block','height':'360px'});
			$(".confirmBtn").text('确定');
			$(".cancelBtn").text('取消');
			
	}else if(pTitle == '屠宰'){
		
		var butcherData = sessionStorage.getItem('butcherData');
		butcherDataArr = JSON.parse(butcherData);
		butcherDataArr.slaughterhouseId=pigListData.slaughterhouseId;
		$('.slaughteredId').text(butcherDataArr.pigId)
		$('.slaughteredLayer').css({'display':'block','height':'200px'});
	}else if(pTitle == '销售录入'){
		var butcherData = sessionStorage.getItem('butcherData');
		butcherDataArr = JSON.parse(butcherData);
		$('.salesId').text(butcherDataArr.pigId);
		$('.pigId').val(butcherDataArr.pigId)
		$('.salesLayer').css({'display':'block','height':'200px'});
//		$(".confirmBtn").text('确定');
//		$(".cancelBtn").text('取消');
	}else if(pTitle == addEntryOutNum){
		$('.newAddBuctNum').css({'display':'block','height':'120px'});
		$(".confirmBtn").text('确定');
		$(".cancelBtn").text('取消');
	}
	
	var butcherBetails = parent.$('#butcherBetailsTable').DataTable();
	/**
	 * 新增生猪 
	 */
	$(document).on('click', '.confirmBtn', function() {

		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var txt = $(".confirmBtn").text();
			if(pTitle == '新增生猪'&&txt=='是') {
				var id = $.trim($(".addPig").val());
				var slaughterhouseId = pigListData.slaughterhouseId;
				var userId = pigListData.userId; //用户id
				if(id == "") {
					layer.msg("请输入生猪ID号");
					return false;
				} else {
					$.ajax({
						type: "post",
						async: true, //同步执行
						url: allUrl.butcherPersonnelPigAdd,
						data: {
							pigId: id,
							slaughterhouseId: slaughterhouseId,
							userId: userId
						},
						success: function(dataAll) {
							if(dataAll.code == 0) {
								layer.msg('录入成功！')
								butcherBetails.ajax.reload();
								setTimeout(function() {
									parent.layer.close(index);
									$('.addPIgLayer').addClass('none');
									$(".addPig").val(null);
								}, 1000)
							} else {
								layer.alert(dataAll.message, {
									skin: 'layui-layer-lan'
								});
								setTimeout(function() {
									parent.layer.close(index);
									$(".addPig").val(null);
									butcherBetails.ajax.reload();
									$('.addPIgLayer').addClass('none');
								}, 1000)
							}
						}

					});
				}
			}else if((pTitle == '宰前检查报告'&&txt=='确定')||(pTitle == '宰后检查报告'&&txt=='确定')){
				var rowData = sessionStorage.getItem('rowData');
				var rowDataArr = JSON.parse(rowData);
				confirmFn(rowDataArr)
			}else if(pTitle == '屠宰'&&txt=='是'){
				var urls = allUrl.butcherSlaughterPig;
				var data = {
					id: butcherDataArr.id,
					slaughterhouseId: butcherDataArr.slaughterhouseId
				}
				butcher(urls,data,butcherDataArr)
				
			}else if(pTitle == '销售录入'&&txt=='是'){
				$('.entryArea').removeClass('none');
				$('.salesLayer').css({'height':'340px'});
				$('.sales').css({'display':'none'});
				$(".confirmBtn").text('确定');
				$(".cancelBtn").text('取消');
			}else if(pTitle == '销售录入'&&txt=='确定') {
				saleEntry()
			}else if(pTitle == addEntryOutNum&&txt=='确定') {
				addEntryOutNumfn()
			}
		}
	});
	function saleEntry(){
		var data = {
			userId: $("#marketId").val(),
			marketId: $("#farmerId").text(),
			pigId: $('.pigId').val(),
			weight: $('.suttle').val()
		};
		if(data.userId == "") {
			layer.msg("请选择市场人员");
		} else if(data.weight == "") {
			layer.msg("请输入净重");
		} else if(data.marketId == "") {
			layer.msg("请选择市场");
		} else {
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.marketAddPigMsg,
				data: data,
				success: function(allData) {
					if(allData.code == 0) {
						layer.msg("销售录入成功");
						setTimeout(function() {
						parent.layer.close(index);
						butcherBetails.ajax.reload();
						formResetFn();
						},1000)
					} else {
						layer.msg(allData.message);

					}
				}
			})
		}
	};
	function addEntryOutNumfn(){
			var entryData = sessionStorage.getItem('entrySearchvalue');
			var	entryDataArr = JSON.parse(entryData);
		var butcherNumber = $('.butchNumber').val();
		if(butcherNumber){
			var entryDataUrl=entryDataArr.newAddButcherNumUrl;
			entryDataArr.number =butcherNumber;
			delete entryDataArr.slaughter_id;
			delete entryDataArr.newAddButcherNumUrl;
			$.ajax({
					url:entryDataUrl,
					type:'post',
					data:entryDataArr,
					async:false,
					success:function(data){
						if(data.code =='0'){
							 parent.$('.todayButcherNum').text(butcherNumber); 
							 parent.layer.close(index);
						}else{
							layer.msg(data.message);
						}
					}
				})
		}else {
			layer.msg('请输入今日屠宰数!');
		}
	};
	function butcher(urls,data,butcherDataArr){
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: data,
			success: function(allData) {
				if(allData.code == 0) {
					layer.msg("<img src='../src/images/filing/slaughtered.png'/></br>ID:" + butcherDataArr.pigId + "</br>已被屠宰")
					setTimeout(function() {
						parent.layer.close(index);
						butcherBetails.ajax.reload();
						$("#butcher_details_number").text(parseInt($("#butcher_details_number").text()) + 1)
					}, 1000)
					
					
				} else {
					layer.msg(allData.message);

				}
			}
		})
	};
	function confirmFn(cellData) {
		var data = {};
		var formVal = $('#reportInputFrom').serializeArray();
		$.each(formVal, function() {
			data[this.name] = this.value;
		});
		data.pigId = cellData.pigId;
		data.type = 0;
		data.checkType = cellData.checkType;
		for(var key in data) {
			if(data[key] === null || data[key] === "") {
				delete data[key]
			}
		};    
		if(!data.userId) {
			layer.msg('请选择检验人员');
			return false;
		}

		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.breedPigNewAddReport,
			data: data,
			success: function(dataAll) {
				if(dataAll.code == 0) {
					layer.msg('检验成功!');
					setTimeout(function() {
					parent.layer.close(index);
					butcherBetails.ajax.reload();
					formReset();
					}, 1000)
					
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		});
	};
	function formResetFn() {
		$(".suttle,.farmer").val(null);
		$('#farmerName,#farmerPhone,#farmerAddress').text(null);
		$("#salePigType,#marketId  option[value='001']").prop("selected", true);
		$("#marketId  option[value='']").prop("selected", true);
		$('.entryArea').addClass('none');
		$('.sales').removeClass('none');
	};
	function formReset() {
		$('input[name=quarantineResult]').get(0).checked = true;
		var quarantineResultVal = $("input[name=quarantineResult]:checked").val();
		$('.isDispose').addClass('none');
		$('input[name=isDispose]').get(0).checked = false;
		$('input[name=isDispose]').get(1).checked = false;
		$('.describe').val("");
		$('.remark').val("");
		$($('.quarantineChecked')[0]).attr("src", '../src/images/public/choise3.png');
		$($('.quarantineChecked')[1]).attr("src", '../src/images/public/choise2.png');
		$($('.isDisposeChecked')[0]).attr("src", '../src/images/public/choise3.png');
		$($('.isDisposeChecked')[1]).attr("src", '../src/images/public/choise2.png');
		//		if(quarantineResultVal==1){
		//			
		//		}
	};
	/**
	 * 新增生猪--取消
	 */
	$(document).on('click', '.cancelBtn', function() {
		parent.layer.close(index);
		$('.addPIgLayer').addClass('none');
		$(".addPig").val(null);
	});
	 /*
	 * 检验结果
	 */
	$(document).on('click', '.quarantineChecked', function() {
		radioCheckedFn(this, 'quarantineResult');
	});
	/*
	 * 处理方式
	 */
	$(document).on('click', '.isDisposeChecked', function() {
		radioCheckedFn(this, 'isDispose');
	});

	function radioCheckedFn(ele, check) {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var imgUrl = $(ele).attr("src");
			var ipt = $(ele).parent().find('input');
			var names = $(ipt).attr('name');
			var ipts = $('input[name=' + names + ']');
			var pImg, checkVal;
			for(var i = 0; i < ipts.length; i++) {
				pImg = $(ipts[i]).prev().prev();
				if($(pImg).attr("src") != imgUrl) {
					$(pImg).attr("src", '../src/images/public/choise2.png');
				}
			}
			if(imgUrl == '../src/images/public/choise2.png') {
				$(ele).attr("src", '../src/images/public/choise3.png');
				$(ipt).prop("checked", true);
				if(check == 'quarantineResult') {
					checkVal = $("input[name=" + check + "]:checked").val();
				};
			} else if(imgUrl == '../src/images/public/choise3.png') {
				$(ele).attr("src", '../src/images/public/choise3.png');
				$(ipt).prop("checked", true);
				if(check == 'quarantineResult') {
					checkVal = $("input[name=" + check + "]:checked").val();
				};
			} else {
				$(ele).attr("src", '../src/images/public/choise2.png');
				$(ipt).prop("checked", false);
				if(check == 'quarantineResult') {
					checkValVal = $("input[name=" + check + "]:checked").val();
				};
			}
			if(checkVal == 0) {
				$('.isDispose').removeClass('none');
				$('input[name=isDispose]').get(0).checked = true;
			} else if(checkVal == 1) {
				$('.isDispose').addClass('none');
				$('input[name=isDispose]').get(0).checked = false;
				$('input[name=isDispose]').get(1).checked = false;
			}
		}
	}
	$(document).on('click', '.farmerBtn', function(e) {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var farmerName = $.trim($('.farmer').val());
			if(farmerName == "") {
				layer.msg('请输入电话或市场名称');
				return;
			} else {
				var data = {
					key: farmerName
				}
				$.farmerSearch(e, allUrl.butcherComList, data);

			}
		}

	});
	//验证净重
	$(document).on('blur', '.suttle', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var suttles = $.trim($(this).val());

			if(suttles != "") {
				if(!isNaN(suttles)) {
					var val = parseFloat(suttles).toFixed(2);
					$('.suttle').val(val)
				} else {
					layer.msg('需输入数字');
				}
			}
		}
	});
	//养殖户搜索后赋值

	$(document).on('click', ".farmerLi", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var me = this;
			var arrays = ["farmerName", "farmerPhone", "farmerAddress", "farmerId"];
			$.searchAssignment(me, ".farmer", ".farmerName", arrays, ".farmersList", 1);
		}
	});
});