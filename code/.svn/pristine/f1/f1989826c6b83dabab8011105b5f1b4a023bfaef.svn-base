define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var md5 = require("js/jquery.md5")
	var Model = function(){
		this.callParent();
	};


	//修改密码的确定按钮
	Model.prototype.button1Click = function(event){
		var conNewPassWord = this.comp("conNewPassWord").val();
		var newPassWord = this.comp("newPassWord").val();
		var oldPassWord = this.comp("oldPassWord").val();
		 if(oldPassWord==""){
			justep.Util.hint("请输入旧密码！", {type: 'danger'});
			return false;
		}else if(conNewPassWord==""){
			justep.Util.hint("请输入新密码！", {type: 'danger'});
			return false;
		}else if(newPassWord==""){
			justep.Util.hint("请输入确认密码！", {type: 'danger'});
			return false;
		}
		if(oldPassWord ==newPassWord){
			justep.Util.hint("新密码与旧密码一致！", {type: 'danger'});
			return false;
		}
		if(conNewPassWord!=newPassWord){
			justep.Util.hint("新密码与确认密码不一致！", {type: 'danger'});
			 return false;
		}

		var userInfo = localStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		var loginName = userInfoArr.loginName;  //获取当前用户登录的账号或者loginName以及电话，都可
		//请求修改密码的路径
		$.ajax({
			type: "post",
			url: baseUrl.updatePassword,
			dataType: 'json',
			async: false,
			cache: false,
			xhrFields: {
				withCredentials: true
			},
			data: {
				account:loginName,
				password: $.md5(oldPassWord),
				newPassword:$.md5(newPassWord)
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
					//退出登录
					var url = './../user/login.w';
					justep.Shell.showPage(require.toUrl(url));
					localStorage.removeItem('userInfo');
		
				}else{
					justep.Util.hint(dataAll.message, {type: 'danger'});
					return;
				}
			}
		});
		
		
	

	};
	//新密码失去焦点事件
	Model.prototype.newPassWordBlur = function(event){


	};
	//确认密码失去焦点的时候
	Model.prototype.conNewPassWordBlur = function(event){

	};
	//忘记密码的页面跳转
	Model.prototype.span4Click = function(event){
	
		var url = './../user/retrieverPassword.w';
		justep.Shell.showPage(require.toUrl(url));

	};
	return Model;
});