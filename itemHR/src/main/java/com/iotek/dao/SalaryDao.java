package com.iotek.dao;

import com.iotek.model.Salary;

import java.util.List;

public interface SalaryDao {
    void addSalary(Salary salary);
    void deleSalary(int id);
    void updateSalary(Salary salary);
    List<Salary> querySalary(Salary salary);
}
