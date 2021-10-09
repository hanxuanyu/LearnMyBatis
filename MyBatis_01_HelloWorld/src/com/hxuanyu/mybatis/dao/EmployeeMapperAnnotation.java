package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author hxuanyu
 */
public interface EmployeeMapperAnnotation {

    /**
     * 通过id获取员工对象
     *
     * @param id id
     * @return 员工对象
     */
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}
