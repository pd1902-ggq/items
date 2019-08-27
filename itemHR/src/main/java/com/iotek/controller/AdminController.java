package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping(value = "adminLoginView.do")
    public String adminLoginView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "adminLogin";
    }

    @RequestMapping(value = "gm.do")
    public String gm(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "gm";
    }

    @RequestMapping(value = "makeSureFtfsTime.do")
    public String makeSureFtfsTime(Integer f_id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String f_date = request.getParameter( "f_date" );
        String replace = f_date.replace( "T", " " );
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        date=sdf.parse( replace+":00" );
        List<Ftfs> ftfs = ftfsService.queryFtfs( new Ftfs( f_id ) );
        Ftfs ftfs1 = ftfs.get( 0 );
        ftfs1.setF_date( date );
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
    @RequestMapping(value = "departmentGmView.do")
    public String departmentGmView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return departmentGm(request,response);
    }
    @RequestMapping(value = "ftfsGmView.do")
    public String ftfsGmView(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return ftfsGm(request,response);
    }
//部门增删改
    @RequestMapping(value = "addOrUpdateDepartment.do")
    public String addOrUpdateDepartment(Department department,HttpServletRequest request, HttpServletResponse response)throws Exception{
        String method = request.getParameter( "method" );
        if("addDepartment".equals( method )){
            boolean b = departmentService.addDepartment( department );
            request.setAttribute( "addDepart",b );
        }else if("updateDepartment".equals( method )){
            boolean b = departmentService.updateDepartment( department );
            request.setAttribute( "updateDepart",b );
        }
        return departmentGm(request,response);
    }
    @RequestMapping(value = "deleDepartment.do")
    public String deleDepartment(int dep_id,HttpServletRequest request, HttpServletResponse response)throws Exception {
        boolean b = departmentService.deleDepartment( dep_id );
        request.setAttribute( "deleDepart",b );
        return departmentGm(request,response);
    }
//职务增删改
@RequestMapping(value = "addOrUpdatePos.do")
public String addOrUpdatePos(Position position,HttpServletRequest request, HttpServletResponse response)throws Exception{
    String method = request.getParameter( "method1" );
    if("addPos".equals( method )){
        boolean b = positionService.addPosition( position );
        request.setAttribute( "addPos",b );
    }else if("updatePos".equals( method )){
        boolean b = positionService.updatePosition( position );
        request.setAttribute( "updatePos",b );
    }
    return departmentGm(request,response);
}
    @RequestMapping(value = "delePos.do")
    public String delePos(int pos_id,HttpServletRequest request, HttpServletResponse response)throws Exception {
        boolean b =positionService.delePosition( pos_id );
        request.setAttribute( "delePos",b );
        return departmentGm(request,response);
    }

//面试系统入口
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
        Page<Ftfs> ftfsPage0 = ftfsService.queryFtfsByPageWithState( pageNo0,0 );
        request.setAttribute( "ftfs0",ftfsPage0 );

        Page<Ftfs> ftfsPage2 = ftfsService.queryFtfsByPageWithState( pageNo2,2 );
        System.out.println(ftfsPage2);
        request.setAttribute( "ftfs2",ftfsPage2 );

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

    //部门及职务管理系统入口
    private String departmentGm(HttpServletRequest request, HttpServletResponse response) {
        String pageNoStr1 = request.getParameter("pageNo1");
        String pageNoStr2 = request.getParameter("pageNo2");
        int pageNo1=1;
        int pageNo2=1;
        if(pageNoStr1!=null&&!"".equals(pageNoStr1)){
            pageNo1=Integer.parseInt(pageNoStr1);
        }
        if(pageNoStr2!=null&&!"".equals(pageNoStr2)){
            pageNo2=Integer.parseInt(pageNoStr2);
        }
        Page departmentPage = departmentService.queryDepartmentByPage( pageNo1 );
        Page positionPage = positionService.queryPositionByPage( pageNo2 );
        request.setAttribute( "departments",departmentPage );
        request.setAttribute( "pasitions",positionPage );
        return "department";
    }
}
