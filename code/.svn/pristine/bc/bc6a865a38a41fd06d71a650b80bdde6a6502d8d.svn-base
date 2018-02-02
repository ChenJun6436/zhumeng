<template>
  <div class="pig" >
    <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl' :showLeft='showLeft'></Top>
      <ul class="pigSer">
        <li>
          <div class="input_box">
            <input v-model='pigKeyWord' class="input" type="text" name="" placeholder="输入ID搜索">
          </div>
          <img @click='getMypig' class="input_img_right" :src="i_search_u" alt="">
        </li>
      </ul>
      <ul class="pigSer">
        <li>
          <!-- <p class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD'>
               <span v-if="selected1">{{selected1}}</span>
               <span v-if='!selected1' style="color: #e3e3e3;">{{selectedDefaa}}</span> 
              </span>
              <span v-show='!showD'>{{selected.name}}</span>
            </span>
            <select v-model="selected" @change='ChangeType' @click='cll' class="selecta" name="a">
              <option v-for='i in xx' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </p> -->
          <Selecter :val='xx' :selectedDef='selected1' @Change='ChangeType'></Selecter>
          <Selecter :val='xx2' :selectedDef='selected2' @Change='ChangeStatus'></Selecter>
        </li>
        <li>
          <SlDate :defTitle='defTitle1' @getNowDate='getNowDateStart' style='margin-left:.06rem;'></SlDate>
          <span style="width: .2rem;line-height: .7rem;">-</span>
          <SlDate :defTitle='defTitle2' @getNowDate='getNowDateEnd'></SlDate>
        </li>
      </ul>
    <div class="pigTab" style='height: 7rem;'>
      
        <dl >
          <dt> 
            <span>ID</span> 
            <span>品种</span> 
            <span>状态</span> 
            <span>养殖时间</span>
          </dt>
          <div style='height: 6.1rem;overflow-y: auto'>
            <mt-loadmore  :bottom-method="loadBottom" :bottom-all-loaded="allLoaded" bottomPullText='上拉加载更多' ref="loadmore" :auto-fill='false'>
              <dd v-for="item in list1" :class="{'dieStyle':item.pigStatus==1}" @click='clickList(item)'>
                <span>{{item.sign}}</span>
                <span>{{item.pigType}}</span>
                <span>{{item.pigStatus === 0? '正常' : "死亡"}}</span>
                <span>{{item.createTime}}</span>
              </dd>
            </mt-loadmore>
          </div>
        </dl>
    </div>
    <Modal :showModal='showModal' @closeMdal='closeMdal' @Sure='Sure' @Back='Back' :title='title' 
      :conText='conText' :SBtnName1='SBtnName1' :SBtnName2='SBtnName2' :nowStep='nowStep' :nowType='nowType'
      :pigDefaultType='pigDefaultType' ></Modal>
  </div>
</template>

<script>
import Top from '../common/Top'
import Selecter from '../common/Selecter'
import SlDate from '../common/SlDate'
import Modal from '../common/Modal'

