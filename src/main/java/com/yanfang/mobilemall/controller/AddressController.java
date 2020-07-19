package com.yanfang.mobilemall.controller;

import com.yanfang.mobilemall.exception.GoodsException;
import com.yanfang.mobilemall.form.AddressForm;
import com.yanfang.mobilemall.service.AddressService;
import com.yanfang.mobilemall.util.ResultVOUtil;
import com.yanfang.mobilemall.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 地址数据类控制器
 * @author 衍方
 * @date 2020/7/6 - 22:24
 */
@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    /**
     * 查找买家地址列表
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }

    /**
     * 新增地址
     * @param addressForm
     * @param bindingResult 接收错误信息
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@RequestBody @Valid AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【新增地址】参数错误,addressForm={}",addressForm);
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }


    /**
     * 修改地址
     * @param addressForm
     * @param bindingResult 接收错误信息
     * @return
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody @Valid AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改地址】参数错误,addressForm={}",addressForm);
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResultVO delete(@PathVariable Integer addressId){
        addressService.deleteById(addressId);

        //封装返回的数据
        Map<String,String> map = new HashMap<>();
        map.put("addressId",addressId.toString());

        return ResultVOUtil.success(map);
    }


}
