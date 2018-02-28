/**
 * Created by admin on 2018/1/17
 * 模块：首页
 */
$(document).ready(function() {
	//轮播
	$.ajax({
		type: "post",
		async: true, //同步执行
		dataType: 'json',
		crossDomain: true == !(document.all),
		url: allUrl.homeBanner,
		success: function(dataAll) {
			if(dataAll.code == 200) {
				
				//头部轮播
				var bannerData=dataAll.data.banner;
				var imgs="",myCarousel="";
				$.each(bannerData, function(index,data) {
					imgs += '<div class="item"><a href="#"><img src=' +(allUrl.domain+data)+ ' alt="第'+(index+1)+'张"></a></div>';
					myCarousel += '<li data-target="#myCarousel" data-slide-to=' +index + '></li>'
				});
				$('.carousel-indicators').append(myCarousel);
				$('.carousel-inner').append(imgs);
				$('.carousel-indicators>li:eq(0),.carousel-inner>div:eq(0)').addClass('active');
				//设置自动播放/5秒
				$(function() {
					$('#myCarousel').carousel({
						interval: 5000
					});
				});
				
				//解决案列
				var solutionData=dataAll.data.solution;
				if(solutionData.length>0){
					Slide(solutionData);
				}else{
					$('.next,.prev').css('display','none')
				}
				
			} else {
				layer.alert(dataAll.message, {
					skin: 'layui-layer-lan'
				});
			}
		}
	});
	//解决案列旋转木马
	var slideBoxW = $('.Slide_box').width();
	var setTop;
	if(slideBoxW>780){
		setTop=25
	}else if(slideBoxW<780&&slideBoxW>500){
		setTop=15
	}else if(slideBoxW<500&&slideBoxW>350){
		setTop=12
	}else{
		setTop=5
	}
	var states = [
            { '&zIndex': 1, top: setTop, width:'35%',left: '5%','maxHeight':'250px', $opacity: 0.9 ,index:1},
            { '&zIndex': 3,top: 0, width:'45%',left: '28%','maxHeight':'280px', $opacity: 1 ,index:2},
            { '&zIndex': 2,top: setTop,width:'35%', left:'64%', 'maxHeight':'250px',$opacity: 0.9,index:3 },
            { '&zIndex':1,top: setTop, width:'35%',left: '100%','maxHeight':'250px', $opacity: 0.9,index:4}
        ]
  	function Slide(solutions){
  		var lis="";
  		$.each(solutions, function(index,data) {					
			lis += '<li class="marquee_inner_img"><img src='+data.imgUrl+' /><span class="index_case_id">'+data.id+'</span>'+
			'<span class="aanvraagTypeId">'+data.aanvraagTypeId+'</span><p class="img_name">'+data.name+'</p></li>';
		});
		$('.Slide_box>ul').append(lis);
		
		move()
  	};
  	
	function move(){
		var liArr=$('.marquee_inner_img');
		$.each(liArr, function(i,lis) {
//			$(this)
			$(this).css({'z-index':states[i]['&zIndex'],'transition': 'none'}).attr({'index': states[i].index}).finish().animate(states[i],1000).find('img').css({'opacity':states[i].$opacity,'max-height':states[i]['maxHeight']})
		
		});

	};
	//下一张 上一张
	$(document).on('click','.next,.prev',function(){
		if(this.className=='next'){
			states.unshift(states.pop());
		}else{
			states.push(states.shift())
		}
		
		move()
	});
	$(document).on('mouseenter','.marquee_inner_img',function(){
		var zIndex = parseFloat($(this).css("z-index"));
		var index = $(this).attr('index')
		var setLeft;
		if(index==1){
			setLeft='5%';
			zIndex=zIndex+3
		}else if(index==2){
			setLeft= '28%'
		}else if(index==3){
			setLeft= '60%'
			zIndex=zIndex+2
		}
		
		$(this).css({'transition':'all 0.6s','z-index':zIndex,'left':setLeft,'transform': 'scale(1.2)'});
		
	});
	$(document).on('mouseleave','.marquee_inner_img',function(){
		var zIndex = parseFloat($(this).css("z-index"));
		var index = $(this).attr('index')
		var setLeft;
		if(index==1){
			setLeft='5%';
			zIndex=1
		}else if(index==2){
			setLeft= '28%'
			zIndex=3
		}else if(index==3){
			setLeft= '64%'
			zIndex=2
		}
		$(this).css({'transition':'all 0.6s','z-index':zIndex,'transform': 'scale(1)','left':setLeft})
	});

	/*成功案例点击*/
	
		$(document).on('click','.marquee_inner_img',function(){
			var caseId = $(this).find('.index_case_id').text();
			var aanvraagTypeId =  $(this).find('.aanvraagTypeId').text();
			if(aanvraagTypeId==1){
				window.location.href = 'successfulCase/pigTraceabilitySystem.html'
			}else if(aanvraagTypeId==2){
				window.location.href = 'successfulCase/pigDirSir.html'
			}else if(aanvraagTypeId==3){
				window.location.href = 'successfulCase/pigFinancial.html'
			}else{
				window.location.href = 'successfulCase/pigData.html'
			}

		});
	
	/*新闻动态*/
	$.ajax({
		type: "post",
		async: true, //同步执行
		dataType: 'json',
		crossDomain: true == !(document.all),
		url: allUrl.homeFindNews,
		success: function(dataAll) {
			if(dataAll.code == 200) {
				var lis="";
				if(dataAll.data.length>0){
					$.each(dataAll.data,function(i,data){
					lis+='<li><div class="col-xs-3 col-sm-3 col-md-2 index_news_time_box"><span class="index_news_time"> '+data.createTime+'</span><span class="circle"><i></i></span></div>'+
					'<div class="col-xs-9 col-sm-9 col-md-10 index_news_content"><span class="index_news_id">'+data.id+'</span><span class="index_news_imgUrl">'+(data.imgUrl)+'</span>'+
						'<p class="index_news_title">'+data.title+'</p><p class="index_news_description">'+data.description+'</p></div></li>'
					});
					$('.index_news_box').append(lis);
					$('.index_news_img').attr('src',dataAll.data[0].imgUrl);
				}else{
					$('.index-news').css('display','none')
				}
			}
		}
	});
	$(document).on('mousemove click','.index_news_title',function(event){
		if(event.type=='mousemove'){
			var imgUrl = $(this).prev();
			$('.index_news_img').attr('src',imgUrl[0].innerText);
		}else{
			var newsId=$(this).parents('li').find('.index_news_id').text()
			localStorage.setItem('newsId', newsId);
			window.location.href = 'newsDetails.html'
		}
		
	})

});