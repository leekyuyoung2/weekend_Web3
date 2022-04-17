<%@page import="util.FileUtil"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
<!--
	파일 컨텐츠 저장
	웹 서버가 구동되는 루트 디렉토리를 기준으로 파일이 저장
	루트 디렉토리 경로는 application.getRealPath() 함수를 통해 알수 있음  
-->
<%
	ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
	List<FileItem> items =  sfu.parseRequest(request);
	Iterator iter =  items.iterator();
	byte[] data = null;
	String uid=null,ucon=null,fname=null;
	while(iter.hasNext()){
		FileItem item =  (FileItem)iter.next();
		String name = item.getFieldName();
		if(item.isFormField()){
			String value = item.getString("UTF-8");
			if(name.equals("id")) uid = value;
			else if(name.equals("content")) ucon=value;
		}else{
			if(name.equals("image")){
				fname = item.getName();
				data = item.get();
				String root = application.getRealPath(File.separator);
				FileUtil.saveImage(root, fname, data);
			}
		}
	}
	FeedDAO dao = new FeedDAO();
	if(dao.insert(uid, ucon, fname)){
		response.sendRedirect("main.jsp");
	}
	else{
		out.print("작성글의 업로드중 오류가 발생했습니다.");
	}
	out.print(uid+"<br>");
	out.print(ucon+"<br>");
	out.print(fname+"<br>");
	out.print(data+"<br>");
	out.print("루트디렉터리 "+application.getRealPath(File.separator));
	/* request.setCharacterEncoding("utf-8");
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
	out.print(str); */
	
	
	/* FeedDAO dao = new FeedDAO();
	if(dao.insert(uid, ucont))
		out.print("작성하신 글이 업로드 되었습니다.");
	else
		out.print("업로드중에 오류가 발생하였습니다."); */
		
%>
</body>
</html>