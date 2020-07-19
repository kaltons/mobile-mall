package com.yanfang.mobilemall.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * TODO
 * 前端传回后端的地址数据模型
 * @author 衍方
 * @date 2020/7/6 - 1:10
 */
@Data
public class AddressForm {

    /**
     * 地址编号
     */
    private Integer id;

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "电话不能为空")
    private String tel;

    /**
     * 行政单位——省
     */
    @NotEmpty(message = "省不能为空")
    private String province;

    /**
     * 行政单位——市
     */
    @NotEmpty(message = "市不能为空")
    private String city;

    /**
     * 行政单位——县OR区
     */
    @NotEmpty(message = "区不能为空")
    private String county;

    /**
     * 地址编码
     */
    @NotEmpty(message = "编码不能为空")
    private String areaCode;

    /**
     * 买家详细地址
     */
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
