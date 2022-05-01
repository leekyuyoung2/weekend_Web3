<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String psw = request.getParameter("password");

	UserDAO dao = new UserDAO();
	System.out.println(id);
	UserDTO dto =  dao.getUserById(id);
	
	if (dto == null) out.print("NA");
	else if (!psw.equals(dto.getPassword())) out.print("PSWNA");
	else if(dao.deleteById(id) < 1)	out.print("ER");
	else {
		session.removeAttribute("id");
		out.print("OK");	
	}
	
%>
