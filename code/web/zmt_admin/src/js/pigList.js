/**
 * Created by dev on 2017/11/01.
 *
 *
 * 模块：屠宰管理-生猪列表
 */
$(document).ready(function() {
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var fig = $.verifyById(userInfoArr.userId);
	var rloeType = $.isRloe('屠宰场管理');
	var pigList = sessionStorage.getItem('pigList');
	var pigListData = JSON.parse(pigList);
	var classNameArr = ['.statusBtn', '.editorBtn', '.butcherDetailAdd'];
	if(rloeType == '0') {
		$.hiddenOperateBtn(classNameArr)
	};
	if(pigListData.role == 'normalUser') { //普通用户
		$('.butcher_m,.personnel').addClass('none');
		$('#butcher_details_rowData').text(JSON.stringify(pigListData));
		var arrys = ["account", "userId", "status", "number", "userName", "principal", "phone", "address", "districtId"];
		$.adminInfoArea(arrys, pigListData, "#butcher_details_", ".statusBtn")
		pigListTableLoade(userInfoArr.userId);
		butcherCode = 1;
		$.pigType(allUrl.findFilepigType, "#butcher-type");

	} else {

		if(fig) {

			$('#butcher_details_rowData').text(pigList);
			var arrys = ["account", "userId", "status", "number", "userName", "principal", "phone", "address", "districtId"];
			$.adminInfoArea(arrys, pigListData, "#butcher_details_", ".statusBtn")
			var userId = $('#butcher_details_userId').text()
			pigListTableLoade(userId);
			$.pigType(allUrl.findFilepigType, "#butcher-type");
			$("#butcher-status option[value=''] ").prop("selected", true);
		}
	}
	var butcherBetails;

	function pigListTableLoade(userId) {
		/*
		 * 生猪列表--table
		 * 
		 * */
		var columnArrs = ["id", "pigId", "pigBreed", "status", null];
		var columnDefArrs = [{
			targets: 1,
			orderable: false,
			visible: false
		}, {
			targets: 4,
			orderable: false,
			render: function(data) {
				if(data == 0) {
					return '<p>正常</p>'
				} else if(data == 1) {
					return '<p>死亡</p>'
				} else if(data == 2) {
					return '<p>宰前待检验</p>'
				} else if(data == 3) {
					return '<p>待屠宰</p>'
				} else if(data == 4) {
					return '<p>宰后待检验</p>'
				} else if(data == 5) {
					return '<p>待销售 </p>'
				} else if(data == 6) {
					return '<p>已处理 </p>'
				} else if(data == 7) {
					return '<p>已销售 </p>'
				} else {
					return null;
				}
			}
		}, {
			targets: -1,
			orderable: false,
			render: function(data) {
				if(rloeType == '1') {
					return('<a href="#" class="text-primary lookBtn">查看详情</a>')
				} else {
					if(data.status == 0) {
						return('<a class="text-gary">待检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
					} else if(data.status == 1) {
						return('<a class="text-gary">待检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
					} else if(data.status == 2) {
						return('<a href="#" class="text-primary butcherBeforBtn">宰前检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
					} else if(data.status == 3) {
						return('<a  class="text-primary butcherBtn">屠宰</a><a href="#" class="text-primary lookBtn">查看详情</a>');
					} else if(data.status == 4) {
						return('<a href="#" class="text-primary butcherAfterBtn">宰后检验</a><a href="#" class="text-primary lookBtn">查看详情</a>')
					} else if(data.status == 5) {
						return('<a href="#" class="text-primary butcherBtn">销售录入</a><a href="#" class="text-primary lookBtn">查看详情</a>')
					} else if(data.status == 6) {
						return('<a href="#" class="text-primary lookBtn">查看详情</a>')
					} else if(data.status == 7) {
						return('<a href="#" class="text-primary lookBtn">查看详情</a>')
					} else {
						return null;
					}
				}

			}
		}];
		var butcherBetailsTable = {
			id: "butcherBetailsTable",
			url: allUrl.butcherPersonnelPigList,
			searchParams: {
				id: $('#butcher_details_userId').text()
			},
			columns: columnArrs,
			lengthChange: false,
			scrollX: true,
			columnDefs: columnDefArrs

		}
		butcherBetails = $.createTable(butcherBetailsTable);

	};
	$(document).on('click', ".lookBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = $('#butcherBetailsTable').DataTable().row($(this).parents('tr')).data();

			if(pigListData.role == 'normalUser') {
				cellData.role = 'normalUser';
			}
			sessionStorage.pigDetail = JSON.stringify(cellData);
			$(".main-content").load('./pigDetail.html');
			//			window.location.href=('./pigDetail.html');
		}
	});
	/*
	 * 生猪列表--禁、启用
	 */
	$(document).on('click', '.statusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $("#butcher_details_status").text();
			var id = $('#butcher_details_userId').text();
			var statusTxt;
			if(txt == "disable" || txt == "禁用") {
				statusTxt = "启用";
			} else {
				statusTxt = "禁用";
			}
			var arrs = ['#butcher_details_account', "#butcher_details_status", '.statusBtn', '.tips']
			$.enabledOrDisabled(id, statusTxt, tableButcher, arrs);

		}
	});
	/*
	 * 生猪列表--宰前待检验
	 */
	$(document).on('click', '.butcherBeforBtn', function() {
		var tit = '宰前检查报告';
		var checkType = 2;

		butcherReportFn(tit, checkType, this) //屠宰报告

		//		alert('宰前待检验')
	});
	/*
	 * 生猪列表--宰后待检验
	 */
	$(document).on('click', '.butcherAfterBtn', function() {
		var tit = '宰后检查报告';
		var checkType = 3;

		butcherReportFn(tit, checkType, this) //屠宰报告
	});
	/**
	 * 
	 * @param {Object} tit 弹框title
	 * @param {Object} url 新增报告路径
	 * @param {Object} ele 事件对象
	 */
	function butcherReportFn(tit, checkType, ele) {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = $('#butcherBetailsTable').DataTable().row($(ele).parents('tr')).data();
			
//			$.inspectorList(allUrl.butcherInspectorList, '#butcherInspectorList');
//			$('input[name=quarantineResult]').get(0).checked = true;
			cellData.checkType=checkType;
			var butcherBeforReport = layer.open({
				type: 2,
				id: 'butcherBeforReport',
				area: ['480px', '500px'],
				scrollbar: false,
				title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content:'../butcher_manage/butcher_layer.html'

				//

				//				btnAlign: 'c',
				//				btn:['确定','取消'],
				//				btn1:function(){
				//					confirmFn(checkType,cellData)
				//				},
				//				btn2:function(){
				//					formReset();
				//				},
				//				cancel:function(){
				//					formReset();
				//				}
			});
			//			$('reportInputLayer').removeClass('none')
			sessionStorage.rowData = JSON.stringify(cellData);
		}
	};

