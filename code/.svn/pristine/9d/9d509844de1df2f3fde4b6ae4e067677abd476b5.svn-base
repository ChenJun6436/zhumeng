// code by chenjunlml@163.com 
import {get, post, push, post_OLD, post_OLD_a} from './http'

function servive () {
	let myServices = {}
	// /////////////账号模块
	// // 注册用户
	// myServices._register = (req) => {
	// 	return post('/user/register',req)
	// }
	// // 获取验证码
	// myServices._getCode = (req) => {
	// 	return post('/user/getCode',req)
	// }	
	// 登录
	// myServices._login = (req) => {
	// 	return post('sign/userbase/appLogin',req)
	// }
	// //修改密码
	// myServices._pulPs = (req) => {
	// 	return post('sign/userbase/updatePassword', req)
	// }
	// ////////////业务模块
	// 获取生猪品种数据
	myServices.getPigType= (req) => {
		return post('pig/getPigType', req)
	}
	//获取生猪品种top5
	myServices.getPigTop5= (req) => {
		return post('pig/getPigTop5',req)
	}
	//获取总览数据
	myServices.getAllData= (req) => {
		return post('pig/getOverview',req)
	}
	//获取养殖户占比
	myServices.countCulture= (req) => {
		return post('culture/countCulture',req)
	}
	//获取本月销售重量排名
	myServices.saleTop5= (req) => {
		return post('market/sale/top5',req)
	}
	//获取一年生猪总数与屠宰数折线图数据，当前月显示在最后
	myServices.pigAndKill= (req) => {
		return post('find/pig_and_slaughter_for_year',req)
	}
	//获取本月屠宰top榜
	myServices.slaughterTop5= (req) => {
		return post('find/slaughter/top5',req)
	}
	//获取地址  
	myServices.getAddress= (req) => {
		return post('user/getArea',req)
	}
	//获取地址  
	myServices.getAddressName= (req) => {
		return post_OLD_a('area/find_ids_by_district',req)
	}
	// //////个人中心
	// 修改养殖户信息
	myServices._updateFarm= (req) => {
		return post('/farms/update', req)
	}
	//验证手机号
	myServices._verifyCheckCode= (req) => {
		return post('sign/userbase/verifyCheckCode', req)
	}
	//修改手机号
	myServices._resetTel= (req) => {
		return post('sign/userbase/resetTel', req)
	}
	//获取验证码
	myServices._getCode = (req) => {
		return post('sign/userbase/sendVerifyCode',req)	
	}
	//忘记密码
	myServices._resetPassword = (req) => {
		return post('sign/userbase/resetPassword',req)	
	}
	//修改地址
	myServices._pulAddress= (req) => {
		return post('account/manage/app_update_address', req)
	}
	//获取省份
	myServices._getProvince= () => {
		return post_OLD('area/find_province_option')
	}
	//获取市
	myServices._getCity= (req) => {
		return post_OLD('area/find_city_option',req)
	}
	//获取县
	myServices._getDistrict= (req) => {
		return post_OLD('area/find_district_option',req)
	}
	//获取镇
	myServices._getTown= (req) => {
		return post_OLD('entry_area/find_town_option',req)
	}
	//获取村
	myServices._getVillage= (req) => {
		return post_OLD('entry_area/find_village_option',req)
	}
	//查询个人信息
	myServices._getUserInfo= (req) => {
		return post('account/manage/find_info_by_id',req)
	}
	//获取饲料和用户类型
	myServices._getFarmerInfo= (req) => {
		return post('farms/app/geInfo/farmer', req)
	}
	//修改养殖户饲料和名字
	myServices._pulFarmerInfo= (req) => {
		return post('farms/app/update/farmer', req)
	}
	//登录
	myServices._login= (req) => {
		return post('user/login',req)
	}





	return myServices
}

export default servive


// WEBPACK FOOTER //
// ./src/server/myServer.js