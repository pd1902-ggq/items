package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.AdminService;
import com.iotek.service.CvService;
import com.iotek.service.FtfsService;
import com.iotek.service.Impl.EmployeeService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private FtfsService ftfsService;
    @Resource
    private CvService cvService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping(value = "adminLoginView.do")
    public String adminLoginView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "adminLogin";
    }

    @RequestMapping(value = "makeSureFtfsTime.do")
    public String makeSureFtfsTime(int f_id,Date f_date, HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<Ftfs> ftfs = ftfsService.queryFtfs( new Ftfs( f_id ) );
        Ftfs ftfs1 = ftfs.get( 0 );
        ftfs1.setF_date( f_date );
        ftfs1.setF_is_read( 1 );
        ftfsService.updateFtfs( ftfs1 );
        return ftfsGm(request,response);
    }

    @RequestMapping(value = "makeSureOk.do")
    public String makeSureOk(int f_id,boolean ok, HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<Ftfs> ftfs = ftfsService.queryFtfs( new Ftfs( f_id ) );
        Ftfs ftfs1 = ftfs.get( 0 );
        if(ok){
            ftfs1.setF_is_read( 3 );
        }else{
            ftfs1.setF_is_read( 4 );
        }
        ftfsService.updateFtfs( ftfs1 );
        return ftfsGm(request,response);
    }
    @RequestMapping(value = "adminLogin.do")
    public String adminLogin(Administrator administrator,HttpServletRequest request, HttpServletResponse response)throws Exception{
       if(administrator!=null&&administrator.geta_name()!=null&&administrator.geta_pass()!=null){
           Administrator login = adminService.login( administrator );
           if(login!=null){
               return gmView( request,response );
           }else {
               return "adminLoginError";
           }
       }
        return "adminLogin";
    }
    @RequestMapping(value = "gmView.do")
    public String gmView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "gm";
    }
    @RequestMapping(value = "ftfsGmView.do")
    public String ftfsGmView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return ftfsGm(request,response);
    }

    private String ftfsGm(HttpServletRequest request, HttpServletResponse response) {
        String pageNoStr0 = request.getParameter("pageNo0");
        String pageNoStr2 = request.getParameter("pageNo2");
        int pageNo0=1;
        int pageNo2=1;
        if(pageNoStr0!=null&&!"".equals(pageNoStr0)){
            pageNo0=Integer.parseInt(pageNoStr0);
            request.setAttribute( "flag",0 );
        }
        if(pageNoStr2!=null&&!"".equals(pageNoStr2)){
            pageNo2=Integer.parseInt(pageNoStr2);
            request.setAttribute( "flag",2 );
        }
        Page<Ftfs> goodPage0 = ftfsService.queryFtfsByPageWithState( pageNo0,0 );
        Page page0=new Page();
        page0.setPageNo( pageNo0 );
        page0.setTotalRows( goodPage0.getTotalRows() );
        request.setAttribute( "ftfs0",page0 );

        Page<Ftfs> goodPage2 = ftfsService.queryFtfsByPageWithState( pageNo2,2 );
        Page page2=new Page();
        page2.setPageNo( pageNo2 );
        page2.setTotalRows( goodPage2.getTotalRows() );
        request.setAttribute( "ftfs2",page2 );

        //获取简历信息
        List<Cv> cvs = cvService.queryCv( new Cv(  ) );
        request.setAttribute( "cvs",cvs );

        //获取招聘表信息,找聘人信息
        List<Recruit> recruits1 = recruitService.queryRCT( new Recruit() );
        List<Employee> employees = employeeService.queryEmpl( new Employee() );
        request.setAttribute( "rcts",recruits1 );
        request.setAttribute( "empls",employees );
        return "ftfsGm";
    }
}
