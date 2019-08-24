package com.iotek.controller;

import com.iotek.model.Page;
import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @RequestMapping(value = "getRecruitPage.do")
    public String getRecruitPage(int pageNo,HttpServletRequest request, HttpServletResponse response)throws Exception{
        if(pageNo!=0){
            if(pageNo<1){
                pageNo=1;
            }
        }
        Page<Recruit> recruitPage =recruitService.queryRecruitByPageWhitPublich( pageNo,1 );
        request.getSession().setAttribute("recruitPage",recruitPage);
        return "../../index";
    }
}
