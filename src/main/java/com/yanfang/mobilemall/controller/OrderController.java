package com.yanfang.mobilemall.controller;

import com.yanfang.mobilemall.dto.OrderDTO;
import com.yanfang.mobilemall.exception.GoodsException;
import com.yanfang.mobilemall.form.OrderForm;
import com.yanfang.mobilemall.service.OrderService;
import com.yanfang.mobilemall.util.ResultVOUtil;
import com.yanfang.mobilemall.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 订单类类控制器
 * @author 衍方
 * @date 2020/7/6 - 22:54
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@RequestBody @Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,orderForm={}",orderForm);
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setGoodsQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.create(orderDTO);
        //封装返回的数据
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        return ResultVOUtil.success(map);
    }

    /**
     * 根据订单编号查看订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/detail/{orderId}")
    public ResultVO findOrederDetail(@PathVariable("orderId") String orderId){
        return ResultVOUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    /**
     * 根据订单编号修改支付状态
     * @param orderId
     * @return
     */
    @PutMapping("/pay/{orderId}")
    public ResultVO pay(@PathVariable("orderId") String orderId){
        //封装返回的数据
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultVOUtil.success(map);
    }
}
