package com.hxuanyu.mybatis.dao;

import com.hxuanyu.mybatis.bean.Department;

/**
 * @author hxuanyu
 */
public interface DepartmentMapper {

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 部门对象
     */
    public Department getDeptById(Integer id);
}
