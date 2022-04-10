package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost  loginServlet..............");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Boolean ischecked = false;
		if(request.getParameter("idcheck") != null)
			ischecked =  request.getParameter("idcheck").equals("on")? true : false;
		
		// DB를 조회해서.. 해당 회원이 있는지 여부
		// 나중에 연결한다고 하고.. id : admin  password 1234
		// 로그인화면으로 돌아갈때 회원정보가 없어도 화면에 login했던 아이디를 표시하기위해 값을 셋팅
		HttpSession session =  request.getSession();
		request.setAttribute("id", id);
		if(id.equals("admin") && password.equals("1234")) {
			// 다음에 로그인할때 아이디를 저장(checkbox가 true)
			if(ischecked) {
				Cookie cookie = new Cookie("cookieLoginId", id);
				response.addCookie(cookie);
			}
			else {
				Cookie cookie = new Cookie("cookieLoginId", id);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}		
				
			// 회원 인증 관련 정보를 session에 저장한다.
			session.setAttribute("sessionid", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("memberDetail.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error", "회원정보가 없습니다. 회원가입 또는 회원정보를 확인해 주세요");
			System.out.println(request.getAttribute("id"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
