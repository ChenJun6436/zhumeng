var addData = {
	carInfo:[
		{
			driver: '',
			tel: '',
			carNo: ''
		}
	]
}
var carNoData = {
		name: [
			"川","津","沪","渝","冀","豫","云","辽","黑","湘","皖","鲁","新","苏","浙","赣","鄂","桂","甘","晋","蒙","陕","吉","闽","粤","青","藏",,"京","宁","琼"
		],
		code: [
			"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
		]
	}
$(function(){
	
	// console.log(JSON.parse(JSON.stringify(addData)) )
	$(document).on("click", "#ADD_INTO_SURE", function() {
		addData.code= $('#FAC_code').val()
		addData.name= $('#FAC_name').val()
		addData.tel= $('#FAC_tel').val()
		addData.addressN= lastADDRESS
		addData.address = ''
		addData.pigNum= $('#FAC_pigNumber').val()
		addData.pigWeight= $('#FAC_pigWeight').val()
		addData.userId = ''
		addData.slaughterId= ''


		// console.log(addData.carInfo)


		if(typeof(curButcherId)!=="undefined"){
			addData.slaughterId= curButcherId
		}else{
			var userInfo = sessionStorage.getItem('userInfo');
			var userInfoArr = JSON.parse(userInfo);
			addData.userId= userInfoArr.userId
		}
		if(addData.name){

		}else {
			layer.alert('请填写供应商名称', {
				skin: 'layui-layer-lan'
			})
			return false
		}
		var PhoneREGX = /^[1][3,4,5,7,8][0-9]{9}$/
		if(addData.tel){
			if(PhoneREGX.test(addData.tel)){

			}else {
				layer.alert('请填写正确的联系方式', {
					skin: 'layui-layer-lan'
				})
				return false
			}
		}else {
			layer.alert('请填写联系方式', {
				skin: 'layui-layer-lan'
			})
			return false
		}
		
		if(addData.addressN && addData.addressN!=0){
			addData.address = $(".into_factoryForm select[name='address1']").find("option:selected").text()+""+$(".into_factoryForm select[name='address2']").find("option:selected").text()+""+$(".into_factoryForm select[name='address3']").find("option:selected").text()+""+$('#FAC_address').val()
			console.log(addData.addressN)
		}else {
			layer.alert('请填写公司地址', {
				skin: 'layui-layer-lan'
			})
			return false
		}
		///////////////////////////////////
		var numPigNumREGX = /^[1-9]\d*$/
		if(addData.pigNum){
			if(numPigNumREGX.test(addData.pigNum)){
			
			}else {
				layer.alert('生猪数量必须是大于0的整数', {
					skin: 'layui-layer-lan'
				})
				return false
			}
		}else{
			layer.alert('请填写生猪数量', {
					skin: 'layui-layer-lan'
				})
				return false
		}
		var numPigWeightREGX = /^\d+(\.\d{2})?$/ 
		if(numPigWeightREGX.test(addData.pigWeight) && addData.pigWeight>0){
			
		}else if(!addData.pigWeight) {
			
		}else {
			layer.alert('生猪重量必须大于0，且精确到小数点后两位', {
				skin: 'layui-layer-lan'
			})
			return false
		}
		///////////////////////////////////
		var carNoREGX = /^[0-9A-Z]+$/
		for(var i in addData.carInfo){
			addData.carInfo[i].driver =$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[0]).val()
			addData.carInfo[i].tel = $($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[1]).val()
			addData.carInfo[i].carNo  =$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[2]).val()+ $($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[3]).val() + $($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[4]).val()
			if(!addData.carInfo[i].driver){
				layer.alert('请填写运输人员名字', {
					skin: 'layui-layer-lan'
				})
				return false
			}
			if(addData.carInfo[i].tel){
				if(PhoneREGX.test(addData.carInfo[i].tel) ){

				}else {
					layer.alert('请填写正确的运输车辆联系电话', {
						skin: 'layui-layer-lan'
					})
					return false
				}
			}else {
				layer.alert('请填写运输车辆联系电话', {
					skin: 'layui-layer-lan'
				})
				return false
			}
			if(!$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[4]).val()){
				layer.alert('请填写运输车辆车牌号', {
					skin: 'layui-layer-lan'
				})
				return false
			}
		}
		console.log(addData)
		openMsg ()
	})
	$(document).on("click", "#ADD_INTO_CANCLE", function() {
		
		$('.entryOutMain').removeClass('none');
		$('.addIntoForm').addClass('none');
		$('#ONE_CAR_INFO').empty()
		$('#FAC_code').val('')
		$('#FAC_name').val('')
		$('#FAC_tel').val('')
		$('#FAC_address').val('')
		$('#FAC_pigNumber').val('')
		$('#FAC_pigWeight').val('')
		$(".into_factoryForm select[name='address1']").val('0') 
		$(".into_factoryForm select[name='address2']").val('0') 
		$(".into_factoryForm select[name='address3']").val('0') 
		$(".into_factoryForm select[name='address2']").empty()
		$(".into_factoryForm select[name='address2']").append("<option value='0'>所有市</option>")
		$(".into_factoryForm select[name='address3']").empty()
		$(".into_factoryForm select[name='address3']").append("<option value='0'>所有区/县</option>")
	})
	$(document).on("click", "#INTO_DEL_CAR", function() {
		var now = $(this.parentNode)
		if(addData.carInfo.length >1){
			layer.open({
				title:['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
				btn:['确定','取消'],
				content:'您是否确定要删除该车辆？',
				btnAlign: 'c',
				btn1:function(){
					del_car(now);
					layer.closeAll()
				},
				btn2:function(){
					
				}
			})
		}
	})
	function del_car(pa) {
		pa.remove()
		addData.carInfo.splice(pa.index(),1)
		for(var i =0;i<addData.carInfo.length;i++){
			$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[0]).attr('id','FAC_car_driver'+i+'')
			$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[1]).attr('id','FAC_car_tel'+i+'')
			$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[2]).attr('id','CARNAME'+i+'')
			$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[3]).attr('id','CARCODE'+i+'')
			$($($('#ONE_CAR_INFO').find('.add_intoF_car_Form')[i]).find('.car_cari')[4]).attr('id','FAC_car_carNo'+i+'')
		}
	}
	function  openMsg() {
		var aaaa = addData
		layer.open({
			title:['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn:['确定','取消'],
			content:'您是否确定要新增该条数据？',
			btnAlign: 'c',
			btn1:function(){
				add_into();
				layer.closeAll()
			},
			btn2:function(){
				addData = aaaa
			}
		})
	}
	function  add_into() {
		var aaaa = addData
		addData.carInfo = JSON.stringify(addData.carInfo)
		$.ajax({
			type: "post",
			async: true, //同步执行
			// contentType:'',
			url: allUrl.newAddEntry,
			dataType: "json", //返回数据形式为json
			xhrFields: {
				withCredentials: true
			},
			data: JSON.parse(JSON.stringify(addData)) ,
			success: function(data) {
				if(data.code === '0'){
					addData = {
						carInfo:[
							{
								driver: '',
								tel: '',
								carNo: ''
							}
						]
					}
					layer.alert('新增成功', {
						skin: 'layui-layer-lan'
					},function(){
						entryTable.ajax.reload();
						$('.entryOutMain').removeClass('none');
						$('.addIntoForm').addClass('none');
						var curNum = $('.todayEntryNum').text();
						var allNum = parseInt(curNum) + parseInt(aaaa.pigNum); //returns 22
						$('.todayEntryNum').text(allNum);
						layer.closeAll();
					})
					$('.entryOutMain').removeClass('none');
					$('.addIntoForm').addClass('none');
					$('#ONE_CAR_INFO').empty()
					$('#FAC_code').val('')
					$('#FAC_name').val('')
					$('#FAC_tel').val('')
					$('#FAC_address').val('')
					$('#FAC_pigNumber').val('')
					$('#FAC_pigWeight').val('')
					$(".into_factoryForm select[name='address1']").val('0') 
					$(".into_factoryForm select[name='address2']").val('0') 
					$(".into_factoryForm select[name='address3']").val('0') 
					$(".into_factoryForm select[name='address2']").empty()
					$(".into_factoryForm select[name='address2']").append("<option value='0'>所有市</option>")
					$(".into_factoryForm select[name='address3']").empty()
					$(".into_factoryForm select[name='address3']").append("<option value='0'>所有区/县</option>")
//					setTimeout(function(){
//						// $('.box1').addClass('none');
//						// $('.entryOutMain').removeClass('none');
//						// layer.closeAll();
//						 entryTable.ajax.reload();
////						location.reload()
//						$('.entryOutMain').removeClass('none');
//						$('.addIntoForm').addClass('none');
////						$(".main-content").load('./entryOutData.html');
//						
//					},1000)
				}else {
					addData = aaaa
					layer.alert(data.message,{
						skin: 'layui-layer-lan'
					})
				}
			}
		})
	}
	//
	$(document).on("click", "#ADD_CAR_INFO", function() {
		var carInfoLENGTH1 = addData.carInfo.length
		var aa = addData.carInfo.length+1
		if(carInfoLENGTH1 >19){  //4
			layer.alert('运输车辆数不超过20辆', {
				skin: 'layui-layer-lan'
			})
			return false
		}else{
			addData.carInfo.push(
				{
					driver: '1',
					tel: '1',
					carNo: '1'
				}
			)

			var carInfoLENGTH = addData.carInfo.length -1
			$('#ONE_CAR_INFO').append(
				"<div class='addButcherLayer' style='margin:0; border-top: 1px dashed #e3e3e3;position: relative;'>"
					+"<form class='add_intoF_car_Form' style='width: 100%;padding-left: 50px'>"
						+"<p class='basic-Info pull-left' style='width: 120px;'>运输车辆信息:</p>"
						+"<div class='clear'></div>"
						+"<div class='info-default'>"
							+"<label class='select-label pull-left nomrg-top' style='margin: 0px 13px 0px 0px;'><span style='color: red'>*</span>运输人员:</label>"
							+"<input class='selected form-control info-mrg car_cari' id='FAC_car_driver"+carInfoLENGTH+"' maxlength='35' name='name' style='width: 70%; />"
						+"</div>"
						+"<div class='info-default'>"
							+"<label class='select-label pull-left nomrg-top' style=' margin: 24px 13px 0px 0px;'><span style='color: red'>*</span>联系方式:</label>"
							+"<input class='selected form-control info-mrg car_cari' id='FAC_car_tel"+carInfoLENGTH+"' maxlength='11' name='phone' style='width: 70%;   ' />"
						+"</div>"
						+"<div class='info-default margin-top-25' style='overflow:hidden;'>"
							+"<label class='select-label pull-left nomrg-top' id='typeAdd' style='margin: 0px 13px 0px 0px;'><span style='color: red'>*</span>运输车辆:</label>"
							+"<select class='selected form-control info-mrgLeft car_cari' id='CARNAME"+carInfoLENGTH+"' style='width: 15%;float: left;margin:0;'>"
								+"<option value='川' selected='selected'>川</option>"
							+"</select>"
							+"<select class='selected form-control info-mrgLeft car_cari' id='CARCODE"+carInfoLENGTH+"' style='width: 15%;float: left;margin:0;margin-left: 3%'>"
								+"<option value='A' selected='selected'>A</option>"
							+"</select>"
							+"<input class='selected form-control car_cari'  id='FAC_car_carNo"+carInfoLENGTH+"'  maxlength='6' name='CARNUM1' style='width: 34%;float: left;margin:0;margin-left: 3%;'/>"
						+"</div>"
					+"</form>"
					+"<img src='../src/images/ic_delate.jpg' id='INTO_DEL_CAR' style='margin-top: 25%;position: absolute;top: 0;right: 0;cursor: pointer;'>"
				+"</div>"
			)

			getCarNumCode (carInfoLENGTH)
		}
	})
	//获取车牌
	function getCarNumCode (carInfoLENGTH) {
		// for(var i in addData.carInfo){ssss
			var i = carInfoLENGTH
			$("#CARNAME"+i+"").empty()
			for(var k in carNoData.name){
				$("#CARNAME"+i+"").append("<option value="+ carNoData.name[k] +">"+ carNoData.name[k] +"</option>")
			}
			$("#CARCODE"+i+"").empty()
			for(var k in carNoData.code){
				$("#CARCODE"+i+"").append("<option value="+ carNoData.code[k] +">"+ carNoData.code[k] +"</option>")
			}
		// }
	}
	getCarNumCode (0)
	//地址管理
	var lastADDRESS = '';
	$.ajax({
		type: "post",
		async: true, //同步执行
		url: allUrl.find_province_option,
		dataType: "json", //返回数据形式为json
		xhrFields: {
			withCredentials: true
		},
		data: '',
		success: function(data) {
			if(data.code == '0'){
				for(var i in data.data){
					$(".into_factoryForm select[name='address1']").append("<option value="+ data.data[i].key +">"+ data.data[i].value +"</option>")
				}
			}else {
				layer.alert(data.message, {
					skin: 'layui-layer-lan'
				})
			}
		}
	})
	$(document).on("change", ".into_factoryForm select[name='address1']", function() {
		if($(".into_factoryForm select[name='address1']").val() == '0'){
			$(".into_factoryForm select[name='address2']").val('0') 
			$(".into_factoryForm select[name='address3']").val('0') 

			$(".into_factoryForm select[name='address2']").empty()
			$(".into_factoryForm select[name='address2']").append("<option value='0'>所有市</option>")
			$(".into_factoryForm select[name='address3']").empty()
			$(".into_factoryForm select[name='address3']").append("<option value='0'>所有区/县</option>")
			$(".into_factoryForm select[name='address2']").val('0')
			$(".into_factoryForm select[name='address3']").val('0')
			lastADDRESS = 0
		}else{
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.find_city_option,
				dataType: "json", //返回数据形式为json
				xhrFields: {
					withCredentials: true
				},
				data: {province_id: $(".into_factoryForm select[name='address1']").val()},
				success: function(data) {
					if(data.code == '0'){
						$(".into_factoryForm select[name='address2']").empty()
						$(".into_factoryForm select[name='address2']").append("<option value='0'>所有市</option>")
						for(var i in data.data){
							$(".into_factoryForm select[name='address2']").append("<option value="+ data.data[i].key +">"+ data.data[i].value +"</option>")
						}
					}else {
						layer.alert(data.message, {
							skin: 'layui-layer-lan'
						})
					}
				}
			})
		}
	})
	$(document).on("change", ".into_factoryForm select[name='address2']", function() {
		if( $(".into_factoryForm select[name='address2']").val()=='0' ){
			$(".into_factoryForm select[name='address3']").empty()
			$(".into_factoryForm select[name='address3']").append("<option value='0'>所有区/县</option>")
			$(".into_factoryForm select[name='address2']").val('0')
			lastADDRESS = 0
		}else{
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: allUrl.find_district_option,
				dataType: "json", //返回数据形式为json
				xhrFields: {
					withCredentials: true
				},
				data:  {city_id: $(".into_factoryForm select[name='address2']").val()},
				success: function(data) {
					if(data.code == '0'){
						lastADDRESS = data.data[0].key
						$(".into_factoryForm select[name='address3']").empty()
						$(".into_factoryForm select[name='address3']").append("<option value='0'>所有区/县</option>")
						lastADDRESS = 0
						for(var i in data.data){
							$(".into_factoryForm select[name='address3']").append("<option vale="+ data.data[i].key +">"+ data.data[i].value +"</option>")
						}
					}else {
						layer.alert(data.message, {
							skin: 'layui-layer-lan'
						})
					}
				}
			})
		}
	})
	$(document).on("change", ".into_factoryForm select[name='address3']", function() {
		lastADDRESS = $(".into_factoryForm select[name='address3']").val()
	})
})