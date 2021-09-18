<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 18/09/2021
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Choose Condiments</title>
    </head>
    <body>
        <form action="/save" method="post">
            <input type="checkbox" name="condiment" value="Lettuce" id="lettuce">
            <label for="lettuce">Lettuce</label>
            <input type="checkbox" name="condiment" value="Tomato" id="tomato">
            <label for="tomato">Tomato</label>
            <input type="checkbox" name="condiment" value="Mustard" id="mustard">
            <label for="mustard">Mustard</label>
            <input type="checkbox" name="condiment" value="Sprouts" id="sprouts">
            <label for="sprouts">Sprouts</label>
            <hr>
            <button type="submit">Save</button>
        </form>

    </body>
</html>
