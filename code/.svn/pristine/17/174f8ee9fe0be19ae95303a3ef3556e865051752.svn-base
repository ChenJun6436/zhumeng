package com.zmt.zmtofficialwebsite.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zmt.zmtofficialwebsite.model.AanvraagType;
import com.zmt.zmtofficialwebsite.model.Case;
import com.zmt.zmtofficialwebsite.service.CaseService;
import com.zmt.zmtofficialwebsite.util.result.PageResultVo;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.CaseAddVo;
import com.zmt.zmtofficialwebsite.vo.CaseVo;

/**
 * 描述: 案例类型
 *
 * @author yt
 * @create 2018-01-09 14:42
 */
@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private CaseService service;

    /**
     * 获取案例
     */
    @RequestMapping("/findByAanvraagTypeId")
    public PageResultVo findByAanvraagTypeId(@RequestParam(value = "aanvraagTypeId", required = false) Long aanvraagTypeId,
                                             @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
                                             @RequestParam(value = "size", required = true, defaultValue = "5") Integer size) {
        try {
            if (page >= 1) {
                page = page - 1;
            }
            List<CaseVo> vos = service.findByAanvraagTypeId(aanvraagTypeId, page, size);
            return new PageResultVo(service.getCount(aanvraagTypeId), vos.size(), vos);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResultVo.error();
        }
    }

    /**
     * 获取案例详情
     */
    @RequestMapping("/findDetails")
    public ResultVo findDetails(@RequestParam(value = "id", required = true) Long id) {
        try {
            Case pojo = service.findDetails(id);
            return new ResultVo(pojo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 获取一个案例
     */
    @RequestMapping("/findVoByAanvraagTypeId")
    public ResultVo findVoByAanvraagTypeId(@RequestParam(value = "aanvraagTypeId", required = false) Long aanvraagTypeId) {
        try {
            return new ResultVo(service.findVoByAanvraagTypeId(aanvraagTypeId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 新增修改案例
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo saveCase(CaseAddVo vo) {
        try {
            Case pojo = new Case();
            pojo.setId(vo.getId());
            pojo.setName(vo.getName());
            pojo.setImgUrl(vo.getImgUrl());
            pojo.setContent(vo.getContent());
            AanvraagType aanvraagType = new AanvraagType();
            aanvraagType.setId(vo.getAanvraagTypeId());
            pojo.setAanvraagType(aanvraagType);
            return new ResultVo(service.save(pojo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo delete(@RequestParam(value = "id", required = true) Long id) {
        try {
            service.del(id);
            return new ResultVo(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

}
