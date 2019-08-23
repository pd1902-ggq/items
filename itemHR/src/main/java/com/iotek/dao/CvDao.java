package com.iotek.dao;

import com.iotek.model.Cv;

import java.util.List;

public interface CvDao {
    void addCv(Cv cv);
    void deleCv(int id);
    void update(Cv cv);
    List<Cv> queryCv(Cv cv);
    List<Cv> queryCvByPageWithCID(int start,int end,int cid);
}
