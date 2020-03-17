<%--
  Created by IntelliJ IDEA.
  User: shaxibijin
  Date: 2020/3/5
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录系统</h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post" >
        帐号：<input type="text" name="account" placeholder="请输入用户帐号"/><br/>
        密码：<input type="password" name="password" placeholder="请输入用户密码"><br/>
        <input type="submit" value="登录">
    </form>
    <div>${msg}</div>
</body>
</html>
