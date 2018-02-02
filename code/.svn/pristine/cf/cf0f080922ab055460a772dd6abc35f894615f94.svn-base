/**
 * Created by dev on 2017/11/01.
 *
 *
 * 模块：屠宰管理
 */

$(document).ready(function() {
	var me = this;
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	$.login();
	var rloeType = $.isRloe('屠宰场管理');
	var classNameArr = ['.butcherAdd', '.butcherStatusBtn']
	if(rloeType == '0') {
		$.hiddenOperateBtn(classNameArr)
	}
	/*
	 * 判断登录账号是普通用户还是管理员
	 * roleCode=1或null为普通用户，
	 * roleCode=bmadmin为管理员，如果是管理员
	 * 1.判断是否有未新建过屠宰场，已建怎隐藏新增屠宰场按钮，反之则显示新增屠宰场按钮；
	 * 2.页面按正常流程屠宰管理显示，反之则从生猪列表开始显示，状态不可 更改；
	 */
	var butcherCode, tableButcher, searchvalue = null;
	var putongAccountFlag = false;
	if(userInfoArr.roleCode == null || userInfoArr.roleCode == 1) { //普通屠宰用户
		putongAccountFlag = true;
		$.pigType(allUrl.findFilepigType, "#butcher-type"); //加载所有类型
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.butcherUserDtail,
			data: {
				id: userInfoArr.userId
			},
			success: function(dataAll) {
				var data = dataAll.data;
//				$('.butcher').removeClass('on');
//				$('.detailsArea').addClass('on');
				
//				$('.details,.butcher_details').removeClass('none');
				$(".main-content").load('./pigList.html');
//				
				data.number = data.count;
				data.userId = userInfoArr.userId;
				data.role='normalUser';
//				$("#butcher_personnel_id").text(data.slaughterhouseId);
				for(var key in data) {
					if(data[key] == null) {
						delete data[key]
					}
				};
				sessionStorage.pigList = JSON.stringify(data);
//				$('#butcher_details_rowData').text(JSON.stringify(data));
//				var arrys = ["account", "userId", "status", "number", "userName", "principal", "phone", "address", "districtId"];
//				$.adminInfoArea(arrys, data, "#butcher_details_", ".statusBtn")
//				pigListTableLoade(userInfoArr.userId);
//				butcherCode = 1;
//				$.pigType(allUrl.findFilepigType, "#butcher-type");
			}
		});
	} else if(userInfoArr.roleCode === "bmadmin") { //管理员屠宰用户
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.butcherUserExist,
			data: {
				userId: userInfoArr.userId
			},
			success: function(dataAll) {
				if(dataAll.code == 800) {
					$('.butcherAdd').addClass('none');
				}
			}
		});
		searchvalue = {
			userId: userInfoArr.userId
		}

	}
	var columnArrs = ["id", "status", "name", "number", "principalName", "phone", "address", "creatorName", "creatorTime", null];
	var columnDefArrs = [{
		targets: 1,
		orderable: false,
		visible: false
	}, {
		targets: 2,
		orderable: false,
		visible: false
	}, {
		targets: 3,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 4,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 5,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 6,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 7,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 8,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: 9,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: -1,
		orderable: false,
		render: function(data) {
			/*
			 * rloeType=1,只能查看，rloeType=0，可操作
			 */
			if(rloeType == 1) {
				return('<a href="#" class="text-primary personnelBtn">查看</a><a href="#" class="text-primary enteringDataBtn">出入库数据</a>')
			} else {
				if(data.status == "disable") {
					return('<a href="#" class="text-primary filingStatusBtn">启用</a><a href="#" class="text-primary enteringDataBtn">出入库数据</a><a href="#" class="text-primary personnelBtn">查看</a>')
				} else {
					return('<a href="#" class="text-orange filingStatusBtn">禁用</a><a href="#" class="text-primary enteringDataBtn">出入库数据</a><a href="#" class="text-primary personnelBtn">查看</a>')
				}
			}
		}
	}];
	var tableButcherM = {
		id: "tableButcherM",
		url: allUrl.butcherManger,
		searchParams: searchvalue,
		columns: columnArrs,
		lengthChange: false,
		scrollX: true,
		columnDefs: columnDefArrs
	}
	tableButcher = $.createTable(tableButcherM);
	$.verifyById(userInfoArr.userId);
	//新增管理员
	$(document).on('click', ".butcherAdd", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var tit = '新增屠宰场'
			var heigth = ['1068px', '540px'];
			$.detailsEditor(tit,heigth);
		}
	});

	/**
	 * 屠宰场管理-搜索
	 * 
	 */
	$(document).on('click', '.butccherdSearch', function() {

		var fig = $.verifyById(userInfoArr.userId);
		
		if(fig) {
			var keyVal = $.trim($('#searchVal').val());
			var searchVal;
			if(userInfoArr.roleCode ==='jkadmin'||userInfoArr.roleCode ==='admin'){
				 searchVal= {
					key: keyVal
				};
			}else{
				 searchVal= {
				key: keyVal,
				userId: userInfoArr.userId
			};
			}
			
			for(var key in searchVal) {
				if(searchVal[key] == "" || searchVal[key] == null) {
					delete searchVal[key]
				}
			}

			$.seacherFn(tableButcher, searchVal);
		}
	});
	/**
	 * 屠宰场管理-禁/启用
	 */
	$(document).on('click', '.filingStatusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var me = this;
			var cellData = tableButcher.row($(this).parents('tr')).data();
			$.detailsStatus(me, cellData.status, cellData.id, "", "", tableButcher, 1)
		}
	});
	/**
	 * 屠宰场管理-查看
	 */

	var personnelTable = "";
	//	var curButcherId;
	function getCurButcherId() {
		return curButcherId;
	}
	$(document).on('click', '.personnelBtn', function() {
		/*
		 * 1.获取点击行数据
		 * 2屠宰管理管页面，打开屠宰场人员页面
		 * 3、屠宰场人员户页面赋值，并请求table
		 **/
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = tableButcher.row($(this).parents('tr')).data();
			var curButcherId = cellData.id;
			sessionStorage.curButcherId = curButcherId;
			if(cellData.status == "禁用" || cellData.status == "disable") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.butcherPersonDetails,
				data: {
					id: cellData.id
				},
				success: function(dataAll) {
//					var arrys = ["name", "id", "status", "number", "name", "principalName", "phone", "address"];
//					$('.rowData').text(JSON.stringify(dataAll.data));
//					
//					$.adminInfoArea(arrys, dataAll.data, "#butcher_personnel_", ".butcherStatusBtn");
					sessionStorage.butcherPerson = JSON.stringify(dataAll.data);
//					window.location.href=('./butcherPerson.html');
					$('.main-content').load('./butcherPerson.html');
				}
			});
