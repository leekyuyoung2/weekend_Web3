
<%@page import="dto.FeedDTO"%>
<%@page import="dao.FeedDAO"%>
<%@page import="common.FileUtil"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());	
	List<FileItem> items =  sfu.parseRequest(request);
	Iterator iter =  items.iterator();
	String id=null ,content=null, fname = null;
	byte[] data = null;
	FeedDTO dto = new FeedDTO();
	while(iter.hasNext()){
		FileItem item =  (FileItem)iter.next();
		String name = item.getFieldName();
		if(item.isFormField()){
			String value =  item.getString("utf-8");
			if(name.equals("id")) dto.setId(value); //id = value;
			else if(name.equals("content")) dto.setContent(value);//content = value;
		}else{
			if(name.equals("image")){
				fname = item.getName();				
				dto.setImages(fname);
				data =  item.get();
				String root = application.getRealPath(File.separator);				
				FileUtil.saveImage(root, fname, data);
				System.out.println(root);
			}
		}		
	}
	FeedDAO dao = new FeedDAO();
	try{
		dao.insertFeed(dto);
		out.print("OK");
	}catch(Exception e){
		out.print("ER");
	}

%>