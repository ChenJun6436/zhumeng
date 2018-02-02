<template>
  <div class="login" :style='LoginStyle' @keyup.enter="submitForm">
    <Top :showUser='showUser'></Top>
    <div class="login-form-box">
      <div style="margin-top: .66rem;">
        <img style="width: 4.24rem;height:P1.5rem" :src="img_logo" alt="">
      </div>
      <p style="font-size: .48rem;font-weight: bold;color: #64FAF9;margin-top: .66rem;">欢迎登录</p>
      <div class="lon-f-box">
        <form>
          <div class="inp" :style='inpStyle'>
            <img :src="img_zh" alt="">
            <input v-model='loginPostData.account' maxlength="30" type="text" name="" >
          </div>
          <div class="inp" :style='inpStyle'>
            <img :src="img_mm" alt="">
            <input v-model='loginPostData.password'  maxlength="12" type="password" name="">
          </div>
          <p v-if='showE' style="font-size: .2rem;margin-top: .1rem;color:red;">{{msg}}</p>
          <a class="login-btn" :style='loginBtnStyle' href="javaScript:;" @click='submitForm'>登录</a>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import myServices from '../../server/myServer'
import Top from '../common/Header'
import Map from '../common/BaiDuMap'
import IMG_bj from '../../assets/bj.png'
import IMG_kuang from '../../assets/denglukuang.png'
import IMG_logo from '../../assets/denglulogo.png'
import IMG_kuang1 from '../../assets/kuang.png'
import IMG_zh from '../../assets/zhanghu.png'
import IMG_mm from '../../assets/mima.png'
  export default {
    name: 'Login',
    data () {
      return {
        LoginStyle: {
          backgroundImage: "url(" + IMG_bj + ")",
          backgroundSize: "cover",
        },
        loginBtnStyle: {
          backgroundImage: "url(" + IMG_kuang1 + ")",
          backgroundSize: "5rem .7rem",
        },
        loginPostData: {
          account: '',
          password: '',
        },
        img_mm: IMG_mm,
        img_zh: IMG_zh,
        img_logo: IMG_logo,
        inpStyle: {
          backgroundImage: "url(" + IMG_kuang + ")",
          backgroundSize: "5rem .7rem",
        },
        msg:'',
        showE: false,
        showUser: false
      }
    },
    components: {
      Top, Map
    },
    mounted(){
       
    },
    methods: {
      submitForm () {
        let _this = this
        var str   =   _this.loginPostData.account.replace(/\s+/g,"")
        let postD = {
          account: str,
          password: _this.loginPostData.password
        }
        var el = document.documentElement
        var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen
        if (typeof rfs != "undefined" && rfs) { 
          rfs.call(el)
        } else if (typeof window.ActiveXObject != "undefined") { 
          // for Internet Explorer 
        var wscript = new ActiveXObject("<a href='https://www.baidu.com/s?wd=WScript.Shell&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1Y4njnduhuhPyDvnW9Bn1I-0ZwV5Hcvrjm3rH6sPfKWUMw85HfYnjn4nH6sgvPsT6KdThsqpZwYTjCEQLGCpyw9Uz4Bmy-bIi4WUvYETgN-TLwGUv3En1mzP1R1njD1rH6dPHRdnjDz' target='_blank' class='baidu-highlight'>WScript.Shell</a>"); 
          if (wscript != null) { 
            wscript.SendKeys("{F11}"); 
          } 
        }
        if(!_this.showE){
           myServices()._login(postD).then(function(res){
            if(res.data.code=='0'){
              setTimeout(function(){
               _this.$router.push('/Main/DataAnalysis')
              },1000)
            }else {
              _this.showE = true
              _this.msg = res.data.message
              setTimeout(function(){
                _this.showE = false
              },3000)
            }
          })
        }
      }
    }
  }
</script>
<style>
  .login{
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }
  .lon-f-box{
    display: inline-block;
  }
  .inp{
    width: 5rem;
    height: .7rem;
    margin-top: .6rem;
  }
  .inp input{
    float: left;
    height: .33rem;
    margin-top: .19rem;
    margin-left: .3rem;
    background: none;  
    outline: none;  
    border: 0px; 
    color: #64FAF9;
    font-size: .2rem;
  }
  .inp img{
    width: .31rem;
    height: .33rem;
    float: left;
    margin-left: .3rem;
    margin-top: .19rem;
  }
  input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill { 
    /*-webkit-box-shadow: 0 0 0px 1000px  inset !important; */
    background: #fff !important; 
    background-image: none !important; 
    color: #fff !important;
    -webkit-tap-highlight-color:#fff !important;
  }
  .login-btn{
    width: 5rem;
    height: .7rem;
    font-size: .33rem;
    color: #64FAF9;
    /*border: 1px solid rgba(100,250,249,.7);*/
    display: block;
    line-height: .7rem;
    margin-top: .4rem;
  }
  a:link {
    color: #64FAF9;
  }
  a:visited {
    color: #64FAF9;
  }
</style>



// WEBPACK FOOTER //
// src/components/account/Login.vue