<template>
  <div v-if='showModal' class="modal">
    <div class="modal-box">
      <p class="modal-title">{{title}}</p>
      <div class="modal-con" :disabled="!radioShow">
         <p class="modal-con-text" v-show="radioShow">{{conText}}</p> 
        <!--<div class="selecter">
          <select class="a" name="a" >
            <option value="a">111</option>
          </select>
          <img  class="select-right" :src="i_select_u" alt="">
        </div>-->
        <div class="radio-box" v-show="!radioShow">
          <div class="radioer">
            <img class="radio-left" :src="i_radio2_u" alt="">
            <input @change='changeRdio' class="radio-centert" name="Fruit" type="radio" v-model='radioS' value="1" />
            <span class="radio-right">{{radioLeft}}</span>
          </div>
          <div class="radioer">
            <img class="radio-left" :src="i_radio1_u" alt="">
            <input @change='changeRdio' class="radio-centert" name="Fruit" type="radio" v-model='radioS' value="2" />
            <span class="radio-right">{{radioRight}}</span>
          </div>
        </div>
        
      </div>
      <div class="modal-footer">
        <div class="btn-box">
          <a @click='back'  class="samll-btn-no samll-btn" href="javaScript:;" >{{SBtnName2}}</a>
        </div>
        <div class="btn-box">
          <a @click='okay' :style='btnStyle' class="samll-btn" href="javaScript:;" >{{SBtnName1}}</a>
        </div>
          
      </div>
      <div class="close">
        <img @click='closeMdal' :src="i_close_u" alt="">
      </div>
    </div>
  </div>
</template>

<script>
import i_back from './../../assets/common/back@2x.png'
import i_close from './../../assets/common/ic_close.png'
import i_big_btn from './../../assets/common/baocunanniu@2x.png'
import i_select from './../../assets/common/down@2x.png'
import i_radio1 from './../../assets/common/ic_unselected.png'
import i_radio2 from './../../assets/common/ic_selected.png'
export default {
  name: 'Modal',
  data () {
    return {
      i_back_u: i_back,
      i_close_u: i_close,
      i_big_btn_u: i_big_btn,
      i_select_u: i_select,
      i_radio1_u: i_radio1,
      i_radio2_u: i_radio2,
      btnStyle: {
        backgroundImage: "url(" + i_big_btn + ")",
        backgroundRepeat: "repeat-x",
        backgroundSize: "3rem .9rem",
        backgroundPositionX: "-0.6rem",
      },
      radioS: '1',
    }
  },
  props:[
    'showModal','title','conText','SBtnName1','SBtnName2','radioShow','radioLeft','radioRight'
  ],
  methods: {
    closeMdal() {
      this.$emit('closeMdal')
    },
    okay() {
      console.log('ok')
      this.$emit('Sure')
    },
    back() {
      this.$emit('Back')
    },
    changeRdio(num) {
      console.log(this.radioS )
      if(this.radioS === '1'){
        this.i_radio1_u = i_radio1
        this.i_radio2_u = i_radio2
      }else if(this.radioS === '2'){
        this.i_radio1_u = i_radio2
        this.i_radio2_u = i_radio1
      }
       this.$emit('changeRdio',this.radioS)
      // if(this.i_radio1_u === i_radio1){
      //   this.i_radio1_u = i_radio2
      //   this.i_radio2_u = i_radio1
      // }else if(this.i_radio1_u === i_radio2){
      //   this.i_radio1_u = i_radio1
      //   this.i_radio2_u = i_radio2
      // }
      
    }
  },
  components: {
    
  },
  created() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .modal{
    position: absolute;
    background-color: rgba(000,000,000,.5);
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    .modal-box{
      width: 4.22rem;
      height: 3.5rem;
      background-color: #ffffff;
      border-radius: .1rem;
      position: absolute;
      left: 50%;
      margin-left: -2.11rem;
      top: 50%;
      margin-top: -1.75rem;
      .modal-title{
        font-size: .3rem;
        margin-top: .7rem;
      }
      .modal-con{
        margin-top: .36rem;
        .modal-con-text{
          font-size: .4rem;
          font-weight: bold;
        }
        .selecter{
          width: 2.5rem;
          height: .7rem;
          border: 1px solid #e3e3e3;
          margin: 0 auto;
          border-radius: .7rem;;
          select{
            opacity: 0;
            text-indent: .1rem;
            width: 2.5rem;
            height: .3rem;
            outline: none;
            appearance:none;
            -moz-appearance:none;
            option{
              text-indent: .1rem;
              color: #444;
            }
          }
          .select-right{
            width: .2rem;
            height: .12rem;
            float: right;
            margin-right: .2rem;
          }
        }
        .radio-box{
          display: flex;
          margin-left: .4rem;
          .radioer{
            width: 1.8rem;
            position: relative;
            .radio-left{
              width: .36rem;
              height: .36rem;
              z-index: 1;
            }
            .radio-centert{
              width: .3rem;
              height: .3rem;
              position: absolute;
              left: .2rem;
              opacity: 0;
              z-index: 5;
            }
            .radio-right{

            }
          }
        }
      }
      .modal-footer{
        display: flex;
        margin-top: .3rem;
        .btn-box{
          margin: 0 auto;
          width: 1.5rem;
          .samll-btn{
            display: block;
            width: 100%;
            height: .7rem;
            border-radius: .88rem;
            background-color: #ffffff;
            margin-left: .05rem;
            // margin-top: .54rem;
            font-size: .3rem;
            border: none;
            line-height: .7rem;
            color: #ffffff;
            outline: none;
          }
          .samll-btn-no{
            border: 1px solid #e3e3e3;
            background-color: #ffffff;
            font-size: .3rem;
            line-height: .7rem;
            color: #AFB7BE;
            outline: none;
            box-sizing: border-box;
          }
        }
      }
      .close{
        position: absolute;
        right: 0;
        top: -.8rem;
        img{
          width: .4rem;
        }
      }
    }
  }
  
</style>
