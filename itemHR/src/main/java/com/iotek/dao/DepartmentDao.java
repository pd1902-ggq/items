package com.iotek.dao;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentDao {
    void addDepartment(Department department);
    void deleDepartment(int id);
    void updateDepartment(Department department);
    List<Deprecated> queryDepartment(Department department);
    List<Deprecated> queryDepartmentByPage(int start,int end);
}
