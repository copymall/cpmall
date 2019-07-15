package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.SmsHomeRecommendProductMapper;
import com.macro.mall.model.SmsHomeRecommendProduct;
import com.macro.mall.model.SmsHomeRecommendProductExample;
import com.macro.mall.service.SmsHomeRecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {

    @Autowired
    private SmsHomeRecommendProductMapper homeRecommendProductMapper;

    @Override
    public int create(List<SmsHomeRecommendProduct> homeRecommendProductList) {
        for (SmsHomeRecommendProduct smsHomeRecommendProduct : homeRecommendProductList) {
            smsHomeRecommendProduct.setRecommendStatus(1);
            smsHomeRecommendProduct.setSort(0);
            homeRecommendProductMapper.insert(smsHomeRecommendProduct);
        }

        return homeRecommendProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct homeRecommendProduct = new SmsHomeRecommendProduct();
        homeRecommendProduct.setId(id);
        homeRecommendProduct.setSort(sort);
        return homeRecommendProductMapper.updateByPrimaryKeySelective(homeRecommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendProductExample homeRecommendProductExample = new SmsHomeRecommendProductExample();
        homeRecommendProductExample.createCriteria().andIdIn(ids);
        return homeRecommendProductMapper.deleteByExample(homeRecommendProductExample);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendProductExample homeRecommendProductExample = new SmsHomeRecommendProductExample();
        homeRecommendProductExample.createCriteria().andIdIn(ids);
        SmsHomeRecommendProduct homeRecommendProduct = new SmsHomeRecommendProduct();
        homeRecommendProduct.setRecommendStatus(recommendStatus);
        return homeRecommendProductMapper.updateByExampleSelective(homeRecommendProduct, homeRecommendProductExample);
    }

    @Override
    public List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsHomeRecommendProductExample homeRecommendProductExample = new SmsHomeRecommendProductExample();
        SmsHomeRecommendProductExample.Criteria criteria = homeRecommendProductExample.createCriteria();
        if (!StringUtils.isEmpty(productName)) {
            criteria.andProductNameLike("%" + productName + "%");
        }
        if (recommendStatus != null) {
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        homeRecommendProductExample.setOrderByClause("sort desc");
        return homeRecommendProductMapper.selectByExample(homeRecommendProductExample);
    }
}
