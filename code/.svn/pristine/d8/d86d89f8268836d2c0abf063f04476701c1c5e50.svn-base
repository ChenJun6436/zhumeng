/**
 * Created by dev on 2017/11/01.
 *
 *
 * 模块：屠宰管理-生猪详情
 */

$(document).ready(function() {
	var pigDetail = sessionStorage.getItem('pigDetail');
	var cellData = JSON.parse(pigDetail);
	if(cellData.role=='normalUser'){
		$('.butcher_m,.personnel').addClass('none');
	}
	$.pigDetails(cellData, ".butcher_details", ".detailsArea", ".pigArea");
	//返回上一页
//	$(document).on('click', '.backUpper-toggles', function() {
////		window.location.href = './pigList.html';
//	$("body").load('./pigList.html')
//	});
});