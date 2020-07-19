package com.yanfang.mobilemall.service.impl;

import com.yanfang.mobilemall.entity.BuyerAddress;
import com.yanfang.mobilemall.enums.ResultEnum;
import com.yanfang.mobilemall.exception.GoodsException;
import com.yanfang.mobilemall.form.AddressForm;
import com.yanfang.mobilemall.repository.BuyerAddressRepository;
import com.yanfang.mobilemall.service.AddressService;
import com.yanfang.mobilemall.vo.AddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 * 地址数据业务类接口实现类
 * @author 衍方
 * @date 2020/7/6 - 0:58
 */
@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;
    /**
     * 查找买家地址列表
     *
     * @return
     */
    @Override
    public List<AddressVO> findAll() {
        //使用JDK8新特性对类对象进行属性赋值
        List<AddressVO> list = buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());
        return list;
    }

    /**
     * 新增地址OR修改地址
     *
     * @param addressForm
     */
    @Override
    public void saveOrUpdate(AddressForm addressForm) {

        BuyerAddress buyerAddress;
        //如果买家地址编号为空，新增地址
        if (addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        }else {
            //修改地址，从数据库中取出买家地址信息
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        //获取StringBuffer类，用于拼接买家地址
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }

    /**
     * 根据地址编号删除地址
     *
     * @param addressId
     */
    @Override
    public void deleteById(Integer addressId) {
        BuyerAddress buyerAddress = buyerAddressRepository.findById(addressId).get();
        if (buyerAddress.getAddressId() < 0){
            log.error("【删除地址】地址不存在,buyerAddress={}",buyerAddress);
            throw new GoodsException(ResultEnum.ADDRESS_NOT_EXIST);
        }
        buyerAddressRepository.deleteById(addressId);
    }
}
