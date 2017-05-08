package com.fengze.mybatis.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/5/4.
 */
@Data
public class UserDo extends BaseDo {

    private Long userId;

    private String userName;
    private String password;
    private String realName;
    private String email;
    private String cellphone;
    private String address;
    private String userType;//usertype:1,系统用户;2,会员用户
}
