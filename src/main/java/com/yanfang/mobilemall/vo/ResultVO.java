package com.yanfang.mobilemall.vo;

import lombok.Data;

/**
 * TODO
 * 最终封装完毕返回给前端的视图层对象
 * @author 衍方
 * @date 2020/7/6 - 21:37
 */
@Data
public class ResultVO<T> {

    /**
     * 返回数据状态编码，0-成功，1-失败
     */
    private Integer code;

    /**
     * 消息提示
     */
    private String msg;

    /**
     * 视图层数据
     */
    private T data;
}
