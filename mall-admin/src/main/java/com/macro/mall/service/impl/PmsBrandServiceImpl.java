package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.PmsBrandParam;
import com.macro.mall.mapper.PmsBrandMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsBrandExample;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductExample;
import com.macro.mall.service.PmsBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrandParam brandParam) {
        PmsBrand brand = new PmsBrand();
        BeanUtils.copyProperties(brandParam, brand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(brand.getFirstLetter())) {
            brand.setFirstLetter(brand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long brandId, PmsBrandParam brandParam) {
        PmsBrand brand = new PmsBrand();
        BeanUtils.copyProperties(brandParam, brand);
        brand.setId(brandId);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(brand.getFirstLetter())) {
            brand.setFirstLetter(brand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        PmsProduct product = new PmsProduct();
        product.setBrandName(brand.getName());
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andBrandIdEqualTo(brandId);
        productMapper.updateByExampleSelective(product, example);

        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long brandId) {
        return brandMapper.deleteByPrimaryKey(brandId);
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample example = new PmsBrandExample();
        example.setOrderByClause("sort desc");
        PmsBrandExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public PmsBrand getBrand(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand brand = new PmsBrand();
        brand.setShowStatus(showStatus);
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(brand, example);
    }

    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        PmsBrand brand = new PmsBrand();
        brand.setFactoryStatus(factoryStatus);
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(brand, example);
    }
}
