package com.huzh.springcloud.service;

import com.huzh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author huzh
 * @description TODO
 * @date 2020/6/4 11:46
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
