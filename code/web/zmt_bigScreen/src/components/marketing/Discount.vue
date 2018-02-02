<template>
  <div>

    <div style='display: flex;justify-content: space-between'>
      <!-- <PigTypeBox></PigTypeBox> -->
      <!-- <Map :topList='pigTop' style='margin:0 auto;display: inline-block;'></Map> -->
      <KillTopFive  :topList='pigTop'></KillTopFive>
      <FamerType ></FamerType>
      <SaleTopFive  :topList='saleTop'></SaleTopFive>
    </div>
    <div>
      <PigAndKill></PigAndKill>
    </div>
  </div>
</template>
<script>
  import myServices from '../../server/myServer'
  import KillTopFive from '../common/KillTopFive'
  import SaleTopFive from '../common/SaleTopFive'
  import FamerType from '../common/FamerType'
  import PigAndKill from '../common/PigAndKill'
  
  export default {
    name: 'DataAnalysis',
    data () {
      return {
       pigTop:{},
       saleTop:{}
      }
    },
    components:{
      SaleTopFive,KillTopFive,FamerType,PigAndKill
    },
    methods: {
      _killPigTop5(){
        let vm = this
        myServices().slaughterTop5().then(function(res){
          if(res.data.code == '0'){
             vm.pigTop = res.data.data
          }
        }).then(function(){
          
        })
      },
      _saleTopFive(){
        let vm = this
        myServices().saleTop5().then(function(res){
          if(res.data.code == '0'){
             vm.saleTop = res.data.data
          }
        }).then(function(){
          
        })
      }
    },  
    created () {
      this._killPigTop5()
      this._saleTopFive()
    },
    mounted () {
      
    },
    beforeCreate () {
     
    },
    computed : {
      
    }
  }
</script>
<style scoped>
  .topBox{
    width: 70%;
    display: flex;
    margin: 0 auto;
    margin-top: 30px;
    justify-content: space-between;
  }
</style>



// WEBPACK FOOTER //
// src/components/marketing/DataAnalysis.vue