package com.yanfang.mobilemall.repository;

import com.yanfang.mobilemall.entity.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * 商品分类的持久化接口
 * @author 衍方
 * @date 2020/7/5 - 15:52
 */
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory,Integer> {

    /**
     * 根据类目编号查找分类
     * @param categoryType
     * @return
     */
    public GoodsCategory findByCategoryType(Integer categoryType);
}
