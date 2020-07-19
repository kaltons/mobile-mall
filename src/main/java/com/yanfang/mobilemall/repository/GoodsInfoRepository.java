package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO
 * 商品详情的持久化接口
 * @author 衍方
 * @date 2020/7/5 - 16:19
 */
public interface GoodsInfoRepository extends JpaRepository<GoodsInfo,Integer> {

    /**
     * 根据类目编号查找所有该编号的商品信息
     * @param categoryType
     * @return
     */
    public List<GoodsInfo> findAllByCategoryType(Integer categoryType);
}
