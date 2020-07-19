package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * 买家地址表对应的持久化接口
 * @author 衍方
 * @date 2020/7/5 - 16:56
 */
public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {

}
