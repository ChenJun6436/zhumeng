<template>
  <div>
    <div class="topBox" style="margin-top: .6rem">
      <div>
        <SmallBox :title='allTitle' :content='allContent' :up='allUp' :dataShow='allDataShow'>
        </SmallBox>
        <SmallBox style='margin-top: 1.77rem;' :title='killTitle' :content='killContent' :up='killUp' :dataShow='killDataShow'>
        </SmallBox>
        <SmallBox style='margin-top: 1.77rem;'  :title='spTitle' :content='spContent' :up='spUp' :dataShow='spDataShow'>
        </SmallBox>
      </div>
      <div style='margin-left: .4rem;'>
        <Map :topList='pigTop' style='margin:0 auto;display: inline-block;'></Map>
      </div>
      <div>
        <PigTopFive :topList='pigTop'></PigTopFive>
        <PigTypeBox style='margin-top: .36rem;'></PigTypeBox>
      </div>
    </div>    
  </div>
</template>
<script>
  import myServices from '../../server/myServer'
  import Map from '../common/BaiDuMap'
  import SmallBox from '../common/SmallBox'
  import PigTypeBox from '../common/PigTypeBox'
  import PigTopFive from '../common/PigTopFive'
  export default {
    name: 'DataAnalysis',
    data () {
      return {
       overView:[],
       allTitle : '',
       allContent : '',
       allUp : true,
       allDataShow : '',
       killTitle :'',
       killContent : '',
       killUp : true,
       killDataShow : '',
       spTitle :'',
       spContent : '',
       spUp : true,
       spDataShow : '',
       pigTop:[],
      }
    },
    components:{
      Map,SmallBox,PigTypeBox,PigTopFive
    },
    methods: {
      _getAllData(){
        let vm = this
        myServices().getAllData().then(function(res){
          if(res.data.code == '0'){
            //生猪总数
            vm.overView = res.data.data
            vm.allTitle = vm.overView[0].name
            vm.allContent = vm.overView[0].num
            if(vm.overView[0].type == 'up'){
              vm.allUp = true
            }else{
              vm.allUp = false
            }
            vm.allDataShow = vm.overView[0].percentage
            //屠宰总数
            vm.killTitle = vm.overView[1].name
            vm.killContent = vm.overView[1].num
            if(vm.overView[1].type == 'up'){
              vm.killUp = true
            }else{
              vm.killUp = false
            }
            vm.killDataShow = vm.overView[1].percentage
            //异常生猪
            vm.spTitle = vm.overView[2].name
            vm.spContent = vm.overView[2].num
            if(vm.overView[2].type == 'up'){
              vm.spUp = true
            }else{
              vm.spUp = false
            }
            vm.spDataShow = vm.overView[2].percentage
          }
        })
      },
      _getPigTop5(){
        let vm = this
        myServices().getPigTop5().then(function(res){
          if(res.data.code == '0'){
             vm.pigTop = res.data.data
          }
        }).then(function(){
          
        })
      },
    },  
    created () {
      this._getAllData()
      this._getPigTop5()
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
    width: 100%;
    display: flex;
    margin: 0 auto;
    /*margin-top: .3rem;*/
    justify-content: space-between;
  }
</style>



// WEBPACK FOOTER //
// src/components/marketing/DataAnalysis.vue