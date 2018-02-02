define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var md5 = require("js/jquery.md5");
	var Model = function(){
		this.callParent();
		this.allUrl ="";
	};
	

	Model.prototype.getCodeBtnClick = function(event){
		window.clearInterval();
		var me=this;
		var fig=true;
		var InterVal;
		var getCodeBtn = $(me.getElementByXid("getCodeBtn"));
		var phone=this.comp("tel").val();
		if(getCodeBtn.text() != "发送验证码" && getCodeBtn.text() != "重新获取验证码") {
			return
		};
		if(!(/^1[34578]\d{9}$/.test(phone))) {
			justep.Util.hint("请输入正确的手机号", {type: 'danger'});
			return;
		} else {
			$.ajax({
				type: "post",
				url: baseUrl.sendVerifyCode,
				dataType: 'json',
				async: false,
				cache: false,
				xhrFields: {
					withCredentials: true
				},
				data: {
					tel: phone,
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						fig = true;
					}else{
						justep.Util.hint(dataAll.message, {type: 'danger'});
						fig = false;
						return;
					}
				}
			});
			var time = 30; //时间
			getCodeBtn.text(time + "秒");
			if(fig){
				InterVal = setInterval(function() {
					if(time == 0) {
						window.clearInterval(InterVal);
						getCodeBtn.text("重新获取验证码");
						time = 30;
						fig = true;
					} else {
						time--;
						getCodeBtn.text(time + "秒");
	
					}
				}, 1000);
			}
		}
	};


	Model.prototype.confirmBtnClick = function(event){
		var me=this;
		var phone = this.comp("tel").val();
		var password = this.comp("password").val();
		var confirmPassword = this.comp("confirmPassword").val();
		var checkCode = this.comp("checkCode").val();
		if(phone==""){
			justep.Util.hint("请输入电话号码", {type: 'danger'});
		}else if(checkCode==""){
			justep.Util.hint("请输入验证码", {type: 'danger'});
		}else if(password==""){
			justep.Util.hint("请输入密码", {type: 'danger'});
		}else if(password!=confirmPassword){
			justep.Util.hint("两次输入的密码不一样", {type: 'danger'});
		}else{
				$.ajax({
				type: "post",
				url: baseUrl.resetPassword,
				dataType: 'json',
				async: false,
				cache: false,
				xhrFields: {
					withCredentials: true
				},
				data: {
					tel: phone,
					password:$.md5(password),
					checkCode:checkCode
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						justep.Util.hint("修改成功！");
						setTimeout(function() {
							var url = './login.w';	
							justep.Shell.showPage(require.toUrl(url),{tel:phone}); 
							me.comp("tel").val("");
							me.comp("password").val("");
							me.comp("confirmPassword").val("");
							me.comp("checkCode").val("");
						},2000)
					}else{
						justep.Util.hint(dataAll.message, {type: 'danger'});
					}
				}
			});
			
			
		}
	};


	Model.prototype.modelParamsReceive = function(event){
		var userInfo = sessionStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		if(userInfoArr !=null){
			this.comp('tel').val(userInfoArr.tel);
			$(this.getElementByXid("tel")).prop('readonly', true)
		}
	};




	return Model;
});