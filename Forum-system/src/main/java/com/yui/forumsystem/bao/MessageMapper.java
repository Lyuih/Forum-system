package com.yui.forumsystem.bao;

import com.yui.forumsystem.model.Message;

public interface MessageMapper {
    int insert(Message row);

    int insertSelective(Message row);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message row);

    int updateByPrimaryKey(Message row);
}