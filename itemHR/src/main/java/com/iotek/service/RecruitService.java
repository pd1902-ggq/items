package com.iotek.service;

import com.iotek.model.Page;
import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitService {
    Page queryRecruitByPageWhitDraft(int pageNo, int draft);
    Page queryRecruitByPageWhitPublich(int pageNo,int publish);
}
