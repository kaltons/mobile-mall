package com.yanfang.mobilemall.exception;

import com.yanfang.mobilemall.enums.ResultEnum;

/**
 * TODO
 * 自定义商品异常
 * @author 衍方
 * @date 2020/7/5 - 23:57
 */
public class GoodsException extends RuntimeException{

    public GoodsException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }

    //构造方法，控制层调用
    public GoodsException(String error) {
        super(error);
    }
}
