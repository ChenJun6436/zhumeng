define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var md5 = require("js/jquery.md5");
	var Model = function(){
		this.callParent();
	};
	
	//图片路径转换
	Model.prototype.toUrl = function(url){
		return url ? require.toUrl(url) : "";
	};
	
	
	Model.prototype.loginBtnClick = function(event){
		var account=this.comp("account").val();
		var password=this.comp("password").val();
		if(account==""){
			justep.Util.hint("请输入账号", {type: 'danger'});
		}else if(password==""){
			justep.Util.hint("请输入密码", {type: 'danger'});
		}else{
			$.ajax({
				type: "post",
				url: baseUrl.appLogin,
				dataType: 'json',
				async: false,
				cache: false,
				xhrFields: {
					withCredentials: true
				},
				data: {
					account: account,
					password:$.md5(password)
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						if(dataAll.data.departmentName=="建档管理部"){
							if(typeof(Storage) !== "undefined") {
//								sessionStorage.userInfo = JSON.stringify(dataAll.data);
								localStorage.userInfo = JSON.stringify(dataAll.data);
								//保存登录时的账号与密码，用来在后台更改用户个人信息时来重新请求数据
								localStorage.account = dataAll.data.loginName;
								localStorage.password = password;
								var url = 'index.w';	
								justep.Shell.closeAllOpendedPages();
	//							window.location.href=require.toUrl(url);
								}
						}else{
							justep.Util.hint("该账户号不是建档账号，请登录建档账号", {type: 'danger'});
						}
					}else{
						justep.Util.hint(dataAll.message, {type: 'danger'});
					}
				}
			});
		};
	};
	Model.prototype.forgetPasswordFontBtnClick = function(event){
		var url = './retrieverPassword.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	Model.prototype.modelParamsReceive = function(event){
		var data=event.data
		if(data.tel){
			this.comp("account").val(data.tel);
		}

	};
	return Model;
});
