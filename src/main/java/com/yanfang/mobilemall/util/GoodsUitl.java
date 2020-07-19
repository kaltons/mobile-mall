package com.yanfang.mobilemall.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * Tag工具类,将从数据库取出的标签转化为前端需要的数据类型
 * @author 衍方
 * @date 2020/7/5 - 21:24
 */
public class GoodsUitl {

    public static List<Map<String,String>> createTag(String tag){
        //将数据库取出的tag标签按&分割
        String[] tags = tag.split("&");
        List<Map<String,String>> list = new ArrayList<>();
        //封装数据
        Map<String,String> map;
        for (String s : tags) {
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}
