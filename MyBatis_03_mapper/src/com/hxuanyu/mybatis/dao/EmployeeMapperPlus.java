package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Employee;

import java.util.List;

/**
 * 自定义结果集映射
 *
 * @author hxuanyu
 */
public interface EmployeeMapperPlus {

    /**
     * 通过id分布查询员工对象
     *
     * @param id id
     * @return 员工对象
     */
    public Employee getEmpByIdStep(Integer id);

    /**
     * 通过id查询员工
     *
     * @param id id
     * @return 员工对象
     */
    public Employee getEmpById(Integer id);

    /**
     * 通过id查询部门和员工
     *
     * @param id id
     * @return 员工对象
     */
    public Employee getEmpAndDept(Integer id);

    /**
     * 通过部门id获取员工列表
     *
     * @param id 部门id
     * @return 员工列表
     */
    public List<Employee> getEmpsByDeptId(Integer id);
}
