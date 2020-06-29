package com.huzh.springcloud.controller;

import com.huzh.springcloud.domain.CommonResult;
import com.huzh.springcloud.domain.Order;
import com.huzh.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huzh
 * @date 2020/6/28 18:53
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}