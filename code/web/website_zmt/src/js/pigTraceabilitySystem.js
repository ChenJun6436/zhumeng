/**
 * Created by admin on 2018/1/17
 * 模块：猪溯源监管系统
 */
$(document).ready(function() {
	var paramsData;
	var tabRoot = $('.tabRoot').text();
	if(tabRoot=='生猪溯源系统'){
		paramsData={aanvraagTypeId:1,size:999999};
		
	}else if(tabRoot=='猪产品电商平台'){
		paramsData={aanvraagTypeId:2,size:999999};
	}else if(tabRoot=='猪产业金融中心'){
		paramsData={aanvraagTypeId:3,size:999999};
	}else if(tabRoot=='猪产业数据研究院'){
		paramsData={aanvraagTypeId:4,size:999999};
	};
	$.ajax({
		type: "post",
		async: true, //同步执行
		dataType: 'json',
		crossDomain: true == !(document.all),
		url: allUrl.casePig,
		data:paramsData,
		success: function(dataAll) {
			if(dataAll.success) {
				var listData = dataAll.list;
				//头部轮播
				if(listData){
					var lis="",contents="";
					$.each(listData, function(index,data) {
						lis+='<li title='+data.name+'><a href="#">'+data.name+'</a><span class="case-list-id">'+data.id+'</span></li>';
					});
					$('#caseTab').append(lis);
					$('#caseTab>li:eq(0)').addClass('active');
				};
				var firstId=$('#caseTab>li:eq(0)').find('.case-list-id').text();
//
				getFirstCase({id:firstId},allUrl.casePigGetIdCase);
//				getFirstCase(paramsData,allUrl.casePigGetFirstCase);

			} else {
				layer.alert(dataAll.message, {
					skin: 'layui-layer-lan'
				});
			}
		}
	});
	//获取第一个案例内容
	function getFirstCase(id,url){

		$.ajax({
			type: "post",
			async: true, //同步执行
			dataType: 'json',
			crossDomain: true == !(document.all),
			url: url,
			data:id,
			success: function(dataAll) {
				if(dataAll.success) {
					var caseContentData = dataAll.data;
					
					//头部轮播
					if(caseContentData){
						$('.tab-content>div').remove();
						var contents='<div class="tab-pane fade in active"><p class="case-title">'+caseContentData.name+'</p><div class="case-content">'+caseContentData.content+'</div></div>'
						$('.tab-content').append(contents);
//						var windowWid = $(window).width();
//						fixedFn(windowWid)
					};
					
					
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					});
				}
			}
		});
	};

	function fixedFn(windowWid){
		var h =  $('.tab-content').height();
		if(windowWid>=768&&h>300){		
			var top = $('.case')[0].offsetTop;
			var left = $('.case')[0].offsetLeft;
			if(left>200){
				left=left-35
			}
			$('.case-tab-menu').addClass('navbar-fixed-top').next().addClass('col-md-offset-2 col-sm-offset-3 col-xs-offset-0');
			$('.case-tab-menu.navbar-fixed-top').css({'top':top+'px','left':left+'px'})
			
		}else{
			$('.case-tab-menu').removeClass('navbar-fixed-top').next().removeClass('col-md-offset-2 col-sm-offset-3 col-xs-offset-0');
			
		}
	};
	// 滑动滚动条
		$(window).scroll(function(){
		// 滚动条距离顶部的距离 大于 200px时
		var offsetTop = $('.case')[0].offsetTop;
		
		console.log(offsetTop)
		if($(window).scrollTop() >= offsetTop){
				$('.case-tab-menu.navbar-fixed-top').css('top','80px');
			} else{
				$('.case-tab-menu.navbar-fixed-top').css('top',offsetTop+'px');
			}
		});
	
	$(document).on('click','.case-nav>li',function(){
		var caseId = $(this).find('.case-list-id').text();
		$('.case-nav>.active').removeClass('active');
		$(this).addClass('active');
		getFirstCase({id:caseId},allUrl.casePigGetIdCase);
	});
});