<template>
  <div class="login-box">
    <img class="logo" :src="i_logo_u" alt="">
    <div class="iform">
      <div class="input_box">
        <img class="input_img" :src="i_sao_u" alt="">
        <input v-model='conText' class="input" type="text" name="" placeholder="输入ID号或扫码">
      </div>
      <BigBtn :btnName='btnName1' @Click='okay' :flag='flag'></BigBtn>
    </div>
    <Modal :showModal='showModal' @closeMdal='closeMdal' @Sure='Sure' @Back='Back' :title='title' 
      :conText='conText' :SBtnName1='SBtnName1' :SBtnName2='SBtnName2' :nowStep='nowStep' :nowType='nowType'
      :pigTypeList='pigTypeList' :pigDefaultType='pigDefaultType'
      ></Modal>
  </div>
</template>

<script>

import i_logo from './../../assets/index/logo@2x.png'
import i_sao from './../../assets/index/saoyisao@2x.png'

import BigBtn from '../common/BigBtn'
import Modal from '../common/Modal'

import Server from '../../server/myServer'
export default {
  name: 'Index',
  data () {
    return {
      i_logo_u: i_logo,
      i_sao_u: i_sao,
      btnName1: '确定',
      showModal: false,
      title: '请确定养殖以下生猪？',
      conText: '',
      SBtnName1: '是',
      SBtnName2: '否',
      nowStep: 0,
      nowType: 0,
      flag: true,
      pigTypeList: [],
      pigDefaultType: {},
      nowPigType: '',
      createrId: '',
      fileId: '',
    }
  },
  methods: {
    okay() {
      let vm = this
      vm.nowStep = 0
      if(vm.conText){
        Server()._pigStatus({sign: vm.conText, id: JSON.parse(localStorage.getItem('userInfo')).userId }).then(function(res){
          
          if(res.data.code === '0'){
            vm.nowType = 0
            vm.title = '请确定养殖以下生猪？'
            vm.SBtnName1 = '确定'
            vm.SBtnName2 = '取消'
            vm.createrId = res.data.data.createrId
            Server()._pigType().then(function(res){
              if(res.data.data){
                vm.pigTypeList = res.data.data
                vm.showModal = true
                vm.pigDefaultType = res.data.data[0]
                localStorage.setItem('pigType',JSON.stringify(res.data.data) )
              }
            })
          }else if(res.data.code === '1'){
            vm.nowType = 1
            vm.title = '您确定修改以下生猪状态？'
            vm.SBtnName1 = '确定'
            vm.SBtnName2 = '取消'
            vm.showModal = true
            vm.fileId = res.data.data.fileId
          }else {
            vm.$msg(res.data.message)
          }
        })
      }else {
        vm.$msg('请输入生猪ID号或扫码')
      }
    },
    closeMdal() {
      this.showModal = false
      this.nowStep = 0
    },
    Sure(MSG) {
      let vm = this
      vm.nowStep ++
      if(vm.nowStep === 1){
        vm.SBtnName1 = '确定'
        vm.SBtnName2 = '上一步'
        vm.nowStep = 1
        
        if(vm.nowType === 0){
          vm.title = '选择生猪类型：'
        }else if (vm.nowType ===1) {
          vm.title = '选择您需要的操作：'
        }       
      }else if(vm.nowStep === 2){
        vm.SBtnName1 = '确定'
        vm.SBtnName2 = '上一步'
        if(vm.nowType === 0){
          vm.nowPigType = MSG.id
          vm.nowStep = 2
          Server()._createFile({
            sign: vm.conText,
            pigType: vm.nowPigType,
            famerId: JSON.parse(localStorage.getItem('userInfo')).userId,
            createPeopleId: vm.createrId
          }).then(function(res){
            if(res.data.code === '0'){
              vm.showModal = false
              vm.conText = ''
              vm.$msg('生猪信息录入成功')
            }
          })
        }else if(vm.nowType === 1) {
          vm.title = '选择您需要的操作：'
          if(MSG === '1'){
            
          }else if (MSG === '2') {
            Server()._pigDie({
              id: vm.fileId,
              pigStatus: 0,
              currentUserId: JSON.parse(localStorage.getItem('userInfo')).userId,
            }).then(function(res){
              if(res.data.code === '0'){
                vm.showModal = false
                vm.conText = ''
                vm.$msg('生猪信息已更新')      
              }else{
                vm.$msg(res.data.message)
              }
            })
          }
        }
      }else if (vm.nowStep === 3) {
        vm.SBtnName1 = '确定'
        vm.SBtnName2 = '上一步'
        let cancelData = {
          id: vm.fileId,
          famerId: MSG.id,
          pigStatus: 0,
          sign: vm.conText,
          currentUserId: JSON.parse(localStorage.getItem('userInfo')).userId,
        }
        if(cancelData.famerId){
          Server()._cancelBreed(cancelData).then(function(res){
            if(res.data.code === '0'){
              vm.showModal = false
              vm.$msg('生猪信息已更新')
              vm.conText = ''
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
    Back() {
      this.nowStep --
      if(this.nowStep === 0){
        this.SBtnName1 = '是'
        this.SBtnName2 = '否'
      }else if(this.nowStep === -1){
        this.showModal = false
      }
    }
  },
  components: {
    BigBtn, Modal
  },
  created() {
    console.log()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    .logo{
      width: 1.8rem;
      margin-top: 1.5rem;
      margin-bottom: .5rem;
    }
    .input_img{
      width: .4rem;
      height: .4rem;
    }
    .input::-ms-input-placeholder{text-align: center;font-size: .3rem;}
    .input::-webkit-input-placeholder{text-align: center;font-size: .3rem;}
  }
  .selecter{
    width: 2.5rem;  
    select{
      width: 2.5rem;
    }
  }
</style>
