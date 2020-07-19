package com.yanfang.mobilemall.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * TODO
 * 前端传回后端的订单校验数据模型
 * @author 衍方
 * @date 2020/7/6 - 22:57
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "电话不能为空")
    private String tel;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /**
     * 规格编号
     */
    @NotNull(message = "规格不能为空")
    private Integer specsId;

    /**
     * 购买商品数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;
}
