<%@ page import="com.iotek.model.Page" %>
<%@ page import="com.iotek.model.Cv" %>
<%@ page import="com.iotek.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Recruit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>面试管理</title>
    <style>
        td {
            align: center;
            text-align: center;
            vertical-align: middle;
        }

        tr {
            height: 30px;
        }

        body{
            background-image:url("jpg/cat2.jpg") ;
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }

    </style>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            if (${!empty requestScope.get("flag") }) {
                if (${requestScope.get("flag") eq 0}) {
                    $("#a1").css("backgroundColor","buttonface");
                    $("#a2").css("backgroundColor","red");
                    $("#a3").css("backgroundColor","buttonface");
                    $("#t1").show(1000);
                    $("#t2").hide(1000);
                } else if (${requestScope.get("flag") eq 2}) {
                    $("#a1").css("backgroundColor","buttonface");
                    $("#a2").css("backgroundColor","buttonface");
                    $("#a3").css("backgroundColor","red");
                    $("#t1").hide(1000);
                    $("#t2").show(1000);
                }
            }
        });

    </script>
    <script src="js/ftfsGm.js" type="text/javascript"></script>
</head>
<body>

<%
    Page page0 = (Page) request.getAttribute( "ftfs0" );
    Page page2 = (Page) request.getAttribute( "ftfs2" );
    pageContext.setAttribute( "list0", page0.getList() );
    pageContext.setAttribute( "list2", page2.getList() );
    List<Cv> cvs= (List<Cv>) request.getAttribute( "cvs" );
    List<Employee> employees= (List<Employee>) request.getAttribute( "empls" );
    List<Recruit> rcts= (List<Recruit>) request.getAttribute( "rcts" );
    pageContext.setAttribute( "cvs",cvs );
    pageContext.setAttribute( "rcts",rcts );
    pageContext.setAttribute( "employees",employees );
%>
<button id="a1"><a style="text-decoration:none" class="a" >全部面试</a></button>
<button id="a2"><a style="text-decoration:none" class="a" >待安排面试</a></button>
<button id="a3"><a style="text-decoration:none" class="a" >待打分面试</a></button>

<div id="t1">
    待安排面试：
    <table>
        <tr>
            <th width="100px">应聘人名称</th>
            <th width="150px">应聘人联系方式</th>
            <th width="250px">职位描述</th>
            <th width="100px">联系人</th>
            <th width="150px">联系电话</th>
            <th width="200px">面试时间安排</th>
        </tr>
        <c:if test="${!empty list0}">
            <c:forEach items="${list0}" var="a">
                <tr>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_name}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_phone}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct">
                            <c:if test="${a.rct_id eq rct.rct_id}">
                                ${rct.rct_introduaction}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct1">
                            <c:if test="${a.rct_id eq rct1.rct_id}">
                                <c:forEach items="${employees}" var="empl">
                                    <c:if test="${rct1.e_id eq empl.e_id}">
                                        ${empl.e_name}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct1">
                            <c:if test="${a.rct_id eq rct1.rct_id}">
                                <c:forEach items="${employees}" var="empl">
                                    <c:if test="${rct1.e_id eq empl.e_id}">
                                        ${empl.e_phone}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <form method="post" action="makeSureFtfsTime.do">
                            <input type="hidden" name="f_id" value="${a.f_id}">
                            <input type="datetime-local" name="f_date" required>
                            <input type="submit" value="提交">
                        </form>
                    </th>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
                    <div class="div4">
                        <span>共 <%=page0.getTotalPage()%> 页</span>
                        <span>当前在第 <%=page0.getPageNo()%> 页</span>
                        <span><a href="ftfsGmView.do?pageNo0=1">首页</a></span>
                        <span><a href="ftfsGmView.do?pageNo0=<%=page0.getPrevPage()%>">上一页</a></span>
                        <span><a href="ftfsGmView.do?pageNo0=<%=page0.getNextPage()%>">下一页</a></span>
                        <span><a href="ftfsGmView.do?pageNo0=<%=page0.getTotalPage()%>">尾页</a></span>
                        <form style="size: 10px;display: inline" action="ftfsGmView.do"
                              onsubmit="return checkNum(this.children[1].value)">
                            <span style="size: 10px">去第</span><input name="pageNo0" type="number" value=1 min=1
                                                                     max=<%=page0.getTotalPage()%>>页
                            <input type="submit" value="确认">
                        </form>
                    </div>
                </td>
            </tr>
        </c:if>
        <c:if test="${empty list0}">
            <tr>
                <td colspan="6">没有待安排面试</td>
            </tr>
        </c:if>
    </table>
    <hr>
</div>
<div id="t2">
    待打分面试：
    <table>
        <tr>
            <th width="100px">应聘人名称</th>
            <th width="150px">应聘人联系方式</th>
            <th width="250px">职位描述</th>
            <th width="100px">联系人</th>
            <th width="150px">联系电话</th>
            <th width="200px">评分</th>
        </tr>
        <c:if test="${!empty list2}">
            <c:forEach items="${list2}" var="a">
                <tr>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_name}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_phone}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct">
                            <c:if test="${a.rct_id eq rct.rct_id}">
                                ${rct.rct_introduaction}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct1">
                            <c:if test="${a.rct_id eq rct1.rct_id}">
                                <c:forEach items="${employees}" var="empl">
                                    <c:if test="${rct1.e_id eq empl.e_id}">
                                        ${empl.e_name}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct1">
                            <c:if test="${a.rct_id eq rct1.rct_id}">
                                <c:forEach items="${employees}" var="empl">
                                    <c:if test="${rct1.e_id eq empl.e_id}">
                                        ${empl.e_phone}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <form method="post" action="makeSureOk.do">
                            <input type="hidden" name="f_id" value="${a.f_id}">
                            <input type="radio" name="ok" value="true" checked>通过
                            <input type="radio" name="ok" value="false">不通过
                            <input type="submit" value="提交">
                        </form>
                    </th>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
                    <div class="div4">
                        <span>共 <%=page2.getTotalPage()%> 页</span>
                        <span>当前在第 <%=page2.getPageNo()%> 页</span>
                        <span><a href="ftfsGmView.do?pageNo2=1">首页</a></span>
                        <span><a href="ftfsGmView.do?pageNo2=<%=page2.getPrevPage()%>">上一页</a></span>
                        <span><a href="ftfsGmView.do?pageNo2=<%=page2.getNextPage()%>">下一页</a></span>
                        <span><a href="ftfsGmView.do?pageNo2=<%=page2.getTotalPage()%>">尾页</a></span>
                        <form style="size: 10px;display: inline" action="ftfsGmView.do"
                              onsubmit="return checkNum(this.children[1].value)">
                            <span style="size: 10px">去第</span><input name="pageNo2" type="number" value=1 min=1
                                                                     max=<%=page2.getTotalPage()%>>页
                            <input type="submit" value="确认">
                        </form>
                    </div>
                </td>
            </tr>
        </c:if>
        <c:if test="${empty list2}">
            <tr>
                <td colspan="6">没有待打分面试</td>
            </tr>
        </c:if>
    </table>
    <hr>
</div>




<a href="gm.do">返回主页</a>
</body>
</html>
