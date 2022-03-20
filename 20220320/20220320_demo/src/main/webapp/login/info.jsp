<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<%
	Enumeration en =  session.getAttributeNames();
	boolean isLogin = false;
	if(en.hasMoreElements()){
		String name = (String)en.nextElement();
		if(name.equals("id")){
			isLogin = true;
			String id = (String)session.getAttribute(name);
			String.format("%s님 환영합니다. <br>",id);
		}		
	}
	else{
		out.print("회원정보가 없습니다. 로그인 해주세요<br>");	
	}	
%>
<%
	if(isLogin)
%>
		<a href="logout">로그아웃</a>
<%
	else
%>
		<a href="login.html">로그인</a>
</body>
</html>