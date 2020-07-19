package com.yanfang.mobilemall.util;

import java.util.Random;

/**
 * TODO
 * 订单编号随机生成工具
 * @author 衍方
 * @date 2020/7/6 - 14:53
 */
public class KeyUtil {


    //加上synchronized关键字，线程安全
    public static synchronized String createUniqueKey(){
        Random random = new Random();
        //生成6位随机数
        Integer key = random.nextInt(900000)+100000;
        //带上时间戳
        return System.currentTimeMillis() + String.valueOf(key);

    }
}
