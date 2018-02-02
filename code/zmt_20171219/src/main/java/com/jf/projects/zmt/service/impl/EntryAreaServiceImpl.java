package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.AndUserAreaMapper;
import com.jf.projects.zmt.dao.AreaMapper;
import com.jf.projects.zmt.dao.EntryAreaMapper;
import com.jf.projects.zmt.model.AndUserArea;
import com.jf.projects.zmt.model.Area;
import com.jf.projects.zmt.model.EntryArea;
import com.jf.projects.zmt.service.EntryAreaService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.area.EntryAraeListVo;
import com.jf.projects.zmt.vo.area.EntryAreaSearch;
import com.jf.projects.zmt.vo.area.EntryAreaUpdateVo;

/**
 * 乡村
 * @author dqh
 */
@Service
public class EntryAreaServiceImpl implements EntryAreaService {
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private EntryAreaMapper entryMapper;
	
	@Autowired
	private AndUserAreaMapper userAreaMapper;

	@Override
	public ResponseVO findPage(EntryAreaSearch searchVo) {
		ResponseVO vo;
		List<EntryAraeListVo> list = new ArrayList<EntryAraeListVo>();
//		List<Integer> cityIds = new ArrayList<Integer>();
//		if(searchVo.getTownId() == null){//优先从区县开始匹配，如果都没匹配上默认全国
//			if(searchVo.getDistrictId() != null){//区县
//				cityIds = areaService.getDistrictIds(searchVo.getDistrictId());
//			}else if(searchVo.getCityId() != null){//市
//				cityIds = areaService.getDistrictIds(searchVo.getCityId());
//			}else if(searchVo.getProvinceId() != null){//省
//				cityIds = areaService.getDistrictIds(searchVo.getProvinceId());
//			}else{//默认全国
//				cityIds = areaService.getDistrictIds(1);
//			}
//			
//			//根据区县id获取村
//			long total = entryMapper.findtotalByDistrictIds(cityIds);
//			if(total != 0){
//				list = entryMapper.findByDistrictIds(cityIds,searchVo.getStart(),searchVo.getLength());
//			}
//			vo = new ResponseVO(total, total, list);
//		}else{//镇
//			//根据镇id获取村
//			long total = entryMapper.findtotalByTownId(searchVo.getTownId());
//			if(total != 0){
//				list = entryMapper.findBytownId(searchVo.getTownId(),searchVo.getStart(),searchVo.getLength());
//			}
//			vo = new ResponseVO(total, total, list);
//		}
//		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
//		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
//		
//		return vo;
		
		long total = entryMapper.findtotal(searchVo);
		if(total != 0){
			list = entryMapper.findPage(searchVo);
		}
		vo = new ResponseVO(total, total, list);
		return vo;
	}

	@Override
	public ResponseVO add(EntryArea entryArea) {
		ResponseVO vo = new ResponseVO();
		
		//根据区县id获取区县编码
		Area area = areaMapper.findById(entryArea.getDistrictId());
		String code = area.getCode();
		Integer newCode;
		
		//获取当前区县区域乡村的最大编码
		Integer maxCode = entryMapper.findMaxCodeByDistrictId(area.getId());
		if(maxCode == null){//该区县下还未有数据,后面加01
			newCode = Integer.valueOf(code + "01");
		}else{
			newCode = maxCode+1;
		}
		
		//新增，如果parenid为空新增镇，不为空直接新增村
		if(entryArea.getParent() == null || "".equals(entryArea.getParent())){
			//判断乡镇名称是否在该区县存在
			EntryArea entry = entryMapper.townIsRepetition(null, entryArea.getDistrictId(), entryArea.getTown());
//			if(entry != null){
//				vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
//				vo.setMessage("乡镇名称已存在");
//				return vo;
//			}
			EntryArea entryTown = new EntryArea();
			if(entry == null){
				entryTown.setCode(newCode);
				entryTown.setTown(entryArea.getTown());
				entryTown.setDistrictId(entryArea.getDistrictId());
				entryTown.setStatus("enable");
				entryMapper.insert(entryTown);//新增镇
			}
			
			if(entryArea.getVillage() != null && !"".equals(entryArea.getVillage())){
				//判断乡镇名称是否在该区县存在
				EntryArea vill = null;
				if(entry == null){
					vill = entryMapper.villageIsRepetition(null, entryTown.getId(), entryArea.getVillage());
				}else{
					vill = entryMapper.villageIsRepetition(null, entry.getId(), entryArea.getVillage());
				}
				if(vill != null){
					vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
					vo.setMessage("村名称已存在");
					return vo;
				}
				EntryArea entryVill = new EntryArea();
				entryVill.setCode(newCode+1);
				entryVill.setTown(entryArea.getTown());
				entryVill.setDistrictId(entryArea.getDistrictId());
				entryVill.setStatus("enable");
				entryVill.setVillage(entryArea.getVillage());
				if(entry != null){
					entryVill.setParent(entry.getId());
				}else{
					entryVill.setParent(entryTown.getId());
				}
				entryMapper.insert(entryVill);//新增村
			}
		}else{
			EntryArea vill = entryMapper.villageIsRepetition(null, entryArea.getParent(), entryArea.getVillage());
			if(vill != null){
				vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				vo.setMessage("村名称已存在");
				return vo;
			}
			EntryArea entryVill = new EntryArea();
			entryVill.setCode(newCode++);
			entryVill.setTown(entryArea.getTown());
			entryVill.setDistrictId(entryArea.getDistrictId());
			entryVill.setStatus("enable");
			entryVill.setVillage(entryArea.getVillage());
			entryVill.setParent(entryArea.getParent());
			entryMapper.insert(entryVill);//新增村
		}
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
	}

