<template>
  <div class="smallbox" :style='smallBoxStyle'>
    <p class="title">本月屠宰TOP榜</p>
    <p class="title-two">屠宰总数(头):{{topList.slaughterNum}}</p>
    <ul class="toplist">
      <li v-for='(i,index) in topList.list'>
        <img class="Timg" :src="dianColor[index]" alt="">
        <span class="Tname">{{index + 1}}、{{i.slaughterName}}:{{i.pigNum}}头</span>
        <span :style="{color: sizeColor[index]}">({{(i.pigNum/topList.slaughterNum).toFixed(3)+'%'}})</span>
      </li>
    </ul>
  </div>
</template>
<script>
  import myServices from '../../server/myServer'

  import kuang from '../../assets/kuang4.png'
  import hong_u from '../../assets/hongdian.png'
  import cheng_u from '../../assets/huangdian.png'
  import lv_u from '../../assets/lvdian.png'
  import lan_u from '../../assets/landian.png'
  import zi_u from '../../assets/zidian.png'
  export default {
    name: 'KillTopFive',
    data () {
      return {
        smallBoxStyle : {
          backgroundImage: "url(" + kuang + ")",
          backgroundSize:' 5.36rem 4.20rem',
        },
        dianColor:[
          hong_u,cheng_u,lv_u,lan_u,zi_u
        ],
        sizeColor:[
          '#d24836','#ee9e2d','#199f7e','#116fa1','#6a3bd4',
        ],
        pigTop: [],
        allPig: 0,
      }
    },
    props: [
      'topList'
    ],
    mounted(){
      // this._getPigTop5()
    },
    methods: {
      
    },
    created () {
      
    }
  }
</script>
<style scoped>
  .smallbox{
    width: 5.36rem;
    height: 4.20rem;
    box-sizing: border-box;
    padding: .30rem .60rem;
    text-align: left;
    background-repeat: no-repeat;
  }
  .title{
    font-size: .21rem;
    color: #64faf9;
  }
  .title-two{
    color: #fff;
    font-size: .21rem;
    margin-top: .26rem; 
    font-weight: bold;
  }
  .toplist{
    font-size: .21rem;
  }
  .toplist li{
    margin-top: .3rem; 
  }
  .Timg{
    width: .13rem;
    height:.13rem;
    display: inline-block;
    margin-top:.06rem; 
  }
  .Tname{
    font-size: .20rem;
    color: #fff;
    display: inline-block;
    min-width: 1.80rem;
  }


  #bingBOx{
    width: 3.90rem;
    height: 3.80rem;
  }
  .content{
    font-size: .32rem;
    color: #64faf9;
    font-weight: 600;
    letter-spacing:.05rem;
    margin-top: .18rem;
  }
  .dataShow{
    font-size: .18rem;
    color: #fff;
    margin-top: .15rem;
  }
  .dataShow-img{
    margin-top:.03rem; 
  }
</style>



// WEBPACK FOOTER //
// src/components/common/Header.vue