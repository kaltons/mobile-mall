package com.yanfang.mobilemall.dto;

import lombok.Data;

/**
 * TODO
 * 订单业务数据模型，从前端传回的数据模型抽取所需的属性，写入数据库
 * @author 衍方
 * @date 2020/7/6 - 14:18
 */
@Data
public class OrderDTO {

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 商品规格编号
     */
    private Integer specsId;

    /**
     * 商品购买数量
     */
    private Integer goodsQuantity;

}
