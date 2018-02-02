<template>
	<div class="pig">
		<Top :HRight='HRight' :HTitle='HTitle'></Top>
		<div class="pigSer">
			<ul>
				<li>
					<span class="lableLeft">报告人：</span>
					<span class="lableRight" v-html="reportName"></span>
				</li>
				<li>
					<span class="lableLeft">报告时间：</span>
					<span class="lableRight" v-html="reportTime"></span>
				</li>
				<li>
					<span class="lableLeft">报告类型：</span>
					<span class="lableRight" v-html="reportType"></span>
				</li>
				<li>
					<span class="lableLeft">检查结果：</span>
					<span class="lableRight" v-html="checkResults"></span>
				</li>
				<li>
					<span class="lableLeft">处理结果：</span>
					<span class="lableRight" v-html="resultCode"></span>
				</li>
				<li>
					<span class="lableLeft">详请描述：</span>
					<span class="lableRight" v-html="descriptionDatil"></span>
				</li>
				<li>
					<span class="lableLeft">备注：</span>
					<span class="lableRight" v-html="mark"></span>
				</li>
			</ul>
		</div>
		<span class="cancel" @click='cancel'>关闭</span>
	</div>
</template>

<script>
	import Top from '../common/Top';
	import server from '../../server/myServer';
	export default {
		name: 'ReportDetails',
		data() {
			return {
				HRight: '',
				HTitle: '报告详情',
				reportName: '',
				reportType:'',
				checkResults:'',
				resultCode:'',
				descriptionDatil:'',
				mark:''
			}
		},
		methods: {
			//关闭
			cancel(){
				this.$router.push({
					path: '/Main/MyPig'
				});
				
			}
		},

		components: {
			Top
		},
		created() {
//			debugger;   
			let reportDetails = localStorage.getItem('reportDetails');
			let reportDetlArr = JSON.parse(reportDetails);
			this.reportName=reportDetlArr.id,
			this.reportType=reportDetlArr.id,
			 this.reportTime=reportDetlArr.id,
			 this.checkResults=reportDetlArr.id,
			 this.resultCode=reportDetlArr.id,
			 this.descriptionDatil=reportDetlArr.id,
			 this.mark=reportDetlArr.id
		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
.pig{
	width: 100%;
	height: 100%;
	background-color: #FFFFFF;
}
.pigSer {
	margin-top: .1rem;
	width: 100%;
	float: left;
	background: #FFFFFF;
	ul{
		padding: 0 .2rem;
	}
	li {
		height: .88rem;
		line-height: .88rem;
	}
	.none{
		display: none;
	}
	
	.lableLeft {
		float: left;
		display: inline-block;
		width: 1.8rem;
		text-align: left;
	}
	.lableRight {
		float: left;
		display: inline-block;
		width:5.2rem;
		text-align: left;
	}
}
.cancel{
	display: inline-block;
	margin-top:40%;
	width: 3rem;
	height: .8rem;
	border-radius: 1rem;
	line-height: .8rem;
	border: 1px solid #e3e3e3;
	color: #AFB7BF;
}
</style>