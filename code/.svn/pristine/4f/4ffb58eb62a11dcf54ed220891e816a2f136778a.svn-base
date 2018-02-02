package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.FileManagerZMTService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.fileManager.FileBuliderVo;

@Controller
@RequestMapping("/manger")
public class FileManagerController {

	@Autowired
	private FileManagerZMTService fileManagerService;
	@Autowired
	private BrandService brandService;

	/**
	 * 查找建档者
	 * 
	 * @param serchVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/fileManger", method = RequestMethod.POST)
	public ResponseVO getFileManager(SerchVo serchVo) {
		return fileManagerService.findFileBuilders(serchVo);
	}

	/**
	 * 禁止或者启动用户
	 * 
	 * @param userId
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/forbidOrStart/byStatus", method = RequestMethod.POST)
	public ResponseVO forbidOrstart(@RequestParam("userId") String userId,
			@RequestParam("status") String status) {
		return fileManagerService.forbidOrStartBuilder(userId, status);
	}

	/**
	 * 查找某一个建档者建立的档案
	 * 
	 * @param userId
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findFile/bybuildId", method = RequestMethod.POST)
	public ResponseVO getFileBySign(FileBuliderVo vo) {
		return fileManagerService.findFileByBuildersId(vo);
	}

	/**
	 * 激活标签
	 * 
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activeSign/byStatus", method = RequestMethod.POST)
	public ResponseVO activeBrand(@RequestParam("sign") String sign,
			@RequestParam("userId") String userId) {
		return brandService.activeBrandBySign(sign, userId);
	}

	/**
	 * 删除激活的标签
	 * 
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteSign/byStatus", method = RequestMethod.POST)
	public ResponseVO deleteSign(@RequestParam("sign") String sign) {
		return brandService.deleteBrandBySign(sign);
	}

	@ResponseBody
	@RequestMapping(value = "role/byResource", method = RequestMethod.POST)
	public ResponseVO getRoleOfBulider() {
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO = fileManagerService.findRoleVoByRource();
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	@ResponseBody
	@RequestMapping(value = "department/byResource", method = RequestMethod.POST)
	public ResponseVO getDepartmentOfBulider() {
		ResponseVO responseVO = new ResponseVO();
		try {
			responseVO = fileManagerService.findDepartmentVoByRource();
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	/**
	 * 修改检疫人员信息
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update/user", method = RequestMethod.POST)
	public ResponseVO updateInspectionUser(SUser vo) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int falg = fileManagerService.updateBuliderUser(vo);
			if (falg == 1) {
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
				responseVO.setData(falg);
			} else {
				responseVO.setData(falg);
				responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
				responseVO.setMessage("电话号码已注册");
			}
		} catch (Exception e) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}
}
