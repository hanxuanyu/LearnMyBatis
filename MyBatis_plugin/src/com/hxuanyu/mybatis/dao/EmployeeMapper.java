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

    /**
     * 新增员工
     *
     * @param employee 包含员工信息的员工对象
     */
    public void addEmp(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee 要修改的员工
     */
    public void updateEmp(Employee employee);

    /**
     * 通过id删除员工
     *
     * @param id 要删除的员工的id
     */
    public void deleteEmpById(Integer id);
}
