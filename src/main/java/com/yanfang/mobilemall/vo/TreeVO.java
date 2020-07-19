package com.yanfang.mobilemall.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 * 封装商品详情规格视图对象 —— 二次封装
 * @author 衍方
 * @date 2020/7/5 - 22:40
 */
@Data
public class TreeVO {

    private String k = "规格";

    /**
     * 三次封装调用
     */
    private List<GoodsSpecsVO> v;

    /**
     * 选中规格标记
     */
    private String k_s = "s1";

}
