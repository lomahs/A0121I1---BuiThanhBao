<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 18/09/2021
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>List</title>
    </head>
    <body>
        <h4>List necessary condiments:</h4>
        <ul style="list-style-type: decimal">
            <c:forEach var="condiment" items="${condiment}">
                <li>${condiment}</li>
            </c:forEach>
        </ul>
    </body>
</html>
