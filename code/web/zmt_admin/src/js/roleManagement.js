$(function() {
	$.login();
	//	var typeId; //当前选中的类型id
	//请求角色table数据
	roleTypeList(); //页面一加载就请求类型
	//请求类型
	var curquanxian = $.isRloe("角色管理");
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var curTypeId; //当前的类型id
	searchValue = {};
	function roleTypeList() {
		$.ajax({
			type: "post",
			url: allUrl.baseRoleTypeList,
			async: false,
			data: {
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(Data) {
				if(Data.code == '0') {
					var li = '';
					$('.rmHeadList ul').remove();
					$.each(Data.data, function(key, val) {
						li += '<li data = "' + val.id + '" flag="edit" ><span>' + val.name + '</span><img class="editImgBtn none" src="../src/images/bianji2.png" alt="" /> </li>'
					});
					li += '<li class="newAddType liStyle"> +新增类型</li>'
					var ul = '<ul> ' + li + '</ul>'
					$('.rmHeadList').append(ul);
					$('.rmHeadList ul li:first-child').addClass('active1');
					$('.rmHeadList ul li:first-child img').attr('src', '../src/images/bianji1.png');
					curTypeId = $('.active1').attr('data');
				} else {
					layer.msg(Data.message);
				}
			}
		});

	}
	var classNameArr = ['.editImgBtn','.newAddType','.newAddRole','.newAddBumen']
	if(curquanxian =='0'){
		$.hiddenOperateBtn(classNameArr);
		
	}

	//请求table数据
	searchValue = {
		typeId: curTypeId,
		timestamp: 1508998573824,
		token: 'b01ad47000d0b2b719fe390ae15e8612'
	};
	var testCenterSetting = {
		id: "testCenterTable",
		url: allUrl.getRoleListAll,
		searchParams: searchValue,
		lengthChange: false,
		scrollX: true,
		columns: ["departmentName", "roleName", "userCount", "resources", "createTime", "creator", null],
		columnDefs: [{
			"targets": 4,
			"orderable": false,
			"render": function(data, type, row, meta) {
				var list = '';
				var dataLen = data.length;
				$.each(data, function(index, val) {
					var curClass = (dataLen - 1) == index ? 'none' : '';
					list += '<span>' + val.resourceName + '<span class="' + curClass + '">、</span></span>'
				})
				return list;
			}
		}, {
			"targets": -1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				if(curquanxian =='1'){
					return('<a class="lookDetails">查看</a>')
				}else{
					return('<a class="lookDetails">查看</a>  <a class="updateRole">修改</a>  <a class="delRole">删除</a> ')
				}
//					return('<a class="lookDetails">查看</a>  <a class="updateRole">修改</a>  <a class="delRole">删除</a> ')
				
			}
		}],
	}

	var testCenterTable = $.createTable(testCenterSetting); //调用创建table的方法
	//	table头全部部门的select选择框
	var tableHeadDeptSetting = {
		url: allUrl.getlistOfDepartment,
		type: 'post',
		id: 'headDepartmenSel',
		allName: '全部部门',
		data: {
			typeId: curTypeId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
	}
	$.selectBox(tableHeadDeptSetting);

	//头部获取全部角色的下拉选择框的参数
	var tableHeadRoleSetting = {
		url: allUrl.getRoleSelectList,
		type: 'post',
		id: 'headRoleSel',
		allName: '全部角色',
		data: {
			typeId: curTypeId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
	}
	$.selectBox(tableHeadRoleSetting);

	//全部部门下拉刷新
	$(document).on('change', '#headDepartmenSel', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var departmentId = $('#headDepartmenSel').val();
		if(departmentId != 'all') {
			searchValue.departmentId = departmentId;
			testCenterTable.settings()[0].ajax.data = searchValue;
		} 
		
		testCenterTable.ajax.reload();

	})

	//全部角色下拉刷新
	$(document).on('change', '#headRoleSel', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var roleId = $('#headRoleSel').val();
		if(roleId !='all'){
			searchValue.roleId = roleId;
			testCenterTable.settings()[0].ajax.data = searchValue;
		}
		testCenterTable.ajax.reload();
	})
	//	点击编辑img编辑的时候
	$(document).on('click', '.rmHeadList ul li img', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curLi = this.parentElement;
		var curTypeName = $(curLi.firstChild).html();
		$('.roleTypeName').val(curTypeName);
		var id = $(curLi).attr('data');
		var isAdd = false;
		layer.open({
			type: 1,
			area: '450px',
			title: ['编辑类型', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddType"),
			btn: ['保存', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddType(isAdd, id);
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	});

	//	新增类型
	$(document).on('click', '.newAddType', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		$('.roleTypeName').val("");
		var isAdd = true;
		var id = '';
		layer.open({
			type: 1,
			area: '450px',
			title: ['新增类型', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddType"),
			btn: ['保存', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddType(isAdd, id);
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	})
	//新增修改类型的保存
	function newAddType(isAdd, id) {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var name = $('.roleTypeName').val();
		$.ajax({
			type: 'post',
			url: isAdd == true ? allUrl.newAddRoleType : allUrl.editBaseRoleType,
			data: {
				typeId: id,
				typeName: name,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					roleTypeList(); //新增类型成功之后就请求一次类型
					layer.closeAll();
					layer.msg(isAdd == true ? '新增类型成功！' : '修改类型成功！');
				} else {
					layer.closeAll();
					layer.msg(data.message);
				}
			}
		})
	}

	//点击类型加载相应的table，并且类型的框的背景颜色跟着改变
	$(document).on('click', '.rmHeadList ul li', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var allLi = $('.rmHeadList ul li');
		var that = $(this);
		var newBtnClass = that.attr('class');
		//如果是新增按钮不做任何操作
		if(newBtnClass != 'newAddType liStyle') {
			$.each(allLi, function(index, val) {
				$(this).removeClass('active1');
				var curImg = $(this)[0].lastElementChild;
				$(curImg).attr('src', '../src/images/bianji2.png')
			})
			that.addClass('active1');
			var curClickImg = that[0].lastElementChild
			$(curClickImg).attr('src', '../src/images/bianji1.png')

			curTypeId = $('.active1').attr('data');
			//	table头全部部门的select选择框
			tableHeadDeptSetting.data.typeId = curTypeId;
			$.selectBox(tableHeadDeptSetting);
			//头部全部角色的select框的选择
			tableHeadRoleSetting.data.typeId = curTypeId;
			$.selectBox(tableHeadRoleSetting);
			//重新刷新table的数据
			searchValue.typeId = curTypeId;
			if(searchValue.departmentId !=undefined){
				delete searchValue.departmentId
			}
			if(searchValue.roleId !=undefined){
				delete searchValue.roleId
			}
			testCenterTable.settings()[0].ajax.data = searchValue;
			testCenterTable.ajax.reload();
		} else {
			return
		}

	})

	//部门管理
	var bumenTable; //部门管理的列表
	$(document).on('click', '.bumenManage', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var typeId = $('.active1').attr('data');
		//部门管理table
		var bumenSetting = {
			id: "bumenTable",
			url: allUrl.departmentList,
			searchParams: {
				typeId: typeId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			lengthChange: false,
			scrollX: true,
			columns: ["code", "typeName", "departmentName", "countRole", null],
			scrollY: '400px',
			scrollCollapse: "true",
			paging: "false",
			columnDefs: [/*{
				"targets": 0,
				"orderable": false,
				"visible": false
			},*/ {
				"targets": -1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					if(curquanxian =='1'){
						return('<a>/</a>')
					}else{
						return('<a class="buemnEdit">修改</a>  <a class="bumenDel">删除</a> ')
					}
					
				}
			}],
		}
		bumenTable = $.createTable(bumenSetting); //调用创建table的方法
		layer.open({
			type: 1,
			area: ['1067px', '750px'],
			title: ['部门管理', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#bumenManage"),
		})
	})

	//新建部门
	$(document).on('click', '.newAddBumen', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		$('.bumenName').val('');
		var isAdd = true;
		departmentId = '';
		showNewAddLayer(isAdd);

	})

	//修改部门
	var departmentId;
	$(document).on('click', '.buemnEdit', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var isAdd = false;
		var curData = bumenTable.row($(this).parents('tr')).data();
		departmentId = curData.departmentId;
		showNewAddLayer(isAdd);
		//给所属类型和部门名称赋值
		$("#suoshuleixingSel option[value=" + curData.typeId + "]").attr("selected", "selected");
		$('.bumenName').val(curData.departmentName);
	})

	//新增修改部门的弹框
	var curLayer;

	function showNewAddLayer(isAdd) {
		curLayer = layer.open({
			type: 1,
			area: ['583px', '410px'],
			title: [isAdd == true ? '新增部门' : '修改部门', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddDepartment"),
			btn: ['保存', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				departmentSave(isAdd);
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		})

		//获取类型的下拉列表并渲染到select框中
		var typeId = $('.active1').attr('data');
		var setting = {
			url: allUrl.baseRoleTypeList,
			type: "post",
			id: 'suoshuleixingSel',
			//			allName: '全部类型',
			data: {
				typeId: typeId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}
		$.selectBox(setting);
	}
	//新增修改部门的保存
	function departmentSave(isAdd) {
		var typeId = $('#suoshuleixingSel').val();
		var departmentName = $('.bumenName').val();
		$.ajax({
			url: (isAdd == true) ? allUrl.newAddDepartment : allUrl.updateDepartment,
			type: 'post',
			data: {
				departmentId: departmentId,
				typeId: typeId,
				departmentName: departmentName,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					bumenTable.ajax.reload();
					layer.close(curLayer);
					layer.msg(isAdd == true ? "新增成功！" : "修改成功！")
				} else {
					layer.msg(data.message)
				}
			}
		})
	}

	//部门的删除
	$(document).on('click', '.bumenDel', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curData = bumenTable.row($(this).parents('tr')).data();
		$.ajax({
			url: allUrl.delDepartment,
			type: "post",
			data: {
				departmentId: curData.departmentId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					bumenTable.ajax.reload();
					layer.msg('删除成功！')

				} else {
					layer.msg(data.message)
				}
			}
		})
	})

	//新建角色
	$(document).on('click', '.newAddRole', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		
		var roleAdd = true;
		roleBumenLimeitMsg();
		showNewJueseLayer(roleAdd);
		$('.addRoleName').val('');

		

	})

	//修改角色
	var curRoleId;
	$(document).on('click', '.updateRole', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curData = testCenterTable.row($(this).parents('tr')).data();
		curRoleId = curData.roleId;
		var roleAdd = false;
		roleBumenLimeitMsg()
		showNewJueseLayer(roleAdd);
		$("#jueseDapartment option[value='" + curData.departmentId + "']").attr("selected", true);
		$('.addRoleName').val(curData.roleName);
		if(curData.code =='bmadmin'){ 
			$("input[name='accountType'][value='bmadmin']").prop('checked', 'checked');

		}else{
			$("input[name='accountType'][value='1']").prop('checked', 'checked');  

		}
		var lis = $(".limitUl1 li");
		//给权限赋值
		$.each(curData.resources, function(index, val) {
			var id = val.resourceId;
			var type = val.type;
			lis.each(function(e, i) {
				var checkbo = $(i).find('input[type=checkbox]');
				var checkboxId = checkbo.attr('data-id');
				if(checkboxId == id) {
					checkbo.prop('checked', 'checked');
					$(i).find('input[type=radio]').prop('disabled', false);
					if(type == '0') {
						$(i).find('input[value=' + type + ']').prop('checked', 'checked');
					} else {
						$(i).find('input[value=' + type + ']').prop('checked', 'checked');
					}
				}
			})
		});

	})

	//加载部门的数据以及可用权限的数据
	function roleBumenLimeitMsg() {
		var curType = $('.active1 span').text();
		$('.jueseTypeName').text(curType);
		var curTypeId1 = $('.active1').attr('data');
		var curSelSetting = {
			url: allUrl.getlistOfDepartment,
			type: 'post',
			id: 'jueseDapartment',
			data: {
				typeId: curTypeId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}
		$.selectBox(curSelSetting);
		//渲染可用权限
		$.ajax({
			url: allUrl.getRoleLimit,
			type: 'post',
			async: false,
			data: {
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					$('.limitRole ul').remove();
					var options = '';
					$.each(data.data, function(key, val) {
						if(val.name != '基础配置') {
							options += '<li><label class="checkbox-inline"><input type="checkbox" data-id="' + val.id + '" class="curCheckbox" value="" name="checkBox1"> ' + val.name + '</label><label class="radio-inline"><input type="radio" class="curRadio" name="index' + key + '" id="" value="0" disabled>查看/使用</label><label class="radio-inline"><input type="radio" class="curRadio" name="index' + key + '" id="" value="1" disabled>查看</label></li>'
						}

					})
					var box = '<ul class="limitUl1">' + options + '</ul>'
					$('.limitRole').append(box);

				} else {
					layer.msg(data.message)
				}
			}
		})
	}
	//新增和修改角色是弹出的弹出框
	function showNewJueseLayer(roleAdd) {
		//		弹出新增框

		layer.open({
			type: 1,
			area: ['1086px', '800px'],
			title: [roleAdd == true ? '新增角色' : '修改角色', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddjuese"),
			btn: ['保存', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddRoleMsg(roleAdd);
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		})
	}

	//新增修改保存事件
	function newAddRoleMsg(roleAdd) {
		//获取需要传到后台的数据
		var roleName = $('.addRoleName').val();
		var departmentId = $('#jueseDapartment').val();
		var typeId = $('.active1').attr('data');
		var resourceIds = [];
		var allcheckeds = $('input:checkbox[name=checkBox1]:checked');
		//获取可选权限的id和type
		$.each(allcheckeds, function(index, val) {
			var li = $(val).parents("li");
			var curLi = $(this).parents(".limitUl1").find("li");
			var checkedRadio = li.find('input[type=radio]:checked');
			resourceIds.push({
				resourceId: $(this).attr('data-id'),
				type: checkedRadio.val()
			})
		})
		
		var code = $("input:radio[name=accountType]:checked").val();
		//新增传数据
		var addData = {
			code:code,
			creator:userInfoArr.name,
			roleName: roleName,
			departmentId: departmentId,
			typeId: typeId,
			resourceIds: JSON.stringify(resourceIds),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		};
		//修改需要传的数据
		var updateData = {
			code:code,
			creator:userInfoArr.name,
			roleName: roleName,
			departmentId: departmentId,
			roleId: curRoleId,
			resourceIds: JSON.stringify(resourceIds),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		};
		var flag = true;
		if(roleName == '' || addData.resourceIds == "[]" || updateData.resourceIds == "[]") {
			flag = false;
		}
		if(flag) {
			$.ajax({
				url: roleAdd == true ? allUrl.newAddRole : allUrl.updateRole,
				"type": 'post',
				"data": roleAdd == true ? addData : updateData,
				"success": function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(roleAdd == true ? '新增角色成功！' : '修改角色成功!')
						testCenterTable.ajax.reload();
					} else {
						layer.msg(data.message);
					}

				}
			});
		} else {
			layer.alert("请先填写角色名称或选择权限！",{
				skin: 'layui-layer-lan'
			})
		}
	};
	//可用权限checkbox框选中的事件
	$(document).on('change', '.curCheckbox', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var that = $(this)[0];
		var curStates = that.checked;
		var firstLabel = $(this).parents('li');
		var inputs = firstLabel.find("input[type=radio]");
		var id = $(this).attr("data-id");
		if(curStates == true) {
			inputs.attr('disabled', false);
			inputs[0].checked = true;
		} else {
			inputs.attr('disabled', true);
			inputs.attr('checked', false);
		}

	});

	//角色的删除
	$(document).on('click', '.delRole', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curData = testCenterTable.row($(this).parents('tr')).data();
		$.ajax({
			url: allUrl.delRole,
			type: "post",
			data: {
				roleId: curData.roleId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					layer.closeAll();
					layer.msg('删除角色成功！')
					testCenterTable.ajax.reload();
				} else {
					layer.msg(data.message)
				}
			}
		})
	})

	$(document).on('click', '.lookDetails', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		$('.backLastPage').attr('data-className','roleAccout');
		var curData = testCenterTable.row($(this).parents('tr')).data();
		$('.curRoleOfAccount').show();
		$('.testCenterAll').hide();
		var roleAccountSetting = {
			id: "roleAccountTable",
			url: allUrl.accountManageListAll,
			searchParams: {
				roleId: curData.roleId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			lengthChange: false,
			scrollX: true,
			columns: ["status", "account", "name",'phone', "departmentName", 'roleName','creator','createTime'],
			columnDefs: [ {
				"targets": 1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var statusText = data =='enable'?'正常':'禁用';
					return('<span>'+statusText+'</span>')
				}
			}],
		}
		roleAccountTable = $.createTable(roleAccountSetting); //调用创建table的方法	

	})
	
	//返回上一页
	$(document).on('click','.backLastPage',function(){
		var curLocation = $('.backLastPage').attr('data-className');
		if(curLocation == 'roleAccout'){
			$('.curRoleOfAccount').hide();
			$('.testCenterAll').show();
		}
	})

})