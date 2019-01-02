package com.chuaan.springboot.controller.hello;

import com.chuaan.springboot.account.User;
import com.chuaan.springboot.DAO.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:chuaan
 * created:2018-12-29
 */

@Controller
public class ListUserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/listUser")
    public String listUser(Model m) throws Exception{
        List<User> users= userMapper.findAll();
        m.addAttribute("users", users);
        return "listUser";

    }
}
