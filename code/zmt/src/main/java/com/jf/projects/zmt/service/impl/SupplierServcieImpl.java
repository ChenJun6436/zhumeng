package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.dao.LSupplierMapper;
import com.jf.projects.zmt.model.LSupplier;
import com.jf.projects.zmt.service.CarInfoService;
import com.jf.projects.zmt.service.SupplierServcie;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.deal.CarInfoVo;
import com.jf.projects.zmt.vo.deal.DealInfoVo;
import com.jf.projects.zmt.vo.deal.SupplierVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class SupplierServcieImpl implements SupplierServcie {
	
	@Autowired
	private LSupplierMapper mapper;//入库
	
	@Autowired
	private CarInfoService carInfoService;//车辆信息service
	
	@Autowired
	private AndSlaughterhouseUserMapper andSlUser;//用户屠宰场关系表

	@Override
	public Integer add(SupplierVo vo) {
		LSupplier supplier = new LSupplier();
		//添加入库单基本信息
		supplier.setId(UUIDUtil.getUUID());
		supplier.setCode(vo.getCode());
		supplier.setName(vo.getName());
		supplier.setTel(vo.getTel());
		supplier.setAddress(vo.getAddress());
		supplier.setPigNum(vo.getPigNum());
		supplier.setPigWeight(vo.getPigWeight());
		supplier.setSlaughterId(vo.getSlaughterId());
		supplier.setCreateTime(new Date());
		supplier.setUpdateTime(new Date());
		try{
			mapper.insert(supplier);
			//添加车辆信息
			if(vo.getCarInfo() != null && vo.getCarInfo().length() > 0){
				JSONArray array = JSONArray.fromObject(vo.getCarInfo());
				for(int i=0;i<array.size();i++){
					CarInfoVo car = new CarInfoVo();
					JSONObject jsonObject = array.getJSONObject(i);
					car.setCarNo(jsonObject.get("carNo").toString());
					car.setDriver(jsonObject.get("driver").toString());
					car.setTel(jsonObject.get("tel").toString());
					car.setMerchantId(supplier.getId());
					carInfoService.add(car);
				}
			}
		}catch (Exception e) {
			//手动回滚事务
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
		
		return 1;
	}

	@Override
	public SupplierVo findById(String id) {
		SupplierVo vo = new SupplierVo();
		LSupplier supplier = mapper.findById(id);
		if(supplier == null) return new SupplierVo();
		vo.setCode(supplier.getCode());
		vo.setName(supplier.getName());
		vo.setTel(supplier.getTel());
		vo.setAddress(supplier.getAddress());
		vo.setPigNum(supplier.getPigNum());
		vo.setPigWeight(supplier.getPigWeight());
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

}
