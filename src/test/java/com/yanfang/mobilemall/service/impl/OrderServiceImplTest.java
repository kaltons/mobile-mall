package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.dto.OrderDTO;
import com.yanfang.mobilemall.service.OrderService;
import com.yanfang.mobilemall.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 * 订单数据业务类测试
 * @author 衍方
 * @date 2020/7/6 - 15:05
 */
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;
    /**
     * 创建订单
     */
    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("衍方");
        orderDTO.setBuyerPhone("15219612178");
        orderDTO.setBuyerAddress("广东省广州市海珠区仲恺路501号");
        orderDTO.setSpecsId(1);
        orderDTO.setGoodsQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }

    /**
     * 根据订单编号查看订单详情
     */
    @Test
    void findDetail(){
        OrderDetailVO orderDetailVO = orderService.findOrderDetailByOrderId("1594019989431707020");
        System.out.println("衍方测试");
    }

    /**
     * 根据订单编号修改支付状态
     */
    @Test
    void pay(){
        System.out.println(orderService.pay("1594019989431707020"));
    }
}