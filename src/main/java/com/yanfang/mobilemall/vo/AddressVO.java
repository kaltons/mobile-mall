package com.yanfang.mobilemall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO
 * 封装返回给前端的地址信息视图对象
 * @author 衍方
 * @date 2020/7/6 - 0:51
 */
@Data
@AllArgsConstructor
public class AddressVO {

    /**
     * 买家地址编号
     */
    private Integer id;

    /**
     * 地址编码
     */
    private String areaCode;

    /**
     * 买家姓名
     */
    private String name;

    /**
     * 买家电话
     */
    private String tel;

    /**
     * 买家地址
     */
    private String address;
}
