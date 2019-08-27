package com.iotek.controller;

import com.iotek.model.Customer;
import com.iotek.model.Ftfs;
import com.iotek.model.Page;
import com.iotek.model.Recruit;
import com.iotek.service.FtfsService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private FtfsService ftfsService;
    @RequestMapping(value = "getRecruitPage.do")
    public String getRecruitPage(HttpServletRequest request, HttpServletResponse response)throws Exception{
       return mainView( request,response );
    }

    @RequestMapping(value = "sendCv.do")
    public String sendCv(Integer cv_id,Integer rct_id,HttpServletRequest request, HttpServletResponse response)throws Exception{
        Customer customer= (Customer) request.getSession().getAttribute( "customer" );
        Date date=new Date();
        System.out.println(cv_id +"------"+rct_id);
        Ftfs ftfs=new Ftfs(cv_id,rct_id,date,0,customer.getC_id()  );
        ftfsService.addFtfs( ftfs );
        request.setAttribute( "addFtfs",true );
        return mainView( request,response );
    }
    private String mainView(HttpServletRequest request, HttpServletResponse response){
        String pageNoStr = request.getParameter( "pageNo" );
        int pageNo=1;
        if(pageNoStr==null){
            pageNo=1;
        }else{
            pageNo=Integer.parseInt( pageNoStr );
        }
        if(pageNo<1){
            pageNo=1;
        }
        Page<Recruit> recruitPage =recruitService.queryRecruitByPageWhitPublich( pageNo,1 );
        request.getSession().setAttribute("recruitPage",recruitPage);
        return "../../index";
    }
}
