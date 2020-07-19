package com.yanfang.mobilemall.enums;

import lombok.Getter;

/**
 * TODO
 * 用于设置订单支付状态的信息
 * @author 衍方
 * @date 2020/7/6 - 14:59
 */
@Getter
public enum PayStatusEnum {

    UNPIAD(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
