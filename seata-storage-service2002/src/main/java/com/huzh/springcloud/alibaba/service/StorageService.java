package com.huzh.springcloud.alibaba.service;

/**
 * @author huzh
 * @date 2020/6/29 10:37
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
