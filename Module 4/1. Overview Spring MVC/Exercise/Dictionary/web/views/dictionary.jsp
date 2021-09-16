<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 15/09/2021
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Dictionary</title>
    </head>
    <body>
        <form action="/translate" method="post">
            English:
            <input type="text" name="eng" value="${eng}">
            Vietnamese:
            <input type="text" name="vie" value="${vie}" readonly>
            <button type="submit">Translate</button>
        </form>
    </body>
</html>
