package com.macro.mall.dao;

import com.macro.mall.dto.OmsOrderDeliveryParam;
import com.macro.mall.dto.OmsOrderDetail;
import com.macro.mall.dto.OmsOrderQueryParam;
import com.macro.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 */
public interface OmsOrderDao {

    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam orderQueryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> orderDeliveryParamList);

    /**
     * 获取订单详情
     * */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
