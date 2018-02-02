package com.zmt.zmtofficialwebsite.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zmt.zmtofficialwebsite.model.News;
import com.zmt.zmtofficialwebsite.service.NewsService;
import com.zmt.zmtofficialwebsite.util.result.PageResultVo;
import com.zmt.zmtofficialwebsite.util.result.ResultVo;
import com.zmt.zmtofficialwebsite.vo.NewsVo;

/**
 * 描述: 新闻
 *
 * @author yt
 * @create 2018-01-09 14:42
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService service;

    /**
     * 获取新闻类型
     */
    @RequestMapping("/findTypes")
    public ResultVo findTypes() {
        try {
            return new ResultVo(service.findTypes());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 获取新闻列表
     */
    @RequestMapping("/findVos")
    public PageResultVo findVos(@RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
                                @RequestParam(value = "size", required = true, defaultValue = "5") Integer size) {
        try {
            if (page >= 1) {
                page = page - 1;
            }
            List<NewsVo> vos = service.findVos(page, size);
            return new PageResultVo(new Long(service.getCount()), new Long(vos.size()), vos);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResultVo.error();
        }
    }

    /**
     * 获取新闻详情
     */
    @RequestMapping("/findDetails")
    public ResultVo findDetails(@RequestParam(value = "id", required = true) Long id) {
        try {
            News pojo = service.findDetails(id);
            return new ResultVo(pojo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 新增修改新闻
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo save(News vo) {
        try {
            return new ResultVo(service.save(vo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }

    }

    /**
     * 删除新闻
     * 
     * @param vo
     * @return
     */
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
