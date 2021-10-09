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
     * 通过姓名模糊查询员工列表
     *
     * @param lastName 姓名
     * @return map形式的员工集合
     */
    @MapKey("id")
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    /**
     * 通过id查询员工信息，以map、形式返回
     *
     * @param id 员工id
     * @return 包含信息的map
     */
    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    /**
     * 通过姓名模糊查询
     *
     * @param lastName 姓名
     * @return 符合模糊匹配条件的员工列表
     */
    public List<Employee> getEmpByLastNameLike(String lastName);

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
