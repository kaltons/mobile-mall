package com.yanfang.mobilemall.service;

import com.yanfang.mobilemall.vo.DataVO;
import com.yanfang.mobilemall.vo.GoodsInfoVO;
import com.yanfang.mobilemall.vo.SpecsPackageVO;

import java.util.List;

/**
 * TODO
 * 商品数据业务类接口
 * @author 衍方
 * @date 2020/7/5 - 20:42
 */
public interface GoodsService {

    /**
     * 获取首页数据
     * @return
     */
     DataVO findDataVO();

    /**
     * 根据类目编号查找商品数据
     * @param categoryType
     * @return
     */
     List<GoodsInfoVO> findGoodsInfoVOByCategoryType(Integer categoryType);

    /**
     * 根据商品编号获取商品规格信息
     * @param goodsId
     * @return
     */
     SpecsPackageVO findSpecsByGoodsId(Integer goodsId);

    /**
     * 下单后减去库存
     * @param specsId
     * @param quantity
     */
     void subStock(Integer specsId,Integer quantity);
}
