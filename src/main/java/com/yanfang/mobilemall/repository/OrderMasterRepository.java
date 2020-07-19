package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * 订单主表对应的持久化接口
 * @author 衍方
 * @date 2020/7/5 - 20:09
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
