package com.yui.forumsystem;

import com.yui.forumsystem.bao.UserMapper;
import com.yui.forumsystem.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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

}
