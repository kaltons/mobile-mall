package com.yanfang.mobilemall.vo;

import lombok.Data;

import java.util.Map;

/**
 * TODO
 * 封装传回前端页面，用户点击购买按钮显示的商品详情规格视图对象
 * @author 衍方
 * @date 2020/7/5 - 22:08
 */
@Data
public class SpecsPackageVO {

    /**
     * 商品展示图
     */
    private Map<String,String> pic;

    /**
     * 商品规格详情
     */
    private SkuVO sku;
}
