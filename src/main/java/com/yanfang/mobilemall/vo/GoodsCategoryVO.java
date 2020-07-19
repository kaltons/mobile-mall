package com.yanfang.mobilemall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO
 * 返回给前端首页视图层的基础对象 —— 商品分类数据
 * @author 衍方
 * @date 2020/7/5 - 20:48
 */
@Data
@AllArgsConstructor
public class GoodsCategoryVO {

    /**
     * 类目名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;
}
