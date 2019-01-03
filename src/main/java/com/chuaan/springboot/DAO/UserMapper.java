package com.chuaan.springboot.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    //修改这个用户的昵称
    @Update("<script> UPDATE user SET nickname = #{nickname} WHERE uid = #{uid}</script>")
    int updateNickname(@Param("nickname") String nickname, @Param("uid") long uid);


}