//			var columnArrs = ["userId", "status", "account", "userName", "phone", "address", "number", "createTime", null];
//			var columnDefArrs = [{
//				targets: 1,
//				orderable: false,
//				visible: false
//			}, {
//				targets: 2,
//				orderable: false,
//				visible: false
//			}, {
//				targets: 3,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: 4,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: 5,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: 6,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: 7,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: 8,
//				orderable: false,
//				render: function(data, i, k) {
//					return $.renderTable(data, k);
//				}
//			}, {
//				targets: -1,
//				orderable: false,
//				render: function(data) {
//					if(rloeType == '1') {
//						return('<a href="#" class="text-primary viewBtn">查看</a>')
//					} else {
//						if(data.status == "disable") {
//							return('<a href="#" class="text-primary personnelStatusBtn">启用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
//
//						} else {
//							return('<a href="#" class="text-orange personnelStatusBtn">禁用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
//						}
//					}
//
//				}
//			}];
//			var searchVal = {
//				id: cellData.id
//			};
//			var personnelTableM = {
//				id: "personnelTable",
//				url: allUrl.butcherPersonnel,
//				searchParams: searchVal,
//				columns: columnArrs,
//				lengthChange: false,
//				scrollX: true,
//				columnDefs: columnDefArrs
//
//			}
//			personnelTable = $.createTable(personnelTableM);
		}
	});
