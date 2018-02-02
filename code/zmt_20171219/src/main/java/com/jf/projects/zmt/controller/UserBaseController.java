package com.jf.projects.zmt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jf.projects.zmt.service.UserBaseService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.CheckCodeUtil;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.util.NoteContentUtil;
import com.jf.projects.zmt.util.PictureCheckCodeUtil;
import com.jf.projects.zmt.util.RegExVerify;
import com.jf.projects.zmt.util.SendNoteUtil;
import com.jf.projects.zmt.vo.ResponseVO;

/**
 * 
 * @className: UserBaseController
 *
 * @description:用户基础
 *
 * @author wj
 *
 * @date 2017年11月1日下午2:09:15
 *
 */
@Controller
@RequestMapping("/*")
public class UserBaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserBaseService userBaseService;
    

    /**
     * 生成验证码图片
     * 
     * @param request
     * @param response
     * @param modelMap
     */
    @RequestMapping(value = "sign/userbase/getPictureVeritfCode")
    public void getPictureVeritfCode(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        PictureCheckCodeUtil indentify = new PictureCheckCodeUtil(100, 31);
        String checkcode = indentify.getRandomString();
        BufferedImage img = indentify.createImage(checkcode);
        session.setAttribute("checkcode", checkcode);
        try {
            try {
                ServletOutputStream sos = response.getOutputStream();
                ImageIO.write(img, "jpeg", sos);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    /**
     * 用户登录
     * @param account
     * @param password
     * @param code
     * @return
     */
    @RequestMapping(value = "/sign/userbase/login", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO loginUser(HttpServletRequest request, HttpServletResponse response)
                                       throws ServletException, IOException { 
        //校验验证码
        String checkCode=(String) request.getSession().getAttribute("checkcode");
        String password = request.getParameter("password");
        String account = request.getParameter("account");
        String code = request.getParameter("code");
        if(!code.equals(checkCode)){
            ResponseVO responseVO = new ResponseVO();
            responseVO.setCode(ConstantsUtil.RES_CODE_NOT_CORRECT_CODE);
            responseVO.setMessage(ConstantsUtil.RES_CODE_NOT_CORRECT_MESSAGE);
            return responseVO;
        }
        return userBaseService.loginUser(account,password);
       
    }
    
    /**
     * app用户登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/sign/userbase/appLogin", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseVO appLogin(@RequestParam(value = "account", required = true) String account,   
                    @RequestParam(value = "password", required = true) String password){
        
        return userBaseService.loginUser(account,password);
       
    }
    
   /**
    * 修改用户手机号
    * @param account
    * @param tel
    * @param checkCode
    * @return
    */
    @RequestMapping(value = "/sign/userbase/resetTel", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO resetTel(@RequestParam(value = "account", required = true) String account,   
                                @RequestParam(value = "tel", required = true) String tel,
                                @RequestParam(value = "checkCode", required = false) String checkCode) {
        //校验验证码
        ResponseVO codeResponseVO = CheckCodeUtil.checkCodeValue(tel, checkCode);
        if(codeResponseVO!= null){
            return codeResponseVO;
        }   
        return userBaseService.updateTelByAccount(account,tel);
       
    }
    
    
    /**
     * 忘记密码
     * @param tel
     * @param password
     * @param checkCode
     * @return
     */
    @RequestMapping(value = "/sign/userbase/resetPassword",method = RequestMethod.POST)    
    @ResponseBody
    public ResponseVO resetPassword(@RequestParam(value="tel",required = true) String tel,
            @RequestParam(value="password",required = true) String password,
            @RequestParam(value="checkCode",required = true) String checkCode){
        ResponseVO codeResponseVO = CheckCodeUtil.checkCodeValue(tel, checkCode);
        if(codeResponseVO!= null){
            return codeResponseVO;
        }   
        return  userBaseService.updatePwdBytel(tel,password);
    }
    
    /**
     * 校验验证码
     * @param tel
     * @param checkCode
     * @return
     */
    @RequestMapping(value = "/sign/userbase/verifyCheckCode",method = RequestMethod.POST)    
    @ResponseBody
    public ResponseVO verifyCheckCode(@RequestParam(value="tel",required = true) String tel,
            @RequestParam(value="checkCode",required = true) String checkCode){
        //校验验证码
        ResponseVO codeResponseVO = CheckCodeUtil.checkCodeValue(tel, checkCode);
        if(codeResponseVO!= null){
            return codeResponseVO;
        }else{
            ResponseVO resVO = new ResponseVO();
            resVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            resVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return resVO;
        }
    }
    
    /**
     * 修改密码
     * @param account
     * @param password
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/sign/userbase/updatePassword",method = RequestMethod.POST)    
    @ResponseBody
    public ResponseVO updatePassword(@RequestParam(value="account",required = true) String account,
            @RequestParam(value="password",required = true) String password,
            @RequestParam(value="newPassword",required = true) String newPassword){
        
        return  userBaseService.updatePwdByAccount(account,password,newPassword);
    }
    
    /**
     * 发送验证码
     * @Title: sendVerifyCode
     * @Description 发送验证码
     * @param tel
     * @return
     * @return ResponseVO
     */
    @RequestMapping(value = "/sign/userbase/sendVerifyCode",method = RequestMethod.POST) 
    @ResponseBody
    public ResponseVO sendVerifyCode(@RequestParam(value="tel",required = true) String tel){
        ResponseVO responseVO = new ResponseVO();
        if(RegExVerify.isMobile(tel)){              //校验手机号     
            SendNoteUtil.sendNoteMessage(tel,NoteContentUtil.getCheckCodeContent(CheckCodeUtil.newCheckCode(tel)));
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
            return responseVO;
        }else{
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
            return responseVO;
        }
    }
    
    /**
     * 根据用户ID获取用户类型部门角色
     * @param userId
     * @return
     */
    @RequestMapping(value = "/sign/userbase/getUserInfo",method = RequestMethod.POST) 
    @ResponseBody
    public ResponseVO getUserInfo(@RequestParam(value="userId",required = true) String userId){
            return userBaseService.findUserInfoById(userId);
    }
    
    
}
