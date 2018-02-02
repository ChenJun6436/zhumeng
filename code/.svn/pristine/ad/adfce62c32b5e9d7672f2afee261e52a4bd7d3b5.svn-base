<template>
  <div class="login-box">
    <Top :HRight='HRight' :HTitle='HTitle'></Top>
    <div class="login-form">
      <div class="input_box">
        <span class="input_left">手机号</span>
        <input class="input" type="text" name="" placeholder="输入手机号">
        <div @click='getCode' class="input_right" :style='rightStyle'>
          
        </div>
      </div>
      <div class="input_box">
        <span class="input_left">验证码</span>
        <input class="input" type="text" name="" placeholder="请输入验证码">
      </div>
      <BigBtn @Click='register' :btnName='btnName' style="width: 6.8rem;"></BigBtn>
    </div>
  </div>
</template>

<script>
import BigBtn from '../common/BigBtn'
import Top from '../common/Top'
import i_yan from './../../assets/common/yanzhengma@2x.png'

export default {
  name: 'Register',
  data () {
    return {
      HRight:'',
      HTitle:'注册',
      btnName: '确定',
      i_yan_u: i_yan,
      rightStyle: {
        backgroundImage: "url(" + i_yan + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "2.2rem .9rem",
      }
    }
  },
  methods: {
    register() {

    },
    getCode() {

    }
  },
  components: {
    BigBtn,Top
  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    .login-form{
      .input_box{
        border: 1px solid #dcdcdc;
        width: 6.8rem
      }
      .input_right{
        float: right;
        width: 2.2rem;
        height: .9rem;
        margin-top: -1px;
      }
      .input{
        width: 2.5rem;
      }
    }
  }
</style>
