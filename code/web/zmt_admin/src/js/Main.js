//重新定义datatables的默认设置
$.extend($.fn.dataTable.defaults, {
	"searching": false, //不展示搜索框
	"pageLength": 10,
	"ordering": false,
	language: {
		"loadingRecords": "数据加载中...",
		"sProcessing": "处理中...",
		"sLengthMenu": "显示 _MENU_ 项结果",
		"sZeroRecords": "没有匹配结果",
		"sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
		"sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
		"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
		"sInfoPostFix": "",
		"sSearch": "搜索:",
		"sUrl": "",
		"sEmptyTable": "表中数据为空",
		"sLoadingRecords": "载入中...",
		"sInfoThousands": ",",
		"oPaginate": {
			"sFirst": "首页",
			"sPrevious": "上一页",
			"sNext": "下一页",
			"sLast": "末页"
		},
		"oAria": {
			"sSortAscending": ": 以升序排列此列",
			"sSortDescending": ": 以降序排列此列"
		}
	},
	"fnDrawCallback": function() {
		this.api().column(0).nodes().each(function(cell, i) {
			cell.innerHTML = i + 1;
		});
	},
});
/**
 * @param dom 添加时间插件的搜索栏的class
 * @param param 时间插件的属性值
 * @param {Object} datepicker
 */
