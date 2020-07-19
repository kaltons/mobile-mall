package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * 商品分类表持久化接口测试类
 * @author 衍方
 * @date 2020/7/5 - 15:56
 */
@SpringBootTest
class GoodsCategoryRepositoryTest {

    @Autowired
    private GoodsCategoryRepository repository;

    /**
     * 查找所有商品分类
     */
    @Test
    void findAll(){
        List<GoodsCategory> list = repository.findAll();

        for (GoodsCategory goodsCategory : list) {
            System.out.println(goodsCategory);
        }
    }

    /**
     * 根据类目编号查找分类
     */
    @Test
    void findByCategoryType(){
        GoodsCategory goodsCategory = repository.findByCategoryType(1);
        System.out.println(goodsCategory);
    }
}