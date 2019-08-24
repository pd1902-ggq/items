package com.iotek.service.Impl;

import com.iotek.dao.RecruitDao;
import com.iotek.model.Page;
import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "recruitService")
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;
    public Page queryRecruitByPageWhitDraft(int pageNo, int draft) {
        Page<Recruit> page=new Page<Recruit>();
        int totalRows = recruitDao.getTotalRowsWhitDraft( draft );
        List<Recruit> recruits = recruitDao.queryRecruitByPageWhitDraft((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize(),draft);
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(recruits);
        return page;
    }

    public Page queryRecruitByPageWhitPublich(int pageNo, int publish) {
        Page<Recruit> page=new Page<Recruit>();
        int totalRows = recruitDao.getTotalRowsWhitPublich( publish );
        List<Recruit> recruits = recruitDao.queryRecruitByPageWhitPublich((pageNo-1)*page.getPageSize(), pageNo*page.getPageSize(),publish);
        page.setPageNo(pageNo);
        page.setTotalRows(totalRows);
        page.setList(recruits);
        return page;
    }
}
