package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.dto.OrderDTO;
import com.yanfang.mobilemall.entity.GoodsInfo;
import com.yanfang.mobilemall.entity.GoodsSpecs;
import com.yanfang.mobilemall.entity.OrderMaster;
import com.yanfang.mobilemall.enums.PayStatusEnum;
import com.yanfang.mobilemall.enums.ResultEnum;
import com.yanfang.mobilemall.exception.GoodsException;
import com.yanfang.mobilemall.repository.GoodsInfoRepository;
import com.yanfang.mobilemall.repository.GoodsSpecsRepository;
import com.yanfang.mobilemall.repository.OrderMasterRepository;
import com.yanfang.mobilemall.service.GoodsService;
import com.yanfang.mobilemall.service.OrderService;
import com.yanfang.mobilemall.util.KeyUtil;
import com.yanfang.mobilemall.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * TODO
 * 订单数据业务类接口实现类
 * @author 衍方
 * @date 2020/7/6 - 14:28
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsSpecsRepository goodsSpecsRepository;

    @Autowired
    private GoodsInfoRepository goodsInfoRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private GoodsService goodsService;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //创建OrderMaster实体类，用于写入数据库表
        OrderMaster orderMaster = new OrderMaster();
        //将前端传回的DTO数据模型对象的值赋予orderMaster
        BeanUtils.copyProperties(orderDTO,orderMaster);

        //通过OrderDTO传回的商品规格编号，查找规格信息
        GoodsSpecs goodsSpecs = goodsSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if(goodsSpecs == null){
            log.error("【创建订单】规格不存在,phoneSpecs={}",goodsSpecs);
            throw new GoodsException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(goodsSpecs,orderMaster);

        //通过goodsSpecs中的商品编号查找商品信息
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsSpecs.getGoodsId()).get();
        if(goodsInfo == null){
            log.error("【创建订单】商品不存在,phoneInfo={}",goodsInfo);
            throw new GoodsException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(goodsInfo,orderMaster);

        //计算订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        //将数据库取出的商品规格单价由分转为元单位，再乘以数量，加上邮费
        orderAmount = goodsSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getGoodsQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        //生成订单编号
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        //将订单编号写入DTO，传回前端使用
        orderDTO.setOrderId(orderMaster.getOrderId());

        //设置支付状态
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());
        //写入数据库
        orderMasterRepository.save(orderMaster);

        //修改库存
        goodsService.subStock(orderDTO.getSpecsId(),orderDTO.getGoodsQuantity());

        return orderDTO;
    }

    /**
     * 根据订单编号查看订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {

        //New一个OrderDetailVO，用于返回给前端
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        //根据orderId到数据库查找订单详情
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new GoodsException(ResultEnum.ORDER_NOT_EXIST);
        }
        //复制属性值
        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        //将分转化为元单位
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");
        return orderDetailVO;
    }

    /**
     * 根据订单编号修改支付状态
     *
     * @param orderId
     * @return
     */
    @Override
    public String pay(String orderId) {
        //从数据库中获取订单详情
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        //找不到订单
        if(orderMaster == null){
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new GoodsException(ResultEnum.ORDER_NOT_EXIST);
        }
        //查找到订单，订单支付状态为未支付
        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            //写入数据库
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
        }

        return orderId;
    }
}
