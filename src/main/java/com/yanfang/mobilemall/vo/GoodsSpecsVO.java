package com.yanfang.mobilemall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * TODO
 * 封装商品详情规格视图对象 —— 三次封装
 * @author 衍方
 * @date 2020/7/5 - 22:42
 */
@Data
public class GoodsSpecsVO {

    /**
     * 规格编号
     */
    @JsonProperty("id")
    private Integer specsId;

    /**
     * 规格名称
     */
    @JsonProperty("name")
    private String specsName;

    /**
     * 封面图
     */
    @JsonProperty("imgUrl")
    private String specsIcon;

    /**
     * 预览图
     */
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
