package com.iotek.dao;

import com.iotek.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    void deleEmployee(int id);
    void updateEmployee(Employee employee);
    List<Employee> queryEmployee(Employee employee);
    List<Employee> queryEmployeeByPage(int start,int end);
}
