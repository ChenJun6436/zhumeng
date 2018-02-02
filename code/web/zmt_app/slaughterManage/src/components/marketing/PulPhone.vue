<template>
  <div class="login-box">
    <Top :HRight='HRight' :HTitle='HTitle' @Click='Save'></Top>
    <div class="login-form">
      <div class="input_box" style='border: none'>
        <span class="input_left">手机号</span>
        <input class="input" type="text" name="" placeholder="输入手机号" disabled>
        <div @click='getCode' class="input_right" :style='rightStyle'>
          <span v-show='!canClickCode'><span>21s</span>后重新获取</span> 
        </div>
      </div>
      <div class="tip">
        <img :src="i_sure_u" alt=""><span>短信验证码已发送，请填写验证码</span>
        <p><span>接收短信大约需要</span><span class="daoTip">48s</span></p>
      </div>
      <div class="input_box">
        <span class="input_left">验证码</span>
        <input class="input" type="text" name="" placeholder="请输入验证码">
      </div>
      <!-- <BigBtn @Click='register' :btnName='btnName' style="width: 6.8rem;"></BigBtn> -->
    </div>
  </div>
</template>

<script>
// import BigBtn from '../common/BigBtn'
import Top from '../common/Top'
import i_yan from './../../assets/common/yanzhengma@2x.png'
import i_sure from './../../assets/common/sure_.png'

export default {
  name: 'PulPhone',
  data () {
    return {
      HRight:'确定',
      HTitle:'绑定手机',
      btnName: '确定',
      i_yan_u: i_yan,
      i_sure_u: i_sure,
      rightStyle: {
        backgroundImage: "url(" + i_yan + ")",
        backgroundColor : '#c1c1c1',
        backgroundRepeat: "no-repeat",
        backgroundSize: "2.2rem .9rem",
        backgroundPosition : "0rem -.04rem"
      },
      canClickCode: true,
    }
  },
  methods: {
    register() {

    },
    getCode() {
      let _this = this
      if(_this.canClickCode){
        console.log(_this.canClickCode)
        _this.canClickCode = false
        _this.rightStyle = {
          backgroundColor : '#c1c1c1',
          backgroundRepeat: "no-repeat",
          backgroundSize: "2.2rem .9rem",
          backgroundPosition: "0rem -.04rem",
        }
      }else {
        console.log(2)
      }
    },
    Save() {
      let _this = this
      Toast({
        message: '修改成功',
        position: 'middle',
        duration: 2000
      })
      setTimeout(function(){
        _this.$router.push('/Main/PerCenter')
      },2000)
      
    }
  },
  components: {
    // BigBtn,
    Top
  },
  created() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    background-color: #fff;
    .login-form{
      .input_box{
        border: 1px solid #dcdcdc;
        width: 6.8rem
      }
      .input_right{
        float: right;
        width: 2.2rem;
        height: .8rem;
        line-height: .8rem;
        color: #fff;
        margin-top: -1px;
        border-radius: .9rem;
      }
      .input{
        width: 2.5rem;
      }
      .tip{
        margin-top: .46rem;
        color: #95adaa;
        .daoTip{
          color: #1FB5AD;
          font-weight: bold;
        }
      }
    }
  }
</style>
