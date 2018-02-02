/**
 * Created by dev on 2017/11/08.
 *
 *
 * 模块：登陆
 */
$(document).ready(function() {

	//获取验证图片
	jQuery.fn.getCode = function() {
		var timestamp = new Date().getTime();
		$("#code_img").attr("src", allUrl.loginGetPictureVeritfCode + "?token=b01ad47000d0b2b719fe390ae15e8612&timestamp=" + timestamp);
	};
	$.fn.getCode();
	/*
	 * 忘记密码
	 */
	$(document).on('click', '.forget-password', function() {
		$('.login,.forget-password').addClass('none');
		$('.new-password,.back_login').removeClass('none');
		$('.login-right-title').text('忘记密码');
	});
	
	/*
	 * 返回登录页面
	 */
	$(document).on('click','.back_login',function(){
		$('.login,.forget-password').removeClass('none');
		$('.new-password,.back_login').addClass('none');
		$('.login-right-title').text('欢迎登录!');
	})
	/**
	 * 登陆
	 */
	var role;
	$(document).on('click', '.loginBtn', function(e) {
		var txt = $('.login-right-title').text();
		var form, urls;
		var allValues = {};
		if(txt == "忘记密码") {
			var phone = $.trim($("#phone").val());
			form = $('.new-password');
			urls=allUrl.loginResetPassword;
		} else {

			form = $('.login');
			urls=allUrl.login
		}
		var values = form.serializeArray();
		var fig = true;
		$.each(values, function(i, v) {
			if(v.value == "") {
				$('input[name=' + v.name + ']').parent().css("border", "1px solid #fa8564");
				fig = false;
			} else {
				fig = true;
				$('input[name=' + v.name + ']').parent().css("border", "");
			}
			if(v.name == "password") {
				allValues[v.name] = $.md5(v.value);
			} else {
				allValues[v.name] = v.value;
			}
		});
		allValues.timestamp = 1508998573824;
		allValues.token = 'b01ad47000d0b2b719fe390ae15e8612';
		e.preventDefault();
		$("#new-password").blur();
		if(fig&&pass) {
			$.ajax({
				type: "post",
				async: true, //同步执行
				url: urls,
				xhrFields: {
					withCredentials: true
				},
				dataType: "json",
				data: allValues,
				success: function(dataAll) {
					if(dataAll.code == 0) {
						var userResources = dataAll.data.userResources;
						var resourceName = [];
						$.each(userResources, function(i, res) {
							resourceName.push(res.resourceName)
						});
						if(resourceName[0]== '首页'){
								role = "./../index.html";
						}else{
							for(var name in resourceName) {
								if(resourceName[name] == '建档管理') {
									role = "../filing_manage/filing_manage.html"
								} else if(resourceName[name] == '养殖管理') {
									role = "../breed_manage/breed_manage.html"
								} else if(resourceName[name] == '屠宰场管理') {
									role = "../butcher_manage/butcher_manage.html"
								} else if(resourceName[name] == '屠宰场出入库数据') {
									role = "../butcher_manage/entryOutDataSelsct.html"
								} else if(resourceName[name] == '检验中心') {
									role = "../testing_center/testing_center.html"
								} else if(resourceName[name] == '市场管理') {
									role = "../market_manage/market_manage.html"
								} else if(resourceName[name] == '账号管理') {
									role = "../account_manage/account_manage.html"
								} else if(resourceName[name] == '基础配置') {
									role = ""
								} else if(resourceName[name] == '角色管理') {
									role = "../basic_configuration/role management.html"
								} else if(resourceName[name] == '地址管理') {
									role = "../basic_configuration/address_manage.html"
								} else if(resourceName[name] == '生猪品种管理') {
									role = "../basic_configuration/pig_breed_manage.html"
								}
							}
						}
						$.fn.storageInfo(dataAll.data);
					} else {
						$.fn.getCode();
						layer.alert(dataAll.message, {
							skin: 'layui-layer-lan'
						});

					}
				}
			})
		} else {
			layer.alert("请解决红色标记", {
				skin: 'layui-layer-lan'
			});
			$.fn.getCode();
		}
	});
	//存储登录信息
	jQuery.fn.storageInfo = function(data) {
		if(typeof(Storage) !== "undefined") {
			sessionStorage.userInfo = JSON.stringify(data);
			window.location.href = role;
			//			$.each(role, function(k, e) {
			//				if(k == data.role) {
			//					
			//				}
			//			});
		} else {
			alert("抱歉！您的浏览器不支持 Web Storage ...");
		}
	};
	//按键绑定
	$(document).keypress(function(e) {
		// 回车键事件  
		if(e.which == 13) {
			$('#loginBtn').click();
		}
	});
	/**
	 * 更换验证码
	 */
	$(document).on('click', '#code_img', function() {
		$.fn.getCode();
	});
	/**
	 * 忘记密码获取验证码
	 */
	$(document).on('click', '#send_code', function() {
		window.clearInterval();
		var me = this;
		var InterVal;
		var fig = true;
		var phone = $.trim($("#phone").val());
		var txt = $(me).text();
		if(txt != "发送验证码" && txt != "重新发送") {
			return
		};
		if(!(/^1[34578]\d{9}$/.test(phone))) {
			layer.msg("请输入正确的手机号");
			$("#phone").parent().css('border', '1px solid #fa8564');
			return;
		} else {

			$.ajax({
				type: "post",
				url: allUrl.loginSendVerifyCode,
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
						layer.alert(dataAll.message,{
							skin: 'layui-layer-lan'
						});
						fig = false;
						return;
					}

				}
			});
			var time = 60; //时间
			$(me).html(time + "秒");
			if(fig){
				InterVal = setInterval(function() {
					if(time == 0) {
						window.clearInterval(InterVal);
						$(me).text("重新发送");
						time = 60;
						validCode = true;
					} else {
						time--;
						$(me).text(time + "秒");
	
					}
				}, 1000);
			}

		}
		
	

	});
	/*
	 * 新密码验证
	 */
	var pass = true;
	$(document).on('blur', '#new-password', function() {
		var txt = $('.login-right-title').text();
		if(txt=="忘记密码"){
			var len = $.trim($(this).val().length);
			if(len==0){
				return false;
			}else if(!(len >5&& len < 15)) {
				layer.alert('请输入密码，密码为6-15位数',{
					skin: 'layui-layer-lan'
				});
				pass = false;
				$(this).parent().css('border', '1px solid #fa8564');
			} else {
				pass = true;
			}
		}
		

	})

});