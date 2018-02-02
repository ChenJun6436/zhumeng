<!-- <Selecter :val='xx' @Change='Change'> -->
<template>
  <div>
    <mt-datetime-picker :style='{display: _showDate}'
      class='mypicker'
      ref="picker"
      type="date"
      cancelText='清空'
      v-model="pickerValue"
      @confirm="handleConfirm"
      @cancel="checkinCancel">
    </mt-datetime-picker>
    <div class="slDate"  @click='openPicker'  style='position: relative;'>
      <span v-if='haveDateVale' style="line-height: .7rem;">{{_pickerValue}}</span>
      <img class="dateImg" :src="i_date_u" alt="" @click='openPicker'>
      <span v-if='!haveDateVale' style='position: absolute;top: .2rem;left: .5rem;'>{{defTitle}}</span>
    </div>

  </div>
</template>

<script>

import i_date from './../../assets/common/date@2x.png'

export default {
  name: 'SlDate',
  data () {
    return {
      i_date_u: i_date,
      pickerValue: '',
      showDate: 'none',
      nowData:'',
      haveDateVale: false
    }
  },
  props:[
    'val','defTitle'
  ],
  methods: {
    openPicker() {
      this.showDate = 'block'
    },
    handleConfirm() {
      let vm = this
      console.log(this.nowData)
      this.haveDateVale = true
      this.showDate = 'none'
      if(this.nowData){
        this.$emit('getNowDate',this.nowData)
      }else {
        setTimeout(function(){
          vm.$emit('getNowDate',vm.nowData)
        },300)
      }
      
    },
    checkinCancel() {
      this.haveDateVale = false
      this.showDate = 'none'
      this.nowData = ''
      if(!this.nowData){
        this.$emit('getNowDate',this.nowData)
      }else {
        setTimeout(function(){
          vm.$emit('getNowDate',vm.nowData)
        },300)
      }
    },

  },
  created() {
    
  },
  computed: {
    _showDate: function() {
      return this.showDate 
    },
    _pickerValue: function() {
      function add0(m){return m<10?'0'+m:m }
      var time = new Date(this.pickerValue);
      var y = time.getFullYear();
      var m = time.getMonth()+1;
      var d = time.getDate();
      this.nowData = y+'-'+add0(m)+'-'+add0(d)
      return this.nowData
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='less'>
  .slDate{
    width: 3.2rem;
    height: .7rem;
    border: 1px solid #e3e3e3;
    margin: 0 auto;
    border-radius: .7rem;;
    .dateImg{
      float: right;
      width: .4rem;
      height: .4rem;
      margin-top: .12rem;
      margin-right: .2rem;
    }
  }
  .mypicker{
    z-index: 999
  }
  
</style>
