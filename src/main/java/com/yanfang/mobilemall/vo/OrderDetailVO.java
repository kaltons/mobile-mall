package com.yanfang.mobilemall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * TODO
 * 封装传回前端的订单详情视图对象
 * @author 衍方
 * @date 2020/7/6 - 15:26
 */
@Data
public class OrderDetailVO {

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
    @JsonProperty("tel")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @JsonProperty("address")
    private String buyerAddress;

    /**
     * 商品购买数量
     */
    @JsonProperty("num")
    private Integer goodsQuantity;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品规格名称
     */
    @JsonProperty("specs")
    private String specsName;

    /**
     * 规格单价
     */
    @JsonProperty("price")
    private String specsPrice;

    /**
     * 封面图
     */
    @JsonProperty("icon")
    private String goodsIcon;

    /**
     * 订单总价
     */
    @JsonProperty("amount")
    private BigDecimal orderAmount;

    /**
     * 订单支付状态
     */
    private Integer payStatus;

    /**
     * 快递邮费
     */
    private Integer freight = 10;
}
