<template>
	<div class="modal-bg">
		<div class="modal-box">
			<div class="modal-head">
				<span>提示</span>
				<span @click='Close'  style='float: right;margin-right: 15px;cursor: pointer;'><i class="el-icon-close"></i></span>
			</div>
			<div class="modal-con" >
				<p style="font-weight: bold;font-size: 17px;text-align:center;">您是否确认屠宰“耳标号：<span>xxx</span>”</p>
				<div style='margin-left: 0;text-align:center;margin-top:40px'>
					<span @click='Close' style='background: #BDBDBD;margin: 0;' :plain="true" class="add-btn">取消</span>
					<span @click='Sure'  :plain="false" class="add-btn">确定</span>
				</div>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
	import i_delete from '../../assets/icon/ic_delete.png'
	export default {
		name: 'SlaughterAll',
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
			height: 210px;
			width: 500px;
			overflow: hidden;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -105px;
			margin-left: -250px;
			background: #fff;
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