<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Komandor
  Date: 08.12.2021
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<jsp:useBean id="employeeBean" scope="request" type="com.office.data.beans.EmployeeBean"/>
<h1>${employeeBean.size}</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last name</th>
        <th>Age</th>
        <th>Payment_type</th>
        <th>Role</th>
        <th>Preference</th>
        <th>Current Preference</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeBean.employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.lastName}</td>
            <td>${e.firstName}</td>
            <td>${e.age}</td>
            <td>${e.payment_type}</td>
            <td>${e.role}</td>
            <td>${e.preference}</td>
            <td>${e.currentPreference}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
