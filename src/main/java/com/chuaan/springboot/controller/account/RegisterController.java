package com.chuaan.springboot.controller.account;

import com.chuaan.springboot.service.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.chuaan.springboot.service.util.SHA256;

import javax.servlet.http.HttpServletResponse;

/**
 * 注册的控制器，但是有很多问题没有考虑
 * 输入值范围的确定
 * 返回正确或错误信息
 * 邀请码写在了代码里而不是在数据库中
 * 没有验证码来降低负载
 * 没有防止sql注入
 * 不知道如何解决uid生成
 *
 *
 * author:chuaan
 * created:2019-01-07
 */


@Controller
public class RegisterController {

    private final RegisterService registerService;
    private final SHA256 sha256;

    @Autowired
    RegisterController(RegisterService registerService, SHA256 sha256){
        this.registerService=registerService;
        this.sha256=sha256;
    }

    @RequestMapping("register")
    public String registerGet(){
        return "login/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerPost(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam("password2") String password2,
                               @RequestParam("nickname") String nickname,
                               @RequestParam("telephone") String telephone,
                               @RequestParam("key") String key,
                               HttpServletResponse response){
        int localAdmin;
        if(!"777".equals(key)){
            return "redirect:/login";
        }
        else{
            localAdmin = 1;
        }
        if(password.equals(password2)){
            String hashPW = sha256.toSHA256(password);
            registerService.register(name,hashPW,nickname,localAdmin,telephone,key);
        }

        return "redirect:/login";
    }
}
