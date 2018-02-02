<template>
	<div class="login-box">
		<img class="logo" :src="i_logo_u" alt="">
		<div class="iform">
			<div class="input_box">
				<img class="input_img" :src="i_sao_u" alt="">
				<input class="input" type="text" name="" placeholder="输入ID号或扫码" maxlength="9" v-model="pigId">
			</div>
			<BigBtn :btnName='btnName1' @Click='okay' :flag='flag'></BigBtn>
		</div>
		<Modal :showModal='showModal':radioShow='radioShow' @closeMdal='closeMdal' @Sure='Sure' @changeRdio='getRdioValue' @Back='Back' :title='title' :conText='conText'
			 :SBtnName1='SBtnName1' :SBtnName2='SBtnName2' :radioRight='radioRight' :radioLeft='radioLeft'></Modal>

	</div>
</template>

<script>
	import i_logo from './../../assets/index/logo@2x.png';
	import i_sao from './../../assets/index/saoyisao@2x.png';
	import BigBtn from '../common/BigBtn';
	import { MessageBox } from 'mint-ui';
	import Modal from '../common/Modal';
	import server from '../../server/myServer';
	export default {
		name: 'Index',
		data() {
			return {
				i_logo_u: i_logo,
				i_sao_u: i_sao,
				btnName1: '确定',
				flag: true,
				showModal: false,
				title: '请确定操作以下生猪？',
				conText: '',
				SBtnName1: '是',
				SBtnName2: '否',
				nowStep: 0,
				radioShow:true,
				radioValue:1,
				pigId: '',
				radioLeft:'销售登记',
				radioRight:'屠宰'
			}
		},
		methods: {
			okay() {
				var _this = this;
				if(!this.pigId) {
					_this.$msg('请输入ID号！');
					return false;
				};
				
				let existPigData = {
					pigId: _this.pigId
				};
				server()._existPig(existPigData).then(function(res) {
					if(res.data.code === '0') {
						_this.conText = _this.pigId;
						_this.radioShow=true;
						_this.showModal = true;
						
					} else {
						_this.$msg(res.data.message)
					}
				});

			},
			closeMdal() {
				this.showModal = false;
				this.title='请确定操作以下生猪？';
				this.SBtnName1 = '是';
				this.SBtnName2 = '否';
			},
			Sure() {
//				this.nowStep = 0
//				this.nowStep++
				var _this=this;
				if(this.SBtnName1 === '是') {//选择需要的操作
					this.title = '请选择你需要的操作：';
					this.radioShow=false;
					this.SBtnName1 = '确定';
					this.SBtnName2 = '上一步';
				} else if(this.SBtnName1 === '确定') {
					var userInfo = localStorage.getItem('userInfo');
					var userInfoArr = JSON.parse(userInfo);
					if(this.radioValue==1){
						//销售登记
						let existData={
							pigId:_this.pigId,
							userId:userInfoArr.userId
						}
						server()._exist(existData).then(function(res) {
							if(res.data.code === '0') {
								localStorage.setItem('salsEntry', JSON.stringify({pigId:_this.pigId,type:'index'}));
								_this.$router.push({ path: '/Main/SalesEntry'});
								
							}else{
								_this.$msg(res.data.message)
							}
						})
						
					}else if(this.radioValue==2){
						//屠宰
						if(this.title=='请选择你需要的操作：'){
							this.title = '您将要屠宰：';
							this.radioShow=true;
							this.conText = this.pigId;
						}else{
							let slaughterData = {
								userId:userInfoArr.userId,
								pigId:_this.pigId
							};
							server()._slaughter(slaughterData).then(function(res) {
								if(res.data.code === '0') {
									_this.showModal = false;
									_this.title='请确定操作以下生猪？';
									_this.$msg('ID:'+_this.pigId+'已屠宰','middle');
									_this.SBtnName1 = '是';
									_this.SBtnName2 = '否';
									_this.pigId="";
								}else{
									_this.$msg(res.data.message)
								}
							});
						};
					};
				}
			},
			Back() {
				if(this.SBtnName2 === '上一步') {
					if(this.title=='请选择你需要的操作：'){
						this.title = '请确定操作以下生猪？',
						this.radioShow=true;
						this.SBtnName1 = '是'
						this.SBtnName2 = '否'
					}else if(this.title=='您将要屠宰：'){
						this.title = '请选择你需要的操作：';
						this.radioShow=false;
						this.SBtnName1 = '确定';
						this.SBtnName2 = '上一步';
					}
					
				} else if(this.SBtnName2 === '否') {
					this.showModal = false
				}
			},
			getRdioValue(val){
				this.radioValue=val
			}
		},
		components: {
			BigBtn,
			Modal
		},
		created() {
			let _this = this;
			let userInfo = localStorage.getItem('userInfo');
			let userInfoArr = JSON.parse(userInfo);
			if(!userInfoArr) {
				MessageBox.alert('请登录！').then(action => {
			
					_this.$router.push({
						path: '/Login'
					})
				});
			};

		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
	.login-box {
		.logo {
			width: 1.8rem;
			margin-top: 1.5rem;
			margin-bottom: .5rem;
		}
		.input_img {
			width: .4rem;
			height: .4rem;
		}
		.input::-ms-input-placeholder {
			text-align: center;
			font-size: .3rem;
		}
		.input::-webkit-input-placeholder {
			text-align: center;
			font-size: .3rem;
		}
	}
	
	.selecter {
		width: 2.5rem;
		select {
			width: 2.5rem;
		}
	}
</style>