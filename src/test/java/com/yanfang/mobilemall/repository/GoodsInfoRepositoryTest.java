package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * 商品详情表持久化接口测试类
 * @author 衍方
 * @date 2020/7/5 - 16:21
 */
@SpringBootTest
class GoodsInfoRepositoryTest {

    @Autowired
    private GoodsInfoRepository repository;

    /**
     * 查找所有商品详情信息
     */
    @Test
    void findAll(){
        List<GoodsInfo> list = repository.findAll();

        for (GoodsInfo goodsInfo : list) {
            System.out.println(goodsInfo);
        }
    }

    /**
     * 根据类目编号查找所有该编号的商品信息
     */
    @Test
    void findAllByCategoryType(){

        List<GoodsInfo> list = repository.findAllByCategoryType(1);

        for (GoodsInfo goodsInfo : list) {
            System.out.println(goodsInfo);
        }
    }

}