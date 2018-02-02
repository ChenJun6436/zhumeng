<template>
	<div class="pig">
		<Top :HRight='HRight' :HTitle='HTitle'></Top>
		<div class="pigSer">
			<ul>
				<li>
					<span class="lableLeft">ID:</span>
					<span class="pigId" v-html="pigId"></span>
				</li>
				<li>
					<span class="lableLeft">净重(kg):</span>
					<input class="suttles" placeholder="精确到小数点后两位" type="number" oninput="if(value.length>8)value=value.slice(0,8)" v-model.trim="suttlesVal"  @blur="inpBlur" ></input>
				</li>
				<li class="marketFlow_box" >
					<span class="lableLeft">流向市场:</span>
					<input class="marketFlow" placeholder="手机号/名称" type="text" v-model.trim="marketFlowVal" />
					<img @click='getMarketFlow' class="marketFlowSearch_img" :src="i_search_u" alt="">
					<div class="marketFlowList" :class="{ 'scollY': isFig,'none':isShow}">
						<dl v-for="i in list1">
							<dt>
								<dd v-html="i.name" @click="getMarketPseon(i)"></dd>
							</dt>
						</dl>
					</div>
				</li>
				<li>
					<span class="lableLeft">市场人员:</span>
					<Selecter :val='person' :selectedDef='selected2' @Change='marketPersonInfo' class="marketPersonSelect"></Selecter>
				</li>
			</ul>
		</div>
		<div class="partition"></div>
		<div class="marketPersonTab">
			<ul>
				<li style="display: none;">
					<span class="lableLeft">id</span>
					<span class="lableRight" v-html="marketId"></span>
				</li>
				<li>
					<span class="lableLeft">姓名</span>
					<span class="lableRight" v-html="name"></span>
				</li>
				<li>
					<span class="lableLeft">电话</span>
					<span class="lableRight" v-html="phone"></span>
				</li>
				<li>
					<span class="lableLeft">地址</span>
					<span class="lableRight" v-html="address"></span>
				</li>
			</ul>
		</div>
		<div class="btn-group">
			<span class="cancel" @click='cancel'>取消</span>
			<span class="confirm" @click='confirm'>保存</span>
			<!--<img @click='confirm' class="confirm_img" :src="i_confirm_u" alt="">-->
		</div>
	</div>
</template>

