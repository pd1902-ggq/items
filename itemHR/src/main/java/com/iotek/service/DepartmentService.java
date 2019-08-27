package com.iotek.service;

import com.iotek.model.Department;
import com.iotek.model.Page;

import java.util.List;

public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean deleDepartment(int id);
    boolean updateDepartment(Department department);
    List<Department> queryDepartment(Department department);
    Page queryDepartmentByPage(int pageNo);
}
