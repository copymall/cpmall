package com.macro.mall.service;

import com.macro.mall.model.CmsSubject;

import java.util.List;

/**
 * 商品专题Service
 */
public interface CmsSubjectService {

    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 根据专题名称分页获取专题
     * */
    List<CmsSubject> list(String keyword, Integer pageSize, Integer pageNum);
}
