<template>
  <div class="smallbox" :style='smallBoxStyle'>
    <p class="title">{{title}}（头）</p>
    <p class="content">{{content}}</p>
    <p class="dataShow">较昨日: 
      <img v-if='!up' class="dataShow-img" :src="abate_u" alt=""> 
      <img v-if='up' class="dataShow-img" :src="increase_u" alt="">
      {{dataShow}}
    </p>
  </div>
</template>
<script>
  import myServer from '../../server/myServer'

  import kuang from '../../assets/kuang1.png'
  import abate from '../../assets/hongjiantou.png'
  import increase from '../../assets/lvjiantou.png'
  export default {
    name: 'SmallBox',
    data () {
      return {
        abate_u : abate,
        increase_u : increase,
        smallBoxStyle : {
          backgroundImage: "url(" + kuang + ")",
          // backgroundRepeat: "repeat-x",
          backgroundSize: "2.95rem 1.82rem",
          // backgroundPositionX: "-0.06rem",
        },
      }
    },
    props: [
      'title','content','up','dataShow'
    ],
    methods: {
      
    },
    created () {

    }
  }
</script>
<style scoped>
  .smallbox{
    width: 2.95rem;
    height: 1.82rem;
    box-sizing: border-box;
    padding:.2rem .4rem;
    text-align: left;
  }
  .title{
    font-size: .21rem;
    color: #64faf9;
  }
  .content{
    font-size: .36rem;
    color: #64faf9;
    font-weight: 600;
    letter-spacing: .05rem;
    margin-top: .2rem;
  }
  .dataShow{
    font-size:.22rem;
    color: #fff;
    margin-top: .2rem;
  }
  .dataShow-img{
    margin-top: .06rem; 
  }
</style>



// WEBPACK FOOTER //
// src/components/common/Header.vue