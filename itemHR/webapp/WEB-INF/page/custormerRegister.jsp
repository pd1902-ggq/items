<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\7\17 0017
  Time: 16:34
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
    <meta charset="UTF-8">
    <title>注册</title>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
           $("#name").change(function () {
               var value=$("#name").val();
               $.ajax({
                   type:"post",
                   url:"checkCustormer.do",
                   data:{"name":value},
                   success:function (obj) {
                       $("#td3").text(obj)
                   }
               })
           })
        });
        function fun1() {
            var name = document.getElementsByName("name")[0].value;
            var reg1 = /^[A-z]\w{5,10}$/;
            if(!reg1.test(name)){
                document.getElementById("td1").innerText="请用字母开头，并用户名长度在6-11位之间"
                document.getElementById("td1").style.color = "red";
                return;
            }else{
                document.getElementById("td1").innerText=""
            }
        }
        function fun2() {
            var pass = document.getElementsByName("pass")[0].value;
            if(pass.length < 5){
                document.getElementById("td2").innerText="密码长度不能少于5个字符"
                document.getElementById("td2").style.color = "red"
                return;
            }else{
                document.getElementById("td2").innerText=""
            }
        }
    </script>
</head>
<body>
<fieldset>
    <legend>游客注册</legend>
    <form method="post" action="custormerRegister.do">
        <table border="0px" cellspacing="" cellpadding="">
            <tr>
                <td>用户名:</td>
                <td><input id="name" type="text" name="c_account" onblur="fun1()"/></td>
                <td id="td1"></td>
                <td id="td3" style="color: red"></td>
            </tr>
            <tr>
                <td>登录密码:</td>
                <td><input type="password" name="c_pass" onblur="fun2()"/></td>
                <td id="td2"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
