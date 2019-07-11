package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 */
public interface PmsProductCategoryDao {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
