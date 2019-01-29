package com.jeff.service.impl;

import java.util.List;
import java.util.Map;

import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import com.jeff.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public EasyUIDatagrid showPage(User user, Map<String, Integer> map) {
        List<User> list = userMapper.selByPage(user, map);
        long count = userMapper.selCountByPageInfo(user, map);
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        datagrid.setRows(list);
        datagrid.setTotal(count);
        return datagrid;
    }

    @Override
    public boolean insUser(User user) {

        return userMapper.insUser(user) > 0;
    }

    @Override
    public boolean delUser(int id) {

        return userMapper.delUser(id) > 0;
    }

    @Override
    public User selUserById(int id) {

        return userMapper.selUserById(id);
    }

    @Override
    public boolean updUser(User user) {

        return userMapper.updUser(user) > 0;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insDemo() {
        User user = new User();
        user.setLoginName("cs0129");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserType(0);
        user.setStatus(0);
        userMapper.insUser(user);

        //int num = 6 / 0;

        user.setId(12L);
        user.setLoginName("xgcs0129");
        user.setPassword("xg123456");
        userMapper.updUser(user);

    }

}
