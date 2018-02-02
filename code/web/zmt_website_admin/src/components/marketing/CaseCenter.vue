<template>
<div class="case-box">
		<ul class="nav">
			<li>内容管理 》 </li>
			<li class="active">案例中心 </li>
		</ul>
		<div class="case-content">
			<el-table :data="tableData" class='tableData' stripe>
				<el-table-column label="序号" type="index" class="no">
				</el-table-column>
				<el-table-column label="类型">
					<template slot-scope="scope">
						<span class="case-titlt">{{ scope.row.name}}</span>
					</template>
				</el-table-column>
				<el-table-column label="成功案例">
					<template slot-scope="scope">
						<span>{{ scope.row.num}}</span>
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template slot-scope="scope">
						<el-button class='checkBtn' size="mini" @click="handleCheck(scope.$index, scope.row)">查看</el-button>
					</template>
				</el-table-column>
			</el-table>
			
	</div>



</div>
  <!--case_box end-->
</template>
<script>
	import server from '../../server/myServer';
export default {
  name:"CaseCenter",
  data(){
      return{
          tableData: []
      }
  },
  methods: {
  	handleCheck(insex,row){
  		this.$router.push({ name: 'CaseList',query:{id:row.id}});
  	}
  },
  created() {
			//页面加载数据
	let me = this;
	server()._getCaseType().then(function(res) {
			var Data = res.data;
			if(Data.success) {
				me.tableData = Data.data
			} else {
				me.$msg(Data.message, 'error', 'center')
			}
		});
	}

}
</script>

<style lang='scss'>
.case-box{
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
		.case-content {
			min-height: 500px;
			background: #FFFFFF;
			border: 1px solid #E3E5EB;
			.case-titlt {
				display: block;
				min-width: 150px;
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
			}
			.tableData {
				width: 95%;
				margin: 2.5% auto;
			}
			.checkBtn,
			.checkBtn:hover {
				color: #3C91DD;
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


