package com.macro.mall.service;

import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 优惠券管理Service
 */
public interface SmsCouponService {
    /**
     * 添加优惠券
     * @return
     */
    @Transactional
    int create(SmsCouponParam couponParam);

    /**
     * 根据优惠券id
     * @param id删除优惠券
     * @return
     */
    @Transactional
    int delete(Long id);

    /**
     * 根据优惠券id更新优惠券信息
     * @param id
     * @param couponParam
     * @return
     */
    @Transactional
    int updata(Long id,SmsCouponParam couponParam);

    /**
     * 分页获取优惠券列表
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 获取优惠券详情
     * @param id 优惠券表id
     */
    SmsCouponParam getItem(Long id);
}
