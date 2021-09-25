<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 22/09/2021
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Configuration</title>
    </head>
    <body>
        <h2>Settings</h2>
        <form:form modelAttribute="configuration" action="/" method="post">
            <table>
                <tr>
                    <td>Languages</td>
                    <td>
                        <form:select path="language" items="${language}"/>
                    </td>
                </tr>
                <tr>
                    <td>Page Size</td>
                    <td>Show
                    <form:select path="pageSize" items="${pageSize}"/> emails per page </td>
                </tr>
                <tr>
                    <td>Spams filter</td>
                    <td>
                        <form:checkbox path="enableSpamFilter" value="${true}"/> Enable spams filter
                    </td>
                </tr>
                <tr>
                    <td>Signature</td>
                    <td>
                        <form:textarea path="signature"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Update</button>
                        <button type="reset">Cancel</button>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
