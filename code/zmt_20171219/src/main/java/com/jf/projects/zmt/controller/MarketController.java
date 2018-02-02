package com.jf.projects.zmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.projects.zmt.model.Market;
import com.jf.projects.zmt.service.MarketService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.ConstantsUtil;
import com.jf.projects.zmt.vo.ResponseVO;
import com.jf.projects.zmt.vo.market.MarketDetailsVo;
import com.jf.projects.zmt.vo.market.MarketListVo;
import com.jf.projects.zmt.vo.market.MarketPigVo;
import com.jf.projects.zmt.vo.market.MarketUserDetailsVo;
import com.jf.projects.zmt.vo.market.MarketVo;
import com.jf.projects.zmt.vo.user.UserSearch;

/**
 * @className: MarketController
 * @description:市场中心
 * @author yt
 * @date 2017年10月25日下午3:17:39
 */
@Controller
@RequestMapping("/*")
public class MarketController {

    @Autowired
    private MarketService service;

    @Autowired
    private UserService userService;

    private Long count = 0l;

    /**
     * 分页显示所有市场
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_list_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getList(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<MarketListVo> vos = service.findListByKey(search);
            count = service.findListCountByKey(search);
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
     * 市场新增
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/market/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO add(Market vo) {

        boolean flag = service.add(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 市场修改
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/market/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO update(Market vo) {

        boolean flag = service.update(vo);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 市场启用禁用
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/market/update_status", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO updateStatus(@RequestParam(value = "id", required = true) String id,
                                   @RequestParam(value = "status", required = true) String status) {

        boolean flag = service.updateStatus(id, status);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(flag ? ConstantsUtil.RES_SUCCESS_CODE : ConstantsUtil.RES_FAIL_CODE);
        responseVO.setMessage(flag ? ConstantsUtil.RES_SUCCESS_MESSAGE
                                  : ConstantsUtil.RES_FAIL_MESSAGE);
        return responseVO;
    }

    /**
     * 市场详情
     * 
     * @param vo
     * @return
     */
    @RequestMapping(value = "/sign/market/find_details", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findDetailsById(@RequestParam(value = "id", required = true) String id) {

        MarketDetailsVo vo = service.findDetailsById(id);
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(vo);
            responseVO.setCode(ConstantsUtil.RES_SUCCESS_CODE);
            responseVO.setMessage(ConstantsUtil.RES_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setCode(ConstantsUtil.RES_FAIL_CODE);
            responseVO.setMessage(ConstantsUtil.RES_FAIL_MESSAGE);
        }
        return responseVO;
    }

    /**
     * 获取所有用户
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getType(UserSearch search) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<MarketVo> vos = service.findMarketUserByKey(search);
            count = userService.findMarketUserCountByKey(search);
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
     * 获取市场中心用户详情
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_user_details", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getUserDetails(@RequestParam(value = "id", required = true) String id) {
        ResponseVO responseVO = new ResponseVO();
        try {
            MarketUserDetailsVo vo = service.findUserDetailsByKey(id);
            responseVO.setData(vo);
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
     * 获取所有用户管理的猪列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_pigs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findListByPid(@RequestParam(value = "id", required = true) String id,
                                    @RequestParam(value = "pigId", required = false) String pigId,
                                    @RequestParam(value = "pigBreed", required = false) String pigBreed,
                                    @RequestParam(value = "start", required = false) Integer start,
                                    @RequestParam(value = "length", required = false) Integer length) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<MarketPigVo> vos = service.findListByPid(id, pigBreed, pigId, start, length);
            count = service.findCountById(id);
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
     * 市场下拉数据列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_option", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findOption() {
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO.setData(service.findOption());
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
     * 屠宰销售市场下拉列表
     * 
     * @return
     */
    @RequestMapping(value = "/sign/market/find_com_list_key", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO findComListByKey(@RequestParam(value = "key", required = false) String key) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<Market> vos = service.findComListByKey(key);
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
