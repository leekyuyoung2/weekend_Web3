package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;
import model.StudentDTO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/s")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDAO dao;   
    public StudentController() {
        super();
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new StudentDAO();
	}



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String view="";
		if(req.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/s?action=list")
			.forward(req, resp);
		}else {
			switch (action) {
			case "list":
				view = list(req,resp);
				break;
			case "insert":
				view = insert(req,resp);
				break;
			default:
				break;
			}
			getServletContext().getRequestDispatcher("/"+view).forward(req, resp);			
		}
	}



	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		StudentDTO student = new StudentDTO();
		student.setUSERNAME(req.getParameter("username"));
		// 2022.03.27
		SimpleDateFormat formmatter = new SimpleDateFormat("yyyy.MM.dd");
		try {
			Date d =  (Date) formmatter.parse(req.getParameter("birth"));
			
			student.setBIRTH(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setEMAIL(req.getParameter("email"));
		student.setUNIV(req.getParameter("univ"));
		
		dao.insert(student);
				
		return list(req, resp);
	}



	private String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("students", dao.getAll());
		return "studentlist.jsp";
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
