<!-- <Selecter :val='xx' @Change='Change'> -->
<template>
  <p class="selecter" style="position: relative">
    <span style="line-height: .7rem;float: left;position: absolute;left:.5rem;"> 
      <span v-show='showD'>
       <span v-if="selectedDef">{{selectedDef}}</span>
       <span v-if='!selectedDef' style="color: #e3e3e3;">{{selectedDefaa}}</span> 
      </span>
      <span v-show='!showD'>{{selected.name}}</span>
    </span>
    <select v-model="selected" @change='Change' class="selecta" name="a">
      <option v-for='i in val' :value="i">{{i.name}}</option>
    </select>
    <img  class="select-right aa" :src="i_select_u" alt="">
  </p>
</template>

<script>

import i_select from './../../assets/common/down@2x.png'
export default {
  name: 'Selecter',
  data () {
    return {
      i_select_u: i_select,
      selected: '',
      showD: true,
    }
  },
  props:[
    'val','selectedDef','selectedDefaa'
  ],
  methods: {
    Change() {
      // console.log(this)
      this.showD = false
      let data  = {
        select: this.selected,
        uid: this._uid
      }
      this.$emit('Change',data)
     
    },
  },
  created() {
    
  },
  computed: {
    
  },
  watch:{

　},
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
      
      width: 3.2rem;
      height: .6rem;
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
      position: absolute;
      right: 0;
      top: .3rem;
    }
  }
  
</style>
