package com.yanfang.mobilemall.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 * 商品信息表对应的实体类
 * @author 衍方
 * @date 2020/7/5 - 16:12
 */
@Data
@Entity
public class GoodsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品描述
     */
    private String goodsDescription;

    /**
     * 商品库存
     */
    private Integer goodsStock;

    /**
     * 封面图
     */
    private String goodsIcon;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 商品标签
     */
    private String goodsTag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
