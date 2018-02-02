define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};
	
	
	
	//接收参数
	Model.prototype.modelParamsReceive = function(event){
		var Data = this.params.data;
		var curData = this.comp('curData');
		curData.clear();
		curData.add({
			account:Data.val("account"),
			address:Data.val("address"),
			createTime:Data.val("createTime"),
			fooderName:Data.val("fooderName"),
			phone:Data.val("phone"),
			userName:Data.val("userName"),
			farmType:Data.val("farmType")=='0'?'个人':'养殖场',
		})	
	};
	

	return Model;
});