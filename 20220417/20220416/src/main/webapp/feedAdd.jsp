<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
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
	out.print("id =" + uid+"<br><hr>");
	out.print("content =" + ucont+"<br><hr>");
	out.print("conten type =" + request.getContentType()+"<br><hr>");
	out.print("conten length =" + request.getContentLength()+"<br><hr>");
	InputStreamReader isr = new InputStreamReader(request.getInputStream(),"UTF-8");
	BufferedReader br = new BufferedReader(isr);
	String str = "";
	String line = "";
	while( (line = br.readLine()) !=null ){
		str += line+"<br>";
	}
	out.print(str);
	
	
	/* FeedDAO dao = new FeedDAO();
	if(dao.insert(uid, ucont))
		out.print("작성하신 글이 업로드 되었습니다.");
	else
		out.print("업로드중에 오류가 발생하였습니다."); */
		
%>
</body>
</html>