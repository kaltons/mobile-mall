package com.yanfang.mobilemall.service;

import com.yanfang.mobilemall.form.AddressForm;
import com.yanfang.mobilemall.vo.AddressVO;

import java.util.List;

/**
 * TODO
 * 地址数据业务类接口
 * @author 衍方
 * @date 2020/7/6 - 0:49
 */
public interface AddressService {

    /**
     * 查找买家地址列表
     * @return
     */
    List<AddressVO> findAll();

    /**
     * 新增地址OR修改地址
     * @param addressForm
     */
    void saveOrUpdate(AddressForm addressForm);

    /**
     * 根据地址编号删除地址
     * @param addressId
     */
    void deleteById(Integer addressId);

}
