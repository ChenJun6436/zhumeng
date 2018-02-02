<template>
  <div class="login-box">
    <div class="login-form">
      资料录入
    </div>
  </div>
</template>

<script>
export default {
  name: 'DataInput',
  data () {
    return {
      
    }
  },
  methods: {

  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    height: 100px;
    background-color: red;
    .login-form{
      height:50px;
      background-color: blue;
    }
  }
</style>
