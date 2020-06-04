package com.huzh.springcloud.service;

import com.huzh.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author huzh
 * @date 2020/4/1622:23
 */
//Feign的面向接口编程
//@FeignClient(value = "SPRINGCLOUDDEMO-DEPT")
/**
 * 修改api工程模块，根据已有的DeptClientService接口新建一个实现了FallbackFactory接口的
 *      类DeptClientServiceFallBackFactory
 * fallbackFactory：集成Hystrix服务降级，还要记得在depte-feign模块 yml开启hystrix（因为fallbackFactory是在注解@FeignClient使用的）
 */
@FeignClient(value = "SPRINGCLOUDDEMO-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
    @PostMapping("/dept/add")
    boolean add(@RequestBody Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> list();
}
