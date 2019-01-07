package com.chuaan.springboot.DAO;

import org.apache.ibatis.annotations.*;
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


    //登陆的时候寻找是否用户 并返回对应用户的Admin
    @Select("<script> SELECT uid,admin FROM user WHERE"
            +" username = #{name} AND hashpw = #{hashPW} </script>")
    List<User> getAdmin(@Param("name") String name, @Param("hashPW") String hashPW);

    //根据uid查找用户
    @Select("<script> SELECT uid,username,nickname,telephone FROM user WHERE"
            +" uid = #{uid}</script>")
    List<User> getUser(@Param("uid") long uid);

    // 插入一个新用户信息
    @Insert("<script>INSERT INTO user VALUES(#{uid},#{name},#{hashPW},#{admin},#{nickname},#{telephone})</script>")
    int insertUser(@Param("uid") long uid,@Param("name") String name,@Param("hashPW") String hashPW, @Param("admin") int admin, @Param("nickname") String nickname, @Param("telephone") String telephone);

    //修改这个用户的可修改信息
    @Update("<script> UPDATE user SET nickname = #{nickname}, telephone = #{telephone} WHERE uid = #{uid}</script>")
    int updateUser(@Param("nickname") String nickname, @Param("uid") long uid, @Param("telephone") String telephone);


}
