package com.hxuanyu.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Alias("emp")
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private Department dept;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + dept +
                '}';
    }

    public Department getDepartment() {
        return dept;
    }

    public void setDepartment(Department department) {
        this.dept = department;
    }

    public Employee(Integer id, String lastName, String email, String gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dept = department;
    }

    public Employee(Integer id, String lastName, String email, String gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
