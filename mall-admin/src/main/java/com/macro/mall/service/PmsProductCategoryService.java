package com.macro.mall.service;

import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品分类Service
 */
public interface PmsProductCategoryService {

    /**
     * 添加产品分类
     */
    @Transactional
    int create(PmsProductCategoryParam productCategoryParam);

    /**
     * 修改商品分类
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 分页查询商品分类
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 根据id获取商品分类
     */
    PmsProductCategory getItem(Long id);

    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 修改导航栏显示状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 查询所有一级分类及子分类
     * */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
