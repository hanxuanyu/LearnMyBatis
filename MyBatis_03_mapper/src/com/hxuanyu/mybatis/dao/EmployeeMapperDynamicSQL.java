package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxuanyu
 */
public interface EmployeeMapperDynamicSQL {
    /**
     * 通过if条件查询员工列表
     *
     * @param employee 员工对象
     * @return 员工列表
     */
    public List<Employee> getEmpsByConditionIf(Employee employee);

    /**
     * 通过trim查询员工列表
     *
     * @param employee 员工对象
     * @return 员工列表
     */
    public List<Employee> getEmpsByConditionTrim(Employee employee);

    /**
     * 通过choose条件查询员工列表
     *
     * @param employee 员工对象
     * @return 员工列表
     */
    public List<Employee> getEmpsByConditionChoose(Employee employee);

    /**
     * 根据传入对象的id更新员工信息
     *
     * @param employee 员工信息
     */
    public void updateEmp(Employee employee);


    /**
     * 根据传入的id列表查出对应的员工列表
     *
     * @param ids id列表
     * @return 员工列表
     */
    public List<Employee> getEmpsByConditionForeach(List<Integer> ids);

    /**
     * 批量插入员工
     *
     * @param emps 员工列表
     */
    public void addEmps(@Param("emps") List<Employee> emps);
}
