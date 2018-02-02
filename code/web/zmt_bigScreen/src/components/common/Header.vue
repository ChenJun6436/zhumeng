<template>
  <div class="headers">
      <div class="imgMan-head">
        <div class="imgM-h-left">
          <img class="imgM-left-logo":src="IMG_logo_u" alt="" v-if='showUser'>
        </div>
        <div style='position: absolute;top: 0;left: 50%;margin-left: -2.5rem;'>
          <p class="title">威远县农业局生猪监管数据平台</p>
        </div>
        <div class="imgM-h-right">
            <div class="fl" style="margin-left: 5rem;">
                <span>{{nowDate}}</span>&nbsp;&nbsp;
                <span>{{nowTime}}</span>&nbsp;&nbsp;
                <span>星期{{week}}</span>
            </div>
        </div>
    </div>
  </div>
</template>
<script>
  import myServer from '../../server/myServer'

  import IMG_logo from '../../assets/logo.png'
  export default {
    name: 'Top',
    data () {
      return {
        IMG_logo_u : IMG_logo,
        nowDate:'',
        nowTime:'',
        week:'',
      }
    },
    props: [
      'showUser'
    ],
    methods: {
      getTime(){
  
        let vm = this
        setInterval(function(){
          let WEEK = new Date().getDay()
          if(WEEK === 0){
            WEEK = '日'
          }
          if(WEEK === 1){
            WEEK = '一'
          }
          if(WEEK === 2){
            WEEK = '二'
          }
          if(WEEK === 3){
            WEEK = '三'
          }
          if(WEEK === 4){
            WEEK = '四'
          }
          if(WEEK === 5){
            WEEK = '五'
          }
          if(WEEK === 6){
            WEEK = '六'
          }
          vm.nowDate = new Date().toLocaleDateString()
          vm.nowTime = new Date().toLocaleTimeString()
          vm.week = WEEK
        },1000)
        
      }
    },
    created () {
      this.getTime()
    }
  }
</script>
<style scoped>
  .headers{
    width: 100%;
    height: 1rem;
    /*background-color: #545c64;*/
    color: #fff;
    border-bottom: .02rem solid #215660;
  }
  .imgM-h-left{
    float: left;
    width: 50%;
    text-align: left;
  }
  .imgM-left-logo{
      width: 2rem;
      height: .7rem;
      margin-left: .6rem;
      float: left;
      margin-top: .15rem;
  }
  .title{
    font-size: .4rem;
    line-height: 1rem;
    font-weight: 600;
    color: #fff;
  }
  .logo{
    width: 2rem;
    height: .7rem;
  }
  .imgM-h-right{
      float: right;
      /*line-height: 80rem;*/
      margin-right: .62rem;
      margin-top: .54rem;
      font-size: .18rem;
  }
  .imgM-h-right a{
    color: #f0f0f0;
  }
  .fl{
    float: left;
  }
</style>



// WEBPACK FOOTER //
// src/components/common/Header.vue