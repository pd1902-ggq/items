package com.iotek.service;

import com.iotek.model.Cv;
import com.iotek.model.Page;

import java.util.List;

public interface CvService {
    void addCv(Cv cv);
    void deleCv(int id);
    void update(Cv cv);
    List<Cv> queryCv(Cv cv);
    Page queryCvByPageWithCID(int pageNo, int cid);
}
