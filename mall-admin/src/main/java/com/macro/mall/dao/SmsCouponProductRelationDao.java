package com.macro.mall.dao;

import com.macro.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和产品关系自定义dao
 */
public interface SmsCouponProductRelationDao {
    int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
