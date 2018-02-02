<!-- chenjunlml@163.com   -->
<template>
  <div class="editorBtn-box">
      <img class="editorIMG" :src="i_editor_u" alt="">
    </a>
  </div>
</template>

<script>

// import i_big_btn from './../../assets/common/baocunanniu@2x.png'
import i_editor from './../../assets/common/editor_@2x.png'
export default {
  name: 'editorBtn',
  data () {
    return {
      // btnStyle: {
      //   backgroundImage: "url(" + i_big_btn + ")",
      //   backgroundRepeat: "repeat-x",
      //   backgroundSize: "2rem .9rem",
      //   backgroundPositionX: "-0.6rem",
      // },
      i_editor_u: i_editor
    }
  },
  props:[
    'btnName'
  ],
  methods: {
    Click() {
      this.$emit('Click')
    }
  },
  created() {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .editorBtn-box{
    .samll-btn{
      .editorIMG{
        height: .46rem;
        width: .68rem;
      }
    }
  }
  
</style>
