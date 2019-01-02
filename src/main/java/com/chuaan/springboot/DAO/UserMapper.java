package com.chuaan.springboot.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:chuaan
 * created:2018-12-29
 */


@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

}
