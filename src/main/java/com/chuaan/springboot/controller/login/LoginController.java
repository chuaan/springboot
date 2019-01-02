package com.chuaan.springboot.controller.login;

import com.chuaan.springboot.DAO.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.chuaan.springboot.util.SHA256;
import com.chuaan.springboot.account.*;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * author:chuaan
 * created:2019-01-02
 */

@Controller
public class LoginController {


    @Autowired
    private SHA256 sha256;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(HttpSession session,
                           @RequestParam(required = false, value = "message", defaultValue = "") String message) {
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        if(admin!=null && admin.getAdmin()<Admin.REJECT){
            return "AlreadyLogin";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(HttpSession session,
                            @RequestParam("username") String name,
                            @RequestParam("password") String password) {
        String hashPW = null;
        try {
            hashPW = sha256.toSHA256(password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<User> users = userMapper.getAdmin(name,hashPW);
        Admin admin = new Admin(users.get(0));





        if (admin.getAdmin() < Admin.REJECT) {
            session.setAttribute("Current_Admin", admin);


            return "mainpage";
        }
        //      if(name.equals("test") && hashPW.equals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08")){
        //        return "mainpage";
        //  }
        return "say";
    }
}