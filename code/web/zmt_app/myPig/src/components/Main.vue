<template>
  <div class="login-box" :style='appStyle'>
    <!-- <transition name='fade' mode="out-in"> -->
      <router-view></router-view> 
    <!-- </transition>   -->
    <Bottom :nowIndex='nowIndex' :showf='_showf'></Bottom>
  </div>
</template>


<script>
import Bottom from './common/Bottom'
export default {
  name: 'Main',
  data () {
    return {
      nowIndex: 1,
      showf: false,
      myHeight: '',
      appStyle: {},
    }
  },
  methods: {
    isTab(){
      this.showf = false
      let showArr = ['Index','MyPig','PerCenter']
      if(this.$route.name === 'Index' || this.$route.path === '' || this.$route.path === '/'){
        this.nowIndex = 1
      }
      if(this.$route.name === 'MyPig'){
        this.nowIndex = 2
      }
      if(this.$route.name === 'PerCenter'){
        this.nowIndex = 3
      }
      for(var i =0;i<=showArr.length;i++){
        if( this.$route.name == showArr[i] ){
          this.showf = true
        }
      }
    }
  },
  components: {
    Bottom
  },
  created() {
    this.isTab()
  },
  mounted() {
    let h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
    // this.myHeight = h/50 + 0.56 +'rem'
    this.myHeight = h/50 + 0.4 +'rem'
    // this.myHeight = h/50 +'rem'
    this.appStyle = {
      minHeight : this.myHeight,
      height : this.myHeight
    }
  },
  watch:{
    '$route':'isTab'
  },
  computed: {
    _showf: function(){
      return this.showf
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .login-box{
    // position: absolute;
    // top: 0;
    // left: 0;
    // bottom: 0;
    // right: 0;
    background-color: #f1f1f1;
    .footer{
      background-color: #28282e;
      text-align: center;
      .f_img{
        display: inline-block;
        height: .4rem;
        width: .44rem;
      }
      .f_font{
        // width: .48rem;
        height: .24rem;
      }
    }
    .mint-tabbar > .mint-tab-item.is-selected{
      background-color: #28282e;
    }
    .mint-tab-item-icon {
        width: .48rem;
        height: .48rem;
        margin: 0 auto 5px;
    }
    .mint-loadmore-bottom {
      margin-bottom: 0px; 
    }
  }
</style>
