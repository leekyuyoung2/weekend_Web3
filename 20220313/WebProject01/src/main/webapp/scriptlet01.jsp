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
	int num1 = 2, num2 = 3; 
	//out.print( String.format("%d + %d = %d <br>",num1,num2, num1+num2) );	
%>

<%=String.format("%d + %d = %d <br>",num1,num2, num1+num2) %>
</body>
</html>