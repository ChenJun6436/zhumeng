/**
 * Created by dev on 2017/9/26.
 *
 *
 * 模块：新建建档管理
 */
var treeAll;
$(document).ready(function() {

	//类型，部门，角色
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	$("#choose_type").prop('disabled', true);
	$('#choose_type').append('<option value=' + userInfoArr.typeId + '>' + userInfoArr.typeName + '</option>');
	if(userInfoArr.roleCode == 'admin') {//roleCode是admin时，部门角色可选
		//获取所有部门
		var getAllType = $('#choose_type').val();
		if(getAllType == "") {
			layer.alert("请选择类型", {
				skin: 'layui-layer-lan'
			});
			return false;
		} else {
			var typeSetting = {
				url: allUrl.getlistOfDepartment,
				type: 'post',
				id: 'choose_department',
				data: {
					typeId: getAllType,
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612'
				}
			};
			$.selectBox(typeSetting);
			getAllDepartment();
		};

	};
	if(userInfoArr.departmentCode=="dp0001"){//判断是否为建档，是部门角色可选
			var xialaBumenSet = {
				url: allUrl.jiandangbuMessage,
				type: "post",
				id: "choose_department",
				data: {
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612',
					typeId: userInfoArr.typeId
				}
			}
			$.selectBox(xialaBumenSet); //请求部门

			getAllDepartment();//请求角色
	}else{
		if(userInfoArr.roleCode=="bmadmin"){//roleCode是bmadmin时，角色可选，部门不可选
		
			$("#choose_department").append('<option value=' + userInfoArr.departmentId + '>' + userInfoArr.departmentName + '</option>')
			$("#choose_department").prop('disabled', true);
			getAllDepartment();
		
		
		}else{//roleCode不是admin，departmentId也不是dp0001，roleCode不是bmadmin时，默认选择
			if(userInfoArr.roleCode!="admin"){
				var InfoArr = ['department', 'role'];
				$.each(InfoArr, function(i, info) {
					$("#choose_" + info).prop('disabled', true);
					$("#choose_" + info).append('<option value=' + userInfoArr[info + 'Id'] + '>' + userInfoArr[info + 'Name'] + '</option>')
				});
			}
		}
	};
	
	
	//获取角色
	$(document).on('change', '#choose_department', function() {
		getAllDepartment();

	});
	//改变角色
	$(document).on('change', '#choose_role,#choose_department', function() {
		if(pTitle == "新建档案管理员") {
			newAddPeoLimitFn(100,1);
		};
		if(pTitle == "新建养殖户"||pTitle == "新增屠宰场人员") {
		newAddPeoLimitFn(180,1);
		};
	});

	function getAllDepartment() {
		var getDepartment = $('#choose_department').val();
		if(getDepartment == "") {
			layer.alert("请选择部门", {
				skin: 'layui-layer-lan'
			});
			return false;
		} else {
			var departmentSetting = {
				url: allUrl.getRoleSelectList,
				type: 'post',
				id: 'choose_role',
				data: {
					departmentId: getDepartment,
					timestamp: 1508998573824,
					token: 'b01ad47000d0b2b719fe390ae15e8612'
				}
			};
			$.selectBox(departmentSetting);
		}
	};
	$.addressFn("#province", allUrl.find_province_option);
	var table = $(parent.$("#add-form")[0]).parents();
	var pTitle = $(parent.$("#add-form")[0]).parent().text();
	
	
	if(pTitle == "新建档案管理员") {
		newAddPeoLimitFn(100);
		$('.last-step').css({
			'height': '550px'
		});
	};
	if(pTitle == "新建养殖户") {
		$('input[name=famerId]').get(0).checked = true;
		$('.filingAddLeft,.filingAddRight').css('margin-top', '30px');
		$('.last-step').css({
			'height': '600px'
		});
		$('.framsTyep').removeClass('none');
		newAddPeoLimitFn(180)
	}
	if(pTitle == "新增屠宰场") {
		$('.basicData,.jurisdiction,.name,.default_generated').addClass('none');
		$('.filingAddLeft').css({'margin':'0px 0px 0px 60px','height':'320px','padding-top':'0px'});
		$('.filingAddRight').css({'margin-top':'20px','height':'380px'});
		$(".butcherAdd,.principal").removeClass("none");
		$('.btn-colse').css('margin-right','0px');
		$(".btnAdd").text("确定添加");
	};
	if(pTitle == "新增屠宰场人员") {
		newAddPeoLimitFn(180);
		$('.last-step').css({
			'height': '600px'
		});
		var rowData=JSON.parse($(table.find('.rowData')).text());
		$(".butcherAdd").removeClass("none");
		$("#butcherAdd").val(rowData.name).prop('disabled', true);
	};
	//修改档案管理员
	if(pTitle == "修改档案管理员") {
		var rowData=JSON.parse($(table.find('.rowData')).text());
		$('#name').val(rowData.name);
		if(rowData.phone==undefined){
			$("#tel").val(rowData.tel);
		}else{
			$("#tel").val(rowData.phone);
		}
		
		
		filingEditorFn(rowData);
	};
	//修改养殖户
	if(pTitle == "修改养殖户") {
		var rowData=JSON.parse($(table.find('.rowData')).text());
		$('.last-step').css({
			'height': '600px'
		});
		if(rowData.id==undefined){
			rowData.id=rowData.userId
		}
		if(rowData.userName==undefined){
			$('#name').val(rowData.name);
		}else{
			$('#name').val(rowData.userName);
		}
		if(rowData.phone==undefined){
			$("#tel").val(rowData.tel);
		}else{
			$("#tel").val(rowData.phone);
		}
		if(rowData.fooderName==undefined){
			$("#feed").val(rowData.feed)
		}else{
			$("#feed").val(rowData.fooderName)
		}
		
		$('.filingAddLeft,.filingAddRight').css('margin-top', '30px');
		
		$('.framsTyep').removeClass('none');
		var famerIdVal=parseInt(rowData.farmType);
		$('input[name=famerId]').get(famerIdVal).checked = true;
		if(famerIdVal==1){
			$($('input[value="1"]').parent().find('img')).prop('src','../src/images/public/choise3.png');
			$($('input[value="0"]').parent().find('img')).prop('src','../src/images/public/choise2.png')
		}
		
		filingEditorFn(rowData);
	};
	//修改屠宰场
	if(pTitle == "修改屠宰场") {
		$('.filingAddLeft').css({'margin':'0px 0px 0px 60px','height':'320px','padding-top':'0px'});
		$('.filingAddRight').css({'margin-top':'20px','height':'380px'});
		$('.btn-colse').css('margin-right','0px');
		var rowData=JSON.parse($(table.find('.rowData')).text());
		$('.basicData,.jurisdiction,.name,.default_generated').addClass('none');
		$(".butcherAdd,.principal").removeClass("none");
		$(".btnAdd").text("保存");
		$('#principal').val(rowData.principalName);
		if(rowData.phone==undefined){
			$("#tel").val(rowData.tel);
		}else{
			$("#tel").val(rowData.phone);
		}
		
		$("#butcherAdd").val(rowData.name)
		
		filingEditorFn(rowData);
	};
	//修改屠宰场人员
	if(pTitle == "修改屠宰场人员") {
		var rowData=JSON.parse($(table.find('#butcher_details_rowData')).text());
		$('.last-step').css({
			'height': '600px'
		});
		$(".btnAdd").text("保存");
		$(".butcherAdd").removeClass("none");
		var butcherName =$(table.find('#butcher_personnel_name')).text(); 
		if(butcherName==""){
			butcherName=rowData.slaughterhouseName
		}
		$("#butcherAdd").val(butcherName).prop('disabled', true);
		
		if(rowData.userName==undefined){
			$('#name').val(rowData.name);
		}else{
		$('#name').val(rowData.userName);
		}
		
		if(rowData.phone==undefined){
			$("#tel").val(rowData.tel);
		}else{
			$("#tel").val(rowData.phone);
		}
		filingEditorFn(rowData);
	};
	function newAddPeoLimitFn(hei,role){
		var limitAjaxData;
		if(role==1){
			limitAjaxData = {
			roleId: $('#choose_role').val(),
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}else{
			limitAjaxData = {
			roleId: userInfoArr.roleId,
			timestamp: 1508998573824,
			token: 'b01ad47000d0b2b719fe390ae15e8612'
			}
		}
		 
		$.limitSelect('newAddPeoLimit', limitAjaxData);
		//
		if($("#newAddPeoLimit").height() > hei) {
			$("#newAddPeoLimit").css({
				'height': hei+'px',
				'overflow': 'auto'
			})
		};
	}
		
	
	
	//修改档案管理员
	
	function filingEditorFn(rowData) {
		
		$('.jurisdiction').addClass('none');
		$(".btnAdd").text("保存");
		addressDefaultValue(rowData);
		var userId;
		if(rowData.id==null){
			userId=rowData.userId
		}else{
			userId=rowData.id
		}
		if(pTitle == "修改屠宰场"){
			return false;
		}else{
			$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.getUserInfo,
			data: {userId:userId},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					var InfoArr = ["type",'department', 'role'];
					var data=dataAll.data;
					$.each(InfoArr, function(i, info) {
						$("#choose_" + info+" option").remove();
						$("#choose_" + info).append("<option value="+data[info+"Id"]+">"+data[info+"Name"]+"</option>")
						$("#choose_" + info).prop('disabled', true);
					
				});

				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					})
				}

			}
			})
		}
	};
	//修改地址默认赋值
	function addressDefaultValue(rowData){
		if(rowData.provinceId!=null){
			$("#province option").each(function(i){
				if(this.value==rowData.provinceId){
					$("#province  option[value="+rowData.provinceId+"] ").prop("selected",true);
				}
			 
			});
		}
		if(rowData.cityId==null){
			$.addressFn("#city", allUrl.find_city_option, "city");
		}else{
			$.addressFn("#city", allUrl.find_city_option, "city");
			$("#city option").each(function(i){
				if(this.value==rowData.cityId){
					$("#city  option[value="+rowData.cityId+"] ").prop("selected",true);
				}
			 
			});
		}
		if(rowData.districtId==null){
			$.addressFn("#district", allUrl.find_district_option, "district");
		}else{
			$.addressFn("#district", allUrl.find_district_option, "district");
			$("#district option").each(function(i){
				if(this.value==rowData.districtId){
					$("#district  option[value="+rowData.districtId+"] ").prop("selected",true);
				}
			 
			});
		}
		 if(rowData.townId==null){
			$.addressFn("#town",allUrl.find_town_option,"town");
		}else{
			$.addressFn("#town",allUrl.find_town_option,"town");
			$("#town option").each(function(i){
				if(this.value==rowData.townId){
					$("#town  option[value="+rowData.townId+"] ").prop("selected",true);
				}
			 
			});
		}
		if(rowData.villageId==null){
			$.addressFn("#village", allUrl.find_village_option, "village");
		}else{
			$.addressFn("#village", allUrl.find_village_option, "village");
			$("#village option").each(function(i){
				if(this.value==rowData.villageId){
					$("#village  option[value="+rowData.villageId+"] ").prop("selected",true);
				}
			 
			});
		}
	};
	//地址
	$("#province,#city,#district,#town,#village").change(function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var selectId = $(this)[0].id;
			switch(selectId) {
				case "province":
					$.addressFn("#city", allUrl.find_city_option, "city");
					break;
				case "city":
					$.addressFn("#district", allUrl.find_district_option, "district");
					break;
				case "district":
					$.addressFn("#town",allUrl.find_town_option,"town");
					break;
				case "town":
					$.addressFn("#village", allUrl.find_village_option, "village");
					break;
			}
		}
		

	});
	//	//权限 单选
	$(document).on('click', '.radioChecked', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
		var imgUrl = $(this).attr("src");
		var ipt = $(this).parent().find('input');
		var names = $(ipt).attr('name');
		var ipts = $('input[name=' + names + ']');
		var pImg;
		for(var i = 0; i < ipts.length; i++) {
			pImg = $(ipts[i]).prev().prev();
			if($(pImg).attr("src") != imgUrl) {
				$(pImg).attr("src", '../src/images/public/choise2.png');
			}
		}
		if(imgUrl == '../src/images/public/choise2.png') {
			$(this).attr("src", '../src/images/public/choise3.png');
			$(ipt).prop("checked", true);
		} else if(imgUrl == '../src/images/public/choise3.png') {
			$(this).attr("src", '../src/images/public/choise3.png');
			$(ipt).prop("checked", true);
		} else {
			$(this).attr("src", '../src/images/public/choise2.png');
			$(ipt).prop("checked", false);
		}
		}
	});
	//取消
	$(document).on('click', ".btn-colse", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
		var txt = $(this).text();
		if(txt == "取消") {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		} else {
			$(".last-step").css("display", "block");
			$(".next-step").css("display", "none");
			$(".btnAdd").text("下一步");
			$(this).text("取消");
		}
	}
	});
	//验证手机号
	var telFig = true;
	$(document).on('blur', "#tel", function() {
		var phone = $.trim($("#tel").val());
		if(!(/^1[34578]\d{9}$/.test(phone)) && phone != "") {
			layer.alert("请输入正确的手机号", {
				skin: 'layui-layer-lan'
			});
			$("#tel").css('border', '1px solid red');
			telFig = false;
		} else {
			telFig = true;
		}
	});
	var tableLaode;
	//下一步
	$(document).on('click', ".btnAdd", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
		var txt = $(this).text();
		if(txt == "下一步") {
			$(".last-step").css("display", "none");
			$(".next-step").css("display", "block");
			$(this).text("确定添加");
			$(".btn-colse").text("上一步");
			selectTree = $.areaSelect("permissionAddr",userInfoArr.userId);

		} else if(txt =='确定添加') {
			var addUrl, areaList;
			var dataObj = {
				currentUserId: userInfoArr.userId,
				typeId: $('#choose_type').val(),
				departmentId: $('#choose_department').val(),
				roleId: $('#choose_role').val(),
				villageId: $('#village').val(),
				townId: $("#town").val(),
				districtId: $("#district").val(),
				cityId: $("#city").val(),
				provinceId: $("#province").val(),
				name: $.trim($("#name").val()),
				tel: $.trim($("#tel").val()),
				principalName: ''
			};
			if(pTitle == "新建档案管理员") {
				addUrl = allUrl.findFileManageAdd;
				areaList = $.getSelectedAreaId(selectTree);
				dataObj.areas = JSON.stringify(areaList);
				if(dataObj.tel == "") {
					$("#tel").css('border', '1px solid red');
					layer.alert("请输入电话号码", {
						skin: 'layui-layer-lan'
					});
					return false;
				}
				tableLaode = parent.$('#tableFilingM').DataTable();
			} else if(pTitle == "新建养殖户") {
				other = 1;
				addUrl = allUrl.farmsAdd
				dataObj.feed = $.trim($("#feed").val());
				if($("input[name=famerId]").prop("checked")) {
					dataObj.farmType = 0
				} else {
					dataObj.farmType = 1;
				}
				areaList = $.getSelectedAreaId(selectTree);
				dataObj.areas = JSON.stringify(areaList);
				if(dataObj.tel == "") {
					$("#tel").css('border', '1px solid red');
					layer.alert("请输入电话号码", {
						skin: 'layui-layer-lan'
					});
					return false;
				}
				tableLaode = parent.$('#breedManage').DataTable();
			} else if(pTitle == "新增屠宰场") {
				addUrl = allUrl.butcherAdd;
				dataObj.currentUserId = "";
				dataObj.typeId = "";
				dataObj.departmentId = "";
				dataObj.roleId = "";
				dataObj.phone = dataObj.tel;
				dataObj.tel = "";
				dataObj.name = $('#butcherAdd').val();
				dataObj.principalName = $('#principal').val();
				dataObj.creatorId = userInfoArr.userId;
				if(dataObj.principalName == "") {
					$("#principal").css('border', '1px solid red');
					layer.alert("请输入负责人", {
						skin: 'layui-layer-lan'
					});
					return false;
				} else if(dataObj.phone == "") {
					$("#tel").css('border', '1px solid red');
					layer.alert("请输入电话号码", {
						skin: 'layui-layer-lan'
					});
					return false;
				} else if(dataObj.districtId == "") {
					layer.alert("请选择地址到县或区", {
						skin: 'layui-layer-lan'
					});
					return false;
				} else {
					var addressArr = ["province", "city", "district", "town", "village"];
					var d = "";
					$.each(addressArr, function(i, add) {
						d += $("#" + add + " option:selected").text();

					});
					dataObj.address = d.split('-')[0];
					$("#principal,#tel").css('border', '');
				}
				tableLaode = parent.$('#tableButcherM').DataTable();
			} else if(pTitle == '新增屠宰场人员') {
			
				addUrl = allUrl.findFileManageAdd;
				areaList = $.getSelectedAreaId(selectTree);
				dataObj.areas = JSON.stringify(areaList);
				if(dataObj.tel == "") {
					$("#tel").css('border', '1px solid red');
					layer.alert("请输入电话号码", {
						skin: 'layui-layer-lan'
					});
					return false;
				};
			}

			for(var key in dataObj) {
				if(dataObj[key] === "") {
					delete dataObj[key];
				}
			}
			if(dataObj.name == undefined) {
				$("#name,#butcherAdd").css('border', '1px solid red');
				layer.alert("请输入名称", {
					skin: 'layui-layer-lan'
				});
				return false;
			} else if(dataObj.areas == "[]") {
				$('.basic-Info').css('color', 'red');
				layer.alert("请选择可用权限", {
					skin: 'layui-layer-lan'
				});
				return false;
			} else {

				if(telFig) {
					$("#name,#tel,#butcherAdd").css('border', "");
					$('.basic-Info').css('color', "");
					$.ajax({
						type: "post",
						async: true, //同步执行
						url: addUrl,
						data: dataObj,
						success: function(dataAll) {
							if(dataAll.code == 0) {
								if(pTitle == '新增屠宰场人员') {
									tableLaode = parent.$('#personnelTable').DataTable();
									userSlaughter(dataAll.data,tableLaode);
								} else {
									layer.msg("添加成功");
									setTimeout(function() {
										var index = parent.layer.getFrameIndex(window.name);
										parent.layer.close(index);
										if(pTitle == '新增屠宰场'){
											parent.$('.butcherAdd').addClass('none');
										}
										tableLaode.ajax.reload();
										

									}, 1000);
								}

							} else {
								layer.alert(dataAll.message, {
									skin: 'layui-layer-lan'
								})
							}

						}
					})
				} else {
					layer.alert("请输入正确的手机号", {
						skin: 'layui-layer-lan'
					});
				}

			}

		}else{
			editorSave()
			
		}
	}
	});
	//编辑保存
	var personnelTableLen;
	function editorSave(){
		var updateUrl;
		var dataObj = {
			id: rowData.id,
			villageId: $('#village').val(),
			townId: $("#town").val(),
			districtId: $("#district").val(),
			cityId: $("#city").val(),
			provinceId: $("#province").val(),
			name: $.trim($("#name").val()),
			tel: $.trim($("#tel").val())
		};
		var addressEleVal,phoneVal,nameVal;
		if(pTitle == "修改档案管理员") {
			updateUrl = allUrl.findFileManageUpdate;
			tableLaode = parent.$('#tableFilingM').DataTable();
			addressEleVal=parent.$(".address");
			phoneVal=parent.$(".phone");
			nameVal=parent.$(".name");
		};
		if(pTitle == "修改养殖户"){
			phoneVal=parent.$("#breed_details_phone");
			nameVal=parent.$("#breed_details_userName");
			addressEleVal=parent.$("#breed_details_address");
			updateUrl = allUrl.farmsUpdate;
			dataObj.feed = $.trim($("#feed").val());
			dataObj.userId = dataObj.id;
			dataObj.currentUserId=userInfoArr.userId;
			if($("input[name=famerId]").prop("checked")) {
				dataObj.farmType = 0
			} else {
				dataObj.farmType = 1;
			};
			tableLaode = parent.$('#tableBreedM').DataTable();
			delete dataObj.id;
		};
		if(pTitle == "修改屠宰场"){
			addressEleVal=parent.$("#butcher_personnel_address");
			phoneVal=parent.$("#butcher_personnel_phone");
			nameVal =parent.$("#butcher_personnel_name");
			updateUrl = allUrl.butcherUpdate;
			dataObj.phone=dataObj.tel;
			delete dataObj.tel;
			dataObj.name = $('#butcherAdd').val();
			dataObj.principalName = $('#principal').val();
			if(dataObj.townId == "") {
				layer.alert("请选择地址到镇或乡", {
					skin: 'layui-layer-lan'
				});
				return false;
			}else{
				var address=addressVal();
				dataObj.address = address;
			}
			
			tableLaode = parent.$('#tableButcherM').DataTable();
		};
		if(pTitle ==="修改屠宰场人员"){
			nameVal=parent.$("#butcher_details_userName");
			phoneVal=parent.$("#butcher_details_phone");
			addressEleVal=parent.$("#butcher_details_address");
			updateUrl = allUrl.accountManUpdate;
			dataObj.currentUserId=userInfoArr.userId;
			dataObj.userId =$(table.find("#butcher_details_userId")).text();
			delete dataObj.id;
			personnelTableLen = parent.$('.statusBtn')[0].classList.length;
			if(personnelTableLen==1){
				tableLaode = parent.$('#personnelTable').DataTable();
			};
			
		};
		for(var key in dataObj) {
			if(dataObj[key] === "") {
				delete dataObj[key];
			}
		};
		if(dataObj.name==undefined){
			layer.msg('请输入名称');
			return false;
		}else if( $.trim($("#tel").val())==""){
			layer.msg('请输入电话');
			return false;
		}else{
			var address=addressVal();
			$.ajax({
			type: "post",
			async: true, //同步执行
			url: updateUrl,
			data: dataObj,
			success: function(dataAll) {
				if(dataAll.code == 0) {
						layer.msg("修改成功");
						addressEleVal.text(address);
						
						phoneVal.text($("#tel").val());
					
						if(pTitle == "修改屠宰场"){
							nameVal.text($("#butcherAdd").val())
							parent.$("#butcher_personnel_principalName").text($("#principal").val());
						}else{
							nameVal.text($("#name").val())
						}
						var rowDatas ;
						if(pTitle == "修改养殖户"){
							if(dataObj.farmType==0){
								parent.$("#breed_details_farmType").text('个体');
							}else{
								parent.$("#breed_details_farmType").text('养殖场');
							};
							parent.$("#breed_details_fooderName").text($("#feed").val());
						};
						if(pTitle == "修改屠宰场人员") {
							rowDatas=JSON.parse($(table.find('#butcher_details_rowData')).text());
							dataObj.slaughterhouseName=rowDatas.slaughterhouseName;
							$(table.find('#butcher_details_rowData')).text(JSON.stringify(dataObj));
						}else{
							rowDatas = JSON.parse($(table.find('.rowData')).text())
							$(table.find('.rowData')).text(JSON.stringify(dataObj));
						}
						setTimeout(function() {
							var index = parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);
							if(personnelTableLen==2)
							return false;
							if(pTitle == '新增屠宰场'){
								parent.$('.butcherAdd').addClass('none');
							}
							tableLaode.ajax.reload();
							
						}, 1000);
				

				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					})
				}

			}
		});
		}
		
		
	};
	function addressVal(){
		var addressArr = ["province", "city", "district", "town", "village"];
			var d = "";
			$.each(addressArr, function(i, add) {
				d += $("#" + add + " option:selected").text();
			});
		return d.split('-')[0];
	}
	function userSlaughter(userId, tableLaode) {
		var slaughterhouseId = $($(parent.$("#add-form")[0]).parents().find('#butcher_personnel_id')).text();
		if(slaughterhouseId == "") {
			layer.msg('请获取屠宰场ID');
		} else {
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.butcherPersonnelAdd,
				data: {
					userId: userId,
					slaughterhouseId: slaughterhouseId
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						layer.msg("添加成功");
						setTimeout(function() {
							var index = parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);

							tableLaode.ajax.reload();
							//					parent.location.reload();
						}, 1000);
					} else {
						layer.alert(dataAll.message, {
							skin: 'layui-layer-lan'
						});
					};
				}
			});
		}

	}

});