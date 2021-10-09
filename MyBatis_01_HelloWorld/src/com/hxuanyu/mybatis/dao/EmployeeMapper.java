package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Employee;

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
}
