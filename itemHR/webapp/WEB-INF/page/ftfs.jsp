<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.*" %><%--
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
    <title>我的面试信息</title>
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
                    $("#a4").css("backgroundColor","buttonface");
                    $("#t1").show(1000);
                    $("#t2").hide(1000);
                    $("#t3").hide(1000);
                } else if (${requestScope.get("flag") eq 2}) {
                    $("#a1").css("backgroundColor","buttonface");
                    $("#a2").css("backgroundColor","buttonface");
                    $("#a3").css("backgroundColor","red");
                    $("#a4").css("backgroundColor","buttonface");
                    $("#t1").hide(1000);
                    $("#t2").show(1000);
                    $("#t3").hide(1000);
                } else if (${requestScope.get("flag") eq 3}) {
                    $("#a1").css("backgroundColor","buttonface");
                    $("#a2").css("backgroundColor","buttonface");
                    $("#a4").css("backgroundColor","red");
                    $("#a3").css("backgroundColor","buttonface");
                    $("#t1").hide(1000);
                    $("#t3").show(1000);
                    $("#t2").hide(1000);
                }
            }
        });

    </script>
    <script src="js/ftfs.js" type="text/javascript"></script>
</head>
<body>

<%
    Page<Ftfs> page0 = (Page) request.getAttribute( "ftfs0" );
    Page<Ftfs> page1 = (Page) request.getAttribute( "ftfs1" );
    Page<Ftfs> page3 = (Page) request.getAttribute( "ftfs3" );
    pageContext.setAttribute( "list0", page0.getList() );
    pageContext.setAttribute( "list1", page1.getList() );
    pageContext.setAttribute( "list3", page3.getList() );
    List<Cv> cvs= (List<Cv>) request.getAttribute( "cvs" );
    List<Employee> employees= (List<Employee>) request.getAttribute( "empls" );
    List<Recruit> rcts= (List<Recruit>) request.getAttribute( "rcts" );
    pageContext.setAttribute( "cvs",cvs );
    pageContext.setAttribute( "rcts",rcts );
    pageContext.setAttribute( "employees",employees );
%>
<button id="a1"><a style="text-decoration:none" class="a" >全部面试</a></button>
<button id="a2"><a style="text-decoration:none" class="a" >待回复面试</a></button>
<button id="a3"><a style="text-decoration:none" class="a" >待参加面试</a></button>
<button id="a4"><a style="text-decoration:none" class="a" >已完成面试</a></button>

<div id="t1">
    待回复面试：
    <table>
        <tr>
            <th width="100px">简历名称</th>
            <th width="250px">职位描述</th>
            <th width="100px">联系人</th>
            <th width="150px">联系电话</th>
        </tr>

        <c:if test="${!empty list0}">
            <c:forEach items="${list0}" var="a">
                <tr>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_title}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct">
                            <c:if test="${a.rct_id eq rct.rct_id}">
                                ${rct.rct_introduaction()}
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
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">
                    <div class="div4">
                        <span>共 <%=page0.getTotalPage()%> 页</span>
                        <span>当前在第 <%=page0.getPageNo()%> 页</span>
                        <span><a href="orders?pageNo0=1&method=myOrders">首页</a></span>
                        <span><a href="orders?pageNo0=<%=page0.getPrevPage()%>&method=myOrders">上一页</a></span>
                        <span><a href="orders?pageNo0=<%=page0.getNextPage()%>&method=myOrders">下一页</a></span>
                        <span><a href="orders?pageNo0=<%=page0.getTotalPage()%>&method=myOrders">尾页</a></span>
                        <form style="size: 10px;display: inline" action="orders"
                              onsubmit="return checkNum(this.children[1].value)">
                            <input type="hidden" name="method" value="myOrders">
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
                <td colspan="4">没有待回复面试</td>
            </tr>
        </c:if>
    </table>
    <hr>
