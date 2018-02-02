<template>
  <div class="login-box">
    <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl' ></Top>
    <div class="login-form">
      <div class="input_box">
        <span class="input_left">手机号</span>
        <input v-model='phone' class="input" type="text" name="" placeholder="输入手机号">
        <div @click='getCode' class="input_right" :style='rightStyle'>
          <span v-show='!canClickCode'><span>{{_num}}s</span>后重新获取</span> 
        </div>
      </div>
      <div class="tip" v-show='showTip'>
        <img :src="i_sure_u" alt=""><span>短信验证码已发送，请填写验证码</span>
        <p><span>接收短信大约需要</span><span class="daoTip">{{_num}}s</span></p>
      </div>
      <div class="input_box">
        <span class="input_left">验证码</span>
        <input v-model='code' class="input" type="text" name="" placeholder="请输入验证码">
      </div>
      <BigBtn @Click='Save' :btnName='btnName' style="width: 6.8rem;" :flag='flag'></BigBtn>
    </div>
  </div>
</template>

<script>
import BigBtn from '../common/BigBtn'
import Top from '../common/Top'
import i_yan from './../../assets/common/yanzhengma@2x.png'
import i_sure from './../../assets/common/sure_.png'
import { Toast } from 'mint-ui'
import server from '../../server/myServer'
export default {
  name: 'BindPhone',
  data () {
    return {
      flag: true,
      HRight:'',
      HTitle:'绑定手机',
      btnName: '确定',
      toUrl: "/Main/PerCenter",
      i_yan_u: i_yan,
      i_sure_u: i_sure,
      rightStyle: {
        backgroundImage: "url(" + i_yan + ")",
        backgroundColor : '#c1c1c1',
        backgroundRepeat: "no-repeat",
        backgroundSize: "2.2rem .9rem",
      },
      canClickCode: true,
      phone: '',
      code: '',
      num: 30,
      showTip: false,
      canSvae: true,
      haveLogin: false
    }
  },
  methods: {
    register() {

    },
    getCode() {
      let _this = this
      _this.num = 30
      let codeData = {
        tel: this.phone
      }
      if(_this.canClickCode){
        if(codeData.tel == '') {
          _this.$msg('手机号不能为空！')
          return false
        } else if(!(/^1[34578]\d{9}$/.test(codeData.tel))) {
          _this.$msg('请输入正确的手机号！')
          return false
        } else {

          server()._getCode(codeData).then(function(res) {
            if(res.data.code === '0') {
              _this.showTip = true
              let i = setInterval(function(){
                _this.num -- 
                if(_this.num <= 0){
                  clearInterval(i)
                  _this.rightStyle= {
                    backgroundImage: "url(" + i_yan + ")",
                    backgroundColor : '#c1c1c1',
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "2.2rem .9rem",
                  }
                  _this.canClickCode = true
                  _this.showTip = false
                }
              },1000)
              _this.canClickCode = false
              _this.rightStyle = {
                backgroundColor : '#c1c1c1',
                backgroundRepeat: "no-repeat",
                backgroundSize: "2.2rem .9rem",
              }
            } else {
              _this.$msg(res.data.message)
            }
          })
        }
      }else {
        
      }
    },
    Save() {
      let _this = this
      let newLocl = JSON.parse(localStorage.getItem('userInfo'))
      if(_this.canSvae){
        if(_this.phone == ''){
          _this.$msg('手机号不能为空！')
        }else {
          if(_this.code){
            if(/^\d{6}$/.test(this.code)){
                _this.canSvae = false
                let saveData = {
                  account: newLocl.loginName,
                  tel: _this.phone,
                  checkCode: _this.code
                }
                server()._resetTel(saveData).then(function(res){
                  if(res.data.code === '0'){
                    _this.$msg('修改成功,请重新登录','middle')
                    localStorage.removeItem('userInfo')
                    setTimeout(function(){
                      _this.$router.push('/Login')
                    },1500)
                  }else {
                    _this.canSvae = true
                    _this.$msg(res.data.message)
                  }
                })
            }else {
              _this.$msg('请输入正确的验证码')
            }
          }else {
            _this.$msg('验证码不能为空')
          }
        }
      }else{

      }
    },
  },
  components: {
    Top , BigBtn
  },
  created() {

  },
  computed: {
    _num : function(){
      return this.num
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    background-color: #fff;
    position: absolute;
    background-color: #fff;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    .login-form{
      .input_box{
        border: 1px solid #dcdcdc;
        width: 6.8rem
      }
      .input_right{
        float: right;
        width: 2.2rem;
        height: .9rem;
        line-height: .9rem;
        color: #fff;
        margin-top: -1px;
        border-top-right-radius: .45rem;
        border-bottom-right-radius: .45rem;
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
