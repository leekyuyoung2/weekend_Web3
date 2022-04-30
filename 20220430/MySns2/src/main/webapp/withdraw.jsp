<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
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
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String psw = request.getParameter("password");
	String confirmpsw = request.getParameter("confirmpassword");
	String name = request.getParameter("name");

	UserDAO dao = new UserDAO();
	// errroCode : 0 성공  1: 회원이 존재하지 않으면.  2: 패스워드확인 실패

	int errorCode = 0;
	if (!dao.findByUserId(id))
		errorCode = 1;
	if (!psw.equals(confirmpsw))
		errorCode = 2;
	if (errorCode > 0) {		
		//request.setAttribute("errorCode", errorCode);
		//request.getRequestDispatcher("signup.html").forward(request, response);
		return;
	}	
	int count = dao.deleteById(id);
	if (count < 1) {
		out.print("회원탈퇴중에 알수 없는 에러가 발생했습니다.");
		return;
	}

	response.sendRedirect("index.html");
	%>
</body>
</html>