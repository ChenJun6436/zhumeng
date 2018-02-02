package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.FarmsService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AppAddUserInfoVo;
import com.jf.projects.zmt.vo.farms.AddFarmerUserInfo;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.farms.AppUpdateVo;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.fileManager.FileSearch;

@Controller
@RequestMapping("/farms")
public class FarmsController {
	@Autowired
	private FarmsService farmsService;
	@Autowired
	private BrandService brandService;

	/**
	 * 查找养殖户信息
	 * 
	 * @param serchVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getfarmsInfo", method = RequestMethod.POST)
	public ResponseVO findFarms(SerchVo serchVo) {
		ResponseVO responseVO = farmsService.findFarmsInfos(serchVo);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	/**
	 * 逻辑删除养殖户领养的生猪
	 * 
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFile/bySign", method = RequestMethod.POST)
	public ResponseVO deletePigFile(String sign) {
		return farmsService.deletePigFileByStatus(sign);
	}

	/**
	 * 养猪户领养的生猪
	 * 
	 * @param fileSearch
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findFile/byFarms", method = RequestMethod.POST)
	public ResponseVO getPigFileByFarmsId(FileSearch fileSearch) {
		ResponseVO responseVO = null;

		try {
			responseVO = farmsService.findFileByFarms(fileSearch);
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setCode(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * 养殖户对应的角色
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "role/byResource", method = RequestMethod.POST)
	public ResponseVO getRoleOfBulider() {
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO = farmsService.findRoleVoByRource();
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * 养殖户对应的部门
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "department/byResource", method = RequestMethod.POST)
	public ResponseVO getDepartmentOfBulider() {
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO = farmsService.findDepartmentVoByRource();
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * 新增养殖户
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseVO addFarms(AddFarmerUserInfo vo) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int flag = farmsService.addFarms(vo);
			if (flag == 1) {
				responseVO.setData(flag);
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			} else {
				responseVO.setData(flag);
				responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
				responseVO.setMessage("该电话号码系统已存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * 养殖户输入标签判断该表示是否可用
	 * 
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/detail/sign", method = RequestMethod.POST)
	public ResponseVO getDetailSign(String sign) {
		return brandService.findSignDetail(sign);
	}

	/**
	 * 修改养殖户
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseVO updateFarms(AddFarmerUserInfo vo) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int flag = farmsService.updateFarms(vo);
			if (flag != 0) {
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			} else {
				responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
				responseVO.setMessage("电话号码已注册");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * APP端获取当前用户创建的养猪户
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "app/getFarmer", method = RequestMethod.POST)
	public ResponseVO appGetFarmsInfo(AppSearch vo) {
		return farmsService.findAppFarmsInfo(vo);
	}

	/**
	 * app端新增养殖户
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "app/addFarmer", method = RequestMethod.POST)
	public ResponseVO appAddFarmer(AppAddUserInfoVo vo) {
		ResponseVO responseVO = new ResponseVO();
		int falg = farmsService.appAddFarmer(vo);
		if (falg != 0) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage("电话号码已被使用");
		}
		return responseVO;
	}

	@ResponseBody
	@RequestMapping(value = "app/geInfo/farmer", method = RequestMethod.POST)
	public ResponseVO appGetOnlyFarmer(
			@RequestParam(value = "id", required = true) String id) {
		return farmsService.appGetFarmerInfo(id);
	}

	@ResponseBody
	@RequestMapping(value = "app/update/farmer", method = RequestMethod.POST)
	public ResponseVO appUpdateFarmer(AppUpdateVo vo) {
		return farmsService.appUpdateFarmer(vo);
	}
}
