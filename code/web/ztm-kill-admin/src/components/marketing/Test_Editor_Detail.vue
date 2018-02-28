<template>

	<div class="news_box">
		<ul class="nav">
			<li>工作台 》 </li>
			<li>检验 》 </li>
			<li>检验报告 》 </li>
			<li>查看报告 》 </li>
			<li class="active">查看明细 </li>
		</ul>
		<div class="news-content" style='padding-bottom: 60px;'>
			<div style="line-height: 80px">
				<span style='margin-left: 40px;font-size: 18px;font-weight: bold;color: #1FB5AD'>查看明细</span>
				<div style='float: right;margin-right: 40px;'>
					<p style='margin-left: 0;text-align:center;'>
						<span :plain="false" class="add-btn">打印</span>
						<span style='background: #BDBDBD;margin-left: 20px;' :plain="true" class="add-btn">返回</span>
					</p>
				</div>
			</div>
			<span class="border_bottom"></span>
			<div style='margin-left: 40px;margin-top: 40px;width: 550px;overflow: hidden'>
				<div style=''>
					<p style="font-weight: bold;font-size: 17px;margin-bottom: 20px;text-align: center">
						xx检验报告
					</p>
					<div style='overflow: hidden;border-bottom: 1px dashed #ddd;padding-bottom: 20px;'>
						<ul class="codeList" style=''>
							<li style='float: left'>
								<span class='nam'>报告编号：</span>
								<span class='val'>xxx</span>
							</li>
							<li style='float: right'>
								<span class='nam'>检验人员：</span>
								<span class='val'>xxx</span>
							</li>
						</ul>
					</div>
					<div>
						<p style="font-weight: bold;line-height: 40px;">
							生猪明细
						</p>
						<el-table :data="tableData" class='tableData' stripe>
							<el-table-column label="序号" type="index" class="no">
							</el-table-column>
							<el-table-column label="猪舍名称">
								<template slot-scope="scope">
									<span v-show='scope.row.type==1'>公司新闻</span>
									<span v-show='scope.row.type==2'>行业新闻</span>
								</template>
							</el-table-column>
							<el-table-column label="可入/已入（头）">
								<template slot-scope="scope">
									<span class="news-titlt">{{ scope.row.title}}</span>
								</template>
							</el-table-column>
							<el-table-column label="操作">
								<template slot-scope="scope">
									<el-button class='deleteBtn' size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">入舍</el-button>
									<el-button class='editBtn' size="mini" @click="handleEdit(scope.$index, scope.row)">出舍</el-button>
								</template>
							</el-table-column>
						</el-table>
						<el-pagination
					      @current-change="handleCurrentChange"
					      :current-page.sync="cur"
					      :page-size="curPage"
					      :background='true'
					      :small='true'
					      :total="recordsTotal"
					      layout="prev, pager, next, total,jumper"
					      style='text-align: right;margin-right: 30px;margin-top: 60px;margin-bottom: 20px;'
					      >
					    </el-pagination>
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
		name: "TestEditorDetail",
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

