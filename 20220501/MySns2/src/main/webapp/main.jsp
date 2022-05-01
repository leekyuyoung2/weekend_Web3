<%@page import="dto.FeedDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.FeedDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("login.html");
	}
	FeedDAO dao = new FeedDAO();
	List<FeedDTO> lists =  dao.getAllFeed();
	String str = "<table align=center>";
    str += "<tr height=40><td><b>작성글 리스트</b></td>";
    str += "<td align=right>";
    str += "<a href='feedAdd.html'><button>글쓰기</button></a>"; 
    str += "</td></tr>";
    
    for (FeedDTO feed : lists) {
        String img = feed.getImages(), imgstr = "";
        if (img != null) {
            imgstr = "<img src='images/" + img + "' width=240>";
        }    	
        str += "<tr><td colspan=2><hr></td></tr>";
        str += "<tr>";
    	str += "<td><small>" + feed.getId() + "</small></td>";
    	str += "<td><small>&nbsp;(" + feed.getTs() + ")</small></td>";
        str += "</tr>";
    	str += "<tr><td colspan=2>" + imgstr + "</td></tr>";
    	str += "<tr><td colspan=2>" + feed.getContent() + "</td></tr>";
    }
    str += "</table>";
    out.print(str); 
%>