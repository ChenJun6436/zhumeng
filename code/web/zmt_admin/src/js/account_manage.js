var treeAll;
$(function() {
	$.login("#shaixuanSel");
	//获取当前用户的登录信息
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var curQuanxian = $.isRloe("账号管理");
	//只有查看权限的时候隐藏新增账号按钮
	var classNameArry = ['.newAddTestPeople'];
	if(curQuanxian =='0'){
		$.hiddenOperateBtn(classNameArry);
	}
	//请求table数据
	var searchValue = {
		typeId: userInfoArr.typeId,
		timestamp: 1508998573824,
		token: 'b01ad47000d0b2b719fe390ae15e8612'
	};
	var testCenterSetting = {
		id: "testCenterTable",
		url: allUrl.accountManageListAll,
		searchParams: searchValue,
		lengthChange: false,
		scrollX:true,
		columns: ["status", "account", "name", "phone", "departmentName", "roleName", "creator", "createTime", null],
		columnDefs: [{
			"targets": 1,
			"render": function(data, type, row, meta) {
				var textState = data == 'enable' ? '启用' : '禁用';
				var curSpan = '';
				if(data == "disable") {
					curSpan = '<span class="text-gary">' + textState + '</span>'
				} else {
					curSpan = '<span">' + textState + '</span>'
				}
				return curSpan;
			}
		}, {
			"targets": 2,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 3,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 4,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 5,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 6,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 7,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": 8,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
			}
		}, {
			"targets": -1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				var textState = data.status == 'enable' ? '禁用' : '启用';
				var className = data.status == 'enable' ? "talbeDisabled" : "tableOperate";
				if(curQuanxian !='1'){
					return('<a onclick="" class="isDisabled + ' + className + '">' + textState + '</a> <a class="edit">编辑</a> <a class="del">删除</a>  <a class="resetPass">重置密码</a> ')
				}else{
					return('<a>/</a>')
				}
				
			}
		}],
	}
	var testCenterTable = $.createTable(testCenterSetting); //调用创建table的方法

	//点击搜索按钮进行搜索
	$(document).on('click', '.searchBtn', function() {
		accountManTableSearch();
	})

	//部门选择框下拉选择
	$(document).on('change', '#accountManHeadBumen', function() {
		accountManTableSearch();
	})

	//角色选择框下拉选择
	$(document).on('change', '#accountManHeadRole', function() {
		accountManTableSearch();
	})

	//按条件搜索（table）
	function accountManTableSearch() {
		var typeId = $('#shaixuanSel').val(); //类型的id
		var departmentId = $('#accountManHeadBumen').val(); //头部部门的id
		var roleId = $('#accountManHeadRole').val(); //头部角色的id
		var keywords = $('.inputBox').val();
		searchValue = {
			keywords: keywords
		}
		if(departmentId != "all") {
			searchValue.departmentId = departmentId
		}
		if(roleId != "all") {
			searchValue.roleId = roleId
		}
		if(typeId != "all") {
			searchValue.typeId = typeId
		}
		testCenterTable.settings()[0].ajax.data = searchValue;
		testCenterTable.ajax.reload();

	}

	//table的禁用启用
	$(document).on('click', '.isDisabled', function() {
		var curData = testCenterTable.row($(this).parents('tr')).data();
		var textState = curData.status == 'disable' ? '启用' : '禁用';
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要' + textState + '？',
			btnAlign: 'c',
			yes: function() {
				$.ajax({
					url: allUrl.accManIsDisabled,
					type: "post",
					data: {
						user_id: curData.id,
						timestamp: 1508998573824,
						token: 'b01ad47000d0b2b719fe390ae15e8612'
					},
					success: function(data) {
						if(data.code == '0') {
							if(textState == '禁用' && userInfoArr.userId == curData.id) {
								layer.alert('该账号已被禁用成功，点击确认后即将返回登录页面！', {
									closeBtn: 0
								}, function() {
									sessionStorage.removeItem('userInfo');
									window.location.href = '../login/login.html';

								});
							} else {
								layer.msg(textState + '成功！');
								testCenterTable.ajax.reload();
							}

						}
					}
				})

				//				$.enabledOrDisabled(curData.id, textState, testCenterTable,'',);
			}
		})
	})

	//列表的删除
	$(document).on('click', '.del', function() {
		var curData = testCenterTable.row($(this).parents('tr')).data();
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(curData.status != 'enable') {
			layer.alert("该账号已被禁用，不能删除！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要删除这条数据?',
			btnAlign: 'c',
			yes: function() {
				if(curData.id === userInfoArr.userId) {
					layer.alert("您不能删除当前登录的账号！", {
						skin: 'layui-layer-lan'
					})
					return
				} else {
					$.ajax({
						url: allUrl.accManDel,
						type: 'post',
						data: {
							timestamp: 1508998573824,
							token: 'b01ad47000d0b2b719fe390ae15e8612',
							user_id: curData.id
						},
						success: function(data) {
							if(data.code == '0') {
								layer.closeAll();
								layer.msg('删除成功！')
								testCenterTable.ajax.reload();

							} else {
								layer.msg(data.message);
							}
						}
					})
				}

			}
		})

	})

	//列表的重置密码
	$(document).on('click', '.resetPass', function() {
		var curData = testCenterTable.row($(this).parents('tr')).data();
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(curData.status != 'enable') {
			layer.alert("该账号已被禁用，不能重置密码！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要重置密码?',
			btnAlign: 'c',
			yes: function() {
				$.resetPassword(curData.id);
			}
		})

	})

	//列表的编辑
	var user_id;
	$(document).on('click', '.edit', function() {
		var curData = testCenterTable.row($(this).parents('tr')).data();
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(curData.status != 'enable') {
			layer.alert("该账号已被禁用，不能编辑！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		var isAdd = false;

		user_id = curData.id;
		$.ajax({
			url: allUrl.getCurAccountMsg,
			type: 'post',
			data: {
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612',
				user_id: curData.id
			},
			success: function(data) {
				if(data.code == '0') {
					newAddBaseMsgLayer(isAdd, data.data);

				} else {
					layer.msg(data.message)
				}
			}
		})

	})

	//点击新增账号
	//	var firstStpe;  //第一个弹框基本内容
	$(document).on('click', '.newAddTestPeople', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		treeAll = "";
		var isAdd = true;
		newAddBaseMsgLayer(isAdd);

	})
	//点击新增账号的（基本信息）
	function newAddBaseMsgLayer(isAdd, data) {
		$('.accountName').val('');
		$('.accountTel').val('');
		layer.open({
			type: 1,
			area: '1068px',
			title: [isAdd == true ? '新增账号' : '编辑账号', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddAcount"),
			btn: ['下一步', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddNextStpe(isAdd)
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
		//获取所有的类型
		var typeSetting = {
			url: allUrl.baseRoleTypeList,
			type: 'post',
			id: 'accountAllType',
			data: {
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}

		$.selectBox(typeSetting);
		if(isAdd){
			$('#accountAllType').find("option[value='" + userInfoArr.typeId + "']").attr("selected", true);
			$('#accountAllType').attr("disabled", true);
		}
		
		if(userInfoArr.roleCode == 'admin') {
			//根据当前默认的类型来请求下面的部门
			$.getdepartmentList();
			//根据当前默认的部门来加载部门下面的角色
			$.getRoleOfDepartmentAndRole();

		} else if(userInfoArr.roleCode == 'bmadmin') {
			//根据当前默认的类型来请求下面的部门
			$.getdepartmentList();
			$('#departmentOfType').find("option[value='" + userInfoArr.departmentId + "']").attr("selected", true);
			//根据当前默认的部门来加载部门下面的角色
			$.getRoleOfDepartmentAndRole();
			$('#departmentOfType').attr('disabled', true);
		} else if(userInfoArr.roleCode == null || (userInfoArr.roleCode != "admin" && userInfoArr.roleCode != "bmadmin")) {
			//建档部门code是dp0001  如果是  请求那个接口 如果不是 全部灰色不点点击 赋当前用户的值
			if(userInfoArr.departmentCode == 'dp0001') {
				//建档管理人员获取部门下拉列表数据
				var xialaBumenSet = {
					url: allUrl.jiandangbuMessage,
					type: "post",
					id: "departmentOfType",
					data: {
						timestamp: 1508998573824,
						token: 'b01ad47000d0b2b719fe390ae15e8612',
						typeId: userInfoArr.typeId
					}
				}
				$.selectBox(xialaBumenSet); //请求部门
				$.getRoleOfDepartmentAndRole(); //获取角色和权限
			} else {
				//根据当前默认的类型来请求下面的部门
				$.getdepartmentList();
				$('#departmentOfType').find("option[value='" + userInfoArr.departmentId + "']").attr("selected", true);
				//根据当前默认的部门来加载部门下面的角色
				$.getRoleOfDepartmentAndRole();
				$('#roleOfDepartment').find("option[value='" + userInfoArr.roleId + "']").attr("selected", true);
				$('#departmentOfType ,#roleOfDepartment').attr('disabled', true);
			}
		}

		//省市区镇乡的加载
		$.addressFn('#province', allUrl.find_province_option);
		//判断是新增还是修改
		if(isAdd == false) {
			$('#accountAllType').find("option[value='" + data.typeId + "']").attr("selected", true);
			$('#accountAllType').attr("disabled", true);
			//			$("#accountAllType").find("option[value='" + data.typeId + "']").attr("selected", true);
			//根据当前默认的类型来请求下面的部门
			$.getdepartmentList();
			$("#departmentOfType").find("option[value='" + data.departmentId + "']").attr("selected", true);
			//根据当前默认的部门来加载部门下面的角色
			$.getRoleOfDepartmentAndRole();
			$("#roleOfDepartment").find("option[value='" + data.roleId + "']").prop("selected", true);
			$('.accountName').val(data.name);
			$('.accountTel').val(data.tel);
			if(data.provinceId != null) {
				$("#province").find("option[value='" + data.provinceId + "']").prop("selected", true);
				$.morenArea(allUrl.find_city_option, "province", 'city', "province") //根据省的id来获取市	
			}
			if(data.cityId != null) {
				$("#city").find("option[value='" + data.cityId + "']").prop("selected", true);
				$.morenArea(allUrl.find_district_option, "city", 'district', "city") //根据市的id来获取区
			}
			if(data.districtId != null) {
				$("#district").find("option[value='" + data.districtId + "']").prop("selected", true);
				$.morenArea(allUrl.find_town_option, "district", 'town', "district") //根据区的id来获取镇
			}
			if(data.townId != null) {
				$("#town").find("option[value='" + data.townId + "']").prop("selected", true);
				$.morenArea(allUrl.find_village_option, "town", 'village', "town") //根据镇的id来获取乡
				$("#village").find("option[value='" + data.villageId + "']").prop("selected", true);
			}
		}
		//加载相关的权限
		getSomeLimit();
	}

	//新增点击下一步之后弹出选择区域的的弹框
	//	var secondAreaLayer;  //第二个加载区域的弹框
	var areaZtree;

	function newAddNextStpe(isAdd) {
		var secondAreaLayer = layer.open({
			type: 1,
			area: ['1068px', '725px'],
			title: [isAdd == true ? '新增账号' : '编辑账号', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddAcountNextStep"),
			btn: ['确定', '上一步'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddAccountManageSave(isAdd);
			},
			btn2: function(index, layero) {
				layer.close(secondAreaLayer);
			}
		});
		//加载区域的数据
		areaZtree = $.areaSelect('accountManageZtree', userInfoArr.userId);
		//获取当前账号的区域
		if(isAdd == false) {
			$.ajax({
				url: allUrl.getAreaEditIdsByUserId,
				type: 'post',
				data: {
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612',
					user_id: user_id
				},
				success: function(data) {
					if(data.code == '0') {
						treeAll = data.data;
						var list = treeAll;
						$.each(list, function(index, event) {
							if(event.provinceId) {
								$.each(areaZtree.getNodes(), function(i, e) {
									if(event.provinceId == e.id) {
										e.checked = true;
										areaZtree.updateNode(e);
									}
								});
							}
						});
					} else {
						layer.msg(data.message)
					}
				}
			})
		}

	}

	//新增保存的事件
	function newAddAccountManageSave(isAdd) {
		var areaList = $.getSelectedAreaId(areaZtree);
		var arry1 = ["province", "city", "district", "town", "village"];
		var obj = {
			currentUserId: userInfoArr.userId,
			areas: JSON.stringify(areaList),
			typeId: $('#accountAllType').val(),
			departmentId: $('#departmentOfType').val(),
			roleId: $('#roleOfDepartment').val(),
			name: $('.accountName').val(),
			tel: $('.accountTel').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		};
		//获取地址的值
		$.each(arry1, function(index, val) {
			obj[val + 'Id'] = $("#" + val).val();
		});
		if(isAdd == false) {
			obj.userId = user_id;
		}
		var flag = true;
		if(obj.areas == "[]" || obj.name == "" || obj.tel == "") {
			flag = false
		}
		if(flag == true) {
			$.ajax({
				url: isAdd == true ? allUrl.accountManNewAdd : allUrl.accountManUpdate,
				type: "post",
				data: obj,
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(isAdd == true ? '新增成功！' : '修改成功！')
						testCenterTable.ajax.reload();
					} else {
						layer.msg(data.message)
					}
				}
			})
		} else {
			layer.msg('请您先填写基本信息！')
		}

	}

	//当下拉选择类型的时候，重新加载部门和角色
	$(document).on('change', '#accountAllType', function() {
		$.getdepartmentList();
		$.getRoleOfDepartmentAndRole();
		//加载相关的权限
		getSomeLimit()
	})
	//当下拉选择部门的时候重新加载角色
	$(document).on('change', '#departmentOfType', function() {
		$.getRoleOfDepartmentAndRole();
		getSomeLimit();
		//加载相关的权限
	})

	//加载相关权限
	function getSomeLimit() {
		var limitAjaxData = {
			roleId: $('#roleOfDepartment').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		$.limitSelect('newAddPeoLimit', limitAjaxData)
	}
	//下拉角色时选择权限并渲染
	$(document).on('change', '#roleOfDepartment', function() {
		//加载相关的权限
		getSomeLimit();
	})
	//table的全部部门和全部角色的select框渲染

	var tableHeadDeptSetting = {
		url: allUrl.getlistOfDepartment,
		type: 'post',
		id: 'accountManHeadBumen',
		allName: '全部部门',
		data: {
			typeId: userInfoArr.typeId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
	}
	$.selectBox(tableHeadDeptSetting);
	var tableHeadRoleSetting = {
		url: allUrl.getRoleSelectList,
		type: 'post',
		id: 'accountManHeadRole',
		allName: '全部角色',
		data: {
			typeId: userInfoArr.typeId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
	}
	$.selectBox(tableHeadRoleSetting);

	//地址的联动
	$('#province ,#city,#district,#town,#village').on('change', function() {
		var selectId = $(this)[0].id;
		switch(selectId) {
			case "province":
				$.addressFn('#city', allUrl.find_city_option, 'city');
				break;
			case "city":
				$.addressFn('#district', allUrl.find_district_option, 'district');
				break;
			case "district":
				$.addressFn('#town', allUrl.find_town_option, 'town');
				break;
			case "town":
				$.addressFn('#village', allUrl.find_village_option, 'village');
				break;
		}
	})
	//新增账号的电话号码的验证
	$(document).on('change', '.accountTel', function() {
		var phone = $('.accountTel').val();
		$.isPhone(phone);
	})

})