//	/**
//	 * 屠宰场人员table-状态
//	 */
//	$(document).on('click', '.personnelStatusBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var txt = $('#butcher_personnel_status').text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该屠宰场已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				});
//				return false;
//			};
//			var cellData = personnelTable.row($(this).parents('tr')).data();
//			if(cellData.status == "disable") {
//				txt = "启用";
//			} else {
//				txt = "禁用";
//			}
//			$.enabledOrDisabled(cellData.userId, txt, personnelTable);
//
//		}
//	});
//	/**
//	 * 屠宰场人员table-重置密码
//	 */
//	$(document).on('click', '.resetPassWordBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var cellData = personnelTable.row($(this).parents('tr')).data();
//			var txt = $("#butcher_personnel_status").text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该屠宰场已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				})
//			} else {
//				if(cellData.status == "disable" || cellData.status == "禁用") {
//					layer.alert("该人员已禁用，请启用后在操作", {
//						skin: 'layui-layer-lan'
//					});
//					return false;
//				}
//				$.resetPassword(cellData.userId);
//			}
//		}
//	});
//	/**
//	 * 屠宰场人员-状态
//	 */
//	$(document).on('click', '.butcherStatusBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var me = this;
//			$.detailsStatus(me, "#butcher_personnel_status", "#butcher_personnel_id", "#butcher_personnel_name", ".personnelTips", tableButcher)
//
//		}
//	});

//	/**
//	 * 屠宰场人员-新增
//	 */
//	$(document).on('click', '.personnelAdd', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var txt = $("#butcher_personnel_status").text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该屠宰场已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				})
//			} else {
//				var tit = '新增屠宰场人员'
//				$.detailsEditor(tit);
//			}
//		}
//	});
//	/**
//	 * 屠宰场人员-搜索
//	 */
//	$(document).on('click', '.personnelSearch', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var keyVal = $.trim($('#personnelSearchVal').val());
//			var searchVal;
//			if(keyVal == "") {
//				var searchVal = {
//					id: $('#butcher_personnel_id').text()
//				}
//			} else {
//				var searchVal = {
//					key: keyVal,
//					id: $('#butcher_personnel_id').text()
//				};
//
//			}
//
//			$.seacherFn(personnelTable, searchVal);
//		}
//	});

//	/**
//	 * 生猪列表--新增
//	 */
//	$(document).on('click', '.butcherDetailAdd', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var statusTxt = $('#butcher_details_status').text();
//			if(statusTxt == "禁用" || statusTxt == "disable") {
//				layer.alert("该人员已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				});
//				return false;
//			};
//			$('.addPIgLayer').removeClass('none');
//			var addPIg = layer.open({
//				type: 1,
//				area: ['580px', '300px'],
//				title: ['新增生猪', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
//				content: $('.addPIgLayer'),
//				btn: ['是', '否'],
//				btnAlign: 'c',
//				btn1: function(index, layero) {
//					var fig = $.verifyById(userInfoArr.userId);
//					if(fig) {
//						var txt = $(".layui-layer-btn0").text();
//						if(txt == "是") {
//							var id = $.trim($(".addPig").val());
//							var slaughterhouseId = $('#butcher_personnel_id').text() //屠宰场ID
//							var userId = $('#butcher_details_userId').text() //用户id
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
//										slaughterhouseId: slaughterhouseId,
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
	 * 屠宰场人员--状态
	 */
	$(document).on('click', '.personnelStatus', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var me = this;
			$.detailsStatus(me, "#butcher_personnel_status", '#butcher_personnel_account', '.personnelTips')
		}
	});
	/**
	 * 屠宰场人员--查看
	 */
//	var butcherBetails;
//	$(document).on('click', ".viewBtn", function() {
//		/*
//		 * 1.获取点击行数据
//		 * 2隐藏养殖管页面，打开养殖页面
//		 * 3、养殖户页面赋值，并请求table
//		 **/
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var txt = $('#butcher_personnel_status').text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该屠宰场已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				});
//				return false;
//			};
//			$(".personnelArea").removeClass('on');
//			$(".detailsArea").addClass('on');
//			var arrys = ["account", "userId", "status", "number", "userName", "principal", "phone", "address", "districtId", ];
//			var cellData = personnelTable.row($(this).parents('tr')).data();
//			if(cellData.status == "disable" || cellData.status == "禁用") {
//				layer.alert("该人员已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				});
//				return false;
//			}
//			$('#butcher_details_rowData').text(JSON.stringify(cellData));
//			$.adminInfoArea(arrys, cellData, "#butcher_details_", ".statusBtn")
//			$('.butcher_details,.details').removeClass('none');
//			$('.butcher_manage,.personnel_manage').addClass('none');
//			var userId = $('#butcher_details_userId').text()
//			pigListTableLoade(userId);
//			$.pigType(allUrl.findFilepigType, "#butcher-type");
//			$("#butcher-status option[value=''] ").prop("selected", true);
//		}
//	});

