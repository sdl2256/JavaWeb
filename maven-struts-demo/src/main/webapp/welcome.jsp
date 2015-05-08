<%--
  Created by IntelliJ IDEA.
  User: SDL
  Date: 2015/5/8
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Struts2-Demo-欢迎页面</title>
</head>
<body>
Welcome:
<br>

<h1>name=<s:property value="name"/></h1>

<h1>password=<s:property value="password"/></h1>

<h1>重新登录</h1>
<s:form action="login_go" namespace="/" method="post">
    <s:textfield name="name" label="name"></s:textfield>
    <s:password name="password" label="password"></s:password>

    <s:submit value="Login"></s:submit>
</s:form>
</body>
</html>
