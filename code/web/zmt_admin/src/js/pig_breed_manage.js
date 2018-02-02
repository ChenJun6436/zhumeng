$(function() {
	$.login();
	//请求table的数据
	var searchValue = {};
	var userInfo = sessionStorage.getItem('userInfo');
	var userInfoArr = JSON.parse(userInfo);
	var curQuanxian = $.isRloe("生猪品种管理");
	if(curQuanxian =='0'){
		$('.xinzengPig').removeClass('none')
	}
	var pigBreedManageSetting = {
		id: "pig_breed_manageTable",
		url: allUrl.breedPigList,
		searchParams: {
			timestamp:1508998573824,
			token:'b01ad47000d0b2b719fe390ae15e8612'
		},
		lengthChange: false,
		columns: ["name", "createTime", "status", null],
		scrollY:'600px',
		scrollX: true,
		columnDefs: [{
				"targets": 1,
				"orderable": false,
				"render": function(data, type, row, meta) {
					return $.renderTable(data, row)
				}
			},{
				"targets": 2,
				"orderable": false,
				"render": function(data, type, row, meta) {
					return $.renderTable(data, row)
				}
			},{
				"targets": 3,
				"orderable": false,
				"render": function(data, type, row, meta) {
					return $.renderTable(data, row)
				}
			},{
			"targets": -1,
			"orderable": false,
			"render": function(data, type, row, meta) {
				var textState = data.status == '正常' ? '禁用' : '启用';
				var className = data.status == '正常' ? "tableOperate" : "talbeDisabled";
				if(curQuanxian =='1'){
					return('<span>/</span>')
				}else{
					return('<a class="tableOperate del">删除</a><a id="isDisabled" class=' + className + '>' + textState + '</a>')
				}
				
			}

		}],
	}
	var pigBreedManageTable = $.createTable(pigBreedManageSetting);

	//新增品种
	$(document).on('click', '.xinzengPig', function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		$('#pigBreed').val('');
		layer.open({
			type: 1,
			area: '300px',
			title: ['新增品种', 'background-color:#1FB5AD;color:white;font-size:16px'],
			content: $("#newAddBreed"),
			btn: ['提交', '取消'],
			btnAlign: 'c',
			yes: function(index, layero) {
					newAddBreedSave();
			},
			btn2: function(index, layero) {
				layer.closeAll();
			}
		});

	});
	
	//新增产品保存
	function newAddBreedSave(){
		
		var pigBreed = $('#pigBreed').val();
		if(pigBreed !=''){
			$.ajax({
			type: "post",
			url: allUrl.newAddBreedType,
			data: {
				name: pigBreed
			},
			success: function(Data) {
				if(Data.code=='0'){
					pigBreedManageTable.ajax.reload();
					
					layer.closeAll();
					layer.alert('保存成功！');
				}else{
					
					layer.closeAll();
					layer.msg(Data.message);
				}
			}
		});
		}else{
			layer.msg('请先填写生猪的品种！')
			
		}
		
	}
	
	

	//删除
	$(document).on("click", ".del", function() {
		var data = pigBreedManageTable.row($(this).parents('tr')).data();
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		if(data.status == '禁用'){
			layer.alert("该生猪已被禁用，不能删除！",{
				skin: 'layui-layer-lan'
			})
			return false;
		}
		var setting = {
			id:data.id,
			url:allUrl.breedDel,
			contentText:"删除"
		}
		layer.open({
			title:['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn:['确定','取消'],
			content:'您是否确定要删除该条数据？',
			btnAlign: 'c',
			yes:function(){
				ajaxFn(setting)
			}
		})
		

	});
	
	
	//禁用启用
	$(document).on("click", "#isDisabled", function() {
		var fig = $.verifyById(userInfoArr.userId);
		if(!fig){
			return
		}
		var data = pigBreedManageTable.row($(this).parents('tr')).data();
		var statusName = data.status == '正常' ? '禁用' : '启用';
		var setting ={
			id:data.id,
			url:allUrl.breedIsDisabled,
			contentText:statusName,
		}
		layer.open({
			title:['信息', 'background-color:#1FB5AD;color:white;font-size:16px'],
			btn:['确定','取消'],
			content:'您是否确定要'+ statusName +'该条数据？',
			btnAlign: 'c',
			yes:function(){
				ajaxFn(setting);
			}
		})
			

	});
	
	function ajaxFn(setting){
		$.ajax({
			type: "post",
			url: setting.url,
			data: {
				id: setting.id
			},
			success: function(Data) {
				if(Data.code =='0'){
					pigBreedManageTable.ajax.reload();
					layer.closeAll();
					layer.msg(setting.contentText+'成功')
				}else{
					layer.closeAll();
					layer.msg(Data.message);
				}

			},
			error:function(a,b,c){
			}

		});	
	}

})