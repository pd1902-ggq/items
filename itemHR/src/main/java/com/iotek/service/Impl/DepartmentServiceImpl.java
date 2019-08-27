package com.iotek.service.Impl;

import com.iotek.dao.DepartmentDao;
import com.iotek.dao.EmployeeDao;
import com.iotek.dao.PositionDao;
import com.iotek.model.Department;
import com.iotek.model.Employee;
import com.iotek.model.Page;
import com.iotek.model.Position;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private PositionDao positionDao;
    public boolean addDepartment(Department department) {
        Department department1=new Department(  );
        department1.setDep_name( department.getDep_name() );
        List<Department> departments = departmentDao.queryDepartment( department1 );
        if(departments==null||departments.size()==0){
            departmentDao.addDepartment( department );
            return true;
        }
        return false;
    }

    public boolean deleDepartment(int id) {
        Position position=new Position(  );
        position.setDep_id( id );
        List<Position> positions = positionDao.queryPosition( position );
        if(positions==null||positions.size()==0){
            departmentDao.deleDepartment( id );
            return true;
        }else{
            for (Position position1 : positions) {
                Employee employee=new Employee(  );
                employee.setPos_id( position1.getPos_id() );
                List<Employee> employees = employeeDao.queryEmployee( employee );
                if(employees!=null&&employees.size()!=0){
                    return false;
                }
            }
            for (Position position1 : positions) {
                positionDao.delePosition( position1.getPos_id() );
            }
            departmentDao.deleDepartment( id );
            return true;
        }
    }

    public boolean updateDepartment(Department department) {
        Department department1=new Department(  );
        department1.setDep_name( department.getDep_name() );
        List<Department> departments = departmentDao.queryDepartment( department1 );
        if(departments==null||departments.size()==0){
            departmentDao.updateDepartment( department );
            return true;
        }
        return false;
    }

    public List<Department> queryDepartment(Department department) {
        return departmentDao.queryDepartment( department );
    }

    public Page queryDepartmentByPage(int pageNo) {
        Page<Department> page=new Page<Department>();
        int totalRows = departmentDao.getTotalRows(  );
        List<Department> departments = departmentDao.queryDepartmentByPage((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize());
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(departments);
        return page;
    }
}
