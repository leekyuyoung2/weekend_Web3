<%@page import="java.io.File"%>
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
	// errroCode : 0 성공  1: 사용할수 없는 아이디 입니다.  2: 패스워드확인 실패
	
	int errorCode = 0;
	if(dao.findByUserId(id)) errorCode = 1;
	if(!psw.equals(confirmpsw)) errorCode = 2;
	if(errorCode > 0){
		System.out.println(application.getRealPath(File.separator));
		System.out.println(errorCode);
		request.setAttribute("errorCode", errorCode);
		request.getRequestDispatcher("/error.jsp").forward(request, response);		
		return;
	}
	
	UserDTO dto = new UserDTO();
	dto.setId(id); dto.setName(name); dto.setPassword(psw);
	int count = dao.insert(dto);
	if(count < 1){ 
		out.print("회원가입중에 알수 없는 에러가 발생했습니다.");
		return;
	}
	
	response.sendRedirect("index.html");
	
%>
</body>
</html>