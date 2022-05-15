<%@page import="dao.FeedDAO"%>
<%@page import="common.FileUtil"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 화면에서 json 형태로 데이터 읽어옮
	// 화면에서는 일반데이터와 file 정보를 가지고 있는 데이터가 넘어온다
	// file정보를 읽어서 파일 업로드 한다
	// 일반 데이터는 DAO에 전달해서 DB 업데이트를 하도록한다
	request.setCharacterEncoding("utf-8");
	String jsonstr = null, ufname = null;
	byte[]ufile = null;
	ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
	List<FileItem> items =  sfu.parseRequest(request);
	// java.lang 에 있는 Iterator가 아님
	// java.util.Iterator 임
	Iterator iter =  items.iterator();
	while(iter.hasNext()){
		FileItem item = (FileItem)iter.next();
		String name = item.getFieldName();
		if(item.isFormField()){
			String value = item.getString("utf-8");
			if(name.equals("jsonstr")) jsonstr = value;
		}else{
			if(name.equals("image")){
				ufname = item.getName();
				ufile = item.get();
				String root = application.getRealPath(File.separator);
				FileUtil.saveImage(root, ufname, ufile);
			}
		}
	}
	
	FeedDAO dao = new FeedDAO();
	if(dao.insert(jsonstr)) 
		out.print("OK");
	else 
		out.print("ER");
	
	
%>