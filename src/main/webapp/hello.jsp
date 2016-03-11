<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<h1><%= request.getAttribute("message")%></h1>
<h1>${requestScope.message}</h1>

</body>
</html>
