<%@ page import="com.iotek.GetCookie" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.iotek.service.CustomerService" %>
<%@ page import="com.iotek.service.RecruitService" %>
<%@ page import="com.iotek.service.CvService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: 11929
  Date: 2019/7/18
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <title>购物商城</title>
    <style>
        #comments {
            overflow-y: scroll;
        }

    </style>
    <script src="js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $(".comment").live("click", function () {
                var a = $("#commentx").css("display");
                if (a == "none") {
                    $("#commentx").css("display", "block");
                }
            });
            $("#search").change(function () {
                var value = $("#search").val();
                $.ajax({
                    type: "post",
                    url: "search",
                    data: {"str": value},
                    success: function (obj) {
                        alert("aaa")
                    }
                })
            })
        });
    </script>
</head>
<body>

<c:if test="${addFtfs eq true}">
    <script>
        alert("简历投递成功")
    </script>
</c:if>


<%
    Cookie[] cookies = request.getCookies();
    Cookie cookie = GetCookie.getC( cookies, "c_account" );
    Cookie cookie1 = GetCookie.getC( cookies, "c_pass" );
    if (cookie != null) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "bean.xml" );
        CustomerService custormerService = (CustomerService) context.getBean( "custormerService" );
        Customer login = custormerService.login( new Customer( cookie.getValue(), cookie1.getValue() ) );
        if (login != null) {
            session.setAttribute( "customer", login );
        }
    }
%>


<div class="div1">
    <%
        if (session.getAttribute( "customer" ) == null) {
    %>
    <span><a href="customerLoginView.do">游客登录</a></span>
    <span><a href="customerRegisterView.do">游客免费注册</a> </span>
    <%
    } else {
        Customer customer = (Customer) session.getAttribute( "customer" );
        ApplicationContext context=new ClassPathXmlApplicationContext( "bean.xml" );
        CvService cvService = (CvService) context.getBean( "cvService" );
        Cv cv = new Cv();
        cv.setC_id( customer.getC_id() );
        List<Cv> cvs = cvService.queryCv( cv );
        pageContext.setAttribute( "list", cvs );
    %>
    <span><a href="getcvs.do"><%=customer.getC_account()%></a></span>
    <%
        }
    %>
    <%
        if (session.getAttribute( "admin" ) == null) {
    %>
    <span><a href="adminLoginView.do">管理员登录</a></span>
    <%
    } else {
        Administrator admin = (Administrator) session.getAttribute( "admin" );
    %>
    <span><a href="gmView.do"><%=admin.geta_name()%></a></span>
    <%
        }
    %>
</div>
<div class="div2">
    <span><a href="ftfsView.do">我的面试信息</a> </span>
    <span><a href="user?method=getMyInfo">我的淘宝</a></span>
    <span><a href="buycar?method=getInfo">购物车</a></span>
    <span><a href="orders?method=myOrders">我的订单</a></span>
    <span><a href="">商品分类</a></span>
    <span><a href="">卖家中心</a> </span>
</div>
<div style="clear: both"></div>
<div class="div3">
    <table>
        <tr>
            <th width="100px">职位</th>
            <th width="100px">主题</th>
            <th width="100px">职位描述</th>
            <th width="100px">发布时间</th>
            <th width="100px">地址</th>
            <th width="50px">薪资</th>
            <th width="50px">联系人</th>
            <th width="200">投递简历</th>
        </tr>
        <%
            ApplicationContext context = new ClassPathXmlApplicationContext( "bean.xml" );
            RecruitService recruitService = (RecruitService) context.getBean( "recruitService" );
            Page<Recruit> recruitPage = (Page<Recruit>) session.getAttribute( "recruitPage" );
            if (recruitPage == null) {
                recruitPage = recruitService.queryRecruitByPageWhitPublich( 1, 1 );
            }
            if (recruitPage.getList() != null && recruitPage.getList().size() != 0) {
                for (Recruit recruit : recruitPage.getList()) {
        %>
        <tr>
            <td><%=recruit.getPos_id()%>
            </td>
            <td><%=recruit.getRct_title()%>
            </td>
            <td><%=recruit.getRct_introduaction()%>
            </td>
            <td>
                <fmt:formatDate value="<%=recruit.getRct_publish_time()%>" pattern="yyyy-MM-dd HH-mm-ss"/>
            </td>
            <td><%=recruit.getRct_address()%>
            </td>
            <td>
                <%=recruit.getRct_salary()%>
            </td>
            <td>
                <%=recruit.getE_id()%>
            </td>
            <td>
                <form action="sendCv.do" method="post">
                    <select name="cv_id" required>
                        <c:if test="${!empty list}">
                            <C:forEach items="${list}" var="i">
                                <option value="${i.cv_id}">${i.cv_title}</option>
                            </C:forEach>
                        </c:if>
                    </select>
                    <input type="hidden" name="rct_id" value="<%=recruit.getRct_id()%>">
                    <input type="submit" value="投递简历">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        <tr>
            <td style="align-content: left;text-align: left" colspan="8">
                <div class="div4">
                    <span>共 <%=recruitPage.getTotalPage()%> 页</span>
                    <span>当前在第 <%=recruitPage.getPageNo()%> 页</span>
                    <span><a href="getRecruitPage.do?pageNo=1">首页</a></span>
                    <span><a href="getRecruitPage.do?pageNo=<%=recruitPage.getPrevPage()%>">上一页</a></span>
                    <span><a href="getRecruitPage.do?pageNo=<%=recruitPage.getNextPage()%>">下一页</a></span>
                    <span><a href="getRecruitPage.do?pageNo=<%=recruitPage.getTotalPage()%>">尾页</a></span>
                    <form style="size: 10px" action="getRecruitPage.do"
                          onsubmit="return checkNum(this.children[1].value)">
                        <span style="size: 10px">去第</span><input name="pageNo" type="number" value=1 min=1
                                                                 max=<%=recruitPage.getTotalPage()%>>页
                        <input type="submit" value="确认">
                    </form>
                </div>
            </td>
        </tr>
        <%
        } else {
        %>
        <tr>
            <td colspan="7">没有招聘信息</td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<div style="display: none" id="commentx">
    <fieldset>
        <legend id="commentGoodName"></legend>
        <div style="height:100px" id="comments"></div>
    </fieldset>
</div>
</body>
</html>
