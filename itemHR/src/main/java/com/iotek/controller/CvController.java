package com.iotek.controller;

import com.iotek.model.Customer;
import com.iotek.model.Cv;
import com.iotek.model.Page;
import com.iotek.service.CvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class CvController {
    @Resource
    private CvService cvService;
    @RequestMapping(value = "getcvs.do")
    public String getcvs( HttpServletRequest request, HttpServletResponse response)throws Exception{
        return cvView( request,response );
    }

    @RequestMapping(value = "deleCv.do")
    public String custormerLogin(int cv_id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.err.println("delete");
        cvService.deleCv( cv_id );
        request.setAttribute( "deleCv",true );
        return cvView( request,response );
    }

    @RequestMapping(value = "addOrUpdateCv.do")
    public String addOrUpdateCv(Cv cv,String method, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Customer customer = (Customer) request.getSession().getAttribute( "customer" );
        System.out.println(cv);
        if("add".equals( method )){
            Cv cv1=new Cv();
            cv1.setC_id( customer.getC_id() );
            cv.setC_id( customer.getC_id() );
            List<Cv> cvs = cvService.queryCv( cv1 );
            if(cvs==null||cvs.size()<5){
                cvService.addCv( cv );
                request.setAttribute( "addCv",true );
            }else{
                request.setAttribute( "addCv",false );
            }
        }else if("update".equals( method )){
            cvService.update( cv );
            request.setAttribute( "updateCv",true );
        }
        return cvView( request,response );
    }

    private String cvView( HttpServletRequest request, HttpServletResponse response){
        Customer customer = (Customer) request.getSession().getAttribute( "customer" );
        String pageNoStr = request.getParameter( "pageNo" );
        int pageNo=1;
        if(pageNoStr==null||"".equals(  pageNoStr)){
            pageNo=1;
        }else{
           pageNo=Integer.parseInt( pageNoStr );
        }
        Page page = cvService.queryCvByPageWithCID( pageNo, customer.getC_id() );
        request.setAttribute( "cvs",page );
        return "customerCv";
    }
}
