/**
 * Created by dev on 2017/9/26.
 *
 *
 * 模块：建档管理
 */
$(document).ready(function() {
	$.login('.type');
	var rloeType = $.isRloe('建档管理');
	var classNameArray = ['.addFilingBtn','.statusBtn','.editorBtn','.addFiling'];
	if(rloeType ==0){
		$.hiddenOperateBtn(classNameArray);
	}
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var columnArrs = ["department", "role", "account", "id", "status", "name", "phone", "archivesNumber", "address", null];
	var columnDefArrs = [{
		targets: 1,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets: 2,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets: 3,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets: 4,
		orderable: false,
		visible: false
	}, {
		targets: 5,
		orderable: false,
		visible: false
	},{
		targets: 6,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets:7,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets: 8,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets:9,
		orderable: false,
		render: function(data,i,k) {
			return	$.renderTable(data,k)
		}
	},{
		targets: -1,
		orderable: false,
		render: function(data) {
			if(rloeType =='1'){
				return('<a href="#" class="text-primary viewBtn">查看</a>')
			}else{
				if(data.status == "disable") {
					return('<a href="#"  class="text-primary cellStatusBtn">启用</a><a href="#" class="text-primary editorBtn none">编辑</a><a href="#" class="text-primary deleteBtn none">删除</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
		
				} else {
					return('<a href="#" class="text-orange cellStatusBtn">禁用</a><a href="#" class="text-primary editorBtn none">编辑</a><a href="#" class="text-primary deleteBtn none">删除</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
				}
			}
			
	
		}
	}];
	var searchVal = $('.type').val();
	var data;
	if(searchVal==""){
		data=null
	}else{
		data={
			typeId:searchVal
		}
	}
	var tableFilingM = {
		id: "tableFilingM",
		url: allUrl.fileManger,
		searchParams: data,
		columns: columnArrs,
		lengthChange:false,
		scrollX:true,
		columnDefs: columnDefArrs
	
	}
	$.verifyById(userInfoArr.userId);
	var bottomTable = $.createTable(tableFilingM);
	//新增管理员
	$(document).on('click', ".addFilingBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var tit='新建档案管理员'
			$.detailsEditor(tit);

		}
		
	});
	$.department(allUrl.findFileDepartment,"#department");
	$.role(allUrl.findFileRole,"#role");
	/**
	 * 建档管理--搜索
	 */
	$(document).on('click', ".filingSearchBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			filingSeacherFn()
		}
		
	});
	/**
	 * 建档管理--部门/角色
	 */
	$(document).on('change', ".type,#department,#role", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			filingSeacherFn()
		}
		
	});
	/**
	 * 建档管理--禁/启用
	 */
	$(document).on('click', ".cellStatusBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var cellData = bottomTable.row($(this).parents('tr')).data();
			if(cellData.status == "disable") {
				txt = "启用";
			} else {
				txt = "禁用";
			}
			$.enabledOrDisabled(cellData.id, txt, bottomTable);
		}
		
	});
	function filingSeacherFn(){
		searchVal={
    		keyWords:$('.search-input').val(),
    		typeId:$('.type').val(),
    		departmentId:$("#department").val(),
    		roleId:$('#role').val()
    	};
    	for(var key in searchVal){
    		
	        if(searchVal[key]=="" || searchVal[key] == 'all'){
	            delete searchVal[key];
	        }
	    };
    	$.seacherFn(bottomTable,searchVal);
	}
	/**
	 * 建档管理--重置密码
	 */
	$(document).on('click', ".resetPassWordBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var cellData = bottomTable.row($(this).parents('tr')).data();
			if(cellData.status=="启用"||cellData.status=="enable"){
				$.resetPassword(cellData.id)
			}else{
				layer.alert("该账号已禁用，请启用后在操作",{
					skin: 'layui-layer-lan'
				})
			}
		}
	});
	/**
	 * 建档管理--查看
	 */
	var filingDetails;
	$(document).on('click', '.viewBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			/*
		 * 1.获取点击行数据
		 * 2/关闭建档管理页面，打开建档管理详情页面页面
		 * 3、建档管理详情页面赋值，并请求table
		 **/
			var cellData = bottomTable.row($(this).parents('tr')).data();
			if(cellData.status == "disable" || cellData.status == "禁用") {
					layer.alert("该账号已禁用，请启用后在操作", {
						skin: 'layui-layer-lan'
					})
				} else {
			$('.rowData').text(JSON.stringify(cellData));
			var arrys = ["account", "archivesNumber", "status", "name", "phone", "address", "id"]
			$.adminInfoArea(arrys, cellData, ".", ".statusBtn")
			$(".filing-list>a").removeClass('on');
			$(".filing-details>a").addClass('on');
			$('.filing-details,.filing_details').removeClass('none');
			$('.filing_manage').removeClass('block').addClass('none');
			
			var columnArrs = ["sign","id", "createTime", "name", "address", "remark", null];
			var columnDefArrs = [{
				targets: 2,
				orderable: false,
				visible: false
			}, {
				targets: 3,
				orderable: false,
				render: function(data) {
					if(data!=null){
						return (data.split('.')[0]);
					}else{
						return null;
					}
					
				}
			},{
				targets: -1,
				orderable: false,
				render: function(data) {
					if(rloeType =='1'){
						return('<span>/</span>')
					}else{
						if(data.name == null && data.address == null) {
							return('<a href="#" class="text-primary collectionBtn">补录</a><a href="#" class="text-primary deleteBtn">删除</a>')
						} else {
							return null;
						}
					}
					
		
				}
			}];
			searchVal = {
				userId: cellData.id
			}
			var tableFilingd = {
				id: "tableFilingD",
				url: allUrl.findFileByBuildId,
				searchParams: searchVal,
				columns: columnArrs,
				lengthChange:false,
				scrollX:true,
				columnDefs: columnDefArrs
			}
			filingDetails = $.createTable(tableFilingd);
		};}
	});
	/**
	 * 建挡详情--禁、启用
	 */
	$(document).on('click', '.statusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig)
//		if(rloeType==1){
//			layer.alert("您没有禁/启用权限",{
//				skin: 'layui-layer-lan'
//			})
//		}else{
			var txt = $(".status").text();
			var id=$('.id').text();
			var statusTxt;
			if(txt== "disable"||txt== "禁用") {
				statusTxt = "启用";
			} else {
				statusTxt = "禁用";
			}
			var arrs=['.account',".status",'.statusBtn','.tips']
			$.enabledOrDisabled(id, statusTxt, bottomTable,arrs);
//		}
	});
	/**
	 * 建挡详情--地址修改
	 */
	$(document).on('click', '.editorBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var txt=$(".status").text();
			if(txt== "disable"||txt== "禁用") {
				layer.alert("该账号已禁用，请启用后在操作",{
					skin: 'layui-layer-lan'
				})
			}else{
				var tit ='修改档案管理员'
				$.detailsEditor(tit);
			}

		}
		
	});
	/**
	 * 建挡详情--搜索
	 */
	$(document).on('click', '.personnelSearch', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var searchVal;
		
			var val=$(".personnelSearch-input").val();
			if(val==""){
				searchVal={
	    			userId:$(".id").text()
	    		};
			}else{
				searchVal={
	    			sign:val
	    		};
	    		
			}
			$.seacherFn(filingDetails,searchVal);
		}
		
    	
	});

	/**
	 * 建挡详情--补录
	 */
	$(document).on('click', '.collectionBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var txt = $('.status').text();
			if(txt=="禁用"||txt=="disable"){
					layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			}
			var  cellData = filingDetails.row($(this).parents('tr')).data();
			$(".pigId").text(cellData.sign)
			$.pigType(allUrl.findFilepigType,"#pigTypeAdd");
			$('.addInfor,.addfilDetLar').removeClass('none');
			$('.activateIdArea').addClass('none');
			var postRecorded = layer.open({
				type: 1,
				area: ['580px', '490px'],
				scrollbar: false,
				title: ['新增', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content: $('.addfilDetLar'),
				btn: ['保存', '取消'],
				btnAlign: 'c',
				btn1: function(index, layero) {
					var fig = $.verifyById(userInfoArr.userId);
					if(fig){
						saveFn(postRecorded);
					}
					
				},
				btn2: function() {
					var fig = $.verifyById(userInfoArr.userId);
					if(fig){
						formResetFn();
						$('.addInfor,.addfilDetLar').addClass('none');
					}	
				},
				cancel: function(index) {
					var fig = $.verifyById(userInfoArr.userId);
					if(fig){
						formResetFn();
						$('.addInfor,.addfilDetLar').addClass('none');
					}
				}
			})
		}
		
	});
	
	
	//弹框关闭后表单的处理
	function formResetFn() {
		
		var inputs = $('.addInfor').find('input,select');
		$.each(inputs, function(i, inp) {
			$(inp).val(null);
		});
		$("#farmerName,#farmerId,#farmerPhone,#farmerAddress").text(null);
	
	};
	/**
	 * 建挡详情--删除
	 */
	$(document).on('click', ".deleteBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var txt = $('.status').text();
			if(txt=="禁用"||txt=="disable"){
					layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			var cellData = filingDetails.row($(this).parents('tr')).data();
			$.showLayer({
				msg: '是否确认删除这条ID？',
				y: function() {
					$.ajax({
						type: "post",
						async: true, //同步执行
						url: allUrl.findFileDeleteSign,
						data: {
							sign: cellData.sign
						},
						success: function(dataAll) {
							if(dataAll.code == 0) {
								var start = $("#tableFilingD").dataTable().fnSettings()._iDisplayStart;
									var total = $("#tableFilingD").dataTable().fnSettings().fnRecordsDisplay();
									if((total - start) == 1) {
										if(start > 0) {
											filingDetails.fnPageChange('previous', true);
										}
									} else {
										filingDetails.draw(false);
									};
									
									layer.msg('删除成功');
									var len=$("#filingDetails").find('tr').length
									$('.archivesNumber').text(len-1);	
									
									
							} else {
								layer.msg(dataAll.message,{
									skin: 'layui-layer-lan'
								});
							}
						}
					})
				}
			})
		}
	});						
	/**
	 * 建挡详情--新增
	 */
	$(document).on('click', ".addFiling", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var txt = $('.status').text();
			if(txt=="禁用"||txt=="disable"){
					layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			}else{
			$(".activateId").val(null);
			$('.addfilDetLar,.activateIdArea').removeClass('none');
			var addFilingD = layer.open({
				type: 1,
				area: ['580px', '490px'],
				scrollbar: false,
				title: ['新增', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content: $('.addfilDetLar'),
				btn: ['是', '否'],
				btnAlign: 'c',
				btn1: function(index, layero) {
					var fig = $.verifyById(userInfoArr.userId);
					if(fig){
						var txt = $(".layui-layer-btn0").text();
						var id = $(".id").text();
						if(txt == "是") {
							var sign =$.trim($(".activateId").val());
							if(sign==""){
								layer.msg("请输入ID");
								return;
							}
							$.ajax({
								type: "post",
								async: true, //同步执行
								url: allUrl.findFileactiveSign,
								data:{
									sign:sign,
									userId:id
								},
								success: function(dataAll) {
									
									if(dataAll.code==0){
											$(".pigId").text(sign);
											$('.activateIdArea').addClass('none');
											$('.addInfor').removeClass('none');
											$(".layui-layer-btn0").text("保存");
											$(".layui-layer-btn1").text("上一步");
											$.pigType(allUrl.findFilepigType,"#pigTypeAdd");
											var len= $('.archivesNumber').text();
											$('.archivesNumber').text(parseInt(len)+1);	
									}else{
										layer.msg(dataAll.message)
									}
									
								}
							});
						} else {
							saveFn(addFilingD);
						}
					}
				},
				btn2: function(index) {
					var fig = $.verifyById(userInfoArr.userId);
					if(fig){
						var txt = $(".layui-layer-btn1").text();
						if(txt == "否") {
							$(".activateId").val(null);
							$('.addfilDetLar ').addClass('none');
							
						} else {
							$('.activateIdArea').removeClass('none');
							$('.addInfor').addClass('none');
							$(".layui-layer-btn0").text("是");
							$(".layui-layer-btn1").text("否")
							return false;
						}
					}
					
		
				},
				cancel: function(index) {
					
					$(".activateId").val(null);
					$('.addfilDetLar ').addClass('none');
					$('.addInfor').addClass('none');
					filingDetails.ajax.reload();
					formResetFn();
				}
			});
			}
		}
	});
	
	//养殖户搜索
	$(document).on("click",".farmerBtn",function(e){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var farmerName = $.trim($('.famerId').val());
			if(farmerName == "") {
				layer.msg('请输入养殖户');
				return;
			}else{
				var data={
					keyWords: farmerName
				}
				$.farmerSearch(e,allUrl.findFilegetFarms,data)
			}
		}
		
	});
	//养殖户搜索后赋值
	$(document).on('click',".farmerLi",function(){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var me=this;
			var arrays=["farmerId","farmerName","farmerAddress","farmerPhone"];
			$.searchAssignment(me,".farmer",".farmerName",arrays,".farmersList")
		}
		
	});
	function saveFn(postRecorded) {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig)
		var id =$(".id").text();
		var fig=true;
		var famerId=$("#farmerId").text();
		var sign=$(".pigId").text();
		var pigTypeAdd=$("#pigTypeAdd").val();
		if(pigTypeAdd==""){
			layer.msg('请选择生猪类型');
			return false;
		}else if(famerId==""){
			layer.msg('请选择养殖户');
			return false;
		}else{
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.findFileaddSave,
				data: {
					sign:sign,
					pigType:pigTypeAdd,
					famerId:famerId,
					createPeopleId:id
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						layer.msg("保存成功")
						layer.close(postRecorded);
						formResetFn();
						filingDetails.ajax.reload();
						$(".addInfor").addClass('none');
					} else {
						layer.msg(dataAll.message)
					}
				}
			})
		}
		

	};
	//返回上一页
	$(document).on('click','.backUpper-toggle',function(){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			$.verifyById(userInfoArr.userId);
			window.location.href = './filing_manage.html';
		}
		
	});
});
$(window).resize(function(){
//	$.tableScrollFn("#tableFilingM",1100);
//	$.tableScrollFn("#tableFilingD",800)
});