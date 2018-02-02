import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

//公共模块
///////////////账号模块
//登录页面
const Login = r => require.ensure([], () => r(require('@/components/account/Login')), 'Login')

///////////////功能模块
///大盒子
const Main = r => require.ensure([], () => r(require('@/components/Main')), 'Main')
const Discount = r => require.ensure([], () => r(require('@/components/marketing/Discount')), 'Discount')
const DataAnalysis = r => require.ensure([], () => r(require('@/components/marketing/DataAnalysis')), 'DataAnalysis')

//全部路由的名称
const myRouterList = [
  '/',
  'Login',
  'Main',
  'Discount',
  'LookDiscount',
  'DataAnalysis',
]

const routes = [
  {
    path: '/Login',
    name: 'Login',
    component: Login
  },
  {
    path: '/',
    redirect: '/Login'
  },
  {
    path: '/Main',
    component: Main,
    children: [
      {
        path: '/',
        redirect: '/Main/DataAnalysis'
      },
      {
        path: '/Main/Discount',
        name: 'Discount',
        component: Discount
      },   
      {
        path: '/Main/DataAnalysis',
        name: 'DataAnalysis',
        component: DataAnalysis
      },
    ]
  }
]

const myRouter = new Router({
  routes
})
myRouter.beforeEach((to, from, next) => {
  //限制路由跳转到空白页面
  let canTo = false
  myRouterList.forEach(function (i){
    if(i === to.name){
      canTo = true
    }
  })
  if(!canTo){
    next(false)
  }else{
    next()
  }
})

export default myRouter





// WEBPACK FOOTER //
// ./src/router/index.js