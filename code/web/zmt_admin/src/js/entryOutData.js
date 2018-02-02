/*
 * 屠宰场出入库数据
 */
$(function(){
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	$('.entry_library_data').removeClass('none');
	$('.entry_library_data_area').addClass('on');
	
//	判断是否是监控管理员
	if(userInfoArr.typeId =='e998326a-0d16-46c5-9151-dcc617b507b4'){
		$('.entryDataBtn,.outDataBtn,.newAddButcherNum').addClass('none')
	}
	//判断当前登陆账户类型：普通用户与管理员
	var entrySearchvalue,entryUrl,getTotalUrl,newAddButcherNumUrl;
		if(userInfoArr.roleCode == null || userInfoArr.roleCode == 1) { //普通屠宰用户
			entrySearchvalue={    
				user_id:userInfoArr.userId

			};
			entryUrl=allUrl.getEntryListByuserId;
			getTotalUrl　= allUrl.getTotalNumberByUserId;
			newAddButcherNumUrl = allUrl.newAddButcherNumByUserId;
		}else{
			entrySearchvalue={    
				slaughter_id:curButcherId,
				slaughterhouse_id:curButcherId,
				
			};
			entryUrl=allUrl.getEntryListByButcherId;
			getTotalUrl　= allUrl.getTotalNumberByButcherId;
			newAddButcherNumUrl = allUrl.newAddButcherNumber;
		}
		
		
	//获取屠宰数量出入库总数
	$.ajax({
		url:getTotalUrl,
		type:'post',
		async:false,
		data:entrySearchvalue,
		success:function(data){
			var Data = data.data;
			$('.todayButcherNum').text(Data.butcherNum);
			$('.todayEntryNum').text(Data.inNum);
			$('.todayOutNum').text(Data.outNum)
		}
	})
	
	//新增屠宰数
	$(document).on('click','.newAddButcherNum',function(ev){
		$('.butchNumber').val('');
		layer.open({
			type: 2,
			area: ['583px','492px'],
			scrollbar: false,
			id:'butcherBeforReport',
			title: ['新增出入库单屠宰数', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: './butcher_layer.html',
		});
		entrySearchvalue.newAddButcherNumUrl=newAddButcherNumUrl;
		sessionStorage.entrySearchvalue = JSON.stringify(entrySearchvalue);
	})
	
	
	
	//入库单
	var entrySetting = {
		id: "entryDataTable",
		url:entryUrl,
		searchParams: entrySearchvalue,
		lengthChange: false,
		scrollX:true,
		columns: ["code", "merchantName", "tel", "pigNum", "pigWeight", "carNum", "createTime", null],
		columnDefs: [ {
				targets: 5,
				orderable: false,
				render: function(data) {
					if(data ==null){
						return ('/')
					}else{
						return(data+'/kg')
					}
					
					
				}
			},{
			"targets": -1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				return('<a href="#" class="entryLookBtn text-primary">查看详情</a>');
			}
		}]
	} 
	entryTable = $.createTable(entrySetting); //调用创建table的方法
	
	//入库单点击查看详情
	$(document).on('click','.entryLookBtn',function(){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var curData = entryTable.row($(this).parents('tr')).data();
			var tit = '入库单详情';
			var entryDatilUrl = allUrl.getEntryDetails;
			entryOutDatilLayerFn(curData,tit,entryDatilUrl);

		};
	});
	//新增入库单
	$(document).on('click','.entryDataBtn',function(){
		$('.entryOutMain').addClass('none');
		$('.addIntoForm').removeClass('none');
//		$(".main-content").load('./add_into_factory.html');	


		//清空数据
		addData = {
			carInfo:[
				{
					driver: '',
					tel: '',
					carNo: ''
				}
			]
		}
		var carInfoLENGTH = '0';
		$('#ONE_CAR_INFO').empty()
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
	})
	
	
	//点击入库单是显示入库单的数据
	$(document).on('click','.chukudan',function(){
		$('.chukudan').addClass('activeLi');
		$('.rukudan').removeClass('activeLi');
		$('.chukudabList, .outDataBtn').addClass('none');
		$('.rukudanList,.entryDataBtn,.rukudanLis').removeClass('none');
		if(userInfoArr.typeId =='e998326a-0d16-46c5-9151-dcc617b507b4'){
			$('.entryDataBtn,.outDataBtn,.newAddButcherNum').addClass('none')
		}
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//出库单
//	var chukudabListTable;
	$(document).on('click','.rukudan',function(){
	var searchvalue,urls;
		if(userInfoArr.roleCode == null || userInfoArr.roleCode == 1) { //普通屠宰用户
			searchValue={    
				user_id:userInfoArr.userId
			};
			urls=allUrl.getOutListByuserId;
		}else{
			searchValue={    
				slaughter_id:curButcherId
			};
			urls=allUrl.getOutListByButcherId;
		}
		$('.chukudan').removeClass('activeLi');
		$('.rukudan').addClass('activeLi');
		$('.chukudabList,.outDataBtn').removeClass('none');
		$('.rukudanList,.entryDataBtn,.rukudanLis').addClass('none');
		if(userInfoArr.typeId =='e998326a-0d16-46c5-9151-dcc617b507b4'){
			$('.entryDataBtn,.outDataBtn,.newAddButcherNum').addClass('none')
		}
		var columnArrs = ["code", "merchantName", "tel","pigNum", "pigWeight", "carNum", "createTime", null];
		var columnDefArrs = [{
				targets: 5,
				orderable: false,
				render: function(data) {
					if(data==null){
						return('/')
					}else{
						return(data+'/kg')
					}
				}
			},{
				targets: -1,
				orderable: false,
				render: function(data) {
					return('<a href="#" class="text-primary viewDetailsBtn">查看详情</a>')
					
				}
			}];
			var chukudabList= {
			id: "chukudabListTable",
			url: urls,
			searchParams: searchValue,
			columns: columnArrs,
			lengthChange: false,
			scrollX: true,
			columnDefs: columnDefArrs
		}
		chukudabListTable = $.createTable(chukudabList);
	});
	//新增出库单
	
	$(document).on('click', '.outDataBtn', function() {
		$('.entryOutMain').addClass('none');
		$('.addOutoForm').removeClass('none');
//		$(".main-content").load('./add_outo_factory.html');
	//清空数据
		addData = {
			carInfo:[
				{
					driver: '',
					tel: '',
					carNo: ''
				}
			]
		}
		var carInfoLENGTH = '0';
		$('#ONE_CAR_INFO_OU').empty()
		$('#ONE_CAR_INFO_OU').append(
			"<div class='addButcherLayer' style='margin:0; border-top: 1px dashed #e3e3e3;position: relative;'>"
				+"<form class='add_outoF_car_Form' style='width: 100%;padding-left: 50px;margin-bottom: 20px;'>"
					+"<p class='basic-Info pull-left' style='width: 120px;'>运输车辆信息:</p>"
					+"<div class='clear'></div>"
					+"<div class='info-default'>"
						+"<label class='select-label pull-left nomrg-top' style='margin: 0px 13px 0px 0px;'><span style='color: red'>*</span>运输人员:</label>"
						+"<input class='selected form-control info-mrg car_caro' id='FAC_car_driver_OU"+carInfoLENGTH+"' name='name' maxlength='35' style='width: 70%; />"
					+"</div>"
					+"<div class='info-default'>"
						+"<label class='select-label pull-left nomrg-top' style='margin: 24px 13px 0px 0px;'><span style='color: red'>*</span>联系方式:</label>"
						+"<input class='selected form-control info-mrg car_caro' id='FAC_car_tel_OU"+carInfoLENGTH+"' name='phone' maxlength='11' style='width: 70%;' />"
					+"</div>"
					+"<div class='info-default margin-top-25' style='overflow:hidden;'>"
						+"<label class='select-label pull-left nomrg-top' id='typeAdd' style='margin: 0px 13px 0px 0px;'><span style='color: red'>*</span>运输车辆:</label>"
						+"<select class='selected form-control info-mrgLeft car_caro' id='CARNAME_OU"+carInfoLENGTH+"' style='width: 15%;float: left;margin:0;'>"
							+"<option value='川' selected='selected'>川</option>"
						+"</select>"
						+"<select class='selected form-control info-mrgLeft car_caro' id='CARCODE_OU"+carInfoLENGTH+"' style='width: 15%;float: left;margin:0;margin-left: 3%'>"
							+"<option value='A' selected='selected'>A</option>"
						+"</select>"
						+"<input class='selected form-control car_caro'  id='FAC_car_carNo_OU"+carInfoLENGTH+"'  maxlength='6' name='CARNUM1' style='width: 34%;float: left;margin:0;margin-left: 3%;'/>"
					+"</div>"
				+"</form>"
				+"<img src='../src/images/ic_delate.jpg' id='OUTO_DEL_CAR' style='margin-top: 25%;position: absolute;top: 0;right: 0;cursor: pointer;'>"
			+"</div>"
		)
		//获取车牌
		function getCarNumCode (carInfoLENGTH) {
			var i = carInfoLENGTH
			// for(var i in addData.carInfo){
				$("#CARNAME_OU"+i+"").empty()
				for(var k in carNoData.name){
					$("#CARNAME_OU"+i+"").append("<option value="+ carNoData.name[k] +">"+ carNoData.name[k] +"</option>")
				}
				$("#CARCODE_OU"+i+"").empty()
				for(var k in carNoData.code){
					$("#CARCODE_OU"+i+"").append("<option value="+ carNoData.code[k] +">"+ carNoData.code[k] +"</option>")
				}
			// }
		}
		getCarNumCode (0)
	});
	
	//出库单点击查看详情
	$(document).on('click','.viewDetailsBtn',function(){
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			var curData = chukudabListTable.row($(this).parents('tr')).data();
			var tit = '出库单详情';
			var OutDatilUrl = allUrl.getOutDetails;
			entryOutDatilLayerFn(curData,tit,OutDatilUrl);

		};
	});
	/**
	 * 
	 * @param {Object} curData 当前行数据
	 * @param {Object} tit 弹框标题
	 * @param {Object} url 请求路径
	 */
	function entryOutDatilLayerFn(curData,tit,url){
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: url,
			data: {id:curData.id},
			success: function(allData) {
				if(allData.code=='0'){
					layer.open({
						type: 2,
						area: ['878px','678px'],
						scrollbar: false,
						id:'entryOutDatil-form',
						title: [tit, 'background-color:#1FB5AD;color:white;font-size:16px'],
						content: './entryOutDetail.html',
					});
					sessionStorage.entryOutDatil = JSON.stringify(allData.data);
				}else{
					layer.msg(allData.message)
				}
			}
		});
	};
	//返回上一页
	$(document).on('click', '.backUpper-toggle', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig) {
			window.location.href = './butcher_manage.html';
		}
	});
	

})

var chukudabListTable,entryTable;
