<template>
  <div class="login-box">
    <div class="addbox">
      <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl'></Top>
      <div style='display: flex'>
        <span style='display: block;padding-top: .6rem;margin-left: 0.7rem;font-size: .28rem;'>地址：</span>
        <div class="addressFrom">
          <div class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD1'>
               <span v-if="_selectedDef1">{{_selectedDef1}}</span>
               <span v-if='!_selectedDef1' style="color: #e3e3e3;">{{s1}}</span> 
              </span>
              <span v-show='!showD1'>{{selected1.name}}</span>
            </span>
            <select v-model="selected1" @change='shengChange(selected1)' class="selecta" name="a">
              <option v-for='i in sheng' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </div>
          <div class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD2'>
               <span v-if="_selectedDef2">{{_selectedDef2}}</span>
               <span v-if='!_selectedDef2' style="color: #e3e3e3;">{{s2}}</span> 
              </span>
              <span v-show='!showD2'>{{selected2.name}}</span>
            </span>
            <select v-model="selected2" @change='shiChange(selected2)' class="selecta" name="a">
              <option v-for='i in shi' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </div>
          <div class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD3'>
               <span v-if="_selectedDef3">{{_selectedDef3}}</span>
               <span v-if='!_selectedDef3' style="color: #e3e3e3;">{{s3}}</span> 
              </span>
              <span v-show='!showD3'>{{selected3.name}}</span>
            </span>
            <select v-model="selected3" @change='xianChange(selected3)' class="selecta" name="a">
              <option v-for='i in xian' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </div>
          <div class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD4'>
               <span v-if="_selectedDef4">{{_selectedDef4}}</span>
               <span v-if='!_selectedDef4' style="color: #e3e3e3;">{{s4}}</span> 
              </span>
              <span v-show='!showD4'>{{selected4.name}}</span>
            </span>
            <select v-model="selected4" @change='zhenChange(selected4)' class="selecta" name="a">
              <option v-for='i in zhen' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </div>
          <div class="selecter" style="position: relative">
            <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
              <span v-show='showD5'>
               <span v-if="_selectedDef5">{{_selectedDef5}}</span>
               <span v-if='!_selectedDef5' style="color: #e3e3e3;">{{s5}}</span> 
              </span>
              <span v-show='!showD5'>{{selected5.name}}</span>
            </span>
            <select v-model="selected5" @change='cunChange(selected5)' class="selecta" name="a">
              <option v-for='i in cun' :value="i">{{i.name}}</option>
            </select>
            <img  class="select-right aa" :src="i_select_u" alt="">
          </div>
          <!-- <Selecter :val='sheng' @Change='shengChange' :selectedDef='_selectedDef1' :selectedDefaa ='s1'></Selecter> -->
          <!-- <Selecter :val='shi' @Change='shiChange' :selectedDef='_selectedDef2' :selectedDefaa ='s2'></Selecter> -->
<!--           {{_selectedDef2}} -->
          <!-- <Selecter :val='xian' @Change='xianChange' :selectedDef='_selectedDef3' :selectedDefaa ='s3'></Selecter> -->
          <!-- <Selecter :val='zhen' @Change='zhenChange' :selectedDef='_selectedDef4' :selectedDefaa ='s4'></Selecter> -->
          <!-- <Selecter :val='cun' @Change='cunChange' :selectedDef='_selectedDef5' :selectedDefaa ='s5'></Selecter> -->
        </div>
      </div>
      <p class="tipt"><img :src="i_wenhao_u" alt="">找不到所在地址？联系平台客服</p>
      <BigBtn :btnName='btnName' @Click='PulAddress' :flag='flag'></BigBtn>
    </div>
    
  </div>
</template>

<script>
import i_wenhao from './../../assets/common/wenhao.png'
import i_select from './../../assets/common/down@2x.png'
import BigBtn from './../common/BigBtn'
import Top from './../common/Top'
import Selecter from './../common/Selecter'

