package com.yui.forumsystem.bao;

import com.yui.forumsystem.model.ArticleReply;

public interface ArticleReplyMapper {
    int insert(ArticleReply row);

    int insertSelective(ArticleReply row);

    ArticleReply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleReply row);

    int updateByPrimaryKey(ArticleReply row);
}