package com.chuaan.springboot.service.account;

import com.chuaan.springboot.DAO.UserMapper;
import com.chuaan.springboot.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 *根据输入的用户信息来注册并返回前往的页面
 * author:chuaan
 * created:2019-01-07
 */

@Service
public class RegisterService {

    private final UserMapper userMapper;

    @Autowired
    RegisterService(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public String register(String name, String hashPW, String nickname, int admin,String telephone, String key){
        //暂时用telphone作为uid
        long uid = Long.parseLong(telephone);
            userMapper.insertUser(uid, name, hashPW, admin, nickname, telephone);
        return "login";
    }

}
