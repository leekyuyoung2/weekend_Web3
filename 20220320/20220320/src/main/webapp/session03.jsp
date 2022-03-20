<%@page import="java.util.Enumeration"%>
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
		Enumeration en =  session.getAttributeNames();
		if(!en.hasMoreElements()){
			out.print("<p>현재 설정된 세션이 없습니다.");			
		}else{
			while(en.hasMoreElements()){
				String name =  en.nextElement().toString();
				String value =  session.getAttribute(name).toString();
				out.print(String.format("설정된 세션의 속성 이름 [ %s ] : %s <br>", name, value));
			}
		}
	%>
</body>
</html>