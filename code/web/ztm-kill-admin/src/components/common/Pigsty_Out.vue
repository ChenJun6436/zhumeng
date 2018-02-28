<template>
	<div class="modal-bg">
		<div class="modal-box">
			<div class="modal-head">
				<span>出舍</span>
				<span @click='Close'  style='float: right;margin-right: 15px;cursor: pointer;'><i class="el-icon-close"></i></span>
			</div>
			<div class="modal-con" >
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm" label-position='left' style='width: 280px;'>
					<el-form-item style='font-weight: bold;margin-bottom: 0px;'  label="xx猪舍">
				  	</el-form-item>
					<el-form-item style='margin-bottom: 0px;' label="可出头数：">
						<span>xxx</span>
					</el-form-item>
					<el-form-item style='margin-bottom: 0px;' label="出舍头数：">
						<el-input v-model="ruleForm.name" placeholder='请输入整数'></el-input>
					</el-form-item>
					<p style='margin-left: 0;text-align:center;margin-top:20px'>
						<span @click='Close'  style='background: #BDBDBD;' :plain="true" class="add-btn">取消</span>
						<span @click='sureOut' :plain="false" class="add-btn">确定</span>
					</p>
				</el-form>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
	export default {
		name: 'Pigsty_Out',
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
			sureOut() {
				this.$emit('Click')
			},
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
			height: 305px;
			width: 410px;
			overflow: hidden;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -150px;
			margin-left: -205px;
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
			padding: 20px 50px 10px 50px;
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