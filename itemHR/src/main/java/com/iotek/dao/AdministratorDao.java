package com.iotek.dao;

import com.iotek.model.Administrator;

import java.util.List;

public interface AdministratorDao {
    void addAdmin(Administrator adminidtrator);
    void deleAdmin(int id);
    void updateAdmin(Administrator administrator);
    List<Administrator> queryAdmin(Administrator administrator);
}
