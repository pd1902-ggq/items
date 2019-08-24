
<%@ page import="java.util.List" %>
<%@ page import="ggq.model.UserDetail" %>
<%--
  Created by IntelliJ IDEA.
  User: 11929
  Date: 2019/7/18
  Time: 14:56
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
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/updatecss.css">
    <script type="text/javascript" src="js/updatejs.js"></script>
</head>
<body>
<input type="button" value="添加详情">
<table>
    <tr>
        <th>ID</th>
        <th>RECEIVER</th>
        <th>PHONE</th>
        <th>ADDRESS</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <%
        List<UserDetail> uds = (List<UserDetail>) request.getAttribute("uds");
        if(uds !=null&& uds.size()!=0){
            for (UserDetail detail : uds) {
    %>
    <tr>
        <td><%=detail.getId()%></td>
        <td><%=detail.getReceiver()%></td>
        <td><%=detail.getPhone()%></td>
        <td><%=detail.getAddress()%></td>
        <td>
            <input type="button" value="修改" onclick="f(<%=detail.getId()%>)">
            <div id="update" style="display:none ">

            </div>
        </td>
        <td>
            <a href="delUd?id=<%=detail.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    }else {
    %>
    <tr><td colspan="6">没有详情，请先添加</td></tr>
    <%
        }
    %>
</table>

</body>
</html>
