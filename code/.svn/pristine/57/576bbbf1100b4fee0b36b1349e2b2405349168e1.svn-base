define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var domainUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
	};
	
	
	//加载数据
	var userInfoArr;
	Model.prototype.modelLoad = function(event){
		justep.Shell.on('onFarmerData',this.onFarmerData,this);
		
	};
	
	//加载数据的方法
	function loadData(data,farmersData){
		farmersData.clear();
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:domainUrl.myFarmers,
            data:data,
            success : function(allData){
            	var data = allData.data;
            	if(allData.code=='0'){
            		$.each(data,function(i,e){
            			farmersData.add({
	            			'createTime': e.createTime,
							'userName': e.userName,
							'farmType': e.farmType =="0"?"个人":"养殖户",
							'phone': e.phone,
							'address':e.address,
							'fooderName':e.fooderName,
							'account':e.account
            			});
            		})
            	}
            }
        });
	
		
	}
	

	Model.prototype.farmerDataCustomRefresh = function(event){
		var farmersData = this.comp('farmerData');
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		if(userInfoArr!=null){
			var data = {
				id:userInfoArr.userId
			};
			loadData(data,farmersData);
	
		}
	};
	
	//我的养殖户详情
	Model.prototype.li1Click = function(event){
		var row = event.bindingContext.$object;
		var url = require.toUrl("./farmersDetails.w");
		justep.Shell.showPage(url,{
			data:row
		});
	};
	
	//新增养殖户
	Model.prototype.button1Click = function(event){
		var url = require.toUrl("./addFarmer.w");
		justep.Shell.showPage(url);

	};
	
	//点击搜索事件
	Model.prototype.image1Click = function(event){
		var me = this;
		var farmersData = me.comp('farmerData');
		var beginDate = me.comp("startDate").value;
		var endDate = me.comp("endDate").value;
		var keyWords = me.comp("input1").value;
		var data= {
			id:userInfoArr.userId,
			keyWords:keyWords,
			beginDate:beginDate,
			endDate:endDate
		}
		for (var key in data ){
			if(data[key]==""||data[key]==undefined){
				delete data[key]
			}
		};
		loadData(data,farmersData);
	};
	

	Model.prototype.modelActive = function(event){
//		var farmersData = this.comp('farmerData');
//		farmersData.refreshData();

	};
	
	//切换页面重新加载数据
	Model.prototype.modelParamsReceive = function(event){
		this.comp("input1").val("");
		this.comp("startDate").val("");
		this.comp("endDate").val("");
		this.comp("farmerData").refreshData()
		

	};
	

	Model.prototype.startDateChange = function(event){
		this.image1Click(event)
	};
	

	Model.prototype.endDateChange = function(event){
		this.image1Click(event)
	};
	Model.prototype.onFarmerData = function() {
		this.modelParamsReceive();
	}

	Model.prototype.modelUnLoad = function(event){
		justep.Shell.off('onFarmerData',this.onFarmerData);
	};
	

	return Model;
});