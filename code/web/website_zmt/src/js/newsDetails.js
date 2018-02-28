/**
 *
 * Created by dev on 2018/1/16
 * 模块：新闻详情
 */

$(document).ready(function() {
	//新闻详情加载
	var newsId = localStorage.getItem("newsId");
	$.ajax({
	type: "post",
	async: true, //同步执行
	dataType: 'json',
	crossDomain: true == !(document.all),
	url: allUrl.getNewsDetailsMsg,
	data: {
		id: newsId
	},
	success: function(dataAll) {
		if(dataAll.success) {
			var Data = dataAll.data;
			var nowTime = getDate(Data.createTime,"-");
			$('.news_details_time').text(nowTime);
			$('.news_details_title').html(Data.title)
			$('.news_details_content').append(Data.content);			
			$('#newTitle').text(Data.title);
			$('#newsDescription')[0].content=Data.description;
			$('#newsKeywords')[0].content=Data.keywords;
					
			

		} else {
			layer.alert(dataAll.message, {
					skin: 'layui-layer-lan'
			});
		}
	}
});

//返回按钮的操作
$(document).on('click','.newsDetales_back',function(){
	window.location.href = './news.html'
	s
})


//时间戳转化成yyyy-mm-dd格式
function getDate(timeData,style) {   //timeData 为时间戳  style为年月日中间拼接的样式
    var time = new Date(timeData);
    var time = time.toLocaleDateString().replace(/\d+/g,function (a,b) {
      if(a.length == 1){
        var a =  '0'+a
      }
      return a
    });
    return time.replace(/\//g,style||'-')
  };
});