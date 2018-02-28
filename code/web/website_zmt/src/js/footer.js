/**
 * Created by admin on 2018/1/17
 * 模块：头部导航和底部
 */
$(document).ready(function() {
	$.ajax({
		type: "post",
		async: true, //同步执行
		dataType: 'json',
		crossDomain: true == !(document.all),
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
						if(data=='phone'){
							var bottomPhone = bottomData[data];
							var newstr="";
						    for(var i=0;i<bottomPhone.length;i++){
						    	if(i==2||i==6){
						    		newstr+=bottomPhone[i]+'-';
						    	}else{
						    		newstr+=bottomPhone[i]
						    	}
						    }
							$('.bottom-phone').text(newstr);
							
						}else{
							$('.bottom-'+data).text(bottomData[data])
						}
						
					});
					var domainUrl=(bottomData.wbImg).split('/');
						
						if(domainUrl[0]=="http:"){
							$('.footer_weibo').attr('src',bottomData.wbImg);
							$('.footer_weixin').attr('src',bottomData.wxImg);
						}else{
							$('.footer_weibo').attr('src',allUrl.domain+bottomData.wbImg);
							$('.footer_weixin').attr('src',allUrl.domain+bottomData.wxImg);
						}
					
				};
				
				//底部:友情链接
				var friendLinkData=dataAll.data.bottom.friendLink;
				if(friendLinkData){
					var lis="";
					$.each(friendLinkData, function(index,data) {
						lis+='<li><a href="'+data.url+'">'+data.name+'</a></li>'
					});
					$('.blogroll').append(lis);
				}else{
					$('.blogroll').css('display','none')
				}
			} else {
				layer.alert(dataAll.message, {
					skin: 'layui-layer-lan'
				});
			}
		}
	});
	//导航
	
	$(document).on('click','.navbar-toggle,.sub-menu',function(){
		navBar()
		
	});
	function navBar(){
		var flag=$('#navBar').attr('aria-expanded');
		if(flag){
			var navBarHei = $('#navBar').height();
			var windowHei = $(window).height();
			if(navBarHei>windowHei){
				$('#navBar').addClass('navBarSet');
			}
			$('#navBar>.navbar-nav').addClass('navBoxShadow');
		}else{
			$('#navBar>.navbar-nav').removeClass('navBoxShadow');
			$('#navBar').removeClass('navBarSet');
		}
	};
	$(window).resize(function(){ 
		navBar();
	});
});
