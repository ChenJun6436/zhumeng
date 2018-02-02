<template>
  <div class="smallbox" :style='smallBoxStyle'>
    <p class="title">养殖户对比图(2018年)</p>
    <p class="title-two">
      <span> <span class="huang"><img :src="dian1" alt="">养殖户总数</span>{{famerType.culturist}}户</span>
      <span> <span class="huang"><img :src="dian1" alt="">养殖状元</span>{{famerType.champion}} ({{famerType.num}}头)</span>
    </p>
    <div id="bingBOx">
      
    </div>
  </div>
</template>
<script>
  import myServices from '../../server/myServer'

  import kuang from '../../assets/kuang5.png'
  import dian from '../../assets/huangdian.png'


    // 引入基本模板
  let echarts = require('echarts/lib/echarts')
  // 引入柱状图组件
  require('echarts/lib/chart/pie')
  // 引入提示框和title组件
  require('echarts/lib/component/tooltip')
  require('echarts/lib/component/title')

  export default {
    name: 'FamerType',
    data () {
      return {
        smallBoxStyle : {
          backgroundImage: "url(" + kuang + ")",
          // backgroundRepeat: "repeat-x",
          // backgroundSize: "cover",
          backgroundSize:' 7.23rem 4.20rem',
          // backgroundPositionX: "-0.6rem",
        },
        dian1: dian,
        famerType:[]
      }
    },
    props: [
      'title','content','up','dataShow'
    ],
    mounted(){
      this._getFamerTypee()
    },
    methods: {
      _getFamerTypee(){
        let vm = this
        myServices().countCulture().then(function(res){
          if(res.data.code == '0'){
             vm.famerType = res.data.data
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
      color:['#e2962b', '#15b99b'],
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
              radius : [30, 53],
              // center: ['40%', '50%'],
              data:[
                      {name:'养殖场', value:vm.famerType.culturist},
                      {name:'散户', value:vm.famerType.farm},
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
        // 绘制图表
        myChart.setOption(option)
      },
    },
    created () {
      
    }
  }
</script>
<style scoped>
  .smallbox{
    width: 7.23rem;
    height: 4.20rem;
    box-sizing: border-box;
    padding: .25rem;
    text-align: left;
    position: relative;
  }
  .title{
    font-size: .21rem;
    color: #64faf9;
    text-align: center;
  }
  .title-two{
    color: #fff;
    font-size: .21rem;
    text-align: center;
    margin-top: .50rem;
  }
  .huang{
    color: #e2962b;
    margin-left: .20rem;
    margin-right: .10rem;
  }
  .huang img{
    height:.08rem;
    margin-top:.07rem;
    margin-right:.05rem;
  }
  #bingBOx{
    width: 3.90rem;
    height: 2.80rem;
    margin: 0 auto;
  }
/*  .blackImg{
    position: absolute;
    top: 1.84rem;
    left: 1.65rem;
  }*/
  .content{
    font-size: .32rem;
    color: #64faf9;
    font-weight: 600;
    letter-spacing:.05rem;
    margin-top: .18rem;
  }
  .dataShow{
    font-size: .18rem;
    color: #fff;
    margin-top: .15rem;
  }
  .dataShow-img{
    margin-top:.03rem; 
  }
</style>



// WEBPACK FOOTER //
// src/components/common/Header.vue