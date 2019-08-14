package com.bjpowernode.settings.service;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.domain.User;

import java.util.List;

/**
 * Author：Rainyu
 * 2019/8/13
 */

public interface UserService {
    User login(String loginAct, String loginPwd,String ip) throws LoginException;

    List<User> getUserList();
}
