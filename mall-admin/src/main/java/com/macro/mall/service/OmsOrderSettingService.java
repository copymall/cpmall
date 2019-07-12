package com.macro.mall.service;

import com.macro.mall.model.OmsOrderSetting;

/**
 * 订单设置Service
 */
public interface OmsOrderSettingService {

    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     * */
    int update(Long id, OmsOrderSetting orderSetting);

}
