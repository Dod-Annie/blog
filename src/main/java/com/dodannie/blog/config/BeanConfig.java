package com.dodannie.blog.config;

import com.dodannie.blog.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dod_Annie
 * @description 将实体类放入Spring容器
 * @date 2020/5/30 21:19
 */
@Configuration
public class BeanConfig {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
