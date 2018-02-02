//code by  chenjunlml@163.com
import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

//公共模块
///////////////账号模块
//登录页面
const Login = r => require.ensure([], () => r(require('@/components/account/Login')), 'Login')
//注册页面
const Register = r => require.ensure([], () => r(require('@/components/account/Register')), 'Register')
//找回密码
const FindPs = r => require.ensure([], () => r(require('@/components/account/FindPs')), 'FindPs')
//修改密码
const PulPs = r => require.ensure([], () => r(require('@/components/account/PulPs')), 'PulPs')
///////////////功能模块
/////////大盒子
const Main = r => require.ensure([], () => r(require('@/components/Main')), 'Main')
//主页
const Index = r => require.ensure([], () => r(require('@/components/marketing/Index')), 'Index')
//新建养殖户
const AddFarmers = r => require.ensure([], () => r(require('@/components/marketing/AddFarmers')), 'AddFarmers')
//地址管理
const AddressManer = r => require.ensure([], () => r(require('@/components/marketing/AddressManer')), 'AddressManer')
//个人中心
const PerCenter = r => require.ensure([], () => r(require('@/components/marketing/PerCenter')), 'PerCenter')
//建档记录
const ArchivalRecords = r => require.ensure([], () => r(require('@/components/marketing/ArchivalRecords')), 'ArchivalRecords')
//绑定手机
const BindPhone = r => require.ensure([], () => r(require('@/components/marketing/BindPhone')), 'BindPhone')
//资料录入
const DataInput = r => require.ensure([], () => r(require('@/components/marketing/DataInput')), 'DataInput')
//养殖户详情
const FarmersDetail = r => require.ensure([], () => r(require('@/components/marketing/FarmersDetail')), 'FarmersDetail')
//我的猪
const MyPig = r => require.ensure([], () => r(require('@/components/marketing/MyPig')), 'MyPig')
//修改手机
const PulPhone = r => require.ensure([], () => r(require('@/components/marketing/PulPhone')), 'PulPhone')
//记录详情
const RecordDetail = r => require.ensure([], () => r(require('@/components/marketing/RecordDetail')), 'RecordDetail')


//全部路由的名称
const myRouterList = [
  '/',
  'Login',
  'Register',
  'FindPs',
  'PulPs',
  'Main',
  'Index',
  'AddFarmers',
  'AddressManer',
  'PerCenter',
  'ArchivalRecords',
  'BindPhone',
  'DataInput',
  'FarmersDetail',
  'MyPig',
  'PulPhone',
  'RecordDetail',
]

const routes = [
  {
    path: '',
    redirect: '/Login'
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login
  },
  {
    path: '/FindPs',
    name: 'FindPs',
    component: FindPs
  },
  {
    path: '/PulPs',
    name: 'PulPs',
    component: PulPs
  },
  {
    path: '/Register',
    name: 'Register',
    component: Register
  },
  {
    path: '/Main',
    component: Main,
    children: [
      {
        path: '',
        redirect: '/Main/Index'
      },
      {
        path: '/Main/Index',
        name: 'Index',
        component: Index
      },
      {
        path: '/Main/AddFarmers',
        name: 'AddFarmers',
        component: AddFarmers
      },
      {
        path: '/Main/AddressManer',
        name: 'AddressManer',
        component: AddressManer
      },
      {
        path: '/Main/PerCenter',
        name: 'PerCenter',
        component: PerCenter
      },
      {
        path: '/Main/ArchivalRecords',
        name: 'ArchivalRecords',
        component: ArchivalRecords
      },
      {
        path: '/Main/BindPhone',
        name: 'BindPhone',
        component: BindPhone
      },
      {
        path: '/Main/DataInput',
        name: 'DataInput',
        component: DataInput
      },
      {
        path: '/Main/FarmersDetail',
        name: 'FarmersDetail',
        component: FarmersDetail
      },
      {
        path: '/Main/MyPig',
        name: 'MyPig',
        component: MyPig
      },
      {
        path: '/Main/PulPhone',
        name: 'PulPhone',
        component: PulPhone
      },
      {
        path: '/Main/RecordDetail',
        name: 'RecordDetail',
        component: RecordDetail
      }
    ]
  }
]

const myRouter = new Router({
  routes
})
myRouter.beforeEach((to, from, next) => {
  if(to.name === 'Login'){
    if(localStorage.getItem('userInfo')){
      next('/Main/Index')
      // myRouter.push({ name: 'Index' })
    }else {
      next()
    }
  }
  let canTo = false
  let fromName = from.name
  localStorage.setItem('router', from.path)
  let noBackRouter = ['BindPhone','PulPs','AddressManer','FindPs']
  noBackRouter.forEach(function(i){
    if(i === fromName){
      localStorage.setItem('router', '/Main/Index')
    }
  })
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