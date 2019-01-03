package com.chuaan.springboot.controller.login;

import com.chuaan.springboot.service.session.UtilSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


/**
 * 退出登陆把Session清空
 * author:chuaan
 * created:2019-01-03
 */

@Controller
@RequestMapping(value="/web")
public class LogoutController {


    private final UtilSession utilSession;

    @Autowired
    public LogoutController(UtilSession utilSession){
        this.utilSession = utilSession;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletResponse response){
        utilSession.clean(session);
       // RememberMeUtil.removePersistenceCookie(response);
        return "redirect:/login";
    }
}
