/**
 * Created by dev on 2017/11/01.
 *
 *
 * 模块：养殖管理
 */
$(document).ready(function() {
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	$.login('.filter-select');
	var rloeType = $.isRloe('养殖管理');
	var classNameArr = ['.editorBtn', '.statusBtn', '.breedDetailAdd', '.breedAdd']
	if(rloeType == 0) {
		$.hiddenOperateBtn(classNameArr)
	}
	var columnArrs = ["id", "status", "department", "role", "account", "userName", "phone", "farmType", "total", "fooderName", "address", null];
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
			if(k.status == "disable") {
				if(data == 0) {
					return '<span class="text-gary">个体</span>'
				} else if(data == 1) {
					return '<span class="text-gary">养殖场</span>'
				} else {
					return null
				}
			} else {
				if(data == 0) {
					return '<span>个体</span>'
				} else if(data == 1) {
					return '<span>养殖场</span>'
				} else {
					return null
				}
			}

		}
	}, {
		targets: 9,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);

		}
	}, {
		targets: 10,
		orderable: false,
		render: function(data, i, k) {
			if(data == null || data == "") {
				return null;
			} else {
				return $.renderTable(data, k);
			}
		}
	}, {
		targets: 11,
		orderable: false,
		render: function(data, i, k) {
			return $.renderTable(data, k);
		}
	}, {
		targets: -1,
		orderable: false,
		render: function(data) {
			if(rloeType == 1) {
				return('<a href="#" class="text-primary viewBtn">查看</a>')
			} else {
				if(data.status == "disable") {
					return('<a href="#" class="text-primary filingStatusBtn">启用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
				} else {
					return('<a href="#" class="text-orange filingStatusBtn">禁用</a><a href="#"  class="text-primary resetPassWordBtn">重置密码</a><a href="#" class="text-primary viewBtn">查看</a>')
				}
			}

		}
	}];
	var data = $('.filter-select').val();
	var searchVal;
	if(data == "") {
		data = null
	} else {
		searchVal = {
			typeId: data
		}
	};
	var tableBreedM = {
		id: "breedManage",
		url: allUrl.farmsManger,
		searchParams: searchVal,
		lengthChange: false,
		columns: columnArrs,
		scrollX: true,
		columnDefs: columnDefArrs

	}
	var tableBreed = $.createTable(tableBreedM);
	$.department(allUrl.farmsDepartment, "#breed-departments");
	$.role(allUrl.farmsRole, "#breed-role");
	$.verifyById(userInfoArr.userId);
	/**
	 * 养殖管理--搜索
	 */
	$(document).on('click', ".breedSearch", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			filingSeacherFn()
		}

	});
	/**
	 * 养殖管理--部门/角色
	 */
	$(document).on('change', ".filter-select,#breed-departments,#breed-role,#breed-type", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			filingSeacherFn()
		}
	});

	function filingSeacherFn() {
		searchVal = {
			keyWords: $('#searchVal').val(),
			typeId: $('.filter-select').val(),
			farmType: $('#breed-type').val(),
			departmentId: $("#breed-departments").val(),
			roleId: $('#breed-role').val()
		};
		for(var key in searchVal) {

			if(searchVal[key] == "" || searchVal[key] == 'all') {
				delete searchVal[key];
			}
		};
		$.seacherFn(tableBreed, searchVal);
	}
	/**
	 * 养殖管理--新增管理员
	 * 
	 */
	$(document).on('click', ".breedAdd", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var tit = '新建养殖户'
			$.detailsEditor(tit);

		}

	});
	/**
	 * 养殖管理--禁/启用
	 * 
	 */
	$(document).on('click', ".filingStatusBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = tableBreed.row($(this).parents('tr')).data();
			if(cellData.status == "disable") {
				txt = "启用";
			} else {
				txt = "禁用";
			}
			$.enabledOrDisabled(cellData.id, txt, tableBreed)
		}
	});
	/**
	 * 养殖管理--重置密码
	 */
	$(document).on('click', ".resetPassWordBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = tableBreed.row($(this).parents('tr')).data();
			if(cellData.status == "启用" || cellData.status == "enable") {
				$.resetPassword(cellData.id)
			} else {
				layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			};
		}
	});
	/*
	 * 养殖管理--查看
	 */
	var breedBetailsTable = "";
	$(document).on('click', ".viewBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			/*
			 * 1.获取点击行数据
			 * 2隐藏养殖管页面，打开养殖页面
			 * 3、养殖户页面赋值，并请求table
			 **/
			var cellData = tableBreed.row($(this).parents('tr')).data();
			if(cellData.status == "禁用" || cellData.status == "disable") {
				layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				});
				return false;
			};
			$('.rowData').text(JSON.stringify(cellData))
			$(".breed_manage").addClass('none');
			$(".breed_details,.details").removeClass('none');
			$(".breedArea").removeClass('on');
			$(".detailsArea").addClass('on');
			var arrys = ["id", "status", "account", "userName", "total", "phone", "farmType", "fooderName", "address"];
			$.adminInfoArea(arrys, cellData, "#breed_details_", ".statusBtn")

			/*
			 * 养殖户管理--Table
			 * 
			 * */
			var columnArrs = ["id", "sign", "pigType", "statusType", "createTime", "bulider", null];
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
						return '<p>完成养殖</p>'
					} else if(data == 3) {
						return '<p>完成养殖</p>'
					} else if(data == 4) {
						return '<p>完成养殖</p>'
					} else if(data == 5) {
						return '<p>完成养殖 </p>'
					} else if(data == 6) {
						return '<p>完成养殖 </p>'
					} else if(data == 7) {
						return '<p>完成养殖 </p>'
					} else {
						return null;
					}
				}
			}, {
				targets: 5,
				orderable: false,
				render: function(data) {
					if(data != null) {
						return(data.split('.')[0]);
					} else {
						return null;
					}

				}
			}, {
				targets: -1,
				orderable: false,
				render: function(data) {
					if(rloeType == 1) {
						return('<a href="#" class="text-primary lookBtn">查看</a>')
					} else {
						return('<a href="#" class="text-primary lookBtn">查看</a><a href="#" class="text-primary deleteBtn">删除</a>')
					}
				}
			}];
			var searchVal = {
				userId: $('#breed_details_id').text()
			};

			var breedBetails = {
				id: "breedBetailsTable",
				url: allUrl.farmsbyFarms,
				searchParams: searchVal,
				columns: columnArrs,
				lengthChange: false,
				scrollX: true,
				columnDefs: columnDefArrs

			}
			breedBetailsTable = $.createTable(breedBetails);
		}
	});
	/*
	 * 养殖户管理--搜索
	 * 
	 * */
	$(document).on('click', '.breedDetailSearch', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var data = {
				keyWords: $('#searchId').val(),
				userId: $('#breed_details_id').text()
			};
			for(var key in searchVal) {

				if(searchVal[key] == "" || searchVal[key] == 'all') {
					delete searchVal[key];
				}
			};
			$.seacherFn(breedBetailsTable, data);
		}
	});

	/*
	 * 养殖户管理--新增生猪
	 * 
	 * */
	var creater;
	$(document).on('click', '.breedDetailAdd', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $("#breed_details_status").text();
			if(txt == "disable" || txt == "禁用") {
				layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			} else {

				var breedDetail = layer.open({
					type: 1,
					area: ['580px', '320px'],
					title: ['新增生猪', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
					content: $('.addPigLayer'),
					btn: ['是', '否'],
					btnAlign: 'c',
					btn1: function(index, layero) {
						var fig = $.verifyById(userInfoArr.userId);
						if(fig) {
							var txt = $(".layui-layer-btn0").text();
							if(txt == "是") {
								pigActive()

							} else {
								addPig(breedDetail)
							}
						}
					},
					btn2: function(index) {
						var fig = $.verifyById(userInfoArr.userId);
						if(fig) {
							var txt = $(".layui-layer-btn1").text();
							if(txt == "否") {
								$(".addPig").val(null);
							} else {
								$('.addPigTypeArea').addClass('none');
								$('.addPigIdArea').removeClass('none');
								$(".layui-layer-btn0").text("是");
								$(".layui-layer-btn1").text("否")
								return false;
							}
						}
					},
					cancel: function(index) {
						var fig = $.verifyById(userInfoArr.userId);
						if(fig) {
							$(".addPig").val(null);
							$(".addPigType  option[value=''] ").attr("selected", true)
							$('.addPigTypeArea').addClass('none');
							$('.addPigIdArea').removeClass('none');
						}
					}
				});
			}
		}
	});
	//生猪激活
	function pigActive() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var id = $.trim($(".addPig").val());
			if(id == "") {
				layer.msg("请输入生猪ID号");
				return false;
			}
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.farmsActivateSign,
				data: {
					sign: id
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						$(".addPigId").text(id)
						$('.addPigTypeArea').removeClass('none');
						$('.addPigIdArea').addClass('none');
						$(".layui-layer-btn0").text("保存");
						$(".layui-layer-btn1").text("上一步");
						creater = dataAll.data.createrId;
						$.pigType(allUrl.farmsPigType, '.addPigType');

					} else {
						layer.msg(dataAll.message);
					}

				}
			});
		}
	};
	//新增生猪

	function addPig(breedDetail) {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var createrId = creater;
			var pigType = $('.addPigType').val();
			var id = $(".addPigId").text();
			var famerId = $('#breed_details_id').text();
			if(pigType == "") {
				layer.msg('请选择生猪类型');
			} else {
				$.ajax({
					type: "post",
					async: true, //同步执行
					url: allUrl.farmsAddPig,
					xhrFields: {
						withCredentials: true
					},
					data: {
						sign: id,
						createPeopleId: createrId,
						famerId: famerId,
						pigType: pigType
					},
					success: function(dataAll) {
						if(dataAll.code == 0) {
							$(".addPig").val(null);
							$(".addPigType  option[value=''] ").attr("selected", true)
							$('.addPigTypeArea').addClass('none');
							$('.addPigIdArea').removeClass('none');
							layer.msg('新增成功');
							breedBetailsTable.ajax.reload();
							layer.close(breedDetail);
							var len = $("#breed_details_total").text()
							$("#breed_details_total").text(parseInt(len) + 1);
						} else {
							layer.msg(dataAll.message);
						}

					}
				});
			}
		}
	};
	//禁、启用
	$(document).on('click', '.statusBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var txt = $("#breed_details_status").text();
			var id = $('#breed_details_id').text();
			var statusTxt;
			if(txt == "disable" || txt == "禁用") {
				statusTxt = "启用";
			} else {
				statusTxt = "禁用";
			}
			var arrs = ['#breed_details_account', "#breed_details_status", '.statusBtn', '.tips']
			$.enabledOrDisabled(id, statusTxt, tableBreed, arrs)
		}
	});
	//修改
	$(document).on('click', '.editorBtn', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var txt = $("#breed_details_status").text();
			if(txt == "启用" || txt == "enable") {
				var tit = '修改养殖户'
				$.detailsEditor(tit);
			} else {
				layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			};
		}

	});
	//删除
	$(document).on('click', ".deleteBtn", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {

			var cellData = breedBetailsTable.row($(this).parents('tr')).data();
			var txt = $("#breed_details_status").text();
			if(txt == "启用" || txt == "enable") {
				$.showLayer({
					msg: '是否确认删除这条生猪信息？',
					y: function() {
						$.ajax({
							type: "post",
							async: true, //同步执行
							url: allUrl.farmsPigDelete,
							data: {
								sign: cellData.sign
							},
							success: function(data) {
								if(data.code == 0) {
									var start = $("#breedBetailsTable").dataTable().fnSettings()._iDisplayStart;
									var total = $("#breedBetailsTable").dataTable().fnSettings().fnRecordsDisplay();
									if((total - start) == 1) {
										if(start > 0) {
											breedBetailsTable.fnPageChange('previous', true);
										}
									} else {
										breedBetailsTable.draw(false);
									};

									layer.msg('删除成功');
									var len = $("#breedBetailsTable tbody").find('tr').length
									$("#breed_details_total").text(len - 1);

								} else {
									layer.alert(data.message, {
										skin: 'layui-layer-lan'
									});
								}
							}
						})
					}
				})
			} else {
				layer.alert("该账号已禁用，请启用后在操作", {
					skin: 'layui-layer-lan'
				})
			};

		}
	});
	//查看
	var pigListTable = "";
	$(document).on('click', ".lookBtn", function() {
		/*
		 * 1.获取点击行数据
		 * 2隐藏养殖户页面，打开生猪页面
		 * 3、生猪页面赋值，并请求table
		 **/
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var cellData = breedBetailsTable.row($(this).parents('tr')).data();
			var blockArry = [".pig_list", ".pig", ".details"];
			pigListTable = $.pigDetilas(blockArry, cellData, ".breed_details", ".detailsArea", ".pigArea");
		}
	});
	$(document).on('click', '.detailsArea', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			$(".pig_list,.pig,.breed_manage").addClass('none');
			$(".breed_details,.details").removeClass('none');
			$(".pigArea,.breedArea").removeClass('on');
			$(".detailsArea").addClass('on');
		}
	});
	//返回上一页
	$(document).on('click', '.backUpper-toggle', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var onTxt = $('.locationNav .on').text();
			if(onTxt == '生猪列表') {
				window.location.href = './breed_manage.html';
			} else if(onTxt == '生猪详情') {
				$('.detailsArea').click();
			}
		}
	})

	//移动扫二维码(显示苹果二维码)
	$('.appCode').on({
		mouseover: function() {
//			alert('苹果二维码')
			//			debugger;
		},
		mouseout: function() {
			//          debugger; 
		}
	})

	//移动扫二维码(显示安卓二维码)
	$('.androidCode').on({
		mouseover: function() {
//			alert('安卓二维码')
			//			debugger;
		},
		mouseout: function() {
			//          debugger; 
		}
	})

});