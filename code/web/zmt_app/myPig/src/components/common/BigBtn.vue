<!-- chenjunlml@163.com   -->
<template>
  <div class="btn-box">
    <button  @click='Click' :style='btnStyle' class="big-btn" href="javaScript:;" :disabled='!flag'>{{btnName}}</button>
  </div>
</template>

<script>

import i_big_btn from './../../assets/common/baocunanniu@2x.png'
export default {
  name: 'BigBtn',
  data () {
    return {
      btnStyle: {
        backgroundImage: "url(" + i_big_btn + ")",
        backgroundRepeat: "repeat-x",
        backgroundSize: "8rem .9rem",
        backgroundPositionX: "-0.6rem",
      }
    }
  },
  props:[
    'btnName','btnClick','flag'
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
  .btn-box{
    margin: 0 auto;
    width: 5.8rem;
    .big-btn{
      display: block;
      width: 100%;
      height: .88rem;
      border-radius: .88rem;
      background-color: #ffffff;
      margin: 0 auto;
      margin-top: .54rem;
      font-size: .3rem;
      border: none;
      line-height: .88rem;
      color: #ffffff;
      outline: none;
    }
  }
  
</style>
