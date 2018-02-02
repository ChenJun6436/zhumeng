define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	
	var Model = function(){
		this.callParent();
	};
	
	//图片路径转换
	Model.prototype.toUrl = function(url){
		return url ? require.toUrl(url) : "";
	};
	Model.prototype.loginBtnClick = function(event){
		var url = 'index.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	Model.prototype.registerBtnClick = function(event){
		var url = 'register.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	return Model;
});