<template>
  <div class="myhhh">
    <mt-header :title="HTitle">
      <router-link :to="toUrl" slot="left" v-if='!showLeft'>
        <img class="header-left" :src="i_back_u" alt="">
      </router-link>
      <mt-button v-if='HRight' slot="right" @click='Click'>{{HRight}}</mt-button>
    </mt-header>
  </div>
  
</template>

<script>

import i_back from './../../assets/common/back@2x.png'
export default {
  name: 'Top',
  data () {
    return {
      i_back_u: i_back,
    }
  },
  props:[
    'HTitle','HRight','toUrl','showLeft'
  ],
  methods: {
    Click() {
      this.$emit('Click')
    }
  },
  created() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang='less'>
.myhhh{
  .mint-header {
    background-color: #ffffff;
    border-bottom: 1px solid #e3e3e3;
    color: #444444;
    font-size: .34rem;
    height: .88rem;
    .header-left{
      height: .3rem;
      width: .18rem;
      margin-left: .1rem; 
    }
    .mint-header-button{
      // line-height: .88rem;
    }
    .mint-header-title{
      font-weight: bold;
    }
  }
}
  
  
</style>
