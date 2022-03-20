<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	String password = (String)session.getAttribute("password");
	out.print( String.format("설정된 세션의 값 [1] : %s <br>", id) );
	out.print( String.format("설정된 세션의 값 [2] : %s", password) );	
%>
</body>
</html>