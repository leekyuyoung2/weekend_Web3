package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 =  Integer.valueOf( request.getParameter("n1") );
		int n2 =  Integer.valueOf( request.getParameter("n2") );
		String op =  request.getParameter("operation");
		long result = 0;
		switch (op) {
		case "+": result = n1 + n2;	break;
		case "-": result = n1 - n2;	break;
		case "x": result = n1 * n2;	break;
		case "/": result = n1 / n2;	break;
		default:
			break;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		out.append("<html><body><h2>계산기 서블릿</h2>")
		.append("계산 결과 : " +result+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
