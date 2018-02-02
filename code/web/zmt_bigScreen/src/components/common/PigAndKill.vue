<template>
  <div class="smallbox" :style='smallBoxStyle'>
    <p class="title">近一年生猪总数和屠宰数对比图</p>
    <div class="botBox">
      <div id="xianBox">
      
      </div>
      <div class="bang">
        <dl>
          <dt><img class="tuzaiC" :src="tuzaichang_u" alt=""><span class="tuzaiCT">屠宰场</span></dt>
          <dd>{{allData.slaughterHouse}}</dd>
        </dl>
        <dl class="tuzaiBT">
          <dt><img class="tuzaiB" :src="tuzaibangshou_u" alt=""><span class="tuzaiBT">屠宰榜首</span></dt>
          <dd>{{allData.slaughterChampion}}</dd>
          <dd>({{allData.slaughterNum}})头</dd>
        </dl>
      </div>
    </div>
  </div>
</template>
<script>
  import myServices from '../../server/myServer'

  import kuang from '../../assets/kuang6.png'
  import tuzaichang from '../../assets/tuzaichang.png'
  import tuzaibangshou from '../../assets/tuzaibangshou.png'

    // 引入基本模板
  let echarts = require('echarts/lib/echarts')
  // 引入柱状图组件
  require('echarts/lib/chart/line')
  // 引入提示框和title组件
  require('echarts/lib/component/tooltip')
  require('echarts/lib/component/title')
  require('echarts/lib/component/legend')
  export default {
    name: 'PigAndKill',
    data () {
      return {
        tuzaichang_u: tuzaichang,
        tuzaibangshou_u: tuzaibangshou,
        smallBoxStyle : {
          // width : "100vm",
          backgroundImage: "url(" + kuang + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize: "100% 100%",
          // backgroundSize:' 18.60rem 5.91rem',
          // backgroundPositionX: "-0.6rem",
        },
        // blackX_u: blackX,
        // dian1: dian,
        allData:{},
        monthList:[],
        kiilNum:[],
        pigNum:[]
      }
    },
    props: [
      'title','content','up','dataShow'
    ],
    mounted(){
      this._getPigAndKill()
    },
    methods: {
      _getPigAndKill(){
        let vm = this
        myServices().pigAndKill().then(function(res){
          if(res.data.code == '0'){
             vm.allData = res.data.data
             for(let i of vm.allData.monthList){
              vm.kiilNum.push(i.slaughterNum)
              vm.pigNum.push(i.pigNum)
             }
          }
        }).then(function(){
          vm.drawLine()
        })
      },
      drawLine() {
        let vm = this
        // 基于准备好的dom，初始化echarts实例
        let myChart = echarts.init(document.getElementById('xianBox'))
        let option = {
          // backgroundColor: '#404a59',
          title: {
              text: '单位:头',
              show: true,
              textStyle: {
                  fontWeight: 'normal',
                  fontSize: 16,
                  color: '#F1F1F3'
              },
              right: '2%',
              top: '0%'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    color: '#57617B'
                }
            }
          },
          legend: {
            icon: 'rect',
            itemWidth: 30,
            itemHeight: 13,
            itemGap: 40,
            data:['生猪总数', '屠宰总数'],
            left:'4%',
            top:'3%',
            textStyle: {
              fontSize: 17,
              color: '#F1F1F3'
            },
          },
          grid: {
              left: '0%',
              right: '4%',
              bottom: '3%',
              containLabel: true
          },
          xAxis: [{
              type: 'category',
              boundaryGap: false,
              axisLine: {
                  lineStyle: {
                      color: '#57617B'
                  }
              },
              data: vm.monthList
          }],
          yAxis: [{
              type: 'value',
              name: '',
              axisTick: {
                  show: false
              },
              axisLine: {
                  lineStyle: {
                      color: '#57617B'
                  }
              },
              axisLabel: {
                  margin: 10,
                  textStyle: {
                      fontSize: 14
                  }
              },
              splitLine: {
                  lineStyle: {
                      color: '#57617B'
                  }
              },
          }],
          series: [{
            data: vm.pigNum,
            name: '生猪总数',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 10,
            showSymbol: true,
            lineStyle: {
                normal: {
                    width: 6
                }
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                    offset: 0,
                    color: 'rgba(44,143,255,1)'
                }, {
                    offset: 0.8,
                    color: 'rgba(44,143,255,.1)'
                }], false),
                shadowColor: 'rgba(0, 0, 0, 0.1)',
                shadowBlur: 11
              }
            },
            itemStyle: {
              normal: {
                color: 'rgba(44,143,255,1)',
                borderColor: '#fff',
                borderWidth: 1,
                label: {
                  show: true,
                  position: "top",
                  textStyle: {
                         // 用 itemStyle.normal.label.textStyle.fontSize 來更改餅圖上項目字體大小
                         fontSize: 16,
                         color: '#fff'
                      },
                  formatter: function(p) {
                      return p.value > 0 ? (p.value) : '';
                  }
                },
              }
            },
          }, 
          {
            data: vm.kiilNum,
            name: '屠宰总数',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 10,
            showSymbol: true,
            lineStyle: {
                normal: {
                    width: 5
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#e74ac4 '
                    }, {
                        offset: 0.8,
                        color: 'rgba(231,74,196,.1)'
                    }], false),
                    shadowColor: ' rgba(0,0,0,.5)',
                    shadowBlur: 6
                }
            },
            itemStyle: {
                normal: {
                    color: '#e74ac4',
                    borderColor: '#fff',
                    borderWidth: 1,
                    label: {
                        show: true,
                        position: "top",
                        textStyle: {
                           // 用 itemStyle.normal.label.textStyle.fontSize 來更改餅圖上項目字體大小
                           fontSize: 16,
                           color: '#fff'
                        },
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
          }]
        };
        // 绘制图表
        myChart.setOption(option)
      },
    },
    created () {
      let vm = this
      var myDate = new Date()
      var nowMonth = myDate.getMonth()+1
      for(var i = 0;i<12;i++){
        vm.monthList.push(nowMonth-(i))
      }
      for(var i in vm.monthList){
        if(vm.monthList[i]<=0){
          vm.monthList[i] +=12
        }
        vm.monthList[i]+='月'
      }
      vm.monthList.reverse()
    }
  }
