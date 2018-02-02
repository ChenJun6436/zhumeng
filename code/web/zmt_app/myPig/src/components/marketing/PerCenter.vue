<template>
  <div class="per-box" @touchmove.prevent>
    <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl' @Click='logOut' :showLeft='showLeft'></Top>
    <div class="per-form">
      <div class="myLi" style='overflow: hidden;'>
        <div v-show='!editor'  style="text-align:left;font-size: .30rem;font-weight: bold;">
          <span style="text-align:left;">{{farmName}} <span style="font-weight: normal; font-size: .28rem;">({{userType == 1? '养殖场':'个体' }})</span> </span>
          <img @click='editorName' class="editorIMG" :src="i_editor_u" alt="">
        </div>
        <div class="input_box" v-show='editor'>
          <input v-model='newName' class="input" type="text" name=""  style='width: 4.8rem'>
        </div>
      </div>
      <div  v-show='!editor && farm' style="text-align: left; height: .5rem;overflow: hidden;">
        <span class="leftTitle" v-show='!editor' style="line-height: .3rem;font-size: .3rem;">饲料名称：{{food?food:'未喂养饲料'}}</span>
      </div>
      <div v-show='editor && farm' class="myLi" >
        <div class="input_box"  style="top: 2.2rem">
          <span class="input_left" style="width: 1.5rem;line-height: 0.2rem;">饲料名称：</span>
          <input v-model='newFood' class="input" type="text" name="" style="margin-left: 0.2rem;width: 3.6rem;">
        </div>
      </div>
    </div>
    <div style="height: .2rem;background-color: #e3e3e3">
      
    </div>
    <div class="per-form sth-form">
      <div class="myLi sth-myLi"  @click='goPhone'>
        <span class="leftTitle sth-leftTitle">联系方式</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
        <span class="rightTitle">{{_uPhone}}</span>
      </div>
      <div class="myLi sth-myLi" @click='goPulPs'>
        <span class="leftTitle sth-leftTitle" >修改登录密码</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="myLi sth-myLi" @click='goAddress'>
        <span class="leftTitle sth-leftTitle">地址管理</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="myLi sth-myLi" @click='goFindPs'>
        <span class="leftTitle sth-leftTitle">忘记密码</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="mtfooter" v-show='editor'>
        <SmallBtnNo :btnName='btnName2' @Click='cancel'></SmallBtnNo>
        <SmallBtn :btnName='btnName1' @Click='sure' style='margin-left: .3rem;'></SmallBtn>
      </div>
      <BigBtn @Click='logOut' :btnName='btnName' style="width: 6.8rem;margin-top:2rem" :flag='flag'></BigBtn>
    </div>
  </div>
</template>

