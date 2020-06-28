package com.huzh.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.huzh.springcloud.entities.CommonResult;

/**
 * @author huzh
 * @date 2020/6/28 11:02
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}
