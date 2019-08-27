<%@ page import="com.iotek.model.Department" %>
<%@ page import="com.iotek.model.Page" %>
<%@ page import="com.iotek.model.Position" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/27
  Time: 14:00
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
    <title>部门管理</title>
    <style>
        td {
            align: center;
            text-align: center;
            vertical-align: middle;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#addDepart").click(function () {
                $("#addOrUpdateDepart").css("display", "block");
                $("#method").val("addDepartment");
            });
            $("#addPos").click(function () {
                $("#addOrUpdatePos").css("display", "block");
                $("#method1").val("addPos");
            });
        })
    </script>
</head>
<body>

<c:if test="${addDepart eq true}">
    <script>
        alert("部门添加成功")
    </script>
</c:if>
<c:if test="${addDepart eq false}">
    <script>
        alert("部门添加失败")
    </script>
</c:if>

<c:if test="${updateDepart eq true}">
    <script>
        alert("部门修改成功")
    </script>
</c:if>
<c:if test="${updateDepart eq false}">
    <script>
        alert("部门修改失败")
    </script>
</c:if>

<c:if test="${deleDepart eq true}">
    <script>
        alert("部门删除成功")
    </script>
</c:if>
<c:if test="${deleDepart eq false}">
    <script>
        alert("部门删除失败")
    </script>
</c:if>

<c:if test="${addPos eq true}">
    <script>
        alert("职务添加成功")
    </script>
</c:if>
<c:if test="${addPos eq false}">
    <script>
        alert("职务添加失败")
    </script>
</c:if>

<c:if test="${updatePos eq true}">
    <script>
        alert("职务修改成功")
    </script>
</c:if>
<c:if test="${updatePos eq false}">
    <script>
        alert("职务修改失败")
    </script>
</c:if>

<c:if test="${delePos eq true}">
    <script>
        alert("职务删除成功")
    </script>
</c:if>
<c:if test="${delePos eq false}">
    <script>
        alert("职务删除失败")
    </script>
</c:if>

<%
    Page<Department> departmentPage = (Page<Department>) request.getAttribute( "departments" );
    Page<Position> positionPage = (Page<Position>) request.getAttribute( "pasitions" );
    pageContext.setAttribute( "departments", departmentPage.getList() );
    pageContext.setAttribute( "positions", positionPage.getList() );
%>
<fieldset>
    <legend>部门管理</legend>
    <table>
        <tr>
            <th width="100px">部门名称</th>
            <th width="200px">创部时间</th>
            <th width="100px">修改</th>
            <th width="100px">删除</th>
        </tr>
        <c:if test="${!empty departments}">
            <c:forEach items="${departments}" var="d">
                <td>${d.dep_name}</td>
                <td><fmt:formatDate value="${d.dep_date}" pattern="yyyy-MM-dd"/></td>
                <td><input id="update${d.dep_id}" type="button" value="修改"></td>
                <script>
                    $(function () {
                        var depid =${d.dep_id};
                        $("#update" + depid).click(function () {
                            $("#addOrUpdateDepart").css("display", "block");
                            $("#method").val("updateDepartment");
                            $("#dep_name").val("${d.dep_name}");
                            $("#dep_id").val("${d.dep_id}");
                        });
                    })
                </script>
                <td>
                    <form action="deleDepartment.do" method="post">
                        <input type="hidden" name="dep_id" value="${d.dep_id}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </c:forEach>
            <tr>
                <td colspan="2">
                    <div class="div4">
                        <span>共 <%=departmentPage.getTotalPage()%> 页</span>
                        <span>当前在第 <%=departmentPage.getPageNo()%> 页</span>
                        <span><a href="departmentGmView.do?pageNo1=1">首页</a></span>
                        <span><a href="departmentGmView.do?pageNo1=<%=departmentPage.getPrevPage()%>">上一页</a></span>
                        <span><a href="departmentGmView.do?pageNo1=<%=departmentPage.getNextPage()%>">下一页</a></span>
                        <span><a href="departmentGmView.do?pageNo1=<%=departmentPage.getTotalPage()%>">尾页</a></span>
                        <form style="size: 10px;display: inline" action="departmentGmView.do"
                              onsubmit="return checkNum(this.children[1].value)">
                            <span style="size: 10px">去第</span><input name="pageNo1" type="number" value=1 min=1
                                                                     max=<%=departmentPage.getTotalPage()%>>页
                            <input type="submit" value="确认">
                        </form>
                    </div>
                </td>
            </tr>
        </c:if>
        <c:if test="${empty departments}">
            <tr>
                <td colspan="2">无部门</td>
            </tr>
        </c:if>
    </table>
