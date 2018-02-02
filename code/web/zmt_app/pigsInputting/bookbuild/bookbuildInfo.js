define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var allData = require("js/loadData");
	var baseUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
		this.id="";
	};

	Model.prototype.modelParamsReceive = function(event){
		/*
		1、参数接收事件
		2、根据参数获取ID
		*/
		var self=this;
		if (self.params && self.params.id) {
			self.id = self.params.id;
		}
		
		self.comp('titleBar').set({
	        'title' : "ID:"+self.id
	    });
		var farmersInfoData=self.comp("bookbuilInfoData");
		if (farmersInfoData) { farmersInfoData.clear();}
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url: baseUrl.pigDetails,  
            data:{pig_id:self.id },
            success : function(allData){
            	farmersInfoData.loadData(allData.data);
            }
        });
	};


	return Model;
});