package com.yui.forumsystem.bao;

import com.yui.forumsystem.model.Board;

public interface BoardMapper {
    int insert(Board row);

    int insertSelective(Board row);

    Board selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Board row);

    int updateByPrimaryKey(Board row);
}