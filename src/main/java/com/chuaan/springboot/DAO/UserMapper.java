package com.chuaan.springboot.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.chuaan.springboot.account.User;

import java.util.List;

/**
 * author:chuaan
 * created:2018-12-29
 */


@Mapper
@Repository
public interface UserMapper {

    // 测试用
    @Select("select * from user")
    List<User> findAll();


    //登陆的时候确定
    @Select("<script> SELECT uid,admin FROM user WHERE"
            +" username = #{name} AND hashpw = #{hashPW} </script>")
    List<User> getAdmin(@Param("name") String name, @Param("hashPW") String hashPW);



}
