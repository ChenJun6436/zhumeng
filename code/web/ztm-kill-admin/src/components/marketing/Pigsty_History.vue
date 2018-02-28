<template>

	<div class="news_box">
		<ul class="nav">
			<li>猪舍 》 </li>
			<li class="active">猪舍历史生猪 </li>
		</ul>
		<div class="news-content">
			<div style="line-height: 80px">
				<span style='font-weight: bold;margin-left: 20px;'>筛选：</span>
				<el-select v-model="allFunction" placeholder="全部事件">
					<el-option value='入舍' label='入舍'></el-option>
					<el-option value='出舍' label='出舍'></el-option>
				</el-select>
				<el-select v-model="allPigsty" placeholder="全部猪舍">
					<el-option value='入舍' label='入舍'></el-option>
					<el-option value='出舍' label='出舍'></el-option>
				</el-select>
				<span style='font-weight: bold;margin-left: 60px;'>时间：</span>
				<el-date-picker
			      v-model="value1"
			      type="date"
			      placeholder="选择日期">
			    </el-date-picker>
			    －
			    <el-date-picker
			      v-model="value2"
			      type="date"
			      placeholder="选择日期">
			    </el-date-picker>
			</div>
			
			<span class="border_bottom"></span>
			<el-table :data="tableData" class='tableData' stripe>
				<el-table-column label="编号" type="index" class="no">
				</el-table-column>
				<el-table-column label="猪舍名称">
					<template slot-scope="scope">
						<span v-show='scope.row.type==1'>公司新闻</span>
						<span v-show='scope.row.type==2'>行业新闻</span>
					</template>
				</el-table-column>
				<el-table-column label="数量">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="事件">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="时间">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="备注">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
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
	<!--main-content end-->
	</div>
	<!--news_box end-->


</template>

<script>

	import server from '../../server/myServer';
	export default {
		name: "Subaccount",
		data() {
			return {
				allPigsty:'',
				allFunction:'',
				value1:'',
				value2:'',
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: []
			}
		},
		mounted() {
     	console.log(this.urls)
 	 	} ,
		methods: {
			//新增新闻
			addBtn() {
//				this.$router.push({ name: 'NewsEditor',params:{other:1}});
				this.$router.push({ name: 'Subaccount_Add',params:{type:'ad1'} });
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

