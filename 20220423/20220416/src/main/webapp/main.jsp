<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dto.FeedDTO"%>
<%@page import="dao.FeedDAO"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 목록</title>
</head>
<body>
<%
	List<FeedDTO> lists = (new FeedDAO()).getList();
	String str = "<table align = center>";
	str += "<tr><th colspan = 2>작성글 리스트</th></tr>";
	for(FeedDTO dto : lists)
	{
		String images = dto.getImages(), imgstr = "";
		System.out.println(images);
		if(images!=null)
			imgstr = "<img src = 'images/"+images + "' width=240>";
		str += "<tr><td colspan=2><hr></td></tr>";
		str += "<tr>";
		str += "<td><samll>"+dto.getId() + "</small></td>";
		str += "<td><samll>&nbsp;("+dto.getTs() + ")</small></td>";
		str += "</tr>";
		str += "<tr><td colspan=2>"+imgstr+ "</td></tr>";
		str += "<tr><td colspan=2>"+dto.getContent() + "</td></tr>";
		System.out.println(str);
	}
	str += "</table>";
	out.print(str);		
	System.out.println("루트디렉터리 "+application.getRealPath(File.separator));
%>
</body>
</html>