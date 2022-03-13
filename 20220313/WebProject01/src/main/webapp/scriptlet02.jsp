<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
순환문을 이용해서 짝수만 출력  <br>를 붙여서 println 효과를 준다 
 -->
 
<%-- <%! %> --%>

<%
	for(int i=0; i<=10; i++){
		if(i % 2 ==0)
			out.print(i+"<br>");
	}
%>

<%-- <%=%> --%>
</body>
</html>