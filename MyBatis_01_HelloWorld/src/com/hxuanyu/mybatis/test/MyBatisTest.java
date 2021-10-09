package com.hxuanyu.mybatis.test;

import com.hxuanyu.mybatis.bean.Employee;
import com.hxuanyu.mybatis.dao.EmployeeMapper;
import com.hxuanyu.mybatis.dao.EmployeeMapperAnnotation;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1. 根据xml配置文件创建一个SqlSessionFactory对象
 * 2. 创建一个SqlSession实例
 * 3. 调用相关方法
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession实例，能执行已经映射的sql语句

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 3. 调用查询方法，参数一为唯一标识，参数二为语句参数
            Employee employee = sqlSession.selectOne("com.hxuanyu.com.hxuanyu.mybatis.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        }

    }

    @Test
    public void test01() throws Exception {
        // 1. 获取sqlSessionFactory
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        // 2. 获取session对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 3.
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void test02() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        Employee empById = mapper.getEmpById(1);
        System.out.println(empById);
    }
}
