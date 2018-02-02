package com.jf.projects.zmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.AndRoleResourceMapper;
import com.jf.projects.zmt.dao.BrandMapper;
import com.jf.projects.zmt.dao.InspectinMapper;
import com.jf.projects.zmt.dao.PigFileMapper;
import com.jf.projects.zmt.dao.SDepartmentMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.FileManagerZMTService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.department.DepartmentVo;
import com.jf.projects.zmt.vo.farms.SerchVo;
import com.jf.projects.zmt.vo.fileManager.BuildersVo;
import com.jf.projects.zmt.vo.fileManager.FileBuliderVo;
import com.jf.projects.zmt.vo.fileManager.PigFileVo;
import com.jf.projects.zmt.vo.role.RoleVo;

@Service
public class FileManagerZMTServiceImpl implements FileManagerZMTService {
	@Autowired
	private SUserMapper sUserMapper;

	@Autowired
	private PigFileMapper pFileMapper;

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private AndRoleResourceMapper andRoleResourceMapper;

	@Autowired
	private SDepartmentMapper sDepartmentMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private InspectinMapper inspectinMapper;

	@Override
	public ResponseVO findFileBuilders(SerchVo search) {
		ResponseVO responseVO = new ResponseVO();
		try {
			List<BuildersVo> list = sUserMapper
					.findBuidersInfo(search.getAccount(), search.getPhone(),
							search.getTypeId(), search.getDepartmentId(),
							search.getRoleId(), search.getKeyWords(),
							search.getStart(), search.getLength());
			if (list != null) {
				for (BuildersVo buildersVo : list) {
					buildersVo.setAddress(userService.getAddressById(buildersVo
							.getId()));
				}
			}
			long total = sUserMapper.findBuiderNumber(search.getAccount(),
					search.getPhone(), search.getTypeId(),
					search.getDepartmentId(), search.getRoleId(),
					search.getKeyWords());
			responseVO.setData(list);
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
			if (list != null) {
				responseVO.setRecordsFiltered(total);
				responseVO.setRecordsTotal(total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseVO;

	}

	@Override
	public ResponseVO findFileByBuildersId(FileBuliderVo Vo) {
		ResponseVO responseVO = new ResponseVO();
		List<PigFileVo> list = pFileMapper.findFileByBuliderId(Vo.getUserId(),
				Vo.getSign(), Vo.getStart(), Vo.getLength());
		if (list != null) {
			for (PigFileVo pigFileVo : list) {
				if (pigFileVo.getFarmId() != null) {
					pigFileVo.setAddress(userService.getAddressById(pigFileVo
							.getFarmId()));
				}
			}
		}
		long total = pFileMapper.countFileByBuliderId(Vo.getUserId(),
				Vo.getSign());
		responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
		responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		responseVO.setData(list);
		if (list != null) {
			responseVO.setRecordsFiltered(total);
			responseVO.setRecordsTotal(total);
		}
		return responseVO;
	}

	@Override
	public ResponseVO forbidOrStartBuilder(String builderId, String status) {
		ResponseVO responseVO = new ResponseVO();
		int flag = sUserMapper.forbidOrStart(builderId, status);
		if (flag != 0) {
			responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
			responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
		} else {
			responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
			responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
		}
		return responseVO;
	}

	@Override
	public ResponseVO findRoleVoByRource() {
		ResponseVO responseVO = new ResponseVO();
		List<RoleVo> list = andRoleResourceMapper
				.findRoleVoByResource("dp0001");
		responseVO.setData(list);
		return responseVO;
	}

	@Override
	public ResponseVO findDepartmentVoByRource() {
		ResponseVO responseVO = new ResponseVO();
		List<DepartmentVo> list = sDepartmentMapper
				.findDepartmentVoByResource("dp0001");
		responseVO.setData(list);
		return responseVO;
	}

	@Override
	public int updateBuliderUser(SUser vo) {
		SUser a = sUserMapper.findUserByTel(vo.getTel(), vo.getId());
		if (a != null) {
			return 0;
		}
		inspectinMapper.clearInspectionUserAddress(vo.getId());
		int flag = sUserMapper.update(vo);
		return flag;
	}
}
