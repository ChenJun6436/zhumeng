/*
 * 出入库详情
 */
$(document).ready(function() {
	var entryOutDatil = sessionStorage.getItem('entryOutDatil');
	var entryOutDatilArr = JSON.parse(entryOutDatil);
	var pTitle = $(parent.$("#entryOutDatil-form")[0]).parent().text();
	var entryOutDatilsArr=['code','name','tel','companyAddress','pigNum','pigWeight'];
	if(pTitle=='出库单详情'){
		entryOutDatilsArr.push('saleAddress');
		$('.supplier_infor_font').text('销售商信息:');
		$('.name_font').html('销&nbsp;售&nbsp;&nbsp;商:');
		$('.code_font').text('出货单号:');
		$('.salesAdd').removeClass('none');
	};
	$.each(entryOutDatilsArr,function(i,ele){
		if(ele=='companyAddress'){
			if(entryOutDatilArr.companyAddress){
			$('.companyAddress').html(entryOutDatilArr.companyAddress);
			$('.companyAddress').prop("title",entryOutDatilArr.companyAddress)
			}else{
				$('.companyAddress').prop("title",entryOutDatilArr.address)
				$('.companyAddress').html(entryOutDatilArr.address);
			}
		}else{
			
			$('.'+ele).prop("title",entryOutDatilArr[ele])
			$('.'+ele).html(entryOutDatilArr[ele]);
		};
	});
	//车辆信息获取
	if(entryOutDatilArr.cars){
		if(entryOutDatilArr.cars.length>5){
			$('#cars_infor_table').addClass('scrollBar')
		};
		var tableTbody='';
		 $.each(entryOutDatilArr.cars, function(index,car){
		 	tableTbody+=('<tr><td>'+(index+1)+'</td><td>'+car.driver+'</td><td>'+car.tel+'</td><td>'+car.carNo+'</td></tr>');
		 });
		$("#cars_infor_table").append(tableTbody);
	}
});