</fieldset>
<input id="addDepart" type="button" value="添加">
<div id="addOrUpdateDepart" style="display: none">
    <form method="post" action="addOrUpdateDepartment.do">
        <table>
            <tr>
                <td width="100px">部门名称</td>
                <td width="100px"><input type="text" id="dep_name" name="dep_name"></td>
            </tr>
        </table>
        <input type="hidden" id="method" name="method">
        <input type="hidden" id="dep_id" name="cv_id" value=0>
        <input type="submit" value="提交"><input type="reset" value="重置">
    </form>
</div>
    <hr>
    <fieldset>
        <legend>职务管理</legend>
        <table>
            <tr>
                <th width="200px">部门名称</th>
                <th width="200px">职务名称</th>
                <th width="100px">修改</th>
                <th width="100px">删除</th>
            </tr>
            <c:if test="${!empty positions}">
                <c:forEach items="${positions}" var="p">
                    <c:forEach items="${departments}" var="d">
                        <c:if test="${p.dep_id eq d.dep_id}">
                            <td>${d.dep_name}</td>
                        </c:if>
                    </c:forEach>
                    <td>
                            ${p.pos_name}
                    </td>
                    <td><input id="updatePos${p.pos_id}" type="button" value="修改"></td>
                    <script>
                        $(function () {
                            var posid =${p.pos_id};
                            $("#updatePos" + posid).click(function () {
                                $("#addOrUpdatePos").css("display", "block");
                                $("#method1").val("updatePos");
                                $("#pos_name").val("${p.pos_name}");
                                $("#pos_id").val("${p.pos_id}");
                            });
                        })
                    </script>
                    <td>
                        <form action="delePos.do" method="post">
                            <input type="hidden" name="pos_id" value="${p.pos_id}">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </c:forEach>
                <tr>
                    <td colspan="2">
                        <div class="div4">
                            <span>共 <%=positionPage.getTotalPage()%> 页</span>
                            <span>当前在第 <%=positionPage.getPageNo()%> 页</span>
                            <span><a href="departmentGmView.do?pageNo2=1">首页</a></span>
                            <span><a href="departmentGmView.do?pageNo2=<%=positionPage.getPrevPage()%>">上一页</a></span>
                            <span><a href="departmentGmView.do?pageNo2=<%=positionPage.getNextPage()%>">下一页</a></span>
                            <span><a href="departmentGmView.do?pageNo2=<%=positionPage.getTotalPage()%>">尾页</a></span>
                            <form style="size: 10px;display: inline" action="departmentGmView.do"
                                  onsubmit="return checkNum(this.children[1].value)">
                                <span style="size: 10px">去第</span><input name="pageNo2" type="number" value=1 min=1
                                                                         max=<%=positionPage.getTotalPage()%>>页
                                <input type="submit" value="确认">
                            </form>
                        </div>
                    </td>
                </tr>
            </c:if>
            <c:if test="${empty positions}">
                <tr>
                    <td colspan="2">无职务</td>
                </tr>
            </c:if>
        </table>
    </fieldset>
<input id="addPos" type="button" value="添加">
<div id="addOrUpdatePos" style="display: none">
    <form method="post" action="addOrUpdatePos.do">
        <table>
            <tr>
                <td width="100px">职务名称</td>
                <td width="100px"><input type="text" id="pos_name" name="pos_name"></td>
            </tr>
        </table>
        <input type="hidden" id="method1" name="method1">
        <input type="hidden" id="pos_id" name="pos_id" value=0>
        <input type="submit" value="提交"><input type="reset" value="重置">
    </form>
</div>
    <a href="gm.do">返回主页</a>


</body>
</html>
