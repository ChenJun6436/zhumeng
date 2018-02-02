define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.personalDataCustomRefresh = function(event){
		var url = require.toUrl("../data/personalData.json");
		var farmersInfoData=event.source;
		if (farmersInfoData) { farmersInfoData.clear();}
		$.ajax({
			type : "post",  
            dataType : "json",
//            xhrFields:{withCredentials:true},  
//            async: false,  
            url: url,  
//            url:"http://192.168.5.249:8080/crowdfunding/V1.0/jf_publicity/findById",
//            data:{id:self.id },
            success : function(allData){
            	farmersInfoData.loadData(allData.data);
            
            
            }
        });
	};

	Model.prototype.confirmClick = function(event){
		var name=this.comp("name").val();
		var phone=this.comp("phone").val();
		alert("姓名"+name+"     "+"电话"+phone)
	};

	return Model;
});