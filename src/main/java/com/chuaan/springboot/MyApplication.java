
package com.chuaan.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 外置tomcat部署
 * author:chuaan
 * created:2019-01-09
 **/


@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(MyApplication.class);
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MyApplication.class,args);
    }
}
