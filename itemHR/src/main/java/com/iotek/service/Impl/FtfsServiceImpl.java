package com.iotek.service.Impl;

import com.iotek.dao.FtfsDao;
import com.iotek.model.Cv;
import com.iotek.model.Ftfs;
import com.iotek.model.Page;
import com.iotek.service.FtfsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "ftfsService")
public class FtfsServiceImpl implements FtfsService {
    @Resource
    private FtfsDao ftfsDao;
    public void addFtfs(Ftfs ftfs) {
        ftfsDao.addFtfs( ftfs );
    }


    public void updateFtfs(Ftfs ftfs) {
        ftfsDao.updateFtfs( ftfs );
    }

    public List<Ftfs> queryFtfs(Ftfs ftfs) {
        return ftfsDao.queryFtfs( ftfs );
    }

    public Page queryFtfsByPageWithCidAndState(int pageNo, int cid,int state) {
        Page<Ftfs> page=new Page<Ftfs>();
        int totalRows = ftfsDao.getTotalRowsWithCidAndState( cid,state );
        List<Ftfs> cvs = ftfsDao.queryFtfsByPageWithCidAndState((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize(),cid,state);
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(cvs);
        return page;
    }

    public Page queryFtfsByPageWithState(int pageNo,int state) {
        Page<Ftfs> page=new Page<Ftfs>();
        int totalRows = ftfsDao.getTotalRowsWithState( state );
        List<Ftfs> cvs = ftfsDao.queryFtfsByPageWithState((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize(),state);
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(cvs);
        return page;
    }
}
