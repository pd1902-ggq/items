package com.iotek.service.Impl;

import com.iotek.dao.CvDao;
import com.iotek.model.Cv;
import com.iotek.model.Page;
import com.iotek.model.Recruit;
import com.iotek.service.CvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "cvService")
public class CvServiceImpl implements CvService {
    @Resource
    private CvDao cvDao;
    public void addCv(Cv cv) {
        cvDao.addCv( cv );
    }

    public void deleCv(int id) {
        cvDao.deleCv( id );
    }

    public void update(Cv cv) {
        cvDao.update( cv );
    }

    public List<Cv> queryCv(Cv cv) {
        return cvDao.queryCv( cv );
    }

    public Page queryCvByPageWithCID(int pageNo, int cid) {
        Page<Cv> page=new Page<Cv>();
        int totalRows = cvDao.getTotalRowsWithCID( cid );
        List<Cv> cvs = cvDao.queryCvByPageWithCID((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize(),cid);
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(cvs);
        return page;
    }
}
