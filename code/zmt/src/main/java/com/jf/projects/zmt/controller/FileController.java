package com.jf.projects.zmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.FarmsService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.fileManager.CreateFileVo;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private PigFileService pService;
	@Autowired
	private FarmsService farmsService;
	@Autowired
	private BrandService brandService;

	/**
	 * 建立生猪档案
	 * 
	 * @param createFileVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/createFile", method = RequestMethod.POST)
	public ResponseVO createFile(CreateFileVo createFileVo) {
		int flag = pService.savePigFile(createFileVo);
		ResponseVO responseVO = new ResponseVO();
		if (flag != 0) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage("该标签已经被使用");
		}

		return responseVO;
	}

	/**
	 * 逻辑删除档案
	 * 
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseVO deleteFile(String sign) {
		return pService.deleteFileBySign(sign);
	}

	/**
	 * 在建档是=时候搜索养殖户信息
	 * 
	 * @param keyWords
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getFarms", method = RequestMethod.POST)
	public ResponseVO findFarmsBykeyWords(
			@RequestParam("keyWords") String keyWords) {
		return farmsService.getFarmsByKeyWords("%" + keyWords + "%");
	}

	/**
	 * app端得到当前用户激活标签信息
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/getFile", method = RequestMethod.POST)
	public ResponseVO appFindBrand(AppSearch vo) {
		return brandService.appFindBrandInfo(vo);
	}

	/**
	 * app端查找某一个养殖户养的生猪
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/farmer/getPig", method = RequestMethod.POST)
	public ResponseVO appGetPigByFarmer(AppSearch vo) {
		return pService.appFindFileOfFamer(vo);
	}

	/**
	 * app端修在生猪正常的状态下修改生猪为死亡状态
	 * 
	 * @param id
	 * @param pigStatus
	 * @param currentUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/updateDied", method = RequestMethod.POST)
	public ResponseVO appPigDied(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "pigStatus", required = true) Integer pigStatus,
			@RequestParam(value = "currentUserId", required = true) String currentUserId) {
		return pService.appUpdatePigFileStatus(id, pigStatus, currentUserId);
	}

	/**
	 * app端养殖户取消养殖转让给其他养殖户
	 * 
	 * @param id
	 * @param famerId
	 * @param pigStatus
	 * @param sign
	 * @param currentUserId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/cancel", method = RequestMethod.POST)
	public ResponseVO appCancelPig(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "famerId", required = true) String famerId,
			@RequestParam(value = "pigStatus", required = true) Integer pigStatus,
			@RequestParam(value = "sign", required = true) String sign,
			@RequestParam(value = "currentUserId", required = true) String currentUserId) {
		return pService.appFarmerCancelPig(id, famerId, pigStatus, sign,
				currentUserId);

	}

	/**
	 * app端查找该标签详情
	 * 
	 * @param id
	 * @param sign
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/getDetail", method = RequestMethod.POST)
	public ResponseVO appGetDetail(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "sign", required = true) String sign) {
		return pService.appGetDetail(sign, id);
	}
}
