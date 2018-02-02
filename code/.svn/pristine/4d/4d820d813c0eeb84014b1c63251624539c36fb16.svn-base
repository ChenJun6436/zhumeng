// code by chenjunlml@163.com 
import {get, post, push} from './http'

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
	myServices._login = (req) => {
		return post('sign/userbase/appLogin',req)
	}
	//修改密码
	myServices._pulPs = (req) => {
		return post('sign/userbase/updatePassword', req)
	}
	// ////////////业务模块
	// 新建生猪
	myServices._createFile= (req) => {
		return post('file/createFile', req)
	}
	//判断生猪状态
	myServices._pigStatus= (req) => {
		return post('file/app/getDetail',req)
	}
	//生猪种类
	myServices._pigType= () => {
		return get('pig_breed/getByEnable')
	}
	//取消养殖
	myServices._cancelBreed= (req) => {
		return post('file/app/cancel',req)
	}
	//生猪死亡
	myServices._pigDie= (req) => {
		return post('file/app/updateDied',req)
	}
	//搜索养殖户
	myServices._searchFamer= (req) => {
		return post('file/getFarms',req)
	}
	//我的猪
	myServices._myPig= (req) => {
		return post('file/app/farmer/getPig',req)
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
		return post('area/find_province_option')
	}
	//获取市
	myServices._getCity= (req) => {
		return post('area/find_city_option',req)
	}
	//获取县
	myServices._getDistrict= (req) => {
		return post('area/find_district_option',req)
	}
	//获取镇
	myServices._getTown= (req) => {
		return post('entry_area/find_town_option',req)
	}
	//获取村
	myServices._getVillage= (req) => {
		return post('entry_area/find_village_option',req)
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
	// //退出登录
	// myServices._logout= () => {
	// 	return post('/user/logout')
	// }





	return myServices
}

export default servive


// WEBPACK FOOTER //
// ./src/server/myServer.js