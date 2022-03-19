<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>id : <%= request.getAttribute("id") %></p>
<p>password : <%= request.getAttribute("password") %></p>
</body>
</html>