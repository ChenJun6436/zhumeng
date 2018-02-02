package com.jf.projects.zmt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.Dom4jUtil;
import com.jf.projects.zmt.util.ParamUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.pig.AreaVO;


/**
 * 
 * @ClassName: UserServiceImpl
 *
 * @Description:用户
 *
 * @author wj
 *
 * @date 2018年1月9日
 *
 */

@Service
public class UserServiceImpl implements UserService {


	@Override
    public ResponseVO loginUser(String account, String pwd) {
        ResponseVO responseVO = new ResponseVO();
        String userName = null;
        String password = null;
        String type = null;
        try {
        	 //根据根节点名称获取xml配置信息
   		      Element element =Dom4jUtil.Dom4j_xml(ParamUtil.getXmlFileAddress(), "user");
   		      Element foo;
            for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
                foo = (Element) i.next();
                //获取根节点元素
                userName= foo.elementText("user_name");
                password= foo.elementText("password");
                type = foo.elementText("type");
                if(account.equals(userName)) {
                	break;
                }
            }  
            if (!account.equals(userName)) {     // 验证用户名是否存在
                responseVO.setCode(ConstantsUtil.RES_NOT_EXIST_CODE);
                responseVO.setMessage(ConstantsUtil.RES_NOT_EXIST_MESSAGE);
                return responseVO;
            }
           
            if (!pwd.equals(password)) { // 验证密码
                responseVO.setCode(ConstantsUtil.RES_PWD_NO_MATCH_CODE);
                responseVO.setMessage(ConstantsUtil.RES_PWD_NO_MATCH_MESSAGE);
                return responseVO;
            }
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            responseVO.setData(type);
            return responseVO;
        } catch (Exception e) {
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        } 

    }

	@Override
	public List<AreaVO> findArea(Integer type) {
		List<AreaVO>  list = new ArrayList<AreaVO>();
		 //根据根节点名称获取xml配置信息
		 Element element =Dom4jUtil.Dom4j_xml(type==null?ParamUtil.getXmlFileAddress():ParamUtil.getCityXmlFileAddress(), "area");  //地址获取
		 Element foo;
        for (Iterator i = element.elementIterator("value"); i.hasNext();) {  
            foo = (Element) i.next();
            AreaVO vo = new AreaVO();
            //获取根节点元素
            vo.setProvince(foo.elementText("province"));    //省
            vo.setCity(foo.elementText("city"));			//市
            vo.setDistrict(foo.elementText("district"));    //区
            list.add(vo);
        }  
		return list;
	}

   
}
