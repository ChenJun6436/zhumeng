define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	require("cordova!phonegap-plugin-barcodescanner");
	
	//使用的cordova插件
	var Model = function(){
		this.callParent();
	};
		//底部按钮图片切换
	Model.prototype.allContentsActiveChanged = function(event){
		var homeBtn = this.comp("homeBtn");
		var bookbuildBtn = this.comp("bookbuildBtn");
		var mineBtn = this.comp("mineBtn");
		var farmerBrn = this.comp("farmerBrn");
		var active = event.source.active;
		
		if(active == 0){
			homeBtn.set({
				"icon" :  "img:$UI/pigsInputting/img/shouye12x.png"
			});
			
			homeBtn.setCSS({
				"color" : "#75DA94"
			});
			
			bookbuildBtn.set({
				"icon" : "img:$UI/pigsInputting/img/jiandangjilu22x.png"
					
					
			});
			bookbuildBtn.setCSS({
				"color" : "#FFFFFF"
			});

			mineBtn.set({
				"icon" : "img:$UI/pigsInputting/img/wode22x.png"
			});
			mineBtn.setCSS({
				"color" : "#FFFFFF"
			});
			farmerBrn.setCSS({
				"color" : "#FFFFFF"
			})
			farmerBrn.set({
				"icon" : "img:$UI/pigsInputting/img/wodeyangzhihu22x.png"
			});
			
			
		}else if(active == 1){
			homeBtn.set({
				"icon" :  "img:$UI/pigsInputting/img/shouye22x.png"
			});
			homeBtn.setCSS({
				"color" :"#FFFFFF"
			});
			bookbuildBtn.set({
				"icon" : "img:$UI/pigsInputting/img/jiandangjilu12x.png"
			});
			bookbuildBtn.setCSS({
				"color" : "#75DA94"
			});

			mineBtn.set({
				"icon" : "img:$UI/pigsInputting/img/wode22x.png"
			});
			mineBtn.setCSS({
				"color" : "#FFFFFF"
			});
			farmerBrn.setCSS({
				"color" : "#FFFFFF"
			})
			farmerBrn.set({
				"icon" : "img:$UI/pigsInputting/img/wodeyangzhihu22x.png"
			});
			
			
		}else if(active == 2){
			homeBtn.set({
				"icon" :  "img:$UI/pigsInputting/img/shouye22x.png"
			});
			homeBtn.setCSS({
				"color" : "#FFFFFF"
			});
			bookbuildBtn.set({
				"icon" : "img:$UI/pigsInputting/img/jiandangjilu22x.png"
			});
			bookbuildBtn.setCSS({
				"color" : "#FFFFFF"
			});

			mineBtn.set({
				"icon" : "img:$UI/pigsInputting/img/wode22x.png"
			});
			mineBtn.setCSS({
				"color" : "#FFFFFF"
			});
			farmerBrn.setCSS({
				"color" : "#75DA94"
			})
			farmerBrn.set({
				"icon" :"img:$UI/pigsInputting/img/wodeyangzhihu12x.png"
			});
		}else if(active == 3){
			homeBtn.set({
				"icon" :  "img:$UI/pigsInputting/img/shouye22x.png"
			});
			homeBtn.setCSS({
				"color" : "#FFFFFF"
			});
			bookbuildBtn.set({
				"icon" : "img:$UI/pigsInputting/img/jiandangjilu22x.png"
			});
			bookbuildBtn.setCSS({
				"color" : "#FFFFFF"
			});

			mineBtn.set({
				"icon" : "img:$UI/pigsInputting/img/wode12x.png"
			});
			mineBtn.setCSS({
				"color" : "#75DA94"
			});
			farmerBrn.setCSS({
				"color" : "#FFFFFF"
			})
			farmerBrn.set({
				"icon" : "img:$UI/pigsInputting/img/wodeyangzhihu22x.png"
			});
		}
		var to = event.to;
		if (to >= 1) {
			this.comp('navContainer' + (to + 1)).load();
		}
	};
	

	Model.prototype.confirmBtnClick = function(event){
		var id=this.comp("input2").value;
		if(id==""||id==null){
			justep.Util.hint("请输入ID号或扫码！", {type: 'danger'});
			return false;
		}else{
			$(this.getElementByXid("idNo")).text(id);
			this.comp("popOver").show();

		}
	};

	Model.prototype.image2Click = function(event){
	//扫描二维码，返回二维码信息
		/*cordova.plugins.barcodeScanner.scan(
		 function (result) {
		 alert("We got a barcode\n" +
		 "Result: " + result.text + "\n" +
		 "Format: " + result.format + "\n" +
		 "Cancelled: " + result.cancelled);
		 },
		 function (error) {
			 alert("Scanning failed: " + error);
		 }
		);
*/
	};
	//询问框的确定按钮事件
	Model.prototype.messageDialog1Yes = function(event){
			var pigId=this.comp("input2").value;
			var url = 'index/add.w';
			justep.Shell.showPage(require.toUrl(url),{
				id:pigId
			});
	};
	//激活id
	Model.prototype.activeIdClick = function(event){
		var _this=this;
		var pigId=$(this.getElementByXid("idNo")).text();
		var userInfo = localStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		$.ajax({
				type: "post",
				url: baseUrl.activeSign,
				dataType: 'json',
				async: false,
				cache: false,
				xhrFields: {
					withCredentials: true
				},
				data: {
					sign: pigId,
					userId:userInfoArr.userId
				},
				success: function(dataAll) {
					if(dataAll.code == 0) {
						var url = 'index/dataEntry.w';
						justep.Shell.showPage(require.toUrl(url),{
							id:pigId
						});
						_this.comp("popOver").hide();
						_this.comp("input2").val("")
					}else{
						justep.Util.hint(dataAll.message, {type: 'danger'});
					}
				}
			});
			
	};

	


	

	Model.prototype.modelParamsReceive = function(event){
		//	获取id

		/*
		1、参数接收事件
		2、根据参数获取ID
		*/
		if (this.params && this.params.id) {
			this.id = this.params.id;
			this.comp("input2").val(this.id )
		};
		
	
	};
	//关闭取消按钮
	Model.prototype.closeClick = function(event){
		this.comp("popOver").hide();
	};
	//加载完成
	Model.prototype.modelLoad = function(event){
		var userInfo = localStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		if(userInfoArr == null) {
//			alert("请重新登录！");
			var url = require.toUrl("user/login.w");
			justep.Shell.showPage(url);
		}
	};


	Model.prototype.modelActive = function(event){
		justep.Shell.fireEvent("onData", {id:'id的值'});
		justep.Shell.fireEvent("onMinePageData", {id:'id的值'});
		justep.Shell.fireEvent("onFarmerData", {id:'id的值'});
	};
	Model.prototype.homeBtnClick = function(event){
		this.comp("input2").val(null);
	};



	


	

	Model.prototype.farmerPageActive = function(event){
//		debugger;

	};


	


	

	return Model;
});