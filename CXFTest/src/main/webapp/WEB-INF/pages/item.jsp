<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>price</th>
        <th>order</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.productName}</td>
            <td>${item.sellPrice}</td>
            <td>${item.order}</td>
        </tr>
    </c:forEach>
</table>

<br/>
</body>
</html>
