package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.AndCheckoutPigMapper;
import com.jf.projects.zmt.dao.AndMarketUserMapper;
import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.AndUserRoleMapper;
import com.jf.projects.zmt.dao.AreaMapper;
import com.jf.projects.zmt.dao.EntryAreaMapper;
import com.jf.projects.zmt.dao.FarmsMapper;
import com.jf.projects.zmt.dao.InspectinMapper;
import com.jf.projects.zmt.dao.PigCheckMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.SRoleMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.AndUserArea;
import com.jf.projects.zmt.model.AndUserRole;
import com.jf.projects.zmt.model.Area;
import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.AccountService;
import com.jf.projects.zmt.util.MD5Util;
import com.jf.projects.zmt.util.SendNoteUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.account.AccountInfoVo;
import com.jf.projects.zmt.vo.account.AccountSearchVo;
import com.jf.projects.zmt.vo.account.AccountVo;
import com.jf.projects.zmt.vo.account.AddUserInfoVo;
import com.jf.projects.zmt.vo.account.AppAddUserInfoVo;
import com.jf.projects.zmt.vo.account.UserAreaVo;
import com.jf.projects.zmt.vo.area.AppUpdateAddressVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private SUserMapper mapper;
	
	@Autowired
	private EntryAreaMapper entryMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private AndUserAreaMapper userAreaMapper;
	
	@Autowired
	private AndUserRoleMapper andUserRoleMapper;
	
	@Autowired
	private AndSlaughterhouseUserMapper asuMapper;
	
	@Autowired
	private FarmsMapper farmMapper;
	
	@Autowired
	private PigCheckMapper checkMapper;
	
	@Autowired
	private PigFileMapper fileMapper;
	
	@Autowired
	private SRoleMapper roleMapper;
	
	@Autowired
	private AndMarketUserMapper amuMapper;
	
	@Autowired
	private AndCheckoutPigMapper acpMapper;
	
	@Autowired
	private InspectinMapper inspecMapper;

	@Override
	public ResponseVO findPage(AccountSearchVo search) {
		List<AccountVo> list = new ArrayList<AccountVo>();
		long total = mapper.findTotal(search);
		if(total > 0){
			list = mapper.findPageByUser(search);
		}
		return new ResponseVO(total,total,list);
	}

	@Override
	public AccountInfoVo findInfoById(String id) {
		AccountInfoVo vo = mapper.findInfoById(id);
		if(vo != null){
			//获取村
			EntryArea vill = entryMapper.findById(vo.getVillageId());
			if(vill != null){
				vo.setVillage(vill.getVillage());
			}
			
			EntryArea town = entryMapper.findById(vo.getTownId());
			if(town != null){
				vo.setTown(town.getTown());
			}
			
			Area district = areaMapper.findById(vo.getDistrictId());
			if(district != null) vo.setDistrict(district.getDistrict());
			
			Area city = areaMapper.findById(vo.getCityId());
			if(city != null) vo.setCity(city.getCity());
			
			Area pro = areaMapper.findById(vo.getProvinceId());
			if(pro != null) vo.setProvince(pro.getProvince());
			
			//获取村列表
			vo.setVillageIdList(entryMapper.getVillageOption(vo.getTownId()));
			//获取乡镇列表
			vo.setTownList(entryMapper.getTownOption(vo.getDistrictId()));
			//获取区县列表
			vo.setDistrictList(areaMapper.findDistrictOption(vo.getCityId()));
			//获取市列表
			vo.setCityList(areaMapper.findCityOption(vo.getProvinceId()));
			//获取省列表
			vo.setProvinceList(areaMapper.findProvinceOption());
		}
		return vo;
	}

	@Override
	public List<UserAreaVo> findAreaByUserId(String userId) {
		List<UserAreaVo> list = new ArrayList<UserAreaVo>();
		list = userAreaMapper.findUserArea(userId);
		
		for(UserAreaVo vo : list){//根据当前城市获取上级城市id
			if(vo.getType()  == 5){//村
				vo.setVillageId(vo.getAreaId());
				EntryArea entry = entryMapper.findById(vo.getAreaId());
				vo.setTownId(entry.getParent());
				vo.setDistrictId(entry.getDistrictId());
				Area area = areaMapper.findById(entry.getDistrictId());
				vo.setCityId(area.getParent());
				Area city = areaMapper.findById(area.getParent());
				vo.setProvinceId(city.getParent());
			}else if(vo.getType()  == 4){//乡镇
				vo.setTownId(vo.getAreaId());
				EntryArea entry = entryMapper.findById(vo.getAreaId());
				vo.setDistrictId(entry.getDistrictId());
				Area area = areaMapper.findById(entry.getDistrictId());
				vo.setCityId(area.getParent());
				Area city = areaMapper.findById(area.getParent());
				vo.setProvinceId(city.getParent());
			}else if(vo.getType()  == 3){//区县
				vo.setDistrictId(vo.getAreaId());
				Area area = areaMapper.findById(vo.getAreaId());
				vo.setCityId(area.getParent());
				vo.setProvinceId(areaMapper.findById(area.getParent()).getParent());
			}else if(vo.getType()  == 2){//市
				vo.setCityId(vo.getAreaId());
				vo.setProvinceId(areaMapper.findById(vo.getAreaId()).getParent());
			}else if(vo.getType()  == 1){//省
				vo.setProvinceId(vo.getAreaId());
			}
		}
		
		return list;
	}
	
	@Override
	public String add(AddUserInfoVo vo) {
		
		SUser a = mapper.findUserByTel(vo.getTel(), null);
		if(a != null){
			return 0+"";
		}
		try{
			//将字符串转成list
			List<UserAreaVo> areaList = new ArrayList<UserAreaVo>();
			if(vo.getAreas().length() > 0){
				JSONArray array = JSONArray.fromObject(vo.getAreas());
				for(int i=0;i<array.size();i++){
					UserAreaVo userArea = new UserAreaVo();
					JSONObject jsonObject = array.getJSONObject(i);
					userArea.setAreaId(Integer.parseInt(jsonObject.get("areaId").toString()));
					userArea.setAreaName(jsonObject.get("areaName").toString());
					userArea.setType(Integer.parseInt(jsonObject.get("type").toString()));
					areaList.add(userArea);
				}
				vo.setAreaList(areaList);
			}
			
			SUser user = new SUser();
			user.setName(vo.getName());
			
			//账号随机数
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
			user.setId(UUIDUtil.getUUID());
			mapper.insert(user);
			if(vo.getAreaList() != null && vo.getAreaList().size() > 0){
				//添加用户区域管理关系
				for(UserAreaVo userArea : vo.getAreaList()){
					//获取区域名称
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
			//用户和角色关联表
			if(!StringUtils.isEmpty(vo.getRoleId())){
				AndUserRole andUserRole = new AndUserRole();
				andUserRole.setUserId(user.getId());
				andUserRole.setRoleId(vo.getRoleId());
				andUserRole.setCreator(vo.getCurrentUserId());
				andUserRole.setId(UUIDUtil.getUUID());
				andUserRoleMapper.insert(andUserRole);
			}else{
				return "角色id不能为空";
			}
			return user.getId();
		}catch (Exception e) {
			//手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "添加失败!";
		}
		
	}

	@Override
	public Integer update(AddUserInfoVo vo) {
		SUser a = mapper.findUserByTel(vo.getTel(), vo.getUserId());
		if(a != null){
			return 0;
		}
		//清空用户表用户之前的地址
		if(!StringUtils.isEmpty(vo.getProvinceId())){//判断是否是修改地址
			inspecMapper.clearInspectionUserAddress(vo.getUserId());
		}
		SUser user = mapper.findById(vo.getUserId());
		if(!StringUtils.isEmpty(vo.getName())) user.setName(vo.getName());
		if(!StringUtils.isEmpty(vo.getTel())) user.setTel(vo.getTel());
		if(!StringUtils.isEmpty(vo.getTypeId())) user.setTypeId(vo.getTypeId());
		if(!StringUtils.isEmpty(vo.getDepartmentId())) user.setDepartmentId(vo.getDepartmentId());
		if(!StringUtils.isEmpty(vo.getProvinceId())) user.setProvinceId(vo.getProvinceId());
		if(!StringUtils.isEmpty(vo.getCityId())) user.setCityId(vo.getCityId());
		if(!StringUtils.isEmpty(vo.getDistrictId())) user.setDistrictId(vo.getDistrictId());
		if(!StringUtils.isEmpty(vo.getTownId())) user.setTownId(vo.getTownId());
		if(!StringUtils.isEmpty(vo.getVillageId())) user.setVillageId(vo.getVillageId());
		
		mapper.update(user);
		
		//将字符串转成list
		List<UserAreaVo> areaList = new ArrayList<UserAreaVo>();
		if(vo.getAreas() != null && vo.getAreas().length() > 0){
			JSONArray array = JSONArray.fromObject(vo.getAreas());
			for(int i=0;i<array.size();i++){
				UserAreaVo userArea = new UserAreaVo();
				JSONObject jsonObject = array.getJSONObject(i);
				userArea.setAreaId(Integer.parseInt(jsonObject.get("areaId").toString()));
				userArea.setAreaName(jsonObject.get("areaName").toString());
				userArea.setType(Integer.parseInt(jsonObject.get("type").toString()));
				areaList.add(userArea);
			}
			vo.setAreaList(areaList);
		}
		
		if(vo.getAreaList() != null && vo.getAreaList().size() > 0){
			//删除用户管理区域数据
			userAreaMapper.deleteByUserId(user.getId());
			
			//添加用户区域管理关系
			for(UserAreaVo userArea : vo.getAreaList()){
				//获取区域名称
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
		
		
		
		//用户和角色关联表
		if(!StringUtils.isEmpty(vo.getRoleId())){
		  //删除用户角色关联
	        andUserRoleMapper.deleteByUserId(vo.getUserId());
	        
			AndUserRole andUserRole = new AndUserRole();
			andUserRole.setUserId(vo.getUserId());
			andUserRole.setRoleId(vo.getRoleId());
			andUserRole.setCreator(vo.getCurrentUserId());
			andUserRole.setId(UUIDUtil.getUUID());
			
			andUserRoleMapper.insert(andUserRole);
		}
		
		return 1;
	}

	@Override
	public Integer updateStatus(String userId) {
		SUser user = mapper.findById(userId);
		if("enable".equals(user.getStatus())){//禁用
			user.setStatus("disable");
			mapper.update(user);
		}else{
			user.setStatus("enable");
			mapper.update(user);
		}
		return 1;
	}

	@Override
	public String delete(String userId) {
		
		//判断删除账号是否为管理员
//		SRole role = roleMapper.findRoleByUserId(userId);
//		if("admin".equals(role.getCode())){
//			return "不能对管理员账号做操作!";
//		}
		
		//如果该用户已被使用则不可删除
		int asu = asuMapper.findCountByUser(userId);
		if(asu > 0){//屠宰场
			return "该账号已在屠宰场使用，不能删除!";
		}
		String str = farmMapper.getFarmId(userId);
		if(!StringUtils.isEmpty(str)){//养殖场
			return "该账号已在养殖场使用，不能删除!";
		}
		int check = checkMapper.countByUserId(userId);
		if(check > 0){//生猪检查
			return "该账号已在生猪检查使用，不能删除!";
		}
		int file = fileMapper.countFile(userId);
		if(file > 0){//生猪建档
			return "该账号已在生猪建档使用，不能删除!";
		}
		int market = amuMapper.findCountByUser(userId);
		if(market > 0){//市场人员
			return "该账号已在市场人员使用，不能删除!";
		}
		int checkout = acpMapper.findCountByUserId(userId);
		if(checkout > 0){
			return "该账号已在使用，不能删除";
		}
		SUser user = mapper.findUserByCreateId(userId);
		if(user != null){
			return "该账号下有创建用户，不能删除";
		}
		
		String inspec = inspecMapper.ExitUser(userId);
		if(inspec != null){
			return "该账号已在检验中心使用，不能删除!";
		}
		
		//删除用户区域表数据
		userAreaMapper.deleteByUserId(userId);
		//删除用户角色数据
		andUserRoleMapper.deleteByUserId(userId);
		//删除屠宰场数据
		asuMapper.deleteByUserId(userId);
		//删除用户表数据
		mapper.delete(userId);
		
		return "ok";
	}

	@Override
	public String restPwd(String userId) {
		SUser user = mapper.findById(userId);
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
		boolean flag = Pattern.matches(regex, user.getTel());
		if(flag){
			user.setPassword(MD5Util.MD5("ZMT123456"));
			mapper.update(user);
			SendNoteUtil.sendNoteMessage(user.getTel(), "密码重置成功，新登录密码为：ZMT123456");
			return null;
		}else{
			return "当前用户手机号码不正确";
		}
	}

	@Override
	public String AppAddFarmsUser(AppAddUserInfoVo userInfo) {
		//判断电话号码是否存在
		SUser a = mapper.findUserByTel(userInfo.getTel(), null);
		if(a != null){
			return 0+"";
		}
		
		//获取用户管辖区域
		Integer areaId = null;//区域id
		String areaName = null;//区域名字
		Integer areaType = null;//1->省级2->市级3->区级,4-乡镇级，5-村级
		while(true){
			if(!StringUtils.isEmpty(userInfo.getVillageId())){//村
				EntryArea entry = entryMapper.findById(userInfo.getVillageId());
				areaId = entry.getId();
				areaName = entry.getVillage();
				areaType = 5;
				break;
			}
			if(!StringUtils.isEmpty(userInfo.getTownId())){//乡镇
				EntryArea entry = entryMapper.findById(userInfo.getTownId());
				areaId = entry.getId();
				areaName = entry.getTown();
				areaType = 4;
				break;
			}
			if(!StringUtils.isEmpty(userInfo.getDistrictId())){//区县
				Area area = areaMapper.findById(userInfo.getDistrictId());
				areaId = area.getId();
				areaName = area.getDistrict();
				areaType = 3;
				break;
			}
			break;
		}
		
		SUser user = new SUser();
		user.setName(userInfo.getName());
		//账号随机数
		String str = new Date().getTime() + "";
		str = str.substring(5);
		user.setLoginName("JD" + str);
		user.setPassword(MD5Util.MD5("ZMT123456"));
		user.setStatus("enable");
		user.setTel(userInfo.getTel());
		
		user.setProvinceId(userInfo.getProvinceId());
		user.setCityId(userInfo.getCityId());
		user.setDistrictId(userInfo.getDistrictId());
		user.setTownId(userInfo.getTownId());
		user.setVillageId(userInfo.getVillageId());
		
		//获取角色、部门、类型id 角色在数据库已存在的角色code为yzadmin的数据
		SRole role = roleMapper.findRoleByCode("yzadmin");
		
		user.setTypeId(role.getTypeId());
		user.setDepartmentId(role.getDepartmentId());
		user.setCreatorId(userInfo.getCurrentUserId());
		user.setId(UUIDUtil.getUUID());
		mapper.insert(user);
		
		//用户角色关联
		AndUserRole andUserRole = new AndUserRole();
		andUserRole.setUserId(user.getId());
		andUserRole.setRoleId(role.getId());
		andUserRole.setCreator(userInfo.getCurrentUserId());
		andUserRole.setId(UUIDUtil.getUUID());
		andUserRoleMapper.insert(andUserRole);
		
		//用户管理区域范围
		AndUserArea and = new AndUserArea();
		and.setUserId(user.getId());
		and.setAreaId(areaId);
		and.setAreaName(areaName);
		and.setAreaType(areaType);
		and.setCreator(userInfo.getCurrentUserId());
		and.setId(UUIDUtil.getUUID());
		userAreaMapper.insert(and);
		
		return user.getId();
	}

	@Override
	public String verifyUserById(String userId) {
		SUser user = mapper.findById(userId);
		if(user == null){
			return "您的账号已被删除，请联系管理员";
		}
		if("disable".equals(user.getStatus())){
			return "您的账号已被禁用，请联系管理员";
		}
		return "ok";
	}

	@Override
	public Integer AppUpdateAddress(AppUpdateAddressVo vo) {
		SUser user = mapper.findById(vo.getUserId());
		if(user == null){
			return 0;
		}
		user.setProvinceId(vo.getProvinceId());
		user.setCityId(vo.getCityId());
		user.setDistrictId(vo.getDistrictId());
		user.setTownId(vo.getTownId());
		user.setVillageId(vo.getVillageId());
		mapper.update(user);
		return 1;
	}
}
