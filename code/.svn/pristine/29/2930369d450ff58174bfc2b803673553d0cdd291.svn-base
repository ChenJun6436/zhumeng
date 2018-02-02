/**
 * Created by admin on 2018/1/17
 * 模块：头部导航和底部
 */
$(document).ready(function() {
	$.ajax({
		type: "post",
		async: true, //同步执行
//		dataType: 'json',
		url: allUrl.homeFooter,
		success: function(dataAll) {
			if(dataAll.code == 200) {
				
				//头部SEO
				var seoData=dataAll.data.seo;
				if(seoData){
					$('#title').text(seoData.title);
					if($('#description')[0]){
						$('#description')[0].content=seoData.description;
						$('#keywords')[0].content=seoData.keywords;
					}
					
				}
				//底部
				var bottomData=dataAll.data.bottom;
				if(bottomData){
					var bottomArr=["tel","phone","addres","record","wxName","wbName"];
					$.each(bottomArr,function(index,data){
						$('.bottom-'+data).text(bottomData[data])
					});
					$('.footer_weibo').attr('src',bottomData.wbImg);
					$('.footer_weixin').attr('src',bottomData.wxImg);
				};
				
				//底部:友情链接
				var friendLinkData=dataAll.data.bottom.friendLink;
				if(friendLinkData){
					var lis="";
					$.each(friendLinkData, function(index,data) {
						lis+='<li><a href="'+data.url+'">'+data.name+'</a></li>'
					});
					$('.blogroll').append(lis);
				}
			} else {
				layer.alert(dataAll.message, {
					skin: 'layui-layer-lan'
				});
			}
		}
	});
});
