<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 15/09/2021
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Currency Converter</title>
    </head>
    <body>
        <form action="/converter" method="post">
            Exchange Rate:
            <input type="text" name="rate" value="22000"><br>
            USD:
            <input type="text" name="usd" value="0"><br>
            <button type="submit">Converter</button>
        </form>
    </body>
</html>
