package com.bjpowernode.settings.service.impl;

import com.bjpowernode.settings.dao.UserDao;
import com.bjpowernode.utils.SqlSessionUtil;

/**
 * Author：Rainyu
 * 2019/8/13
 */

public class UserServiceImpl {
    private UserDao dao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}
