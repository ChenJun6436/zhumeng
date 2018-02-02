/**
 * Created by dev on 2017/11/01.
 *
 *
 * 模块：屠宰管理-屠宰厂人员
 */

$(document).ready(function() {
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var fig = $.verifyById(userInfoArr.userId);
	var rloeType = $.isRloe('屠宰场管理');
	var classNameArr = ['.butcherStatusBtn', '.personnelEditorBtn','.personnelAdd']
	if(rloeType == '0') {
			$.hiddenOperateBtn(classNameArr)
		}
		if(fig) {
			var arrys = ["name", "id", "status", "number", "name", "principalName", "phone", "address"];
			var butcherPerson =JSON.parse(sessionStorage.getItem('butcherPerson'));
			$('.rowData').text(JSON.stringify(butcherPerson));
			$.adminInfoArea(arrys, butcherPerson, "#butcher_personnel_", ".butcherStatusBtn");
		}
		
	/**
	 * 屠宰场人员-状态
	 */
	$(document).on('click', '.butcherStatusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var me = this;
			$.detailsStatus(me, "#butcher_personnel_status", "#butcher_personnel_id", "#butcher_personnel_name", ".personnelTips")

		}
	});
	var columnArrs = ["userId", "status", "account", "userName", "phone", "address", "number", "createTime", null];
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
				targets: -1,
				orderable: false,
				render: function(data) {
					if(rloeType == '1') {
						return('<a href="#" class="text-primary viewBtn">查看</a>')
					} else {
						if(data.status == "disable") {
							return('<a href="#" class="text-primary personnelStatusBtn">启用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')

						} else {
							return('<a href="#" class="text-orange personnelStatusBtn">禁用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
						}
					}

				}
			}];
			var searchVal = {
				id: butcherPerson.id
			};
			var personnelTableM = {
				id: "personnelTable",
				url: allUrl.butcherPersonnel,
				searchParams: searchVal,
				columns: columnArrs,
				lengthChange: false,
				scrollX: true,
				columnDefs: columnDefArrs

			};
		var personnelTable = $.createTable(personnelTableM);
		/**
	 * 屠宰场人员table-状态
	 */
	$(document).on('click', '.personnelStatusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $('#butcher_personnel_status').text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			var cellData = personnelTable.row($(this).parents('tr')).data();
			if(cellData.status == "disable") {
				txt = "启用";
			} else {
				txt = "禁用";
			}
			$.enabledOrDisabled(cellData.userId, txt, personnelTable);

		}
	});
	/**
	 * 屠宰场人员table-重置密码
	 */
	$(document).on('click', '.resetPassWordBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var cellData = $('#personnelTable').DataTable().row($(this).parents('tr')).data();
			var txt = $("#butcher_personnel_status").text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			} else {
				if(cellData.status == "disable" || cellData.status == "禁用") {
					layer.alert("该人员已禁用，请启用后在操作", {
						skin: 'layui-layer-lan'
					});
					return false;
				}
				$.resetPassword(cellData.userId);
			}
		}
	});
	/**
	 * 屠宰场人员--查看
	 */
	$(document).on('click', ".viewBtn", function() {
		/*
		 * 1.获取点击行数据
		 * 2隐藏养殖管页面，打开养殖页面
		 * 3、养殖户页面赋值，并请求table
		 **/
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var txt = $('#butcher_personnel_status').text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
//			$(".personnelArea").removeClass('on');
//			$(".detailsArea").addClass('on');
			var arrys = ["account", "userId", "status", "number", "userName", "principal", "phone", "address", "districtId", ];
//			var cellData = personnelTable.row($(this).parents('tr')).data();
			var cellData = $("#personnelTable").DataTable().row($(this).parents('tr')).data();
			if(cellData.status == "disable" || cellData.status == "禁用") {
				layer.alert("该人员已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			cellData.slaughterhouseId=$('#butcher_personnel_id').text();
			cellData.slaughterhouseName=$('#butcher_personnel_name').text();
			sessionStorage.pigList = JSON.stringify(cellData);
//			window.location.href=('./pigList.html');
			$(".main-content").load('./pigList.html');
		}
	});
	/**
	 * 屠宰场人员-搜索
	 */
	$(document).on('click', '.personnelSearch', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var keyVal = $.trim($('#personnelSearchVal').val());
			var searchVal;
			if(keyVal == "") {
				var searchVal = {
					id: $('#butcher_personnel_id').text()
				}
			} else {
				var searchVal = {
					key: keyVal,
					id: $('#butcher_personnel_id').text()
				};

			}

			$.seacherFn(personnelTable, searchVal);
		}
	});
	/*
	 * 生猪列表--地址修改
	 * */
	$(document).on('click', '.personnelEditorBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $('#butcher_personnel_status').text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			} else {
				var tit = '修改屠宰场';
				var heigth = ['1068px','540px'];
				$.detailsEditor(tit, heigth);
			}

		}
	});
	/**
	 * 屠宰场人员-新增
	 */
	$(document).on('click', '.personnelAdd', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $("#butcher_personnel_status").text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该屠宰场已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			} else {
				var tit = '新增屠宰场人员'
				$.detailsEditor(tit);
			}
		};
	});
});
