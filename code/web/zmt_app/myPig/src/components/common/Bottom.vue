<!-- chenjunlml@163.com   -->
<template>
  <div class="jjj">
    <mt-tabbar class='footer' v-model="selected" fixed v-if='showf'>  
      <mt-tab-item @click.native='goIndex' id="index">  
        <img slot="icon" :src="_index_i" class="f_img">  
        <img :src="_index_f" class="f_font">  
      </mt-tab-item>  
      <mt-tab-item @click.native='goPig' id="pig">  
        <img slot="icon" :src="_pig_i" class="f_img">  
        <img :src="_pig_f" class="f_font">  
      </mt-tab-item>  
      <mt-tab-item @click.native='goMy' id="my">  
        <img slot="icon" :src="_my_i" class="f_img">  
        <img :src="_my_f" class="f_font">  
      </mt-tab-item>  
    </mt-tabbar> 
  </div>
  
</template>

<script>

import i_pig1 from './../../assets/index/1ic_pig.png'
import i_pig2 from './../../assets/index/2ic_pig.png'
import i_index1 from './../../assets/index/shouye1@2x.png'
import i_index2 from './../../assets/index/shouye2@2x.png'
import i_my1 from './../../assets/index/wode1@2x.png'
import i_my2 from './../../assets/index/wode2@2x.png'

import f_pig1 from './../../assets/index/1ic_mypig.png'
import f_pig2 from './../../assets/index/2ic_mypig.png'
import f_index1 from './../../assets/index/sy1@2x.png'
import f_index2 from './../../assets/index/sy2@2x.png'
import f_my1 from './../../assets/index/wd1@2x.png'
import f_my2 from './../../assets/index/wd2@2x.png'

export default {
  name: 'Bottom',
  data () {
    return {
      selected: 'pig',
      pig_i: i_pig1,
      index_i: i_index1,
      my_i: i_my1,
      pig_f: f_pig1,
      index_f: f_index1,
      my_f: f_my1,
    }
  },
  props:[
    'showf','nowIndex'
  ],
  methods: {
    goIndex() {
      this.index_i = i_index1
      this.index_f = f_index1
      this.pig_i = i_pig1
      this.pig_f = f_pig1
      this.my_i = i_my1
      this.my_f = f_my1
      this.$router.push('/Main/Index')
    },
    goPig() {
      this.index_i = i_index2
      this.index_f = f_index2
      this.pig_i = i_pig2
      this.pig_f = f_pig2
      this.my_i = i_my1
      this.my_f = f_my1
      this.$router.push('/Main/MyPig')
    },
    goMy() {
      this.index_i = i_index2
      this.index_f = f_index2
      this.pig_i = i_pig1
      this.pig_f = f_pig1
      this.my_i = i_my2
      this.my_f = f_my2
      this.$router.push('/Main/PerCenter')
    },
    nowActive(){
      if(this.$parent.nowIndex == 1){
        this.index_i = i_index1
        this.index_f = f_index1
        this.pig_i = i_pig1
        this.pig_f = f_pig1
        this.my_i = i_my1
        this.my_f = f_my1
      }
      if(this.$parent.nowIndex == 2){
        this.index_i = i_index2
        this.index_f = f_index2
        this.pig_i = i_pig2
        this.pig_f = f_pig2
        this.my_i = i_my1
        this.my_f = f_my1
      }
      if(this.$parent.nowIndex == 3){
        this.index_i = i_index2
        this.index_f = f_index2
        this.pig_i = i_pig1
        this.pig_f = f_pig1
        this.my_i = i_my2
        this.my_f = f_my2
      }
    }
  },
  created() {
   this.nowActive()
  },
  watch:{
    '$route':'nowActive'
  },
  computed: {
    _index_i: function() {
      return this.index_i
    },
    _index_f: function() {
      return this.index_f
    },
    _my_i: function() {
      return this.my_i
    },
    _my_f: function() {
      return this.my_f
    },    
    _pig_i: function() {
      return this.pig_i
    },
    _pig_f: function() {
      return this.pig_f
    },          
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang='less'>
.jjj{
  .mint-tab-item{
    background-color: #28282E
  }
  .mint-tabbar{
  height: 1rem;
  .mint-tab-item-icon{
    margin: 0 auto;
  }
  .f_img{
    width: .44rem;
    height: .4rem;
  }
  .f_font{
    height: .24rem;
  }
  .is-selected{
    background-color: #28282E
  }
}
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
      line-height: .88rem;
    }
  }
}

  
</style>
