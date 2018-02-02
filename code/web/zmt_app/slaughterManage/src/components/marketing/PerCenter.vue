<template>
  <div class="per-box">
    <Top :HRight='HRight' :HTitle='HTitle'></Top>
    <div class="per-form">
      <div class="myLi">
        <div v-show='!editor'>
          <span class="leftTitle">张三</span>
          <img @click='editorName' class="editorIMG" :src="i_editor_u" alt="">
        </div>
        <div class="input_box" v-show='editor'>
          <input class="input" type="text" name="">
        </div>
      </div>
    </div>
    <div class="per-form sth-form">
      <div class="myLi sth-myLi">
        <span class="leftTitle sth-leftTitle">联系方式</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
        <span class="rightTitle">18380404364</span>
      </div>
      <div class="myLi sth-myLi">
        <span class="leftTitle sth-leftTitle">修改登录密码</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="myLi sth-myLi">
        <span class="leftTitle sth-leftTitle">地址管理</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="myLi sth-myLi">
        <span class="leftTitle sth-leftTitle">忘记密码</span>
        <img  class="editorIMG nextIMG" :src="i_next_u" alt="">
      </div>
      <div class="mtfooter" v-show='editor'>
        <SmallBtn :btnName='btnName1' @Click='sure'></SmallBtn>
        <SmallBtnNo :btnName='btnName2' @Click='cancel' style='margin-left: .3rem;'></SmallBtnNo>
      </div>
    </div>
  </div>
</template>

<script>
import Top from '../common/Top'
import editorBtn from '../common/editorBtn'
import SmallBtn from '../common/SmallBtn'
import SmallBtnNo from '../common/SmallBtnNo'
import i_editor from './../../assets/common/editor_@2x.png'
import i_next from './../../assets/common/next_.png'
export default {
  name: 'PerCenter',
  data () {
    return {
      HTitle: '个人信息',
      HRight: '',
      i_editor_u: i_editor,
      i_next_u: i_next,
      editor: false,
      btnName1: '保存',
      btnName2: '取消'
    }
  },
  components: {
    Top, editorBtn, SmallBtn, SmallBtnNo
  },
  methods: {
    editorName() {
      this.editor = true
    },
    sure() {
      this.editor = false
    },
    cancel() {
      this.editor = false
    }
  },
  created() {
    console.log(1)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .per-box{
    .mtfooter{
      display: flex;
      position: absolute;
      bottom: .42rem;
      left: .5rem;
      .btn-box-smallbtn{
        width: 3rem;
      }
    }
    .per-form{
      padding: 0 .36rem;
      background-color: #fff;
      .domy{
        box-sizing: border-box;
        padding-top: 0.22rem;
      }
      .myLi{
        height: 1.2rem;
        line-height: 1.2rem;
        .leftTitle{
          font-size: .32rem;
          float: left;
          font-weight: bold;
          letter-spacing: 3px;
        }
        .rightTitle{
          float: right;
          margin-right: .2rem;
          font-size: .26rem;
          letter-spacing: 1px;
        }
        .editorIMG{
          height: .46rem;
          width: .68rem;
          float: right;
          margin-top: .32rem;
        }
        .input_box{
          border: 1px solid #e3e3e3;
          height: .68rem;
          margin-top: 0;
          position: absolute;
          top: 1.1rem;
          left: .8rem;
          input{
            height: .4rem;
          }
        }
      }
    }
    .sth-form{
      // height: 10.5rem;
      margin-top: .2rem;
      position: absolute;
      left: 0;
      right: 0;
      bottom: 0;
      top: 105px;
      .sth-myLi{
        border-bottom: 1px solid #e3e3e3;
        .sth-leftTitle{
          font-weight: 400;
          letter-spacing: 1px;
        }
        .nextIMG{
          width: .12rem;
          height: .2rem;
          margin-top: .5rem
        }
      }
    }
  }
</style>
