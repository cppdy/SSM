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

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
