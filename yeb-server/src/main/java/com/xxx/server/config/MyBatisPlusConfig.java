package com.xxx.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 分页配置
 *
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.config
 * @Author: zuoyu
 * @CreateTime: 2022-11-01  12:56
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
