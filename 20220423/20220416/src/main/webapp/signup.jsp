<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
</head>
<body>
<%
// 회원가입 프로세스
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upsw = request.getParameter("psw");
	String upswconfirm = request.getParameter("pswconfirm");
	String uname = request.getParameter("name");
	
	MemberDAO dao = new MemberDAO();
	// 패스워드 확인
	
	if(!upsw.equals(upswconfirm)){
		out.print("패스워드확인이 틀립니다.");
		return;		
	}
	
	// 이미 가입한 회원
	if(dao.exists(uid)){
		out.print("이미 가입한 회원입니다.");
		return;
	}
	
	// 가입하지 않은 회원이면 회원가입, 그리고 오류처리
	if(dao.insert(uid, upsw, uname))
		out.print("회원가입이 완료되었습니다.");
	else
		out.print("회원가입 처리중 오류가 발생했습니다.");
	
%>

</body>
</html>