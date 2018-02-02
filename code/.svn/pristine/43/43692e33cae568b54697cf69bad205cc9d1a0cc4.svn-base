package com.jf.projects.zmt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.BrandMapper;
import com.jf.projects.zmt.dao.FarmsMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.Brand;
import com.jf.projects.zmt.model.Farms;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.farms.AppFileOfFamerVo;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.fileManager.CreateFileVo;
import com.jf.projects.zmt.vo.fileManager.FileRecordVo;
import com.jf.projects.zmt.vo.fileManager.FileSearch;
import com.jf.projects.zmt.vo.user.UserInfoVo;

@Service
public class PigFileServiceImpl implements PigFileService {

	@Autowired
	private PigFileMapper pFileMapper;

	@Autowired
	private SUserMapper sMapper;

	@Autowired
	private PigFlowMapper pFlowMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private FarmsMapper farmsMapper;
	@Autowired
	private BrandMapper brandMapper;

	@Override
	public int savePigFile(CreateFileVo cVo) {
		String sign = pFileMapper.getPigFile(cVo.getSign());
		if (sign != null) {
			return 0;
		}
		PigFile pigFile = new PigFile();
		PigFlow pFlow = new PigFlow();
		pigFile.setId(UUIDUtil.getUUID());
		pigFile.setPigId(cVo.getSign());
		pigFile.setFamerId(cVo.getFamerId());
		pigFile.setPigType(cVo.getPigType());
		pigFile.setCreatePeopleId(cVo.getCreatePeopleId());
		pigFile.setMark(cVo.getMark());
		pigFile.setPigStatus(0);
		UserInfoVo uVo = sMapper.findUserInfoByUerId(cVo.getCreatePeopleId());
		uVo.setAddress(userService.getAddressById(cVo.getCreatePeopleId()));
		String farmId = farmsMapper.getFarmId(cVo.getFamerId());// 获取养殖场id
		Farms farms2 = farmsMapper.findById(farmId);// 获取该用户养殖的信息
		String food = null;
		if (farms2 != null) {
			food = farms2.getFood();// 获取该用户养殖的饲料
		}
		if (uVo != null) {
			pFlow.setCreaterName(uVo.getName());
			pFlow.setAddress(uVo.getAddress());
			pFlow.setId(UUIDUtil.getUUID());
			pFlow.setThing("开始养殖");
			pFlow.setStatus("正常");
			pFlow.setUserId(cVo.getFamerId());
			pFlow.setType("1");
			pFlow.setDescription("生猪与标签绑定");
			pFlow.setPigId(cVo.getSign());
			pFlowMapper.insert(pFlow);
		}
		if (food != null) {
			PigFlow pFlow2 = new PigFlow();
			pFlow2.setCreaterName(uVo.getName());
			pFlow2.setAddress(uVo.getAddress());
			pFlow2.setId(UUIDUtil.getUUID());
			pFlow2.setThing("喂养饲料");
			pFlow2.setStatus("正常");
			pFlow2.setDescription(food);
			pFlow2.setPigId(cVo.getSign());
			pFlowMapper.insert(pFlow2);
		}
		int flag = pFileMapper.insert(pigFile);
		return flag;
	}

	@Override
	public ResponseVO getFile(FileSearch fileSearch) {
		ResponseVO responseVO = new ResponseVO();
		List<FileRecordVo> list = pFileMapper.findFileByFarmerId(
				fileSearch.getUserId(), fileSearch.getKeyWords(),
				fileSearch.getStart(), fileSearch.getLength());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setData(list);
		if (fileSearch.getUserId() != null && fileSearch.getKeyWords() != null) {
			if (list.size() == 0) {
				responseVO.setMessage("没有生猪档案");
				return responseVO;
			}
		}
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	@Override
	public ResponseVO deleteFileBySign(String sign) {
		ResponseVO responseVO = new ResponseVO();
		int flag = pFileMapper.deleteFileBySign(sign);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		if (flag != 0) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		}
		return responseVO;
	}

	@Override
	public boolean updateStatus(String pigId, Integer status) {
		try {
			PigFile p = new PigFile();
			p.setPigId(pigId);
			p.setPigStatus(status);
			p.setUpdateTime(new Date());
			return pFileMapper.updateStatus(p) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return false;
		}
	}

	@Override
	public boolean updateAllByPigId(PigFile p) {
		try {
			return pFileMapper.updateAllByPigId(p) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			return false;
		}
	}

	@Override
	public boolean existPigId(String pigId) {
		return pFileMapper.existPigId(pigId);
	}

