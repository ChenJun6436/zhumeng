<template>
  <div class="btn-box-smallbtn">
    <a @click='Click'  class="samll-btn" href="javaScript:;" >{{btnName}}</a>
  </div>
</template>

<script>


export default {
  name: 'SmallBtnNo',
  data () {
    return {

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
      border: 1px solid #e3e3e3;
      display: block;
      width: 100%;
      height: .7rem;
      border-radius: .88rem;
      background-color: #ffffff;
      font-size: .3rem;
      line-height: .7rem;
      color: #AFB7BE;
      outline: none;
      box-sizing: border-box;
    }
  }
  
</style>
