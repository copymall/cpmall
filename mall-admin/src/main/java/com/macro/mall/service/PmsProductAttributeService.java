package com.macro.mall.service;

import com.macro.mall.dto.PmsProductAttributeParam;
import com.macro.mall.dto.ProductAttrInfo;
import com.macro.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品属性Service
 */
public interface PmsProductAttributeService {

    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 0->属性；2->参数
     * @return
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 添加商品属性
     */
    @Transactional
    int create(PmsProductAttributeParam productAttributeParam);

    /**
     * 修改商品属性
     * */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * 获取单个商品属性信息
     * */
    PmsProductAttribute getItem(Long id);

    /**
     * 批量删除商品属性
     * */
    int delete(List<Long> ids);

    /**
     * 根据商品分类的id获取商品属性及属性分类
     * */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
