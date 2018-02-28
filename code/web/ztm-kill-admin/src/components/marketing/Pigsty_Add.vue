<template>

	<div class="news_box">
		<ul class="nav">
			<li>屠宰场设置 》 </li>
			<li>猪舍管理 》 </li>
			<li class="active"> 新增猪舍</li>
		</ul>
		<div class="news-content">
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="160px" class="demo-ruleForm" label-position='right' style='width: 780px;margin-top: 50px;'>
				<el-form-item label="猪舍名称：" prop="name">
			    	<el-input placeholder='最多填写7个字'></el-input>
		  		</el-form-item>
		  		<el-form-item label="猪舍上限：" prop="name">
		  			<el-input-number placeholder='整数' v-model="num1" @change="handleChange" :min="0" :max="99999999" label="猪舍上限："></el-input-number>
		  		</el-form-item>
		  		<el-form-item style='margin-top: 100px;'>
				    <span  style='background: #BDBDBD;' :plain="true" class="add-btn">取消</span>
				    <span  :plain="false" class="add-btn">确定</span>
			  	</el-form-item>
		  	</el-form>
		</div>	
	</div>
	<!--main-content end-->
	</div>
	<!--news_box end-->
</template>

<script>

	import server from '../../server/myServer';
	export default {
		name: "Pigsty_Add",
		data() {
			return {
				cur:1,
				curPage:10,
				recordsTotal:0,
				tableData: [],
				num1: 0,
				rules:{
					name: [
			            { required: true, message: '请输入活动名称', trigger: 'blur' },
			            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
					],
					region: [
						{ required: true, message: '请选择活动区域', trigger: 'change' }
					],
				},
				ruleForm: {
		          name: '',
		          region: '',
		          date1: '',
		          date2: '',
		          delivery: false,
		          type: [],
		          resource: '',
		          desc: ''
		        },
			}
		},
		mounted() {
			
 	 	} ,
		methods: {
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
	    handleChange(value) {
			console.log(value);
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
			if(this.$route.params.type === 'ad'){
				this.typeName = '新增猪舍'
			}
			if(this.$route.params.type === 'ed'){
				this.typeName = '编辑猪舍'
			}
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

