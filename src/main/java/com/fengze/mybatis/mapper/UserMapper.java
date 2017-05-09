package com.fengze.mybatis.mapper;

import com.fengze.mybatis.domain.UserDo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface UserMapper {
    public UserDo queryById(UserDo userDo);
    public UserDo findById(Integer userId);
    public List<UserDo> queryByList(UserDo userDo);
    public Integer addUser(UserDo userDo);
    public Integer modifyUser(UserDo userDo);
    public Integer delUser(UserDo userDo);
}
