package com.jeff.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import com.jeff.service.UserService;
import com.jeff.util.MyBatisUtil;

public class UserServiceImpl implements UserService {

    @Override
    public EasyUIDatagrid showPage(User user, Map<String, Integer> map) {
        SqlSession session = MyBatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.selByPage(user, map);
        long count = userMapper.selCountByPageInfo(user, map);
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        datagrid.setRows(list);
        datagrid.setTotal(count);
        return datagrid;
    }

}
