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

}
