package com.macro.mall.service;

import com.macro.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * 优惠券领取记录管理Service
 */
public interface SmsCouponHistoryService {
    /**
     * 分页查询优惠券领取记录
     * @param couponId
     * @param useStatus
     * @param orderSn
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsCouponHistory> list(Long couponId,Integer useStatus,String orderSn,Integer pageSize,Integer pageNum);
}
