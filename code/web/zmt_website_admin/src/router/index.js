import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

//登录页面
import Login from '@/components/account/Login'

//忘记密码
import ForgetPass from '@/components/account/ForgetPass'

import Main from '@/components/Main'
//图片管理
import PictureManage from '@/components/marketing/PictureManage'
//案例中心
import CaseCenter from '@/components/marketing/CaseCenter'
//基础配置
import BasicConfiguration from '@/components/marketing/BasicConfiguration'
//新闻中心
import NewsCenter from '@/components/marketing/NewsCenter'
//新闻编辑
import NewsEditor from '@/components/marketing/NewsEditor'
import CaseList from '@/components/marketing/CaseList'
import CaseEditor from '@/components/marketing/CaseEditor'
Vue.use(Router)

// 公用模块的
// const Login = r=>require.ensure([], () => r(require('@/components/account/Login')), 'Login')

// //全部路由的名称
// const myRouterList =[
//   '/',
//   'Login'

// ]

export default new Router({
  routes: [
    {
      path: '/',
      redirect: 'Login'
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/ForgetPass',
      name: 'ForgetPass',
      component: ForgetPass
    },{
      path:'Main',
      component:Main,
      children:[{
        path:'',
        redirect: '/Main/PictureManage'
      }
      ,{
        path:'/Main/PictureManage',
        name:'PictureManage',
        component:PictureManage
      }
      ,{
        path:'/Main/CaseCenter',
        name:'CaseCenter',
        component:CaseCenter
      },{
        path:'/Main/BasicConfiguration',
        name:'BasicConfiguration',
        component:BasicConfiguration
      },{
        path:'/Main/NewsCenter',
        name:'NewsCenter',
        component:NewsCenter
      },{
        path:'/Main/NewsEditor',
        name:'NewsEditor',
        component:NewsEditor
      },{
        path:'/Main/CaseList',
        name:'CaseList',
        component:CaseList
      },{
        path:'/Main/CaseEditor',
        name:'CaseEditor',
        component:CaseEditor
      }
      ]
    }
  ]
})
