package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.service.GoodsService;
import com.yanfang.mobilemall.vo.DataVO;
import com.yanfang.mobilemall.vo.GoodsInfoVO;
import com.yanfang.mobilemall.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * TODO
 * 商品数据业务类测试
 * @author 衍方
 * @date 2020/7/5 - 21:36
 */
@SpringBootTest
class GoodsServiceImplTest {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取首页数据
     */
    @Test
    void findDataVO(){
        DataVO dataVO = goodsService.findDataVO();
        System.out.println("衍方测试");
}

    /**
     * 根据类目编号查找商品数据
     */
    @Test
    void findGoodsInfoVOByCategoryType(){
        List<GoodsInfoVO> list = goodsService.findGoodsInfoVOByCategoryType(2);
        System.out.println("衍方测试");
    }

    /**
     * 根据商品编号获取商品规格信息
     */
    @Test
    void findSku(){
        SpecsPackageVO specsPackageVO = goodsService.findSpecsByGoodsId(1);
        System.out.println("衍方测试");
    }

    /**
     * 下单后减去库存
     */
    @Test
    void subStock(){
        goodsService.subStock(1,1);
    }

}