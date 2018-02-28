<template>
	<div class="modal-bg">
		<div class="modal-box">
			<div class="modal-head">
				<span>新增销售商</span>
				<span @click='Close'  style='float: right;margin-right: 15px;cursor: pointer;'><i class="el-icon-close"></i></span>
			</div>
			<div class="modal-con" >
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="110px" class="demo-ruleForm" label-position='right' style='width: 500px;    margin: 0 auto;'>
				  <el-form-item  label="企业名称：" prop='name'>
				  	<el-input style='width: 380px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  </el-form-item>
				  <el-form-item  label="联系方式：" prop='name'>
				  	<el-input style='width: 300px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  </el-form-item>
				  <el-form-item  label="社会信用代码：">
				  	<el-input style='width: 300px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  </el-form-item>
				  <el-form-item  label="公司地址：" prop='name'>
				  	<el-select style='width: 120px;' v-model="value" placeholder="请选择">
						    <el-option>1
						    </el-option>
					  	</el-select>
					  	<el-select style='width: 120px;margin-left: 5px;' v-model="value" placeholder="请选择">
						    <el-option>1
						    </el-option>
					  	</el-select>
					  	<el-select style='width: 120px;margin-left: 5px;' v-model="value" placeholder="请选择">
						    <el-option>1
						    </el-option>
					  	</el-select>
				  </el-form-item>
				  <el-form-item>
				  	<el-input style='width: 380px;' v-model="ruleForm.name" placeholder='请输入该账号绑定的手机号'></el-input>
				  </el-form-item>
				  <el-form-item style='margin-top: 50px;'>
				    <span  style='background: #BDBDBD;' :plain="true" class="add-btn">取消</span>
				    <span  :plain="false" class="add-btn">确定</span>
				  </el-form-item>
				 </el-form>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
	import i_delete from '../../assets/icon/ic_delete.png'
	export default {
		name: 'SaleErAdd',
		data() {
			return {
				i_delete: i_delete,
				xx:false,
				tableData:[
					{num: '1111'},{num: '2222'},{num: '3333'},{num: '4444'},
					{num: '5555'},{num: '1111'},
				],
				ruleForm:{
					name:'',
				},
				rules:{
					name: [
			            { required: true, message: '请输入活动名称', trigger: 'blur' },
			            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
		          	],
				}
			}
		},
		methods: {
			Close() {
				this.$emit('Close')
			},
			Sure() {
				this.$emit('sureKill')
			}
		}
	}
</script>
<style scope lang='scss'>
	.modal-bg{
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		z-index: 2;
		background: rgba(0,0,0,0.6);
		.modal-box{
			height: 493px;
			width: 709px;
			overflow: hidden;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -245px;
			margin-left: -355px;
		}
		.modal-head{
			line-height: 40px;
			font-size: 17px;
			color: #fff;
			padding-left: 27px;
			background: #1FB5AD;
			overflow: hidden;
		}
		.modal-con{
			background: #fff;
			padding: 50px 40px ;
			.add-btn {
				color: #FFFFFF;
				display: inline-block;
				padding: 0 22px;
				text-align: center;
				line-height: 38px;
				font-size: 14px;
				background: #1FB5AD;
				border-radius: 5px;
				margin-left: 40px;
				cursor: pointer;
			}
		}
	}
</style>