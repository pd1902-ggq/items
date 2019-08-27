package com.iotek.service.Impl;

import com.iotek.dao.EmployeeDao;
import com.iotek.dao.PositionDao;
import com.iotek.model.Employee;
import com.iotek.model.Position;
import com.iotek.model.Page;
import com.iotek.model.Position;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
    @Resource
    private EmployeeDao employeeDao;
    public boolean addPosition(Position position) {
        Position position1=new Position(  );
        position1.setDep_id( position.getDep_id() );
        List<Position> positions = positionDao.queryPosition( position1 );
        if(positions==null||positions.size()==0){
            for (Position position2 : positions) {
                if(position2.getPos_name().equals( position.getPos_name() )){
                    return false;
                }
            }
            positionDao.addPosition( position );
            return true;
        }else{
            positionDao.addPosition( position );
            return true;
        }
    }

    public boolean delePosition(int id) {
        Employee employee=new Employee(  );
        employee.setPos_id( id );
        List<Employee> employees = employeeDao.queryEmployee( employee );
        if(employees==null||employees.size()==0){
            positionDao.delePosition( id );
            return true;
        }else{
            return false;
        }
    }

    public boolean updatePosition(Position position) {
        Position position1=new Position(  );
        position1.setDep_id( position.getDep_id() );
        List<Position> positions = positionDao.queryPosition( position1 );
        if(positions==null||positions.size()==0){
            for (Position position2 : positions) {
                if(position2.getPos_name().equals( position.getPos_name() )){
                    return false;
                }
            }
            positionDao.updatePosition( position );
            return true;
        }else{
            positionDao.updatePosition( position );
            return true;
        }
    }

    public List<Position> queryPosition(Position position) {
        return positionDao.queryPosition( position );
    }

    public Page queryPositionByPage(int pageNo) {
        Page<Position> page=new Page<Position>();
        int totalRows = positionDao.getTotalRows(  );
        List<Position> cvs = positionDao.queryPositionByPage((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize());
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(cvs);
        return page;
    }
}
