import Vue from 'vue'
import Router from 'vue-router'

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
///////首页
import PigDetail from '@/components/marketing/Pig_Detail'
///////屠宰场设置
////生猪入场
import PigInList from '@/components/marketing/PigIn_List'
////销售商、供应商
import Distributor from '@/components/marketing/Distributor'
import Distributor_Add from '@/components/marketing/Distributor_Add'
import Supplier from '@/components/marketing/Supplier'
////检验人员
import Inspector from '@/components/marketing/Inspector'
////猪舍管理
import Pigsty from '@/components/marketing/Pigsty'
import Pigsty_Add from '@/components/marketing/Pigsty_Add'
import Pigsty_List from '@/components/marketing/Pigsty_List'
import Pigsty_History from '@/components/marketing/Pigsty_History'
////屠宰
import Slaughter from '@/components/marketing/Slaughter'
import SlaughterHistory from '@/components/marketing/Slaughter_History'
//销售
import SaleList from '@/components/marketing/Sale_List'
import SaleAdd from '@/components/marketing/Sale_Add'
import SaleEditor from '@/components/marketing/Sale_Editor'
////报损
import LossList from '@/components/marketing/Loss_List'
import LossAdd from '@/components/marketing/Loss_Add'
import LossEditor from '@/components/marketing/Loss_Editor'
////检验
import TestList from '@/components/marketing/Test_List'
import TestAdd from '@/components/marketing/Test_Add'
import TestEditor from '@/components/marketing/Test_Editor'
import TestEditorDetail from '@/components/marketing/Test_Editor_Detail'

////子账号管理
import Subaccount from '@/components/marketing/Subaccount' 
import Subaccount_Add from '@/components/marketing/Subaccount_Add' 
import Subaccount_Account from '@/components/marketing/Subaccount_Account'
import Subaccount_Company from '@/components/marketing/Subaccount_Company'
////账号管理
import Account_Safe from '@/components/marketing/Account_Safe'
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
      redirect: '/Main/Subaccount_Company'
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
      },
      ,{
        path:'/Main/PigDetail',
        name:'PigDetail',
        component:PigDetail
      },
      {
        path:'/Main/Distributor',
        name:'Distributor',
        component:Distributor
      },
      {
        path:'/Main/Distributor_Add/:type',
        name:'Distributor_Add',
        component:Distributor_Add
      },
      {
        path:'/Main/Supplier',
        name:'Supplier',
        component:Supplier
      },
      {
        path:'/Main/Inspector',
        name:'Inspector',
        component:Inspector
      },
      {
        path:'/Main/Pigsty',
        name:'Pigsty',
        component:Pigsty
      },
      {
        path:'/Main/Pigsty_Add/:type',
        name:'Pigsty_Add',
        component:Pigsty_Add
      },
      {
        path:'/Main/Pigsty_List',
        name:'Pigsty_List',
        component:Pigsty_List
      },
      {
        path:'/Main/Pigsty_History',
        name:'Pigsty_History',
        component:Pigsty_History
      },
      {
        path:'/Main/Slaughter',
        name:'Slaughter',
        component:Slaughter
      },
      {
        path:'/Main/SlaughterHistory',
        name:'SlaughterHistory',
        component:SlaughterHistory
      },
      {
        path:'/Main/Subaccount',
        name:'Subaccount',
        component:Subaccount
      },
      {
        path:'/Main/Subaccount_Add',
        name:'Subaccount_Add',
        component:Subaccount_Add
      },
      {
        path:'/Main/Subaccount_Account',
        name:'Subaccount_Account',
        component:Subaccount_Account
      },
      {
        path:'/Main/Subaccount_Company',
        name:'Subaccount_Company',
        component:Subaccount_Company
      },
      {
        path:'/Main/Account_Safe',
        name:'Account_Safe',
        component:Account_Safe
      },
      {
        path:'/Main/LossList',
        name:'LossList',
        component:LossList
      },
      {
        path:'/Main/LossAdd',
        name:'LossAdd',
        component:LossAdd
      },
      {
        path:'/Main/LossEditor',
        name:'LossEditor',
        component:LossEditor
      },
      {
        path:'/Main/TestList',
        name:'TestList',
        component:TestList
      },
      {
        path:'/Main/TestAdd',
        name:'TestAdd',
        component:TestAdd
      },
      {
        path:'/Main/TestEditor',
        name:'TestEditor',
        component:TestEditor
      },
      {
        path:'/Main/TestEditorDetail',
        name:'TestEditorDetail',
        component:TestEditorDetail
      },
      {
        path:'/Main/SaleList',
        name:'SaleList',
        component:SaleList
      },
      {
        path:'/Main/SaleAdd',
        name:'SaleAdd',
        component:SaleAdd
      }, 
      {
        path:'/Main/SaleEditor',
        name:'SaleEditor',
        component:SaleEditor
      }, 
      {
        path:'/Main/PigInList',
        name:'PigInList',
        component:PigInList
      }, 
      {
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
