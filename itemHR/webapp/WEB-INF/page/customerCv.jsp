<%@ page import="com.iotek.model.Cv" %>
<%@ page import="com.iotek.model.Page" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/24
  Time: 9:46
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
    <title>个人简历</title>
    <style>
        body {
            background-image: url("jpg/cat2.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#add").click(function () {
                $("#addOrUpdate").css("display", "block");
                $("#method").val("add");
            });
        })
    </script>
    <script src="js/customerCv.js" type="text/javascript"></script>
</head>
<body>
<c:if test="${addCv}">
    <script>
        alert("简历添加成功")
    </script>
</c:if>
<c:if test="${addCv eq false}">
    <script>
        alert("简历添加失败")
    </script>
</c:if>
<c:if test="${updateCv}">
    <script>
        alert("简历更新成功")
    </script>
</c:if>
<c:if test="${deleCv}">
    <script>
        alert("简历删除成功")
    </script>
</c:if>
<%
    Page<Cv> cvs = (Page<Cv>) request.getAttribute( "cvs" );
    List<Cv> list = cvs.getList();
    pageContext.setAttribute( "list", list );
%>
<c:if test="${!empty list}">
    <c:forEach items="${list}" var="c">
        <table>
            <tr>
                <td width="150px">标题:</td>
                <td width="150px" class="title">${c.cv_title}</td>
            </tr>
            <tr>
                <td width="150px">姓名:</td>
                <td width="150px" class="name">${c.cv_name}</td>
            </tr>
            <tr>
                <td width="150px">性别:</td>
                <td width="150px" class="gender">${c.cv_gender}</td>
            </tr>
            <tr>
                <td width="150px">电话:</td>
                <td width="150px" class="phone">${c.cv_phone}</td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td class="birth"><fmt:formatDate value="${c.cv_birth}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>住址:</td>
                <td class="address">${c.cv_address}</td>
            </tr>
            <tr>
                <td>学校名称:</td>
                <td class="school">${c.cv_school}</td>
            </tr>
            <tr>
                <td>学历:</td>
                <td class="education">${c.cv_education}</td>
            </tr>
            <tr>
                <td>所学专业:</td>
                <td class="major">${c.cv_major}</td>
            </tr>
            <tr>
                <td>入学时间</td>
                <td class="enroll"><fmt:formatDate value="${c.cv_enroll_date}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>毕业时间</td>
                <td class="graduation"><fmt:formatDate value="${c.cv_graduation_date}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>期望薪资</td>
                <td class="salary">${c.cv_salary}</td>
            </tr>
            <tr>
                <td> 经历</td>
                <td class="exprience">${c.cv_exprience}</td>
            </tr>
            <tr>
                <td>修改</td>
                <td><input id="update${c.cv_id}" type="button" value="修改"></td>
                <script>
                    $(function () {
                        var cvid =${c.cv_id};
                        $("#update" + cvid).click(function () {
                            $("#addOrUpdate").css("display", "block");
                            $("#method").val("update");
                            $("#cv_name").val("${c.cv_name}");
                            $("#cv_address").val("${c.cv_address}");
                            $("#cv_birth").val("<fmt:formatDate value='${c.cv_birth}' pattern='yyyy-MM-dd'/>");
                            $("#cv_school").val("${c.cv_school}");
                            $("#cv_education").val("${c.cv_education}");
                            $("#cv_enroll_date").val("<fmt:formatDate value='${c.cv_enroll_date}' pattern='yyyy-MM-dd'/>");
                            $("#cv_exprience").val("${c.cv_exprience}");
                            $("#cv_gender").val("${c.cv_gender}");
                            $("#cv_graduation_date").val("<fmt:formatDate value='${c.cv_graduation_date}' pattern='yyyy-MM-dd'/>");
                            $("#cv_id").val("${c.cv_id}");
                            $("#cv_major").val("${c.cv_major}");
                            $("#cv_salary").val("${c.cv_salary}");
                            $("#c_id").val("${c.c_id}");
                            $("#cv_title").val("${c.cv_title}");
                            $("#cv_phone").val("${c.cv_phone}");

                        });
                    })
                </script>
                <td>删除</td>
                <td>
                    <form method="post" action="deleCv.do">
                        <input type="hidden" name="cv_id" value="${c.cv_id}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </table>
    </c:forEach>
    <div class="div4">
        <span>共 <%=cvs.getTotalPage()%> 页</span>
        <span>当前在第 <%=cvs.getPageNo()%> 页</span>
        <span><a href="getcvs.do?pageNo=1">首页</a></span>
        <span><a href="getcvs.do?pageNo=<%=cvs.getPrevPage()%>">上一页</a></span>
        <span><a href="getcvs.do?pageNo=<%=cvs.getNextPage()%>">下一页</a></span>
        <span><a href="getcvs.do?pageNo=<%=cvs.getTotalPage()%>">尾页</a></span>
        <form style="size: 10px" action="getcvs.do" onsubmit="return checkNum(this.children[1].value)">
            <span style="size: 10px">去第</span><input name="pageNo" type="number" value=1 min=1
                                                     max=<%=cvs.getTotalPage()%>>页
            <input type="submit" value="确认">
        </form>
    </div>
</c:if>
<c:if test="${empty list}">
    暂无简历<br/>
</c:if>
<input id="add" type="button" value="添加">
<div id="addOrUpdate" style="display: none">
    <form method="post" action="addOrUpdateCv.do">
        <table>
            <tr>
                <td width="150px">标题:</td>
                <td width="150px"><input type="text" name="cv_title" id="cv_title"></td>
            </tr>
            <tr>
                <td width="150px">姓名:</td>
                <td width="150px"><input type="text" name="cv_name" id="cv_name"></td>
            </tr>
            <tr>
                <td width="150px">性别:</td>
                <td width="150px"><input type="text" name="cv_gender" id="cv_gender"></td>
            </tr>
            <tr>
                <td width="150px">电话:</td>
                <td width="150px"><input type="text" name="cv_phone" id="cv_phone"></td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td><input type="date" name="cv_birth" id="cv_birth"></td>
            </tr>
            <tr>
                <td>住址:</td>
                <td><input type="text" name="cv_address" id="cv_address"></td>
            </tr>
            <tr>
                <td>学校名称:</td>
                <td><input type="text" name="cv_school" id="cv_school"></td>
            </tr>
            <tr>
                <td>学历:</td>
                <td><input type="text" name="cv_education" id="cv_education"></td>
            </tr>
            <tr>
                <td>所学专业:</td>
                <td><input type="text" name="cv_major" id="cv_major"></td>
            </tr>
            <tr>
                <td>入学时间:</td>
                <td><input type="date" name="cv_enroll_date" id="cv_enroll_date"></td>
            </tr>
            <tr>
                <td>毕业时间:</td>
                <td><input type="date" name="cv_graduation_date" id="cv_graduation_date"></td>
            </tr>
            <tr>
                <td>期望薪资:</td>
                <td><input type="number" name="cv_salary" id="cv_salary"></td>
            </tr>
            <tr>
                <td>经历:</td>
                <td><textarea name="cv_exprience" id="cv_exprience"></textarea></td>
            </tr>
        </table>
        <input type="hidden" id="method" name="method">
        <input type="hidden" id="cv_id" name="cv_id" value=0>
        <input type="hidden" id="c_id" name="c_id">
        <input type="submit" value="提交"><input type="reset" value="重置">
    </form>

</div>
<br/>
<a href="index.jsp">返回首页</a>
</body>
</html>

