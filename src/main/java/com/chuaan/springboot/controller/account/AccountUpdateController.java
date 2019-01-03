package com.chuaan.springboot.controller.account;

import com.chuaan.springboot.DAO.UserMapper;
import com.chuaan.springboot.account.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * author:chuaan
 * created:2019-01-03
 */

@Controller
@RequestMapping("web/update")
public class AccountUpdateController {




    private final UserMapper userMapper;

    @Autowired
    public AccountUpdateController(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    @RequestMapping("/nickname")
    public String updateNickname(HttpSession session, @RequestParam("nickname") String nickname){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        userMapper.updateNickname(nickname, admin.getUid());
        return "web/mainpage";
    }

}
