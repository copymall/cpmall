package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.OmsOrderReturnApplyDao;
import com.macro.mall.dto.OmsOrderReturnApplyResult;
import com.macro.mall.dto.OmsReturnApplyQueryParam;
import com.macro.mall.dto.OmsUpdateStatusParam;
import com.macro.mall.mapper.OmsOrderReturnApplyMapper;
import com.macro.mall.model.OmsOrderReturnApply;
import com.macro.mall.model.OmsOrderReturnApplyExample;
import com.macro.mall.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyDao orderReturnApplyDao;

    @Autowired
    private OmsOrderReturnApplyMapper orderReturnApplyMapper;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam returnApplyQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderReturnApplyDao.getList(returnApplyQueryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnApplyExample orderReturnApplyExample = new OmsOrderReturnApplyExample();
        orderReturnApplyExample.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return orderReturnApplyMapper.deleteByExample(orderReturnApplyExample);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return orderReturnApplyDao.getDetail(id);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam updateStatusParam) {

        Integer status = updateStatusParam.getStatus();
        OmsOrderReturnApply orderReturnApply = new OmsOrderReturnApply();
        if (status.equals(1)) {
            //确认退货
            orderReturnApply.setId(id);
            orderReturnApply.setStatus(1);
            orderReturnApply.setReturnAmount(updateStatusParam.getReturnAmount());
            orderReturnApply.setCompanyAddressId(updateStatusParam.getCompanyAddressId());
            orderReturnApply.setHandleTime(new Date());
            orderReturnApply.setHandleMan(updateStatusParam.getHandleMan());
            orderReturnApply.setHandleNote(updateStatusParam.getHandleNote());
        } else if (status.equals(2)) {
            //完成退货
            orderReturnApply.setId(id);
            orderReturnApply.setStatus(2);
            orderReturnApply.setReceiveTime(new Date());
            orderReturnApply.setReceiveMan(updateStatusParam.getReceiveMan());
            orderReturnApply.setReceiveNote(updateStatusParam.getReceiveNote());
        } else if (status.equals(3)) {
            //拒绝退货
            orderReturnApply.setId(id);
            orderReturnApply.setStatus(3);
            orderReturnApply.setHandleTime(new Date());
            orderReturnApply.setHandleMan(updateStatusParam.getHandleMan());
            orderReturnApply.setHandleNote(updateStatusParam.getHandleNote());
        } else {
            return 0;
        }

        return orderReturnApplyMapper.updateByPrimaryKeySelective(orderReturnApply);
    }
}
