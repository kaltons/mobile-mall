package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * TODO
 * 买家地址表持久化接口测试类
 * @author 衍方
 * @date 2020/7/5 - 16:58
 */
@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository repository;

    /**
     * 查找所有地址信息
     */
    @Test
    void findAll(){
        List<BuyerAddress> list = repository.findAll();

        for (BuyerAddress buyerAddress : list) {
            System.out.println(buyerAddress);
        }
    }

    /**
     * 新增地址
     */
    @Test
    void save(){
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("440105");
        buyerAddress.setBuyerAddress("广东省广州市海珠区仲恺路501号");
        buyerAddress.setBuyerName("老方");
        buyerAddress.setBuyerPhone("15219612176");
        repository.save(buyerAddress);
    }

    /**
     * 修改地址
     */
    @Test
    void update(){

        BuyerAddress buyerAddress = repository.findById(2).get();
        buyerAddress.setBuyerName("小明");
        repository.save(buyerAddress);
    }

    /**
     * 删除地址
     */
    @Test
    void delete(){
        repository.deleteById(6);
    }

}