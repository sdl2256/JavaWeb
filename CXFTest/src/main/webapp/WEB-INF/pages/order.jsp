<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order.jsp</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Order Id</th>
        <th>Order amount</th>
        <th>detail</th>
    </tr>
    <c:forEach items="${list}" var="order">
        <tr>
            <td>${order.orderid}</td>
            <td>${order.amount}</td>
            <td><a href="${pageContext.request.contextPath}/main/getitems/${order.orderid}.do">详细信息</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
