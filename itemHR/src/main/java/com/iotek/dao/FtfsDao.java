package com.iotek.dao;

import com.iotek.model.Ftfs;

import java.util.List;

public interface FtfsDao {
    void addFtfs(Ftfs ftfs);
    void deleFtfs(int id);
    void updateFtfs(Ftfs ftfs);
    List<Ftfs> queryFtfs(Ftfs ftfs);
    List<Ftfs> queryFtfsByPageWithCvid(int start,int end,int cvid);
    List<Ftfs> queryFtfsByPage(int start,int end);
}
