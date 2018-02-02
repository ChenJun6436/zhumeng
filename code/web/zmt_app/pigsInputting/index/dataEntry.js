define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var baseUrl = require("js/baseUrl");
	var allData = require("js/loadData");
	 require("js/main")
	var Model = function(){
		this.callParent();
		this.id="";
	};
	//保存事件
	Model.prototype.saveBtnClick = function(event){
		var userInfo = localStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		var self = this;
		var sign=self.id;//生猪ID
		var pigType=self.comp("variety").val();//生猪类型Id
		var famerId=self.comp("input1").val();//养殖户Id
		var createPeopleId=userInfoArr.userId;//创建者Id
		if(pigType==""){
			justep.Util.hint('请选择生猪类型',{'type':'danger'});   
		}else if(famerId==""){
			justep.Util.hint('请选择养殖户',{'type':'danger'});
		}else{
			$.ajax({
	            type: "post",
	            async : false,
	            data:{
	            	sign:sign,
	            	pigType:pigType,
	            	famerId:famerId,
	            	createPeopleId:createPeopleId
	            },
	            dataType: "json",
	            xhrFields:{withCredentials:true}, 
	            url: baseUrl.dataEntry,
	            success : function(allData) {
	            	if(allData.code==0){
	            		justep.Util.hint('保存成功！',{'type':'success'});
	            		justep.Shell.showPage(require.toUrl("../main.w"));
	            	}else{
	            		 justep.Util.hint(allData.message,{'type':'danger'});  
	            	}
	            	       
	            }
			})
		}
		
		
	};
	//	获取id
	Model.prototype.modelParamsReceive = function(event){
		/*
		1、参数接收事件
		2、根据参数获取ID
		*/
		if (this.params && this.params.id) {
			this.id = this.params.id;
			this.comp("idNumber").val(this.id )
		}
		//生猪种类
		var varietyData=this.comp("varietyData");
		if (varietyData) { varietyData.clear();}
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:baseUrl.getPigType,  
            success : function(allData){
            	if(allData.code==0){
            		varietyData.loadData(allData.data);
            	}else{
            		justep.Util.hint(dataAll.message, {type: 'danger'});
            	}
            }
        });
	};
	//返回上一步
	Model.prototype. backStepBtnClick = function(event){
		var url = '../main.w';
		var pigId=this.comp("idNumber").value;
		justep.Shell.showPage(require.toUrl(url),{
				id:pigId
			});
	};
//	//获取生猪品种
//	Model.prototype.varietyDataCustomRefresh = function(event){
//	
//		var varietyData=this.comp("varietyData");
//		if (varietyData) { varietyData.clear();}
//		$.ajax({
//			type : "post",  
//            dataType : "json",
//            xhrFields:{withCredentials:true},  
//            async: false,  
//            url:baseUrl.getPigType,  
//            success : function(allData){
//            	if(allData.code==0){
//            		varietyData.loadData(allData.data);
//            	}else{
//            		justep.Util.hint(dataAll.message, {type: 'danger'});
//            	}
//            }
//        });
//	};

	//搜索养殖户
	Model.prototype.farmsBtnClick = function(event){
		var self=this;
		var keyWords = this.comp("farms").val();
		var farmersData=this.comp("farmersData");
		if (farmersData) { farmersData.clear();}
		if(keyWords==""){
			justep.Util.hint("请输入养殖户电话或 姓名", {type: 'danger'});
		}else{
			$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:baseUrl.getFarms,  
            data:{
            	keyWords:keyWords
            },
            success : function(allData){
            	if(allData.code==0){
	            	$(self.getElementByXid("farmersInfo")).css("display","block");
	            	
	            	$(self.getElementByXid("famrId,famrName,famrTel,famraddress")).text(null);
	            		$.each(allData.data,function(index,data){
			        	 farmersData.add({
			        		 "famrId":data.id,
							 "userName":data.userName,
							 "famrphone":data.phone,
							 "address":data.address
			        	 })
			        });
			        //根据收索出来的养殖户信息数量增加滚动条
            		var h = $(self.getElementByXid("farmersInfo")).height();
	            	if(h > 160) {
						$(self.getElementByXid("farmersInfo")).addClass('scroll');
					}else{
						$(self.getElementByXid("farmersInfo")).removeClass('scroll');
					}
            	}else{
            		justep.Util.hint(dataAll.message, {type: 'danger'});
            	}
            }
        });
		}
		
	};
	//养殖户地址，id，电话赋值
	Model.prototype.li1Click = function(event){
		var row=event.bindingContext.$object;        //获取list当前行数据
//		var userName = $(this.getElementByXid("userName")).text();
		this.comp("farms").val(row.val('userName'));//养殖户赋值
		this.comp('input1').val(row.val('famrId'));//养殖户ID赋值
		this.comp("phone").val(row.val('famrphone'));//联系电话赋值
		this.comp("famrsAddress").val(row.val('address'));//地址赋值
		$(this.getElementByXid("farmersInfo")).css("display","none");
		
		
	};


	

	
	return Model;
});