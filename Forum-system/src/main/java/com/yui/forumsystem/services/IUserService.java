package com.yui.forumsystem.services;

import com.yui.forumsystem.model.User;

/**
 * 用户接口
 */
public interface IUserService {
    /**
     * 创建普通用户
     * @param user
     */
    void createNormalUser(User user);
}
