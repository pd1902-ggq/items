package com.iotek.dao;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentDao {
    void addDepartment(Department department);
    void deleDepartment(int id);
    void updateDepartment(Department department);
    List<Department> queryDepartment(Department department);
    List<Department> queryDepartmentByPage(int start,int end);
    int getTotalRows();
}
