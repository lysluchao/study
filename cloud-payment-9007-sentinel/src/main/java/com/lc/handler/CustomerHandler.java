package com.lc.handler;

import com.lc.common.entities.CommonResult;

public class CustomerHandler {
    public static CommonResult handlerException1(){
        return new CommonResult(444,"handlerException1",null);
    }

    public static CommonResult handlerException2(){
        return new CommonResult(444,"handlerException2",null);
    }
}
