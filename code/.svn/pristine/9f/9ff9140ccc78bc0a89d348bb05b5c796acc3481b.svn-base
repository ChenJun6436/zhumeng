$.extend({

	/**
	 * @param {Object} evt 点击事件
	 * @param {Object} url 养殖户搜索地址
	 *  @param {Object} fele 搜索框的值
	 */
	farmerSearch: function(evt, url, data) {
		evt.preventDefault();
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: url,
			data: data,
			success: function(dataAll) {
				if(dataAll.code==0){
					$("#farmerName,#farmerId,#farmerPhone,#farmerAddress").text(null);
					$(".farmersList li").remove();
					$(".farmersList").removeClass("none");
					var dataList = dataAll.data;
					var liList = "";
					$.each(dataList, function(index, data) {
						liList += ('<li class="farmerLi"><span class="farmerName">' + (data.userName==undefined?data.name:data.userName) + '</span><span class="farmerId none">' + data.id + '</span>' +
							'<span class="farmerPhone none">' + data.phone + '</span><span class="farmerAddress none">' + data.address + '</span></li>')
					});
					$(".farmersList").append(liList);
					var h = $(".farmersList").height();
					if(h > 160) {
						$(".farmersList").addClass('scroll');
					}
					
				}else{
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}
				
			}
		});
	},
	/**
	 * 
	 * @param {Object} ele  事件对戏
	 * @param {Object} arry 需要赋值的对象
	 * @param {Object} fele 赋值完成后需处理的对象
	 * @param {Object} int 	输入框对象
	 * @param {Object} fele 输入框对象赋值对象
	 */
	searchAssignment: function(ele, int, intval, arry, fele,other) {
		$(int).val($(ele).find(intval).text());
		$.each(arry, function(index, arr) {
			$("#" + arr).html($(ele).find("." + arr).text())
		});
		$(fele).addClass("none");
		if(other==1){
			$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.butcherGetMaket,
			data: {
				marketId:$("#farmerId").text()
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$("#marketId option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.key + ">" + data.value + "</option>"

					});
					$("#marketId").append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
			
		}
	},
