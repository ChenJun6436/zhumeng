package com.jf.projects.zmt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jf.projects.zmt.dao.AndCheckoutPigMapper;
import com.jf.projects.zmt.dao.PigFlowMapper;
import com.jf.projects.zmt.dao.SUserMapper;
import com.jf.projects.zmt.dao.SlaughterhouseMapper;
import com.jf.projects.zmt.model.AndCheckoutPig;
import com.jf.projects.zmt.model.PigFile;
import com.jf.projects.zmt.model.PigFlow;
import com.jf.projects.zmt.model.SUser;
import com.jf.projects.zmt.model.Slaughterhouse;
import com.jf.projects.zmt.service.CheckoutPigService;
import com.jf.projects.zmt.service.EntryAreaService;
import com.jf.projects.zmt.service.PigFileService;
import com.jf.projects.zmt.service.UserService;
import com.jf.projects.zmt.util.CommonUtil;
import com.jf.projects.zmt.util.UUIDUtil;
import com.jf.projects.zmt.vo.BaseParam;
import com.jf.projects.zmt.vo.OptionVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigsVo;
import com.jf.projects.zmt.vo.checkout.CheckoutPigtVo;
import com.jf.projects.zmt.vo.checkout.PidDetailsVo;

/**
 * @className: UserServiceImpl
 * @description:用户实现
 * @author yt
 * @date 2017年10月19日下午5:11:18
 */

@Service
public class CheckoutPigtServiceImpl implements CheckoutPigService {
    @Autowired
    private AndCheckoutPigMapper dao;

    @Autowired
    private UserService userService;

    @Autowired
    private SUserMapper userDao;

    @Autowired
    private EntryAreaService entryAreaService;

    @Autowired
    private PigFlowMapper pigFlowDao;

    @Autowired
    private PigFileService pigFileService;

    @Autowired
    private SlaughterhouseMapper slaughterhouseDao;

    @Override
    public CheckoutPigtVo findInfoByPigId(String pigId) {
        CheckoutPigtVo vo = new CheckoutPigtVo();
        PigFlow pigFlow = pigFlowDao.findLastByPigId(pigId);
        if (pigFlow != null) {
            String type = pigFlow.getType();
            if (type != null) {
                if (type.equals("1")) {

                    SUser user = userDao.findById(pigFlow.getUserId());
                    vo.setLocation(user.getName());
                    vo.setPhone(user.getTel());
                    vo.setAddress(userService.getAddressById(pigFlow.getUserId()));
                }
                if (type.equals("2")) {
                    Slaughterhouse slaughterhouse = slaughterhouseDao.findById(pigFlow.getUserId());
                    vo.setLocation(slaughterhouse.getName());
                    vo.setPhone(slaughterhouse.getPhone());
                    vo.setAddress(pigFlow.getAddress());
                }
            }

        }
        vo.setId(pigId);
        PigFile pigFile = pigFileService.findPigfileBySign(pigId);
        if (pigFile != null) {
            // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
            Integer pigStatus = pigFile.getPigStatus();
            vo.setStatus(pigStatus);
        }

        return vo;
    }

    @Override
    public boolean add(AndCheckoutPig vo) {
        try {
            boolean flag = true;

            // 1常规检查2宰前检查3宰后检查

            String checkStr = null;
            String status = null;
            Integer checkType = vo.getCheckType();

            if (vo.getType() == 1 || checkType == 1) {
                PigFile pigFile = pigFileService.findPigfileBySign(vo.getPigId());
                if (pigFile != null) {
                    // 生猪状态0正常 1死亡 2待屠宰录入 3待屠宰 4宰后待检验 5待销售 6已处理 7已销售
                    Integer pigStatus = pigFile.getPigStatus();
                    status = CommonUtil.getPigStatusStr(pigStatus);
                }
                checkStr = "注射疫苗";
            }
            if (checkType != null) {

                switch (checkType) {
                case 1:
                    checkStr = "常规检查";
                    break;
                case 2:
                    checkStr = "宰前检查";
                    // status = "待屠宰录入";
                    status = "待屠宰";
                    break;
                case 3:
                    checkStr = "宰后检查";
                    status = "待销售";
                    break;

                }
                if (checkType != 1) pigFileService.updateStatus(vo.getPigId(), checkType == 2 ? 3
                                                                                             : 5);
            }

            if (vo.getType() != 1 && vo.getQuarantineResult() == 0) {
                pigFileService.updateStatus(vo.getPigId(), 6);
                vo.setId(UUID.randomUUID().toString());
                Integer type = vo.getType();
                vo.setType(2);
                vo.setCreateTime(new Date());
                vo.setUpdateTime(new Date());
                flag = dao.insert(vo) > 0;
                vo.setType(type);
                PigFlow pigFlow = new PigFlow();
                pigFlow.setId(UUIDUtil.getUUID());
                pigFlow.setAddress(userService.getAddressById(vo.getUserId()));
                pigFlow.setCreateId(vo.getUserId());
                if (vo.getUserId() != null) pigFlow.setCreaterName(userDao.findById(vo.getUserId())
                                                                          .getName());
                pigFlow.setDescription(vo.getDescribe());
                pigFlow.setPigId(vo.getPigId());
                pigFlow.setStatus("检验异常");
                pigFlow.setThing("生猪处理");
                pigFlow.setRemark(vo.getRemark());
                status = "检验异常";
                pigFlow.setType("3");
                pigFlow.setUserId(vo.getUserId());
                pigFlowDao.insert(pigFlow);
            }
            PigFlow pigFlow = new PigFlow();
            pigFlow.setId(UUIDUtil.getUUID());
            pigFlow.setAddress(userService.getAddressById(vo.getUserId()));
            pigFlow.setCreateId(vo.getUserId());
            if (vo.getUserId() != null) pigFlow.setCreaterName(userDao.findById(vo.getUserId())
                                                                      .getName());
            pigFlow.setDescription(vo.getType() == 1 ? vo.getVaccine() : vo.getDescribe());
            pigFlow.setPigId(vo.getPigId());
            pigFlow.setStatus(status);
            pigFlow.setThing(checkStr);
            pigFlow.setType("3");
            pigFlow.setUserId(vo.getUserId());
            pigFlow.setRemark(vo.getRemark());
            pigFlowDao.insert(pigFlow);
            vo.setId(UUID.randomUUID().toString());
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());
            return flag && dao.insert(vo) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public List<CheckoutPigsVo> findListByPid(BaseParam param) {
        List<CheckoutPigsVo> vos = dao.findListByPid(param);
        for (CheckoutPigsVo vo : vos) {
            String userId = vo.getUserId();
            if (vo.getType() != null && vo.getType() == 1) {
                vo.setDescribe(vo.getVaccine());
            }
            if (userId != null) {
                vo.setAddress(userService.getAddressById(userId));
            }
        }
        return vos;
    }

    @Override
    public Long findListCountByPid(BaseParam param) {

        return dao.findListCountByPid(param);
    }

    @Override
    public PidDetailsVo findPidDetails(String pigId) {

        return dao.findPidDetails(pigId);
    }

    @Override
    public List<OptionVo> getUsers() {

        return dao.getUsers();
    }
}
