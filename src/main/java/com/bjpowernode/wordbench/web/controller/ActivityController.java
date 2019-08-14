package com.bjpowernode.wordbench.web.controller;

import com.bjpowernode.settings.domain.User;
import com.bjpowernode.settings.service.UserService;
import com.bjpowernode.settings.service.impl.UserServiceImpl;
import com.bjpowernode.utils.DateTimeUtil;
import com.bjpowernode.utils.PrintJson;
import com.bjpowernode.utils.ServiceFactory;
import com.bjpowernode.utils.UUIDUtil;
import com.bjpowernode.wordbench.domain.Activity;
import com.bjpowernode.wordbench.service.ActivityService;
import com.bjpowernode.wordbench.service.impl.ActivityServiceImpl;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

/**
 * Author：Rainyu
 * 2019/8/14
 */

public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();
        if ("/workbench/activity/getUserList.do".equals (path)) {
            getUserList (request, response);
        } else if ("/workbench/activity/saveActivity.do".equals (path)) {
            saveActivity (request, response);
        }
    }

    private void saveActivity(HttpServletRequest request, HttpServletResponse response) {
        System.out.println ("进入保存活动控制器");
        ActivityService activityService = (ActivityService) ServiceFactory.getService (new ActivityServiceImpl ());
        //接收参数
        String id = UUIDUtil.getUUID ();

        String owner = request.getParameter ("owner");
        String name = request.getParameter ("name");
        String startDate = request.getParameter ("startDate");
        String endDate = request.getParameter ("endDate");
        String cost = request.getParameter ("cost");
        String description = request.getParameter ("description");
        String createTime = DateTimeUtil.getSysTime ();
        User user = (User)request.getSession ().getAttribute ("user");
        String createBy =user.getName ();
        Activity activity = new Activity ();
        activity.setId (id);
        activity.setOwner (owner);
        activity.setName (name);
        activity.setStartDate (startDate);
        activity.setEndDate (endDate);
        activity.setCost (cost);
        activity.setDescription (description);
        activity.setCreateBy (createBy);
        activity.setCreateTime (createTime);

        System.out.println (activity);
        boolean flag = activityService.saveActivity (activity);
        PrintJson.printJsonFlag (response, flag);



    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println ("进入获得用户信息控制器");
        UserService userService = (UserService) ServiceFactory.getService (new UserServiceImpl ());
        List<User> uList = userService.getUserList ();
        PrintJson.printJsonObj (response, uList);

    }
}
