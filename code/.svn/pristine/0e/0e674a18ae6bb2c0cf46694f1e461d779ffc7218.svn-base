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
	async: false, //同步执行
	url: allUrl.getNewsDetailsMsg,
	data: {
		id: newsId
	},
	success: function(dataAll) {
		if(dataAll.success) {
			var Data = dataAll.data;
			$('.news_details_title').html(Data.title)
			$('.news_details_content').append(Data.content);
		} else {

		}
	}
});
});