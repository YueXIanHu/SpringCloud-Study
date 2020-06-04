package com.huzh.springcloud.service;

import com.huzh.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huzh
 * @description: 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 * @date 2020/6/3 10:56
 */
//@Component 不要忘记添加，不要忘记添加
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    //统一对我们的接口DeptClientService处理熔断
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptNo(id)
                        .setDeptName("该：" + id + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("no this database in MySql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
