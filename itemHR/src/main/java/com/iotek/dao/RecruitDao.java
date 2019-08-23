package com.iotek.dao;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitDao {
    void addRecruit(Recruit recruit);
    void deleRecruit(int id);
    void updateRecruit(Recruit recruit);
    List<Recruit> queryRecruit(Recruit recruit);
}
