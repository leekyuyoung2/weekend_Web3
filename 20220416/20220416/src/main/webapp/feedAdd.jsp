<%@page import="dao.FeedDAO"%>
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
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String ucont = request.getParameter("content");
	FeedDAO dao = new FeedDAO();
	if(dao.insert(uid, ucont))
		out.print("작성하신 글이 업로드 되었습니다.");
	else
		out.print("업로드중에 오류가 발생하였습니다.");
		
%>
</body>
</html>