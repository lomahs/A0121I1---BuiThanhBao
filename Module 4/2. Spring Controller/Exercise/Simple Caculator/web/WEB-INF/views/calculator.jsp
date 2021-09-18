<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 18/09/2021
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Calculator</title>
    </head>
    <body>
        <form action="/calculator">
            <fieldset>
                <legend><h1>Calculator</h1></legend>
                <input type="text" name="firstOperand" value="${firstOperand}">
                <input type="text" name="secondOperand" value="${secondOperand}">
                <p>${error}</p>
                <h4>Result: ${result}</h4>
                <button type="submit" name="operator" value="add">Addition(+)</button>
                <button type="submit" name="operator" value="sub">Subtraction(-)</button>
                <button type="submit" name="operator" value="multi">Multiplication(x)</button>
                <button type="submit" name="operator" value="div">Division(/)</button>
            </fieldset>
        </form>
    </body>
</html>