</div>
<div id="t2">
    待参加面试：
    <table>
        <tr>
            <th width="100px">简历名称</th>
            <th width="250px">职位描述</th>
            <th width="100px">联系人</th>
            <th width="150px">联系电话</th>
            <th width="200px">面试时间</th>
            <th width="100px">同意面试</th>
        </tr>
        <c:if test="${!empty list1}">
            <c:forEach items="${list1}" var="a">
                <tr>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_name}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct">
                            <c:if test="${a.rct_id eq rct.rct_id}">
                                ${rct.rct_introduaction()}
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
                        <fmt:formatDate value="${a.f_date}" pattern="yyyy-MM-dd HH-mm-ss"/>
                    </th>
                    <th>
                        <form method="post" action="agreeFtfs.do">
                            <input type="hidden" name="f_id" value="${a.f_id}">
                            <input type="submit" value="同意">
                        </form>
                    </th>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <div class="div4">
                        <span>共 <%=page1.getTotalPage()%> 页</span>
                        <span>当前在第 <%=page1.getPageNo()%> 页</span>
                        <span><a href="orders?pageNo1=1&method=myOrders">首页</a></span>
                        <span><a href="orders?pageNo1=<%=page1.getPrevPage()%>&method=myOrders">上一页</a></span>
                        <span><a href="orders?pageNo1=<%=page1.getNextPage()%>&method=myOrders">下一页</a></span>
                        <span><a href="orders?pageNo1=<%=page1.getTotalPage()%>&method=myOrders">尾页</a></span>
                        <form style="size: 10px;display: inline" action="orders"
                              onsubmit="return checkNum(this.children[1].value)">
                            <input type="hidden" name="method" value="myOrders">
                            <span style="size: 10px">去第</span><input name="pageNo1" type="number" value=1 min=1
                                                                     max=<%=page1.getTotalPage()%>>页
                            <input type="submit" value="确认">
                        </form>
                    </div>
                </td>
            </tr>
        </c:if>
        <c:if test="${empty list1}">
            <tr>
                <td colspan="5">没有待参加面试</td>
            </tr>
        </c:if>
    </table>
    <hr>
</div>

<div id="t3">
    已完成面试：
    <table>
        <tr>
            <th width="100px">简历名称</th>
            <th width="250px">职位描述</th>
            <th width="100px">联系人</th>
            <th width="150px">联系电话</th>
        </tr>
        <c:if test="${!empty list3}">
            <c:forEach items="${list3}" var="a">
                <tr>
                    <th>
                        <c:forEach items="${cvs}" var="cv">
                            <c:if test="${a.cv_id eq cv.cv_id}">
                                ${cv.cv_name}
                            </c:if>
                        </c:forEach>
                    </th>
                    <th>
                        <c:forEach items="${rcts}" var="rct">
                            <c:if test="${a.rct_id eq rct.rct_id}">
                                ${rct.rct_introduaction()}
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
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">
                    <div class="div4">
                        <span>共 <%=page3.getTotalPage()%> 页</span>
                        <span>当前在第 <%=page3.getPageNo()%> 页</span>
                        <span><a href="orders?pageNo3=1&method=myOrders">首页</a></span>
                        <span><a href="orders?pageNo3=<%=page3.getPrevPage()%>&method=myOrders">上一页</a></span>
                        <span><a href="orders?pageNo3=<%=page3.getNextPage()%>&method=myOrders">下一页</a></span>
                        <span><a href="orders?pageNo3=<%=page3.getTotalPage()%>&method=myOrders">尾页</a></span>
                        <form style="size: 10px;display: inline" action="orders"
                              onsubmit="return checkNum(this.children[1].value)">
                            <input type="hidden" name="method" value="myOrders">
                            <span style="size: 10px">去第</span><input name="pageNo3" type="number" value=1 min=1
                                                                     max=<%=page3.getTotalPage()%>>页
                            <input type="submit" value="确认">
                        </form>
                    </div>
                </td>
            </tr>
        </c:if>
        <c:if test="${empty list3}">
            <tr>
                <td colspan="4">没有已完成面试</td>
            </tr>
        </c:if>
    </table>
    <hr>
</div>

<a href="index.jsp">返回首页</a>
</body>
</html>
