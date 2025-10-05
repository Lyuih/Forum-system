package com.yui.forumsystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * MyBatis配置类
 * 指定MyBatis扫描的Mapper接口所在的包路径
 */

@Configuration
@MapperScan("com.yui.forumsystem.bao")
public class MybatisConfig {

}
