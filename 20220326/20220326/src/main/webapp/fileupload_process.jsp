<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	// 5mb
	MultipartRequest multi =  
	new MultipartRequest(request, "c:/upload",1024*1024*5,"utf-8", 
			new DefaultFileRenamePolicy());
	// form 객체에 있는 파일을 제외한 일반 요청사항
	Enumeration params = multi.getParameterNames();
	while(params.hasMoreElements()){
		String name =  (String)params.nextElement();
		String value= multi.getParameter(name);
		String msg = String.format("name = %s  value = %s<br>", name, value);
		out.print(msg);
	}
	out.print("<hr>");
	// 파일 객체를 읽어오기
	Enumeration files =  multi.getFileNames();
	while(files.hasMoreElements()){
		String name =  (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String originname = multi.getOriginalFileName(name);
		String type =  multi.getContentType(name);
		File file = multi.getFile(name); // 파일 객체
		
		out.print("요청 파라메터 이름 : " + name + ",<br>");
		out.print("실제 파일 이름 : " + originname + ",<br>");
		out.print("저장 파일 이름 : " + filename + ",<br>");
		out.print("파일 컨텐츠유형 : " + type + ",<br>");
		if(file != null){
			out.print("파일 크기 : " + file.length()+"<br>");
		}
	}
	
	
%>
</body>
</html>