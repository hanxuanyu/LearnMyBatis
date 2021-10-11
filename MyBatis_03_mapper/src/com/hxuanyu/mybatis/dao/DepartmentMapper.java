package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Department;

/**
 * @author hxuanyu
 */
public interface DepartmentMapper {

    /**
     * 根据id查询部门
     *
     * @param id 部门id
     * @return 部门对象
     */
    public Department getDeptById(Integer id);

    /**
     * 根据id查询部门，并且包含对应的所有员工列表
     *
     * @param id 部门id
     * @return 部门对象
     */
    public Department getDeptByIdPlus(Integer id);

    /**
     * 分步查询部门信息
     *
     * @param id 部门id
     * @return 部门对象
     */
    public Department getDeptByIdStep(Integer id);
}
