<template>
  <div class="login-box">
    <div class="addbox">
      <Top :HRight='HRight' :HTitle='HTitle'></Top>
      <div style='display: flex'>
        <span style='display: block;padding-top: .6rem;margin-left: 0.7rem;font-size: .28rem;'>地址：</span>
        <div class="addressFrom">
          <Selecter :val='sheng' @Change='shengChange'></Selecter>
          <Selecter :val='sheng' @Change='shengChange'></Selecter>
          <Selecter :val='sheng' @Change='shengChange'></Selecter>
          <Selecter :val='sheng' @Change='shengChange'></Selecter>
          <Selecter :val='sheng' @Change='shengChange'></Selecter>
        </div>
      </div>
      
      <BigBtn :btnName='btnName'></BigBtn>
    </div>
    
  </div>
</template>

<script>
import BigBtn from './../common/BigBtn'
import Top from './../common/Top'
import Selecter from './../common/Selecter'
export default {
  name: 'AddressMan',
  data () {
    return {
      HRight: '',
      HTitle: '地址管理',
      btnName: '保存',
      sheng: ['省','sic']
    }
  },
  methods: {
    shengChange() {

    },
  },
  components: {
    Top, Selecter, BigBtn
  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang='less'>
  .login-box{

    .addbox{
      background-color: #fff;
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
      .addressFrom{
        .selecter{
          height: .7rem;
          width: 5rem;
          border: 1px solid #e3e3e3;
          // margin: 0 auto;
          margin-top: .46rem;
          border-radius: .7rem;
          .aa{
            width: .2rem;
            height: .12rem;
            float: right;
            margin-right: .3rem;
            margin-top: .25rem;
          }
          select{
            opacity: 0;
            text-indent: .1rem;
            width: 4.3rem;
            height: .3rem;
            outline: none;
            appearance:none;
            -moz-appearance:none;
            option{
              text-indent: .2rem;
              // color: #444;
            }
          }
        }
      }
      .btn-box{
        width: 6.8rem;
      }
    }
  }
</style>
