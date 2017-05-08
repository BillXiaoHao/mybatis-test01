package com.fengze.mybatis.dao;

import com.fengze.mybatis.domain.UserDo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface UserDao {
    public UserDao queryById(UserDo userDo);
    public UserDao findById(Integer userId);
    public List<UserDo> queryByList(UserDo userDo);
    public Integer addUser(UserDo userDo);
    public Integer modifyUser(UserDo userDo);
    public Integer delUser(UserDo userDo);
}
