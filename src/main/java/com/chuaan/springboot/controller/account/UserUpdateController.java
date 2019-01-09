package com.chuaan.springboot.controller.account;

import com.chuaan.springboot.DAO.UserMapper;
import com.chuaan.springboot.account.Admin;
import com.chuaan.springboot.account.User;
import com.chuaan.springboot.service.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final SHA256 sha256;

    @Autowired
    public UserUpdateController(UserMapper userMapper, SHA256 sha256){
        this.userMapper = userMapper;
        this.sha256 = sha256;
    }

    //显示用户信息
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

    //修改用户
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String updateUser(HttpSession session, @RequestParam("nickname") String nickname,
                                 @RequestParam("telephone") String telephone){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        userMapper.updateUser(nickname, admin.getUid(), telephone);
        return "redirect:/web/user";
    }

    //删除用户
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public  String deleteUser(HttpSession session, @RequestParam("password") String password){
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        List<String> hashPWs = userMapper.getPassword(admin.getUid());
        String originHashPW = hashPWs.get(0);
        if(sha256.toSHA256(password).equals(originHashPW)){
            userMapper.deleteUser(admin.getUid());
            return "redirect:/web/logout";
        } else{
            return "redirect:/web/mainpage";
        }

    }

}
