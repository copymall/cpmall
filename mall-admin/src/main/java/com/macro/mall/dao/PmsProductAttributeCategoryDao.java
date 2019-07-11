package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

public interface PmsProductAttributeCategoryDao {

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
