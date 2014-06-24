<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Home Page :: MediNetServices</title>
</head>

<body>

<p>
    <img src="<c:url value="/static/img/logo.jpg"/>"/>
</p>

<h2>
    Welcome to MediNetServices!
</h2>

<security:authorize access="hasRole('admin')">
    <a href="<c:url value="/admin/index"/>">Dashboard </a>
</security:authorize>

<security:authorize access="hasRole('user')">
    <a href="<c:url value="/user/index"/>">Dashboard </a>
</security:authorize>

<p>
    ${msg}
</p>

</body>
</html>
