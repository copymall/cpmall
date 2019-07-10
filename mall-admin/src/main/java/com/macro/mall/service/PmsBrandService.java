package com.macro.mall.service;

import com.macro.mall.dto.PmsBrandParam;
import com.macro.mall.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌Service
 */
public interface PmsBrandService {

    /**
     * 获取全部品牌列表
     */
    List<PmsBrand> listAllBrand();

    /**
     * 添加品牌
     */
    int createBrand(PmsBrandParam brandParam);

    /**
     * 更新品牌
     */
    int updateBrand(Long brandId, PmsBrandParam brandParam);

    /**
     * 删除品牌
     */
    int deleteBrand(Long brandId);

    /**
     * 根据品牌名称分页获取品牌列表
     */
    List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据编号查询品牌信息
     */
    PmsBrand getBrand(Long brandId);

    /**
     * 批量删除品牌
     */
    int deleteBrand(List<Long> ids);

    /**
     * 批量更新显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 批量更新厂家制造商状态
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