//	/**
//	 * 
//	 * @param {Object} ele      点击对象
//	 * @param {Object} status   获取状态的对象
//	 * @param {Object} account  获取账号的对象
//	 * @param {Object} fele     tips对象
//	 * @param {Object} url      后台地址
//	 * @param {Object} id       管理员id
//	 * @param {Object} table    父级table
//	 */
	detailsStatus: function(ele, status, id, account, fele, table, type) {
		// debugger;
		var txt = $(status).text();
		var account = $(account).text();
		var userId = $(id).text();
		if(userId === "") {
			userId = id;
		};
		if(txt===""){
			txt = status;
		};
		var statusTxt, status;
		if(txt == "禁用"||txt =="disable") {
			statusTxt = "启用";
			$(status).text("启用");
			status = "enable";
			if(type!=1){
				$(ele).css("background-image", "url(../src/images/filing/disable.png)");
				$(ele).prop("title", '启用')
			}
			
		} else {
			statusTxt = "禁用";
			$(status).text("禁用");
			status = "disable"
			if(type!=1){
				$(ele).prop("title", '禁用')
				$(ele).css("background-image", "url(../src/images/filing/enable.png)");
			}
		};

		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.butcherStatus,
			data: {
				id: userId,
				status: status
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					if(type == 1) {
						layer.msg(statusTxt + "成功");
						table.ajax.reload();
					} else {
						layer.tips('您' + statusTxt + '了' + account + '账号！', fele, {
							tips: [3, '#78BA32']
						});
					}

//					
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})

	},
	/**地址编辑*/

	detailsEditor: function(tit,h) {
		var hei=['1065px', '720px'];
		var addFiling = layer.open({
			type: 2,
			id: 'add-form',
			area:h==undefined?hei:h ,
			scrollbar: false,
			title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
			content: '../filing_manage/add_filing.html',
			btnAlign: 'c'
		});
	},
	pigDetilas: function(blockArry, cellData, details, detailsArea, pigArea) {
		$.each(blockArry, function(index, arr) {
			$(arr).removeClass('none');
		});
		$(details).addClass('none');
		$(detailsArea).removeClass('on');
		$(pigArea).addClass('on');
		var id
		if(cellData.sign==undefined||cellData.pigType==undefined){
			id=cellData.pigId;
			$('.pig-type').text(cellData.pigBreed);
		}else{
			id=cellData.sign;
			$('.pig-type').text(cellData.pigType);
		};
		$(".pig-id").text(id)
		/*
		 * 生猪详情
		 * 
		 * */
		var columnArrs = [ "thing", "status", "address", "description", "createrName", "createTime", "remark"];
		var columnDefArrs = [
		{
			targets:3,
	        orderable: false,
	        render: function (data) { 
	        return '<p title='+data+'>'+data+'</p>';
	        }
		}];
		var searchVal = null;

		var pigList = {
			id: "pigListTable",
			url:allUrl.indexGetPigTableDetails,
			searchParams: {
				pig_id:id
			},
			columns: columnArrs,
			lengthChange:false,
			columnDefs: columnDefArrs

		}
		return pigListTable = $.createTable(pigList);
	},
	pigDetails: function( cellData, details, detailsArea, pigArea){
		if(cellData.sign==undefined||cellData.pigType==undefined){
			id=cellData.pigId;
			$('.pig-type').text(cellData.pigBreed);
		}else{
			id=cellData.sign;
			$('.pig-type').text(cellData.pigType);
		};
		$(".pig-id").text(id);
		/*
		 * 生猪详情
		 * 
		 * */
		var columnArrs = [ "thing", "status", "address", "description", "createrName", "createTime", "remark"];
		var columnDefArrs = [
		{
			targets:3,
	        orderable: false,
	        render: function (data) { 
	        return '<p title='+data+'>'+data+'</p>';
	        }
		}];
		var pigList = {
			id: "pigListTable",
			url:allUrl.indexGetPigTableDetails,
			searchParams: {
				pig_id:id
			},
			columns: columnArrs,
			lengthChange:false,
			columnDefs: columnDefArrs

		}
		return pigListTable = $.createTable(pigList);
	},
	/**
	 * 
	 * @param {Object} arrys 需要赋值的对象数组
	 * @param {Object} cellData 点击行的数据
	 * @param {Object} ele 赋值的对象
	 * @param {Object} statusBtn 状态按钮对象
	 */
	adminInfoArea: function(arrys, cellData, ele, statusBtn) {
		$.each(arrys, function(i, arr) {
			if(arr == "status") {
				if(cellData.status == "enable" || cellData.status == "启用") {
					
					cellData.status = "启用"
					$(statusBtn).prop("title", '禁用')
					$(statusBtn).css("background-image", "url(../src/images/filing/disable.png)");
					
				} else {
					cellData.status = "禁用"
					$(statusBtn).prop("title", '启用')
					$(statusBtn).css("background-image", "url(../src/images/filing/enable.png)");
				}
			}
			if(arr == "farmType") {
				if(cellData.farmType == 0) {
					cellData.farmType = "个体"
				} else {
					cellData.farmType = "养殖户"
				}
			}
			$(ele + arr).text(cellData[arr]);
		});
	},
	/**部门加载
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	department: function(urls, ele) {
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.departmentId + ">" + data.departmentName + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
	/**角色加载
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	role: function(urls, ele) {
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.roleId + ">" + data.roleName + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}
			}
		})
	},
	/**生猪类型
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	pigType: function(urls, ele) {
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.id + ">" + data.name + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
		/**屠宰场
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	butcherSelect: function(urls, ele) {salesMarket
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.key + ">" + data.value + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
		/**销售市场
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	salesMarket: function(urls, ele) {
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.key + ">" + data.value + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
		/**销售市场
	 * 
	 * @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	salesMarket: function(urls, ele) {
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.key + ">" + data.value + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
	/**
	 * 
	 *  @param {Object} urls  后台路径
	 * @param {Object} ele   添加对象
	 */
	inspectorList:function(urls, ele) {
		$.ajax({
			type: "get",
			async: true, //同步执行
			url: urls,
			data: {},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					$(ele + " option").not(':first').remove();
					var options = "";
					$.each(dataAll.data, function(index, data) {
						options += "<option value=" + data.key + ">" + data.value + "</option>"

					});
					$(ele).append(options);
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}

			}
		})
	},
	/**搜索
	 * 
	 * @param {Object} ele 刷新的对应table
	 * @param {Object} obj 搜索值
	 */
	seacherFn: function(ele, obj) {
		ele.settings()[0].ajax.data = obj;
		ele.ajax.reload();
	},
	/*
	 * 禁用的处理
	 * */
	renderTable:function (data,k){
			if(k.status=="disable" || k.status=="禁用"){
				return '<span class="text-gary">'+data+'</span>'
			}else{
				return data
			}
		},

	
});