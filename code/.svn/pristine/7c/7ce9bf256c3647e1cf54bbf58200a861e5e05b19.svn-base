<!-- <Selecter :val='xx' @Change='Change'> -->
<template>
  <div>
    <mt-datetime-picker :style='{display: _showDate}'
      class='mypicker'
      ref="picker"
      type="date"
      v-model="pickerValue"
      @confirm="handleConfirm"
      @cancel="checkinCancel">
    </mt-datetime-picker>
    
    <div class="slDate"  @click='openPicker'>
    	 <span v-if='!haveDateVale' style="line-height: .7rem;">{{dateDfl}}</span>
      <span v-if='haveDateVale' style="line-height: .7rem;">{{_pickerValue}}</span>
      <img class="dateImg" :src="i_date_u" alt="" @click='openPicker'>
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
    'val','dateDfl'
  ],
  methods: {
    openPicker() {
    	debugger;
    	console.log(this._pickerValue)
      this.showDate = 'block'
    },
    handleConfirm() {
      this.haveDateVale = true
      this.showDate = 'none'
      this.$emit('getNowDate',this.nowData)
    },
    checkinCancel() {
      this.haveDateVale = false
      this.showDate = 'none'
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
      return y+'-'+add0(m)+'-'+add0(d);
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
