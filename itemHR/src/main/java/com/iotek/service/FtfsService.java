package com.iotek.service;

import com.iotek.model.Ftfs;
import com.iotek.model.Page;

import java.util.List;

public interface FtfsService {
    void addFtfs(Ftfs ftfs);
    void updateFtfs(Ftfs ftfs);
    List<Ftfs> queryFtfs(Ftfs ftfs);
    Page queryFtfsByPageWithCidAndState(int pageNo, int cid,int state);
    Page queryFtfsByPageWithState(int pageNo,int state);
}
