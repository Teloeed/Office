<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello Boss</title>
</head>
<body>
<h1><%= "Hello Boss!" %></h1>
<br/>
<a href="allemployee.html">Hello Servlet</a>
<a href="allagentsjson.html">Json list</a>
<form method="post" action="saleagent.html">
    <label for ="year">Year</label>
    <input id ="year" type="number" name="year">
    <input type="submit" value="Find">
</form>
</body>
</html>