package com.macro.mall.service;

import com.macro.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
