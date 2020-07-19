package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.entity.GoodsCategory;
import com.yanfang.mobilemall.entity.GoodsInfo;
import com.yanfang.mobilemall.entity.GoodsSpecs;
import com.yanfang.mobilemall.enums.ResultEnum;
import com.yanfang.mobilemall.exception.GoodsException;
import com.yanfang.mobilemall.repository.GoodsCategoryRepository;
import com.yanfang.mobilemall.repository.GoodsInfoRepository;
import com.yanfang.mobilemall.repository.GoodsSpecsRepository;
import com.yanfang.mobilemall.service.GoodsService;
import com.yanfang.mobilemall.util.GoodsUitl;
import com.yanfang.mobilemall.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 * 商品数据业务类接口实现类
 * @author 衍方
 * @date 2020/7/5 - 21:05
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsCategoryRepository goodsCategoryRepository;

    @Autowired
    private GoodsInfoRepository goodsInfoRepository;

    @Autowired
    private GoodsSpecsRepository goodsSpecsRepository;
    /**
     * 获取首页数据
     *
     * @return
     */
    @Override
    public DataVO findDataVO() {
        //返回前端的VO数据
        DataVO dataVO = new DataVO();
        //从数据库中查找所有商品类目
        List<GoodsCategory> goodsCategoryList = goodsCategoryRepository.findAll();
        //使用JDK8新特性对类对象进行属性赋值
        List<GoodsCategoryVO> goodsCategoryVOList = goodsCategoryList.stream()
                .map(e -> new GoodsCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        //为DataVO的属性赋值
        dataVO.setCategories(goodsCategoryVOList);

        //从数据库中查找所有商品详情信息
        List<GoodsInfo> goodsInfoList = goodsInfoRepository.findAllByCategoryType(goodsCategoryList.get(0).getCategoryType());
        //使用JDK8新特性对类对象进行属性赋值
        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream()
                .map(e -> new GoodsInfoVO(
                        e.getGoodsId(),
                        e.getGoodsName(),
                        e.getGoodsPrice() + ".00",
                        e.getGoodsDescription(),
                        GoodsUitl.createTag(e.getGoodsTag()),
                        e.getGoodsIcon()
                )).collect(Collectors.toList());
        //为DataVO的属性赋值
        dataVO.setGoods(goodsInfoVOList);
        return dataVO;
    }

    /**
     * 根据类目编号查找商品数据
     *
     * @param categoryType
     * @return
     */
    @Override
    public List<GoodsInfoVO> findGoodsInfoVOByCategoryType(Integer categoryType) {
        //根据类目编号从数据库中商品详情信息
        List<GoodsInfo> goodsInfoList = goodsInfoRepository.findAllByCategoryType(categoryType);
        //使用JDK8新特性对类对象进行属性赋值
        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream()
                .map(e -> new GoodsInfoVO(
                        e.getGoodsId(),
                        e.getGoodsName(),
                        e.getGoodsPrice() + ".00",
                        e.getGoodsDescription(),
                        GoodsUitl.createTag(e.getGoodsTag()),
                        e.getGoodsIcon()
                )).collect(Collectors.toList());

        return goodsInfoVOList;
    }

    /**
     * 根据商品编号获取商品规格信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public SpecsPackageVO findSpecsByGoodsId(Integer goodsId) {
        //根据商品编号到数据库查找商品信息
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsId).get();

        //根据商品编号到数据库查找商品规格信息
        List<GoodsSpecs> goodsSpecsList = goodsSpecsRepository.findAllByGoodsId(goodsId);

        //封装Tree
        List<GoodsSpecsVO> goodsSpecsVOList = new ArrayList<>();  //封装到tree中
        List<GoodsSpecsCasVO> goodsSpecsCasVOList = new ArrayList<>();  //封装到list中

        GoodsSpecsVO goodsSpecsVO;
        GoodsSpecsCasVO goodsSpecsCasVO;

        for (GoodsSpecs goodsSpecs : goodsSpecsList) {
            goodsSpecsVO = new GoodsSpecsVO();
            goodsSpecsCasVO = new GoodsSpecsCasVO();
            //循环拷贝类对象数据
            BeanUtils.copyProperties(goodsSpecs,goodsSpecsVO);
            //循环拷贝类对象数据
            BeanUtils.copyProperties(goodsSpecs,goodsSpecsCasVO);
            //加入数据列表
            goodsSpecsVOList.add(goodsSpecsVO);
            //加入数据列表
            goodsSpecsCasVOList.add(goodsSpecsCasVO);
        }
        //new一个TreeVO对象，开始初次组装
        TreeVO treeVO = new TreeVO();
        treeVO.setV(goodsSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        //new一个SkuVO对象，开始二次组装
        SkuVO skuVO = new SkuVO();
        //将BigDecimal类型转为Integer类型
        Integer price = goodsInfo.getGoodsPrice().intValue();
        //将Integer类型转为String类型
        skuVO.setPrice(price+".00");
        skuVO.setStock_num(goodsInfo.getGoodsStock());
        skuVO.setTree(treeVOList);
        skuVO.setList(goodsSpecsCasVOList);

        //new一个SkuVO对象，开始最终组装
        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        Map<String,String> pic = new HashMap<>();
        pic.put("picture",goodsInfo.getGoodsIcon());
        specsPackageVO.setPic(pic);

        return specsPackageVO;
    }

    /**
     * 下单后减去库存
     *
     * @param specsId
     * @param quantity
     */
    @Override
    public void subStock(Integer specsId, Integer quantity) {

        //根据规格编号获取数据库中商品的规格库存信息
        GoodsSpecs goodsSpecs = goodsSpecsRepository.findById(specsId).get();
        //根据商品规格信息中的商品编号查找商品库存信息
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsSpecs.getGoodsId()).get();

        //规格库存量减去购买量的结果，用于判断是否库存是否足够
        Integer result = goodsSpecs.getSpecsStock() - quantity;
        //库存不足时
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new GoodsException(ResultEnum.GOODS_STOCK_ERROR);
        }
        //重新设置现有库存
        goodsSpecs.setSpecsStock(result);
        //写入数据库
        goodsSpecsRepository.save(goodsSpecs);
        //商品库存量减去购买量的结果，用于判断是否库存是否足够
        result = goodsInfo.getGoodsStock() -quantity;
        //库存不足时
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new GoodsException(ResultEnum.GOODS_STOCK_ERROR);
        }
        //重新设置现有库存
        goodsInfo.setGoodsStock(result);
        goodsInfoRepository.save(goodsInfo);
    }
}