import i_search from './../../assets/common/search@2x.png'
// import i_select from './../../assets/common/down@2x.png'
import Server from '../../server/myServer'
export default {
  name: 'MyPig',
  data () {
    return {
      defTitle1:'开始时间',
      defTitle2:'结束时间',
      showLeft: true,
      // i_select_u: i_select,
      // selected: '',
      // showD: true,
      selected:'',
      HRight:'',
      HTitle:'我的猪',
      toUrl: "-1",
      i_search_u: i_search,
      xx: [],
      xx2: [{name:'全部状态',status:''},{name:'正常',status:0},{name:'死亡',status:1}],
      list1: [],
      allLoaded: false,
      pigKeyWord: '',
      selected1: '全部品种',
      selected2: '全部状态',
      serPigType:'',
      serPigStatus:'',
      startTime: '',
      endTime: '',
      showModal: false,
      title: '您确定修改以下生猪状态？',
      conText: '0',
      nowStep: 0,
      nowType: 1,
      SBtnName1: '是',
      SBtnName2: '否',
      pigDefaultType: {},
      fileId: '',
    }
  },
  methods: {
    ChangeType(msg) {
      this.serPigType = msg.select.id
      this.getMypig()
    },
    ChangeStatus(msg) {
      this.serPigStatus = msg.select.status
      this.getMypig()
    },
    loadBottom() {
      this.allLoaded = true;// 若数据已全部获取完毕
      this.$refs.loadmore.onBottomLoaded();
    },
    getMypig() {
      let vm = this
      let pigData = {
        id: JSON.parse(localStorage.getItem('userInfo')).userId,
        beginDate: vm.startTime,
        endDate: vm.endTime,
        keyWords: vm.pigKeyWord,
        pigStatus: vm.serPigStatus,
        pigType: vm.serPigType,
      }
      for(var i in pigData) {
        if(pigData[i] === ''){
          delete pigData[i] 
        }
      }
      // console.log(pigData)
      Server()._myPig(pigData).then(function(res){
        if(res.data.data){
          vm.list1 = res.data.data
        }else{
          this.$msg(res.data.message)
        }
      })
      
    },
    getPigType() {
      let vm = this
      Server()._pigType().then(function(res){
        if(res.data.data){
          vm.xx = res.data.data
          vm.xx.unshift({id:'',name:'全部品种'})
          // vm.showModal = true
          // vm.pigDefaultType = res.data.data[0]
          // localStorage.setItem('pigType',JSON.stringify(res.data.data) )
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
    Sure(MSG) {
      let vm = this
      vm.nowStep ++
      if(vm.nowStep === 1){
        vm.SBtnName1 = '确定'
        vm.SBtnName2 = '上一步'
        vm.nowStep = 1
        vm.title = '选择您需要的操作：'
      }else if(vm.nowStep === 2){
          vm.title = '请选择养殖户：'
          vm.SBtnName1 = '确定'
          vm.SBtnName2 = '上一步'
          if(MSG === '1'){
            
          }else if (MSG === '2') {
            vm.showModal = false
            Server()._pigDie({
              id: vm.fileId,
              pigStatus: 0,
              currentUserId: JSON.parse(localStorage.getItem('userInfo')).userId,
            }).then(function(res){
              if(res.data.code === '0'){
                vm.conText = ''
                vm.$msg('生猪信息已更新')      
                vm.getMypig()
              }else{
                vm.$msg(res.data.message)
              }
            })
          }
      }else if (vm.nowStep === 3) {
        
        if(MSG.id){
          Server()._cancelBreed({
            id: vm.fileId,
            famerId: MSG.id,
            pigStatus: 0,
            sign: vm.conText,
            currentUserId: JSON.parse(localStorage.getItem('userInfo')).userId,
          }).then(function(res){
            if(res.data.code === '0'){
              vm.showModal = false
              vm.$msg('生猪信息已更新')
              vm.conText = ''
              vm.getMypig()
            }else{
              vm.$msg(res.data.message)
            }
          })
        }else {
          vm.nowStep = 2
          vm.$msg('请选择养殖户')
        }
        
      }
    },
    clickList(msg) {
      let vm = this
      vm.conText = msg.sign
      if(msg.pigStatus === 0){
        Server()._pigStatus({sign: vm.conText, id: JSON.parse(localStorage.getItem('userInfo')).userId }).then(function(res){        
         if(res.data.code === '1'){
            vm.nowStep = 0
            vm.nowType = 1
            vm.title = '您确定修改以下生猪状态？'
            vm.SBtnName1 = '是'
            vm.SBtnName2 = '否'
            vm.showModal = true
            vm.fileId = res.data.data.fileId
          }else {
            vm.$msg(res.data.message)
          }
        }) 
      }else {
        vm.$msg('生猪已死亡，不能操作')
      }
    },
    Back() {
      this.nowStep --
      if(this.nowStep === 0){
        this.SBtnName1 = '是'
        this.SBtnName2 = '否'
      }else if(this.nowStep === -1){
        this.showModal = false
      }
    },
    closeMdal() {
      this.nowType = 1
      this.nowStep = 0
      this.title = '您确定修改以下生猪状态？'
      this.showModal = false
    }
  },
  components: {
    Top, Selecter, SlDate, Modal
  },
  created() {
    this.toUrl = localStorage.getItem('router')
    this.xx = JSON.parse(localStorage.getItem('pigType'))
    this.getMypig()
    this.getPigType()
  },
  beforeCreate() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
.dieStyle{
  color:#95A0AA;
}

.pig{

  .selecter{
    height: .7rem;
    width: 3.2rem;
    border: 1px solid #e3e3e3;
    margin: 0 auto;
    border-radius: .7rem;;
    select{
      opacity: 0;
      text-indent: .1rem;
      
      width: 3.2rem;
      height: .6rem;
      outline: none;
      appearance:none;
      -moz-appearance:none;
      option{
        text-indent: .1rem;
        color: #444;
      }
    }
    .select-right{
      width: .2rem;
      height: .12rem;
      float: right;
      margin-right: .2rem;
      position: absolute;
      right: 0;
      top: .3rem;
    }
  }
  .pigTab{
    margin-top: .2rem;
    background-color: #ffffff;
    dt,dd{
      display: flex;
      padding: .32rem;
      border-bottom: 1px solid #e3e3e3;
      span{
        width: 25%;
      }
    }
    dt{
      font-weight: bold;
      font-size: .3rem;
    }
  }
}
.pigSer{
  background-color: #fff;
}

.pigSer li{
  width: 6.8rem;
  padding: .32rem 0;
  display: flex;
  margin: 0 auto;
  box-sizing: border-box;
  border-bottom: 1px solid #e3e3e3;
  .input_img_right{
    width: .92rem;
    height: .68rem;
    // margin-top: .32rem;
    margin-left: .14rem;
  }
  .input_box{
    width: 5.8rem;
    height: .68rem;
    border-radius: .68rem;
    background-color: #ffffff;
    margin-top: 0rem;
    margin-right: 0;
    border: 1px solid #e3e3e3;
    // margin-left: .32rem; 
    .input_img{
      display: none
    }
    .input_left{
      display: block;
      width: 1rem;
      height: .4rem;
      float: left;
      margin-left: .3rem;
      margin-top: .24rem;
      
    }
    .input{
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
    .selecter{
      width: 3.2rem;  
      select{
        width: 3.2rem;
      }
    }
  }
  
  }
</style>
