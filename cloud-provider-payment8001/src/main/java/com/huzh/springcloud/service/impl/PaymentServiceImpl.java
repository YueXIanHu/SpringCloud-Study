package com.huzh.springcloud.service.impl;

import com.huzh.springcloud.dao.PaymentDao;
import com.huzh.springcloud.entities.Payment;
import com.huzh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huzh
 * @description TODO
 * @date 2020/6/4 11:46
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
