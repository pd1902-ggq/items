package com.iotek.service.Impl;

import com.iotek.dao.EmployeeDao;
import com.iotek.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeDao employeeDao;
    public List<Employee> queryEmpl(Employee employee) {
        return employeeDao.queryEmployee( employee );
    }
}
