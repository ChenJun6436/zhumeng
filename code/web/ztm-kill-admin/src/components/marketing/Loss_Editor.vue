<template>

	<div class="news_box">
		<ul class="nav">
			<li>工作台 》 </li>
			<li>报损 》 </li>
			<li>报损列表 》 </li>
			<li class="active">报损报告 </li>
		</ul>
		<div class="news-content" style='padding-bottom: 60px;'>
			<div style="line-height: 80px">
				<span style='margin-left: 40px;font-size: 18px;font-weight: bold;color: #1FB5AD'> 新增报损报告</span>
			</div>
			<span class="border_bottom"></span>
			<div style='margin-left: 40px;margin-top: 40px;overflow: hidden'>
				<div style='width: 50%;float: left;border-right: 1px solid #ddd;'>
					<p style="font-weight: bold;font-size: 17px;margin-bottom: 40px;">
						报告编号：<span style='margin-left: 5px;'>xxx</span>
					</p>
					<ul class="codeList">
						<li>
							<span class='nam'>报损类型：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>报告时间：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>检验人员：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>检验时间：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>报损类型：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>处理原因：</span>
							<span class='val'>xxx</span>
						</li>
						<li>
							<span class='nam'>凭证：</span>
							<span class='val'>xxx</span>
						</li>
						<li style='margin-left: 70px;'>
							<span style='display: inline-block;width: 120px;height: 120px;border:1px solid;margin-left: 5px;margin-top: 5px;'></span>
							<span style='display: inline-block;width: 120px;height: 120px;border:1px solid;margin-left: 5px;margin-top: 5px;'></span>
							<span style='display: inline-block;width: 120px;height: 120px;border:1px solid;margin-left: 5px;margin-top: 5px;'></span>
							<span style='display: inline-block;width: 120px;height: 120px;border:1px solid;margin-left: 5px;margin-top: 5px;'></span>
							<span style='display: inline-block;width: 120px;height: 120px;border:1px solid;margin-left: 5px;margin-top: 5px;'></span>
						</li>
						<li>
							<span class='nam'>备注：</span>
							<span class='val'>xxx</span>
						</li>
					</ul>
				</div>
				<div style="width: 40%;float: left;margin-left: 80px;">
	  				<div style="line-height: 20px">
						<span style='font-size: 17px;font-weight: bold;'> 详情</span>
					</div>
					<div v-if='pigNum'>
						<div style="margin-top: 30px;margin-bottom: 20px;">
							<span> 生猪头数：xx头</span>
						</div>
						<el-table :data="tableData" border max-height="450" style='width: 430px;'>
							<el-table-column label="序号">
								<template slot-scope="scope">
									<span v-show='scope.row.type==1'>公司新闻</span>
									<span v-show='scope.row.type==2'>行业新闻</span>
								</template>
							</el-table-column>
							<el-table-column label="耳标号">
								<template slot-scope="scope">
									<span v-show='scope.row.type==1'>公司新闻</span>
									<span v-show='scope.row.type==2'>行业新闻</span>
								</template>
							</el-table-column>
							<el-table-column label="生猪ID">
								<template slot-scope="scope">
									<span class="news-titlt">{{ scope.row.title}}</span>
								</template>
							</el-table-column>
							<el-table-column label="操作">
								<template slot-scope="scope">
									<el-button class='deleteBtn' size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
								</template>
							</el-table-column>
						</el-table>
					</div>
					<div v-if='!pigNum'>
						<ul class="codeList" style='margin-top: 40px;'>
							<li>
								<span class='nam'>生猪重量：</span>
								<span class='val'>xxx</span>
							</li>
							<li>
								<span class='nam'>生猪头数：</span>
								<span class='val'>xxx</span>
							</li>
							<li>
								<span class='nam'>生猪部位：</span>
								<span class='val'>xxx</span>
							</li>
						</ul>
					</div>
	  			</div>
			</div>
		</div>
	</div>

</template>

