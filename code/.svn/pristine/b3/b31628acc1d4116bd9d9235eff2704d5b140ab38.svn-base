<template>
	<div class="pig">
		<Top :HRight='HRight' :HTitle='HTitle'></Top>
		<div class="pigSer">
			<ul>
				<li>
					<div class="input_box">
						<input v-model='pigKeyWord' class="input" type="text" name="" placeholder="输入ID搜索">
					</div>
					<img @click='getMypig' class="input_img_right" :src="i_search_u" alt="">
				</li>
			</ul>
			<ul>
				<li>
					<!--<Selecter :val='xx1' :selectedDef='selected1' @Change='ChangeType'></Selecter>-->
					<!---->
					<Selecter :val='status' :selectedDef='selected2' @Change='ChangeStatus' class="statusSelect"></Selecter>
				</li>
				<li>
					<!--时间-->
					<SlDate @getNowDate='getNowDateStart' :dateDfl='dateStart'></SlDate>
					<span style="width: .3rem;line-height: .7rem;">-</span>
					<SlDate @getNowDate='getNowDateEnd' :dateDfl='dateEnd'></SlDate>
				</li>
			</ul>
		</div>
		<div class="pigTab" style='height: 7rem;'>
			<dl>
				<dt> 
		            <span>ID</span> 
		            <span>状态</span> 
		            <span>养殖时间</span>
		        </dt>
				<div style='height: 5.5rem;overflow-y: auto'>
					<mt-loadmore :bottom-method="loadBottom" :bottom-all-loaded="allLoaded" bottomPullText='上拉加载更多' ref="loadmore" :auto-fill='false'>
						<dd v-for="i in list1" >
							<!--{{i}}-->
							<span>{{i.pigId}}</span>
							<!--<span>{{i.pigType}}</span>-->
							<span v-show='i.status==0'>正常</span>
							<span v-show='i.status==1'>死亡 </span>
							<span v-show='i.status==2' @click="checkOut(i)" class="text-danger" >宰前待检查 </span>
							<span v-show='i.status==3' @click="butcher(i)">待屠宰 </span>
							<span v-show='i.status==4' @click="checkOut(i)" class="text-danger">宰后待检验 </span>
							<span v-show='i.status==5'  @click="entrySales(i)">待销售 </span>
							<span v-show='i.status==6' class="text-danger" @click="handled(i)">已处理 </span>
							<span v-show='i.status==7' >已销售 </span>
							<span>{{i.createTime}}</span>
						</dd>
					</mt-loadmore>
				</div>
			</dl>
		</div>
		<Modal :showModal='showModal':radioShow='radioShow' @closeMdal='closeMdal' @Sure='Sure' @changeRdio='getRdioValue' @Back='Back' :title='title' :conText='conText'
			 :SBtnName1='SBtnName1' :SBtnName2='SBtnName2' :radioRight='radioRight' :radioLeft='radioLeft'></Modal>
	</div>
</template>

