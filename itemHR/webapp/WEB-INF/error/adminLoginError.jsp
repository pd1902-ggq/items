<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/23
  Time: 18:49
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
    <title>管理员登录错误界面</title>
</head>
<body>
    <a href="adminLoginView.do">用户或密码错误，请返回重新登录！</a>
</body>
</html>
