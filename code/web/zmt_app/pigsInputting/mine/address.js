define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
	};
	

	Model.prototype.addressDataCustomRefresh = function(event){
		
	};

	Model.prototype.confirmClick = function(event){

	};
	
	//加载数据请求当前的账号信息
	var userInfoArr;
	Model.prototype.modelLoad = function(event){
		var me = this;
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		var userId = userInfoArr.userId;
		var provinceData = this.comp("provinceData");
		var curData = this.comp("addressData");
		var cityData = this.comp("cityData");
		var districtData = this.comp("districtData");
		var townData = this.comp("townData");
		var villageData = this.comp("villageData");
		curData.clear();provinceData.clear();cityData.clear();districtData.clear();townData.clear();villageData.clear();
		$.ajax({
			type: "post",
			url: baseUrl.getAddreeByUserId,
			dataType: 'json',
			async: false,
			cache: false,
			xhrFields: {
				withCredentials: true
			},
			data: {
				user_id:userId
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					var Data = dataAll.data;
					loadLocation(provinceData,'',baseUrl.get_province_option)
					if(Data.provinceId !=null){
						loadLocation(cityData,{province_id:Data.provinceId},baseUrl.get_city_option);
					}
					if(Data.cityId){
						loadLocation(districtData,{city_id:Data.cityId},baseUrl.get_district_option);
					}
					if(Data.districtId){
						loadLocation(townData,{district_id:Data.districtId},baseUrl.get_town_option);
					}
					if(Data.townId){
						loadLocation(villageData,{town_id:Data.townId},baseUrl.get_village_option);
					}
					curData.add({
						province:Data.provinceId !=null?Data.provinceId:"",
						provinceLabel:Data.province!=null?Data.province:"",
						cityLabel:Data.city!=null?Data.city:"",
						city:Data.cityId!=null?Data.cityId:"",
						district:Data.districtId!=null?Data.districtId:"",
						districtLabel:Data.district!=null?Data.district:"",
						town:Data.townId!=null?Data.townId:"",
						townLabel:Data.town!=null?Data.town:"",
						village:Data.villageId!=null?Data.villageId:"",
						villageLabel:Data.village!=null?Data.village:"",
					})

				}else{
					justep.Util.hint(dataAll.message, {type: 'danger'});
					return;
				}
			}
		});
	};
	
	//请求地址的方法
		function loadLocation(areaEleData,data,url){
		areaEleData.clear();
		
		var ajaxData = '';	
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:url,
            data:data!=''?data:'',
            success : function(allData){
            	var data = allData.data;
            	if(allData.code=='0'){
            		$.each(data,function(i,e){
            			areaEleData.add({
	            			'fValue': e.key,
							'fLabel': e.value,
            			});
            		})
            	}
            }
        });
	}
	
	//省的change事件
	Model.prototype.select1Change = function(event){
		var cityData = this.comp('cityData');
		
		var provinceId = $(this.getElementByXid("select1")).val();
		var provinceText = $(this.getElementByXid("select1")).text();
		var data = {
			province_id:provinceId
		}
		var addressData = this.comp('addressData');
		addressData.setValue('cityLabel',"");
        addressData.setValue('city',"");
		this.comp('districtData').clear();
		this.comp('townData').clear();
		this.comp('villageData').clear();
		loadLocation(cityData,data,baseUrl.get_city_option)
		
	};
	
	//市的change 事件
	Model.prototype.select2Change = function(event){
		var districtData = this.comp('districtData');
//		this.comp('addressData').clear()
		var city_id = $(this.getElementByXid("select2")).val();
		var data = {
			city_id:city_id
		}
		var addressData = this.comp('addressData');
		addressData.setValue('districtLabel',"");
        addressData.setValue('district',"");
		this.comp('townData').clear();
		this.comp('villageData').clear();
		loadLocation(districtData,data,baseUrl.get_district_option)
		
	};
	
	//区的change事件
	Model.prototype.select3Change = function(event){
		var townData = this.comp('townData');
//		this.comp('addressData').clear()
		var district_id = $(this.getElementByXid("select3")).val();
		var data = {
			district_id:district_id
		}
		var addressData = this.comp('addressData');
		addressData.setValue('townLabel',"");
        addressData.setValue('town',"");
		this.comp('villageData').clear();
		loadLocation(townData,data,baseUrl.get_town_option)
		

	};
	
	//镇的change事件
	Model.prototype.select4Change = function(event){
		var villageData = this.comp('villageData');
		var town_id = $(this.getElementByXid("select4")).val();
		var data = {
			town_id:town_id
		}
		var addressData = this.comp('addressData');
		addressData.setValue('villageLabel',"");
        addressData.setValue('village',"");
		this.comp('villageData').clear();
		loadLocation(villageData,data,baseUrl.get_village_option)
	};
	
	//点击保存的事件
	Model.prototype.button1Click = function(event){
		var me = this;
		var obj = {}
		obj.userId = userInfoArr.userId;
		obj.provinceId = $(this.getElementByXid("select1")).val();
		obj.cityId = $(this.getElementByXid("select2")).val();
		obj.districtId = $(this.getElementByXid("select3")).val();
		obj.townId = $(this.getElementByXid("select4")).val();
		obj.villageId = $(this.getElementByXid("select5")).val();
//		me.close();

		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:baseUrl.saveAddress,
            data:obj,
            success : function(allData){
            	var data = allData.data;
            	if(allData.code=='0'){
//            		if(data)
            		justep.Util.hint("保存成功！");
            		me.close();
//            		var url = './minePage.w';
//					justep.Shell.showPage(require.toUrl(url));
            	}else{
            		justep.Util.hint(allData.message, {type: 'danger'});
            	}
            }
        });
		
	};
	

	return Model;
});