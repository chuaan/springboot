package com.chuaan.springboot.controller.account;

import com.chuaan.springboot.DAO.UserMapper;
import com.chuaan.springboot.account.Admin;
import com.chuaan.springboot.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * author:chuaan
 * created:2019-01-03
 */

@Controller
@RequestMapping("web")
public class UserUpdateController {




    private final UserMapper userMapper;

    @Autowired
    public UserUpdateController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(HttpSession session, Model model){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        List<User> users = userMapper.getUser(admin.getUid());
        User user = users.get(0);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("telephone",user.getTelephone());
        return "web/user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String updateUser(HttpSession session, @RequestParam("nickname") String nickname,
                                 @RequestParam("telephone") String telephone){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        userMapper.updateUser(nickname, admin.getUid(), telephone);
        return "redirect:/web/user";
    }

}
