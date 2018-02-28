
// code by chenjunlml@163.com 
import {get, post, push} from './http'

function servive () {
	let myServices = {}
	
	// /////////////账号模块
	// 登录
	myServices._login = (req) => {
		return post('user/login',req)
	}
	//修改密码
	myServices._upDatePass = (req) => {
		return post('user/changePassword', req)
	}

	//退出登录
	myServices._logout= () => {
		return post('user/logout')
	}
	// ////////////业务模块
	// 查看图片信息
	myServices.findPic = () => {
		return get('image/findImage')
	}
	//新增修改图片
	myServices.updatePic= (req) => {
		return post('image/save',req)
	}
	//删除图片
	myServices.delPic= (req) => {
		return post('image/delete',req)
	}
	//图片上传
	myServices.uploadPic= (req) => {
		return post('upload/file',req)
	}
	
	
	//底部配置获取友情链接
	myServices.basicGetLink= () => {
		return post('websit/find/friendLinks')
//		return post('websit/find/friendLinks')
	}
	//底部配置获取以保存的数据
	myServices.basicGetAllMessage= () => {
		return get('websit/find/contactInfo')
	}
	//底部配置删除友情链接
	myServices.delbasicGetLink= (req) => {
		return post('websit/delete/friendLinks',req)
	}
	//底部配置获保存
	myServices.basicSaveMsg= (req) => {
		return push('websit/save/contactInfo',req)
	}
	
	//SEO配置获保存
	myServices.basicSEOSaveMsg= (req) => {
		return post('websit/save/seoInfo',req)
	}
	
	//SEO配置获取所有的数据
	myServices.getBasicSEOAllMsg= () => {
		return get('websit/find/seoInfo')
	}



	// //内容管理
	//新闻中心--查看新闻列表
	myServices._newsTable = (req) => {
		return post('news/findVos',req)
	}
	//新闻中心--新增新闻
	myServices._addNews = (req) => {
		return post('news/save',req)
	}
	//新闻中心--删除新闻
	myServices._deleteNews = (req) => {
		return post('news/delete',req)
	}
	//新闻中心--获取新闻详情
	myServices._getNewsDetails = (req) => {
		return post('news/findDetails',req)
	}
	//案例中心--获取案例类型
	myServices._getCaseType = (req) => {
		return post('aanvraag_type/findAll',req)
	}
	//案例中心--获取案例列表
	myServices._getCaseList = (req) => {
		return post('case/findByAanvraagTypeId',req)
	}
	//案例中心--新增案例
	myServices._addCase = (req) => {
		return post('case/save',req)
	}
	//案例中心--删除案例
	myServices._deleteCase = (req) => {
		return post('case/delete',req)
	}
	//新闻中心--获取案例详情
	myServices._getCaseDetails = (req) => {
		return post('case/findDetails',req)
	}
	//新增修改图片
	myServices.updatePic= (req) => {
		return post('image/save',req)
	}
	//删除图片
	myServices.delPic= (req) => {
		return push('image/delete',req)
	}
	//图片上传
	myServices.uploadPic= (req) => {
		return post('upload/file',req)
	}
//http://192.168.5.154:8080/zmt-ow/upload/file
	





	return myServices
}

export default servive


// WEBPACK FOOTER //
// ./src/server/myServer.js