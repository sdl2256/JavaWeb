<%--
  Created by IntelliJ IDEA.
  User: SDL
  Date: 2015/5/8
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>struts2-Demo-登录界面</title>
</head>
<body>
<p>struts2-Demo-登录界面</p>

<form action="login_go" method="post">
    name:<input type="text" name="name"/>
    password<input type="password" name="password"/>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
