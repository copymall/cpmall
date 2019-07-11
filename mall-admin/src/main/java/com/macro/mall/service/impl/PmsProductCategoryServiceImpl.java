package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.PmsProductCategoryAttributeRelationDao;
import com.macro.mall.dao.PmsProductCategoryDao;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.model.*;
import com.macro.mall.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;

    @Autowired
    private PmsProductCategoryAttributeRelationDao productCategoryAttributeRelationDao;

    @Autowired
    private PmsProductMapper productMapper;

    @Autowired
    private PmsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;

    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Override
    public int create(PmsProductCategoryParam productCategoryParam) {

        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = productCategoryMapper.insertSelective(productCategory);
        //创建筛选属性关联
        List<Long> attributeIdList = productCategoryParam.getProductAttributeIdList();
        if (!CollectionUtils.isEmpty(attributeIdList)) {
            insertRelationList(productCategory.getId(), attributeIdList);
        }
        return count;
    }

    @Override
    public int update(Long id, PmsProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(productCategory.getName());
        PmsProductExample productExample = new PmsProductExample();
        productExample.createCriteria().andProductCategoryIdEqualTo(productCategory.getId());
        int count = productMapper.updateByExampleSelective(product, productExample);
        //同时更新筛选属性的信息
        if (!CollectionUtils.isEmpty(productCategoryParam.getProductAttributeIdList())) {
            PmsProductCategoryAttributeRelationExample attributeRelationExample = new PmsProductCategoryAttributeRelationExample();
            attributeRelationExample.createCriteria().andProductCategoryIdEqualTo(productCategory.getId());
            productCategoryAttributeRelationMapper.deleteByExample(attributeRelationExample);
            insertRelationList(productCategory.getId(), productCategoryParam.getProductAttributeIdList());
        } else {
            PmsProductCategoryAttributeRelationExample attributeRelationExample = new PmsProductCategoryAttributeRelationExample();
            attributeRelationExample.createCriteria().andProductCategoryIdEqualTo(productCategory.getId());
            productCategoryAttributeRelationMapper.deleteByExample(attributeRelationExample);
        }
        return count;
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample productCategoryExample = new PmsProductCategoryExample();
        productCategoryExample.setOrderByClause("sort desc");
        productCategoryExample.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(productCategoryExample);
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        PmsProductCategoryExample productCategoryExample = new PmsProductCategoryExample();
        productCategoryExample.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, productCategoryExample);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
        PmsProductCategoryExample productCategoryExample = new PmsProductCategoryExample();
        productCategoryExample.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, productCategoryExample);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(PmsProductCategory productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }

    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelation> list = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductCategoryId(productCategoryId);
            relation.setProductAttributeId(productAttrId);
            list.add(relation);
        }
        productCategoryAttributeRelationDao.insertList(list);
    }
}
