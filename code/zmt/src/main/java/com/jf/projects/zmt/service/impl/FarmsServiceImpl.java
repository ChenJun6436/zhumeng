package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.AndRoleResourceMapper;
import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.AndUserRoleMapper;
import com.jf.projects.zmt.dao.EntryAreaMapper;
import com.jf.projects.zmt.dao.FarmsMapper;
import com.jf.projects.zmt.dao.FodderMapper;
import com.jf.projects.zmt.dao.InspectinMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SDepartmentMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.AndUserArea;
import com.jf.projects.zmt.model.AndUserRole;
import com.jf.projects.zmt.model.Farms;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.AccountService;
import com.jf.projects.zmt.service.FarmsService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.MD5Util;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AddUserInfoVo;
import com.jf.projects.zmt.vo.account.AppAddUserInfoVo;
import com.jf.projects.zmt.vo.account.UserAreaVo;
import com.jf.projects.zmt.vo.department.DepartmentVo;
import com.jf.projects.zmt.vo.farms.AddFarmerUserInfo;
import com.jf.projects.zmt.vo.farms.AppFarmsVo;
import com.jf.projects.zmt.vo.farms.AppSearch;
import com.jf.projects.zmt.vo.farms.AppUpdateVo;
import com.jf.projects.zmt.vo.farms.FarmsInfo;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.farms.UserOfFarms;
import com.jf.projects.zmt.vo.fileManager.FileRecordVo;
import com.jf.projects.zmt.vo.fileManager.FileSearch;
import com.jf.projects.zmt.vo.role.RoleVo;
import com.jf.projects.zmt.vo.user.UserInfoVo;

@Service
public class FarmsServiceImpl implements FarmsService {
	@Autowired
	private FarmsMapper farmsMapper;
	@Autowired
	private PigFileMapper pFileMapper;
	@Autowired
	private AndRoleResourceMapper andRoleResourceMapper;
	@Autowired
	private SDepartmentMapper sDepartmentMapper;
	@Autowired
	private SUserMapper mapper;
	@Autowired
	private EntryAreaMapper entryMapper;
	@Autowired
	private AndUserAreaMapper userAreaMapper;
	@Autowired
	private FodderMapper fodderMapper;

	@Autowired
	private AndUserRoleMapper andUserRoleMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private InspectinMapper inspectinMapper;
	@Autowired
	private AccountService accountService;
	@Autowired
	private SUserMapper sUserMapper;
	@Autowired
	private PigFlowMapper pFlowMapper;

	@Override
	public ResponseVO findFarmsInfos(SerchVo search) {
		ResponseVO responseVO = new ResponseVO();
		long total = farmsMapper.countFarmsVos(search.getAccount(),
				search.getPhone(), search.getTypeId(),
				search.getDepartmentId(), search.getRoleId(),
				search.getKeyWords(), search.getFarmType());
		List<FarmsInfo> infos = farmsMapper.findFarmsVos(search.getAccount(),
				search.getPhone(), search.getTypeId(),
				search.getDepartmentId(), search.getRoleId(),
				search.getKeyWords(), search.getFarmType(), search.getStart(),
				search.getLength());

		if (infos != null) {
			for (FarmsInfo fInfo : infos) {
				fInfo.setAddress(userService.getAddressById(fInfo.getId()));
				fInfo.setTotal(pFileMapper.countFileOfFarmer(fInfo.getId()));
			}
		}
		responseVO.setData(infos);
		if (infos != null) {
			responseVO.setRecordsTotal(total);
			responseVO.setRecordsFiltered(total);
		}
		return responseVO;
	}

	@Override
	public ResponseVO deletePigFileByStatus(String sign) {
		ResponseVO responseVO = new ResponseVO();
		pFileMapper.deleteFileBySign(sign);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage("删除成功");
		return responseVO;
	}

	@Override
	public ResponseVO findFileByFarms(FileSearch fileSearch) {
		ResponseVO responseVO = new ResponseVO();
		List<FileRecordVo> list = pFileMapper.findFileByFarmerId(
				fileSearch.getUserId(), fileSearch.getKeyWords(),
				fileSearch.getStart(), fileSearch.getLength());
		responseVO.setData(list);
		long total = pFileMapper.countFileByFarmerId(fileSearch.getUserId(),
				fileSearch.getKeyWords());
		responseVO.setRecordsTotal(total);
		if (list != null) {
			responseVO.setRecordsTotal(total);
			responseVO.setRecordsFiltered(total);
		}
		return responseVO;
	}

