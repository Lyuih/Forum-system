package com.yui.forumsystem.services.impl;

import com.yui.forumsystem.bao.UserMapper;
import com.yui.forumsystem.common.AppResult;
import com.yui.forumsystem.common.ResultCode;
import com.yui.forumsystem.exception.ApplicationException;
import com.yui.forumsystem.model.User;
import com.yui.forumsystem.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void createNormalUser(User user) {
        // 1. 非空校验
        if(user == null
            || user.getUsername().isEmpty()
            || user.getNickname().isEmpty()
            || user.getPassword().isEmpty()
            || user.getSalt().isEmpty()) {
            //打印日志
            log.warn(ResultCode.FAILED_PARAMS_VALIDATE.toString());
            throw new ApplicationException(AppResult.failed(ResultCode.FAILED_PARAMS_VALIDATE));
        }
        // 2. 按用户名查询用户信息
        User existsUser = userMapper.selectByUserName(user.getUsername());
        // 2.1 判断用户是否存在
        if(existsUser != null){
            //打印日志
            log.info(ResultCode.AILED_USER_EXISTS.toString());
            //抛出异常
            throw new ApplicationException(AppResult.failed(ResultCode.AILED_USER_EXISTS));
        }
        // 3. 新增用户流程，设置默认值
        user.setGender((byte) 2);
        user.setArticleCount(0);
        user.setIsAdmin((byte) 0);
        user.setState((byte) 0);
        user.setDeleteState((byte) 0);
        // 当前日期
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);

        // 写入数据库
        int row = userMapper.insertSelective(user);
        if (row != 1) {
            // 打印日志
            log.info(ResultCode.FAILED_CREATE.toString());
            // 抛出异常
            throw new ApplicationException(AppResult.failed(ResultCode.FAILED_CREATE));
        }
        // 打印日志
        log.info("新用户成功. username = " + user.getUsername() + ". ");
    }
}
