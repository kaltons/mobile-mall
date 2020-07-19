package com.yanfang.mobilemall.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 * 封装传回前端首页的视图层对象
 * @author 衍方
 * @date 2020/7/5 - 20:47
 */
@Data
public class DataVO {

    /**
     * 封装商品分类数据
     */
    private List<GoodsCategoryVO> categories;

    /**
     * 封装商品详情数据
     */
    private List<GoodsInfoVO> goods;
}
