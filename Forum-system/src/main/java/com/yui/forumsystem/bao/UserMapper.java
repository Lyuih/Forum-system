package com.yui.forumsystem.bao;

import com.yui.forumsystem.model.User;

public interface UserMapper {
    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}