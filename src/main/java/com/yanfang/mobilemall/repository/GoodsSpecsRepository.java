package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO
 * 商品规格表的持久化接口
 * @author 衍方
 * @date 2020/7/5 - 16:38
 */
public interface GoodsSpecsRepository extends JpaRepository<GoodsSpecs,Integer>{

    /**
     * 根据商品编号查找所属的商品规格信息
     * @param goodsId
     * @return
     */
    public List<GoodsSpecs> findAllByGoodsId(Integer goodsId);
}