<script>
import BigBtn from '../common/BigBtn'
import Top from '../common/Top'
import editorBtn from '../common/editorBtn'
import SmallBtn from '../common/SmallBtn'
import SmallBtnNo from '../common/SmallBtnNo'
import i_editor from './../../assets/common/editor_@2x.png'
import i_next from './../../assets/common/next_.png'
import server from '../../server/myServer'
import { MessageBox } from 'mint-ui'
export default {
  name: 'PerCenter',
  data () {
    return {
      showLeft: true,
      flag: true,
      btnName:'退出',
      HRight:'',
      HTitle: '个人信息',
      toUrl: '',
      i_editor_u: i_editor,
      i_next_u: i_next,
      editor: false,
      btnName1: '保存',
      btnName2: '取消',
      newName: '',
      newFood: '',
      uPhone: '',
      farm: true,
      food: '',
      farmName: '',
      userType: '个人',
    }
  },
  components: {
    Top, editorBtn, SmallBtn, SmallBtnNo,BigBtn
  },
  methods: {
    editorName() {
      this.editor = true
    },
    strLen(str) {
      var len = 0;
      for (var i=0; i<str.length; i++) { 
       var c = str.charCodeAt(i); 
       if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
         len++; 
       } 
       else { 
        len+=2; 
       } 
      } 
      return len;
    },
    sure() {
      
      let vm = this
      if(vm.strLen(vm.newName) > 30 && vm.strLen(vm.newFood) < 30){
        vm.$msg('名称不能超过15个字')
      }else if(vm.newName === ''  && vm.newFood !== ''){
        vm.$msg('名称不能为空')
      }else if (vm.newFood === '' && vm.newName !== '') {
        vm.$msg('饲料不能为空')
      }else if(vm.strLen(vm.newFood) > 30){
        vm.$msg('饲料名称不能超过12个字')
      }else{
        server()._pulFarmerInfo({
          id: JSON.parse(localStorage.getItem('userInfo')).userId,
          name: vm.newName,
          food: vm.newFood
        }).then(function(res){
          console.log(vm.strLen(vm.newName))
          if(res.data.code === '0'){
            vm.editor = false
            vm.$msg('修改成功')
            vm.farm = true
            let newLcoal = JSON.parse(localStorage.getItem('userInfo'))
            newLcoal.name = vm.newName
            localStorage.setItem('userInfo', JSON.stringify(newLcoal))
            vm._getFarmerInfo()
          }else {
            vm.$msg(res.data.message)
          }
        })
      }
      
    },
    cancel() {
      this.editor = false
      this.newFood = this.food
      this.newName = this.farmName
    },
    goPhone() {
      this.$router.push('/Main/PulPhone')
    },
    goPulPs() {
      this.$router.push('/PulPs')
    },
    goAddress() {
      this.$router.push('/Main/AddressManer')
    },
    goFindPs() {
      this.$router.push('/FindPs')
    },
    _getFarmerInfo() {
      let vm = this
      this.toUrl = localStorage.getItem('router')
      this.newName = JSON.parse(localStorage.getItem('userInfo')).name
      this.farmName = JSON.parse(localStorage.getItem('userInfo')).name
      this.uPhone = JSON.parse(localStorage.getItem('userInfo')).tel
      server()._getFarmerInfo({id: JSON.parse(localStorage.getItem('userInfo')).userId}).then(function(res){
        if(res.data.code === '0'){
          vm.farm = true
          vm.food = res.data.data.food
          vm.newFood = res.data.data.food
          vm.userType = res.data.data.farmsType
        }
      })
    },
    _pulFarmerInfo() {

    },
    logOut() {
      let vm = this
      // vm.$router.push('192.168.5.113:8020/zmt_admin/index.html')
      // window.location.href = '192.168.5.113:8020/zmt_admin/index.html'
      MessageBox.confirm('您确定退出当前登录账号吗?').then(action => {
        vm.flag = false
        this.$msg('已退出,请重新登录')
        localStorage.removeItem('userInfo')
        setTimeout(function(){
          vm.$router.push('/Login')
        },2000)
      })
    }
  },
  created() {
    this._getFarmerInfo()
    this.userType = JSON.parse(localStorage.getItem('userInfo')).typeName
  },
  computed: {
    _uPhone: function(){
      let a = []
      this.uPhone.split('')
      for(var i in this.uPhone){
        a.push(this.uPhone[i])
      }

      for(var i in a){
        if(i == 3 || i == 4 || i == 5 || i == 6){
          a.splice(i,1,"*")
        }
      }
      let b = a.join('')
      return b
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .per-box{
    position: absolute;
    background-color: #fff;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    .mtfooter{
      display: flex;
      // position: fixed;
      // bottom: .42rem;
      // left: .5rem;
      margin-top: 1.6rem;
      .btn-box-smallbtn{
        width: 3rem;
      }
    }
    .per-form{
      padding: 0 .36rem;
      background-color: #fff;
      .domy{
        box-sizing: border-box;
        padding-top: 0.22rem;
      }
      .myLi{
        height: 1.2rem;
        line-height: 1.2rem;
        .leftTitle{
          font-size: .32rem;
          float: left;
          font-weight: bold;
          letter-spacing: 3px;
        }
        .rightTitle{
          float: right;
          margin-right: .2rem;
          font-size: .26rem;
          letter-spacing: 1px;
        }
        .editorIMG{
          height: .46rem;
          width: .68rem;
          float: right;
          margin-top: .32rem;
        }
        .input_box{
          border: 1px solid #e3e3e3;
          height: .68rem;
          margin-top: 0;
          position: absolute;
          top: 1.1rem;
          left: .8rem;
          input{
            height: .4rem;
          }
        }
      }
    }
    .sth-form{
      // height: 10.5rem;
      // margin-top: .2rem;
      // position: absolute;
      // left: 0;
      // right: 0;
      // bottom: 0;
      // top: 3.3rem;
      .sth-myLi{
        border-bottom: 1px solid #e3e3e3;
        .sth-leftTitle{
          font-weight: 400;
          letter-spacing: 1px;
        }
        .nextIMG{
          width: .12rem;
          height: .2rem;
          margin-top: .5rem
        }
      }
    }
  }
</style>
