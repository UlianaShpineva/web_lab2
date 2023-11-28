<%--
  Created by IntelliJ IDEA.
  User: ulian
  Date: 16.10.2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>error</title>
    <link rel="stylesheet" type="text/css" href="styles/mainPageStyle.css">
</head>
<header>
    <h1>Shpineva Uliana Sergeevna<br>
        group P3216, variant 3749</h1>
</header>
<body>
<table id="errorTable">
    <tr>
        <td>
            <div id="errorMsg">
                Error
                 <br>
                <%=session.getAttribute("error")%>
            </div>
        </td>
    </tr>
    <tr>
        <a href="${pageContext.request.contextPath}">
            <button id="goBackButton">Go back</button>
        </a>
    </tr>

</table>
</body>
</html>
