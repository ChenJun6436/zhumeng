/**
 *
 * Created by dev on 2018/1/16
 * 模块：新闻资讯
 */

$(document).ready(function() {

	//页面加载后请求新闻的相关数据
	//获取公司的新闻
	var totalPageNum1, totalPageNum2; //返回的总条数
	getCompanyNews('1', '1', '5') //公司新闻  页面首次加载时默认为第一页
	getCompanyNews('2', '1', '5') //行业新闻
	//请求公司新闻的数据
	function getCompanyNews(type, page, size) {
		$.ajax({
			type: "post",
			async: false, //同步执行
			url: allUrl.getAllNewsMsg,
			data: {
				type: type,
				page: page,
				size: size
			},
			success: function(res) {
				if(res.success) {
					var newDatas = res.data;
					var ulList = '';
					if(type === '1') {
						$('#companyNews ul').remove()
						$('#companyNews hr').remove()
					} else {
						$('#tradeNews ul').remove()
						$('#tradeNews hr').remove()
					}
					$.each(newDatas.list, function(i, e) {
						ulList += '<ul class="news_list"><li class="news_img"><img src=" ' + e.imgUrl + ' "> </li><li class="news_title"> ' + e.title + ' </li><li class="time_gray"> ' + e.createTime + ' </li><li class="news_content"> ' + e.description + ' </li><li class="news_details" data-id="' + e.id + '">查看详情></li></ul>'
					});
					if(type === '1') {
						totalPageNum1 = newDatas.recordsTotal;
						$('#companyNews').append(ulList);
					} else {
						totalPageNum2 = newDatas.recordsTotal;
						$('#tradeNews').append(ulList);
					}
					
					var ulh = $('.news_list').height();
					$('.news_list img').css('height',ulh+'px' )
					console.log(ulh)
				}
			}
		})

	}

	//给页面添加分页(公司新闻分页)
	/*params
	 * totalPageNum1,后台请求来的新闻总条数
	 * 'newsPageingCom'为显示div框的元素id
	 * type: 1为公司新闻，2为行业新闻
	 */
	var type　= '1';  //默认为公司新闻
	fenye(totalPageNum1,'newsPageingCom',);
	function fenye(totalPageNum1,idCl) {
		layui.use('laypage', function() {
			var laypage = layui.laypage;
			laypage.render({
				elem: idCl, //注意，这里的 newsPageing 是 ID，不用加 # 号
				count: totalPageNum1, //数据总数，从服务端得到
				theme: "#1FB5AD",
				next: '<i class="glyphicon glyphicon-menu-right" aria-hidden="true"><i/>',
				prev: '<i class="glyphicon glyphicon-menu-left" aria-hidden="true"></i>',
				limit: 5,
				layout: ["prev", "page", "next", "skip"],
				jump: function(obj, first) {
					//obj包含了当前分页的所有参数，比如： 
					var curPage = obj.curr;   //得到当前页，以便向服务端请求对应页的数据。
					var pageLimit = obj.limit;  //得到每页显示的条数
					//首次不执行
					if(!first) {
						getCompanyNews(type, curPage,pageLimit)  
					}
				}
			});
		});
	}

	//点击公司新闻按钮
	$(document).on('click', '.companyNewsBtn', function() {
		fenye(totalPageNum1,'newsPageingCom');
		type = "1";
	})

	//点击行业新闻按钮
	$(document).on('click', '.tradeNewsBtn', function() {
		type = "2";
		fenye(totalPageNum2,'newsPageingCom');

	})

	//新闻详情
	$(document).on('click', '.news_title,.news_details', function() {
		var newsId = $(this).attr("data-id");
		localStorage.setItem('newsId', newsId);
		window.location.href = 'newsDetails.html'

	});
});