//	function confirmFn(checkType, cellData) {
//		var data = {};
//		var formVal = $('#reportInputFrom').serializeArray();
//		$.each(formVal, function() {
//			data[this.name] = this.value;
//		});
//		data.pigId = cellData.pigId;
//		data.type = 0;
//		data.checkType = checkType;
//		for(var key in data) {
//			if(data[key] === null || data[key] === "") {
//				delete data[key]
//			}
//		};    
//		if(!data.userId) {
//			layer.msg('请选择检验人员');
//			return false;
//		}
//
//		$.ajax({
//			type: "post",
//			async: true, //同步执行
//			url: allUrl.breedPigNewAddReport,
//			data: data,
//			success: function(dataAll) {
//				if(dataAll.code == 0) {
//					layer.closeAll();
//					butcherBetails.ajax.reload();
//					layer.msg('检验成功!');
//					formReset();
//				} else {
//					layer.alert(dataAll.message, {
//						skin: 'layui-layer-lan'
//					});
//				}
//
//			}
//		});
//	};
//
//	function formReset() {
//		$('input[name=quarantineResult]').get(0).checked = true;
//		var quarantineResultVal = $("input[name=quarantineResult]:checked").val();
//		$('.isDispose').addClass('none');
//		$('input[name=isDispose]').get(0).checked = false;
//		$('input[name=isDispose]').get(1).checked = false;
//		$('.describe').val("");
//		$('.remark').val("");
//		$($('.quarantineChecked')[0]).attr("src", '../src/images/public/choise3.png');
//		$($('.quarantineChecked')[1]).attr("src", '../src/images/public/choise2.png');
//		$($('.isDisposeChecked')[0]).attr("src", '../src/images/public/choise3.png');
//		$($('.isDisposeChecked')[1]).attr("src", '../src/images/public/choise2.png');
//		//		if(quarantineResultVal==1){
//		//			
//		//		}
//	};
//	/*
//	 * 检验结果
//	 */
//	$(document).on('click', '.quarantineChecked', function() {
//		radioCheckedFn(this, 'quarantineResult');
//	});
//	/*
//	 * 处理方式
//	 */
//	$(document).on('click', '.isDisposeChecked', function() {
//		radioCheckedFn(this, 'isDispose');
//	});
//
//	function radioCheckedFn(ele, check) {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var imgUrl = $(ele).attr("src");
//			var ipt = $(ele).parent().find('input');
//			var names = $(ipt).attr('name');
//			var ipts = $('input[name=' + names + ']');
//			var pImg, checkVal;
//			for(var i = 0; i < ipts.length; i++) {
//				pImg = $(ipts[i]).prev().prev();
//				if($(pImg).attr("src") != imgUrl) {
//					$(pImg).attr("src", '../src/images/public/choise2.png');
//				}
//			}
//			if(imgUrl == '../src/images/public/choise2.png') {
//				$(ele).attr("src", '../src/images/public/choise3.png');
//				$(ipt).prop("checked", true);
//				if(check == 'quarantineResult') {
//					checkVal = $("input[name=" + check + "]:checked").val();
//				};
//			} else if(imgUrl == '../src/images/public/choise3.png') {
//				$(ele).attr("src", '../src/images/public/choise3.png');
//				$(ipt).prop("checked", true);
//				if(check == 'quarantineResult') {
//					checkVal = $("input[name=" + check + "]:checked").val();
//				};
//			} else {
//				$(ele).attr("src", '../src/images/public/choise2.png');
//				$(ipt).prop("checked", false);
//				if(check == 'quarantineResult') {
//					checkValVal = $("input[name=" + check + "]:checked").val();
//				};
//			}
//			if(checkVal == 0) {
//				$('.isDispose').removeClass('none');
//				$('input[name=isDispose]').get(0).checked = true;
//			} else if(checkVal == 1) {
//				$('.isDispose').addClass('none');
//				$('input[name=isDispose]').get(0).checked = false;
//				$('input[name=isDispose]').get(1).checked = false;
//			}
//		}
//	}
	/*
	 * 生猪列表--待屠宰/待录入
	 */
	$(document).on('click', '.butcherBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var statusTxt = $('#butcher_details_status').text();
			if(statusTxt == "禁用" || statusTxt == "disable") {
				layer.alert("该人员已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			var txt = $(this).text();
			var cellData = $('#butcherBetailsTable').DataTable().row($(this).parents('tr')).data();
			sessionStorage.butcherData = JSON.stringify(cellData);
//			$(".slaughteredId,.pigId").text(cellData.pigId);
//			$(".salesId").text(cellData.pigId + "销售信息？");
			if(txt == "屠宰") {
				var tit = "屠宰";
//				var urls = allUrl.butcherSlaughterPig;
//				var data = {
//					id: cellData.id,
//					slaughterhouseId: pigListData.slaughterhouseId
//				}
//				var fig = $.verifyById(userInfoArr.userId);
//				if(fig) {
					butcherDateilsFn(tit);
//				}
			} else {
				var fig = $.verifyById(userInfoArr.userId);
				if(fig) {
					var tit = "销售录入";
//					var urls = allUrl.marketAddPigMsg;
					butcherDateilsFn(tit);
				}
			}

		}
	});

	function butcherDateilsFn(tit) {
		var slaughtered = layer.open({
			type:2,
			area: ['580px', '490px'],
//			btn: ['是', '否'],
			id: 'butcherBeforReport',
			title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
			content:'../butcher_manage/butcher_layer.html'
		})
	};
