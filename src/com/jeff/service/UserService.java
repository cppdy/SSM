package com.jeff.service;

import java.util.Map;

import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;

public interface UserService {

    EasyUIDatagrid showPage(User user, Map<String, Integer> map);

    boolean insUser(User user);

    boolean delUser(int id);

    User selUserById(int id);

    boolean updUser(User user);

    void insDemo();

}
