<template>
  <div class="login-box">
    <Top :HRight='HRight'  :HTitle='HTitle'></Top>
    <div class="input_box">
      <span class="input_left">原始密码</span>
      <input class="input" type="text" placeholder="请输入原始密码">
    </div>
    <div class="input_box">
      <span class="input_left">新密码</span>
      <input class="input" type="password" placeholder="请输入新密码">
    </div>
    <div class="input_box">
      <span class="input_left">确认密码</span>
      <input class="input" type="password" placeholder="请确认密码">
    </div>
    <BigBtn :btnName='btnName'></BigBtn>
  </div>
</template>

<script>
import BigBtn from './../common/BigBtn'
import Top from './../common/Top'
export default {
  name: 'PulPs',
  data () {
    return {
      HRight: '',
      HTitle: '修改密码',
      btnName: '保存',
    }
  },
  methods: {

  },
  components: {
    BigBtn, Top
  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    .input_box{
      width: 6.8rem;
      border: 1px solid #e3e3e3;
      .input_left{
        width: 1.2rem;
      }
    }
    .btn-box{
      width: 6.8rem;
    }
  }
</style>
