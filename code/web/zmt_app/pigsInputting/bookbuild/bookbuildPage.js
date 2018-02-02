define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var allData = require("js/loadData");	
	var baseUrl = require("js/baseUrl");
	var Model = function(){
		this.callParent();
	};

	Model.prototype.endDateClick = function(event){
		var startDate=this.comp("startDate").val();
//		if(startDate==""||startDate==null){
//			justep.Util.hint("请选择开始日期", {type: 'danger'});
//			return false ;
//		}else{
			$(this.getElementByXid("endDate")).context.min=startDate;
//		}
	};
	//加载数据
	Model.prototype.bookbuildDataCustomRefresh = function(event){
		this.bookbuildFn(this);

	};
	//点击跳转
	Model.prototype.personClick = function(event){
		var self = this;
		var id = event.bindingContext.$object.val("sign");
		justep.Shell.showPage(require.toUrl("./bookbuildInfo.w"),{
			id:id
		});  
	};

	Model.prototype.searchBtnClick = function(event){
		this.bookbuildFn(this);
		
	};
	Model.prototype.bookbuildFn = function(me){
		var userInfo = localStorage.getItem('userInfo');
		var userInfoArr = JSON.parse(userInfo);
		if(userInfoArr == null) {
			justep.Shell.showPage("login");
			return false;
		}
		var id =userInfoArr.userId;//创建者Id
//		var id="d40baa3f65a34a4e8cdf05684732bb0f";	
		var key = me.comp("searchInput").val();
		var beginDate = me.comp("startDate").val();
		var endDate = me.comp("endDate").val();
		var bookbuildData=me.comp("bookbuildData");
		if (bookbuildData) { bookbuildData.clear();}
		var data={
			id:id,
			keyWords:key,
			beginDate:beginDate,
			endDate:endDate
		};
		for(var key in data){
			if(data[key]==""||data[key]==null){
				delete data[key]
			}
		};
		$.ajax({
			type : "post",  
            dataType : "json",
            xhrFields:{withCredentials:true},  
            async: false,  
            url:baseUrl.bookBuild, 
            data:data, 
            success : function(allData){
            	if(allData.code==0){
            		bookbuildData.loadData(allData.data);
            	}else{
            		justep.Util.hint(allData.message, {type: 'danger'});
            	}
            }
        });
	};


	Model.prototype.endDateChange = function(event){
		this.bookbuildFn(this);
	};

	//切换页面重新加载数据
	Model.prototype.modelParamsReceive = function(event){
		this.comp("searchInput").val("");
		this.comp("startDate").val("");
		this.comp("endDate").val("");
		this.comp("bookbuildData").refreshData()

	};
	
	Model.prototype.onData = function() {
		this.modelParamsReceive();
	}


	Model.prototype.startDateChange = function(event){
		this.bookbuildFn(this);
	};


	Model.prototype.modelUnLoad = function(event){
		justep.Shell.off('onData',this.onData);
	};


	Model.prototype.modelLoad = function(event){
		justep.Shell.on('onData',this.onData,this);
	};


	return Model;
});


