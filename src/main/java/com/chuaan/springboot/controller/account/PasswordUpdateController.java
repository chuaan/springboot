package com.chuaan.springboot.controller.account;

import com.chuaan.springboot.DAO.UserMapper;
import com.chuaan.springboot.account.Admin;
import com.chuaan.springboot.account.User;
import com.chuaan.springboot.service.account.UserAlert;
import com.chuaan.springboot.service.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * author:chuaan
 * created:2019-01-07
 */

@Controller
@RequestMapping("/web")
public class PasswordUpdateController {


    private final UserMapper userMapper;

    private final SHA256 sha256;

    private final UserAlert userAlert;

    @Autowired
    public PasswordUpdateController(UserMapper userMapper, SHA256 sha256, UserAlert userAlert){
        this.userMapper = userMapper;
        this.sha256 = sha256;
        this.userAlert = userAlert;
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String getUser(){
        return "web/password";
    }


    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String updateUser(HttpSession session, HttpServletResponse response,
                             @RequestParam("originPassword") String originPassword,
                             @RequestParam("password") String password,
                             @RequestParam("password2") String password2){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        List<String> hashPWs = userMapper.getPassword(admin.getUid());
        String originHashPW = hashPWs.get(0);
        if(sha256.toSHA256(originPassword).equals(originHashPW) && password.equals(password2)){
            userMapper.updatePassword(sha256.toSHA256(password), admin.getUid());
            return "redirect:/web/logout";
        }else{
            userAlert.errorPasswordChange(response);
        }

        return "redirect:/web/mainpage";
    }
}
