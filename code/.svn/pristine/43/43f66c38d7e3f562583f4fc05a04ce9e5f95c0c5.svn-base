package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.AndInspectionUserMapper;
import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.AndUserRoleMapper;
import com.jf.projects.zmt.dao.InspectinMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.AndInspectionUser;
import com.jf.projects.zmt.model.AndUserArea;
import com.jf.projects.zmt.model.AndUserRole;
import com.jf.projects.zmt.model.Inspectin;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.InspectionService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.MD5Util;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.UserAreaVo;
import com.jf.projects.zmt.vo.inspection.AddInspectionUser;
import com.jf.projects.zmt.vo.inspection.InspectionListVo;
import com.jf.projects.zmt.vo.inspection.InspectionUserVo;
import com.jf.projects.zmt.vo.user.UserSearch;

@Service
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	private InspectinMapper inspectinMapper;
	@Autowired
	private SUserMapper mapper;

	@Autowired
	private AndUserAreaMapper userAreaMapper;
	@Autowired
	private AndUserRoleMapper andUserRoleMapper;
	@Autowired
	private AndInspectionUserMapper andInspectionUserMapper;
	@Autowired
	private UserService userService;

	@Override
	public ResponseVO findInspectionInfo(UserSearch uSearch) {
		List<InspectionListVo> list = inspectinMapper.findListByKeyWords(
				uSearch.getKey(), uSearch.getStart(), uSearch.getLength());
		long total = inspectinMapper.countInspection(uSearch.getKey());
		ResponseVO responseVO = new ResponseVO();
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(list);
		if (list.size() != 0) {
			responseVO.setRecordsFiltered(total);
			responseVO.setRecordsTotal(total);
		}
		return responseVO;
	}

	@Override
	public ResponseVO addInspection(Inspectin vo) {
		ResponseVO responseVO = new ResponseVO();
		vo.setId(UUIDUtil.getUUID());
		vo.setStatus(ConstantsUtil.STATUS_ENABLE);
		int flag = inspectinMapper.insert(vo);
		if (flag == 1) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}

		return responseVO;
	}

	@Override
	public int addInspectionUser(AddInspectionUser vo) {

		SUser a = mapper.findUserByTel(vo.getTel(), null);
		if (a != null) {
			return 0;
		}
		String id = UUIDUtil.getUUID();
		// 将字符串转成list
		List<UserAreaVo> areaList = new ArrayList<UserAreaVo>();
		if (vo.getAreas() != null) {
			if (vo.getAreas().length() > 0) {
				JSONArray array = JSONArray.fromObject(vo.getAreas());
				for (int i = 0; i < array.size(); i++) {
					UserAreaVo userArea = new UserAreaVo();
					JSONObject jsonObject = array.getJSONObject(i);
					userArea.setAreaId(Integer.parseInt(jsonObject
							.get("areaId").toString()));
					userArea.setAreaName(jsonObject.get("areaName").toString());
					userArea.setType(Integer.parseInt(jsonObject.get("type")
							.toString()));
					areaList.add(userArea);
				}
				vo.setAreaList(areaList);
			}
		}
		SUser user = new SUser();
		user.setName(vo.getName());

		// 账号随机数
		String str = new Date().getTime() + "";
		str = str.substring(5);
		user.setLoginName("JD" + str);
		user.setPassword(MD5Util.MD5("ZMT123456"));
		user.setTel(vo.getTel());
		user.setTypeId(vo.getTypeId());
		user.setDepartmentId(vo.getDepartmentId());
		user.setStatus("enable");
		user.setProvinceId(vo.getProvinceId());
		user.setCityId(vo.getCityId());
		user.setDistrictId(vo.getDistrictId());
		user.setTownId(vo.getTownId());
		user.setVillageId(vo.getVillageId());
		user.setCreatorId(vo.getCurrentUserId());// TODO 获取当前登录用户
		user.setId(id);
		mapper.insert(user);
		if (vo.getAreaList() != null && vo.getAreaList().size() > 0) {
			// 添加用户区域管理关系
			for (UserAreaVo userArea : vo.getAreaList()) {
				// 获取区域名称
				AndUserArea and = new AndUserArea();
				and.setUserId(user.getId());
				and.setAreaId(userArea.getAreaId());
				and.setAreaName(userArea.getAreaName());
				and.setAreaType(userArea.getType());
				and.setCreator(vo.getCurrentUserId());// TODO 当前登录用户
				and.setId(UUIDUtil.getUUID());
				userAreaMapper.insert(and);
			}
		}
		// 用户和角色关联表
		if (!StringUtils.isEmpty(vo.getRoleId())) {
			AndUserRole andUserRole = new AndUserRole();
			andUserRole.setUserId(user.getId());
			andUserRole.setRoleId(vo.getRoleId());
			andUserRole.setCreator(vo.getCurrentUserId());// TODO 当前用户
			andUserRole.setId(UUIDUtil.getUUID());

			andUserRoleMapper.insert(andUserRole);
		}
		if (!StringUtils.isEmpty(vo.getInspectionId())) {
			// 添加用户与检疫中心关系
			AndInspectionUser aUser = new AndInspectionUser();
			aUser.setId(UUIDUtil.getUUID());
			aUser.setUserId(id);
			aUser.setInspectionId(vo.getInspectionId());
			andInspectionUserMapper.insert(aUser);
		}
		return 1;
	}

	@Override
	public ResponseVO findInspectionUserInfo(UserSearch userSearch) {
		ResponseVO responseVO = new ResponseVO();
		List<InspectionUserVo> list = inspectinMapper.findInspectionUserInfo(
				userSearch.getKey(), userSearch.getId(), userSearch.getStart(),
				userSearch.getLength());
		if (list != null) {
			for (InspectionUserVo inspectionUserVo : list) {
				inspectionUserVo.setAddress(userService
						.getAddressById(inspectionUserVo.getId()));
			}
		}
		long total = inspectinMapper.countInspectionUserInfo(
				userSearch.getKey(), userSearch.getId());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);

		responseVO.setData(list);
		responseVO.setRecordsFiltered(total);
		responseVO.setRecordsTotal(total);

		return responseVO;
	}

	@Override
	public ResponseVO startOrForbid(String id, String status) {
		ResponseVO responseVO = new ResponseVO();
		if (status.equals("enable")) {
			status = "disable";
		} else if (status.equals("disable")) {
			status = "enable";
		}

		int flag = inspectinMapper.startOrForbid(id, status);
		if (flag == 1) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	@Override
	public ResponseVO updateInspection(Inspectin vo) {
		inspectinMapper.clearInspectionAddress(vo.getId());
		int flag = inspectinMapper.update(vo);
		ResponseVO responseVO = new ResponseVO();
		if (flag == 1) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	@Override
	public int updateInspectionUser(SUser vo) {
		SUser a = mapper.findUserByTel(vo.getTel(), vo.getId());
		if (a != null) {
			return 0;
		}
		inspectinMapper.clearInspectionUserAddress(vo.getId());
		int flag = mapper.update(vo);
		return flag;
	}
}
