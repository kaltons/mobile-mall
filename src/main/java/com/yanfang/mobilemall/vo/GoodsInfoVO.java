package com.yanfang.mobilemall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TODO
 * 返回给前端首页视图层的基础对象 —— 商品详情数据
 * @author 衍方
 * @date 2020/7/5 - 20:52
 */
@Data
@AllArgsConstructor
public class GoodsInfoVO {

    /**
     * 商品编号
     */
    @JsonProperty("id")
    private Integer goodsId;

    /**
     * 商品名称
     */
    @JsonProperty("title")
    private String goodsName;

    /**
     * 商品单价
     */
    @JsonProperty("price")
    private String goodsPrice;

    /**
     * 商品描述
     */
    @JsonProperty("desc")
    private String goodsDescription;

    /**
     * 商品标签
     */
    private List<Map<String,String>> tag;

    /**
     * 封面图
     */
    @JsonProperty("thumb")
    private String goodsIcon;
}
