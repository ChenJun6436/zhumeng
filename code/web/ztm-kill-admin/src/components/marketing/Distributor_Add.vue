<template>
	<div class="news_box">
		<ul class="nav">
			<li>屠宰场设置 》 </li>
			<li>合作商管理 》 </li>
			<li>{{typeName3}} 》 </li>
			<li class="active">{{typeName}}</li>
		</ul>
		<div class="news-content" style="padding-left: 50px;">
			<p style="line-height: 100px;font-size: 18px;font-weight: bold;">{{typeName2}}</p>
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="130px" class="demo-ruleForm" label-position='left' style='width: 780px;'>
			  <el-form-item label="企业名称：" prop="name">
			    <el-input v-model="ruleForm.name" placeholder='请填写销售商公司名称或销售商名称'></el-input>
			  </el-form-item>
			  <el-form-item label="联系方式：" prop="name">
			    <el-input v-model="ruleForm.name" placeholder='请填写手机号码'></el-input>
			  </el-form-item>
			  <el-form-item label="社会信用代码：" prop="name">
			    <el-input v-model="ruleForm.name" placeholder='社会信用代码 18位'></el-input>
			  </el-form-item>
			  <el-form-item label="公司地址：" prop="region">
			    <el-select v-model="ruleForm.region" placeholder="所有省" style='width: 183px;'>
			      <el-option label="区域一" value="shanghai"></el-option>
			      <el-option label="区域二" value="beijing"></el-option>
			    </el-select>
			    <el-select v-model="ruleForm.region" placeholder="所有市" style='width: 183px;margin-left: 27px;'>
			      <el-option label="区域一" value="shanghai"></el-option>
			      <el-option label="区域二" value="beijing"></el-option>
			    </el-select>
			    <el-select v-model="ruleForm.region" placeholder="所有区/县" style='width: 183px;margin-left: 27px;'>
			      <el-option label="区域一" value="shanghai"></el-option>
			      <el-option label="区域二" value="beijing"></el-option>
			    </el-select>
			  </el-form-item>
			  <el-form-item label="" prop="name">
			    <el-input v-model="ruleForm.name" placeholder='详细地址'></el-input>
			  </el-form-item>
			  <el-form-item>
			    <span  style='background: #BDBDBD;' :plain="true" class="add-btn">取消</span>
			    <span  :plain="false" class="add-btn">确定</span>
			  </el-form-item>
			</el-form>
		</div>
	</div>
</template>

<script>

	import server from '../../server/myServer';
	export default {
		name: "Distributor_Add",
		data() {
			return {
				typeName:'供应商信息',
				typeName2:'供应商信息',
				typeName3: '合作供应商',
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
		        rules: {
		          name: [
		            { required: true, message: '请输入活动名称', trigger: 'blur' },
		            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
		          ],
		          region: [
		            { required: true, message: '请选择活动区域', trigger: 'change' }
		          ],
		          date1: [
		            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
		          ],
		          date2: [
		            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
		          ],
		          type: [
		            { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
		          ],
		          resource: [
		            { required: true, message: '请选择活动资源', trigger: 'change' }
		          ],
		          desc: [
		            { required: true, message: '请填写活动形式', trigger: 'blur' }
		          ]
		        }
			}
		},
		mounted() {

   	 	} ,
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						alert('submit!');
					} else {
						console.log('error submit!!');
					return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
        },
		components: {

		},
		beforeCreate() {
 
		},
		created() {
			if(this.$route.params.type === 'ad1'){
				this.typeName = '新增销售商'
				this.typeName2 = '销售商信息'
				this.typeName3 = '合作销售商'
			}
			if(this.$route.params.type === 'ed1'){
				this.typeName = '编辑销售商'
				this.typeName2 = '销售商信息'
				this.typeName3 = '合作销售商'
			}
			if(this.$route.params.type === 'ad2'){
				this.typeName = '新增供应商'
				this.typeName2 = '供应商信息'
				this.typeName3 = '合作供应商'
			}
			if(this.$route.params.type === 'ed2'){
				this.typeName = '编辑供应商'
				this.typeName2 = '供应商信息'
				this.typeName3 = '合作供应商'
			}
		},
		 
	}

</script>

<style scope lang='scss'>

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

