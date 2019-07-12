package com.macro.mall.service;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;
import com.macro.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类Service
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 添加商品属性分类
     * */
    int create(String name);

    /**
     * 修改商品属性分类
     * */
    int update(Long id, String name);

    /**
     * 删除单个商品属性分类
     * */
    int delete(Long id);

    /**
     * 获取单个商品属性分类信息
     * */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * 分页获取所有商品属性分类
     * */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取所有商品属性分类及其下属性
     * */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
