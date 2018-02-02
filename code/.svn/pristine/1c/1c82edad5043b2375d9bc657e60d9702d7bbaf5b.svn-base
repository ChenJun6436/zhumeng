<!-- <Selecter :val='xx' @Change='Change'> -->
<template>
  <div class="selecter" style="position: relative">
    <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
      <span v-show='showD'>{{selectedDef}}</span>
      <span v-show='!showD'>{{selected.name}}</span>
    </span>
    <select v-model="selected" @change='Change' class="selecta" name="a">
      <option v-for='i in val' :value="i">{{i.name}}</option>
    </select>
    <img  class="select-right aa" :src="i_select_u" alt="">
  </div>
</template>

<script>

import i_select from './../../assets/common/down@2x.png'
export default {
  name: 'Selecter',
  data () {
    return {
      i_select_u: i_select,
      selected: '省',
      showD: true
    }
  },
  props:[
    'val','selectedDef'
  ],
  methods: {
    Change() {
      this.showD = false
      this.$emit('Change',this.selected)
    },
  },
  created() {
    
  },
  computed: {
    _showSpan: function(){
      return this.selected.name
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .selecter{
    height: .7rem;
    width: 3.2rem;
    border: 1px solid #e3e3e3;
    margin: 0 auto;
    border-radius: .7rem;;
    select{
      opacity: 0;
      text-indent: .1rem;
      padding-left: .3rem;
      width: 3.2rem;
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
    	margin-top: .3rem;
      width: .2rem;
      height: .12rem;
      float: right;
      margin-right: .2rem;
    }
  }
  
</style>
