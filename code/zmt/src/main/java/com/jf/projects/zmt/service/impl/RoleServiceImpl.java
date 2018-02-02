package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndRoleResourceMapper;
import com.jf.projects.zmt.dao.AndUserRoleMapper;
import com.jf.projects.zmt.dao.SRoleMapper;
import com.jf.projects.zmt.model.AndRoleResource;
import com.jf.projects.zmt.model.SRole;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.service.RoleService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.role.RoleListVo;
/**
 * 
 * @className: RoleServiceImpl
 *
 * @description:用户角色实现
 *
 * @author wj
 *
 * @date 2017年10月25日下午3:26:22
 *
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SRoleMapper sRoleMapper;
    @Autowired
    private AndUserRoleMapper andUserRoleMapper;
    @Autowired
    private AndRoleResourceMapper andRoleResourceMapper;
    
    

    @Override
    public List<SRole> findAll() {
        return null;
    }

    @Override
    public ResponseVO deleteRole(String roleId) {
        ResponseVO resVO = new ResponseVO();

        try {
            // 查询该角色下是否存在用户数据，如有，则不进行删除
            List<SUser> list = andUserRoleMapper.findByRoleId(roleId);
            if (list != null && list.size() > 0) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("角色下有用户不可删除！");
                return resVO;
            } else {
                //删除角色关联的资源数据
                andRoleResourceMapper.deleteByRoleId(roleId);
                
                // 删除角色
                sRoleMapper.delete(roleId);
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
    public ResponseVO findRoleByDepartmentId(String departmentId) {
        ResponseVO resVO = new ResponseVO();
        try {
            // 根据类型ID获取部门数据
            resVO.setData(sRoleMapper.findByDepartmentId(departmentId));
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
    public ResponseVO addRole(String roleName, String departmentId, String typeId, String resourceIds,String code,String creator) {
        
        ResponseVO resVO = new ResponseVO();
        SRole sRole = new SRole();
        try {
            // 查询同一部门中是否已存在该角色
            SRole role = sRoleMapper.findByNameAndDepartmentId(departmentId,roleName);
            if (role != null) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在该角色！");
                return resVO;
            }
            //新增角色
            sRole.setCreator(creator);
            //角色为监控机构时，角色代码为jkadmin
            if(typeId.equals("e998326a-0d16-46c5-9151-dcc617b507b4")){
            	sRole.setCode("jkadmin");
            }else {
            	sRole.setCode(code);
            }
            sRole.setDepartmentId(departmentId);
            sRole.setTypeId(typeId);
            sRole.setName(roleName);
            sRole.setId(UUID.randomUUID().toString());
            sRoleMapper.insert(sRole);
            //新增角色资源
            
            /*if(resourceIds != null && resourceIds.size()>0){
                for(int i=0 ;i<resourceIds.size();i++){
                    resourceIds.get(i).setId(UUID.randomUUID().toString());
                    resourceIds.get(i).setRoleId(sRole.getId());
                }
            }*/
            List<AndRoleResource> list = new ArrayList<AndRoleResource>();
            
            //解析json串
            JSONArray array = JSONArray.fromObject(resourceIds);
            for(int i=0;i<array.size();i++){
                
                AndRoleResource andRoleResource = new AndRoleResource();
                JSONObject jsonObject = array.getJSONObject(i);
                andRoleResource.setId(UUID.randomUUID().toString());
                andRoleResource.setRoleId(sRole.getId());
                andRoleResource.setResourceId(jsonObject.get("resourceId").toString());
                andRoleResource.setType(Integer.parseInt(jsonObject.get("type").toString()));
                list.add(andRoleResource);
                
//                System.out.println("resourceId="+jsonObject.get("resourceId").toString());
//                System.out.println("type="+jsonObject.get("type").toString());
            }
             //批量新增角色资源
            andRoleResourceMapper.addRoleResourceBatch(list);
            
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
    }

    @Override
    public ResponseVO updateRole(String roleId,String roleName, String departmentId, String resourceIds,String code,String creator) {
        ResponseVO resVO = new ResponseVO();
        try {
            // 查询同一部门中是否已存在该角色
            SRole role = sRoleMapper.findByNameAndDepartmentId(departmentId,roleName);
            if (role != null && !role.getId().equals(roleId)) {
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage("已存在该角色！");
                return resVO;
            }
            //更新角色信息
            SRole  roleVO = sRoleMapper.findById(roleId);
            if(roleVO == null ){
                resVO.setCode(ConstantsUtil.RES_PARAMER_FAIL_CODE);
                resVO.setMessage(ConstantsUtil.RES_PARAMER_FAIL_MESSAGE);
                return resVO;
            }
            roleVO.setCreator(creator);
          //角色为监控机构时，角色代码为jkadmin
            if(roleVO.getTypeId().equals("e998326a-0d16-46c5-9151-dcc617b507b4")){
            	roleVO.setCode("jkadmin");
            }else {
            	roleVO.setCode(code);
            }
            roleVO.setDepartmentId(departmentId);
            roleVO.setName(roleName);
            sRoleMapper.update(roleVO);
            //更新角色资源
            
            if(resourceIds !=null){
                //删除数据库原有资源数据
                andRoleResourceMapper.deleteByRoleId(roleId);
                
                List<AndRoleResource> list = new ArrayList<AndRoleResource>();
                //解析json串
                JSONArray array = JSONArray.fromObject(resourceIds);
                for(int i=0;i<array.size();i++){
                    
                    AndRoleResource andRoleResource = new AndRoleResource();
                    JSONObject jsonObject = array.getJSONObject(i);
                    andRoleResource.setId(UUID.randomUUID().toString());
                    andRoleResource.setRoleId(roleId);
                    andRoleResource.setResourceId(jsonObject.get("resourceId").toString());
                    andRoleResource.setType(Integer.parseInt(jsonObject.get("type").toString()));
                    list.add(andRoleResource);
                }
                 //批量新增角色资源
                andRoleResourceMapper.addRoleResourceBatch(list);
            }
            
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        } catch (Exception e) {
            e.printStackTrace();
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            resVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            resVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return resVO;
        }
    }

    @Override
    public ResponseVO findRoleList(String typeId,String departmentId, String roleId,Integer start,Integer length) {
        ResponseVO resVO = new ResponseVO();
        try {
            // 根据类型ID获取部门数据
            List<RoleListVo> list = sRoleMapper.findRoleList(typeId,departmentId,roleId,null,null);
            resVO.setRecordsFiltered(list.size());
            resVO.setRecordsTotal(list.size());
            resVO.setData(sRoleMapper.findRoleList(typeId,departmentId,roleId,start,length));
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
