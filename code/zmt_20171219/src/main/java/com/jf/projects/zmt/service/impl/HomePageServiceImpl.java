package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jf.projects.zmt.dao.MarketMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SlaughterhouseMapper;
import com.jf.projects.zmt.service.HomePageService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.CommonUtil;
import com.jf.projects.zmt.vo.RequestPageParam;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.home.FilingNumberVo;
import com.jf.projects.zmt.vo.home.HomePigVo;
import com.jf.projects.zmt.vo.home.HomeSearchVo;
import com.jf.projects.zmt.vo.home.InputNumberVo;
import com.jf.projects.zmt.vo.home.PicCountVo;
import com.jf.projects.zmt.vo.home.RealCountVo;
import com.jf.projects.zmt.vo.home.SaleNumberVo;
import com.jf.projects.zmt.vo.home.SlaughterNumberVo;
import com.jf.projects.zmt.vo.pigFlow.PigFlowVo;

@Service
public class HomePageServiceImpl implements HomePageService {

	@Autowired
	private PigFlowMapper flowMapper;
	@Autowired
	private PigFileMapper fileMapper;
	@Autowired
	private MarketMapper marketMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private SlaughterhouseMapper slMapper;
	
	@Override
	public RealCountVo getTodayReal(Integer areaId, Integer type) {
		RealCountVo vo = new RealCountVo();
		//生猪总数
		vo.setNumber(fileMapper.countByArea(areaId, type));
		//今日建档总数
		vo.setArchivesNumbers(fileMapper.countByAreaToday(areaId, type));
		//今日屠宰总数
		vo.setSlaughterNumbers(slMapper.countByAreaToday(areaId, type));
		//今日销售总数
		vo.setSellNumbers(marketMapper.countByArea(areaId, type));
		
		return vo;
	}

	@Override
	public PicCountVo getPic(Integer areaId, Integer type) {
		PicCountVo vo = new PicCountVo();
		//建档数
		FilingNumberVo filin = new FilingNumberVo();
		filin = fileMapper.countFilingNumberForYear(areaId, type);
		if(filin == null){
			filin = new FilingNumberVo();
		}
		vo.setFilingNumber(filin);
		//养殖数
		InputNumberVo input = new InputNumberVo();
		input = fileMapper.countInputNumberForYear(areaId, type);
		if(input == null){
			input = new InputNumberVo();
		}
		vo.setInputNumber(input);
		//屠宰数
		SlaughterNumberVo slau = new SlaughterNumberVo();
		slau = slMapper.countSlaughterNumberForYear(areaId, type);
		if(slau == null){
			slau = new SlaughterNumberVo();
		}
		vo.setSlaughterNumber(slau);
		//销售数
		SaleNumberVo sale = new SaleNumberVo();
		sale = marketMapper.countSaleNumberForYear(areaId, type);
		if(sale == null){
			sale = new SaleNumberVo();
		}
		vo.setSaleNumber(sale);
		
		return vo;
	}

	@Override
	public ResponseVO getPigByFiled(HomeSearchVo vo) {
		
		List<HomePigVo> list = new ArrayList<HomePigVo>();
		
		long total = flowMapper.findtotal(vo);
		if(total != 0){
			list = flowMapper.findPage(vo);
			for(HomePigVo pigvo : list){
				if(!StringUtils.isEmpty(pigvo.getCreatePersonId())){
					pigvo.setAddress(userService.getAddressById(pigvo.getCreatePersonId()));
				}
				if(!StringUtils.isEmpty(pigvo.getStatus())){
					pigvo.setStatus(CommonUtil.getPigStatusStr(Integer.valueOf(pigvo.getStatus())));
				}
			}
		}
		return new ResponseVO(total, total, list);
	}

	@Override
	public ResponseVO findFlowByPigId(String pigId,RequestPageParam pageParam) {
		List<PigFlowVo> list = new ArrayList<PigFlowVo>();
		long total = flowMapper.countByPigId(pigId);
		if(total != 0){
			list = flowMapper.findByPigId(pigId,pageParam);
		}
		return new ResponseVO(total, total, list);
	}

	@Override
	public List<PigFlowVo> findAllByPigId(String pigId) {
		
		return flowMapper.findAllByPigId(pigId);
	}

}
