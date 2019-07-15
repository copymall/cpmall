package com.macro.mall.service;

import com.macro.mall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页广告管理Service
 */
public interface SmsHomeAdvertiseService {
    /**
     * 添加广告
     * @param advertise
     * @return
     */
    int create(SmsHomeAdvertise advertise);
    /**
     * 批量删除广告
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改上下线状态
     * @return
     */
    int updateStatus(Long id, Integer status);
    /**
     * 获取广告详情
     * @param id
     * @return
     */
    SmsHomeAdvertise  getItem(Long id);
    /**
     * 更新广告
     * @param id
     * @param advertise
     * @return
     */
    int update(Long id,SmsHomeAdvertise advertise);
    /**
     * 分页查询广告
     * @param namee
     * @param type
     * @param endTime
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeAdvertise> list(String namee, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
