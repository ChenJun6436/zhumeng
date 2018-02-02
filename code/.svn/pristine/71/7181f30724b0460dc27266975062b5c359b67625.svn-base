/**
 * Created by dev on 2017/9/26.
 *
 *
 * 模块：首页
 */
$(document).ready(function() {
	$.login();
	
	var rloeType = $.isRloe('首页');
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var getType = userInfoArr.userArea;
	$.verifyById(userInfoArr.userId);
	if(getType.length!=0){
		if(getType[0].type == 1) {
			setDefaultAddress('#province');
			$.addressFn("#city", allUrl.find_city_option, "city");
		} else if(getType[0].type == 2) {
			$("#province").addClass('none');
			setDefaultAddress('#city');
			$.addressFn("#county", allUrl.find_district_option, "district");
		} else if(getType[0].type == 3) {
			$("#province,#city").addClass('none');
			setDefaultAddress('#county');
			$.addressFn("#town", allUrl.find_town_option, "town")
		} else if(getType[0].type == 4) {
			$("#province,#city,#county").addClass('none');
			setDefaultAddress('#town');
			$.addressFn("#village", allUrl.find_village_option, "village");
		} else if(getType[0].type == 5) {
			$("#province,#city,#county,#town").addClass('none');
			setDefaultAddress('#village');
		};
	};
	function setDefaultAddress(ele) {
		$(ele + " option").remove();
		var options = "";
		$.each(getType, function(i, type) {
			options += ('<option  value=' + type.areaId + '>' + type.areaName + '</option>')
		});
		$(ele).append(options);
	};
	//实时数据
	var realTimeData = echarts.init(document.getElementById('real-timeData'));
	realTimeData.showLoading();
	realOptions = {
		tooltip: {
			trigger: 'item',
		},
		legend: {
			bottom: 0,
			left: 'center',
			width: '80%',
			data: ['今日建档总数', '生猪总数', '今日屠宰总数', '今日销售总数']
		},
		series: [
	
			{
				name: '实时数据',
				type: 'pie',
				radius: ['40%', '55%'],
				label: {
					normal: {
						formatter: '{c}',
						backgroundColor: '#F1F1F1',
						borderColor: '#aaa',
						borderWidth: 1,
						borderRadius: 4,
						rich: {
							a: {
								color: '#999',
								lineHeight: 22,
								align: 'center'
							},
							hr: {
								borderColor: '#aaa',
								width: '80%',
								borderWidth: 0.5,
								height: 0
							},
							b: {
								fontSize: 16,
								lineHeight: 33
							},
							per: {
								color: '#eee',
								backgroundColor: '#334455',
								padding: [2, 4],
								borderRadius: 2
							}
						}
					}
				},
				data: [
	
					{
						name: '今日销售总数',
						itemStyle: {
							normal: {
								color: '#A9D86E'
							}
						}
					},
					{
						name: '生猪总数',
						itemStyle: {
							normal: {
								color: '#F8A20F'
							}
						}
	
					},
					{
						name: '今日屠宰总数',
						itemStyle: {
							normal: {
								color: '#5FAEE3'
							}
						}
					},
					{
						name: '今日建档总数',
						itemStyle: {
							normal: {
								color: '#F1F1F1'
							}
						}
					}
				]
			}
		]
	};
	realTimeDataFn(realOptions);
	//折线图
	var myChart = echarts.init(document.getElementById('chartmain'));
	myChart.showLoading();
	var options = {
		title: {
			text: ''
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			"right": 'top',
			right: 35,
			data: ['建档数', '当月录入数', '销售数', '屠宰总数']
		},
	
		calculable: true,
		xAxis: [{
			type: 'category',
			data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
		}],
		yAxis: [{
			type: 'value'
		}],
		series: [{
				name: '建档数',
				type: 'line',
				symbolSize: 12,
				itemStyle: {
					normal: {
						color: '#32D2C9'
					},
				}
			},
			{
				name: '当月录入数',
				type: 'line',
				symbolSize: 12,
				itemStyle: {
					normal: {
						color: '#F8A20F'
					}
				}
			}, {
				name: '销售数',
				type: 'line',
				symbolSize: 12,
				itemStyle: {
					normal: {
						color: '#FA8564'
					}
				}
			},
			{
				name: '屠宰总数',
				type: 'line',
				symbolSize: 12,
				itemStyle: {
					normal: {
						color: '#AEC785'
					}
				}
			}
		]
	};
	optionsFn(options);
	
	function realTimeDataFn(option, type, areaId) {
		var data;
		if(areaId != undefined && areaId != "") {
			if($(areaId).val()==""){
				prevEleVal =selectChooce(areaId)
				data = {
					id: prevEleVal,
					type: type-1
				}
			}else{
				data = {
					id: $(areaId).val(),
					type: type
				}
			}
		} else {
			data = {
				id: getType[0].areaId,
				type: getType[0].type
			}
		}
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.indexRealTimeData,
			xhrFields: {
				withCredentials: true
			},
			dataType: "json",
			data: data,
			success: function(allData) {
				if(allData.code == "0") {
					realOptions.series[0].data[0].value = allData.data.sellNumbers;
					realOptions.series[0].data[1].value = allData.data.number;
					realOptions.series[0].data[2].value = allData.data.slaughterNumbers;
					realOptions.series[0].data[3].value = allData.data.archivesNumbers;
					realTimeData.hideLoading();
					realTimeData.setOption(realOptions);
				} else {
					
						layer.alert(allData.message, {
						skin: 'layui-layer-lan'
					})
					}
	
				
			}
		});
	
	}
	//根据地址改变圆柱图以及对应的table
	
	function optionsFn(options, type, addId) {
		var data;
		if(addId != undefined) {
			if($(addId).val()==""){
				prevEleVal =selectChooce(addId)
				data = {
					id: prevEleVal,
					type: type-1
				}
			}else{
				data = {
					id: $(addId).val(),
					type: type
				}
			}
		} else {
			data = {
				id: getType[0].areaId,
				type: getType[0].type
			}
		}
	
		//通过Ajax获取数据
		$.ajax({
			type: "post",
			async: true, //同步执行
			url: allUrl.indexGetPigData,
			dataType: "json", //返回数据形式为json
			xhrFields: {
				withCredentials: true
			},
			data: data,
			success: function(dataAll) {
				if(dataAll.code == 0) {
					var bookbuildingNumberData = dataAll.data.filingNumber; //建档数
					var numberOfInputData = dataAll.data.inputNumber; //录入数
					var slaughterNumbersData = dataAll.data.slaughterNumber; //屠宰数量
					var saleNumberData = dataAll.data.saleNumber; //销售数
					var months = ["jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sept", "oct", "nov", "dece"]
					var bookbuildingNumberRes = [];
					var numberOfInputRes = [];
					var saleNumberRes = [];
					var slaughterNumbersRes = [];
					if(bookbuildingNumberData) {
						$.each(months, function(index, month) {
							bookbuildingNumberRes.push(bookbuildingNumberData[month]);
							numberOfInputRes.push(numberOfInputData[month]);
							saleNumberRes.push(saleNumberData[month]);
							slaughterNumbersRes.push(slaughterNumbersData[month]);
	
						});
						options.series[0].data = bookbuildingNumberRes;
						options.series[1].data = numberOfInputRes;
						options.series[2].data = saleNumberRes;
						options.series[3].data = slaughterNumbersRes;
						myChart.hideLoading();
						myChart.setOption(options);
						tableDataFn(options.series);
	
					}
				} else {
					layer.alert(dataAll.message, {
						skin: 'layui-layer-lan'
					})
				}
			}
		});
	};
	//地址
	$("#province,#city,#county,#town,#village").change(function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(fig){
			var selectId = $(this)[0].id;
			switch(selectId) {
				case "province":
					$.addressFn("#city", allUrl.find_city_option, "city");
					realTimeDataFn(options, 1, "#province");
					optionsFn(options, 1, "#province");
					table(1,"#province")
					break;
				case "city":
					$.addressFn("#county", allUrl.find_district_option, "district");
					realTimeDataFn(options, 2, "#city");
					optionsFn(options, 2, "#city");
					table(2, "#city")
					break;
				case "county":
					$.addressFn("#town", allUrl.find_town_option, "town");
					realTimeDataFn(options, 3, "#county");
					optionsFn(options, 3, "#county");
					table(3, "#county")
					break;
				case "town":
					$.addressFn("#village", allUrl.find_village_option, "village");
					realTimeDataFn(options, 4, "#town");
					optionsFn(options, 4, "#town");
					table(4, "#town")
					break;
				case "village":
					realTimeDataFn(options, 5, "#village")
					optionsFn(options, 5, "#village");
					table(5,"#village")
					break;
			}
		}
		
	
	});
	//折线图对应的table
	function tableDataFn(datas) {
		$("#tbodyData tr").remove();
		var tableTbody = "";
		var td = "";
		$.each(datas, function(index, list) {
			td = "<td class='td'><p class='none'>" + list.name + "</p><span></span></td>";
			$.each(list.data, function(index, data) {
				td += ('<td>' + data + '</td>');
			});
			tableTbody += "<tr>" + td + "</tr>"
	
		});
		$("#tbodyData").append(tableTbody);
		if($("#tbodyData>tr").length != 0) {
			colourAtla()
		} else {
			setTimeout(colourAtla(), 1000);
		}
	};
	//添加色标图片
	function colourAtla() {
		var txt;
		$.each($("#tbodyData>tr"), function(index, trs) {
			txt = trs.cells[0].children[0].innerText;
			if(txt == "建档数") {
				$(".td span:eq(" + index + ")").addClass("filingNumcber");
			} else if(txt == "当月录入数") {
				$(".td span:eq(" + index + ")").removeClass("filingNumcber").addClass("resultNumcber");
			} else if(txt == "屠宰总数") {
				$(".td span:eq(" + index + ")").removeClass("resultNumcber").addClass("slaughterNumber");
			} else if(txt == "销售数") {
				$(".td span:eq(" + index + ")").removeClass("slaughterNumber").addClass("salesNumber");
			}
		})
	
	}
	table();
	$.pigType(allUrl.findFilepigType,'#breed');
	$.butcherSelect(allUrl.indexButcherSelect,'#slaughterHouse');
	$.salesMarket(allUrl.indexSalesMarketSelect,'#salesMarket')
	//bottom的table
	var bottomTable;
	function table(type,addId){
		var searchVal;
		if(addId != undefined) {
			if($(addId).val()==""){
				prevEleVal =selectChooce(addId)
				searchVal = {
					areaId: prevEleVal,
					type: type-1
				}
			}else{
				searchVal = {
					areaId: $(addId).val(),
					type: type
				}
			}
			
		} else {
			searchVal = {
				areaId: getType[0].areaId,
				type: getType[0].type
			}
		}
		var columnArrs = ["pigId", "pigNo", "pigBreed", "status", "address", "farmName", "slaughter", "market", null];
		var columnDefArrs = [{
			targets: 1,
			orderable: false,
			visible: false
		}, {
			targets: 4,
			orderable: false,
			render: function(data) {
				return(data == null ? "" : data)
			}
		}, {
			targets: 5,
			orderable: false,
			render: function(data) {
				return('<p title="'+data+'">'+data+'</p>')
			}
		},{
			targets: -1,
			orderable: false,
			render: function(data) {
				return('<a href="#" class="viewDetailsBtn text-view">查看详情</a>')
			}
		}];
		var tableOptions = {
			id: "table",
			url: allUrl.indexGetPigTable,
			searchParams: searchVal,
			columns: columnArrs,
			lengthChange:false,
			scrollX: true,
			columnDefs: columnDefArrs
		}
		 bottomTable = $.createTable(tableOptions);
	}
	//获取下拉为请选择时的值
	function selectChooce(addId){
		var prevEle=$(addId).prev();
		var prevEleVal=$(prevEle).val();
		return prevEleVal;
		
	}
	
	//搜索
	
	$(document).on("click", "#seacherBtn", function() {
		$.verifyById(userInfoArr.userId);
		tableSeacherFn()
	});
	$(document).on("change", "#farm,#breed,#status,#slaughterHouse,#salesMarket", function() {
		$.verifyById(userInfoArr.userId);
		tableSeacherFn()
	});
    function tableSeacherFn(){
    	var areaId;
    	var k=5;
    	arrays=["#village","#town","#county","#city","#province"];
    	$.each(arrays, function(i,area) {
    		if($(area).val()!=""){
    			areaId=$(area).val();
    			type=k;
    		};
    		k--;
    		
    	});
		searchVal={
			areaId: areaId,
			type: type,
    		keywords:$('.seacher-input').val(),//关键字
    		farmId:$('#farm').val(),//养殖场
    		breedId:$("#breed").val(),//品种
    		status:$('#status').val(),//状态
    		slaughterId:$('#slaughterHouse').val(),//屠宰场
    		marketId:$("#salesMarket").val()//销售市场
    	};
    	for(var key in searchVal){
    		
	        if(searchVal[key]=="" || searchVal[key] == 'all'){
	            delete searchVal[key];
	        }
	    };
    	$.seacherFn(bottomTable,searchVal);
    };
	// 查看详情
	
	$(document).on("click", ".viewDetailsBtn", function() {
		var fig=$.verifyById(userInfoArr.userId);
		var cellData = bottomTable.row($(this).parents('tr')).data();
		$(".viewIdNum").html(cellData.pigNo);
		$(".viewVarieties").html(cellData.pigBreed);
		var layEdit;
		if(fig){
			layEdit = layer.open({
				type: 1,
				area: ['1000px', '600px'],
				scrollbar: false,
				title: ['查看详情', 'background-color:#1FB5AD;color:white;font-size:16px;font-family:MicrosoftYaHei;font-weight:bold;'],
				content: $("#viewDetails"),
				btn: ['取消'],
				btnAlign: 'c'
			});
		}; 
		var columnArrs = [ "thing", "status", "address", "description", "createrName", "createTime", "remark"];
		var columnDefArrs = [
		{
			targets:3,
	        orderable: false,
	        render: function (data) { 
	        return '<p title='+data+'>'+data+'</p>';
	        }
		},{
			targets:-1,
	        orderable: false,
	        render: function (data) { 
	        	if(data==null){
	        		return null;
	        	}else{
	        		 return '<p title='+data+'>'+data+'</p>';
	        	}
	       
	        }
		}];
		var searchVal = null;

		var pigList = {
			id: "viewTable",
			url:allUrl.allPigInfor,
			searchParams: {
				pig_id: cellData.pigNo
			},
			columns: columnArrs,
			lengthChange:false,
			info:false,
			columnDefs: columnDefArrs

		}
		$.createTable(pigList);

	});


});
