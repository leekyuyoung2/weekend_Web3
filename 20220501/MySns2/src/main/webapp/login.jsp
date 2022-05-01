<%@page import="dao.UserDAO"%>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserDAO dao = new UserDAO();
	int code =  dao.login(id, password);
	if(code == 1){		
		out.print("NA");
	}else if(code == 2){		
		out.print("PS");
	}else 
	{
		session.setAttribute("id", id);		
		out.print("OK");
	}
	System.out.println(code + " ---------------------");
%>