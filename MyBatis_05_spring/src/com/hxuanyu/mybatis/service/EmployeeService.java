package com.hxuanyu.mybatis.service;

import com.hxuanyu.mybatis.bean.Employee;
import com.hxuanyu.mybatis.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmps(){
        return employeeMapper.getEmps();
    }
}
