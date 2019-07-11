package com.macro.mall.service;

import com.macro.mall.dto.SmsFlashPromotionProduct;
import com.macro.mall.model.SmsFlashPromotionProductRelation;

import java.util.List;

/**
 * 限时购商品关联管理Service
 */
public interface SmsFlashPromotionProductRelationService {
    /**
     * 批量添加关联
     * @param relationList
     * @return
     */
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * 修改关联信息
     */
    int update(Long id,SmsFlashPromotionProductRelation relation);

    /**
     * 删除关联
     * @param id
     * @return
     */
    int delete(Long id);
    /**
     * 获取关联详情
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * 分页查询相关商品及促销信息
     * @param flashPromotionId          限时购id
     * @param flashPromotionSessionId   限时购场次id
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId,Long flashPromotionSessionId,Integer pageSize,Integer pageNum);

    /**
     * 根据活动和场次id获取商品关系数量
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);


}
