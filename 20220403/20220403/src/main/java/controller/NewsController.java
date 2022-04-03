package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;
import model.NewsDAO;

/**
 * Servlet implementation class NewsController
 * @WebServlet --> 요청경로에 따라서 호출되는 주소 소문자만 인식
 */
@WebServlet("/news")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewsDAO dao;
	private final String START_PAGE = "newsList.jsp";
	private ServletContext ctx;
	
	// 초기화 메서드는 한번만 호출된다.
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	dao = new NewsDAO();
    	ctx = getServletContext();
	}

    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Method m; // java reflection   if(switch)없이 요청에따라 구현 메서드가 실행되도록 
		String view = null;
		if(action == null)
			action = "listNews";
		
		try {
			// localhost:8080/20220403/news?action=addnews
			// 현재 클래스에서 action이름과 HttpServletRequest를 파라메터러 하는 메서드를 찾는
			m = this.getClass().getMethod(action,HttpServletRequest.class);
			// 메서드를 실행 후 리턴값을 받아옴
			view = (String)m.invoke(this, request);
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
			ctx.log("요청 action 없음");
			request.setAttribute("error", "action 파라메터가 잘못되었습니다.");
			view = START_PAGE;
		}catch(Exception e) {
			e.printStackTrace();
		}
		// form에서 post 요청을 할때 forward 방식을 이용해서 등록후 다시 리스트를 보여주는 과정에서
		// 새로고침을 하면 다시 등록되는 현상이 발생
		if(view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());  // redirect:/ 이후 경로만 가져옴
			response.sendRedirect(rview);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	public String addNews(HttpServletRequest request) {
		News n = new News();
		try {
			// 이미지 파일 저장
			n.setTitle(request.getParameter("title"));
			n.setContent(request.getParameter("content"));
			
			String fileName = "test.png";
			n.setImg("./img/"+fileName);
			dao.addNews(n);
		}catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 추가과정에서 문제 발생");
			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다.");
			return listNews(request);
		}
		return "redirect:/news?action=listNews";
	}
	
	public String listNews(HttpServletRequest request) {
		List<News> lists = null;
		try {
			lists = dao.getAll();
			request.setAttribute("newslist", lists);
		}catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 목록 생성 과정에서 문제 발생!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다.");
		}
		return "newsList.jsp";
	}
	public String getNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			News n = dao.getNews(aid);
			request.setAttribute("news", n);
		}catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다.");
		}
		return "newsView.jsp";
	}
	
	public String deleteNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제과정에서 문제 발생");
			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다.");
			return listNews(request);
		}
		return "rediect:/news?action=listNews";
	}
	

}
