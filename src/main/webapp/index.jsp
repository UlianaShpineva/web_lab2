<%--
  Created by IntelliJ IDEA.
  User: ulian
  Date: 16.10.2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="data.UserSessionBean" %>
<%@ page import="data.UserData" %>
<%@ page import="jakarta.inject.Inject" %>
<jsp:useBean id="userSessionBean" class="data.UserSessionBean" scope="session"/>
<%--<jsp:setProperty name="userSessionBean" property="requests" value="${userSessionBean.requests}"/>--%>
<%--<jsp:setProperty name="userSessionBean" property="*"/>--%>
<%--<jsp:getProperty name="userSessionBean" property="*"/>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Web lab2</title>
    <link rel="stylesheet" type="text/css" href="styles/mainPageStyle.css">

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts/Coords.js"></script>
    <script src="scripts/graph.js"></script>
    <script src="scripts/mainPageController.js"></script>
</head>
<header>
    <h1>Shpineva Uliana Sergeevna<br>
        group P3216, variant 3749</h1>
</header>
<body>
<table>
    <tr>
        <td>
            <canvas id="graph" width="400" height="400"></canvas>
        </td>
        <td>
            <form id="mainForm">
                <div>
                    <div id="xButtons">
                        <label for="xButtons">X</label>
                        <button type="button" name="x">-5</button>
                        <button type="button" name="x">-4</button>
                        <button type="button" name="x">-3</button>
                        <button type="button" name="x">-2</button>
                        <button type="button" name="x">-1</button>
                        <button type="button" name="x">0</button>
                        <button type="button" name="x">1</button>
                        <button type="button" name="x">2</button>
                        <button type="button" name="x">3</button>
                    </div>

                    <div>
                        <label for="yInput">Y</label>
                        <input name="y" type="text" id="yInput" maxlength="15" placeholder="from -5 to 5">
                    </div>

                    <div id="rInput">
                        <label for="rInput">R</label>
                        <label class="radios"><input id="radio1" name="R-radio-group" type="radio" value="1" />1</label>
                        <label class="radios"><input id="radio2" name="R-radio-group" type="radio" value="1.5" />1.5</label>
                        <label class="radios"><input id="errorRadio" name="R-radio-group" type="radio" value="2" />2</label>
                        <label class="radios"><input id="radio4" name="R-radio-group" type="radio" value="2.5" />2.5</label>
                        <label class="radios"><input id="radio5" name="R-radio-group" type="radio" value="3" />3</label>
                    </div>
                </div>
            </form>
            <div id="btns">
                <button type="submit" id="checkButton">Submit</button>
                <button class="btn" id="clearButton">Reset</button>
            </div>
        </td>
    </tr>
<%--    <tfoot>--%>
    <tr>
        <p></p>
    </tr>

    <tr>
        <td colspan="5" id="historyContainer">
            <table id="outputTable">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Hit fact</th>
                    <th>Current time</th>
                    <th>Execution time</th>
                </tr>


                <%
                    if (!userSessionBean.getRequests().isEmpty()) {
                %>
                <p hidden="hidden"> ${userSessionBean.requests.get(0).lastR}</p>
                <%}%>


                <c:forEach items="${userSessionBean.requests}" var="data">
                    <tr>
                        <td> ${data.x}</td>
                        <td> ${data.y}</td>
                        <td> ${data.r}</td>
                        <c:choose>
                            <c:when test="${data.success == true}">
                                <td>Hit</td>
                            </c:when>
                            <c:otherwise>
                                <td>Miss</td>
                            </c:otherwise>
                        </c:choose>
                        <td> ${data.currentTime}</td>
                        <td> ${data.executionTime} ms</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