	@Override
	public ResponseVO appFindFileOfFamer(AppSearch vo) {
		String start = vo.getBeginDate();
		String end = vo.getEndDate();
		if (start != null) {
			vo.setBeginDate(start + " 00:00:00");
		}
		if (end != null) {
			vo.setEndDate(end + " 23:59:59");
		}
		List<AppFileOfFamerVo> list = pFileMapper.appFindFileOfFamer(
				vo.getId(), vo.getKeyWords(), vo.getBeginDate(),
				vo.getEndDate(), vo.getPigType(), vo.getPigStatus());
		ResponseVO responseVO = new ResponseVO();
		responseVO.setData(list);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	@Override
	public ResponseVO appFarmerCancelPig(String id, String famerId,
			Integer pigStatus, String sign, String currentUserId) {
		PigFile pigFile = new PigFile();// 转让流程
		PigFlow pf = new PigFlow();// 转让人饲料插入流程
		String address = userService.getAddressById(famerId);// 转让养殖户地址
		String fid = farmsMapper.getFarmId(famerId);
		ResponseVO responseVO = new ResponseVO();
		pigFile.setId(id);
		pigFile.setFamerId(famerId);
		PigFlow pigFlow = new PigFlow();
		pigFlow.setId(UUIDUtil.getUUID());
		pigFlow.setThing("生猪转让");
		pigFlow.setPigId(sign);
		pigFlow.setStatus("正常");
		pigFlow.setAddress(address);
		StringBuffer sb = new StringBuffer();
		sb.append("生猪从");
		UserInfoVo uVo = sMapper.findUserInfoByUerId(currentUserId);// 获取原有养殖户信息
		UserInfoVo uVo2 = sMapper.findUserInfoByUerId(famerId);// 获取转让养殖户信息
		Farms farms2 = farmsMapper.findById(fid);// 获取该用户养殖的信息

		if (uVo != null) {
			pigFlow.setCreaterName(uVo.getName());
			sb.append(uVo.getName());
		}
		if (uVo2 != null) {
			sb.append("转让到").append(uVo2.getName());
			pf.setAddress(address);
			pf.setCreaterName(uVo2.getName());
		}
		pigFlow.setDescription(sb.toString());
		if (pigStatus != 0) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage("该生猪不能转让");
			return responseVO;
		} else {
			int flag = pFileMapper.update(pigFile);
			if (flag != 0) {
				pFlowMapper.insert(pigFlow);// 插入流程表
				if (farms2 != null) {
					if (farms2.getFood() != null) {
						pf.setId(UUIDUtil.getUUID());
						pf.setThing("喂养饲料");
						pf.setPigId(sign);
						pf.setStatus("正常");
						pf.setDescription(farms2.getFood());
						pFlowMapper.insert(pf);// 插入流程
					}
				}
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
				return responseVO;
			}
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;
		}
	}

	@Override
	public ResponseVO appUpdatePigFileStatus(String id, Integer pigStatus,
			String currentUserId) {
		PigFile pigFile = new PigFile();
		PigFlow pigFlow = new PigFlow();
		PigFile file = pFileMapper.findById(id);
		if (file != null) {
			pigFlow.setPigId(file.getPigId());
		}
		pigFlow.setId(UUIDUtil.getUUID());
		pigFlow.setThing("生猪死亡");

		pigFlow.setStatus("死亡");
		pigFlow.setDescription("在养殖中死亡");
		pigFlow.setAddress(userService.getAddressById(currentUserId));
		UserInfoVo uVo = sMapper.findUserInfoByUerId(currentUserId);
		if (uVo != null) {
			pigFlow.setCreaterName(uVo.getName());
			pigFlow.setAddress(userService.getAddressById(currentUserId));
		}
		ResponseVO responseVO = new ResponseVO();
		if (pigStatus != 0) {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage("该生猪状态不可修改");
			return responseVO;
		}
		pigFile.setId(id);
		pigFile.setPigStatus(1);
		int flag = pFileMapper.update(pigFile);
		if (flag != 0) {
			pFlowMapper.insert(pigFlow);// 插入流程表
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			return responseVO;
		}
		responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
		responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		return responseVO;
	}

	@Override
	public PigFile findPigfileBySign(String sign) {
		return pFileMapper.findPigfileBySign(sign);
	}

	@Override
	public ResponseVO appGetDetail(String sign, String id) {
		Map<String, String> map = new HashMap<String, String>();
		List<PigFile> pigFile = pFileMapper.appGetFile(sign, id);
		PigFile pfFile = pFileMapper.findPigfileBySign(sign);
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
		if (pigFile != null && pigFile.size() != 0) {
			if (pigFile.get(0).getPigStatus() != 0) {
				responseVO.setCode("-4");
				responseVO.setMessage("生猪已完成养殖或已死亡");
			} else if (pigFile.get(0).getPigStatus() == 0) {
				responseVO.setCode("1");
				responseVO.setMessage("该标签可以修改");
				map.put("fileId", pigFile.get(0).getId());
				map.put("status ", "0");
				responseVO.setData(map);
			}
			return responseVO;
		}
		if (pfFile != null) {
			responseVO.setCode(ConstantsUtil.SIGN_TO_USE);
			responseVO.setMessage("标签已被他人使用");
			return responseVO;
		}

		map.put("createrId", brand.getCreaterId());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(map);
		return responseVO;
	}
}
