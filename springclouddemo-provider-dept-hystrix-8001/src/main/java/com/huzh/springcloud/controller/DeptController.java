package com.huzh.springcloud.controller;

import com.huzh.springcloud.entity.Dept;
import com.huzh.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huzh
 * @date 2020/4/811:23
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    //一旦调用服务方法失败并抛出了异常信息之后，会自动调用@HystrixCommand标注好的fallbackMethod，调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("该Id：" + id + "没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptNo(id).setDeptName("该Id" + id + "没有对应的信息,null -- @HystrixCommand")
                .setDbSource("no this database in MySql");
    }

    @GetMapping("/dept/list")
    public List<Dept> get() {
        return deptService.list();
    }

    /**
     * 增加自己服务描述的接口
     *
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务" + list.size());

        //查询SPRINGCLOUDDEMO-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUDDEMO-DEPT");

        //打印SPRINGCLOUDDEMO-DEPT服务信息
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }
}
