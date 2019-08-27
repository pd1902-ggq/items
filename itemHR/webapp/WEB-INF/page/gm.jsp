<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/28
  Time: 18:28
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
    <title>管理员主页面</title>
    <style>
        body{
            background-image:url("jpg/cat4.jpg") ;
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<button><a href="ftfsGmView.do">面试管理</a></button>
<button><a href="departmentGmView.do">部门及职务管理</a></button>
</body>
</html>
