package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.AreaMapper;
import com.jf.projects.zmt.dao.EntryAreaMapper;
import com.jf.projects.zmt.model.Area;
import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.service.AreaService;
import com.jf.projects.zmt.service.EntryAreaService;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.account.UserAreaVo;
import com.jf.projects.zmt.vo.area.ZtreeVo;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper mapper;
	@Autowired
	private EntryAreaService entryService;
	@Autowired
	private EntryAreaMapper entryMapper;
	@Autowired
	private AndUserAreaMapper userAreaMapper;

	@Override
	public List<Integer> getDistrictIds(Integer id) {
		List<Integer> cityIds = new ArrayList<Integer>();
		cityIds.add(id);
		List<Integer> districtIds = this.getAllDistrictIds(cityIds, new ArrayList<Integer>());
		return districtIds;
	}
	
	//迭代器 根据省市区任意id 获取该id下所有的区县id
	private List<Integer> getAllDistrictIds(List<Integer> cityIds,List<Integer> districtIds){
		for(Integer id : cityIds){
			List<Area> list = mapper.findByParent(id);
			List<Integer> ids = new ArrayList<Integer>();
			for(Area area : list){
				ids.add(area.getId());
			}
			if(list != null && list.size() > 1){
				this.getAllDistrictIds(ids,districtIds);
			}else{
				districtIds.add(id);
			}
		}
		return districtIds;
	}

	@Override
	public List<OptionVo> findProvinceOption() {
		
		return mapper.findProvinceOption();
	}

	@Override
	public List<OptionVo> findCityOption(Integer provId) {
		Area area = mapper.findById(provId);
		String code = area.getCode().substring(2, 6);
		List<OptionVo> cityList = new ArrayList<OptionVo>();
		if("0000".equals(code) && !StringUtils.isEmpty(area.getCity())){//直辖市
			OptionVo vo = new OptionVo();
			vo.setKey(area.getId().toString());
			vo.setValue(area.getCity());
			cityList.add(vo);
			return cityList;
		}else{
			return mapper.findCityOption(provId);
		}
	}

	@Override
	public List<OptionVo> findDistrictOption(Integer cityId) {
		
		return mapper.findDistrictOption(cityId);
	}

	@Override
	public List<ZtreeVo> findTree(Integer id, Integer type,String userId) {
		List<Integer> userArea = null;
		Integer userAreaType = 0;
		List<ZtreeVo> list = new ArrayList<ZtreeVo>();
		//首次加载 ，根据用户id获取用户管辖范围
		if(id == null && type == null){
			userArea = new ArrayList<Integer>();
			List<UserAreaVo> userAreaVos = userAreaMapper.findUserArea(userId.toString());
			for(UserAreaVo vo : userAreaVos){
				userArea.add(vo.getAreaId());
				userAreaType = vo.getType();
			}
		}
		//判断是初次加载页面 还是 根据id获取下一层级
		if(id == null && type == null){//首次加载
			//判断首次进入，根据用户管辖区域获取数据，存在多个城市情况。根据当前用户管理区域获取id的城市
			if(id == null && type == null && userAreaType == 1){
				List<OptionVo> options = mapper.findProByList(userArea);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(1);
					List<OptionVo> citys = this.findCityOption(Integer.valueOf(vo.getKey()));
					if(citys.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(id == null && type == null && userAreaType == 2){
				List<OptionVo> options = mapper.findCityByList(userArea);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(2);
					List<OptionVo> districts = this.findDistrictOption(Integer.valueOf(vo.getKey()));
					if(districts.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(id == null && type == null && userAreaType == 3){
				List<OptionVo> options = mapper.findDisByList(userArea);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(3);
					List<OptionVo> towns = entryService.getTownOption(Integer.valueOf(vo.getKey()));
					if(towns.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(id == null && type == null && userAreaType == 4){
				List<OptionVo> options = entryMapper.findTownByList(userArea);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(4);
					List<OptionVo> villages = entryService.getVillageOption(Integer.valueOf(vo.getKey()));
					if(villages.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(id == null && type == null && userAreaType == 5){
				List<OptionVo> options = entryMapper.findVillByList(userArea);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(5);
					ztree.setLean(false);
					list.add(ztree);
				}
			}
		}else{
			type ++;
			
			if(type == 1){//省
				List<OptionVo> options = this.findProvinceOption();
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(1);
					List<OptionVo> citys = this.findCityOption(Integer.valueOf(vo.getKey()));
					if(citys.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(type == 2){//市
				List<OptionVo> options = this.findCityOption(id);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(2);
					List<OptionVo> districts = this.findDistrictOption(Integer.valueOf(vo.getKey()));
					if(districts.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(type == 3){//区县
				List<OptionVo> options = this.findDistrictOption(id);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(3);
					List<OptionVo> towns = entryService.getTownOption(Integer.valueOf(vo.getKey()));
					if(towns.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(type == 4){//乡镇
				List<OptionVo> options = entryService.getTownOption(id);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(4);
					List<OptionVo> villages = entryService.getVillageOption(Integer.valueOf(id));
					if(villages.size() > 0){
						ztree.setLean(true);
					}else{
						ztree.setLean(false);
					}
					list.add(ztree);
				}
			}else if(type == 5){//村
				List<OptionVo> options = entryService.getVillageOption(id);
				for(OptionVo vo : options){
					ZtreeVo ztree = new ZtreeVo();
					ztree.setId(vo.getKey());
					ztree.setName(vo.getValue());
					ztree.setType(5);
					ztree.setLean(false);
					list.add(ztree);
				}
			}
		}
		return list;
	}

	@Override
	public List<Integer> findvallageIds(Integer areaId, Integer type) {
		
		List<Integer> villageId = new ArrayList<Integer>();
		if(type > 0 && type < 4){//省市区级别
			List<Integer> districtIds = this.getDistrictIds(areaId);
			villageId = entryService.getVillageIdByDistrictIds(districtIds);
		}else{//乡镇级别
			EntryArea entryArea = new EntryArea();
			entryArea = entryMapper.findById(areaId);
			if(entryArea.getParent() == null && entryArea.getVillage() == null){//镇
				List<OptionVo> opts = entryService.getVillageOption(areaId);
				for(OptionVo vo : opts){
					villageId.add(Integer.valueOf(vo.getKey()));
				}
			}else{//村
				villageId.add(areaId);
			}
		}
		return villageId;
	}

}
