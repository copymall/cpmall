package com.macro.mall.dto;

import com.macro.mall.model.PmsProductCategory;

import java.util.List;

public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {

    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }

}
