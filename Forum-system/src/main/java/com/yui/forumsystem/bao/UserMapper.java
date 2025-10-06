package com.yui.forumsystem.bao;

import com.yui.forumsystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);

    /** 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    User selectByUserName(@Param("username") String username);
}