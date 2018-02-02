define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var MsgDialog = require("$UI/system/components/justep/messageDialog/messageDialog");
	var domainUrl = require("js/baseUrl");
	var md5 = require("js/jquery.md5");
	var Model = function(){
		this.callParent();
	};

	
	
	Model.prototype.addressBtnClick = function(event){
//		var url = './address.w';
//			justep.Shell.showPage(require.toUrl(url),{
////				id:id
//			});
	};

	Model.prototype.passWordBtnClick = function(event){
		var url = './passWord.w';
		justep.Shell.showPage(require.toUrl(url));
	};

	Model.prototype.col19Click = function(event){
		var url = './infor.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	//点击编辑时修改姓名
	Model.prototype.image1Click = function(event){
		var me = this;
		var personalData = me.comp('personalData');
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		var str=userInfoArr.tel;
		var str2 = str.substr(0, 3) + '****' + str.substr(7);
		var curUserName = me.comp('input1').val();
		//当点击编辑后，不修改点击取消，再次点击编辑，input框再次默认为当前登录用户的名字
		if(userInfoArr.name !=curUserName){
			personalData.clear();
			personalData.add({
				name:userInfoArr.name,
				phone:str2
			})
		}	
		$(me.getElementByXid("span2")).addClass("isShow");
		$(me.getElementByXid("image1")).addClass("isShow");
		$(me.getElementByXid("input1")).removeClass("isShow");
		$(me.getElementByXid("row14")).removeClass("isShow");
	};
	//点击修改联系方式
	Model.prototype.row1Click = function(event){
		var url = './updatePhone.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	//修改登录密码的跳转
	Model.prototype.row3Click = function(event){
		var url = './passWord.w';
		justep.Shell.showPage(require.toUrl(url));
		

	};
	//地址管理
	Model.prototype.row7Click = function(event){
		var url = './address.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	//密码修改
	Model.prototype.row9Click = function(event){
		var url = '../user/retrieverPassword.w';
		justep.Shell.showPage(require.toUrl(url));
	};
	//保存按钮
	Model.prototype.button2Click = function(event){
		var me = this;
		var userId = userInfoArr.userId;
		var name = this.getElementByXid("input1").value;
		if(name ==""){
			justep.Util.hint("名称不能为空！", {
	            "type" : "danger"
	        });
	        return
		}
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:domainUrl.saveBaseMessage,
            data:{
            	userId:userId,
            	name:name
            },
            success : function(allData){
            	if(allData.code=='0'){
            		justep.Util.hint("修改成功！");
            		userInfoArr.name = name;
            		var data = JSON.stringify(userInfoArr);
            		localStorage.setItem("userInfo",data);
            		me.getElementByXid("span2").textContent = name;
            		$(me.getElementByXid("span2")).removeClass("isShow");
					$(me.getElementByXid("image1")).removeClass("isShow");
					$(me.getElementByXid("input1")).addClass("isShow");
					$(me.getElementByXid("row14")).addClass("isShow");	
            	}else{
            		justep.Util.hint(allData.message, {
			            "type" : "danger"
			        });
            	}
	
            }
        });	
		

	};
	
	//取消按钮
	Model.prototype.button4Click = function(event){
		var me = this;		
		$(me.getElementByXid("span2")).removeClass("isShow");
		$(me.getElementByXid("image1")).removeClass("isShow");
		$(me.getElementByXid("input1")).addClass("isShow");
		$(me.getElementByXid("row14")).addClass("isShow");

	};
	//数据接收参数
	var userInfoArr;
	Model.prototype.modelParamsReceive = function(event){
		var me = this;
		var userInfo = localStorage.getItem('userInfo');
		userInfoArr = JSON.parse(userInfo);
		if(userInfoArr !=null){
			var account = localStorage.getItem('account');
			var password = localStorage.getItem('password');
			$.ajax({
				type: "post",
				url: domainUrl.appLogin,
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
				success:function(data){
					if(data.code=='0'){
						var Data = data.data;
						if((Data.name != userInfoArr.name)||(Data.tel != userInfoArr.tel)){
							localStorage.removeItem(userInfoArr);
							sessionStorage.userInfo = JSON.stringify(Data);
						}
						me.getElementByXid("span2").textContent = Data.name;
						var str=Data.tel;
						var str2 = str.substr(0, 3) + '****' + str.substr(7);
						me.getElementByXid("span3").textContent = str2;
						var personalData = me.comp("personalData");
						personalData.clear();
						personalData.add({
							name:Data.name,
							phone:str2
						})
					}else{
						alert(data.message)
					
					}
			}
		})
		}
	};
	//退出登录
	Model.prototype.button1Click = function(event){
		var that=this;
		if (!that.msg)
		that.msg = new MsgDialog({
			parentNode : that.getElementByXid("titlebar")
		});
        that.msg.on('onClose', function(event) {		         
			  if (event.button == "no") {
                    return false;
            } else {
            	localStorage.removeItem('userInfo');
				var url = 'user/login.w';
				justep.Shell.showPage(require.toUrl(url));
            }
		}, that);
        that.msg.show({
			type : 'YesNo',
			title : '提示',
			message : '<p style="text-align: center;">是否退出登录？</p>',
				width : 270
			});
//		window.location.href="https://open.ys7.com/view/h5/23c327c9f0f0410c894775254c150216";
	};
	
	Model.prototype.onMinePageData = function() {
		this.modelParamsReceive();
	}
	
	Model.prototype.modelUnLoad = function(event){
		justep.Shell.off('onMinePageData',this.onMinePageData);

	};
	//数据的加载
	
	Model.prototype.modelLoad = function(event){
		justep.Shell.on('onMinePageData',this.onMinePageData,this);
	};

	

	return Model;
});


