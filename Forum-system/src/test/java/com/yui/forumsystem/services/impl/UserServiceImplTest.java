package com.yui.forumsystem.services.impl;

import com.yui.forumsystem.model.User;
import com.yui.forumsystem.services.IUserService;
import com.yui.forumsystem.utils.MD5Util;
import com.yui.forumsystem.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private IUserService iUserService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void createNormalUser() {
        //构建User对象
        User user = new User();
        user.setUsername("test");
        user.setNickname("test");

        //定义一个原始密码
        String password = "123456";

        //生成salt
        String salt = UUIDUtil.UUID_32();
        //生成密码的密文
        String ciphertext = MD5Util.md5Salt(password, salt);
        //设置加密后的密码
        user.setPassword(ciphertext);

        //设置salt
        user.setSalt(salt);
        //调用service层的方法
        userServiceImpl.createNormalUser(user);

        //打印结果
        System.out.println(user);
    }
}