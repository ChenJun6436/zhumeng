<template>
  <div id="app" :style='appStyle'>
    <router-view ></router-view>
   
  </div>
</template>

<script>

export default {
  name: 'app',
  data() {
    return {
      myHeight: '',
      appStyle: {},
    }
  },
  created(){
    
  },
  mounted(){
    let h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
    // this.myHeight = h/50 + 0.54 +'rem'
    this.myHeight = h/50 + 0.5 +'rem'
    // this.myHeight = h/50 +'rem'
    this.appStyle = {
      minHeight : this.myHeight,
      height : this.myHeight,
    }
  }
}
</script>

<style lang='less'>
html{
  font-size: 100px;
  padding: 0;
  margin: 0;
  body{
    padding: 0;
    margin: 0;
    #app {
      font-family: 'PingFang-SC-Medium', Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
      // position: absolute;
      // top: 0;
      // left: 0;
      // bottom: 0;
      // right: 0;
      color: #444444;
      font-size: .28rem;
    }
    div,form,img,ul,ol,li,dl,dt,dd {margin: 0; padding: 0; border: 0; }
    li{list-style-type:none;}
    img{vertical-align:top;}
    h1,h2,h3,h4,h5,h6 { margin:0; padding:0;font-size:12px; font-weight:normal;}
    a{color: #95adaa;border:none;-webkit-tap-highlight-color: rgba(0,0,0,0);-webkit-tap-highlight-color:transparent;outline:none;}
    a:link {color: #95adaa; text-decoration:none;}
    a:visited {color: #95adaa;text-decoration:none;}
    a:hover {color: #95adaa; text-decoration:none;}
    a:active {color: #95adaa;outline: none;}
    .fl{
      float: left;
    }
    .input_box{
      width: 5.8rem;
      height: .88rem;
      border-radius: .88rem;
      background-color: #ffffff;
      margin: 0 auto;
      margin-top: .54rem;
      .input_img{
        width: .32rem;
        height: .4rem;
        float: left;
        margin-left: .3rem;
        margin-top: .24rem;
      }
      .input_left{
        display: block;
        width: 1rem;
        height: .4rem;
        float: left;
        margin-left: .3rem;
        margin-top: .24rem;
        
      }
      .input{
        float: left;
        height: .6rem;
        margin-top: .1rem;
        width: 3.5rem;
        margin-left: .5rem;
        border: none;
        font-size: .3rem;
        background: none;
        outline: none;
        color: #444444;
      }
      
    }
  }
}

</style>
