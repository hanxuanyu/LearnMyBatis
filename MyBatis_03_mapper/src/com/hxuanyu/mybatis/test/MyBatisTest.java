package com.hxuanyu.mybatis.test;

import com.hxuanyu.mybatis.bean.Department;
import com.hxuanyu.mybatis.bean.Employee;
import com.hxuanyu.mybatis.dao.DepartmentMapper;
import com.hxuanyu.mybatis.dao.EmployeeMapper;
import com.hxuanyu.mybatis.dao.EmployeeMapperDynamicSQL;
import com.hxuanyu.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1. 根据xml配置文件创建一个SqlSessionFactory对象
 * 2. 创建一个SqlSession实例
 * 3. 获取接口的代理对象MapperFactory
 * 4. 调用相关方法
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
    public void testSelect() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 默认不会自动提交数据，需要手动提交
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.getEmpByLastNameLike("%e%");
            for (Employee employee : list) {
                System.out.println(employee);
            }
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
            Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
            System.out.println(map);
            Map<Integer, Employee> map2 = mapper.getEmpByLastNameLikeReturnMap("%e%");
            System.out.println(map2);
        }
    }

    @Test
    public void testInsert() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 默认不会自动提交数据，需要手动提交
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.addEmp(new Employee(null, "jerry", "jerry@hxuanyu.com", "1"));
            sqlSession.commit();
        }
    }

    @Test
    public void testUpdate() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 默认不会自动提交数据，需要手动提交
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.updateEmp(new Employee(1, "jerry", "jerry@hxuanyu.com", "0"));
            sqlSession.commit();
        }
    }

    @Test
    public void testDelete() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 默认不会自动提交数据，需要手动提交
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmpById(5);
            sqlSession.commit();
        }
    }


    @Test
    public void test05() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee emp1 = mapper.getEmpByIdStep(1);
            System.out.println(emp1);
        }
    }

    @Test
    public void test06() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDeptByIdStep(1);
            System.out.println(department);
            System.out.println(department.getEmps());
        }
    }

    @Test
    public void testDynamicSql() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee();
            employee.setId(1);
            employee.setLastName("tom");
            mapper.updateEmp(employee);
        }
    }

    @Test
    public void testBatchSave() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(1, "smith", "smith@hxuanyu.com", "1", new Department(1)));
            emps.add(new Employee(1, "allen", "allen@hxuanyu.com", "0", new Department(1)));
            mapper.addEmps(emps);
            sqlSession.commit();
        }
    }

    @Test
    public void testFirstLevelCache() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmpById(1);

            Employee emp02 = mapper.getEmpById(1);
            System.out.println(emp01);
            System.out.println(emp01);
        }
    }

}
