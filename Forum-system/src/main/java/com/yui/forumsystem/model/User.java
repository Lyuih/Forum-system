package com.yui.forumsystem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("用户信息")
@Data
public class User {
    private Long id;
    @ApiModelProperty("用户名")
    private String username;

    private String password;

    private String nickname;

    private String phoneNum;

    private String email;

    private Byte gender;

    private String salt;

    private String avatarUrl;

    private Integer articleCount;

    private Byte isAdmin;

    private String remark;

    private Byte state;

    private Byte deleteState;

    private Date createTime;

    private Date updateTime;


}