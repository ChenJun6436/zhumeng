<template>
	<div class="modal-bg">
		<div class="modal-box">
			<div class="modal-head">
				<span>手机换绑</span>
				<span @click='Close'  style='float: right;margin-right: 15px;cursor: pointer;'><i class="el-icon-close"></i></span>
			</div>
			<div class="modal-con">
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0" class="demo-ruleForm" label-position='right' style='width: 403px;'>
				  <el-form-item  label="">
				  	<el-input v-model="ruleForm.name" placeholder='请输入新绑定的手机号'></el-input>
				  </el-form-item>
				  <el-form-item  label="">
				  	<el-input style='width: 243px;' v-model="ruleForm.name" placeholder='请输入验证码'></el-input>
				  	<span  :plain="false" class="add-btn">获取验证码</span>
				  </el-form-item>
				  <el-form-item style='margin-top: 100px;'>
				    <span  style='background: #BDBDBD;' :plain="true" class="add-btn">取消</span>
				    <span  :plain="false" class="add-btn">下一步</span>
				  </el-form-item>
				 </el-form>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
	export default {
		name: 'ChangePhone',
		data() {
			return {
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
			width: 585px;
			overflow: hidden;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -245px;
			margin-left: -290px;
		}
		.modal-head{
			line-height: 40px;
			font-size: 17px;
			color: #fff;
			padding-left: 27px;
			background: #1FB5AD;
		}
		.modal-con{
			background: #fff;
			padding: 50px 90px ;
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