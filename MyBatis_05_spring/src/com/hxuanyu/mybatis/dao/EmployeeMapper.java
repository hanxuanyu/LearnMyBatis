package com.hxuanyu.mybatis.dao;


import com.hxuanyu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
public interface EmployeeMapper {
    /**
     * 通过id获取员工对象
     *
     * @param id 员工id
     * @return 员工对象
     */
    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();
}
