package com.huzh.springcloud.dao;

import com.huzh.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huzh
 * @date 2020/4/8 10:56
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long deptNo);

    List<Dept> findAll();
}
