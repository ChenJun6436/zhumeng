package com.jf.projects.zmt.controller;

import com.jf.projects.zmt.util.PoiImport;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.dao.AndSlaughterhouseUserMapper;
import com.jf.projects.zmt.model.AndSlaughterhouseUser;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.service.AndSlaughterhouseUserService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.SlaughterhouseService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.slaughterhouse.SlaughterhousePigVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yt
 * @className: AndSlaughterhouseUserController
 * @description:屠宰场
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class AndSlaughterhouseUserController {

  @Autowired
  private AndSlaughterhouseUserService service;

  @Autowired
  private UserService userService;

  @Autowired
  private PigFileService pigFileService;

  @Autowired
  private AndSlaughterhouseUserMapper dao;

  @Autowired
  private SlaughterhouseService slaughterhouseService;

  private Long count = 0l;

  /**
   * 批量录入生猪信息
   *
   * @param file excel文件信息
   * @param userId 用户id
   * @param slaughterhouseId 屠宰场id
   * @return ResponseVO
   */
  @RequestMapping(value = "/sign/and_slaughter_house/addList")
  @ResponseBody
  public ResponseVO addList(MultipartFile file,
      @RequestParam(value = "slaughterhouseId", required = false) String slaughterhouseId,
      @RequestParam(value = "userId", required = false) String userId) {

    ResponseVO vo = new ResponseVO();
    if (StringUtils.isBlank(slaughterhouseId) || StringUtils.isBlank(userId) || file.isEmpty()) {
      vo.setCode("400");
      vo.setMessage("参数错误");
      return vo;
    }

    try {
      List<String> pIds = PoiImport.importExcel(file.getInputStream(), file.getOriginalFilename());//获取excel文件内容
      AndSlaughterhouseUser slaughterhouseUser = new AndSlaughterhouseUser();
      slaughterhouseUser.setUserId(userId);
      slaughterhouseUser.setSlaughterhouseId(slaughterhouseId);
      if (pIds != null && pIds.size() > 0) {
        for (String pid : pIds) {
          slaughterhouseUser.setPigId(pid);
          vo = add(slaughterhouseUser);
          if (!vo.getCode().equals("0")) {
            vo.setMessage(vo.getMessage() + pid);
            return vo;
          }
        }
      }
    } catch (Exception e) {
      vo.setCode("500");
      vo.setMessage("内部错误");
    }
    return vo;
  }

  /**
   * 生猪录入
   */
  @RequestMapping(value = "/sign/and_slaughter_house/add", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO add(AndSlaughterhouseUser vo) {
    ResponseVO responseVO = new ResponseVO();
    if (pigFileService.existPigId(vo.getPigId())) {
      responseVO.setCode("800");
      responseVO.setMessage("猪ID不存在！");
      return responseVO;
    }
    if (vo.getSlaughterhouseId() == null && vo.getUserId() != null) {
      List<OptionVo> ops = slaughterhouseService.findUserOption(vo.getUserId());
      if (ops != null && ops.size() > 0) {
        vo.setSlaughterhouseId(ops.get(0).getKey());
      }
    }
    PigFile pigFile = pigFileService.findPigfileBySign(vo.getPigId());
    if (pigFile != null) {
      // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
      Integer pigStatus = pigFile.getPigStatus();
      if (pigStatus == null) {
        responseVO.setCode("800");
        responseVO.setMessage("此猪ID状态为空,异常数据不能录入！");
        return responseVO;
      }
      if (pigStatus != 2) {
        responseVO.setCode("800");
        responseVO.setMessage("猪ID非待屠宰录入状态，不能录入！");
        return responseVO;
      }
    }
    if (service.existPigId(vo.getPigId())) {
      responseVO.setCode("800");
      responseVO.setMessage("该猪已被本屠宰场或其他屠宰场录入，不能重复录入;");
    } else {
      boolean flag = service.add(vo);
      responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
      responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
          : ConstantsUtil.RES_FAIL_MESSAGE);
    }

    return responseVO;
  }

  /**
   * 生猪是否存在 是否可以录入
   */
  @RequestMapping(value = "/sign/and_slaughter_house/exist_pig", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO existPigId(@RequestParam(value = "pigId", required = true) String pigId) {
    ResponseVO responseVO = new ResponseVO();
    if (pigFileService.existPigId(pigId)) {
      responseVO.setCode("800");
      responseVO.setMessage("猪ID不存在！");
      return responseVO;
    }

    PigFile pigFile = pigFileService.findPigfileBySign(pigId);
    if (pigFile != null) {
      // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
      Integer pigStatus = pigFile.getPigStatus();
      if (pigStatus == null) {
        responseVO.setCode("800");
        responseVO.setMessage("此猪ID状态为空,异常数据不能录入！");
        return responseVO;
      }
    }

    responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
    responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
    return responseVO;
  }

  /**
   * 用户屠宰场关联建立
   */
  @RequestMapping(value = "/sign/and_slaughter_house/add_user_slaughter", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO addUserSlaughter(AndSlaughterhouseUser vo) {

    boolean flag = service.addUserSlaughter(vo);
    ResponseVO responseVO = new ResponseVO();
    responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
    responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
        : ConstantsUtil.RES_FAIL_MESSAGE);
    return responseVO;
  }

  /**
   * 生猪屠宰
   */
  @RequestMapping(value = "/sign/and_slaughter_house/slaughter", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO slaughter(AndSlaughterhouseUser svo) {
    ResponseVO responseVO = new ResponseVO();
    if (svo.getId() == null) {

      List<OptionVo> vos = slaughterhouseService.findUserOption(svo.getUserId());
      if (vos != null && vos.size() > 0) {
        svo.setSlaughterhouseId(vos.get(0).getKey());
      } else {
        responseVO.setCode("800");
        responseVO.setMessage("登录用户非屠宰人员，屠宰失败！");
        return responseVO;
      }
      responseVO = this.add(svo);
      if (responseVO != null && responseVO.getCode() != null
          && responseVO.getCode().equals("800")) {
        return responseVO;
      }
    }

    AndSlaughterhouseUser vo = dao.findById(svo.getId());
    if (vo != null) {
      PigFile pigFile = pigFileService.findPigfileBySign(vo.getPigId());
      if (pigFile != null) {
        // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
        Integer pigStatus = pigFile.getPigStatus();
        if (pigStatus != 3) {
          responseVO.setCode("800");
          responseVO.setMessage("猪ID非待屠宰状态，不能屠宰！");
          return responseVO;
        }
      }
    }
    boolean flag = service.slaughter(svo.getId(), svo.getSlaughterhouseId());

    responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
    responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
        : ConstantsUtil.RES_FAIL_MESSAGE);
    return responseVO;
  }

  /**
   * 分页显示猪列表
   */
  @RequestMapping(value = "/sign/and_slaughter_house/find_pig_list", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO getList(BaseParam param) {
    ResponseVO responseVO = new ResponseVO();
    try {
      List<SlaughterhousePigVo> vos = service.findListByPid(param);

      count = service.findListCountByPid(param);
      responseVO = new ResponseVO(count, count, vos);
      responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
      responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);

      return responseVO;
    } catch (Exception e) {
      e.printStackTrace();
      responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
      responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
      return responseVO;
    }
  }

  /**
   * 猪列表
   */
  @RequestMapping(value = "/sign/and_slaughter_house/find_pigs", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO getLists(BaseParam param) {
    ResponseVO responseVO = new ResponseVO();
    try {
      List<SlaughterhousePigVo> vos = service.findList(param);

      responseVO = new ResponseVO();
      responseVO.setData(vos);
      responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
      responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);

      return responseVO;
    } catch (Exception e) {
      e.printStackTrace();
      responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
      responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
      return responseVO;
    }
  }
}
