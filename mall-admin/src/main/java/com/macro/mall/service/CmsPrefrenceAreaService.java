package com.macro.mall.service;

import com.macro.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 优选专区Service
 */
public interface CmsPrefrenceAreaService {

    /**
     * 获取所有商品优选
     * */
    List<CmsPrefrenceArea> listAll();
}
