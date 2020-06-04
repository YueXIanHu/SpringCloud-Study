package com.huzh.springcloud.service;

import com.huzh.springcloud.entity.Dept;

import java.util.List;

/**
 * @author huzh
 * @date 2020/4/8 11:09
 */
public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}

