<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<p><h1>현재 시간</h1>
	<jsp:useBean id="date" class="java.util.Date"/>
	<p><%=date %>
</body>
</html>