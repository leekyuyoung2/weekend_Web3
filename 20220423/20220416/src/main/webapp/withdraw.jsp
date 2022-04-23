<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	if(!dao.exists(uid)){
		out.print("회원정보를 찾을 수 없습니다.");
		return;
	}
	if(dao.delete(uid))
		out.print("회원탈퇴가 완료 되었습니다.");
	else
		out.print("회원탈퇴처리중 오류가 발생했습니다.");
%>
</body>
</html>