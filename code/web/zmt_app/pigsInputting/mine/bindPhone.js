define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
	};
	
	//点击获取验证码
	Model.prototype.span3Click = function(event){
		window.clearInterval();
		var me=this;
		var fig=true;
		var InterVal;
		var reg = /^[1][34578][0-9]{9}$/;
		var getCodeBtn = $(me.getElementByXid("getCodeBtn"));
		var phone=this.comp("newPhone").val();  //获取当前账号登录的电话
		if(getCodeBtn[0].innerText == "获取验证码" || getCodeBtn[0].innerText == "重新获取验证码") {
			 if(phone === ''){
	                justep.Util.hint('请填写手机号！',{'type':'danger'});
	                return;
	             }else if(!reg.test(phone)){
	                justep.Util.hint('手机号码格式不正确！',{'type':'danger'});
	                return;
	            }
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
		var time = 60; //时间
		getCodeBtn.text(time + "秒");
		if(fig){
			InterVal = setInterval(function() {
				if(time == 0) {
					window.clearInterval(InterVal);
					getCodeBtn.text("重新获取验证码");
					time = 60;
					fig = true;
				} else {
					time--;
					getCodeBtn.text(time + "秒");

				}
			}, 1000);
		}
		}else{
			return
		};

	};
	
	//修改手机号码的确认
	Model.prototype.button1Click = function(event){
		var checkCode = this.comp("input2").val();
		var phone = this.comp("newPhone").val();
		var account =userInfoArr.loginName;  //获取当前用户登录的账号
		$.ajax({
			type: "post",
			url: baseUrl.updatePhone,
			dataType: 'json',
			async: false,
			cache: false,
			xhrFields: {
				withCredentials: true
			},
			data: {
				account:account,
				tel: phone,
				checkCode:checkCode
			},
			success: function(dataAll) {
				if(dataAll.code == 0) {
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
	
	//加载数据
	var userInfoArr;
	Model.prototype.modelLoad = function(event){
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
	};
	
	
	return Model;
});