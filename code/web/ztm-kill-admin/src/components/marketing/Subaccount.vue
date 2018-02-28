<template>

	<div class="news_box">
		<ul class="nav">
			<li>屠宰场设置 》 </li>
			<li class="active">子账号管理 </li>
		</ul>
		<div class="news-content">
			<span @click='addBtn' :plain="true" class="add-btn"><span class="el-icon-plus"> </span> 新增人员</span>
			<div style='float: right;margin-right: 35px;'>
				搜索：<el-input style='width: 378px;height: 41px;' placeholder="姓名/联系方式"></el-input>
				<span @click='addBtn' :plain="true" class="add-btn" style='margin-left: 10px;'><span class="el-icon-search"> </span>查询</span>
			</div>
			<span class="border_bottom"></span>
			<p style='margin-left: 40px;margin-top: 20px;'>
				<span>当前子账户：xx</span>
				<span style='margin-left: 40px;'>被停用账户：xxx</span>	
			</p>
			<el-table :data="tableData" class='tableData' stripe>
				<el-table-column label="序号" type="index" class="no">
				</el-table-column>
				<el-table-column label="状态">
					<template slot-scope="scope">
						<span v-show='scope.row.type==1'>公司新闻</span>
						<span v-show='scope.row.type==2'>行业新闻</span>
					</template>
				</el-table-column>
				<el-table-column label="账号">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="角色">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="姓名">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="联系方式">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="创建时间">
					<template slot-scope="scope">
						<span>{{ scope.row.createTime}}</span>
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template slot-scope="scope">
						<el-button class='deleteBtn' size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">禁用</el-button>
						<el-button class='editBtn' size="mini" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
						<el-button class='editBtn' size="mini" @click="handleEdit(scope.$index, scope.row)">重置密码</el-button>
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

