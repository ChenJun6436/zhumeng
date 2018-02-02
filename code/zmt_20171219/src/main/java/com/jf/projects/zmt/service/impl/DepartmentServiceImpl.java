package com.jf.projects.zmt.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.dao.SDepartmentMapper;
import com.jf.projects.zmt.dao.SRoleMapper;
import com.jf.projects.zmt.model.SDepartment;
import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.service.DepartmentService;
import com.jf.projects.zmt.util.CommonUtil;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * @className: DepartmentServiceImpl
 * @description:部门实现
 * @author wj
 * @date 2017年10月25日下午3:41:38
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private SDepartmentMapper sDepartmentMapper;

    @Autowired
    private SRoleMapper sRoleMapper;
    
    @Override
    public ResponseVO findDepartmentList(String typeId) {
        // TODO Auto-generated method stub
        ResponseVO resVO = new ResponseVO();
        try {
            // 根据类型ID获取部门数据
            resVO.setData(sDepartmentMapper.findListByTypeId(typeId));
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
          
        
    }


    @Override
    public ResponseVO findDepartment(String typeId) {
        ResponseVO resVO = new ResponseVO();
        try {
            // 根据类型ID获取部门数据
            resVO.setData(sDepartmentMapper.findByTypeId(typeId));
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
    }

    @Override
    public ResponseVO deleteDepartment(String departmentId) {
        ResponseVO resVO = new ResponseVO();

        try {
            // 查询该部门下是否存在角色数据，如有，则不进行删除
            List<SRole> list = sRoleMapper.findByDepartmentId(departmentId);
            if (list != null && list.size() > 0) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("部门下有角色不可删除！");
                return resVO;
            } else {
                // 删除部门
                sDepartmentMapper.delete(departmentId);
                resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
                resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
                return resVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }

    }

    @Override
    public ResponseVO addDepartment(String typeId, String departmentName,Integer type) {
        ResponseVO resVO = new ResponseVO();
        SDepartment sDepartment = new SDepartment();

        try {
            // 判断是否已存在部门
            SDepartment department = sDepartmentMapper.findByName(departmentName);
            if (department != null) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在该部门！");
                return resVO;
            }
            sDepartment.setType(type);
            sDepartment.setTypeId(typeId);
            sDepartment.setName(departmentName);
            sDepartment.setId(UUID.randomUUID().toString());
            if(departmentName.equals("建档管理部")){
                sDepartment.setCode("dp0001");
            }else if(departmentName.equals("养殖管理部")){
                sDepartment.setCode("dp0002");
            }else{
             // 编码生成规则-->dp+随机四位数
                sDepartment.setCode("dp" + CommonUtil.getRandomNum(4));
            }
            sDepartmentMapper.insert(sDepartment);
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }

    }

    @Override
    public ResponseVO updateDepartment(String departmentId, String typeId, String departmentName) {
        ResponseVO resVO = new ResponseVO();
        try {
            // 判断是否已存在部门
            SDepartment department = sDepartmentMapper.findByName(departmentName);
            if (department != null) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在该部门！");
                return resVO;
            }
            // 判断是否存在该部门数据
            SDepartment deptVO = sDepartmentMapper.findById(departmentId);
            if (deptVO == null) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
                return resVO;
            }
            // 更新部门信息
            deptVO.setTypeId(typeId);
            deptVO.setName(departmentName);
            sDepartmentMapper.update(deptVO);
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;

        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
    }


	@Override
	public ResponseVO findDepartmentForjy(String typeId) {
		ResponseVO resVO = new ResponseVO();
        try {
            // 根据类型ID获取部门数据
            resVO.setData(sDepartmentMapper.findByTypeIdForjy(typeId));
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
	}

   
}
