package com.macro.mall.service;

import com.macro.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页品牌管理Service
 */
public interface SmsHomeBrandService {
    /**
     * 添加首页品牌推荐
     * @param homeBrandList
     * @return
     */
    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * 修改品牌推荐排序
     * @param id
     * @param sort
     * @return
     */
    int updateSort(Long id,Integer sort);

    /**
     * 批量删除品牌推荐
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 更新推荐状态
     * @return
     */
    int updateReommendStatus(List<Long> ids,Integer recommendStatus);
    /**
     * 分页查询品牌推荐
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
