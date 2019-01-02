package com.chuaan.springboot.helloworld;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.util.Date;

/**
 * author:chuaan
 * created:2018-12-29
 */

@Controller
public class HelloJspController {

    @RequestMapping("/hellojsp")
    public String helloJsp(Model m) throws Exception{
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if(true)
            throw new Exception("some exception");
        return "hellojsp";
    }
}
