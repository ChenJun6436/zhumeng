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
//销售录入
const SalesEntry = r => require.ensure([], () => r(require('@/components/marketing/SalesEntry')), 'SalesEntry')
//地址管理
const AddressMan = r => require.ensure([], () => r(require('@/components/marketing/AddressManer')), 'AddressManer')
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
//报告详情
const ReportDetails = r => require.ensure([], () => r(require('@/components/marketing/ReportDetails')), 'ReportDetails')

//全部路由的名称
const myRouterList = [
  '/',
  'Login',
  'Register',
  'FindPs',
  'PulPs',
  'Main',
  'Index',
  'SalesEntry',
  'AddressMan',
  'PerCenter',
  'ArchivalRecords',
  'BindPhone',
  'DataInput',
  'FarmersDetail',
  'MyPig',
  'PulPhone',
  'RecordDetail',
  'ReportDetails'
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
        path: '/Main/SalesEntry',
        name: 'SalesEntry',
        component: SalesEntry
      },
      {
        path: '/Main/AddressMan',
        name: 'AddressMan',
        component: AddressMan
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
      },
      {
        path: '/Main/ReportDetails',
        name: 'ReportDetails',
        component: ReportDetails
      }
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
  // if(from.name !== 'Login'){
  //   if(to.name)
  // }
  // console.log(to)
  // console.log(from)
  // console.log(next)
})

export default myRouter





// WEBPACK FOOTER //
// ./src/router/index.js