<script>
	import Top from '../common/Top';
	import Selecter from '../common/Selecter';
	import i_search from './../../assets/common/3.png';
	import i_confirm from './../../assets/common/ic_confirm.png';
	import { MessageBox } from 'mint-ui';
	import server from '../../server/myServer';
	export default {
		name: 'SalesEntry',
		data() {
			return {
				HRight: '',
				HTitle: '销售登记',
				pigId: '',
				suttlesVal: '',
				i_search_u: i_search,
				i_confirm_u:i_confirm,
				marketFlowVal: '',
				list1: [],
				selected2: '全部人员',
				person: '',
				marketId:'',
				name:'',
				isFig:false,
				isShow:true,
				phone:'',
				userId:'',
				address:'',
//				showf:true,
				type:''
			}
		},
		methods: {
			getMarketFlow() {
				var _this=this;
				if(this.marketFlowVal==""){
					_this.$msg('请输入电话/名称','middle');
				}else{
					let marketData={
						key:_this.marketFlowVal
					}
					server()._market(marketData).then(function(res) {
					if(res.data.code==0) {
						_this.list1 = res.data.data
						if(res.data.data.length>7)
							_this.isFig=true;
							_this.isShow=false;
					} else {
						_this.$msg(res.data.message)
					}
				})
				}
			},
			getMarketPseon(data) {
				//姓名，电话，地址赋值
				let _this=this;
				_this.marketId=data.id
				_this.marketFlowVal=data.name;
				_this.name=data.name;
				_this.phone=data.phone;
				_this.address=data.address;
				_this.isShow=true;
				//获取市场人员
				server()._maketPersons({marketId:data.id}).then(function(res) {
					if(res.data.code==0) {
						_this.person=res.data.data
						for(var i=0;i<_this.person.length;i++){
							_this.person[i].name=_this.person[i].value
						}
					} else {
						_this.$msg(res.data.message)
					}
				})
			},
			//保留两位小数
			inpBlur(){
            	this.suttlesVal= parseFloat(this.suttlesVal).toFixed(2);
            	
			},
			//市场人员
			marketPersonInfo(userInfo){
				this.userId= userInfo.key
			},
			//确定
			confirm(){
				let _this=this;
				 if(!this.suttlesVal){
					_this.$msg('请输入净重！','middle');
					return false;
				}else if(!this.marketId){
					_this.$msg('请选择市场！','middle');
					return false;
				}else if(!this.userId){
					//市场人员id
					_this.$msg('请选择市场人员！','middle');
					return false;
				}
				let salesEntryData={
					userId:this.userId,
					marketId:this.marketId,
					pigId:this.pigId,
					weight:this.suttlesVal
				};
				server()._salesEntry(salesEntryData).then(function(res) {
					if(res.data.code==0) {
						_this.$msg('录入成功！','middle');
						setTimeout(function() {
							if(_this.type=='index'){
								_this.$router.push({
									path: '/Main/Index'
								});
							}else{
								_this.$router.push({
									path: '/Main/MyPig'
								});
							}
						}, 1000);
					} else {
						_this.$msg(res.data.message)
					}
				})
			},
			//取消
			cancel(){
				if(this.type=='index'){
					this.$router.push({
						path: '/Main/Index'
					})
				}else{
					this.$router.push({
						path: '/Main/MyPig'
					})
				}
				
			}
			/*key(e){
            var _this=this;
            if(e.keyCode=='13'){
                _this.research(this.marketFlowVal);
            }
        },
    input() {
    	debugger
    	var _this=this;
	    var input = this.$refs.input;
	    input.addEventListener('input',function(){
	      this.marketFlowVal = input.value;
	      _this.research(this.marketFlowVal);
	    },false)*/
			////	  },
			//	   research(marketFlowVal) {
			//	   	debugger;
			//	   	if(marketFlowVal){
			//	   		console.log(564654)
			//	   	}

			//	   },
		},

		components: {
			Top,
			Selecter
		},
		created() {
//			debugger;   
			let salsEntry = localStorage.getItem('salsEntry');
			let salsEntryArr = JSON.parse(salsEntry);
			this.pigId=salsEntryArr.pigId;
			this.type=salsEntryArr.type;
//			this.showf=false;
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
		height: 3.8rem;
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
		.pigId{
			float: left;
			padding-left: .2rem;
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
			width: 8.2rem;
			text-align: left;
		}
		.scollY{
			overflow: hidden;
    		overflow-y: scroll;
		}
		.marketFlow_box {
			position: relative;
			.marketFlowList{
				position: absolute;
				top:.78rem;
				right: .1rem;
				width: 5.2rem;
				max-height: 5.2rem;
				border: .01rem solid #e3e3e3;
				border-radius: .2rem;
				z-index: 99;
				background: #FFFFFF;
				dd{
					text-align: left;
					margin: 0 .2rem;
				}
			}
		}
		.marketFlowSearch_img {
			position: absolute;
			width: 20px;
			height: 22px;
			right: .3rem;
			top: .2rem;
			z-index: 999999;
		}
		.suttles,
		.marketFlow {
			width: 4.8rem;
			height: .68rem;
			border-radius: .68rem;
			background-color: #FFFFFF;
			position: relative;
			margin-top: .1rem;
			float: left;
			padding: 0 .2rem;
			border: 1px solid #e3e3e3;
			z-index: 99999;
		}
		.marketPersonSelect {
			width: 5.2rem;
			float: left;
			margin-top: .1rem;
			margin-bottom: .3rem;
			select{
				width: 5.2rem!important;
			}
		}
	}
	.partition{
		clear: both;
		height: .2rem;
		width: 100%;
		background: #f1f1f1;
	}
	.marketPersonTab{
		width: 100%;
		margin-top: .2rem;
		background: #FFFFFF;
		ul{
			padding: 0 .2rem;
		}
		li {
			
			height: .88rem;
			line-height: .88rem;
			border-bottom: 1px solid #e3e3e3;
			.lableLeft {
				float: left;
				display: inline-block;
				width: 1.8rem;
				text-align: left;
			}
			.lableRight{
				width: 4.8rem;
				display: inline-block;
				text-align: right;
			}
		}
			
	}
	.btn-group{
		margin-top:2.5rem;
		span{
			display: inline-block;
			width: 3rem;
			height: .8rem;
			border-radius: 1rem;
			line-height: .8rem;
			border: 1px solid #e3e3e3;
		}
		.confirm{
			background: -webkit-linear-gradient(left, #75DA94, #53C7EE);
			color: #FFFFFF;
			border: 1px solid #75DA94;
		}
		.cancel{
			color: #AFB7BF;
		}
	}
</style>