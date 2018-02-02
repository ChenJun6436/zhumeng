package com.jf.projects.zmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.PigBreedMapper;
import com.jf.projects.zmt.model.PigBreed;
import com.jf.projects.zmt.service.PigBreedService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

@Service
public class PigBreedServiceImpl implements PigBreedService {

	@Autowired
	private PigBreedMapper mapper;

	@Override
	public ResponseVO add(PigBreed pigBreed) {
		ResponseVO vo = new ResponseVO();
		try {
			PigBreed p = mapper.isRepetition(null, pigBreed.getName());
			if (p != null) {
				vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				vo.setMessage("该品种已存在");
				return vo;
			}
			mapper.insert(pigBreed);
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
	}

	@Override
	public ResponseVO findAll() {
		ResponseVO vo = new ResponseVO();
		try {
			vo.setData(mapper.findAllPigBreed());
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return vo;
	}

	@Override
	public ResponseVO delete(String id) {
		ResponseVO vo = new ResponseVO();
		try {
			// TODO 判断是否有被使用
			// if(1 != 0){
			// vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
			// vo.setMessage("已有ID使用该品种！不可进行删除操作！");
			// return vo;
			// }
			mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_FAIL_CODE);
			vo.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
			return vo;
		}
		vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return vo;
	}

	@Override
	public ResponseVO updateStatus(String id) {
		ResponseVO vo = new ResponseVO();
		try {
			PigBreed breed = mapper.findById(id);
			if ("enable".equals(breed.getStatus())) {
				// TODO 判断时候有被使用
				// if(true){
				// vo.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
				// vo.setMessage("已有ID使用该品种！不可进行删除操作！");
				// return vo;
				// }
				breed.setStatus("disable");
				mapper.update(breed);
			} else {
				breed.setStatus("enable");
				mapper.update(breed);
			}
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			vo.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			return vo;
		}
		return vo;
	}

	@Override
	public ResponseVO findPigBreedEnable() {
		ResponseVO responseVO = new ResponseVO();
		responseVO.setData(mapper.findPigBreedOfEnable());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		return responseVO;
	}

}
