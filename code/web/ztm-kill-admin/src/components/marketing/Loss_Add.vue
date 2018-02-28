<template>

	<div class="news_box">
		<ul class="nav">
			<li>工作台 》 </li>
			<li>报损 》 </li>
			<li>报损列表 》 </li>
			<li class="active">新增报损报告 </li>
		</ul>
		<div class="news-content">
			<div style="line-height: 80px">
				<span style='margin-left: 40px;font-size: 18px;font-weight: bold;color: #1FB5AD'> 新增报损报告</span>
				<div style='float: right;margin-right: 40px;'>
					<p style='margin-left: 0;text-align:center;'>
						<span :plain="false" class="add-btn">确定</span>
						<span style='background: #BDBDBD;margin-left: 20px;' :plain="true" class="add-btn">取消</span>
					</p>
				</div>
			</div>
			<span class="border_bottom"></span>
			<div style='margin-left: 40px;margin-top: 20px;overflow: hidden'>
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" label-position='right' style='width: 45%;float: left;'>
					<div style='height: 40px;margin-bottom: 22px'>
						<el-form-item  style='float: left;'  label="经济类型：" prop='name'>
				  		<el-input style='width: 136px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  	</el-form-item>
				  	<el-form-item style='float: left;margin-left: 40px;'  label="报告时间：" prop='name'>
					  	<el-date-picker
					      v-model="value1"
					      type="date"
					      placeholder="选择日期">
					    </el-date-picker>
					  </el-form-item>
					</div>
					<el-form-item label="报损类型：" prop='name'>
			  		<el-radio v-model="radio" label="1">整头报损</el-radio>
  					<el-radio v-model="radio" label="2">重量报损</el-radio>
			  	</el-form-item>
			  	<el-form-item label="">
			  		<div style='height: 540px;border:1px solid #ddd;padding: 20px;'>
			  			<div v-if='radio==1'>
			  				<div style="line-height: 20px">
									<span style='font-size: 17px;font-weight: bold;'> 详情</span>
									<div style='float: right;margin-right: 40px;'>
										已添加：<span style='margin-right: 5px;font-size: 16px;font-weight: bold;color: #1FB5AD'> xxxx</span>/头
									</div>
								</div>
								<div>
									<el-input style='width: 50%;height: 41px;' placeholder="请输入ID"></el-input>
									<span @click='addBtn' :plain="true" class="add-btn" style='margin-left: 10px;'>确定</span>
									<span style='cursor: pointer;text-decoration: underline;color: #1FB5AD;margin-left: 10px;'>excel导入</span>
								</div>
								<el-table :data="tableData" border max-height="520">
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
			  			<div v-if='radio==2'>
			  				<div style="line-height: 20px;margin-bottom: 25px;">
									<span style='font-size: 17px;font-weight: bold;'> 详情</span>
								</div>
								<el-form-item style='margin-bottom: 20px;'  label="生猪重量：" prop='name'>
						  		<el-input style='width: 310px;' v-model="ruleForm.name" placeholder=''></el-input><span style='margin-left: 5px;'>kg</span>
						  	</el-form-item>
						  	<el-form-item style='margin-bottom: 20px;'  label="生猪头数：" prop='name'>
						  		<el-input style='width: 310px;' v-model="ruleForm.name" placeholder=''></el-input><span style='margin-left: 5px;'>头</span>
						  	</el-form-item>
						  	<el-form-item style='margin-bottom: 20px;'  label="包含部位：">
						  		<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
								  <div style="margin: 15px 0;"></div>
								  <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
								    <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
								  </el-checkbox-group>
						  	</el-form-item>
						  	<el-form-item style='margin-bottom: 20px;'  label="其他部位：" prop='name'>
						  		<el-input style='width: 310px;' v-model="ruleForm.name" placeholder=''></el-input>
						  	</el-form-item>
			  			</div>
			  		</div>
			  	</el-form-item>
			 	</el-form>
			 	<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" label-position='right' style='width: 45%;float: right;margin-right: 40px;'>
			 		<el-form-item  label="处理原因：" prop='name'>
			  		<el-input style='width: 136px;' v-model="ruleForm.name" placeholder=''></el-input>
			  	</el-form-item>
			  	<el-form-item  label="处理原因：">
			  		<el-input style='width: 95%;' v-model="ruleForm.name" placeholder='凭证号'></el-input>
			  	</el-form-item>
					<el-form-item  label="">
			  		<el-upload
						  action="https://jsonplaceholder.typicode.com/posts/"
						  list-type="picture-card"
						  :on-preview="handlePictureCardPreview"
						  :on-remove="handleRemove">
						  <i class="el-icon-plus"></i>
						</el-upload>
						<el-dialog :visible.sync="dialogVisible">
						  <img width="100%" :src="dialogImageUrl" alt="">
						</el-dialog>
			  	</el-form-item>
			  	<el-form-item  label="备注：">
			  		<el-input
			  			style='width: 95%;'
						  type="textarea"
						  :rows="6"
						  placeholder="200字以内"
						  v-model="ruleForm.name">
						</el-input>
			  	</el-form-item>
			 	</el-form>
			</div>
		</div>
	</div>
	<!--main-content end-->
	</div>
	<!--news_box end-->


</template>

<script scope>
	const cityOptions = ['上海', '北京', '广州', '深圳'];
	import server from '../../server/myServer';
	export default {
		name: "LossAdd",
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

