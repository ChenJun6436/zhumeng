package com.jf.projects.zmt.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.BrandMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.Brand;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.service.BrandService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.fileManager.AppBrandVo;
import com.jf.projects.zmt.vo.user.UserInfoVo;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private PigFlowMapper pFlowMapper;
	@Autowired
	private SUserMapper sUserMapper;
	@Autowired
	private PigFileMapper pMapper;
	@Autowired
	private UserService userService;

	@Override
	public ResponseVO activeBrandBySign(String sign, String userId) {
		ResponseVO responseVO = new ResponseVO();
		PigFlow pFlow = new PigFlow();
		Brand brand = brandMapper.findBrand(sign);
		if (brand == null) {
			responseVO.setCode(ConstantsUtil.SIGN_NOT_EXIXT);
			responseVO.setMessage("该标签不存在");

		} else {
			int flag = brandMapper.findBrandStatus(sign);
			if (flag == 1) {
				responseVO.setCode(ConstantsUtil.SIGN_ACTIVE_STRING);
				responseVO.setMessage("该标签已经被激活");
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateString = formatter
						.format(System.currentTimeMillis());
				brandMapper.activeBrand(sign, userId, dateString);
				UserInfoVo uVo = sUserMapper.findUserInfoByUerId(userId);
				uVo.setAddress(userService.getAddressById(userId));
				if (uVo != null) {
					pFlow.setCreaterName(uVo.getName());
					pFlow.setAddress(uVo.getAddress());
					pFlow.setId(UUIDUtil.getUUID());
					pFlow.setStatus("正常");
					pFlow.setThing("建号");
					pFlow.setPigId(sign);
					pFlowMapper.insert(pFlow);
				}
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage("激活成功");
			}
		}
		return responseVO;
	}

	@Override
	public ResponseVO deleteBrandBySign(String sign) {
		int flag = brandMapper.deleteSign(sign);
		ResponseVO responseVO = new ResponseVO();
		if (flag == 1) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode("-1");
			responseVO.setMessage("删除失败");
		}

		return responseVO;
	}

	@Override
	public ResponseVO findSignDetail(String sign) {
		PigFile pigFile = pMapper.findPigfileBySign(sign);
		Brand brand = brandMapper.findBrand(sign);
		ResponseVO responseVO = new ResponseVO();
		if (brand == null) {
			responseVO.setCode(ConstantsUtil.SIGN_NOT_EXIXT);
			responseVO.setMessage("标签不存在");
			return responseVO;
		} else {
			int flag = brandMapper.findBrandStatus(sign);
			if (flag == 0) {
				responseVO.setCode(ConstantsUtil.SIGN_NOT_ACTIVE);
				responseVO.setMessage("标签未被激活");
				return responseVO;
			}
		}
		if (pigFile != null) {
			responseVO.setCode(ConstantsUtil.SIGN_TO_USE);
			responseVO.setMessage("标签不能使用");
			return responseVO;
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("createrId", brand.getCreaterId());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(map);
		return responseVO;
	}

	@Override
	public ResponseVO appFindBrandInfo(AppSearch vo) {
		ResponseVO responseVO = new ResponseVO();
		String start = vo.getBeginDate();
		String end = vo.getEndDate();
		if (start != null) {
			vo.setBeginDate(start + " 00:00:00");
		}
		if (end != null) {
			vo.setEndDate(end + " 23:59:59");
		}
		List<AppBrandVo> list = brandMapper.findAppBrandInfoByCreater(
				vo.getId(), vo.getBeginDate(), vo.getEndDate(),
				vo.getKeyWords());
		responseVO.setData(list);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}
}
