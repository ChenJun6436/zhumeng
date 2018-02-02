// code by chenjunlml@163.com 
import {get, post, push} from './http'

function servive () {
	let myServices = {}
	// 


	// 获取验证码
	myServices._getCode = (req) => {
		return post('sign/userbase/sendVerifyCode',req)	
	}
	//忘记密码
	myServices._resetPassword = (req) => {
		return post('sign/userbase/resetPassword',req)	
	}
	
	// 登录
	myServices._login = (req) => {
		return post('sign/userbase/appLogin',req)
	}
	//判断生猪是否可以录入
	myServices._existPig= (req) => {
		return post('sign/and_slaughter_house/exist_pig',req)
	}
	//屠宰生猪
	myServices._slaughter= (req) => {
		return post('sign/and_slaughter_house/slaughter',req)
	}
	//我的猪
	myServices._myPig= (req) => {
		return post('sign/and_slaughter_house/find_pigs',req)
	}
	//市场流行
	myServices._market= (req) => {
		return post('sign/market/find_com_list_key',req)
	}
	//市场人员
	myServices._maketPersons= (req) => {
		return post('sign/and_market_user/get_maket_persons',req)
	}
	//销售录入
	myServices._salesEntry= (req) => {
		return post('sign/and_market_user/add',req)
	}
	//根据生猪id判断是否可以市场录入
	myServices._exist= (req) => {
		return post('sign/and_market_user/exist',req)
	}

//	//公用地址
//	myServices._myImgUrl = () => {
//		return 'http://192.168.5.154:8080/coupon/file/upload'
//	}
//	//长传优惠券的地址
//	myServices._myEditorImgUrl = () => {
//		return 'http://192.168.5.154:8080/coupon/file/uploadByCoupon'
//	}
//	// /////////////账号模块
//	// 注册用户
//	myServices._register = (req) => {
//		return post('/user/register',req)
//	}
	
//	//修改密码
//	myServices._upDatePass = (req) => {
//		return post('/user/updatePass', req)
//	}
//	// ////////////业务模块
//	// 查询数据字典
//	myServices._findDic = () => {
//		return get('/dic/findDic')
//	}
//	//查询全部优惠券
//	myServices._getCoupon= (req) => {
//		return post('/coupon/getCoupon',req)
//	}
//	//新增优惠券
//	myServices._postCoupon= (req) => {
//		return push('/coupon/save',req)
//	}
//	//查询数据分析
//	myServices._getCouponData= (req) => {
//		return post('/coupon/findAnalysis',req)
//	}
//	//停止活动
//	myServices._postCouponStop= (req) => {
//		return post('/coupon/shutdown',req)
//	}
//	//查询优惠券信息详情 + 搜索
//	myServices._getCouponCustomer= (req) => {
//		return post('customer/findCustomer',req)
//	}
//	//查询活动详情
//	myServices._getCouponDetail= (req) => {
//		return post('/coupon/findDetail',req)
//	}
//	//////个人中心
//	//个人中心查询信息
//	myServices._getPerson= () => {
//		return get('/user/findInfo')
//	}
//	//上传头像
//	myServices._postHeader= (req) => {
//		return post('/file/upload', req)
//	}
//	//修改用户信息
//	myServices._postPerson= (req) => {
//		return post('/user/updateInfo', req)
//	}
//	//查询区域
//	myServices._getAddress= (req) => {
//		return post('/area/findByPid', req)
//	}
//	//回显区域
//	myServices._getAddressPid= (req) => {
//		return post('/area/findParent', req)
//	}



	return myServices
}

export default servive


// WEBPACK FOOTER //
// ./src/server/myServer.js