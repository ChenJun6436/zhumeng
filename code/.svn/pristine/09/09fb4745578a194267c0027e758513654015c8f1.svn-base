<template>
  <div class="smallbox" :style='smallBoxStyle'>
    <p class="title">生猪品种数据(2018年)</p>
    <div id="bingBOx">
      
    </div>
    <img class="blackImg" :src="blackX_u" alt="">
  </div>
</template>
<script>
  import myServices from '../../server/myServer'

  import kuang from '../../assets/kuang3.png'
  import abate from '../../assets/hongjiantou.png'
  import increase from '../../assets/lvjiantou.png'
  import blackX from '../../assets/quanquan.png'

    // 引入基本模板
  let echarts = require('echarts/lib/echarts')
  // 引入柱状图组件
  require('echarts/lib/chart/pie')
  // 引入提示框和title组件
  require('echarts/lib/component/tooltip')
  require('echarts/lib/component/title')
  // require('echarts/lib/component/formatter')
  
  export default {
    name: 'PigTypeBox',
    data () {
      return {
        smallBoxStyle : {
          backgroundImage: "url(" + kuang + ")",
          backgroundSize: "4.4rem 4.3rem",
        },
        blackX_u: blackX,
        pigType:[]
      }
    },
    props: [
      'title','content','up','dataShow'
    ],
    mounted(){
      this._getPigType()
    },
    methods: {
      _getPigType(){
        let vm = this
        myServices().getPigType().then(function(res){
          if(res.data.code == '0'){
             vm.pigType = res.data.data
          }
        }).then(function(){
          vm.drawLine()
        })
      },
      drawLine() {
        let vm = this
        // 基于准备好的dom，初始化echarts实例
        let myChart = echarts.init(document.getElementById('bingBOx'))

        let option = {
      // tooltip : {
      //     trigger: 'item',
      //     formatter: "{a} <br/>{b} : {c} ({d}%)"
      // },
      color:['#6a3bd4', '#ee9e2d','#219fe4','#d24836','#1bad88'],
      legend: {
          orient: 'vertical',
          x: 'right',
          data: ['准时','迟到','请假','未到'],
          formatter:function(name){
            var oa = option.series[0].data;
            var num = oa[0].value + oa[1].value + oa[2].value + oa[3].value;
            for(var i = 0; i < option.series[0].data.length; i++){
                    if(name==oa[i].name){
                      return name + '     ' + oa[i].value + '     ' + (oa[i].value/num * 100).toFixed(2) + '%';
                    }
            }
          }
      },
      series : [
          {
              name: '签到比例分析',
              type: 'pie',
              radius : '30%',
              // center: ['40%', '50%'],
              data:[
                {name:vm.pigType[0].typeName, value:vm.pigType[0].num},
                {name:vm.pigType[1].typeName, value:vm.pigType[1].num},
                {name:vm.pigType[2].typeName, value:vm.pigType[2].num},
                {name:vm.pigType[3].typeName, value:vm.pigType[3].num},
                {name:vm.pigType[4].typeName, value:vm.pigType[4].num},
              ],
              itemStyle: {
                  emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
              },
              itemStyle: {
                  normal: {
                      label:{ 
                            show: true, 
//                              position:'inside',
                            formatter: '{b}:({d}%)\n{c}头' 
                        }
                  },
                    labelLine :{show:true}
              }
          }
      ]
  };
        myChart.setOption(option)
        // 绘制图表
        // myChart.setOption({
        //   series: {
        //     type: 'pie',
        //     radius: '30%',
        //     data: [
        //       {name:vm.pigType[0].typeName, value:vm.pigType[0].num},
        //       {name:vm.pigType[1].typeName, value:vm.pigType[1].num},
        //       {name:vm.pigType[2].typeName, value:vm.pigType[2].num},
        //       {name:vm.pigType[3].typeName, value:vm.pigType[3].num},
        //       {name:vm.pigType[4].typeName, value:vm.pigType[4].num},
        //     ]
        //   },
        //   color:['#6a3bd4', '#ee9e2d','#219fe4','#d24836','#1bad88'],
        //   itemStyle : {
        //     normal : {
          // label
        //       formatter: '{b}:({d}%)\n{c}头',
        //       textStyle : {
        //         fontWeight : 'normal',
        //         fontSize : 20
        //       }
        //     }
        //   },
        // })
      },
    },
    created () {
      
    }
  }
</script>
<style scoped>
  .smallbox{
    width: 4.4rem;
    height: 4.3rem;
    box-sizing: border-box;
    padding: .25rem;
    text-align: left;
    position: relative;
  }
  .title{
    font-size: .21rem;
    color: #64faf9;
  }
  #bingBOx{
    width: 3.90rem;
    height: 3.80rem;

  }
  .blackImg{
    position: absolute;
    top: 2.02rem;
    left: 1.8rem;
    width: .8rem;
    height: .8rem;
  }
  .content{
    font-size: .32rem;
    color: #64faf9;
    font-weight: 600;
    letter-spacing:.5rem;
    margin-top: .18rem;
  }
  .dataShow{
    font-size: .18rem;
    color: #fff;
    margin-top: .15rem;
  }
  .dataShow-img{
    margin-top:. 3rem; 
  }
</style>



// WEBPACK FOOTER //
// src/components/common/Header.vue