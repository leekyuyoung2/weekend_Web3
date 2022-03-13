<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
<%! // 스크립트 태그 : 선언문
int count = 3; 
String makeItLower(String data){
	return data.toLowerCase();
}
%>

<%
	for(int i = 0; i<count; i++){
		out.println("Java Server Page "+ i+"<br>");
	}
%>


<%=makeItLower("Hello world") %>
</body>
</html>