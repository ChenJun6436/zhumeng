var treeAll;
$(function() {
	//获取当前用户的登录信息
	$.login();
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var curQuanxian = $.isRloe("检验中心");
	//当没有操作权限时，隐藏操作按钮
	var classNameArry = ['.newAddMarket', '.ct_isDisabledBtn', '.ct_addressEdit', '.newAddTestPeople', '.isDisabledBtn', '.detailsEdit', '.tcDetailsAddReport']
	if(curQuanxian == '0') {
		$.hiddenOperateBtn(classNameArry);
	}
	var searchValue = {
		timestamp: 1508998573824,
		token: 'b01ad47000d0b2b719fe390ae15e8612'
	};
	var setting = {
		id: 'shichangManageList',
		url: allUrl.getTestCenterList,
		searchParams: searchValue,
		lengthChange: false,
		scrollX: true,
		columns: ["name", "principalName", "phone", "address", "creatorName", null],
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
				if(curQuanxian == '1') {
					return('<a class="tableOperate tableOperate2" >查看</a>')
				} else {
					return('<a class="isDisabled1 ' + className + '">' + textState + '</a>  <a class="tableOperate tableOperate2" >查看</a>')
				}

			}
		}],
	}
	var getTestCenterTable = $.createTable(setting); //调用创建table的方法
	//检验中心的启用禁用事件
	$(document).on('click', '.isDisabled1', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var curData = getTestCenterTable.row($(this).parents('tr')).data();
		var statusText = curData.status == 'enable' ? '禁用' : '启用';
		layer.confirm('您确定要' + statusText + '该条数据？', {
			btn: ['确定', '取消'], //按钮
			title: ['提示信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btnAlign: 'c',
		}, function() {
			$.ajax({
				url: allUrl.testCenterIsdisabled,
				type: 'post',
				data: {
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612',
					id: curData.id,
					status: curData.status,
				},
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(statusText + '成功！');
						getTestCenterTable.ajax.reload();
					} else {
						layer.msg(data.message);
					}
				}
			})

		}, function() {
			layer.closeAll();
		});

	})
	//检验中心的查看
	var jianyanData;
	var checkCenterId;
	$(document).on('click', '.tableOperate2', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var curData = getTestCenterTable.row($(this).parents('tr')).data();
		if(curData.status != 'enable') {
			layer.alert("该检验中心已被禁用，不能查看！", {
				skin: 'layui-layer-lan'

			})
			return false
		}
		jianyanData = curData;
		checkCenterId = curData.id;
		curStatus = curData.status;
		userId = curData.id;
		$('#marketList').hide();
		$('.testCenterAll').show();
		//赋值
		var arry = ['name', 'phone', 'total', 'principalName', 'address']
		$.each(arry, function(i, e) {
			$('.ct_' + e).text(curData[e])
		});
		var statusText = curData.status == "enable" ? "正常" : "禁用";
		$('.ct_status').text(statusText);
		if(statusText == '禁用') {
			$('.ct_isDisabledBtn').prop('src', '../src/images/enabled.png')
		} else {
			$('.ct_isDisabledBtn').prop('src', '../src/images/disabled.png')
		}
		//加载检验中心人员的table
		//请求检验中心人员table数据
		if(searchValue.key != undefined) {
			delete searchValue.key
		}
		searchValue.id = curData.id;
		var testCenterSetting = {
			id: "testCenterTable",
			url: allUrl.testCenterListAll,
			searchParams: searchValue,
			lengthChange: false,
			scrollX: true,
			columns: ["account", "name", "phone", "totals", null],
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
				"targets": -1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var textState = data.status == 'enable' ? '禁用' : '启用';
					var className = data.status == 'enable' ? "talbeDisabled" : "tableOperate";
					if(curQuanxian == '1') {
						return('<a class="tableOperate tableOperate1" >查看</a>')
					} else {
						return('<a class="isDisabled ' + className + '">' + textState + '</a>  <a class="tableOperate tableOperate1" >查看</a>  <a class="resetPass">重置密码</a> ')
					}

				}
			}],
		}

		testCenterTable = $.createTable(testCenterSetting)
	})
	//检验中心的搜索
	$(document).on('click', '.centerSearchBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var keywords = $('.keyWord').val();
		searchValue = {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		if(keywords != '') {
			searchValue.key = keywords
		}
		getTestCenterTable.settings()[0].ajax.data = searchValue;
		getTestCenterTable.ajax.reload();

	})
	//检验中心详情table的创建
	var testCenDelTable; //检验详情的table创建  在点击查看详情时渲染改table
	//新增检验中心
	$(document).on('click', '.newAddMarket', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var isAdd = true;
		showAddCtLayer(isAdd);
	})
	//修改检验中心
	$(document).on('click', '.ct_addressEdit', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var isAdd = false
		//隐藏检验中心的名称
		if(jianyanData.status != 'enable') {
			layer.alert("该检验中心已被禁用，不能修改！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		showAddCtLayer(isAdd, jianyanData.id);
		$('.fuzeren').show();
		$('.mingcheng').hide();
		$('.principalName').val(jianyanData.principalName);
		$('.phone').val(jianyanData.phone);
		$('.name').val(jianyanData.name);
		$('.jianyanCTName').addClass('none');
		morenAreaVlaue(jianyanData);
	})
	//地址的默认赋值
	function morenAreaVlaue(data) {
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

	//新增检验中心layer
	function showAddCtLayer(isAdd, id) {
		var title;
		var curUrl;
		if(isAdd == true) {
			title = '新增检验中心';
			curUrl = allUrl.newAddTestCenter
		} else if(isAdd == false) {
			title = '修改检验中心';
			curUrl = allUrl.updateTestCenter
		} else if(isAdd == 'peopleFlag') {
			title = '修改检验人员';
			curUrl = allUrl.updateTestCenter1
		}
		layer.open({
			type: 1,
			area: '600px',
			title: [title, 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $(".newAddMarketLayer"),
			btn: ['提交', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddtestCenter(isAdd, id, curUrl) //保存信息的方法
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
		$.addressFn('#province1', allUrl.find_province_option);
	}

	//地址的联动
	$('#province1 ,#city1,#district1,#town1,#village1').on('change', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
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

	//检验中心详情的禁用启用
	$(document).on('click', '.ct_isDisabledBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		detailsIsDisabled(allUrl.testCenterIsdisabled, 'ct_isDisabledBtn', 'ct_status', getTestCenterTable, '检验中心')
	})

	//检验中心的新增修改保存
	function newAddtestCenter(isAdd, id, curUrl) {
		var curArray1 = ['province', 'city', 'district', 'town', 'village'];
		var Data = {
			name: $('.name').val(),
			principalName: $('.principalName').val(),
			phone: $('.phone').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612',
			creatorId: userInfoArr.userId
		}
		if(isAdd == false) {
			Data.id = id;

			jianyanData.phone = Data.phone;
			jianyanData.principalName = Data.principalName;
		}
		if(isAdd == 'peopleFlag') {
			Data.id = id;
			Data.name = $('.principalName1').val();
			Data.tel = $('.phone').val();
			curData.phone = Data.tel;
			curData.name = Data.name;
			curData.principalName = Data.name;
		}
		var areaText = [];
		var flag = true;
		$.each(curArray1, function(index, val) {
			Data[val + 'Id'] = $('.' + val).val();
			var curText = $('.' + val).find("option:selected").text();
			if(curText != '--请选择--') {
				areaText.push(curText);
			}
			if(!isAdd) {
				jianyanData[val + 'Id'] = Data[val + 'Id'];
			} else if(isAdd == 'peopleFlag') {
				curData[val + 'Id'] = Data[val + 'Id'];
			}
		});
		Data.address = '';
		$.each(areaText, function(i, e) {
			Data.address += e;
		})
		if(isAdd == true) {
			if(Data.name == '' || Data.principalName == '' || Data.phone == "") {
				flag = false;
			}
		}
		if(flag) {
			$.ajax({
				url: curUrl,
				type: 'post',
				data: Data,
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg(isAdd == true ? '新增成功' : '修改成功！');
						isAdd == 'peopleFlag' ? testCenterTable.ajax.reload() : getTestCenterTable.ajax.reload();
						if(isAdd == false) {
							var arry2 = ['name', 'principalName', 'phone', 'address'];
							$.each(arry2, function(index, e) {
								$('.ct_' + e).text(Data[e]);
							})
							getTestCenterTable.ajax.reload();
						} else if(isAdd == 'peopleFlag') {
							var arr3 = ['name', 'address'];
							$.each(arr3, function(index, e) {
								$('.' + e).text(Data[e])
							});
							$('.phone1').text(Data.tel);
							testCenDelTable.ajax.reload();
						}
					} else {
						layer.msg(data.message)
					}
				}
			})
		} else {
			layer.msg('请先填写基本信息！')
		}

	}

	var testCenterTable; //调用创建table的方法
	//点击搜索按钮
	$(document).on('click', '.searchBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		searchFn();
	})
	//搜索调用的方法
	function searchFn() {
		var keywords = $('#testing_search').val();
		searchValue = {
			id: jianyanData.id,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		if(keywords != '') {
			searchValue.key = keywords
		}
		testCenterTable.settings()[0].ajax.data = searchValue;
		testCenterTable.ajax.reload();
	}

	//点击保存按钮
	$(document).on("click", '.testbtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var areasId = $.getSelectedAreaId(testCenterTree); // 调用获取区域值的方法，获取已选中的区域的id
	})
	//新增人员页面选择角色加载可用的权限
	$(document).on('change', '.chooseRole', function() {
		$.getLimitByRoleId();
	})

	//点击查看详情
	var userId;
	var curData;
	$(document).on('click', '.tableOperate1', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		curData = testCenterTable.row($(this).parents('tr')).data();
		if(curData.status != 'enable') {
			layer.alert("该市场检验人员已被禁用，不能查看！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		userId = curData.id;
		//		jianyanData = curData;
		$(".testCenterAll").hide();
		$('#marketList').hide();
		$('.testCenterDetails').show();
		$('.testCenterBack').attr("data", "testCenterDetails");
		var tcDetailsSetting = {
			id: "testCenterDetailsTable",
			url: allUrl.testCenterCheckBreedList,
			searchParams: {
				userId: userId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			lengthChange: false,
			scrollX: true,
			columns: ["pigId", "type", "quarantineResult", "describe", "createTime", "address", "remark"],
			columnDefs: [{
				"targets": 2,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var showText;
					if(row.type == '1') {
						showText = '接种疫苗'
					} else if(row.type == '0') {
						showText = '生猪检查'
					} else {
						showText = '生猪处理'
					}
					return('<span>' + showText + '</span> ')
				}
			}, {
				"targets": 3,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var showText;
					if(data == null) {
						showText = '/'
					} else {
						showText = row.quarantineResult == '1' ? '通过' : '不通过';
					}
					return('<span>' + showText + '</span> ')
				}
			}, {
				"targets": 5,
				"orderable": false,
				"render": function(data, type, row, meta) {
					var curTime = new Date(row.createTime).toLocaleDateString();
					return('<span>' + curTime + '</span> ')
				}

			}],
		}

		$("#testCenterDetalSlect ").val('');
		testCenDelTable = $.createTable(tcDetailsSetting);
		//给检验人员详情赋值

		var arr1 = ['account', 'totals', 'name', 'address'];
		$.each(arr1, function(i, e) {
			$('.' + e).text(curData[e]);
		})
		$('.phone1').text(curData.phone);
		$('.status').text(curData.status == 'enable' ? '正常' : '禁用');
		$('.isDisabledBtn').prop('src', curData.status == 'enable' ? '../src/images/disabled.png' : '../src/images/enabled.png')

	})

	//检验人员生猪详情的搜索（根据id查询）
	$(document).on('click', '.ctDetailsSerach', function() {
		pidBreedSearch()
	})
	//生猪类型的下拉搜索
	$(document).on('change', '#testCenterDetalSlect', function() {
		pidBreedSearch()
	})
	//生猪详情的搜索
	function pidBreedSearch() {
		var pigId = $('.seachId').val();
		var typeId = $('#testCenterDetalSlect').val();
		searchValue = {
			userId: userId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		if(pigId != '') {
			searchValue.pigId = pigId
		}
		if(typeId != '') {
			searchValue.type = typeId
		}
		testCenDelTable.settings()[0].ajax.data = searchValue;
		testCenDelTable.ajax.reload();
	}
	//详情页面新增报告
	$(document).on('click', '.tcDetailsAddReport', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(curData.status != 'enable') {
			layer.alert("所属检验人员已被禁用，不能新增报告！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		var nameArry = ['#breedPigId', '#yimiaoName', '.yimiaoNameBeizhu', '.describe', '.textareaBerzhu'];
		$.each(nameArry, function(i, e) {
			$(e).val('');
		});
		layer.open({
			type: 1,
			area: '350px',
			title: ['新增报告', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#reportLayer"),
			btn: ['是', '否'],
			btnAlign: 'c',
			yes: function(index, layero) {
				var breedPigId = $('#breedPigId').val();
				if(breedPigId == '') {
					layer.msg('请先输入生猪的id！')
				} else {
					$.ajax({
						url: allUrl.getPigMsgByPigId,
						type: 'post',
						data: {
							timestamp: 1508998573824,
							token: 'b01ad47000d0b2b719fe390ae15e8612',
							pigId: breedPigId
						},
						success: function(data) {
							if(data.code == '0') {
								layer.closeAll();
								var Data = data.data;
								var pigMsgArry = ['id', 'location', 'phone', 'address'];
								$.each(pigMsgArry, function(index, even) {
									$('.pig_' + even).text(Data[even]);
								});
								// debugger;
								var statesText;
								switch(Data.status) {
									case 0:
										statesText = '正常';
										$(".checkType option").remove();
										$(".checkType").append("<option value='1'>常规检查</option><option value='2'>宰前检查</option>");
										break;
									case 1:
										statesText = '死亡';
										break;
									case 2:
										$(".checkType option").remove();
										$(".checkType").append("<option value='1'>常规检查</option><option value='2'>宰前检查</option>");
										statesText = '宰前待检验';
										break;
									case 3:
										$(".checkType option").remove();
										$(".checkType").append("<option value='1'>常规检查</option><option value='2'>宰前检查</option>");
										statesText = '待屠宰';
										break;
									case 4:
										$(".checkType option").remove();
										$(".checkType").append("<option value='3'>宰后检查</option>");
										statesText = '宰后待检验';
										break;
									case 5:
										statesText = '待销售';
										break;
									case 6:
										statesText = '已处理';
										break;
									case 7:
										statesText = '已销售';
										break;
									default:
										break;
								}
								$('.pig_status').text(statesText);
								newReport();
							} else {
								layer.msg(data.message);
							}
						}
					})

				}
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	})

	//新增报告点击“是”
	function newReport() {
		layer.open({
			type: 1,
			area: '500px',
			title: ['', 'background-color:#1FB5AD'],
			content: $("#reportYesLayer"),
			btn: ['确定', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				var radioSelect = $("input[type='radio']:checked").val();
				layer.closeAll();
				if(radioSelect === "1") {
					addReportNext(radioSelect);
				} else {
					addReportNext(radioSelect)
				}
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	}

	//新增报告后选择生猪检查和接种疫苗的确定事件
	function addReportNext(radioSelect) {
		layer.open({
			type: 1,
			area: '500px',
			title: [radioSelect == "1" ? "疫苗报告" : "检查报告", 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: radioSelect == "1" ? $("#reportYesNextLayer1") : $("#reportYesNextLayer2"),
			btn: ['确定', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddReportSave();
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
	}

	//检查结果为不通过时显示处理方式
	$(document).on('change', 'input:radio[name=checkRuslt]', function() {
		var thisValue = $('input:radio[name=checkRuslt]:checked').val();
		if(thisValue == '0') {
			$('.chulifangshi').show();
		} else {
			$('.chulifangshi').hide();
		}
	})

	//详情中新增报告的保存事件
	function newAddReportSave() {
		//获取相关的数据
		var objValue = {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}; //作为参数传给后代的对象
		objValue.userId = userId;
		//		checkCenterId
		objValue.pigId = $('#breedPigId').val();
		var yimiaoName = $('input:radio[name=optionsRadios]:checked').val();
		if(yimiaoName == '0') {
			objValue.type = '0';
			objValue.checkType = $('.checkType').val();
			var checkResult = $('input:radio[name=checkRuslt]:checked').val();
			objValue.quarantineResult = checkResult; //检查结果
			if(checkResult == '0') {
				//				objValue.type = '2';
				objValue.isDispose = $('input:radio[name=chuliStyle]:checked').val(); //处理方式
			} else {
				if(objValue.isDispose != undefined) {
					delete objValue.isDispose
				}
			}
			objValue.describe = $('.describe').val(); //描述
			objValue.remark = $('.textareaBerzhu').val(); //备注
		} else {
			objValue.type = '1';
			objValue.vaccine = $('#yimiaoName').val(); //疫苗名称
			objValue.remark = $('.yimiaoNameBeizhu').val();
		}
		$.ajax({
			url: allUrl.breedPigNewAddReport,
			type: "post",
			data: objValue,
			success: function(data) {
				if(data.code == '0') {
					layer.closeAll();
					testCenDelTable.ajax.reload();
					layer.msg('新增成功！');
				} else {
					layer.msg(data.message)
				}
			}
		})

	}
	//新增检验人员
	$(document).on('click', '.newAddTestPeople', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(jianyanData.status != 'enable') {
			layer.alert("所属检验中心已被禁用，不能新增！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		$('.accountName,.accountTel').val('');
		newAddCheckPeo()
	})
	//新增检验人员的
	function newAddCheckPeo() {
		layer.open({
			type: 1,
			area: '1068px',
			title: ['新增检验人员', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddchecekPeo"),
			btn: ['下一步', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
				//点击确定弹出区域选择弹框
				var isPhone = $.isPhone($('.accountTel').val());
				if(isPhone) {
					selectTree = $.areaSelect("newAddArea1", userInfoArr.userId);
					tcAreaSelect();
				} else {
					layer.msg("请先填写正确的手机号码！")
				}

			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});
		$('.curtCenter').text(jianyanData.name);
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
		//加载相关的权限(根据角色的id)
		$.getLimitByRoleId();
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

	//区域选择的弹框
	var selectTree;

	function tcAreaSelect() {
		var curLayer = layer.open({
			type: 1,
			area: ['1068px', '693px'],
			title: ['新增', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddArea"),
			btn: ['确定', '上一步'],
			btnAlign: 'c',
			yes: function(index, layero) {
				newAddTestPeopleSave() //保存
			},
			btn2: function(index, layero) {
				layer.close(curLayer);
			}
		});
	}

	//新增检验人员的新增保存
	function newAddTestPeopleSave() {
		var areas = $.getSelectedAreaId(selectTree);
		var obj = {
			currentUserId: userInfoArr.userId,
			areas: JSON.stringify(areas),
			typeId: $('#accountAllType').val(),
			departmentId: $('#departmentOfType').val(),
			roleId: $('#roleOfDepartment').val(),
			name: $('.accountName').val(),
			tel: $('.accountTel').val(),
			villageId: $('#village').val(),
			townId: $('#town').val(),
			districtId: $('#district').val(),
			cityId: $('#city').val(),
			provinceId: $('#province').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		var flag = true;
		obj.inspectionName = jianyanData.name;
		obj.inspectionId = jianyanData.id;
		if(obj.areas == "[]" || obj.name == "" || obj.tel == "") {
			flag = false
		}
		if(flag == true) {
			$.ajax({
				url: allUrl.testCenterNewAddPeople,
				type: "post",
				data: obj,
				success: function(data) {
					if(data.code == '0') {
						layer.closeAll();
						layer.msg('新增成功！')
						testCenterTable.ajax.reload();
					} else {
						layer.closeAll();
						layer.msg(data.message)
					}
				}
			})
		} else {
			layer.msg('请先完善基本信息！')
		}
	}
	//详情基本信息的编辑
	$(document).on('click', '.detailsEdit', function() {
		if(curData.status != 'enable') {
			layer.alert("该检验人员已被禁用，不能编辑！", {
				skin: 'layui-layer-lan'
			})
			return false
		}
		$('.principalName1').val(curData.name);
		$('.phone').val(curData.phone);
		$('.jianyanCTName,.fuzeren').hide();
		$('.mingcheng').show();
		var isAdd = "peopleFlag";
		showAddCtLayer(isAdd, curData.id);
		//需要给地址赋默认值
		morenAreaVlaue(curData);
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
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		if(data.status != 'enable') {
			layer.alert("该检验人员已被禁用，不能重置密码！", {
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
				$.resetPassword(data.id);

			}
		})
	})

	//列表中的禁用启用
	$(document).on('click', '.isDisabled', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var data = testCenterTable.row($(this).parents('tr')).data();
		var textState = data.status == 'enable' ? '禁用' : '启用';
		layer.open({
			title: ['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn: ['确定', '取消'],
			content: '您是否确定要' + textState + '？',
			btnAlign: 'c',
			yes: function() {
				$.enabledOrDisabled(data.id, textState, testCenterTable)
			}
		})
	})
	//检验人员详情页面的禁用启用
	var curStatus; //详情中的状态修改状态
	$(document).on('click', '.isDisabledBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		detailsIsDisabled(allUrl.accManIsDisabled, 'isDisabledBtn', 'status', testCenterTable, '检验人员')
	})
	//详情页面的启用禁用
	function detailsIsDisabled(url, imgClName, statusClName, table, type) {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var statusText = curStatus == 'enable' ? '禁用' : '启用';
		$.ajax({
			url: url,
			type: "post",
			data: {
				user_id: userId,
				id: userId,
				status: curStatus,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					layer.tips('您已经' + statusText + '了该账号', '.' + imgClName, {
						tips: [3, "#00A651"]
					});
					if(statusText == '禁用') {
						if(type == '检验人员') {
							curData.status = 'disable'
						}
						jianyanData.status = 'disable',

							$('.' + imgClName).prop('src', '../src/images/enabled.png')
						$('.' + statusClName).text('禁用');
					} else {
						if(type == '检验人员') {
							curData.status = 'enable'
						}
						jianyanData.status = 'enable',

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

	//点击返回上一页
	$(document).on('click', '.testCenterBack', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig) {
			return
		}
		var curlocation = $('.testCenterBack').attr("data");
		if(!(curlocation == "testCenter")) {
			$(".testCenterAll").show();
			$('.testCenterDetails').hide();
			$('.testCenterBack').attr("data", "testCenter")
		} else {
			$(".testCenterAll").hide();
			$('.testCenterDetails').hide();
			$('#marketList').show();
		}
	})

	//新增人员的电话号码验证
	$(document).on('change', '.accountTel', function() {
		var phone = $('.accountTel').val();
		$.isPhone(phone);
	})

	//新增检验中心的电话号码的验证
	$(document).on('change', '.phone', function() {
		var phone = $('.phone').val();
		$.isPhone(phone);
	})

})