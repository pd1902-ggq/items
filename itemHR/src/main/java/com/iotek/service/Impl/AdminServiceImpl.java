package com.iotek.service.Impl;

import com.iotek.dao.AdministratorDao;
import com.iotek.model.Administrator;
import com.iotek.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdministratorDao administratorDao;
    public Administrator login(Administrator administrator) {
        List<Administrator> administrators = administratorDao.queryAdmin( administrator );
        if(administrators!=null&&administrators.size()!=0){
            return administrators.get( 0 );
        }
        return null;
    }
}
