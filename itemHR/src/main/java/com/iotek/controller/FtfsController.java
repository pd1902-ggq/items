package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.CvService;
import com.iotek.service.FtfsService;
import com.iotek.service.EmployeeService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FtfsController {
    @Resource
    private FtfsService ftfsService;
    @Resource
    private CvService cvService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping(value = "ftfsView.do")
    public String ftfsView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return ftfs(request,response);
    }

    @RequestMapping(value = "agreeFtfs.do")
    public String agreeFtfs(int f_id,HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<Ftfs> ftfs = ftfsService.queryFtfs( new Ftfs( f_id ) );
        ftfs.get( 0 ).setF_is_read( 2 );
        ftfsService.updateFtfs( ftfs.get( 0 ) );
        return ftfs(request,response);
    }
    private String ftfs(HttpServletRequest request, HttpServletResponse response) {
        Customer customer= (Customer) request.getSession().getAttribute( "customer" );
        if (customer!=null) {
            String pageNoStr0 = request.getParameter("pageNo0");
            String pageNoStr1 = request.getParameter("pageNo1");
            String pageNoStr3 = request.getParameter("pageNo3");
            int pageNo0=1;
            int pageNo1=1;
            int pageNo3=1;
            if(pageNoStr0!=null&&!"".equals(pageNoStr0)){
                pageNo0=Integer.parseInt(pageNoStr0);
                request.setAttribute( "flag",0 );
            }
            if(pageNoStr1!=null&&!"".equals(pageNoStr1)){
                pageNo1=Integer.parseInt(pageNoStr1);
                request.setAttribute( "flag",1 );
            }
            if(pageNoStr3!=null&&!"".equals(pageNoStr3)){
                pageNo3=Integer.parseInt(pageNoStr3);
                request.setAttribute( "flag",3 );
            }
            Page<Ftfs> ftfsPage0 = ftfsService.queryFtfsByPageWithCidAndState( pageNo0,customer.getC_id(),0 );
            request.setAttribute( "ftfs0",ftfsPage0 );

            Page<Ftfs> ftfsPage1 = ftfsService.queryFtfsByPageWithCidAndState( pageNo1,customer.getC_id(),1 );
            request.setAttribute( "ftfs1",ftfsPage1 );

            Page<Ftfs> ftfsPage3 = ftfsService.queryFtfsByPageWithCidAndState( pageNo3,customer.getC_id(),3 );
            request.setAttribute( "ftfs3",ftfsPage3 );

            //获取简历信息
            Cv cv=new Cv();
            cv.setC_id( customer.getC_id() );
            List<Cv> cvs = cvService.queryCv( cv );
            request.setAttribute( "cvs",cvs );

            //获取招聘表信息,找聘人信息
            Ftfs ftfs=new Ftfs(  );
            ftfs.setC_id(  customer.getC_id());
            List<Ftfs> ftfs1 = ftfsService.queryFtfs( ftfs );
            List<Employee> employees=new ArrayList<Employee>(  );
            List<Recruit> recruitList=new ArrayList<Recruit>(  );
            for (Ftfs ftfs2 : ftfs1) {
                Recruit recruit=new Recruit(  );
                recruit.setRct_id( ftfs2.getRct_id() );
                List<Recruit> recruits = recruitService.queryRCT( recruit );
                recruitList.addAll( recruits );
                int e_id = recruits.get( 0 ).getE_id();
                List<Employee> employees1 = employeeService.queryEmpl( new Employee( e_id ) );
                employees.addAll( employees1 );
            }
            request.setAttribute( "rcts",recruitList );
            request.setAttribute( "empls",employees );
            return "ftfs";
        } else {
            return "custormerLogin";
        }
    }
}
