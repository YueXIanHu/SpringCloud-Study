package com.huzh.springcloud.service;

import com.huzh.springcloud.entities.CommonResult;
import com.huzh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author huzh
 * @date 2020/6/28 11:59
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}