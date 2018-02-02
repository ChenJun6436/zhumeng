<template>
<div class="Main" :style="MainStyle">
  <Top :showUser='showUser'></Top>
  <router-view style='padding: .38rem'/>
</div>  
</template>
<script>
//引用头部组件
  import Top from './common/Header'
  import myServer from '../server/myServer'
  import IMG_bj from '../assets/bj.png'
  export default {
    name: 'Main',
    data () {
      return {
        IMG_bj_u: IMG_bj,
        MainStyle: {
          backgroundImage: "url(" + IMG_bj + ")",
          // backgroundRepeat: "repeat-x",
          backgroundSize: "cover",
          // backgroundPositionX: "-0.6rem",
        },
        showUser: true,
      }
    },
    components: {
      Top
    },
    watch:{
      // '$route':'isTab'
    },
    methods: {

    },
    beforeCreate () {

    },
    created () {
      let vm = this
      var a = true
      setInterval(function(){
        if(a){
          vm.$router.push('/Main/DataAnalysis')
          a = false
        }else{
          vm.$router.push('/Main/Discount')
          a = true
        }
      },10000)
    }
  }
</script>
<style scoped>
.Main{
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  overflow: hidden;
}
  .main-box{
    position: relative;
    background: #f4f4f4;
  }
  .aside{
    height: 100%;
    background: rgb(84, 92, 100);
    width: 180px;
    position: absolute;
  }
  .main{
    height: 100%;
    background-color: #f4f4f4;
    /*padding: 10px;*/
    margin: 0 auto;
    width: 100%;
    padding-right: 185px;
    box-sizing: border-box;
  }
  .main-content{
    width: 100%;
    height: 100%;
    background-color: #fff;
    margin-left: 180px;
    text-align: left;
    padding: 10px;
    box-sizing: border-box;
  }
  .main-content div{
    /*display: inline-block;*/
    text-align: left;
  }
</style>



// WEBPACK FOOTER //
// src/components/Main.vue