import server from '../../server/myServer'
export default {
  name: 'AddressManer',
  data () {
    return {
      i_select_u: i_select,
      selected1: '',selected2: '',selected3: '',selected4: '',selected5: '',
      showD1: true,showD2: true,showD3: true,showD4: true,showD5: true,
      i_wenhao_u: i_wenhao,
      HRight: '',
      HTitle: '地址管理',
      toUrl: '/Main/Percenter',
      btnName: '保存',
      flag: true,
      userInfo: {},
      sheng: [],
      shi: [],
      xian: [],
      zhen: [],
      cun: [],
      shengID: '',
      shiID: '',
      xianID: '',
      zhenID: '',
      cunID: '',
      selectedDef1: '',
      selectedDef2: '',
      selectedDef3: '',
      selectedDef4: '',
      selectedDef5: '',
      s1: '省',
      s2: '市',
      s3: '区',
      s4: '镇',
      s5: '村',
    }
  },
  methods: {
    shengChange(msg) {
      // console.log('sheng的当前值1：'+msg.name )
      this.shengID = msg
      this._getCity()
      this.selectedDef1 = msg.name
      this.selectedDef2 = ''
      this.selectedDef3 = ''
      this.selectedDef4 = ''
      this.selectedDef5 = ''
    },
    shiChange(msg) {
      this.shiID = msg
      this._getDistrict()
      this.selectedDef2 = msg.name
      this.selectedDef3 = ''
      this.selectedDef4 = ''
      this.selectedDef5 = ''

    },
    xianChange(msg) {
      this.xianID = msg
      this._getTown()
      this.selectedDef3 = msg.name
      this.selectedDef4 = ''
      this.selectedDef5 = ''
    },
    zhenChange(msg) {
      this.zhenID = msg
      this._getVillage()
      this.selectedDef4 = msg.name
      this.selectedDef5= ''
    },
    cunChange(msg) {
      this.cunID = msg
      this.selectedDef5 = msg.name
    },
    _getCity() {
      let vm = this
      // vm.selectedDef2 = ''
      server()._getCity({province_id: vm.shengID.key}).then(function(res){
        if(res.data.code === '0'){
          vm.shi = vm._changeNameValue(res.data.data) 
        }
      }).then(function(){
        
      })
      

    },
    _getDistrict() {
      let vm = this
      server()._getDistrict({city_id: vm.shiID.key}).then(function(res){
        if(res.data.code === '0'){
          vm.xian = vm._changeNameValue(res.data.data) 
        }else {
          
        }
      })
    },
    _getTown() {
      let vm = this
      server()._getTown({district_id: vm.xianID.key}).then(function(res){
        if(res.data.code === '0'){
          vm.zhen = vm._changeNameValue(res.data.data) 
        }else {
          
        }
      })
    },
    _getVillage() {
      let vm = this
      server()._getVillage({town_id: vm.zhenID.key}).then(function(res){
        if(res.data.code === '0'){
          vm.cun = vm._changeNameValue(res.data.data) 
        }else {
          
        }
      })
    },
    //转换value name
    _changeNameValue(a) {
      for(let i =0;i< a.length; i++){
        a[i].name = a[i].value
      }
      return a
    },
    //获取用户信息
    _getUserInfo() {
      let vm = this
      server()._getUserInfo({user_id:JSON.parse(localStorage.getItem('userInfo')).userId}).then(function(res){
        if(res.data.code === '0'){
          vm.selectedDef1 = res.data.data.province
          vm.selectedDef2 = res.data.data.city
          vm.selectedDef3 = res.data.data.district
          vm.selectedDef4 = res.data.data.town
          vm.selectedDef5 = res.data.data.village
          vm.sheng = vm._changeNameValue(res.data.data.provinceList)
          vm.shi = vm._changeNameValue(res.data.data.cityList)
          vm.xian = vm._changeNameValue(res.data.data.districtList)
          vm.zhen = vm._changeNameValue(res.data.data.townList)
          vm.cun = vm._changeNameValue(res.data.data.villageIdList)
          vm.shengID = {key: res.data.data.provinceId}
          vm.shiID = {key: res.data.data.cityId}
          vm.xianID = {key: res.data.data.districtId}
          vm.zhenID = {key: res.data.data.townId}
          vm.cunID = {key: res.data.data.villageId}
        }else {
          
        }
      })
    },
    PulAddress() {
      let vm = this
      if(vm.selectedDef1 == ''){
        vm.shengID = ''
      }
      if(vm.selectedDef2 == ''){
        vm.shiID = ''
      }
      if(!vm.selectedDef3){
        vm.xianID = ''
      }
      if(!vm.selectedDef4){
        vm.zhenID = ''
      }
      if(!vm.selectedDef5){
        vm.cunID = ''
      }
      let pulData = {
        userId:  JSON.parse(localStorage.getItem('userInfo')).userId,
        provinceId:  vm.shengID.key,
        cityId:  vm.shiID.key,
        districtId:  vm.xianID.key,
        townId:  vm.zhenID.key,
        villageId:  vm.cunID.key,
      }
      console.log(pulData)
      server()._pulAddress(pulData).then(function(res){
        if(res.data.code === '0'){
          vm.$msg('地址更新成功')
          setTimeout(function(){
            vm.$router.go('-1')
          }, 1500)  
        }else{
          vm.$msg(res.data.message)
        }
      })
    }
  },
  components: {
    Top, Selecter, BigBtn
  },
  created() {
    this._getUserInfo()
    this.userInfo = JSON.parse(localStorage.getItem('userInfo'))
  },
  computed:{
    _selectedDef1: function(){
      // console.log('sheng的当前值：'+this.selectedDef1 )
      return this.selectedDef1
    },
    _selectedDef2: function(){
      // console.log('shi的当前值：'+this.selectedDef2 )
      return this.selectedDef2
    },
    _selectedDef3: function(){
      return this.selectedDef3
    },
    _selectedDef4: function(){
      return this.selectedDef4
    },
    _selectedDef5: function(){
      return this.selectedDef5
    },
  },
  watch:{
　　'shengID.name':{
      handler:(val,oldVal)=>{
        // console.log(val +'___省ID变化___')
        // this.selectedDef2 = ''
        // console.log('省变化 我制空了shi')
      },
      // 深度观察
      deep:true
    }
　},

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang='less'>
  .login-box{

    .addbox{
      background-color: #fff;
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
      .addressFrom{
        .selecter{
          height: .7rem;
          width: 5rem;
          border: 1px solid #e3e3e3;
          // margin: 0 auto;
          margin-top: .46rem;
          border-radius: .7rem;
          .aa{
            width: .2rem;
            // height: .12rem;
            float: right;
            margin-right: .3rem;
            margin-top: .25rem;
          }
          select{
            opacity: 0;
            text-indent: .1rem;
            width: 4.3rem;
            height: .6rem;
            outline: none;
            appearance:none;
            -moz-appearance:none;
            option{
              text-indent: .2rem;
              // color: #444;
            }
          }
        }
      }
      .btn-box{
        width: 6.8rem;
      }
      .tipt{
        margin-top: .4rem;
        line-height: .28rem;
        font-size: .28rem;
        color: #95A0AA;
        img{
          width: .28rem;
          height: .28rem;
        }
      }
    }
  }
</style>
