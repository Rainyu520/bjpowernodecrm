package com.bjpowernode.settings.user;

import com.bjpowernode.utils.DateTimeUtil;
import com.bjpowernode.utils.MD5Util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author：Rainyu
 * 2019/8/13
 */

public class Test01 {
    public static void main(String[] args) {
         /*

            当账号密码验证正确的时候，需要从user对象中取出其他相应信息继续进行登录的验证

            需要验证失效时间
            需要验证锁定状态
            需要验证ip地址
e
         */
        //验证失效时间
        //失效时间
       /* String  expiretime = "2019-08-10 10:10:10";
        String currentSysTime = DateTimeUtil.getSysTime();
        int count = expiretime.compareTo(currentSysTime);
        System.out.println(count);*/

        //验证锁定状态
        /*String ip = "192.168.1.9";
        String allowIps = "192.168.1.9,192,168.1.2";
        if (!allowIps.contains(ip)){
            System.out.println("ip地址受限");
        }*/
        //将密码进行MD5方式加密
        String pw = "123";
        pw = MD5Util.getMD5(pw);
        System.out.println(pw);


    }
}
