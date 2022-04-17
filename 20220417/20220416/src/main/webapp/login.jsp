<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upsw = request.getParameter("psw");
	
	MemberDAO dao = new MemberDAO();
	switch(dao.exists(uid, upsw)){
	case 0:
		out.print("알수 없는 예외가 발생했습니다.");
		return;
	case 1:
		out.print("아이디가 일치하지 않습니다.");
		return;
	case 2:
		out.print("비밀번호가 일치하지 않습니다.");
		return;
	}	
	// 로그인 성공
	session.setAttribute("id", uid);
	response.sendRedirect("main.jsp");	
%>
</body>
</html>