	@Override
	public ResponseVO update(EntryAreaUpdateVo updateVo) {
		ResponseVO vo = new ResponseVO();
		List<AndUserArea> areas = new ArrayList<AndUserArea>();
		areas = userAreaMapper.findByAreaId(updateVo.getVillageId());
		if(areas.size() > 0){
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage("已有用户使用的地址不可修改");
			return vo;
		}
		areas = userAreaMapper.findByAreaId(updateVo.getTownId());
		if(areas.size() > 0){
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage("已有用户使用的地址不可修改");
			return vo;
		}
		
		try{
			//获取所有镇及相关村的id
			List<Integer> list = entryMapper.getTownASId(updateVo.getTownId());
			//修改乡镇名称,先判断名称是否重复
			EntryArea entry = entryMapper.townIsRepetition(updateVo.getTownId(), updateVo.getDistrictId(), updateVo.getTownName());
			if(entry != null){
				vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				vo.setMessage("乡镇名称已存在");
				return vo;
			}
			entryMapper.updateTown(updateVo.getTownName(), list);
			//修改乡村名称,先判断名称是否重复
			EntryArea vill = entryMapper.villageIsRepetition(updateVo.getVillageId(), updateVo.getTownId(), updateVo.getVillageName());
			if(vill != null){
				vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				vo.setMessage("村名称已存在");
				return vo;
			}
			entryMapper.updateVillage(updateVo.getVillageId(), updateVo.getVillageName());
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			return vo;
		}catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return vo;
		}
	}

	@Override
	public Integer updateStatus(Integer villageId) {
		try{
			EntryArea entry = entryMapper.findById(villageId);
			//禁用前判断是否有用户使用
			List<AndUserArea> areas = new ArrayList<AndUserArea>();
			areas = userAreaMapper.findByAreaId(villageId);
			if(areas.size() > 0){
				return 2;
			}
			
			if("enable".equals(entry.getStatus())){
				entry.setStatus("disable");
			}else{
				entry.setStatus("enable");
			}
			entryMapper.update(entry);
			
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public Integer delete(Integer villageId) {
		//查询and_user_area表中地址是否存在
		List<AndUserArea> areas = new ArrayList<AndUserArea>();
		areas = userAreaMapper.findByAreaId(villageId);
		if(areas.size() > 0){
			return 2;
		}
		return entryMapper.delete(villageId);
	}

	@Override
	public List<OptionVo> getTownOption(Integer districtId) {
		
		return entryMapper.getTownOption(districtId);
	}

	@Override
	public List<OptionVo> getVillageOption(Integer townId) {
		
		return entryMapper.getVillageOption(townId);
	}

	@Override
	public List<Integer> getVillageIdByDistrictIds(List<Integer> districtIds) {
		
		return entryMapper.getVillageIdByDistrictIds(districtIds);
	}

}
