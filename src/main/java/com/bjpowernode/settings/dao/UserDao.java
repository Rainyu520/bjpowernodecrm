package com.bjpowernode.settings.dao;

import com.bjpowernode.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Author：Rainyu
 * 2019/8/13
 */

    public interface UserDao {
    User login(Map<String, String> map);

    List<User> getUserList();
}
