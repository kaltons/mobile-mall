package com.yanfang.mobilemall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * TODO
 * 封装商品详情规格视图对象 —— 三次封装
 * @author 衍方
 * @date 2020/7/5 - 22:38
 */
@Data
public class GoodsSpecsCasVO {

    /**
     * 规格编号
     */
    @JsonProperty("s1")
    private Integer specsId;

    /**
     * 单价
     */
    @JsonProperty("price")
    private BigDecimal specsPrice;

    /**
     * 库存
     */
    @JsonProperty("stock_num")
    private Integer specsStock;
}
