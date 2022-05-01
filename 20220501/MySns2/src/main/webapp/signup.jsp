<%@page import="java.io.File"%>
<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String psw = request.getParameter("ps");
	String confirmpsw = request.getParameter("ps2");
	String name = request.getParameter("name");	
	
	UserDAO dao = new UserDAO();
	// errroCode : 0 성공  1: 사용할수 없는 아이디 입니다.  2: 패스워드확인 실패
	
	int errorCode = 0;
	if(dao.findByUserId(id)) out.print("NA");
	//if(!psw.equals(confirmpsw)) out.print("NA");  //화면에서에러처리		
	
	UserDTO dto = new UserDTO();
	dto.setId(id); dto.setName(name); dto.setPassword(psw);
	int count = dao.insert(dto);
	if(count < 1) out.print("ER");
%>