$.extend({
	/**
	 * 
	 * @param {Object} settings 创建table的参数  REQUIRED
	 *  {
			id: REQUIRED table的id 
			url: REQUIRED 获取数据的地址 
			searchParams ： OPTIONAL  搜索参数
			columns: REQUIRED array  ["id", "name", "category"] table的column字段
		}
	 */

	createTable: function(settings) {
		var column = [{
			"data": null,
			"targets": 0
		}];
		$.each(settings.columns, function(index, col) {
			column.push({
				"data": col
			})
		});
		if('fnDrawCallback' in settings) {
			DrawCallback = settings.fnDrawCallback
		} else {
			DrawCallback = function() {
				if(this.api().column(0).nodes()){
					this.api().column(0).nodes().each(function(cell, i) {
					cell.innerHTML = i + 1;
					});
				}else{
					$('#'+this[0].id).DataTable().column(0).nodes().each(function(cell, i) {
					cell.innerHTML = i + 1;
					});
				}
				
				
			}
		}
		//点击行添加行背景色
		$('#' + settings.id + ' tbody').on('click', 'tr', function() {
			if($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				$('#' + settings.id + ' tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});

		//table添加hover高亮效果
		$("#" + settings.id).addClass("hover");
		var x = $("#" + settings.id).DataTable({
			"destroy": true,
			"serverSide": true,
			"async": true,
			"ajax": {
				"data": settings.searchParams,
				"url": settings.url,
				"type": settings.type == undefined ? "post" : settings.type,
				//				dataType:"jsonp",
				//				jsonp:'callback',
				//				xhrFields: {
				//					withCredentials: true
				//				},
			},

			"paging": settings.paging == undefined ? "true" : settings.paging,
			"info": settings.info == undefined ? "true" : settings.info,
			"scrollCollapse": settings.scrollCollapse == undefined ? "false" : settings.scrollCollapse,
			"scrollY": settings.scrollY == undefined ? "" : settings.scrollY,
			"scrollX": settings.scrollX == undefined ? "" : settings.scrollX,
			"lengthChange": settings.lengthChange == undefined ? true : settings.lengthChange,
			"columns": column,
			"columnDefs": settings.columnDefs == "undefined" ? [] : settings.columnDefs,
			"fnDrawCallback": DrawCallback,
		});
		$("#" + settings.id).on('xhr.dt', function(e, settings, json, xhr) {

			//			if((json.success != undefined) && (json.success == false)) {
			//				layer.alert(json.message, {
			//					skin: 'layui-layer-lan'
			//				}, function() {
			//					window.location.href = '/login/login.html'
			//				})
			//			}
		})
		return x;
	},

	/*登陆
	 * 
	 * ele:筛选类型select的class获取id
	 */

	login: function(ele) {
		var userInfo = sessionStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		if(userInfoArr != null) {
			//nav
			var userResources = userInfoArr.userResources;
			var navList = [];
			var spanArr = $('.sidebar-scroll nav span');
			var subPages = $('#subPages>ul>li>a');
			var butcherPages=$('#butcherPages>ul>li>a');
			var resNames = [];
			$.each(userResources, function(i, res) {
				resNames.push(res.resourceName);
			});
			for(var key in resNames) {
				if(resNames[key] == '地址管理' || resNames[key] == '角色管理' || resNames[key] == '生猪品种管理') {
					$.each(subPages, function(i, atext) {
						if($(atext).text() == resNames[key]) {
							$($(atext).parents('li').parents('li')[0]).removeClass('none');
							$($(atext).parents('li')[0]).removeClass('none');

						}
					});
				};
				if(resNames[key] == "屠宰场管理"|| resNames[key] == '屠宰场出入库数据') {
					$.each(butcherPages, function(i, atext) {
						if($(atext).text() == resNames[key]) {
							$($(atext).parents('li').parents('li')[0]).removeClass('none');
							$($(atext).parents('li')[0]).removeClass('none');

						}
					});
				};
				$.each(spanArr, function(i, spantext) {
					if($(spantext).text() == resNames[key]) {
						$($(spantext).parents('li')[0]).removeClass('none');
					}
				});

			};
			//type
			var typeArr = [];
			if(userInfoArr.typeId == "4ab39273-5c1b-4fd0-8f95-8126a1611f02") {
				typeArr = 'all';
				$.getType(typeArr, ele);
			} else if(userInfoArr.typeId == "e32edcdf-c914-48bc-8051-bc8e008aa5dc") {
				$(ele + ' option').remove();
				$(ele).prop('disabled', true);
				$(ele).append('<option  value="e32edcdf-c914-48bc-8051-bc8e008aa5dc">' + userInfoArr.typeName + '</option>');
			} else if(userInfoArr.typeId == "e998326a-0d16-46c5-9151-dcc617b507b4") {

				typeArr = ["e32edcdf-c914-48bc-8051-bc8e008aa5dc", "e998326a-0d16-46c5-9151-dcc617b507b4"];
				$.getType(typeArr, ele);
			}
			$('.admin-arrt').text(userInfoArr.loginName);
		} else {
			var title = $('title').text();
			var hrefUrl;
			layer.alert('请登录', {
				closeBtn: 0,
				skin: 'layui-layer-lan'
			}, function() {
				if(title == '首页') {
					hrefUrl = 'login/login.html'
				} else {
					hrefUrl = '../login/login.html'
				}
				window.location.href = hrefUrl;
			})
		}
	},
	//获取筛选类型
	getType: function(type, ele) {
		$.ajax({
			type: "post",
			url: allUrl.baseRoleTypeList,
			dataType: 'json',
			async: false,
			cache: false,
			xhrFields: {
				withCredentials: true
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + ' option').remove();
					var options = '<option value="">全部</option>';
					$.each(dataAll.data, function(i, data) {
						if(type == 'all') {
							options += '<option value=' + data.id + '>' + data.name + '</option>'
						} else {
							for(var key in type) {
								if(type[key] == data.id) {
									options += '<option value=' + data.id + '>' + data.name + '</option>'
								}
							}
						}
					});
					$(ele).append(options)

				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		});
	},
	//退出登录
	loginOut: function() {
		var title = $('title').text();
		var loginUrl;
		if(title == '首页') {
			loginUrl = 'login/login.html'
		} else {
			loginUrl = '../login/login.html'
		};
		layer.open({
			title: ['退出', 'background-color:#1FB5AD;color:white;'],
			btn: ['确定', '取消'],
			content: '是否退出登录？',
			closeBtn: 0,
			yes: function() {
				sessionStorage.removeItem('userInfo');
				window.location.href = loginUrl;
			}
		});
	},
	showLayer: function(setting) {
		layer.confirm(setting.msg, {
			btn: ['确定', '取消'], //按钮
			skin: 'layui-layer-lan'
		}, setting.y, setting.n);
	},

	//动态添加地址默认值
	selectedFn: function(elearry) {
		if(elearry != "" || elearry != undefined || elearry != null) {
			$.each(elearry, function(index, ele) {
				$(ele).append('<option value="">---请选择 ---</option>');
			});
		}
	},
	/*
	 * ele:id
	 * url:请求路径
	 * addr:判断请求参数，city：判断，获取市的参数province_id，district：判断，获取县的参数city_id：town：判断获取镇的参数district_id
	 * updata:修改时传过来做判断用
	 */
	addressFn: function(ele, url, addr, updata) {

		var prevId, data = "",
			figId = true;
		if($(ele).prev()[0]) {
			if($(ele).prev()[0].id == "") {
				prevId = $(ele).prev()[0].name;
			} else {
				prevId = $(ele).prev()[0].id;
			};

			var nextSelects = $(ele).nextAll();
			$.each(nextSelects, function(index, select) {
				var childrens = $(select).context.children;
				if(childrens.length > 1) {
					for(var i = childrens.length - 1; i > 0; i--) {
						if(i == 0) {
							return;
						} else {
							$(childrens)[i].remove();
						}
					}
				}
			});
			$(ele + " option").not(':first').remove();
		} else {
			var prevData = $(ele).parent().prev()[0].children[0];
			if(prevData != "" && prevData != undefined) {
				if(prevData.id == "") {
					prevId = prevData.name;
				} else {
					prevId = prevData.id;
				};
			}
			//			

			var nextSelects = $(ele).parent().nextAll();
			if(prevId != "" && prevId != undefined) {
				if(updata != 1) {

					var selectData, localNames, childrens;
					$.each(nextSelects, function(index, select) {
						selectData = $(select).children();
						localNames = $(select)[0].localName;

						if(selectData[0] != undefined) {
							if(selectData[0].nodeName == "SELECT") {
								childrens = selectData.children();
								if(childrens) {

									if(localNames == "th") {

										for(var i = childrens.length - 1; i > 0; i--) {
											if(i == 0) {
												return;
											} else {
												$(childrens)[i].remove();
											}
										}
									} else {

										for(var i = childrens.length; i > 0; i--) {
											selectData[0].options.remove(i - 1);
										}
										selectData.append('<option value="">---请选择 ---</option>')
									}

								}
							} else if(selectData[0].nodeName == "INPUT") {
								selectData[0].value = "";
							}
						}

					});
					if(localNames == "th") {
						$(ele + " option").not(':first').remove();
					} else {
						if(updata == 1) {

						} else {
							$(ele + " option").remove();
							$(ele).append('<option value="">---请选择 ---</option>')
							if($('.townsAdd')) {
								$('.townsAdd').val(null)
							}
						}
					}

				}
			}
		};
		if(prevId != "" && prevId != undefined) {

			//				var name= $("#" + prevId+ " option:selected").text();
			var id; //获取上级id;
			if(($("#" + prevId).val() != "" && $("#" + prevId).val() != undefined)) {
				id = $("#" + prevId).val();
			} else {
				id = $("." + prevId).val();
			};
			if(id == "" || id == undefined) {
				return false;
			};
			if(addr == "city") {
				data = {
					province_id: id
				}
			} else if(addr == "district") {
				data = {
					city_id: id
				}
			} else if(addr == "town") {
				data = {
					district_id: id
				}
			} else if(addr == "village") {
				data = {
					town_id: id
				}
			}
		}
		$.ajax({
			type: "post",
			async: false, //同步执行
			url: url,
			dataType: "json", //返回数据形式为json
			data: data,
			success: function(allData) {
				if(allData.code == 0) {
					var options = "";
					$.each(allData.data, function(index, data) {
						options += "<option value='" + data.key + "'>" + data.value + "</option>";
					});
					$(ele).append(options);
				} else {
					layer.alert(allData.message)
				}

			}
		})

	},
	//	/*table添加滚动条
	//	 * ele:指定table对象
	//	 * width：给出table的最小值
	//	 * fele：table的父级（也就是要添加滚动跳的对象）
	//	 */
	//
	//	tableScrollFn: function(table,wid) {
	//		var pTable = $(table).parent();
	//		var pTableWid=$(pTable).width();
	//		if(pTableWid>wid){
	//			$(pTable).removeClass('scrollX');
	//		}else{
	//			$(pTable).addClass('scrollX');
	//		}
	//		
	//	},

	/*
	 * ztree区域选择
	 * eleId为ul的id
	 * ztree的创建必须是个ul ul的class必须是ztree
	 */

	areaSelect: function(eleId, userId) {
		//配置ztree的基本信息
		var setting = {
			async: {
				enable: true,
				url: allUrl.getAreaByUserId,
				autoParam: ["id", "type"],
				dataFilter: filter,
				otherParam: ["user_id", userId],
				type: "post"
			},
			check: {
				enable: true,
				autoCheckTrigger: false,
				chkboxType: {
					"Y": "p",
					"N": "s"
				}
			},
			view: {
				expandSpeed: "",
				showLine: false,
				showIcon: false
			},
			callback: {
				onCheck: zTreeOnCheck,
				onCollapse: zTreeOnCollapse,
				onExpand: zTreeOnExpand
			}

		};
		/*过滤数据 
		 * lean为0则还有末端节点，为1则为最后一个子节点
		 * 
		 * */
		function filter(treeId, parentNode, childNodes) {
			//在这里处理请求返回的数据
			var areaArray = childNodes.data;
			if(!areaArray) return null;
			for(var i = 0, l = areaArray.length; i < l; i++) {
				areaArray[i].name = areaArray[i].name.replace(/\.n/g, '.');
				//当父级选中的时候，异步加载出来的数据也全部选中
				//				if(parentNode!=undefined){
				//					if(parentNode.checked ==true){
				//						childNodes[i].checked = parentNode.checked;
				//						childNodes[i].checkedEx = true;
				//					}
				//				};
				//判断是否是最底层
				if(areaArray[i].lean == true) {
					areaArray[i].isParent = true;
				} else {
					areaArray[i].isParent = false;
				};

				//编辑时根据根据后台返回节点的id来选中已有的节点
				if(treeAll != undefined) {
					$.each(treeAll, function(index, e) {
						for(a in e) {
							if(e[a] == areaArray[i].id) {
								areaArray[i].checked = true;
							}
						}

					});
					//					$('.counts').text("(" + treeAll.length + ")");
				}
			}
			return areaArray;
		};
		/**折叠的事件
		 * event    js event 对象
		 * treeId   对应 zTree 的 treeId，便于用户操控
		 * treeNode 被展开的节点 JSON 数据对象
		 */
		function zTreeOnCollapse(event, treeId, treeNode) {
			var tId = treeNode.tId;
			
			if(!tId) return null;
			var parentTId=treeNode.parentTId;
			var parentUl;
			if(parentTId==null){
				parentUl=("#"+tId)
//				h = $("#"+tId+'>.showTreeboxDfl').height();
			
			}else{
				parentUl=("#"+parentTId)
				
			}
			var h = $(parentUl+'>.showTreeboxDfl').height();

			if(h< 500) {
				$(parentUl+'>.showTreeboxDfl').removeClass('overflow-y');
			} 

		};
		/**展开的事件
		 * event    js event 对象
		 * treeId   对应 zTree 的 treeId，便于用户操控
		 * treeNode 被展开的节点 JSON 数据对象
		 */
		var zIdex=9999;
		function zTreeOnExpand(event, treeId, treeNode) {
			var tId = treeNode.tId;
			if(!tId) return null;
			var parentTId=treeNode.parentTId;
			if(parentTId==null){
				$("#"+tId+'>ul').addClass('showTreeboxDfl');
			}
			var h;
			if($('.showTreeboxDfl')){
				zIdex++;
				var parentUl;
				if(parentTId==null){
					parentUl=("#"+tId);
//					$("#"+tId+'>.showTreeboxDfl').css('z-index',zIdex);
//					h = $("#"+tId+'>.showTreeboxDfl').height();
//					if(h > 510) {
//						$("#"+tId+'>.showTreeboxDfl').addClass('overflow-y');
//					} 
				}else{
					parentUl=("#"+parentTId);
//					$("#"+parentTId+'>.showTreeboxDfl').css('z-index',zIdex);
//					h = $("#"+parentTId+'>.showTreeboxDfl').height();
//					if(h > 510) {
//						$("#"+parentTId+'>.showTreeboxDfl').addClass('overflow-y');
//					} 
				}
				$(parentUl+'>.showTreeboxDfl').css('z-index',zIdex);
				h = $(parentUl+'>.showTreeboxDfl').height();
				if(h > 510) {
					$(parentUl+'>.showTreeboxDfl').addClass('overflow-y');
				} 
			}
			
		};
		//点击子节点的事件
		function zTreeOnCheck(event, treeId, treeNode) {
			treeAll = "";
			//获取所有选中节点的值
			var treeObj = $.fn.zTree.getZTreeObj(eleId);
			var gNode = treeObj.getNodesByFilter(function(node) {
				return node.level == 0
			});
			var allNode = treeObj.transformToArray(treeObj.getNodes()); //当前所有的checkbox(不管选没选中)
			var curAllParentNodes = treeNode.getPath(); //当前选中checkbox的所有父集（并包括自己）
			var num = 0;
			if((treeNode.getParentNode()) != null) {
				var xd = treeNode.getParentNode().children; //(当当前节点有父节点的时候)获取当前节点的所有的兄弟节点
				var flag = true;
				//获取当前选中节点的兄弟节点
				$.each(xd, function(index, e) {
					if(e.checked) {
						flag = false;
						if(e.id != treeNode.id) {
							curAllParentNodes.push(e) //此时的curAllParentNodes为选中节点的父节点以及同级的兄弟节点
						}
						num += 1;
					}
				});
				if(flag) {
					num = 1;
				}
			} else {
				if(treeNode.checked) {
					num = 1;
				} else {
					num = 0;
				}

			}

			//判断只能选择同级的节点
			$.each(allNode, function(index, event) {
				var falg = false;
				$.each(curAllParentNodes, function(i, e) {
					if(event.id == e.id) {
						falg = true;
						return false;
					}
				});
				if(falg == false) {
					if(treeNode.level > 0) {
						treeObj.checkNode(event, false);
						$.each(gNode, function(ine, ev) {
							var eid;
							$.each(curAllParentNodes, function(inex, eve) {
								if(eve.level == 0) {
									eid = eve.id;
								}
							});
							if(ev.id != eid) {
								$("#" + ev.tId)[0].children[2].innerHTML = "(" + 0 + ")"
							}
						});
					} else {
						if(event.level != 0) {
							treeObj.checkNode(event, false);
						} else {
							if(event.checked) {
								$("#" + event.tId)[0].children[2].innerHTML = "(" + 1 + ")"
							}
						};
					};
				}
			});
			var pNodes = $("#" + treeNode.tId).parents() //获取当前选中节点的所有父节点
			var curParents, firstParent; //节点的level为0的父节点
			curParents = $("#" + treeNode.tId).parents('#' + treeId);
			$.each(curAllParentNodes, function(i, e) {
				if(e.level == 0) {
					firstParent = $("#" + e.tId)[0];
					firstParent.children[2].innerHTML = "(" + num + ")"
				};
			});
		};

		//创建ztree
		var zTreeObj = $.fn.zTree.init($("#" + eleId), setting);
		return zTreeObj;
	},

	/*
	 * ztree多选框区域选择获取已选中省市区镇乡的id
	 * tree 为ztree
	 * 
	 */

	getSelectedAreaId: function(tree) {
		var nodes = tree.getCheckedNodes(true);
		var newArray = []; //用来放所有选中区域的id
		var areaList = []; //用来放传给后台的区域id（最终的叶子节点）
		//循环获取所选中区域的id
		$.each(nodes, function(index, node) {
			newArray.push({
				areaId: node.id,
				type: node.type,
				areaName: node.name
			})
		});
		//循环判断是否有子节点以及子节点是否被选中，来添加区域的id
		$.each(nodes, function(index, node) {
			var childrenNodes = node.children;
			var nodeChildChd = true;
			if(childrenNodes) {
				for(var m = 0; m < childrenNodes.length; m++) {
					if(childrenNodes[m].checked) {
						nodeChildChd = false;
					}
				}
				if(nodeChildChd) {
					areaList.push({
						areaId: node.id,
						type: node.type,
						areaName: node.name
					})
				}
			} else {
				areaList.push({
					areaId: node.id,
					type: node.type,
					areaName: node.name
				})
			}

		});
		return areaList;
	},

	/*
	 * 可用权限的选择 
	 * id ul为元素的id
	 * data ajax请求的数据，类型为一个数组对象
	 */
	limitSelect: function(id, data) {
		var limitBox = $('#' + id);
		$.ajax({
			type: 'post',
			url: allUrl.getLimitOfRoleId,
			async: false,
			data: data,
			success: function(data) {
				var options = '';
				$('#' + id + '>li').remove();
				$.each(data.data, function(key, val) {
					var firstSelectImg = val.type == '0' ? '../src/images/public/choise3.png' : '../src/images/public/choise2.png';
					var secondSelectImg = val.type == '1' ? '../src/images/public/choise3.png' : '../src/images/public/choise2.png';
					options += '<li><span><img src="../src/images/public/choise4.png" alt="" />' + val.resourceName + '</span><span><img class="firstRadioImg" src="' + firstSelectImg + '" alt="" />查看/使用</span><span><img class="secondRadioImg" src="' + secondSelectImg + '" alt="" />查看</span></li>'

				});
				//				var box = '<ul id="newAddPeoLimit">' + options + '</ul>'
				limitBox.append(options);
			}

		});
	},

	/*
	 * select选择框
	 * setting为参数
	 * setting.url 为请求路径
	 * setting.type为请求的类型
	 * setting.id 为select元素的id
	 * setting.data ajax请求的数据
	 * setting.allName  显示的全部
	 */
	selectBox: function(setting) {
		var limitBox = $('#' + setting.id);
		$.ajax({
			type: setting.type,
			url: setting.url,
			async: false,
			data: setting.data,
			success: function(data) {
				if(data.code == '0') {
					$('#' + setting.id + '>option').remove();
					if(setting.allName != undefined) {
						var options = '<option value="all"> ' + setting.allName + '</option>';
					} else {
						var options = '';
					}
					$.each(data.data, function(key, val) {
						options += '<option value="' + val.id + '">' + val.name + '</option>'
					});
					limitBox.append(options);
				}
			}
		});
	},

	/*
	 * 公用的禁用启用方法
	 * params
	 * id:为该条数据用户的id
	 * textState 为当前数据的状态
	 * testCenterTable 为当前需要刷新数据的表格
	 * 
	 */
	enabledOrDisabled: function(id, textState, testCenterTable, arrs) {
		$.ajax({
			url: allUrl.accManIsDisabled,
			type: "post",
			data: {
				user_id: id,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					if(arrs != undefined) {
						var acc = $(arrs[0]).text();
						if(textState == "启用") {
							$(arrs[2]).prop("title", '禁用');
							$(arrs[2]).css("background-image", "url(../src/images/filing/disable.png)");
							$(arrs[1]).text("启用");

						} else {

							$(arrs[1]).text("禁用");
							$(arrs[2]).prop("title", '启用');
							$(arrs[2]).css("background-image", "url(../src/images/filing/enable.png)");

						};

						layer.tips('您' + textState + '了' + acc + '账号！', '.tips', {
							tips: [3, '#78BA32']
						});
					} else {
						layer.msg(textState + '成功！');
					}
					testCenterTable.ajax.reload();

				} else {
					layer.closeAll();
					layer.msg(data.message);
				}
			}
		})
	},

	/*
	 * 重置密码（公用方法）
	 * id为当前的用户的id（该条数据）
	 */
	resetPassword: function(id) {
		$.ajax({
			url: allUrl.accManresetPassword,
			type: "post",
			data: {
				user_id: id,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					layer.closeAll();
					layer.msg('重置密码成功！')
				} else {
					layer.closeAll();
					layer.msg(data.message);
				}
			}
		})
	},
	/*
	 * 下拉选择地址的默认地址（编辑时使用）
	 * url 为请求的路径
	 * preEleId 为上一级的元素id
	 * curId  为当前需要渲染的id
	 * id 为传给后台的参数名
	 * ajaxKey 传给后台的id 的key
	 */
	morenArea: function(url, preEleId, curId, ajaxKey) {
		var curId1 = ajaxKey + '_id';
		var ajaxData = {
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612',
		}
		ajaxData[curId1] = $('#' + preEleId).val()
		$.ajax({
			url: url,
			type: 'post',
			async: false, //同步执行
			data: ajaxData,
			success: function(data) {
				var options = '';
				if(data.code == '0') {
					$.each(data.data, function(index, val) {
						options += '<option value="' + val.key + '">' + val.value + '</option>'
					});
					$('#' + curId).append(options)
				} else {
					layer.msg(data.message)
				}
			}
		})
	},

	/*
	 * 根据当前的typeid 和部门的id来加载当前角色下的数据（新增人员中使用）
	 */
	getRoleOfDepartmentAndRole: function() {
		$.ajax({
			type: 'post',
			url: allUrl.getRoleListAll,
			async: false,
			data: {
				typeId: $('#accountAllType').val(),
				departmentId: $('#departmentOfType').val(),
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					$('#roleOfDepartment>option').remove();
					var options = '';
					$.each(data.data, function(key, val) {
						options += '<option value="' + val.roleId + '">' + val.roleName + '</option>'
					});
					$('#roleOfDepartment').append(options);
				}
			}
		});
	},

	/*
	 * //根据type来的id来选择部门（新增人员中使用）
	 */
	getdepartmentList: function() {
		$.ajax({
			type: 'post',
			url: allUrl.departmentList,
			async: false,
			data: {
				typeId: $('#accountAllType').val(),
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				if(data.code == '0') {
					$('#departmentOfType>option').remove();
					var options = '';
					$.each(data.data, function(key, val) {
						options += '<option value="' + val.departmentId + '">' + val.departmentName + '</option>'
					});
					$('#departmentOfType').append(options);
				} else {
					layer.alert(data.message, {
						skin: 'layui-layer-lan'
					});
				}
			}
		});
	},

	/*
	 * 	//根据roleID获取权限 （新增人员中使用）
	 */
	getLimitByRoleId: function() {
		//加载相关的权限
		var limitAjaxData = {
			roleId: $('#roleOfDepartment').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
		}
		$.limitSelect('newAddPeoLimit', limitAjaxData)
	},

	/*
	 * 电话号码的验证
	 * 
	 */
	isPhone: function(phone) {
		var phoneFlag = true;
		if(!(/^1[34578]\d{9}$/.test(phone))) {
			layer.alert("手机号码有误，请重填");
			phoneFlag = false;

		}
		return phoneFlag;
	},
	/*
	 * 判断是否当前账号下的资源是否有操作的权限
	 */
	isRloe: function(curName) {
		var userInfo = sessionStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		var allUserResources = userInfoArr.userResources;
		var isLook;
		$.each(allUserResources, function(index, even) {
			if(curName == even.resourceName) {
				isLook = even.type;
			}

		});
		return isLook;

	},
	/*
	 * 根据用户id，验证用户是否被禁用，或者被删除
	 */
	verifyById: function(userId) {
		var fig = false;
		$.ajax({
			type: 'post',
			url: allUrl.verifyById,
			async: false,
			data: {
				user_id: userId,
				timestamp: 1508998573824,
				token: 'b01ad47000d0b2b719fe390ae15e8612'
			},
			success: function(data) {
				var title = $('title').text();
				var hrefUrl;
				if(data.code != 0) {
					if(data.code == '207') {
						layer.alert(data.message, {
							skin: 'layui-layer-lan',
							closeBtn: 0
						}, function() {
							if(title == '首页') {
								hrefUrl = 'login/login.html'
							} else {
								hrefUrl = '../login/login.html'
							}
							sessionStorage.removeItem('userInfo');
							window.location.href = hrefUrl;

						});
					} else {
						layer.alert(data.message, {
							skin: 'layui-layer-lan',

						});
					}
				} else {
					fig = data.data;
				}

			}
		});
		return fig;
	},
	
	/*
	 * 当前用户只有查看权限时，隐藏可操作的按钮
	 * hiddenClsName 需要隐藏的操作按钮的classname或者id
	 */
	hiddenOperateBtn:function(hiddenClsName){
		$.each(hiddenClsName,function(index,even){
			$(even).removeClass('none')
		})	
	}
});