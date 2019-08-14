package com.bjpowernode.wordbench.service.impl;

import com.bjpowernode.utils.SqlSessionUtil;
import com.bjpowernode.wordbench.dao.ActivityDao;
import com.bjpowernode.wordbench.dao.ActivityRemarkDao;
import com.bjpowernode.wordbench.domain.Activity;
import com.bjpowernode.wordbench.service.ActivityService;

/**
 * Author：Rainyu
 * 2019/8/14
 */

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession ().getMapper (ActivityDao.class);
    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession ().getMapper (ActivityRemarkDao.class);


    @Override
    public boolean saveActivity(Activity activity) {
        boolean flag = true;
        int i  = activityDao.saveActivity(activity);
        if (i!=1){
            flag=false;
        }

        return flag;
    }
}