//			btnAlign: 'c',
//			btn1: function() {
//				var txt = $(".layui-layer-btn0").text();
//				if(txt == "是") {
//					if(ele == "slaughteredLayer") {
//						$.ajax({
//							type: "post",
//							async: true, //同步执行
//							url: urls,
//							data: data,
//							success: function(allData) {
//								if(allData.code == 0) {
//									layer.msg("<img src='../src/images/filing/slaughtered.png'/></br>ID:" + pigId + "</br>已被屠宰")
//									butcherBetails.ajax.reload();
//									layer.close(slaughtered);
//									$("#butcher_details_number").text(parseInt($("#butcher_details_number").text()) + 1)
//								} else {
//									layer.msg(allData.message);
//
//								}
//							}
//						})
//					} else {
//						$('.sales').addClass('none');
//						$(".pigId").val(pigId);
//						$('.entryArea').removeClass('none');
//
//						$(".layui-layer-btn0").text("保存");
//						$(".layui-layer-btn1").text("取消");
//					}
//
//				} else {
//					var fig = $.verifyById(userInfoArr.userId);
//					if(fig) {
//						saveFn(urls, slaughtered);
//					}
//				}
//			},
//			btn2: function() {
//				var txt = $(".layui-layer-btn1").text();
//				if(txt == "取消") {
//					formResetFn();
//
//				}
//			},
//			cancel: function() {
//				formResetFn();
//
//			}
//		});
//
//	};