	@Override
	public ResponseVO getFarmsByKeyWords(String keyWords) {
		ResponseVO responseVO = new ResponseVO();
		List<UserOfFarms> list = farmsMapper.findFarmsBykeywords(keyWords);
		if (list != null) {
			for (UserOfFarms userOfFarms : list) {
				userOfFarms.setAddress(userService.getAddressById(userOfFarms
						.getId()));
			}
		}
		responseVO.setData(list);
		if (list != null) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_NOT_EXIST_CODE);
			responseVO.setMessage("该用户不存在");

		}
		return responseVO;
	}

	@Override
	public ResponseVO findRoleVoByRource() {
		ResponseVO responseVO = new ResponseVO();
		List<RoleVo> list = andRoleResourceMapper
				.findRoleVoByResource("dp0002");
		responseVO.setData(list);
		return responseVO;
	}

	@Override
	public ResponseVO findDepartmentVoByRource() {
		ResponseVO responseVO = new ResponseVO();
		List<DepartmentVo> list = sDepartmentMapper
				.findDepartmentVoByResource("dp0002");
		responseVO.setData(list);
		return responseVO;
	}

	@Override
	public Integer addFarms(AddFarmerUserInfo vo) {

		SUser a = mapper.findUserByTel(vo.getTel(), null);
		if (a != null) {
			return 0;
		}

		// 将字符串转成list
		List<UserAreaVo> areaList = new ArrayList<UserAreaVo>();
		if (vo.getAreas().length() > 0) {
			JSONArray array = JSONArray.fromObject(vo.getAreas());
			for (int i = 0; i < array.size(); i++) {
				UserAreaVo userArea = new UserAreaVo();
				JSONObject jsonObject = array.getJSONObject(i);
				userArea.setAreaId(Integer.parseInt(jsonObject.get("areaId")
						.toString()));
				userArea.setAreaName(jsonObject.get("areaName").toString());
				userArea.setType(Integer.parseInt(jsonObject.get("type")
						.toString()));
				areaList.add(userArea);
			}
			vo.setAreaList(areaList);
		}

		SUser user = new SUser();
		Farms farms = new Farms();
		// Fodder fodder = new Fodder();
		user.setName(vo.getName());
		String id = UUIDUtil.getUUID();// 用户id
		String farmsId = UUIDUtil.getUUID();// 养殖场Id
		// sString feed = vo.getFeed();

		/*
		 * if (feed != null && feed.trim().length() != 0) {
		 * fodder.setId(UUIDUtil.getUUID());// 饲料id fodder.setFarmsId(farmsId);
		 * fodder.setName(feed); fodderMapper.insert(fodder); }
		 */

		farms.setFarmerId(id);
		farms.setId(farmsId);
		if (vo.getFeed() != null) {
			farms.setFood(vo.getFeed());
		}
		farms.setFarmsType(vo.getFarmType());

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
		user.setCreatorId(vo.getCurrentUserId());
		user.setId(id);
		mapper.insert(user);

		farmsMapper.insert(farms);
		if (vo.getAreaList() != null && vo.getAreaList().size() > 0) {
			// 添加用户区域管理关系
			for (UserAreaVo userArea : vo.getAreaList()) {
				// 获取区域名称
				AndUserArea and = new AndUserArea();
				and.setUserId(user.getId());
				and.setAreaId(userArea.getAreaId());
				and.setAreaName(userArea.getAreaName());
				and.setAreaType(userArea.getType());
				and.setCreator(vo.getCurrentUserId());
				and.setId(UUIDUtil.getUUID());
				userAreaMapper.insert(and);
			}
		}
		// 用户和角色关联表
		if (!StringUtils.isEmpty(vo.getRoleId())) {
			AndUserRole andUserRole = new AndUserRole();
			andUserRole.setUserId(user.getId());
			andUserRole.setRoleId(vo.getRoleId());
			andUserRole.setCreator(vo.getCurrentUserId());
			andUserRole.setId(UUIDUtil.getUUID());

			andUserRoleMapper.insert(andUserRole);
		}

		return 1;
	}

	@Override
	public Integer updateFarms(AddFarmerUserInfo vo) {
		SUser a = mapper.findUserByTel(vo.getTel(), vo.getUserId());
		if (a != null) {
			return 0;
		}
		inspectinMapper.clearInspectionUserAddress(vo.getUserId());
		SUser user = mapper.findById(vo.getUserId());
		Farms farms = new Farms();
		String feed2 = vo.getFeed();// 输入的饲料
		String farmId = farmsMapper.getFarmId(vo.getUserId());
		List<FileRecordVo> list = pFileMapper.findPigByFarmerId(vo.getUserId());
		Farms farms2 = farmsMapper.findById(farmId);// 获取该用户养殖的信息
		String feed = farms2.getFood();// 养殖户原有饲料
		Integer farmType = vo.getFarmType();
		farms.setId(farmId);
		farms.setFarmsType(farmType);
		farms.setFood(feed2);
		farmsMapper.update(farms);

		// Fodder fodder = new Fodder();
		/*
		 * if (feed != null && feed.trim().length() != 0) { String feedName =
		 * fodderMapper.getFodderInfo(farmId); if (feedName == null ||
		 * !feedName.trim().equals(feed.trim())) {
		 * fodderMapper.updateFodde(farmId); fodder.setFarmsId(farmId);
		 * fodder.setName(feed); fodder.setId(UUIDUtil.getUUID());
		 * fodderMapper.insert(fodder); } }
		 */
		user.setName(vo.getName());
		// user.setLoginName(vo.getLoginName());
		user.setTel(vo.getTel());
		user.setProvinceId(vo.getProvinceId());
		user.setCityId(vo.getCityId());
		user.setDistrictId(vo.getDistrictId());
		user.setTownId(vo.getTownId());
		user.setVillageId(vo.getVillageId());
		int flag = mapper.update(user);

		UserInfoVo uVo = sUserMapper.findUserInfoByUerId(vo.getCurrentUserId());
		uVo.setAddress(userService.getAddressById(vo.getCurrentUserId()));

		// 插入信息去流程表
		if (feed2 != null) {
			if (feed == null || !feed2.equals(feed)) {
				if (list != null) {
					for (FileRecordVo fileRecordVo : list) {
						if (uVo != null) {
							PigFlow pFlow = new PigFlow();
							pFlow.setCreaterName(uVo.getName());
							pFlow.setAddress(uVo.getAddress());
							pFlow.setId(UUIDUtil.getUUID());
							pFlow.setThing("喂养饲料");
							pFlow.setStatus("正常");
							pFlow.setDescription(feed2);
							pFlow.setPigId(fileRecordVo.getSign());
							pFlowMapper.insert(pFlow);
						}
					}
				}
			}
		}
		return flag;
	}

	@Override
	public ResponseVO findAppFarmsInfo(AppSearch vo) {
		String start = vo.getBeginDate();
		String end = vo.getEndDate();
		if (start != null) {
			vo.setBeginDate(start + " 00:00:00");
		}
		if (end != null) {
			vo.setEndDate(end + " 23:59:59");
		}
		List<AppFarmsVo> list = farmsMapper.appGetFarsmInfo(vo.getId(),
				vo.getBeginDate(), vo.getEndDate(), vo.getKeyWords());
		ResponseVO responseVO = new ResponseVO();
		if (list != null) {
			for (AppFarmsVo appFarmsVo : list) {
				appFarmsVo.setAddress(userService.getAddressById(appFarmsVo
						.getId()));
			}
		}
		responseVO.setData(list);
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

	@Override
	public Integer appAddFarmer(AppAddUserInfoVo vo) {
		String userId = accountService.AppAddFarmsUser(vo);// 用户id
		if (userId.equals("0")) {
			return 0;
		}
		Farms farms = new Farms();
		String farmsId = UUIDUtil.getUUID();// 养殖场Id
		String feed = vo.getFeed();// 饲料
		farms.setFood(feed);
		farms.setFarmerId(userId);
		farms.setId(farmsId);
		farms.setFarmsType(vo.getFarmType());
		int flag = farmsMapper.insert(farms);
		return flag;
	}

	@Override
	public ResponseVO appGetFarmerInfo(String id) {
		Farms farms = farmsMapper.appGetFarmInfo(id);
		ResponseVO responseVO = new ResponseVO();
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(farms);
		return responseVO;
	}

	@Override
	public ResponseVO appUpdateFarmer(AppUpdateVo vo) {
		ResponseVO responseVO = new ResponseVO();
		try {
			String id = farmsMapper.appGetIdByFarmerId(vo.getId());// farms主键
			Farms fm = farmsMapper.findById(id);
			String feed = fm.getFood();// 原有饲料
			AddUserInfoVo addUserInfoVo = new AddUserInfoVo();
			List<FileRecordVo> list = pFileMapper.findPigByFarmerId(vo.getId());// 获取该养殖户养殖的的生猪信息
			Farms farms = new Farms();
			// SUser sUser = new SUser();
			String feed2 = vo.getFood();// 输入的饲料
			farms.setId(id);
			farms.setFood(feed2);
			int flag = farmsMapper.update(farms);

			/*
			 * sUser.setId(vo.getId()); sUser.setName(vo.getName());
			 */
			addUserInfoVo.setUserId(vo.getId());
			addUserInfoVo.setName(vo.getName());

			// int flag2 = sUserMapper.update(sUser);
			int flag2 = accountService.update(addUserInfoVo);

			UserInfoVo uVo = sUserMapper.findUserInfoByUerId(vo.getId());
			uVo.setAddress(userService.getAddressById(vo.getId()));

			// 插入信息去流程表
			if (feed2 != null) {
				if (feed == null || !feed2.equals(feed)) {
					if (list != null) {
						for (FileRecordVo fileRecordVo : list) {
							if (uVo != null) {
								PigFlow pFlow = new PigFlow();
								pFlow.setCreaterName(uVo.getName());
								pFlow.setAddress(uVo.getAddress());
								pFlow.setId(UUIDUtil.getUUID());
								pFlow.setThing("喂养饲料");
								pFlow.setStatus("正常");
								pFlow.setDescription(feed2);
								pFlow.setPigId(fileRecordVo.getSign());
								pFlowMapper.insert(pFlow);
							}
						}
					}
				}
			}
			if (flag != 0 && flag2 != 0) {
				responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
				responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
				return responseVO;
			} else {
				responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
				responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
				return responseVO;
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return responseVO;
		}
	}
}
