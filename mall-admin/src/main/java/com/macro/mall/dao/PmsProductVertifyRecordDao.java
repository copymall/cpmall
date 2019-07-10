package com.macro.mall.dao;

import com.macro.mall.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品审核日志自定义dao
 */
public interface PmsProductVertifyRecordDao {

    int insertList(@Param("list") List<PmsProductVertifyRecord> productVertifyRecordList);

}
