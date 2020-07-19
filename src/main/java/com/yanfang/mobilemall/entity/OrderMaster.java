package com.yanfang.mobilemall.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 * 订单主表对应的实体类
 * @author 衍方
 * @date 2020/7/5 - 20:02
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class OrderMaster {

    @Id
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
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 购买数量
     */
    private Integer goodsQuantity;

    /**
     * 商品小图
     */
    private String goodsIcon;

    /**
     * 规格编号
     */
    private Integer specsId;

    /**
     * 规格名称
     */
    private String specsName;

    /**
     * 规格单价
     */
    private BigDecimal specsPrice;

    /**
     * 订单总价
     */
    private BigDecimal orderAmount;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
