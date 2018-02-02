var treeAll;
window.onresize = function() {
	//	console.log(document.body.clientWidth)
	if(document.body.clientWidth < 1008) {
		$("#dddd").css({
			paddingLeft: "0px"
		});
	} else {
		$("#dddd").css({
			paddingLeft: "260px"
		});
	};
};

$(function() {
	$.login();
	//获取当前用户的登录信息
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var curQuanxian = $.isRloe("市场管理");
	//当前账号如果只有查看权限，则隐藏所有的操作按钮
	var clsNameArry = ['.newAddMarket','.newAddTestPeople','.ct_isDisabledBtn','.ct_addressEdit','.tcDetailsAddReport','.detailsDisabled','.detailsEdit'];
	if(curQuanxian =='0'){
		$.hiddenOperateBtn(clsNameArry);
	}	
	var curData; //查看详情时当前这条数据的详情内容
	//table请求参数
	var searchValue = {
		timestamp: 1508998573824,
		token: 'b01ad47000d0b2b719fe390ae15e8612'
	};
	//市场的请求table
	var setting = {
		id: "shichangManageList",
		url: allUrl.marketManageList,
		searchParams: searchValue,
		lengthChange: false,
		scrollX: true,
		columns: ["name", "principalName", "number", "phone", "address", "creatorName", "creatorTime", null],
		columnDefs: [{
			"targets": 1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return $.renderTable(data, row)
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
			"targets": -1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				var textState = data.status == 'enable' ? '禁用' : '启用';
				var className = data.status == 'enable' ? "talbeDisabled" : "tableOperate";
				if(curQuanxian == "1"){
					return('<a class="tableOperate lookBtn">查看</a>')
				}else{
					return('<a class="MarketIsabledBtn ' + className + '">' + textState + '</a>  <a class="tableOperate lookBtn">查看</a> ')
				}
			}
		}],
	}

	var shichangTable = $.createTable(setting); //创建市场的table
	//市场管理的启用禁用
	$(document).on('click', '.MarketIsabledBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
//		if(curQuanxian == '1') {
//			layer.msg('您没有禁用启用市场的权限！')
//			return false
//		}
		var curData = shichangTable.row($(this).parents('tr')).data();
		var statusText = curData.status == 'enable' ? '禁用' : '启用';
		var status = statusText == '启用' ? 'enable' : 'disable';
		layer.confirm('您确定要' + statusText + '该条数据？', {
			btn: ['确定', '取消'], //按钮
			title: ['提示信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btnAlign: 'c',
		}, function() {
			$.ajax({
				url: allUrl.marketIsDisabled,
				type: 'post',
				data: {
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612',
					id: curData.id,
					status: status,
				},
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(statusText + '成功！');
						shichangTable.ajax.reload();
					} else {
						layer.msg(data.message);
					}
				}
			})
		}, function() {
			layer.closeAll();
		});
	})

	//市场管理的查看
	var marketId;
	$(document).on('click', '.lookBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		curData = shichangTable.row($(this).parents('tr')).data();
		if(curData.status == 'disable') {
			layer.alert("该市场已被禁用，不能查看！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		marketId = curData.id;
		$('#marketList').hide();
		$('.testCenterAll').show();
		var arr = ['name', 'number', 'principalName', 'phone', 'address'];
		//给市场详情赋值
		$.each(arr, function(index, e) {
			$('.ct_' + e).text(curData[e])
		})
		var statusText = curData.status == "enable" ? "正常" : "禁用";
		$('.ct_status').text(statusText);
		$('.ct_isDisabledBtn').prop('src', curData.status == 'disable' ? '../src/images/enabled.png' : '../src/images/disabled.png')
		if(searchValue.key != undefined) {
			delete searchValue.key
		}
		searchValue.id = curData.id;
		var testCenterSetting = {
			id: "testCenterTable",
			url: allUrl.getMarketManageList,
			searchParams: searchValue,
			lengthChange: false,
			scrollX: true,
			columns: ["account", "userName", "phone", "number", "address", null],
			columnDefs: [{
				"targets": 1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					return $.renderTable(data, row)
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
				"targets": -1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var textState = data.status == 'enable' ? '禁用' : '启用';
					var className = data.status == 'enable' ? "talbeDisabled" : "tableOperate";
					if(curQuanxian =='1'){
						return('<a class="tableOperate tableOperateBtn">查看</a> ')
					}else{
						return('<a class="jinyongqiyongBtn ' + className + '">' + textState + '</a>    <a class="resetPass1 tableOperate">重置密码</a>  <a class="tableOperate tableOperateBtn">查看</a> ')
					}
					
				}
			}],
		}
		testCenterTable = $.createTable(testCenterSetting); //加载市场人员的table
	})
	//市场人员请求table数据
	var testCenterTable;

	//市场详情的启用禁用
	$(document).on('click', '.ct_isDisabledBtn', function() {
		detalisIsdisabled(allUrl.marketIsDisabled, 'ct_isDisabledBtn', 'ct_status', shichangTable, '市场')
	})

	//市场人员详情的禁用启用
	$(document).on('click', '.detailsDisabled', function() {
		detalisIsdisabled(allUrl.accManIsDisabled, 'detailsDisabled', 'status', testCenterTable, '市场人员')
	})
	//市场详情与市场人员详情中的禁用启用
	function detalisIsdisabled(url, imgClName, statusClName, table, type) {
		
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var statusText = curData.status == 'enable' ? '禁用' : '启用';
		var curStatus = statusText == '禁用' ? 'disable' : 'enable';
		$.ajax({
			url: url,
			type: "post",
			data: {
				id: curData.id == null ? curData.userId : curData.id,
				user_id: curData.id == null ? curData.userId : curData.id,
				status: curStatus,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					layer.tips('您已经' + statusText + '了该' + type, '.' + imgClName, {
						tips: [3, "#00A651"]
					});
					if(statusText == '禁用') {
						curData.status = 'disable';
						if(type =='市场人员'){
							peopDetails.status = 'disable'
						}
						$('.' + imgClName).prop('src', '../src/images/enabled.png')
						$('.' + statusClName).text('禁用');
					} else {
						curData.status = 'enable';
						if(type =='市场人员'){
							peopDetails.status = 'enable'
						}
						$('.' + imgClName).prop('src', '../src/images/disabled.png')
						$('.' + statusClName).text('正常');
					}
					table.ajax.reload();
				} else {
					layer.msg(data.message)
				}
			}
		})
	}

	//新增市场
	$(document).on('click', '.newAddMarket', function() {
		if(curQuanxian == '1') {
			layer.msg('您没有新增市场的权限！')
			return false
		}
		var isAdd = true;
		$('.mk_name,.mk_principalName,.mk_phone').val('');
		showMarketLayer(allUrl.marketNewAddReport, isAdd, '新增市场')
	})

	//修改市场
	$(document).on('click', '.ct_addressEdit', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(curData.status != 'enable'){
			layer.alert("该市场已被禁用，不能编辑！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		var isAdd = false;
		$('.shichangBox, .peopleName').hide();
		$('.fuzeren').show();
		var arry = ['name', 'phone', "principalName"];
		$.each(arry, function(i, e) {
			$('.mk_' + e).val(curData[e]);
		});
		showMarketLayer(allUrl.updateMarket, isAdd, '修改市场');
		detailsMorenArea(curData) //给地址赋默认值
	})
	//修改市场人员
	$(document).on('click', '.detailsEdit', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(peopDetails.status !='enable'){
			layer.alert("该市场人员已被禁用，不能进行编辑！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		var isAdd = 'flagDetails';
		$('.shichangBox ,.fuzeren').hide();
		$('.peopleName').show();
		var arry = ['userName', 'phone'];
		$.each(arry, function(i, e) {
			$('.mk_' + e).val(peopDetails[e]);
		});
		showMarketLayer(allUrl.accountManUpdate, isAdd, '修改市场人员');
		detailsMorenArea(peopDetails) //给地址赋默认值

	})

	//修改时给地址赋默认值
	function detailsMorenArea(data) {
		if(data.provinceId != null) {
			$("#province1").find("option[value='" + data.provinceId + "']").prop("selected", true);
			$.morenArea(allUrl.find_city_option, "province1", 'city1', 'province') //根据省的id来获取市	
		}
		if(data.cityId != null) {
			$("#city1").find("option[value='" + data.cityId + "']").prop("selected", true);
			$.morenArea(allUrl.find_district_option, "city1", 'district1', 'city') //根据市的id来获取区
		}
		if(data.districtId != null) {
			$("#district1").find("option[value='" + data.districtId + "']").prop("selected", true);
			$.morenArea(allUrl.find_town_option, "district1", 'town1', 'district') //根据区的id来获取镇
		}
		if(data.townId != null) {
			$("#town1").find("option[value='" + data.townId + "']").prop("selected", true);
			$.morenArea(allUrl.find_village_option, "town1", 'village1', 'town') //根据镇的id来获取乡
			$("#village1").find("option[value='" + data.villageId + "']").prop("selected", true);
		}
	}

	//新增修改市场和市场管理人员的弹框
	function showMarketLayer(url, isAdd, titleName) {

		layer.open({
			type: 1,
			area: '600px',
			title: [titleName, 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $(".newAddMarketLayer"),
			btn: ['提交', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddMarketSave(url, isAdd)
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
		$.addressFn('#province1', allUrl.find_province_option); // 调用渲染省的数据的方法
	}
	//新增修改市场和修改市场人员的保存方法
	function newAddMarketSave(url, isAdd) {
		var Data = {
			creatorId: userInfoArr.userId, //传userId
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612',
		};
		var arr = ['name', 'principalName', 'phone'];
		var flag = true;
		$.each(arr, function(i, e) {
			var curValue = $('.mk_' + e).val();
			if(curValue != '') {
				Data[e] = curValue;
			} else {
				if(isAdd == true) {
					flag = false;
					return
				}

			}
		});
		var curArray1 = ['province', 'city', 'district', 'town', 'village'];
		var areaText = [];
		$.each(curArray1, function(index, val) {
			Data[val + 'Id'] = $('.' + val).val();
			var curText = $('.' + val).find("option:selected").text();
			if(curText != '--请选择--') {
				areaText.push(curText);
			}
		});
		Data.address = '';
		$.each(areaText, function(i, e) {
			Data.address += e;
		})
		if(isAdd == false) {
			Data.id = curData.id;
		} else if(isAdd == 'flagDetails') {
			Data.userId = peopDetails.userId,
				Data.currentUserId = userInfoArr.userId,
				Data.tel = $('.mk_phone').val();
			Data.name = $('.mk_userName').val();
			peopDetails.tel = Data.tel
			peopDetails.userName = Data.name
		}
		var array1 = ['cityId', 'districtId', 'provinceId', 'townId', 'villageId', 'name', 'principalName', 'phone'];
		if(!isAdd) {
			$.each(array1, function(index, even) {
				curData[even] = Data[even]
			})
		} else if(isAdd == 'flagDetails') {
			$.each(array1, function(index, even) {
				peopDetails[even] = Data[even]
			})
		}
		//		if(isAdd == true) {
		//			
		//			if(!Data.name || !Data.principalName || !Data.phone) {
		//				flag = false;
		//			}
		//		}

		if(flag) {
			$.ajax({
				url: url,
				type: 'post',
				data: Data,
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(isAdd == true ? '新增成功' : '修改成功！');
						isAdd == 'flagDetails' ? testCenterTable.ajax.reload() : shichangTable.ajax.reload();
						if(isAdd == false) {
							var arr1 = ['address', 'principalName', 'phone', 'name'];
							$.each(arr1, function(index, e) {
								$('.ct_' + e).text(Data[e])
							});
							shichangTable.ajax.reload();
						} else if(isAdd == 'flagDetails') {
							$('.userName').text(Data.name);
							$('.address').text(Data.address);
							$('.phone').text(Data.phone);
							testCenterTable.ajax.reload();
						}
					} else {
						layer.msg(data.message)
					}
				}
			})
		} else {
			layer.msg('请您先填写基本信息！')
		}

	}

	//市场的新增和修改以及市场人员的修改的省市区的联动
	$('#province1 ,#city1,#district1,#town1,#village1').on('change', function() {
		var selectId = $(this)[0].id;
		switch(selectId) {
			case "province1":
				$.addressFn('#city1', allUrl.find_city_option, 'city');
				break;
			case "city1":
				$.addressFn('#district1', allUrl.find_district_option, 'district');
				break;
			case "district1":
				$.addressFn('#town1', allUrl.find_town_option, 'town');
				break;
			case "town1":
				$.addressFn('#village1', allUrl.find_village_option, 'village');
				break;
		}
	})

	//新增检验人员
	$(document).on('click', '.newAddTestPeople', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(curData.status != 'enable'){
			layer.alert("所属市场已被禁用，不能新增市场人员！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		$('.popleName,.peopleTle').val('');
		newAddCheckPeo()
	})
	//新增检验人员的
	function newAddCheckPeo() {
		layer.open({
			type: 1,
			area: '1068px',
			title: ['新增市场管理员', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddchecekPeo"),
			btn: ['下一步', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				//点击确定弹出区域选择弹框

				var isPhone = $.isPhone($('.peopleTle').val());
				if(isPhone) {
					tcAreaSelect();
				} else {
					layer.msg("请先填写正确的手机号码！")
				}

			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
		$('.marketName').text(curData.name); //市场名称赋值
		//省市区镇乡的加载
		$.addressFn('#province', allUrl.find_province_option);
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
		$('#accountAllType').find("option[value='" + userInfoArr.typeId + "']").attr("selected", true);
		$('#accountAllType').attr("disabled", true);
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
		//加载相关的权限
		$.getLimitByRoleId();
	}

	//区域选择的弹框
	var selectTree;

	function tcAreaSelect() {
		selectTree = $.areaSelect("newAddArea1", userInfoArr.userId);
		var curLayer = layer.open({
			type: 1,
			area: ['1068px', '800px'],
			title: ['新增', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddArea"),
			btn: ['确定', '上一步'],
			btnAlign: 'c',
			yes: function(index, layero) {
				saveMarketMsg()
			},
			btn2: function(index, layero) {
				layer.close(curLayer);
			}
		});
	}

	//新增市场管理员的保存
	function saveMarketMsg() {
		var obj = {
			currentUserId: userInfoArr.userId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612',
			typeId: $('#accountAllType').val(),
			departmentId: $('#departmentOfType').val(),
			roleId: $('#roleOfDepartment').val(),
			name: $('.popleName').val(),
			tel: $('.peopleTle').val()
		}
		var areaArry = ['province', 'city', 'district', 'town', 'village'];
		$.each(areaArry, function(i, e) {
			obj[e + 'Id'] = $('#' + e).val();
		});

		obj.areas = JSON.stringify($.getSelectedAreaId(selectTree));
		var flag = true;
		if(obj.areas == "[]" || obj.name == "" || obj.tel == "") {
			flag = false
		}
		var num = curData.number; //当前市场人员的数量
		if(flag) {
			$.ajax({
				url: allUrl.accountManNewAdd,
				type: 'post',
				data: obj,
				success: function(data) {
					if(data.code == '0') {
						$.ajax({
							url: allUrl.contactMarketAndPeople,
							type: 'post',
							data: {
								timestamp: 1508998573824,
								token: 'b01ad47000d0b2b719fe390ae15e8612',
								userId: data.data,
								marketId: curData.id
							},
							success: function(data) {
								if(data.code == '0') {
									layer.closeAll();
									layer.msg('新增成功！');
									num += 1;
									$('.ct_number').text(num);
									testCenterTable.ajax.reload(); //市场人员的列表刷新
									shichangTable.ajax.reload(); //市场的列表刷新
								} else {
									layer.msg(data.message)
								}
							}
						})

					} else {
						layer.msg(data.message)
					}
				}
			})
		} else {
			layer.msg('请您先填完基本信息！')
		}

	}

	//当下拉选择类型的时候，重新加载部门和角色
	$(document).on('change', '#accountAllType', function() {
		$.getdepartmentList();
		$.getRoleOfDepartmentAndRole();
		//加载相关的权限
		$.getLimitByRoleId();
	})
	//当下拉选择部门的时候重新加载角色
	$(document).on('change', '#departmentOfType', function() {
		$.getRoleOfDepartmentAndRole();
		//加载相关的权限
		$.getLimitByRoleId();
	})
	//当角色下拉时加载权限
	$(document).on('click', '#roleOfDepartment', function() {
		$.getLimitByRoleId();
	})

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

	//市场人员管理列表的禁用启用
	$(document).on('click', '.jinyongqiyongBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curData = testCenterTable.row($(this).parents('tr')).data();
		var textState = curData.status == 'enable' ? '禁用' : '启用';
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要' + textState + '？',
			btnAlign: 'c',
			yes: function() {
				$.enabledOrDisabled(curData.userId, textState, testCenterTable)
			}
		})

	})

	//市场人员管理中的重置密码
	$(document).on('click', '.resetPass1', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var curData = testCenterTable.row($(this).parents('tr')).data();
		if(curData.status != 'enable'){
			layer.alert("该市场人员已被禁用，不能重置密码！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要重置密码？',
			btnAlign: 'c',
			yes: function() {
				$.resetPassword(curData.userId)
			}
		})

	})

	//点击查看详情
	var testCenDelTable;
	var userId;
	var peopDetails;
	var manageNum;
	$(document).on('click', '.tableOperateBtn', function() {
		peopDetails = testCenterTable.row($(this).parents('tr')).data();
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(peopDetails.status != 'enable'){
			layer.alert("该市场人员已被禁用，不能进行查看！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		$(".testCenterAll").hide();
		$('.testCenterDetails').show();
		$('.testCenterBack').attr("data", "testCenterDetails");
		
		userId = peopDetails.userId;
		manageNum = peopDetails.number;
		var curArry = ['account', 'number', 'userName', 'phone', 'address'];
		$.each(curArry, function(index, even) {
			$('.' + even).text(peopDetails[even]);
		});
		$('.status').text(peopDetails.status == 'disable' ? '禁用' : '正常');
		$('.detailsDisabled').prop('src', peopDetails.status == 'disable' ? '../src/images/enabled.png' : '../src/images/disabled.png')
		//售卖猪列表详情table的创建
		searchValue = {
			//			userId:userInfoArr.userId,
			id: userId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		var tcDetailsSetting = {
			id: "testCenterDetailsTable",
			url: allUrl.marketManageBreedList,
			searchParams: searchValue,
			lengthChange: false,
			scrollX: true,
			columns: ["pigId", "pigBreed", "weight", "creatorName", "createTime", null],
			columnDefs: [{
				"targets": -1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					return('<a class="tableOperate1">查看</a>')
				}
			}],
		}
		$('#testCenterDetalSlect').val('all');
		testCenDelTable = $.createTable(tcDetailsSetting); //检验详情的table创建
	})

	//详情页面的查看
	var breedPigDetailsTabe;
	$(document).on('click', '.tableOperate1', function() {
		var curData1 = testCenDelTable.row($(this).parents('tr')).data();
		//		curData = curData1;
		$(".testCenterAll").hide();
		$('.testCenterDetails').hide();
		$('.testCenterDetails1').show();
		$('.testCenterBack').attr("data", "testCenterDetailstoDetails");
		$('.breed_id').text('ID:' + curData1.pigId);
		$('.pig_pinzhong').text('品种:' + curData1.pigBreed);
		//生猪详情table的渲染
		searchValue = {
			pig_id: curData1.pigId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		var breedPigDetailsSetting = {
			id: "testCenterDetailsTable1",
			url: allUrl.indexGetPigTableDetails,
			searchParams: searchValue,
			lengthChange: false,
			scrollX: true,
			columns: ["thing", "status", "address", "description", "createrName", "createTime", "remark"],
		}
		breedPigDetailsTabe = $.createTable(breedPigDetailsSetting); //检验详情的table创建
	})

	//详情页面新增报告
	$(document).on('click', '.tcDetailsAddReport', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(peopDetails.status != 'enable'){
			layer.alert("所属的市场人员已被禁用，不能新增录入！",{
				skin: 'layui-layer-lan'
			})
			return false
		}
		$('#breedPigId').val('');
		$('.weight').val('');
		layer.open({
			type: 1,
			area: '350px',
			title: ['新增', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#reportLayer"),
			btn: ['是', '否'],
			btnAlign: 'c',
			yes: function(index, layero) {
				var pigId = $('#breedPigId').val();
				if(pigId != "") {
					// debugger;
					//					if(weightFlag) {
					$.ajax({
						url: allUrl.isEditByPigId,
						type: 'post',
						data: {
							timestamp: 1508998573824,
							token: 'b01ad47000d0b2b719fe390ae15e8612',
							pigId: pigId
						},
						success: function(data) {
							if(data.code == '0') {
								layer.closeAll();
								newReport();

							} else {
								layer.msg(data.message);

							}

						}
					})
					//					} else {
					//						layer.msg('请您先正确填写猪重量')
					//					}
				} else {
					layer.msg('请先输入生猪的id!')
				}
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	})

	//新增报告点击“是”
	function newReport() {
		var breedPigId = $('#breedPigId').val();
		$('.shengzhuId').text(breedPigId);
		layer.open({
			type: 1,
			area: '400px',
			title: ['', 'background-color:#1FB5AD'],
			content: $("#reportYesLayer"),
			btn: ['是', '否'],
			btnAlign: 'c',
			yes: function(index, layero) {
				var pigWeight = $('.weight').val();
				if(pigWeight != '') {
					if(weightFlag) {
						$.ajax({
							url: allUrl.marketAddPigMsg,
							type: 'post',
							data: {
								userId: peopDetails.userId,
								marketId: marketId,
								pigId: breedPigId,
								weight: pigWeight,
								timestamp: 1508998573824,
								token: 'b01ad47000d0b2b719fe390ae15e8612'
							},
							success: function(data) {
								if(data.code == '0') {
									layer.closeAll();
									testCenDelTable.ajax.reload();
									manageNum += 1;
									$('.number').text(manageNum);
									layer.msg('新增成功！')

								} else {
									layer.msg(data.message)

								}
							}
						})
					} else {
						layer.msg("生猪的重量不能小于0！")
					}

				} else {
					layer.msg('请先输入猪重量！')
				}

			},
			btn2: function(index, layero) {
				layer.closeAll();

			}
		});
	}
	//判断输入的重量保留两位小数
	var weightFlag;
	$(document).on('blur', '.weight', function() {
		weightFlag = true;
		var numberWeight = $('.weight').val();
		if(numberWeight <= 0) {
			//				layer.msg('输入的值不小于0！');
			weightFlag = false
		} else {
			var curnumber = parseFloat(numberWeight).toFixed(2);
			$('.weight').val(curnumber);
		}

	})

	//点击新增报告
	$(document).on('click', '.newAddReport', function() {
		layer.open({
			type: 1,
			area: '300px',
			title: ['新增报告', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#addRepot"),
			btn: ['提交', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				alert('123');
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	})

	//点击重置密码
	$(document).on('click', '.resetPass', function() {
		var data = testCenterTable.row($(this).parents('tr')).data();
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要重置密码？',
			btnAlign: 'c',
			yes: function() {
				alert("123");
				layer.closeAll();
			}
		})
	})

	//禁用启用
	$(document).on('click', '.isDisabled', function() {
		var data = testCenterTable.row($(this).parents('tr')).data();
		var textState = data.status == 'disabled' ? '启用' : '禁用';
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要' + textState + '？',
			btnAlign: 'c',
			yes: function() {
				alert("123");
				layer.closeAll();
			}
		})

	})

	//	检验中心的搜索查询
	$(document).on('click', '.marketSearchBtn', function() {
		var name = $('.marketKey').val();
		searchValue = {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		if(name != '') {
			searchValue.key = name
		}
		shichangTable.settings()[0].ajax.data = searchValue;
		shichangTable.ajax.reload();

	});
	//市场人员的搜索
	$(document).on('click', '.searchBtn', function() {
		var name = $('.testing_search1').val();
		searchValue = {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612',
			id: marketId
		}
		if(name != '') {
			searchValue.key = name;
		}
		testCenterTable.settings()[0].ajax.data = searchValue;
		testCenterTable.ajax.reload();
	})

	//生猪列表详情的搜索
	$(document).on('click', '.ctDetailsSerach', function() {
		var pigId = $('.seachId').val();
		var setting = {
			table: testCenDelTable,
			data: {
				id: userId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}
		if(pigId != '') {
			setting.data.pigId = pigId
		}
		selectChangeFn(setting);
	})

	//下拉框的选择刷新table 和搜索刷新table
	/*setting.data 为参数
	 * setting.table 需要被刷新的table
	 */
	function selectChangeFn(setting) {
		searchValue = setting.data;
		setting.table.settings()[0].ajax.data = searchValue;
		setting.table.ajax.reload();
	}
	//点击返回上一页
	$(document).on('click', '.testCenterBack', function() {
		var curlocation = $('.testCenterBack').attr("data");
		if(curlocation == "testCenterDetails") {
			$(".testCenterAll").show();
			$('.testCenterDetails').hide();
			$('.testCenterDetails1').hide();
			$('.testCenterBack').attr("data", "testCenter")
		} else if(curlocation == "testCenterDetailstoDetails") {
			$(".testCenterAll").hide();
			$('.testCenterDetails').show();
			$('.testCenterDetails1').hide();
			$('.testCenterBack').attr("data", "testCenterDetails")
		} else if(curlocation == "testCenter") {
			$('#marketList').show();
			$(".testCenterAll").hide();
			$('.testCenterDetails').hide();
			$('.testCenterDetails1').hide();
		}

	})
	//生猪详情中头部生猪品种的的下拉列表的渲染
	var breedPigSelectSetting = {
		url: allUrl.breedPigList,
		allName: '全部种类',
		id: 'testCenterDetalSlect',
		type: 'post',
		data: {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
	}
	$.selectBox(breedPigSelectSetting);

	//生猪详情列表select选择框的下拉选择
	$(document).on('change', '#testCenterDetalSlect', function() {
		var pigBreed = $('#testCenterDetalSlect').val();

		var setting = {
			table: testCenDelTable,
			data: {
				id: userId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}
		if(pigBreed != "all") {
			setting.data.pigBreed = pigBreed
		}
		selectChangeFn(setting);
	})

	//新增人员的电话号码验证
	$(document).on('change', '.peopleTle', function() {
		var phone = $('.peopleTle').val();
		$.isPhone(phone);
	})

	//新增市场管理的电话号码的验证
	$(document).on('change', '.mk_phone', function() {
		var phone = $('.mk_phone').val();
		$.isPhone(phone);
	})

})