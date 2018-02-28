<template>

	<div class="caseList_box">
		<ul class="nav">
			<li>内容管理 》 </li>
			<li @click='caseCenter'>案例中心 》 </li>
			<li class="active">案例列表 </li>
		</ul>
		<div class="caseList-content">
			<span @click='addBtn' :plain="true" class="add-btn"><span class="el-icon-plus"> </span> {{btnName}}</span>
			<span class="border_bottom"></span>
			
			<el-table :data="caseListTable" class='caseListTable' stripe>
				<el-table-column label="序号" type="index" class="no">
				</el-table-column>
				<el-table-column label="名称">
					<template slot-scope="scope">
						<span class="caseList-titlt">{{ scope.row.title}}</span>
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
	<!--caseList_box end-->


</template>

<script scope>

	import server from '../../server/myServer';
	export default {
		name: "CaseList",
		data() {
			return {
				btnName: '新增案例',
				cur:1,
				curPage:10,
				recordsTotal:0,
				rowId:'',
				caseListTable: []
			}
		},
		mounted() {
         	this.rowId=this.$route.query.id;
         	this.getData();
       	} ,
		methods: {
			//返回案例中心
			caseCenter(){
				this.$router.push({path:'/Main/Distributor'});
			},
			//新增案例
			addBtn(){
				this.$router.push({path:'/Main/CaseEditor'});
			},
			//点击页码和跳页
			handleCurrentChange(val){
				this.cur=val;
		    	this.getData();
			},
			getData(){
		    	let me = this;
				let caseListTableData={
					page:me.cur,
					size:me.curPage,
					aanvraagTypeId:me.rowId
				};
				server()._getCaseList(caseListTableData).then(function(res) {
					var Data = res.data;
					if(Data.success) {
						me.caseListTable = Data.data
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
			
		},
		 
	}

</script>

<style lang='scss'>

	.caseList_box {
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
		.caseList-content {
			min-height: 500px;
			background: #FFFFFF;
			border: 1px solid #E3E5EB;
			.caseList-titlt {
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
			.caseListTable {
				width: 95%;
				margin: 2.5% auto;
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

