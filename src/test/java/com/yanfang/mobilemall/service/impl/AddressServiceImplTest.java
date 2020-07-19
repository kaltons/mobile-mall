package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.form.AddressForm;
import com.yanfang.mobilemall.service.AddressService;
import com.yanfang.mobilemall.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * TODO
 * 地址数据业务类测试
 * @author 衍方
 * @date 2020/7/6 - 1:05
 */
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    /**
     * 查找买家地址列表
     */
    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        System.out.println("衍方测试");
    }

    /**
     * 新增地址OR修改地址
     */
    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        //新增地址
//        addressForm.setName("小华");
//        addressForm.setTel("15219612178");
//        addressForm.setProvince("北京市");
//        addressForm.setCity("北京市");
//        addressForm.setCounty("东城区");
//        addressForm.setAreaCode("110101");
//        addressForm.setAddressDetail("XX路500号");
//        addressService.saveOrUpdate(addressForm);

        //修改地址
        addressForm.setId(3);
        addressForm.setName("老华");
        addressForm.setTel("15219612178");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("XX路500号");
        addressService.saveOrUpdate(addressForm);
    }

    /**
     * 删除地址
     */
    @Test
    void deleteById(){
        addressService.deleteById(3);
    }

}