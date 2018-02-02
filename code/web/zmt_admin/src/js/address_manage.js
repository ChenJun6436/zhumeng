/*地址管理*/
$(document).ready(function(){
	$.login();
	var rloeType = $.isRloe('地址管理');
	if(rloeType =='0'){
		$('.addBtn').removeClass('none')
	}
	$.addressFn("#address",allUrl.find_province_option);
	 //bottom的table
	var  columnArrs= ["villageId","status","provinceName","cityName","districtName","townName","villageName",null];
	var columnDefArrs=[{
			targets: 1,
            orderable: false,
            visible:false
		},{
			targets: 2,
            orderable: false,
            render: function (data) {                	
            	if(data=="enable"){
            		return	'<p>启用</p>'
            	}else{
            		return '<p>禁用</p>'
            	}
	            
            }
        },{
        	targets:-1,
	        orderable: false,
            render: function (data) { 
            	if(rloeType =='1'){
            		return ('<span>/</span>')
            	}else{
            		if(data.status=="enable"){
	            		return('<a href="#" class="editor text-primary">修改</a><a href="#" class="statusBtn text-orange">禁用</a>')
	            	}else{
	            		return ('<a href="#" class="editor text-primary">修改</a><a href="#" class="statusBtn text-primary">启用</a>')
	            	}
            	}
            	
            	
            }
        }
	];

	function searchValFn(){
		var	searchVal={
			provinceId:$('#address').val(),
			cityId:$('#citys').val(),
			districtId:$('#countys').val(),
			townId:$('#towns').val()
		};
		for(var key in searchVal){
	        if(!(searchVal[key]) || searchVal[key] == 'all'){
	            delete searchVal[key];
	        }
    }
		return searchVal;
	}
	var data =searchValFn();
	var tableAddressM = {
	        id:"tableAddressM",
	        url:allUrl.addressManage,
	        searchParams:data,
	        columns:columnArrs,
	        lengthChange:false,
	        scrollX:true,
	        columnDefs:columnDefArrs,
	        async: true
	}	
	
	var tableAddress=$.createTable(tableAddressM);   
	
	//新增地址
	 
	$(document).on('click',".addBtn",function(){
		var addFig=true;
		var trArrs = $("#tbodyAddressM").find('tr');
		$.each(trArrs, function(index,trArr) {
			if(trArr.lastChild.firstChild.text=="取消"){
				layer.alert("请将页面中未保存的数据进保存或取消",{
					skin: 'layui-layer-lan'
				});
				addFig=false;
				return;
			}
		});
		var len=trArrs.length+1
		if(addFig){
			var addTrs=('<tr><td>'+len+'</td><td class="none">id</td><td><p>正常</p></td>'+
			'<td><select name="addressAdd" class="form-control addressAdd"><option value="all">全部</option></select></td>'+
			'<td><select name="citysAdd" class="form-control citysAdd"><option value="all">所有市</option></select></td>'+
			'<td><select name="countysAdd" class="form-control countysAdd"><option value="all">所有区/县</option></select></td>'+
			'<td class="td-towns"><select name="townAdd" class="form-control townAdd"><option value="all">所有镇</option></select>'+
			'<input type="text" name="townsAdd" class="form-control townsAdd" placeholder="请选择或输入镇" ></td><td class="td-input"><input type="text" name="villageAdd" class="form-control village"></td><td class="handles">'+
			'<a href="#" class="cancel margin-right">取消</a><a href="#" class="addressSave">保存</a></td></tr>');
			$("#tbodyAddressM").append(addTrs);
			//地址
			$.addressFn(".addressAdd",allUrl.find_province_option);
		}
	});

	//取消
	$(document).on('click',".cancel",function(){
		var trs=$(this).parents('tr');
		trs.remove()
	});
	//新增保存
	$(document).on('click',".addressSave",function(){

		var trs=$(this).parents("tr");
		var urls=allUrl.areaAdd;
		addressSaveFn(urls,trs)
		
	});
	//修改,取消
	$(document).on('click',".editor",function(){
		if(rloeType==1){
			layer.alert("您没有修改权限",{
				skin: 'layui-layer-lan'
			})
		}else{
		if($(this).html()=="修改"){
			var fig=true;
			var trArrs=$(this).parents("tbody").children();
			$.each(trArrs, function(index,trArr) {
				if(trArr.lastChild.firstChild.text=="取消"){
					layer.alert("请将页面中修改的数据进保存或取消",{
						skin: 'layui-layer-lan'
					});
					fig=false
					return;
				}
			});
			if(fig){
				var row=$(this).parents("tr")
				var trData = tableAddress.row(row).data();
				var cells=row.children();
	           	$.each(cells, function(i,cell){
	                var jqob=$(cell);
					var txt =$(cell).text();
					var put;
					if(i==2){
					
						put = $('<select  class="form-control " disabled><option value='+trData.provinceId+'>'+txt+'</option></select>');
						
					}else if(i==3){
						put = $('<select  class="form-control" disabled><option value='+trData.cityId+'>'+txt+'</option></select>');
						
					}else if(i==4){
						put = $('<select  class="form-control countysAdd" disabled id="address4"><option value='+trData.districtId+'>'+txt+'</option></select>');
						
					}else if(i==5){
						$(cells[i]).addClass('td-towns');
						put = $('<select  class="form-control townEidtor townAdd" id ="address5"><option value='+trData.districtId+'>'+txt+'</option></select>'+
						'<input type="text" name="townEidtor" class="form-control townEidtorInp townsAdd" placeholder="请选择或输入镇" value='+txt+' >');	
					}else if(i==6){
						 put=$("<input type='text' class='form-control village' value="+txt+" >");
					}
					
	               jqob.html(put);
					
	            });
	            $(this).html("取消");
				$(this).context.nextSibling.text="保存";	
				//地址
				$.addressFn("#address5",allUrl.find_town_option,"town",1);
				$("#address5 option:eq(0)").remove();
			}
		}else{
			tableAddress.ajax.reload();
		}
		}
	});
	//thead 地址变动
	$(document).on('change',"#address,#citys,#countys,#towns",function(){
		var selectId;
		if($(this)[0].id==""){
			selectId=$(this)[0].name;
		}else{
			selectId=$(this)[0].id
		};
		switch (selectId){
				case "address":
				 	$.addressFn("#citys",allUrl.find_city_option,"city");
				  	break;
				case "citys":
				 	$.addressFn("#countys",allUrl.find_district_option,"district");
				  	break;
				case "countys":
				 	$.addressFn("#towns",allUrl.find_town_option,"town");
				  	break;
		};
		//下拉搜索
		var Val= searchValFn();
		tableAddress.settings()[0].ajax.data = Val;
		tableAddress.ajax.reload();
	});
	//修改地址联动
	$(document).on('change',".addressAdd,.citysAdd,.countysAdd",function(e,a){
		var selectId;
		if($(this)[0].id==""){
			selectId=$(this)[0].name;
		}else{
			selectId=$(this)[0].id
		};
		switch (selectId){
			
				case "addressAdd":
				 	$.addressFn(".citysAdd",allUrl.find_city_option,"city");
				  	break;
				case "citysAdd":
				 	$.addressFn(".countysAdd",allUrl.find_district_option,"district");
				  	break;
				case "countysAdd":
				 	$.addressFn(".townAdd",allUrl.find_town_option,"town");
				  	break;
		}
		
	});
	//镇的处理
	$(document).on('change','.townAdd,.townEidtor',function(f,e){
		$(".townsAdd").val($('.townAdd option:selected').text());
		$(".village").val(null);
	});
	$(document).on('change','.townsAdd,.townEidtorInp',function(f,e){
		if($(this)[0].name=="townEidtor"){
			
		}else{
			$(".townAdd").val(null);
			$('.village').val(null);
		}
		
	});
	//修改保存,禁用,启用
	$(document).on('click',".statusBtn",function(){	
		if(rloeType==1){
			layer.alert("您没禁/启用权限",{
				skin: 'layui-layer-lan'
			})
		}else{
		var cellData = tableAddress.row($(this).parents('tr')).data();
		if($(this).html()=="保存"){
			var trs=$(this).parents("tr");
			var urls=allUrl.areaUpdate;
			addressSaveFn(urls,trs,cellData)
		
		}else if($(this).html()=="启用"){
			areaUpdateFn("启用",cellData.villageId)
			
		}else{
			areaUpdateFn("禁用",cellData.villageId)
		
		}
		}
	});
	function areaUpdateFn(txt,villageId){
		$.ajax({
				type: "post",
				async: true, //同步执行
				url:allUrl.area_update_status,
				dataType: "json", 
				data:{village_id:villageId},
				success: function(dataAll) {
					if(dataAll.code==0){
						tableAddress.ajax.reload();
						layer.msg(txt+"成功")
					}else{
						layer.alert(dataAll.message,{
							skin: 'layui-layer-lan'
						})
					}
					
					
				}
			});
		
	};
	function addressSaveFn(urls,trs,data){
			var county=trs.find(".countysAdd").val();
			
			var townName=$.trim(trs.find(".townsAdd").val())
			var village=$.trim(trs.find(".village").val());
			
		if(county=='all'||county=='请选择'){
			layer.msg("请选择省市区")
		}else if(townName=='---请选择 ---'||townName==""){
			layer.msg("请选择或输入镇")
		}else if(village==''){
			layer.msg("输入乡或社区")
		}else{
			var town;
			var addressVal;
			var msg;	
			if(data!=undefined){
				town=data.townId;
				addressVal={
					townName:townName,
					villageName:village,
					villageId:data.villageId,
					townId:town
				}
				msg="修改成功"
				
			}else{
				town=$.trim(trs.find(".townAdd").val());
				addressVal={
					districtId:county,
					town:townName,
					village:village
				};
				if(town!="请选择"&&town!=""){
					addressVal.parent=town
				}
				msg="保存成功"
			}
			
			$.ajax({
				type: "post",
				async: true, //同步执行
				url:urls,
				dataType: "json", 
				data:addressVal,
				success: function(dataAll) {
					if(dataAll.code==0){
						tableAddress.ajax.reload();
						layer.msg(msg)
					}else{
						layer.alert(dataAll.message,{
							skin: 'layui-layer-lan'
						})
					}
					
					
				}
			});
		}
		
	}
});