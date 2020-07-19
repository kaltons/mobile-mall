package com.yanfang.mobilemall.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 * 封装商品详情规格视图对象 —— 初次封装
 * @author 衍方
 * @date 2020/7/5 - 22:27
 */
@Data
public class SkuVO {

    /**
     * 二次封装调用
     */
    private List<TreeVO> tree;

    /**
     * 三次封装调用
     */
    private List<GoodsSpecsCasVO> list;

    /**
     * 商品单价
     */
    private String price;

    /**
     * 商品库存
     */
    private Integer stock_num;

    /**
     * 是否显示Sku视图对象
     */
    private Boolean none_sku = false;

    /**
     * 是否显示库存
     */
    private Boolean hide_stock = false;
}
