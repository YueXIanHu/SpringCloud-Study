package com.huzh.springcloud.controller;

import com.huzh.springcloud.entity.Dept;
import com.huzh.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huzh
 * @date 2020/4/8 13:53
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;//Feign面向接口编程

    @GetMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.add(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.list();
    }
}
