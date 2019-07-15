package com.macro.mall.service;

import com.macro.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * 订单原因管理Service
 */
public interface OmsOrderReturnReasonService {

    /**
     * 添加订单原因
     * */
    int create(OmsOrderReturnReason orderReturnReason);

    /**
     * 修改订单原因
     * */
    int update(Long id, OmsOrderReturnReason orderReturnReason);

    /**
     * 批量删除订单原因
     * */
    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     * */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * 获取单个退货原因详情信息
     * */
    OmsOrderReturnReason getItem(Long id);

    /**
     * 修改退货原因启用状态
     * */
    int updateStatus(List<Long> ids, Integer status);
}
