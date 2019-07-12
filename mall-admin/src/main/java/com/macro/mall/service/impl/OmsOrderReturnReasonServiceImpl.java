package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.OmsOrderReturnReasonMapper;
import com.macro.mall.model.OmsOrderReturnReason;
import com.macro.mall.model.OmsOrderReturnReasonExample;
import com.macro.mall.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {

    @Autowired
    private OmsOrderReturnReasonMapper orderReturnReasonMapper;

    @Override
    public int create(OmsOrderReturnReason orderReturnReason) {
        orderReturnReason.setCreateTime(new Date());
        return orderReturnReasonMapper.insert(orderReturnReason);
    }

    @Override
    public int update(Long id, OmsOrderReturnReason orderReturnReason) {
        orderReturnReason.setId(id);
        return orderReturnReasonMapper.updateByPrimaryKey(orderReturnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnReasonExample orderReturnReasonExample = new OmsOrderReturnReasonExample();
        orderReturnReasonExample.createCriteria().andIdIn(ids);
        return orderReturnReasonMapper.deleteByExample(orderReturnReasonExample);
    }

    @Override
    public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        OmsOrderReturnReasonExample orderReturnReasonExample = new OmsOrderReturnReasonExample();
        orderReturnReasonExample.setOrderByClause("sort desc");
        return orderReturnReasonMapper.selectByExample(orderReturnReasonExample);
    }

    @Override
    public OmsOrderReturnReason getItem(Long id) {
        return orderReturnReasonMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        if(!status.equals(0)&&!status.equals(1)){
            return 0;
        }
        OmsOrderReturnReason orderReturnReason = new OmsOrderReturnReason();
        orderReturnReason.setStatus(status);
        OmsOrderReturnReasonExample orderReturnReasonExample = new OmsOrderReturnReasonExample();
        orderReturnReasonExample.createCriteria().andIdIn(ids);
        return orderReturnReasonMapper.updateByExampleSelective(orderReturnReason, orderReturnReasonExample);
    }
}
