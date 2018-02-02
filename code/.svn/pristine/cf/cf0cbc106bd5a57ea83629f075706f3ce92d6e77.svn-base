define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
	};
	//点击确定按钮跳到绑定手机号码的页面
	Model.prototype.button2Click = function(event){
	debugger;
		var me = this;
		var checkedCode = $(me.getElementByXid("input1")).val();
		if(checkedCode !=''){
			$.ajax({
				type: "post",
				url: baseUrl.verifyCheckCode,
				dataType: 'json',
				async: false,
				cache: false,
				xhrFields: {
					withCredentials: true
				},
				data: {
					tel: userInfoArr.tel,
					checkCode:checkedCode
				},
				success: function(dataAll) {
					if(dataAll.code ==='0'){
						var url = './bindPhone.w';
						justep.Shell.showPage(require.toUrl(url));
					}else{
						justep.Util.hint(dataAll.message, {
							"type" : "danger"
						});
					}				
				}
			})
	
		}else{
//				var url = './bindPhone.w';
//						justep.Shell.showPage(require.toUrl(url));
			justep.Util.hint("请先输入验证码！", {
	            "type" : "danger"
	        });
		}
		
			
			
			
			
	

	};
	//点击获取验证码
	Model.prototype.button1Click = function(event){
		window.clearInterval();
		var me=this;
		var fig=true;
		var InterVal;
		var getCodeBtn = $(me.getElementByXid("codeBtn"));
		var phone=userInfoArr.tel;  //获取当前账号登录的电话
		if(getCodeBtn[0].innerText == "获取验证码" || getCodeBtn[0].innerText == "重新获取验证码") {
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
	//数据加载
	var userInfoArr;
	Model.prototype.modelLoad = function(event){
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		var str=userInfoArr.tel;
		var str2 = str.substr(0, 3) + '****' + str.substr(7);
		this.getElementByXid("col2").textContent = str2;
	};

	return Model;
});