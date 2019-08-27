package com.iotek.service;

import com.iotek.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> queryEmpl(Employee employee);
}
