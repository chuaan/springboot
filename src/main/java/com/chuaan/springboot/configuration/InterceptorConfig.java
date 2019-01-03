package com.chuaan.springboot.configuration;

import com.chuaan.springboot.handler.SecurityHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器，把业务全部放在web里面
 * author:chuaan
 * created:2019-01-03
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SecurityHandler()).addPathPatterns("/web/*");
    }
}
