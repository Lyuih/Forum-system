package com.yui.forumsystem.controller;


import com.yui.forumsystem.common.AppResult;
import com.yui.forumsystem.common.ResultCode;
import com.yui.forumsystem.model.User;
import com.yui.forumsystem.services.IUserService;
import com.yui.forumsystem.utils.MD5Util;
import com.yui.forumsystem.utils.UUIDUtil;
import io.micrometer.core.lang.NonNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户接口")
@Slf4j
//这是一个返回数据的Controller
@RestController
//路由映射
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    /**
     * 用户注册
     * @param username 用户名
     * @param nickname 用户昵称
     * @param password 密码
     * @param passwordRepeat 重复密码
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public AppResult register (@ApiParam("用户名") @RequestParam("username") @NonNull String username,
                               @ApiParam("昵称") @RequestParam("nickname") @NonNull String nickname,
                               @ApiParam("密码") @RequestParam("password") @NonNull String password,
                               @ApiParam("确认密码") @RequestParam("passwordRepeat") @NonNull String passwordRepeat) {
//        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(nickname)
//        || StringUtil.isEmpty(password) || StringUtil.isEmpty(passwordRepeat)) {
//            // 返回错误信息
//            return AppResult.failed(ResultCode.FAILED_PARAMS_VALIDATE);
//        }

        // 校验密码与重复密码是否相同
        if (!password.equals(passwordRepeat)) {
            log.warn(ResultCode.FAILED_TWO_PWD_NOT_SAME.toString());
            // 返回错误信息
            return AppResult.failed(ResultCode.FAILED_TWO_PWD_NOT_SAME);
        }
        // 准备数据
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        // 处理密码
        // 1. 生成盐
        String salt = UUIDUtil.UUID_32();
        // 2. 生成密码的密文
        String encryptPassword = MD5Util.md5Salt(password, salt);
        // 3. 设置密码和盐
        user.setPassword(encryptPassword);
        user.setSalt(salt);

        // 调用Service层
        userService.createNormalUser(user);
        // 返回成功
        return AppResult.success();
    }

}
