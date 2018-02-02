define(function(require){
	var $ = require("jquery");
	var domainUrl = require("js/baseUrl");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};



	//点击确认按钮（新增养殖户）
	var userInfoArr;
	Model.prototype.button2Click = function(event){
		var me = this;
		var obj = {};
		var baseFlag = true;
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		obj.name =  $(this.getElementByXid("input1")).val();
		obj.tel =  $(this.getElementByXid("input2")).val();
		obj.currentUserId = userInfoArr.userId;
		obj.farmType = $(this.getElementByXid("select2")).val();
		obj.provinceId =  $(this.getElementByXid("select3")).val();
		obj.cityId =  $(this.getElementByXid("select11")).val();
		obj.districtId =  $(this.getElementByXid("select10")).val();
		$.each(obj,function(i,e){
			if(e == ''){
		        baseFlag = false;
		        return false
			}
		})
		obj.feed = $(this.getElementByXid("input3")).val();
		obj.townId =  $(this.getElementByXid("select8")).val();
		obj.villageId =  $(this.getElementByXid("select9")).val();
		if(!baseFlag){
			justep.Util.hint('请先输入基本信息！',{'type':'danger'});
	           return;
		}
		var reg = /^[1][34578][0-9]{9}$/;
		if(!reg.test(obj.tel)){
			var phoneFlag = false;
			justep.Util.hint('请输入正确的电话号码！',{'type':'danger'});
	          return;
		}
			$.ajax({
				type : "post",  
	            dataType : "json",
	            xhrFields:{withCredentials:true},  
	            async: false,  
	            url:domainUrl.newAddFarmers,
	            data:obj,
	            success : function(allData){
	            
	            	if(allData.code=='0'){
	            		justep.Util.hint("新增养殖户成功！");
				        me.close();
	            	}else{
	            		justep.Util.hint(allData.message, {
				            "type" : "danger"
				        });
	            	}
		
	            }
        });

	};
	//加载类型的数据
	Model.prototype.modelLoad = function(event){
		var typeData = this.comp("typeData");
		var provinceData = this.comp("provinceData");
		loadLocation(provinceData,'',domainUrl.get_province_option)
		typeData.clear();
		typeData.add({
    			'fValue': "个人",
				'fId': "0",
			});
		typeData.add({
			'fValue': "养殖场",
			'fId': "1",
		});
	};


	//省的change事件,加载市的数据
	Model.prototype.select3Change = function(event){
		var cityData = this.comp('cityData');
		var provinceId = $(this.getElementByXid("select3")).val();
		var data = {
			province_id:provinceId
		}
		loadLocation(cityData,data,domainUrl.get_city_option)
		this.comp('districtData').clear();
		this.comp('townData').clear();
		this.comp('villageData').clear();
	};
	//根据市的id加载区的数据（下拉市）
	Model.prototype.select11Change = function(event){
		var districtData = this.comp('districtData');
		var city_id = $(this.getElementByXid("select11")).val();
		var data = {
			city_id:city_id
		}
		loadLocation(districtData,data,domainUrl.get_district_option)
		this.comp('townData').clear();
		this.comp('villageData').clear();
	};
	
	//根据区的id加载镇的数据（下拉区）
	Model.prototype.select10Change = function(event){
		var townData = this.comp('townData');
		var district_id = $(this.getElementByXid("select10")).val();
		var data = {
			district_id:district_id
		}
		loadLocation(townData,data,domainUrl.get_town_option)
		this.comp('villageData').clear();

	};
	
	//根据镇的id获取乡的数据（下拉镇）
	Model.prototype.select8Change = function(event){
		var villageData = this.comp('villageData');
		var town_id = $(this.getElementByXid("select8")).val();
		var data = {
			town_id:town_id
		}
		loadLocation(villageData,data,domainUrl.get_village_option)

	};
	
	
	
	
	//加载省市区的方法
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

	//取消按钮
	Model.prototype.button1Click = function(event){
		this.close();
	};
	return Model;
});