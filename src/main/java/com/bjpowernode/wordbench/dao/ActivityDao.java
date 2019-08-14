package com.bjpowernode.wordbench.dao;

import com.bjpowernode.settings.domain.User;
import com.bjpowernode.wordbench.domain.Activity;

import java.util.List;

/**
 * Author：Rainyu
 * 2019/8/14
 */

public interface ActivityDao {
    List<User> getUserList();

    int saveActivity(Activity activity);
}
