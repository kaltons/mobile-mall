package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO
 * 订单主表持久化接口测试类
 * @author 衍方
 * @date 2020/7/5 - 20:10
 */
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    /**
     * 查找所有订单
     */
    @Test
    void findAll() {

        List<OrderMaster> list = repository.findAll();

        for (OrderMaster orderMaster : list) {
            System.out.println(orderMaster);
        }

        //测试
        System.out.println("Hello git");
    }

    /**
     * 新增订单
     */
    @Test
    void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456987");
        orderMaster.setBuyerName("小明");
        orderMaster.setBuyerPhone("15219612176");
        orderMaster.setBuyerAddress("广东省广州市海珠区仲恺路501号");
        orderMaster.setGoodsId(1);
        orderMaster.setGoodsName("华为笔记本");
        orderMaster.setGoodsQuantity(1);
        orderMaster.setGoodsIcon("../static/XXX.jpg");
        orderMaster.setSpecsId(1);
        orderMaster.setSpecsName("13.9寸");
        orderMaster.setSpecsPrice(new BigDecimal(899900));
        orderMaster.setOrderAmount(new BigDecimal(8999));
        orderMaster.setPayStatus(0);
        repository.save(orderMaster);
    }

    /**
     * 根据编号查找订单
     */
    @Test
    void findById(){
        OrderMaster orderMaster = repository.findById("123456987").get();
        System.out.println(orderMaster);
    }

    /**
     * 更新订单支付状态
     */
    @Test
    void pay(){
        OrderMaster orderMaster = repository.findById("123456987").get();
        orderMaster.setPayStatus(1);
        repository.save(orderMaster);
    }
}