<template>
  <div class="btn-box-smallbtn">
    <a @click='Click' :style='btnStyle' class="samll-btn" href="javaScript:;" >{{btnName}}</a>
  </div>
</template>

<script>

import i_big_btn from './../../assets/common/baocunanniu@2x.png'
export default {
  name: 'SmallBtn',
  data () {
    return {
      btnStyle: {
        backgroundImage: "url(" + i_big_btn + ")",
        backgroundRepeat: "repeat-x",
        backgroundSize: "5rem .9rem",
        backgroundPositionX: "-0.6rem",
      }
    }
  },
  props:[
    'btnName'
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
<style scoped lang='less'>
  .btn-box-smallbtn{
    margin: 0 auto;
    width: 1.5rem;
    .samll-btn{
      display: block;
      width: 100%;
      height: .7rem;
      border-radius: .88rem;
      background-color: #ffffff;
      margin-left: .05rem;
      // margin-top: .54rem;
      font-size: .3rem;
      border: none;
      line-height: .7rem;
      color: #ffffff;
      outline: none;
    }
  }
  
</style>
