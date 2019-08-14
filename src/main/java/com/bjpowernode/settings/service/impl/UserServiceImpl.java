package com.bjpowernode.settings.service.impl;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.dao.UserDao;
import com.bjpowernode.settings.domain.User;
import com.bjpowernode.settings.service.UserService;
import com.bjpowernode.utils.DateTimeUtil;
import com.bjpowernode.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：Rainyu
 * 2019/8/13
 */

public class UserServiceImpl implements UserService {
    private UserDao dao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd,String ip) throws LoginException {
        //把用户名密码封装到map集合中
        Map<String,String> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = dao.login(map);
        if (user==null){
            throw new LoginException("用户名密码错误");

        }
        //验证expireTime登录有效期
        if(user.getExpireTime().compareTo(DateTimeUtil.getSysTime())<0) {
            throw new LoginException("登录超时");
        }
        //验证登录状态
        if (user.getLockState().equals("0")){
            throw  new LoginException("处于不可登录状态") ;
        }
        //验证ip受限
        if (!user.getAllowIps().contains(ip)){
            throw  new LoginException("IP受限") ;
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
        List<User> uLIst = dao.getUserList();
        return uLIst;
    }
}