//	function pigListTableLoade(userId) {
//		/*
//		 * 生猪列表--table
//		 * 
//		 * */
//		var columnArrs = ["id", "pigId", "pigBreed", "status", null];
//		var columnDefArrs = [{
//			targets: 1,
//			orderable: false,
//			visible: false
//		}, {
//			targets: 4,
//			orderable: false,
//			render: function(data) {
//				if(data == 0) {
//					return '<p>正常</p>'
//				} else if(data == 1) {
//					return '<p>死亡</p>'
//				} else if(data == 2) {
//					return '<p>宰前待检验</p>'
//				} else if(data == 3) {
//					return '<p>待屠宰</p>'
//				} else if(data == 4) {
//					return '<p>宰后待检验</p>'
//				} else if(data == 5) {
//					return '<p>待销售 </p>'
//				} else if(data == 6) {
//					return '<p>已处理 </p>'
//				} else if(data == 7) {
//					return '<p>已销售 </p>'
//				} else {
//					return null;
//				}
//			}
//		}, {
//			targets: -1,
//			orderable: false,
//			render: function(data) {
//				if(rloeType == '1') {
//					return('<a href="#" class="text-primary lookBtn">查看详情</a>')
//				} else {
//					if(data.status == 0) {
//						return('<a class="text-gary">待检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
//					} else if(data.status == 1) {
//						return('<a class="text-gary">待检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
//					} else if(data.status == 2) {
//						return('<a href="#" class="text-primary butcherBeforBtn">宰前检验</a><a href="#" class="text-primary lookBtn">查看详情</a>');
//					} else if(data.status == 3) {
//						return('<a  class="text-primary butcherBtn">屠宰</a><a href="#" class="text-primary lookBtn">查看详情</a>');
//					} else if(data.status == 4) {
//						return('<a href="#" class="text-primary butcherAfterBtn">宰后检验</a><a href="#" class="text-primary lookBtn">查看详情</a>')
//					} else if(data.status == 5) {
//						return('<a href="#" class="text-primary butcherBtn">销售录入</a><a href="#" class="text-primary lookBtn">查看详情</a>')
//					} else if(data.status == 6) {
//						return('<a href="#" class="text-primary lookBtn">查看详情</a>')
//					} else if(data.status == 7) {
//						return('<a href="#" class="text-primary lookBtn">查看详情</a>')
//					} else {
//						return null;
//					}
//				}
//
//			}
//		}];
//		var butcherBetailsTable = {
//			id: "butcherBetailsTable",
//			url: allUrl.butcherPersonnelPigList,
//			searchParams: {
//				id: $('#butcher_details_userId').text()
//			},
//			columns: columnArrs,
//			lengthChange: false,
//			scrollX: true,
//			columnDefs: columnDefArrs
//
//		}
//		butcherBetails = $.createTable(butcherBetailsTable);
//
//	}
//	/**
//	 * 生猪列表--搜索
//	 */
//	$(document).on('click', '.butcherDetailSearch', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			pigDetailSearch()
//		}
//	});
//	$(document).on('change', '#butcher-status,#butcher-type', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			pigDetailSearch()
//		}
//	});
//
//	function pigDetailSearch() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var keyVal = $.trim($('#butcherDetailVal').val());
//			var searchVal = {
//				pigId: keyVal,
//				id: $('#butcher_details_userId').text(),
//				pigStatus: $('#butcher-status').val(),
//				pigBreed: $('#butcher-type').val(),
//			}
//			for(var key in searchVal) {
//				if(searchVal[key] === "") {
//					delete searchVal[key];
//				}
//			}
//
//			$.seacherFn(butcherBetails, searchVal);
//		}
//	};
//	/*
//	 * 生猪列表--地址修改
//	 * */
//	$(document).on('click', '.personnelEditorBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var txt = $('#butcher_personnel_status').text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该屠宰场已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				})
//			} else {
//				var tit = '修改屠宰场';
//				var heigth = ['1068px','540px'];
//				$.detailsEditor(tit, heigth);
//			}
//
//		}
//	});
//	$(document).on('click', '.editorBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var txt = $('#butcher_details_status').text();
//			if(txt == "disable" || txt == "禁用") {
//				layer.alert("该人员已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				})
//			} else {
//				var tit = '修改屠宰场人员';
//				$.detailsEditor(tit);
//			}
//		}
//	});
//	/*
//	 * 生猪列表--禁、启用
//	 */
//	$(document).on('click', '.statusBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var txt = $("#butcher_details_status").text();
//			var id = $('#butcher_details_userId').text();
//			var statusTxt;
//			if(txt == "disable" || txt == "禁用") {
//				statusTxt = "启用";
//			} else {
//				statusTxt = "禁用";
//			}
//			var arrs = ['#butcher_details_account', "#butcher_details_status", '.statusBtn', '.tips']
//			$.enabledOrDisabled(id, statusTxt, tableButcher, arrs);
//
//		}
//	});
//	/*
//	 * 生猪列表--宰前待检验
//	 */
//	$(document).on('click', '.butcherBeforBtn', function() {
//		var tit='宰前检查报告';
//		var checkType=2;
//		
//		butcherReportFn(tit,checkType,this)//屠宰报告
//		
//		//		alert('宰前待检验')
//	});
//	/*
//	 * 生猪列表--宰后待检验
//	 */
//	$(document).on('click', '.butcherAfterBtn', function() {
//		var tit='宰后检查报告';
//		var checkType=3;
//		
//		butcherReportFn(tit,checkType,this)//屠宰报告
//	});
//	/**
//	 * 
//	 * @param {Object} tit 弹框title
//	 * @param {Object} url 新增报告路径
//	 * @param {Object} ele 事件对象
//	 */
//	function butcherReportFn(tit,checkType,ele){
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var cellData = butcherBetails.row($(ele).parents('tr')).data();
//			$.inspectorList(allUrl.butcherInspectorList,'#butcherInspectorList');
//			$('input[name=quarantineResult]').get(0).checked = true;
//			var butcherBeforReport = layer.open({
//				type: 1,
//				id: 'butcherBeforReport',
//				area: ['480px', '500px'],
//				scrollbar: false,
//				title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
//				content: $('.reportInputLayer'),
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
//			});
//			//			$('reportInputLayer').removeClass('none')
//		}
//	};
//	
//	function confirmFn(checkType,cellData){
//		var data = {};
//     	var formVal = $('#reportInputFrom').serializeArray();
//     	$.each(formVal, function() {
//     		data[this.name] = this.value;
//     	});
//     	data.pigId=cellData.pigId;
//     	data.type=0;
//     	data.checkType=checkType;
//     	for(var key in data){
//	       	if(data[key]===null||data[key]===""){
//	       		delete data[key]
//	       	}
//	    };
//	    if(!data.userId){
//	    	layer.msg('请选择检验人员');
//	    	return false;
//	    }
//	    	
//	    	$.ajax({
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
//	function formReset(){
//		$('input[name=quarantineResult]').get(0).checked = true;
//		var quarantineResultVal= $("input[name=quarantineResult]:checked").val();
//		$('.isDispose').addClass('none');
//		$('input[name=isDispose]').get(0).checked = false;
//		$('input[name=isDispose]').get(1).checked = false;
//		$('.describe').val("");
//		$('.remark').val("");
//		$($('.quarantineChecked')[0]).attr("src",'../src/images/public/choise3.png');
//		$($('.quarantineChecked')[1]).attr("src",'../src/images/public/choise2.png');
//		$($('.isDisposeChecked')[0]).attr("src",'../src/images/public/choise3.png');
//		$($('.isDisposeChecked')[1]).attr("src",'../src/images/public/choise2.png');
////		if(quarantineResultVal==1){
////			
////		}
//	};
//	/*
//	 * 检验结果
//	 */
//	$(document).on('click', '.quarantineChecked', function() {
//		radioCheckedFn(this,'quarantineResult');
//	});
//	/*
//	 * 处理方式
//	 */
//	$(document).on('click', '.isDisposeChecked', function() {
//		radioCheckedFn(this,'isDispose');
//	});
//	function radioCheckedFn(ele,check){
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig){
//			var imgUrl = $(ele).attr("src");
//			var ipt = $(ele).parent().find('input');
//			var names = $(ipt).attr('name');
//			var ipts = $('input[name=' + names + ']');
//			var pImg,checkVal;
//			for(var i = 0; i < ipts.length; i++) {
//				pImg = $(ipts[i]).prev().prev();
//				if($(pImg).attr("src") != imgUrl) {
//					$(pImg).attr("src", '../src/images/public/choise2.png');
//				}
//			}
//			if(imgUrl == '../src/images/public/choise2.png') {
//				$(ele).attr("src", '../src/images/public/choise3.png');
//				$(ipt).prop("checked", true);
//				if(check=='quarantineResult'){
//					checkVal= $("input[name="+check+"]:checked").val();
//				};
//			} else if(imgUrl == '../src/images/public/choise3.png') {
//				$(ele).attr("src", '../src/images/public/choise3.png');
//				$(ipt).prop("checked", true);
//				if(check=='quarantineResult'){
//					checkVal= $("input[name="+check+"]:checked").val();
//				};
//			} else {
//				$(ele).attr("src", '../src/images/public/choise2.png');
//				$(ipt).prop("checked", false);
//				if(check=='quarantineResult'){
//					checkValVal= $("input[name="+check+"]:checked").val();
//				};
//			}
//			if(checkVal==0){
//				$('.isDispose').removeClass('none');
//				$('input[name=isDispose]').get(0).checked = true;
//			}else if(checkVal==1){
//				$('.isDispose').addClass('none');
//				$('input[name=isDispose]').get(0).checked = false;
//				$('input[name=isDispose]').get(1).checked = false;
//			}
//		}
//	}
//	/*
//	 * 生猪列表--待屠宰/待录入
//	 */
//	$(document).on('click', '.butcherBtn', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//
//			var statusTxt = $('#butcher_details_status').text();
//			if(statusTxt == "禁用" || statusTxt == "disable") {
//				layer.alert("该人员已禁用，请启用后在操作", {
//					skin: 'layui-layer-lan'
//				});
//				return false;
//			};
//			var txt = $(this).text();
//			var cellData = butcherBetails.row($(this).parents('tr')).data();
//			$(".slaughteredId,.pigId").text(cellData.pigId);
//			$(".salesId").text(cellData.pigId + "销售信息？");
//			if(txt == "屠宰") {
//				var slaughterhouseId = $('#butcher_personnel_id').text();
//				var tit = "屠宰";
//				var urls = allUrl.butcherSlaughterPig;
//				var data = {
//					id: cellData.id,
//					slaughterhouseId: slaughterhouseId
//				}
//				var fig = $.verifyById(userInfoArr.userId);
//				if(fig) {
//					butcherDateilsFn(tit, urls, data, cellData.pigId, "slaughteredLayer");
//				}
//			} else {
//				var fig = $.verifyById(userInfoArr.userId);
//				if(fig) {
//					var tit = "销售录入";
//					var urls = allUrl.marketAddPigMsg;
//					butcherDateilsFn(tit, urls, "", cellData.pigId, "salesLayer");
//				}
//			}
//
//		}
//	});
//
//	function butcherDateilsFn(tit, urls, data, pigId, ele) {
//		var slaughtered = layer.open({
//			type: 1,
//			area: ['580px', '490px'],
//			btn: ['是', '否'],
//			title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
//			content: $('.' + ele),
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
//
//	function formResetFn() {
//		$(".suttle,.farmer,#farmerName,#farmerPhone,#farmerAddress").val(null);
//		$("#salePigType  option[value='001']").prop("selected", true)
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
//	//保存
//	function saveFn(urls, slaughtered) {
//		var data = {
//			userId: $("#marketId").val(),
//			marketId: $("#farmerId").text(),
//			pigId: $('.pigId').val(),
//			weight: $('.suttle').val()
//		};
//		if(data.userId == "") {
//			layer.msg("请选择市场人员");
//		} else if(data.weight == "") {
//			layer.msg("请输入净重");
//		} else if(data.marketId == "") {
//			layer.msg("请选择市场");
//		} else {
//			$.ajax({
//				type: "post",
//				async: true, //同步执行
//				url: urls,
//				data: data,
//				success: function(allData) {
//					if(allData.code == 0) {
//						layer.close(slaughtered);
//						layer.msg("销售录入成功");
//						butcherBetails.ajax.reload();
//						formResetFn();
//					} else {
//						layer.msg(allData.message);
//
//					}
//				}
//			})
//		}
//
//	};
	//养殖场管理详情查看 
//	var pigListTable = "";
//	$(document).on('click', ".lookBtn", function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			var cellData = butcherBetails.row($(this).parents('tr')).data();
//			var blockArry = [".pig_list", ".pig"];
//			pigListTable = $.pigDetilas(blockArry, cellData, ".butcher_details", ".detailsArea", ".pigArea");
//		}
//	});
	//生猪列表
//	$(document).on('click', '.detailsArea', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			$(".pig_list,.pig").addClass('none');
//			$(".butcher_details,.details").removeClass('none');
//			$("#butcherDetailVal").val();
//			$("#butcher-type option[value=''] ").prop("selected", true);
//			$("#butcher-status option[value=''] ").prop("selected", true);
//			var searchVal = {
//				id: $('#butcher_details_userId').text()
//			};
//			$.seacherFn(butcherBetails, searchVal);
//			$(".pigArea").removeClass('on');
//			$(".detailsArea").addClass('on');
//		}
//	});
//	//屠宰场人员
//	$(document).on('click', '.personnelArea', function() {
//		var fig = $.verifyById(userInfoArr.userId);
//		if(fig) {
//			$(".personnel_manage").removeClass('none');
//			$(".details,.pig,.butcher_details,.pig_list").addClass('none');
//			$(".pigArea,.detailsArea").removeClass('on');
//			$(".personnelArea").addClass('on');
//		}
//	});
//	//返回上一页
	$(document).on('click', '.backUpper-toggle', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			//如果是普通用户，则点击上一页无效。否则返回上一页
			var onTxt = $('.locationNav .on').text();
			if(putongAccountFlag && onTxt == '生猪列表') {
				return false
			}else if(putongAccountFlag && onTxt == '生猪详情') {
				$('.main-content').load('./pigList.html')
			}else {
				if(onTxt == '生猪列表'){
					$('.main-content').load('./butcherPerson.html')
				}else if(onTxt == '屠宰场人员'||onTxt=='屠宰场出入库数据'){
					window.location.href = './butcher_manage.html';
				}else if(onTxt == '生猪详情'){
					$('.main-content').load('./pigList.html')
				}
				
			}

		}
	});
	
	/*
	 * 点击查看视频
	 * 只能在IE浏览器使用
	 */
	$(document).on('click', '.camera', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var txt = $("#butcher_personnel_status").text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
				return
			}
			var video = layer.open({
				type: 2,
				area: ['1000px', '700px'],
				scrollbar: false,
				title: ["屠宰场监控视频", 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content: '../butcher_manage/video.html',
				btnAlign: 'c'
			});
			//			window.location.href = "http://hik.testzhumengapp.com/openapi/demo/spv/spv.html";
			//			if(window.ActiveXObject || "ActiveXObject" in window) {
			//				window.location.href = "http://hik.testzhumengapp.com/openapi/demo/spv/spv.html";
			//			} else {
			//				var txt = $("#butcher_personnel_status").text();
			//				if(txt == "disable" || txt == "禁用") {
			//					layer.alert("该屠宰场已禁用，请启用后在操作", {
			//						skin: 'layui-layer-lan'
			//					})
			//				} else {
			//					layer.alert("请您在IE浏览器中打开监控视频！",{
			//						skin: 'layui-layer-lan'
			//					})
			//				}
			//			}
		}

	})
	//出入库页面
	$(document).on('click','.enteringDataBtn',function(){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = tableButcher.row($(this).parents('tr')).data();
			if(cellData.status=="disable"||cellData.status=='禁用'){
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return ;
			}
			curButcherId = cellData.id;
			$.ajaxSetup ({ cache: false });
			$.ajax({cache: false})
			$(".main-content").load('./entryOutData.html');
		}
	});
	
});

var curButcherId;  //当前屠宰场的id(供屠宰场出入库数据使用)
