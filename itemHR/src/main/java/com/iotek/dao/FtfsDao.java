package com.iotek.dao;

import com.iotek.model.Ftfs;

import java.util.List;

public interface FtfsDao {
    void addFtfs(Ftfs ftfs);
    void deleFtfs(int id);
    void updateFtfs(Ftfs ftfs);
    List<Ftfs> queryFtfs(Ftfs ftfs);
    List<Ftfs> queryFtfsByPageWithCidAndState(int start,int end,int cid,int state);
    int getTotalRowsWithCidAndState(int cvid,int state);
    List<Ftfs> queryFtfsByPageWithState(int start,int end,int state);
    int getTotalRowsWithState(int state);
}
