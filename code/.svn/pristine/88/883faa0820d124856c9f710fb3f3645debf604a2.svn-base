package com.zmt.zmtofficialwebsite.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmt.zmtofficialwebsite.service.AanvraagTypeService;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;

/**
 * 描述: 案例类型
 *
 * @author yt
 * @create 2018-01-09 14:42
 */
@RestController
@RequestMapping("/aanvraag_type")
public class AanvraagTypeController {

    @Autowired
    private AanvraagTypeService service;

    /**
     * 获取案例类型
     */
    @RequestMapping("/findAll")
    public ResultVo findImage() {

        try {
            return service.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

}
