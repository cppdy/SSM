package com.jeff.service;

import java.util.List;

import com.jeff.entity.User;

public interface UserService {

    List<User> selByPage(User user);

    boolean insUser(User user);

    boolean delUser(int id);

    User selUserById(int id);

    boolean updUser(User user);

    void insDemo();

}
