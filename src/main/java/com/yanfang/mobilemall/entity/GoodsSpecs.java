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
 * 商品规格表对应的实体类
 * @author 衍方
 * @date 2020/7/5 - 16:34
 */
@Data
@Entity
public class GoodsSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;

    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 规格名称
     */
    private String specsName;

    /**
     * 库存
     */
    private Integer specsStock;

    /**
     * 单价
     */
    private BigDecimal specsPrice;

    /**
     * 封面图
     */
    private String specsIcon;

    /**
     * 预览图
     */
    private String specsPreview;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
