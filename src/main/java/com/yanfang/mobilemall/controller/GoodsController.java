package com.yanfang.mobilemall.controller;

import com.yanfang.mobilemall.service.GoodsService;
import com.yanfang.mobilemall.util.ResultVOUtil;
import com.yanfang.mobilemall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * 商品类控制器
 * @author 衍方
 * @date 2020/7/6 - 21:35
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取首页数据
     * @return
     */
    @GetMapping("/index")
    public ResultVO index(){

        return ResultVOUtil.success(goodsService.findDataVO());
    }

    /**
     * 根据类目编号查找商品数据
     * @param categoryType
     * @return
     */
    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return ResultVOUtil.success(goodsService.findGoodsInfoVOByCategoryType(categoryType));
    }

    /**
     * 根据商品编号获取商品规格信息
     * @param goodsId
     * @return
     */
    @GetMapping("/findSpecsByGoodsId/{goodsId}")
    public ResultVO findSpecsByGoodsId(@PathVariable("goodsId") Integer goodsId){
        return ResultVOUtil.success(goodsService.findSpecsByGoodsId(goodsId));
    }

}
