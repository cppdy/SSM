package com.jeff.mapper;

import java.util.List;
import java.util.Map;

import com.jeff.entity.User;

public interface UserMapper {

    List<User> selByPage(User user, Map<String, Integer> map);

    long selCountByPageInfo(User user, Map<String, Integer> map);

}
