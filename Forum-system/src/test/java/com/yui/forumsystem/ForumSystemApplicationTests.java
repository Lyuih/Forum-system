package com.yui.forumsystem;

import com.yui.forumsystem.bao.UserMapper;
import com.yui.forumsystem.model.User;
import com.yui.forumsystem.utils.MD5Util;
import com.yui.forumsystem.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class ForumSystemApplicationTests {

    @Resource
    private DataSource dataSource;

    @Resource
    private UserMapper userMapper;

    @Test
    void testConnection() throws SQLException {
        System.out.println("dataSource = " + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user);
        System.out.println(user.getUsername());
    }



    @Test
    void contextLoads() {
        System.out.println("you can see me");
    }

    @Test
    void testUtils(){
        System.out.println("MD5:"+ MD5Util.md5("123456"));
        System.out.println("UUID_36:"+UUIDUtil.UUID_36());
        System.out.println("UUID_32:"+UUIDUtil.UUID_32());

    }

}
