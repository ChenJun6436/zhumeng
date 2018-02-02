<template>
  <div id="app">    
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app',
  methods: {
    getBrowserVersion: function () {
        var agent = navigator.userAgent.toLowerCase();
        var arr = [];
        var Browser = "";
        var Bversion = "";
        var verinNum = "";
        //IE
        if (agent.indexOf("msie") > 0) {
          var regStr_ie = /msie [\d.]+;/gi;
          Browser = "IE";
          Bversion = "" + agent.match(regStr_ie)
        }
        //firefox
        else if (agent.indexOf("firefox") > 0) {
          var regStr_ff = /firefox\/[\d.]+/gi;
          Browser = "firefox";
          Bversion = "" + agent.match(regStr_ff);
        }
        //Chrome
        else if (agent.indexOf("chrome") > 0) {
          var regStr_chrome = /chrome\/[\d.]+/gi;
          Browser = "chrome";
          Bversion = "" + agent.match(regStr_chrome);
        }
        //Safari
        else if (agent.indexOf("safari") > 0 && agent.indexOf("chrome") < 0) {
          var regStr_saf = /version\/[\d.]+/gi;
          Browser = "safari";
          Bversion = "" + agent.match(regStr_saf);
        }
        //Opera
        else if (agent.indexOf("opera") >= 0) {
          var regStr_opera = /version\/[\d.]+/gi;
          Browser = "opera";
          Bversion = "" + agent.match(regStr_opera);
        } else {
          var browser = navigator.appName;
          if (browser == "Netscape") {
            var version = agent.split(";");
            var trim_Version = version[7].replace(/[ ]/g, "");
            var rvStr = trim_Version.match(/[\d\.]/g).toString();
            var rv = rvStr.replace(/[,]/g, "");
            Bversion = rv;
            Browser = "IE"
          }
        }
        verinNum = (Bversion + "").replace(/[^0-9.]/ig, "");
        arr.push(Browser);
        arr.push(verinNum);
        return arr;
      },

  },
  created () {
    // window.open(document.location, 'big', 'fullscreen=yes')
    let browser =  this.getBrowserVersion()[0]
    let verinNum = this.getBrowserVersion()[1]
    if(browser==='IE' && verinNum <= 8){
      alert('请使用IE9以上游览器访问！')
    }
    // 启动全屏!
    
    // this.launchFullScreen(document.getElementById("app"));
  },
  mounted(){
    // this.launchFullscreen(document.getElementById("app")); // 整个网页
  }
}
</script>

<style>
  body { text-align: center; font-family:"微软雅黑", arial;margin:0; padding:0; background: #FFF; color:#5e6d82;}
  div,form,img,ul,ol,li,dl,dt,dd {margin: 0; padding: 0; border: 0; }
  p{margin: 0;}
  li{list-style-type:none;}
  img{vertical-align:top;}
  h1,h2,h3,h4,h5,h6 { margin:0; padding:0;font-size:12px; font-weight:normal;}
  a:link {color: #5e6d82; text-decoration:none;}
  a:visited {color: #5e6d82;text-decoration:none;}
  a:hover {color: #5e6d82; text-decoration:none;}
  a:active {color: #5e6d82;}
</style>



// WEBPACK FOOTER //
// src/App.vue