<!-- chenjunlml@163.com   -->
<template>
  <div v-if='showModal' class="modal"  @touchmove='aa'>
    <div class="modal-back"></div>
    <div class="modal-box">
      <p class="modal-title">{{title}}</p>
      <div class="modal-con">
        <p v-show='nowStep===0' class="modal-con-text">{{conText}}</p>
        <div v-show='nowType===0 && nowStep===1' class="selecter">
          <select class="a" name="a" v-model='pigType' @change='changePigType'>
            <option v-for='i in pigTypeList' :value="i">{{i.name}}</option>
          </select>
          <span style='display: inline-block;position: absolute;top: .15rem;
    left: 0.3rem;'>
            {{pigType.name}}
          </span>
          <img  class="select-right" :src="i_select_u" alt="">
        </div>
        <div  v-show='nowType===1 && nowStep===1' class="radio-box">
          <div class="radioer">
            <img class="radio-left" :src="i_radio2_u" alt="">
            <input @change='changeRdio' class="radio-centert" name="Fruit" type="radio" v-model='radioS' value="1" />
            <span class="radio-right">取消养殖</span>
          </div>
          <div class="radioer">
            <img class="radio-left" :src="i_radio1_u" alt="">
            <input @change='changeRdio' class="radio-centert" name="Fruit" type="radio" v-model='radioS' value="2" />
            <span class="radio-right">生猪死亡</span>
          </div>
        </div>
        <div  v-show='nowType===1 && nowStep===2'>
          <div class="input_box" >
            <input @keyup='searchUser' v-model='userName' class="input" type="text" name="" placeholder="姓名/电话" style="width: 2.5rem;">
          </div>
          <ul id='serc_box' v-if='farms.length > 0'>
            <li @click='selectFarm(i)' v-for='i in farms'>{{i.userName}}</li>
          </ul>
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
import Server from '../../server/myServer'
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
      pigType: {},
      userName: '',
      allFarms: [],
      nowFarm: {}
    }
  },
  props:[
    'showModal','title','conText','SBtnName1','SBtnName2','nowStep','nowType','pigTypeList','pigDefaultType','userList'
  ],
  methods: {
    aa(e){
      if(e.target.className == ''){
        
      }else {
        e.preventDefault()
      }
    },
    closeMdal() {
      this.$emit('closeMdal')
    },
    okay() {
      if(this.$parent.nowStep === 0){

        this.pigType = this.$parent.pigDefaultType        
        this.$emit('Sure',this.pigType)
        
      }else if (this.$parent.nowStep === 1) {
        if(this.$parent.nowType === 0){
          this.$emit('Sure',this.pigType)
        }else {
          this.$emit('Sure',this.radioS)
        }
        
      }else if (this.$parent.nowStep === 2) {
        this.$emit('Sure',this.nowFarm)
      }
      
    },
    back() {
      this.$emit('Back')
    },
    changePigType() {
      
    },
    changeRdio(num) {
      
      if(this.radioS === '1'){
        this.i_radio1_u = i_radio1
        this.i_radio2_u = i_radio2
      }else if(this.radioS === '2'){
        this.i_radio1_u = i_radio2
        this.i_radio2_u = i_radio1
      }
    },
    searchUser() {
      let vm = this

      Server()._searchFamer({
        keyWords: vm.userName
      }).then(function(res){
        if(res.data){
          vm.allFarms =  res.data.data      
        }else{
          vm.$msg(res.data.message)
        }
      })
    },
    selectFarm(i) {
      this.nowFarm = i
      this.userName = i.userName
    }
  },
  components: {
    
  },
  created() {
    
    
  },
  computed: {
    farms: function(){
      return this.allFarms
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .modal{
    .modal-back{
      position: absolute;
      background-color: rgba(000,000,000,.5);
      height: 100%;
      width: 100%;
      top: 0;
      left: 0;
      bottom: 0;
      right: 0;
    }
    .modal-box{
      width: 4.22rem;
      padding-bottom: .3rem;
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
          border-radius: .7rem;
          position: relative;
          select{
            opacity: 0;
            text-indent: .1rem;
            width: 2.5rem;
            height: .7rem;
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
            position: absolute;
            top: 0;
            margin-right: .2rem;
            right: 0;
            top: .28rem;
          }
        }
        .radio-box{
          display: flex;
          margin-left: .15rem;
          .radioer{
            width: 2rem;
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
        .input_box{
          border: 1px solid #e3e3e3;
          width: 3.44rem;
          height: .7rem;
          margin-top: .2rem;
          .input{
            height: .5rem;
          }
        }
        #serc_box{
          width: 3.44rem;
          background: #fff;
          max-height: 1.4rem;
          // position: absolute;
          // height: 1.4rem;
          top: 2.05rem;
          border: 1px solid #e3e3e3;
          overflow-y: auto;
          margin: 0 auto;
          li{
            height: .7rem;
            line-height: .7rem;
            font-size: .30rem;
            border-bottom: 1px solid #e3e3e3;
            width: 3.44rem;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }
        }
      }
      .modal-footer{
        display: flex;
        margin-top: .3rem;
        margin-left: -4px;
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
