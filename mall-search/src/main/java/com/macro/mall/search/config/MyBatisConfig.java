package com.macro.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.macro.mall.mapper","com.macro.mall.search.dao"})
public class MyBatisConfig {
}