</script>
<style scoped>
  .smallbox{
    margin-top: .3rem;
    width: 100%;
    height: 5.9rem;
    box-sizing: border-box;
    padding: .25rem;
    text-align: left;
    position: relative;
  }
  #xianBox{
    /*width: 15.43rem;*/
    width: 14.53rem;
    height: 5.4rem;
    /*margin: 0 auto;*/
    /*margin-top: .2rem;*/
  }
  .botBox{
    display: flex;
    justify-content: space-between;
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
  
  .bang{
    width: 2.5rem;
    height: 4.1rem;
    padding: .6rem .23rem;
    box-sizing: border-box;
    font-size: .28rem;
    color: #64faf9;
     margin-top: .30rem;
     border:.01rem solid rgba(100,250,249,.2);
     margin-top: .7rem;
     margin-right: .5rem;
  }
  .bang dd{
    font-size: .26rem;
    color: #fff;
    padding-left: .45rem;
    margin-top: .26rem;
  }

  .bang tuzaiC{
    width: .28rem;
    display: inline-block;
  }
  .bang tuzaiB{
    width: .26rem;
    display: inline-block;

  }

  .tuzaiBT dd{
    padding-left: .35rem;
  }
  .tuzaiCT {
    margin-left: .10rem;
    line-height: .35rem;
    display: inline-block;
  }
   .tuzaiBT {
    margin-left: .10rem;
    line-height: .30rem;
    /*display: inline-block;*/
    margin-top: .60rem;
  }
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