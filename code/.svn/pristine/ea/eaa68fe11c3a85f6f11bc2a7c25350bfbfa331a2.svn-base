<template>

	<div class="news_box">
		<ul class="nav">
			<li>内容管理 》 </li>
			<li class="active">新闻中心 </li>
		</ul>
		<div class="news-content">
			<span @click='addBtn' :plain="true" class="add-btn"><span class="el-icon-plus"> </span> {{btnName}}</span>
			<span class="border_bottom"></span>
			
			<el-table :data="tableData" class='tableData' stripe>
				<el-table-column label="序号" type="index" class="no">
				</el-table-column>
				<el-table-column label="新闻类型">
					<template slot-scope="scope">
						<span v-show='scope.row.type==1'>公司新闻</span>
						<span v-show='scope.row.type==2'>行业新闻</span>
					</template>
				</el-table-column>
				<el-table-column label="新闻标题">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="发布时间">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template slot-scope="scope">
						<el-button class='editBtn' size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
						<el-button class='deleteBtn' size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
		name: "NewsCenter",
		data() {
			return {
				btnName: '新增新闻',
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: []
			}
		},
		mounted() {
            //请求第一页数据
//         	this.urls=server()._newsTable()	
           	console.log(this.urls)
       	 	} ,
		methods: {
			//新增新闻
			addBtn() {
//				this.$router.push({ name: 'NewsEditor',params:{other:1}});
				this.$router.push({ path: '/Main/NewsEditor' });
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
				width: 125px;
				height: 38px;
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
		}
	}
</style>

