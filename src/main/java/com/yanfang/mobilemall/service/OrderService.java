package com.yanfang.mobilemall.service;

import com.yanfang.mobilemall.dto.OrderDTO;
import com.yanfang.mobilemall.vo.OrderDetailVO;

/**
 * TODO
 * 订单数据业务类接口
 * @author 衍方
 * @date 2020/7/6 - 14:13
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
     OrderDTO create(OrderDTO orderDTO);

    /**
     * 根据订单编号查看订单详情
     * @param orderId
     * @return
     */
     OrderDetailVO findOrderDetailByOrderId(String orderId);

    /**
     * 根据订单编号修改支付状态
     * @param orderId
     * @return
     */
     String pay(String orderId);
}
