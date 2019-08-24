package com.iotek.controller;

import com.iotek.model.Customer;
import com.iotek.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @RequestMapping(value = "custormerLogin.do")
    public String custormerLogin(Customer customer,HttpServletRequest request, HttpServletResponse response)throws Exception{
        String log=request.getParameter("log");
        if(customer!=null&&customer.getC_account()!=null&&customer.getC_pass()!=null){
            Customer login = customerService.login( customer );
            if(login!=null){
                if("on".equals(log)){//记住账号密码，将账号和密码保存到cookie
                    Cookie cookie=new Cookie("c_account",login.getC_account());
                    Cookie cookie1=new Cookie("c_pass",login.getC_pass());
                    cookie.setMaxAge(60*60);
                    cookie1.setMaxAge(60*60);
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                }
                request.getSession().setAttribute( "customer",login );
                return "../../index";
            }else {
                return "../error/customerLoginError";
            }
        }else{
            return "../error/customerLoginError";
        }
    }

    @RequestMapping(value = "checkCustormer.do")
    public void checkCustormer(String name,HttpServletRequest request, HttpServletResponse response)throws Exception{
        boolean b = customerService.checkName( name );
        if(b){
            response.getWriter().write( "没有重名" );
        }else{
            response.getWriter().write( "重名" );
        }
    }
    @RequestMapping(value = "custormerRegister.do")
    public String custormerRegister(Customer customer,HttpServletRequest request, HttpServletResponse response)throws Exception{
        if(customer!=null&&customer.getC_account()!=null&&customer.getC_pass()!=null){
            customerService.register( customer );
            request.setAttribute( "isOK",true );
            return "../../index";
        }else{
            request.setAttribute( "isOK",true );
            return "custormerRegister";
        }
    }
    @RequestMapping(value = "customerLoginView.do")
    public String customerLoginView()throws Exception{
        return "custormerLogin";
    }
    @RequestMapping(value = "customerRegisterView.do")
    public String customerRegisterView()throws Exception{
        return "custormerRegister";
    }
}
