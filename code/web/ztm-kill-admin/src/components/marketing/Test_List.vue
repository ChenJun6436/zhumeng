<template>

	<div class="news_box">
		<ul class="nav">
			<li>工作台 》 </li>
			<li>检验 》 </li>
			<li class="active">检验报告 </li>
		</ul>
		<div class="news-content">
			<div style="overflow: hidden">
				<p style='float:left;margin-left: 40px;margin-top: 30px;font-weight: bold'>
					<span>所有报告：xx份</span>
					<span style='margin-left: 80px;'>今日报告：xx份</span>
				</p>
				<div style='float: right;margin-right: 35px;'>
					搜索：<el-input style='width: 378px;height: 41px;' placeholder="ID/报告编号"></el-input>
					<span @click='killOnePig' :plain="true" class="add-btn" style='margin-left: 10px;'><span class="el-icon-search"> </span>查询</span>
				</div>
			</div>
			<span class="border_bottom"></span>
			<div style="margin-top:20px">
				<span @click='addBtn' :plain="true" style='margin:0;margin-left: 40px;' class="add-btn"><span class="el-icon-plus"> </span> 新增报告</span>
				<div style='float: right;margin-right: 40px;'>
					<span style='font-weight: bold;margin-left: 40px;'>筛选：</span>
					<el-select style='width: 150px' v-model="allFunction" placeholder="全部销售员">
						<el-option value='入舍' label='入舍'></el-option>
						<el-option value='出舍' label='出舍'></el-option>
					</el-select>
					<el-select style='width: 150px;margin-left: 10px;' v-model="allFunction" placeholder="全部销售员">
						<el-option value='入舍' label='入舍'></el-option>
						<el-option value='出舍' label='出舍'></el-option>
					</el-select>
					<el-select style='width: 150px;margin-left: 10px;' v-model="allFunction" placeholder="全部销售员">
						<el-option value='入舍' label='入舍'></el-option>
						<el-option value='出舍' label='出舍'></el-option>
					</el-select>
				</div>
			</div>
			<el-table :data="tableData" class='tableData' stripe>
				<el-table-column
			      type="index"
			       label='序号'
			      width="55">
			    </el-table-column>
				<!-- <el-table-column type="selection"  width="55">
				</el-table-column> -->
				<el-table-column label="报告编号">
					<template slot-scope="scope">
						<span v-show='scope.row.type==1'>公司新闻</span>
						<span v-show='scope.row.type==2'>行业新闻</span>
					</template>
				</el-table-column>
				<el-table-column label="报告类型">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="检验结果">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="检验人员">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="检验时间">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="提交人员">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="提交时间">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="详情描述">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
					</template>
				</el-table-column>
				<el-table-column label="备注">
					<template slot-scope="scope">
						<span class="news-titlt">{{ scope.row.title}}</span>
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
		<PigstyOut v-if='showOut' @Click='sureOut' @Close='cancelOut'></PigstyOut>
		<!-- <PigstyOut @Click='sureOut' @Close='cancelOut'></PigstyOut> -->
		<SlaughterAll v-if='showKill' @Close='cancelKill' @sureKill='sureKill'></SlaughterAll>
		<SlaughterOne v-if='showKillOne' @Close='cancelKillOne' @sureKill='sureKillOne'></SlaughterOne>	
	</div>

</template>

<script>

	import server from '../../server/myServer'
	import PigstyOut from '../common/Pigsty_Out'
	import PigstyIn from '../common/Pigsty_In'
	import SlaughterAll from '../common/Slaughter_All'
	import SlaughterOne from '../common/Slaughter_One'
	export default {
		name: "SaleList",
		data() {
			return {
				showKillOne: false,
				showKill: false,
				showOut: false,
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: []
			}
		},
		mounted() {

 	 	} ,
		methods: {
			killOnePig() {
				this.showKillOne = true
			},
			killSomePig() {
				this.showKill = true
			},
			cancelOut() {
				this.showOut = false
			},
			cancelKill() {
				this.showKill = false
			},
			cancelKillOne() {
				this.showKillOne = false
			},
			sureKill() {
				this.$msg('屠宰成功','success')
			},
			sureKillOne() {
				this.$msg('屠宰成功','success')
			},
			//新增新闻
			addBtn() {
//				this.$router.push({ name: 'NewsEditor',params:{other:1}});
				this.$router.push({ name: 'TestAdd'});
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
			PigstyOut, PigstyIn, SlaughterAll, SlaughterOne
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

