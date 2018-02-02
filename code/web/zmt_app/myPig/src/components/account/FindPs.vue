<template>
  <div class="login-box">
    <Top :HRight='HRight' :HTitle='HTitle' :toUrl='toUrl'></Top>
    <div class="login-form">
      <div class="input_box">
        <span class="input_left">账号</span>
        <input class="input" type="text" placeholder="输入手机号" v-model='findPs_tel' :disabled='haveLogin'>
        <button @click='getCode' class="input_right" :disabled="!show">
          <span v-show="show">获取验证码</span>
          <span v-show="!show" class="count">{{count}} 秒后重新获取</span>
        </button>
        <!--<div>获取验证码</div>-->
        <!--<div @click='getCode' class="input_right" :style='rightStyle'>
          
        </div>-->
      </div>
      <div class="input_box">
        <span class="input_left">验证码</span>
        <input class="input" type="text" placeholder="请输入验证码" v-model='findPs_code'>
      </div>
      <div class="input_box">
        <span class="input_left">新密码</span>
        <input class="input" type="password" placeholder="请输入新密码" maxlength="15" v-model='findPs_newPass'>
      </div>
      <div class="input_box">
        <span class="input_left">确认密码</span>
        <input class="input" type="password" placeholder="请确认密码" maxlength="15" v-model='findPs_confirmPass'>
      </div>
      <BigBtn @Click='register' :btnName='btnName' style="width: 6.8rem;" :flag='flag'></BigBtn>
    </div>
  </div>
</template>

<script>
  import crypto from 'crypto' //vue md5 加密 
  import BigBtn from '../common/BigBtn'
  import Top from '../common/Top'
  import server from '../../server/myServer'
  export default {
    name: 'FindPs',
    data() {
      return {
        flag: true,
        HRight: '',
        HTitle: '找回密码',
        toUrl: '',
        btnName: '确定',
        findPs_tel: '',
        findPs_code: '',
        findPs_confirmPass: '',
        findPs_newPass: '',
        show: true,
        count: '',
        timer: null,
        haveLogin: false
      }
    },
    methods: {

      //密码加密处理
      getmd5(pass) {
        var md5String;
        var md5 = crypto.createHash("md5");
        md5.update(pass);
        var md5String = md5.digest('hex');
        return md5String;
      },
      //确定
      register() {
        var _this = this;
        
        if(!this.findPs_tel) {
          _this.$msg('手机号不能为空！');
          return false;
        }else if(!this.findPs_code){
          _this.$msg('验证码不能为空！');
          return false;
        }else if(!this.findPs_newPass){
          _this.$msg('密码不能为空！');
          return false;
        }else  if(this.findPs_newPass!=this.findPs_confirmPass){
          _this.$msg('密码与确认密码不一致！');
          return false;
        }else{
          _this.flag = false
          let findPsData={
            tel:this.findPs_tel,
            password:this.getmd5(this.findPs_newPass),
            checkCode:this.findPs_code
          }
          if(_this.haveLogin){
            findPsData.tel = JSON.parse(localStorage.getItem('userInfo')).tel
          }
          server()._resetPassword(findPsData).then(function(res) {
            if(res.data.code === '0') {
              _this.$msg('修改成功！')
                localStorage.setItem('userInfo', JSON.stringify(res.data.data))
               setTimeout(function(){
                  _this.$router.push({ path: '/Login' })
                  localStorage.removeItem('userInfo')
               },1000)
            } else {
              _this.flag = true
              _this.$msg(res.data.message)
            }
          })
        }
      },
      //获取验证码
      getCode() {
        var _this = this;
        var fig = true;
        if(!this.findPs_tel) {
          _this.$msg('手机号不能为空！');
          return false;
        } else if(!(/^1[34578]\d{9}$/.test(this.findPs_tel))) {
          _this.$msg('请输入正确的手机号！');
          return false;
        } else {
          let codeData = {
            tel: this.findPs_tel
          };
          server()._getCode(codeData).then(function(res) {
            if(res.data.code === '0') {
              fig = true
            } else {
              fig = false;
              _this.$msg(res.data.message)
            }
          });
        }
        if(fig) {
          let TIME_COUNT = 30;
          if(!this.timer) {
            this.count = TIME_COUNT;
            this.show = false;
            this.timer = setInterval(() => {
              if(this.count > 0 && this.count <= TIME_COUNT) {
                this.count--;
              } else {
                this.show = true;
                clearInterval(this.timer);
                this.timer = null;
              }
            }, 1000)
          }
        }
      },
      _uPhone(a){
        let arr = []
        a.split('')
        for(var i in a){
          arr.push(a[i])
        }

        for(var i in arr){
          if(i == 3 || i == 4 || i == 5 || i == 6){
            arr.splice(i,1,"*")
          }
        }
        let b = arr.join('')
        return b
      }
    },
    components: {
      BigBtn,
      Top
    },
    created() {
      this.toUrl = localStorage.getItem('router')
      if( JSON.parse(localStorage.getItem('userInfo')) ){
        this.haveLogin = true
        this.findPs_tel = this._uPhone(JSON.parse(localStorage.getItem('userInfo')).tel) 
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box {
    
    .login-form {
      .input_box {
        border: 1px solid #dcdcdc;
        width: 6.8rem
      }
      .input_left {
        width: 1.2rem;
      }
      .input_right {
        float: right;
        width: 2.2rem;
        height: .9rem;
        margin-top: -1px;
        border-top-right-radius: .88rem;
        border-bottom-right-radius: .88rem;
        color: #FFFFFF;
        text-align: center;
        line-height: .9rem;
        outline: none;
        display: block;
        border: none;
        background: -webkit-linear-gradient(left, #75DA94, #53C7EE);
      }
      .input {
        width: 2.5rem;
      }
    }
  }
</style>