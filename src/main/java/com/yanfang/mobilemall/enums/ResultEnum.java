package com.yanfang.mobilemall.enums;

import lombok.Getter;

/**
 * TODO
 * 用于传入自定义异常的一些枚举错误信息
 * @author 衍方
 * @date 2020/7/6 - 0:01
 */
@Getter
public enum ResultEnum {

    GOODS_STOCK_ERROR(0,"商品库存不足"),
    ORDER_NOT_EXIST(1,"订单不存在"),
    SPECS_NOT_EXIST(2,"规格不存在"),
    PHONE_NOT_EXIST(3,"商品不存在"),
    ADDRESS_NOT_EXIST(3,"商品不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
