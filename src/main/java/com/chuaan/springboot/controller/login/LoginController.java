package com.chuaan.springboot.controller.login;

import com.chuaan.springboot.DAO.UserMapper;

import com.chuaan.springboot.service.account.UserAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.chuaan.springboot.service.util.SHA256;
import com.chuaan.springboot.account.*;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * author:chuaan
 * created:2019-01-02
 */

@Controller
public class LoginController {

    private final SHA256 sha256;

    private final UserMapper userMapper;

    private final UserAlert userAlert;

    @Autowired
    public LoginController(SHA256 sha256, UserMapper userMapper, UserAlert userAlert){
        this.sha256 = sha256;
        this.userMapper = userMapper;
        this.userAlert = userAlert;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(HttpSession session,
                           @RequestParam(required = false, value = "message", defaultValue = "") String message) {
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        if(admin!=null && admin.getAdmin()<Admin.REJECT){
            return "redirect:/web/mainpage";
        }

        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(HttpSession session,
                            HttpServletResponse response,
                            @RequestParam("username") String name,
                            @RequestParam("password") String password,
                            @RequestParam(required = false,name = "next", defaultValue = "") String next) {
        String hashPW = sha256.toSHA256(password);
        List<User> users = userMapper.getAdmin(name,hashPW);
        Admin admin;
        if(users.isEmpty()){
            admin = new Admin();
        } else{
            admin = new Admin(users.get(0));
        }




        if (admin.getAdmin() < Admin.REJECT) {
            session.setAttribute("Current_Admin", admin);

            if (next!=null && !next.isEmpty()){
                return "redirect:"+next;
            }
            //2019.1.3 改成redirect
            return "redirect:/web/mainpage";
        }
        //      if(name.equals("test") && hashPW.equals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08")){
        //        return "mainpage";
        //  }
  //      userAlert.noSuchUser(response);
        userAlert.userAlert(response,"login error","login");
        return "login/login";
    }
}
