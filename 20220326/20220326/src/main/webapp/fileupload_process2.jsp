<%@page import="org.apache.commons.io.FileExistsException"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
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
	String fileUploadPath = "c:/upload";
	DiskFileUpload upload =  new DiskFileUpload();
	List<FileItem> items =  upload.parseRequest(request);
	Iterator params =  items.iterator();
	while(params.hasNext()){
		FileItem fileitem = (FileItem)params.next();
		if(!fileitem.isFormField()){
			String fileName =  fileitem.getName();
			fileName = fileName.substring(fileName.lastIndexOf("/")+1);
			File file = new File(fileUploadPath+"/"+fileName);
			try{
				fileitem.write(file);
			}catch(FileExistsException e){
				String newFileName =  fileName.substring(fileName.lastIndexOf("."));
				String exeName = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
				newFileName = newFileName+"_01."+exeName;
				file = new File(fileUploadPath+"/"+newFileName);
				fileitem.write(file);
			}
		}
	}
	
	
	
%>
</body>
</html>