//	function formResetFn() {
//		$(".suttle,.farmer").val(null);
//		$('#farmerName,#farmerPhone,#farmerAddress').text(null);
//		$("#salePigType,#marketId  option[value='001']").prop("selected", true);
//		$("#marketId  option[value='']").prop("selected", true);
//		$('.entryArea').addClass('none');
//		$('.sales').removeClass('none');
//	};
//	$(document).on('click', '.farmerBtn', function(e) {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var farmerName = $.trim($('.farmer').val());
//			if(farmerName == "") {
//				layer.msg('请输入电话或市场名称');
//				return;
//			} else {
//				var data = {
//					key: farmerName
//				}
//				$.farmerSearch(e, allUrl.butcherComList, data);
//
//			}
//		}
//
//	});
//	//验证净重
//	$(document).on('blur', '.suttle', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var suttles = $.trim($(this).val());
//
//			if(suttles != "") {
//				if(!isNaN(suttles)) {
//					var val = parseFloat(suttles).toFixed(2);
//					$('.suttle').val(val)
//				} else {
//					layer.msg('需输入数字');
//				}
//			}
//		}
//	});
//	//养殖户搜索后赋值
//
//	$(document).on('click', ".farmerLi", function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var me = this;
//			var arrays = ["farmerName", "farmerPhone", "farmerAddress", "farmerId"];
//			$.searchAssignment(me, ".farmer", ".farmerName", arrays, ".farmersList", 1);
//		}
//	});
	//保存
//	function saveFn(urls, slaughtered) {
//		
//
//	};
	/**
	 * 生猪列表--新增
	 */
	$(document).on('click', '.butcherDetailAdd', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var statusTxt = $('#butcher_details_status').text();
			if(statusTxt == "禁用" || statusTxt == "disable") {
				layer.alert("该人员已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			//			var rowData =JSON.parse($('#butcher_details_rowData').text());  //屠宰场ID

			var addPIg = layer.open({
				type: 2,
				id: 'butcher_layer',
				area: ['580px', '300px'],
				title: ['新增生猪', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content: '../butcher_manage/butcher_layer.html'
			});
		}
	});
	//				content: '../filing_manage/add_filing.html',
	//				btn: ['是', '否'],
	//				btnAlign: 'c',
	//				btn1: function(index, layero) {
	//					var fig = $.verifyById(userInfoArr.userId);
	//					if(fig) {
	//						var txt = $(".layui-layer-btn0").text();
	//						if(txt == "是") {
	//							var id = $.trim($(".addPig").val());
	//							 var slaughterhouseId =rowData.slaughterhouseId;
	//							var userId = rowData.userId; //用户id
	//							if(id == "") {
	//								layer.msg("请输入生猪ID号");
	//								return false;
	//							} else {
	//								$.ajax({
	//									type: "post",
	//									async: true, //同步执行
	//									url: allUrl.butcherPersonnelPigAdd,
	//									data: {
	//										pigId: id,
	//										slaughterhouseId:slaughterhouseId,
	//										userId: userId
	//									},
	//									success: function(dataAll) {
	//										if(dataAll.code == 0) {
	//											layer.close(addPIg);
	//											$(".addPig").val(null);
	//											butcherBetails.ajax.reload();
	//											layer.msg('录入成功！')
	//											$('.addPIgLayer').addClass('none');
	//										} else {
	//											layer.alert(dataAll.message, {
	//												skin: 'layui-layer-lan'
	//											});
	//											layer.close(addPIg);
	//											$(".addPig").val(null);
	//											butcherBetails.ajax.reload();
	//											$('.addPIgLayer').addClass('none');
	//										}
	//									}
	//
	//								});
	//							}
	//						}
	//					}
	//
	//				},
	//				btn2: function(index) {
	//					var fig = $.verifyById(userInfoArr.userId);
	//					if(fig) {
	//						$(".addPig").val(null);
	//						$('.addPIgLayer').addClass('none');
	//					}
	//				},
	//				cancel: function(index) {
	//					var fig = $.verifyById(userInfoArr.userId);
	//					if(fig) {
	//						$(".addPig").val(null);
	//						$('.addPIgLayer').addClass('none');
	//					}
	//				}
	//			});
	//			
	//		}
	//	});
	/**
	 * 生猪列表--搜索
	 */
	$(document).on('click', '.butcherDetailSearch', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			pigDetailSearch()
		}
	});
	$(document).on('change', '#butcher-status,#butcher-type', function() {

		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			pigDetailSearch()
		}
	});

	function pigDetailSearch() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var keyVal = $.trim($('#butcherDetailVal').val());
			var searchVal = {
				pigId: keyVal,
				id: $('#butcher_details_userId').text(),
				pigStatus: $('#butcher-status').val(),
				pigBreed: $('#butcher-type').val(),
			}
			for(var key in searchVal) {
				if(searchVal[key] === "") {
					delete searchVal[key];
				}
			}
			$.seacherFn(butcherBetails, searchVal);
		}
	};
	//修改屠宰场人员
	$(document).on('click', '.editorBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $('#butcher_details_status').text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该人员已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			} else {
				var tit = '修改屠宰场人员';
				$.detailsEditor(tit);
			}
		}
	});
	//	//返回上一页
	//	$(document).on('click', '.backUpper-toggle', function() {
	////		window.location.href = './butcherPerson.html';
	//		$("body").load('./butcherPerson.html');
	//	});
});