<script>
	import Top from '../common/Top';
	import Selecter from '../common/Selecter';
	import SlDate from '../common/SlDate';
	import { MessageBox } from 'mint-ui';
	import i_search from './../../assets/common/search@2x.png';
	import Modal from '../common/Modal';
	import server from '../../server/myServer';
	export default {
		name: 'MyPig',
		data() {
			return {
				HRight: '',
				HTitle: '我的猪',
				i_search_u: i_search,
				status: [{
					id: "",
					name: '全部状态'
				},{
					id: "0",
					name: '正常'
				}, {
					id: "1",
					name: '死亡'
				}, {
					id: "2",
					name: '待屠宰录入'
				}, {
					id: "3",
					name: '待屠宰'
				}, {
					id: "4",
					name: '宰后待检验'
				}, {
					id: "5",
					name: '待销售'
				}, {
					id: "6",
					name: '已处理'
				}, {
					id: "7",
					name: '已销售'
				}],
				list1: [],
				allLoaded: false,
				pigKeyWord: '',
				//    selected1: '全部品种',
				selected2: '全部状态',
				dateStart: '请选择开始时间',
				dateEnd: '请选择结束时间',
				serPigStatus: '',
				startTime: '',
				endTime: '',
				showModal: false,//屠宰弹框
				radioShow:true,
				title: '您将要屠宰：',
				conText: '',
				SBtnName1: '确定',
				SBtnName2: '取消',
				radioLeft:'销售登记',
				radioRight:'屠宰',
				pigStatusId:''//生猪状态
			}
		},
		methods: {
			ChangeStatus(msg) {
				this.serPigStatus = msg
				this.pigStatusId=msg.id
				this.getMypig()
			},
			loadBottom() {
				this.allLoaded = true; // 若数据已全部获取完毕
				this.$refs.loadmore.onBottomLoaded();
			},
			butcher(i) { //屠宰
				this.conText = i.pigId;
				this.showModal= true;
			},
			handled(data){//已处理
				localStorage.setItem('reportDetails', JSON.stringify(data));
				this.$router.push({ path: '/Main/ReportDetails'});
			},
			checkOut(i) { //检验提示
				MessageBox({
					message:'<div class="msgbox-message"><p class="fontWei">ID:'+ i.pigId+'</p>需要检疫中心完成检疫后才可操作！</div>', 
					confirmButtonText:'关闭',
					title:''
				});

			},
			closeMdal(){//关闭
				this.showModal = false;
			},
			Sure(){//确定
				var userInfo = localStorage.getItem('userInfo');
				var userInfoArr = JSON.parse(userInfo);
				var _this=this;
				let slaughterData = {
					userId:userInfoArr.userId,
					pigId:_this.conText
				};
				server()._slaughter(slaughterData).then(function(res) {
					if(res.data.code === '0') {
						_this.showModal = false;
						_this.$msg('ID:'+_this.conText+'已屠宰','middle');
					}else{
						_this.$msg(res.data.message)
					}
				});
			},
			getRdioValue(){
				
			},
			Back(){//取消
				this.showModal = false
			},
			getMypig() { //获取生猪
				let vm = this
				let pigData = {
					id: JSON.parse(localStorage.getItem('userInfo')).userId,
					beginDate: vm.startTime,
					endDate: vm.endTime,
					keyWords: vm.pigKeyWord,
					pigStatus:vm.pigStatusId
				};
				for(var key in pigData) {
					if(pigData[key] == "") {
						delete pigData[key]
					}
				}
				server()._myPig(pigData).then(function(res) {
					if(res.data.code==0) {
						vm.list1 = res.data.data
					} else {
						vm.$msg(res.data.message)
					}
				})
			},
			getNowDateStart(msg) {
				this.startTime = msg
				this.getMypig()
			},
			getNowDateEnd(msg) {
				this.endTime = msg
				this.getMypig()
			},
			entrySales(data){//销售录入
				localStorage.setItem('salsEntry', JSON.stringify({pigId:data.pigId,type:'myPig'}));
				this.$router.push({ path: '/Main/SalesEntry'});
				this.getMypig()
			}
		},
		components: {
			Top,
			Selecter,
			SlDate,
			Modal
		},
		created() {
			//  this.xx1 = JSON.parse(localStorage.getItem('pigType'))
			this.getMypig()
		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
	.dieStyle {
		color: #95A0AA;
	}

	.pig {
		.selecter {
			width: 6.8rem;
			select {
				width: 6.8rem!important;
			}
		}
		.pigTab {
			margin-top: .2rem;
			background-color: #ffffff;
			dt,
			dd {
				display: flex;
				padding: .32rem;
				border-bottom: 1px solid #e3e3e3;
				span {
					width: 33%;
				}
			}
			dt{
				font-weight: bold;
				font-size: .3rem;
			}
		}
	}
	
	.text-danger {
		color: red;
	}
	
	.pigSer ul {
		background-color: #fff;
	}
	
	.pigSer li {
		width: 6.8rem;
		padding: .32rem 0;
		display: flex;
		margin: 0 auto;
		box-sizing: border-box;
		border-bottom: 1px solid #e3e3e3;
		.input_img_right {
			width: .92rem;
			height: .68rem;
			// margin-top: .32rem;
			margin-left: .14rem;
		}
		.input_box {
			width: 5.8rem;
			height: .68rem;
			border-radius: .68rem;
			background-color: #ffffff;
			margin-top: 0rem;
			margin-right: 0;
			border: 1px solid #e3e3e3;
			// margin-left: .32rem; 
			.input_img {
				display: none
			}
			.input_left {
				display: block;
				width: 1rem;
				height: .4rem;
				float: left;
				margin-left: .3rem;
				margin-top: .24rem;
			}
			.input {
				float: left;
				height: .5rem;
				margin-top: .1rem;
				width: 3.5rem;
				margin-left: .5rem;
				border: none;
				font-size: .3rem;
				background: none;
				outline: none;
				color: #444444;
			}
			.selecter {
				width: 3.2rem;
				select {
					width: 3.2rem;
				}
			}
		}
	}
</style>