<script scope>
	const cityOptions = ['上海', '北京', '广州', '深圳'];
	import server from '../../server/myServer';
	export default {
		name: "LossEditor",
		data() {
			return {
				radio:'2',
				value1:'',
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: [],
				ruleForm:{
					name:'',
				},
				rules:{
					name: [
			            { required: true, message: '请输入活动名称', trigger: 'blur' },
			            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
		          	],
				},
				tableData: [],
				dialogImageUrl: '',
        dialogVisible: false,
        checkAll: false,
        checkedCities: ['上海', '北京'],
        cities: cityOptions,
        isIndeterminate: true
			}
		},
		mounted() {
     	console.log(this.urls)
 	 	} ,
		methods: {
			handleCheckAllChange(val) {
        this.checkedCities = val ? cityOptions : [];
        this.isIndeterminate = false;
      },
      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.cities.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
      },
			handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
			//新增新闻
			addBtn() {
//				this.$router.push({ name: 'NewsEditor',params:{other:1}});
				this.$router.push({ name: 'Distributor_Add',params:{type:'ad1'} });
			},
			//编辑新闻
			handleEdit(index,row) {
//				localStorage.setItem('newsEditorData', JSON.stringify(row));
				this.$router.push({ name: 'NewsEditor',query:{id:row.id}});
			},
			//删除新闻
			handleDelete(index,row){
				debugger;
				var me = this;
				server()._deleteNews({id:row.id}).then(function(res) {
					var Data = res.data;
					if(Data.success) {
						me.$msg('删除成功', 'success', 'center')
						me.getData();
					} else {
						me.$msg(Data.message, 'error', 'center')
					}
				});
			},
			//点击页码和跳页
	    handleCurrentChange(val) {
	    	this.cur=val;
	    	this.getData();
	    },
	    //页面加载数据
	    getData(){
	    	let me = this;
			let newsTableData={
				page:me.cur,
				size:me.curPage
			};
			server()._newsTable(newsTableData).then(function(res) {
				var Data = res.data;
				if(Data.success) {
					me.tableData = Data.list
					me.recordsTotal=Data.recordsTotal;
					console.log(me.tableData)
				} else {
					me.$msg(Data.message, 'error', 'center')
				}
			});
	    }
    },
		components: {
		},
		
		created() {
			//页面加载数据
			this.getData();
		},
		 
	}

</script>

<style lang='scss'>
	.el-upload-list--picture-card .el-upload-list__item{
		width: 120px;
		height: 120px;
	}
	.codeList{
		li{
			margin-top: 20px;
			.nam{
				display: inline-block;
				width: 70px;
			}
			.val{
				margin-left: 5px;
			}
		}
	}
	.el-upload--picture-card{
		width: 120px;
		height: 120px;
		line-height: 127px;
	}
	.news_box {
		margin: 0 35px;
		.nav {
			height: 45px;
			line-height: 45px;
			font-size: 14px;
			li {
				float: left;
				color: #666666;
				cursor: default;
			}
			.active {
				color: #1FB5AD;
			}
		}
		.news-content {
			min-height: 500px;
			background: #FFFFFF;
			border: 1px solid #E3E5EB;
			.news-titlt {
				display: block;
				min-width: 150px;
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
			}
			.add-btn {
				color: #FFFFFF;
				display: inline-block;
				padding: 0 22px;
				text-align: center;
				line-height: 38px;
				font-size: 14px;
				background: #1FB5AD;
				border-radius: 5px;
				margin: 20px 0px 20px 40px;
				cursor: pointer;
			}
			.border_bottom {
				display: block;
				width: 100%;
				border-bottom: 1px solid #F0F2F7;
			}
			.tableData {
				width: 95%;
				margin: 20px auto;
			}
			.editBtn,
			.editBtn:hover {
				color: #3C91DD;
				background: none;
			}
			.deleteBtn,
			.deleteBtn:hover {
				color: #F65342;
				background: none;
			}
			.el-table th {
				& {
					padding: 20px 0px;
					background: #FBFBFB;
				}
				&>.cell {
					color: #777777;
					font-size: 14px;
					text-align: center;
				}
			}
			.el-table td,
			.el-table th.is-leaf {
				border-bottom: none;
			}
			.el-table td {
				text-align: center;
				color: #566175;
				font-size: 14px;
			}
			.el-table::before {
				background: #FFFFFF;
			}
			.el-button {
				cursor: pointer;
				background: none;
				border: none;
			}
			.el-pagination.is-background .el-pager li.active{
				background: #1FB5AD;
			}
		}
	}
</style>

