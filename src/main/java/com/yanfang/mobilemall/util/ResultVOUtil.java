package com.yanfang.mobilemall.util;

import com.yanfang.mobilemall.vo.ResultVO;

/**
 * TODO
 * 用于封装Controller层需要的ResultVO视图对象
 * @author 衍方
 * @date 2020/7/6 - 21:52
 */
public class ResultVOUtil {

    //成功返回
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    //失败返回
    public static ResultVO error(String error){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(error);
        resultVO.setData(null);
        return resultVO;
    }
}
