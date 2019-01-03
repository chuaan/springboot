package com.chuaan.springboot.helloworld;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld
 * author:chuaan
 * created:2018.12.28
 */

@RestController
public class HelloController {
    @RequestMapping("web/hello")
    public String hello(){
        String abc = "Hello Spring Boot reboot!";
        return abc;
    }

}
