package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.dao.LButcherCountMapper;
import com.jf.projects.zmt.dao.LSupplierMapper;
import com.jf.projects.zmt.dao.LWholesalerMapper;
import com.jf.projects.zmt.model.LWholesaler;
import com.jf.projects.zmt.service.CarInfoService;
import com.jf.projects.zmt.service.WholesalerService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.deal.CarInfoVo;
import com.jf.projects.zmt.vo.deal.CountNumberVo;
import com.jf.projects.zmt.vo.deal.DealInfoVo;
import com.jf.projects.zmt.vo.deal.WholesalerVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class WholesalerServiceImpl implements WholesalerService {
	
	@Autowired
	private LWholesalerMapper mapper;//出库单

	@Autowired
	private CarInfoService carInfoService;//车辆信息
	
	@Autowired
	private AndSlaughterhouseUserMapper andSlUser;//用户屠宰场关系表
	
	@Autowired
	private LButcherCountMapper countMapper;//屠宰场宰杀表
	
	@Autowired
	private LSupplierMapper suMapper;//入库单
	
	@Override
	public Integer add(WholesalerVo vo) {
		LWholesaler wholesale = new LWholesaler();
		//添加出库单基本信息
		wholesale.setId(UUIDUtil.getUUID());
		wholesale.setCode(vo.getCode());
		wholesale.setName(vo.getName());
		wholesale.setTel(vo.getTel());
		wholesale.setCompanyAddress(vo.getCompanyAddress());
		wholesale.setPigNum(vo.getPigNum());
		wholesale.setPigWeight(vo.getPigWeight());
		wholesale.setSaleAddress(vo.getSaleAddress());
		wholesale.setSlaughterId(vo.getSlaughterId());
		wholesale.setCreateTime(new Date());
		wholesale.setUpdateTime(new Date());
		try{
			mapper.insert(wholesale);
			//添加车辆信息
			if(vo.getCarInfo() !=null && vo.getCarInfo().length() > 0){
				JSONArray array = JSONArray.fromObject(vo.getCarInfo());
				for(int i=0;i<array.size();i++){
					CarInfoVo car = new CarInfoVo();
					JSONObject jsonObject = array.getJSONObject(i);
					car.setCarNo(jsonObject.get("carNo").toString());
					car.setDriver(jsonObject.get("driver").toString());
					car.setTel(jsonObject.get("tel").toString());
					car.setMerchantId(wholesale.getId());
					carInfoService.add(car);
				}
			}
		}catch (Exception e) {
			//手动回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
		
		return 1;
	}

	@Override
	public WholesalerVo findById(String id) {
		WholesalerVo vo = new WholesalerVo();
		LWholesaler wholesaler = mapper.findById(id);
		if(wholesaler == null) return new WholesalerVo();
		vo.setCode(wholesaler.getCode());
		vo.setName(wholesaler.getName());
		vo.setTel(wholesaler.getTel());
		vo.setCompanyAddress(wholesaler.getCompanyAddress());
		vo.setPigNum(wholesaler.getPigNum());
		vo.setPigWeight(wholesaler.getPigWeight());
		vo.setSaleAddress(wholesaler.getSaleAddress());
		vo.setCars(carInfoService.findByCodeId(id));
		return vo;
	}

	@Override
	public ResponseVO findPageByUserId(String userId,Integer start,Integer length) {
		List<DealInfoVo> list = new ArrayList<DealInfoVo>();
		//根据用户id获取屠宰场id
		String slId = andSlUser.getSlaughterhouseIdByUserId(userId);
		if(StringUtils.isEmpty(slId))new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "该用户不是屠宰场用户");
		//列表数据
		long total = mapper.findTotal(slId);
		if(total > 0){
			list = mapper.findPageBySlId(slId,start,length);
			//统计车辆数量
			for(DealInfoVo vo : list){
				List<CarInfoVo> carList = carInfoService.findByCodeId(vo.getId());
				vo.setCarNum(carList.size());
			}
		}
		return new ResponseVO(total,total,list);
	}

	@Override
	public ResponseVO findPageBySlId(String slId,Integer start,Integer length) {
		List<DealInfoVo> list = new ArrayList<DealInfoVo>();
		long total = mapper.findTotal(slId);
		if(total > 0){
			list = mapper.findPageBySlId(slId,start,length);
			//统计车辆数量
			for(DealInfoVo vo : list){
				List<CarInfoVo> carList = carInfoService.findByCodeId(vo.getId());
				vo.setCarNum(carList.size());
			}
		}
		return new ResponseVO(total,total,list);
	}

	@Override
	public CountNumberVo findNumberByUserId(String userId) {
		//根据用户id获取屠宰场id
		String slId = andSlUser.getSlaughterhouseIdByUserId(userId);
		if(StringUtils.isEmpty(slId))new ResponseVO(ConstantsUtil.RES_PARAMER_FAIL_CODE, "该用户不是屠宰场用户");
		CountNumberVo vo = new CountNumberVo();
		Integer butcherNum = countMapper.countToday(slId);
		Integer inNum = suMapper.countToday(slId);
		Integer outNum = mapper.countToday(slId);
		vo.setButcherNum(butcherNum == null ? 0 : butcherNum);
		vo.setInNum(inNum == null ? 0 : inNum);
		vo.setOutNum(outNum == null ? 0 : outNum);
		return vo;
	}

	@Override
	public CountNumberVo findNumberBySlId(String slId) {
		CountNumberVo vo = new CountNumberVo();
		Integer butcherNum = countMapper.countToday(slId);
		Integer inNum = suMapper.countToday(slId);
		Integer outNum = mapper.countToday(slId);
		vo.setButcherNum(butcherNum == null ? 0 : butcherNum);
		vo.setInNum(inNum == null ? 0 : inNum);
		vo.setOutNum(outNum == null ? 0 : outNum);
		return vo;
	}
}
