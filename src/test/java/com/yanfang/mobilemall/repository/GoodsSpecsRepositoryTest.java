package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * 商品规格表持久化接口测试类
 * @author 衍方
 * @date 2020/7/5 - 16:39
 */
@SpringBootTest
class GoodsSpecsRepositoryTest {

    @Autowired
    private GoodsSpecsRepository repository;

    /**
     * 查找所有商品规格信息
     */
    @Test
    void findAll(){
        List<GoodsSpecs> list = repository.findAll();

        for (GoodsSpecs goodsSpecs : list) {
            System.out.println(goodsSpecs);
        }
    }

    /**
     * 根据商品编号查找所属的商品规格信息
     */
    @Test
    void findAllByGoodsId(){

        List<GoodsSpecs> list = repository.findAllByGoodsId(1);

        for (GoodsSpecs goodsSpecs : list) {
            System.out.println(goodsSpecs);
        }
    }

}