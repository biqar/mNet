<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  User: Bazlur Rahma Rokon
  Date: 6/25/14
  Time: 12:11 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <title>MediNetServices :: Login</title>

    <style type="text/css">
        .container {
            width: 500px;
            clear: both;
        }

        .container input {
            width: 100%;
            clear: both;
        }
    </style>
</head>
<body>
<div id="container">
    <c:if test="${not empty param.login_error}">
        <div class="errors">
            <p>

            <p>Your login attempt was not successful, try again. Reason:
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> .
            </p>
        </div>
    </c:if>

    <form action="<c:url value="/static/j_spring_security_check"/>" method="POST" name="f">
        <div>
            <label for="j_username"> Login: </label>
            <input id="j_username" name="j_username" style="width:150px" type="text"/>
        </div>

        <br/>

        <div>
            <label for="j_password"> Password: </label>
            <input id="j_password" name="j_password" style="width:150px" type="password"/>
        </div>
        <br/>

        <div class="submit">
            <input id="proceed" type="submit" value="Submit"/>
        </div>
    </form>
</div>
</body>
</html>
