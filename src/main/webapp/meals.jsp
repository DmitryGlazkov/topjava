<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<html>
<head>
    <title>Meals</title>
    <style>
        .exceedTrue {background-color: pink}
        .exceedFalse {background-color: lightgreen}
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table border="1" cellpadding="8" cellspacing="4">
    <thead>
    <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
        <c:forEach var="it" items="${mealList}">
            <tr class="${it.isExceed() ? 'exceedTrue' : 'exceedFalse'}">
                <td>${f:formatLocalDateTime(it.getDateTime(), 'yyyy-MM-dd HH:mm')}</td>
                <td>${it.getDescription()}</td>
                <td>${it.getCalories()}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
