package com.zmt.zmtofficialwebsite.controller.admin;

import com.zmt.zmtofficialwebsite.service.ContactInfoService;
import com.zmt.zmtofficialwebsite.service.FileUploadService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.FormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzw
 * @className:
 * @description:
 * @date 2018年1月11日
 */
@Controller
@RequestMapping("/websit")
public class ContactInfoController {

  @Autowired
  private ContactInfoService contactInfoService;
  @Autowired
  private FileUploadService uploadService;

  /**
   * 官网后台保存修改底部信息
   */
  @RequestMapping(value = "/save/contactInfo", method = RequestMethod.POST)
  @ResponseBody
  public ResultVo saveContactInfomation(@RequestBody FormVo vo) {
    return contactInfoService.saveContactInfo(vo);
  }

  @RequestMapping(value = "/find/contactInfo", method = RequestMethod.GET)
  @ResponseBody
  public ResultVo findContactInfomation() {
    return contactInfoService.findContactInfo();
  }
}
