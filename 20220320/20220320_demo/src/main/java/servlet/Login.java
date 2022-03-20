package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 사용자 아이디와 페스워드에 대한 세션 값을 설정
		HttpSession session =  request.getSession();
		String id =  (String)request.getParameter("id");
		String password =  (String)request.getParameter("password");
		// admin/admin1234 회원인증
		if(id.equals("admin") && password.equals("admin1234")) {
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			session.setMaxInactiveInterval(60*30); // 30분 셋팅
			response.sendRedirect("success.html");
		}else {
			response.sendRedirect("fail.html");
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
