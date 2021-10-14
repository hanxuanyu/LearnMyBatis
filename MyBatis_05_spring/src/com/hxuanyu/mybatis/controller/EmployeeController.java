package com.hxuanyu.mybatis.controller;

import com.hxuanyu.mybatis.bean.Employee;
import com.hxuanyu.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getEmps")
    public String emps(Map<String, Object> map) {
        List<Employee> list = employeeService.getEmps();
        map.put("emps", list);
        return "list";
    }
}
