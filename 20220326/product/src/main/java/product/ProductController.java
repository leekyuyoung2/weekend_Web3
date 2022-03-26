package product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontroller")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
    /**
     * Default constructor. 
     */
    public ProductController() {
        // TODO Auto-generated constructor stub
    	service = new ProductService();
    }

    
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =  request.getParameter("action");  
		String view = "";  
		if(action == null) {
			getServletContext()
			.getRequestDispatcher("/pcontroller?action=list")
			.forward(request, response);
		}else {
			switch(action) {
			case "list":
				view = list(request,response);
				break;
			case "info":
				view = info(request, response);
				break;
			}
			getServletContext()
			.getRequestDispatcher(view)
			.forward(request, response);
		}
		
	}
	
	



	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("info", service.find(request.getParameter("id")));
		return "/productInfo.jsp";
	}



	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", service.findAll());
		return "/productList.jsp";
	}
	



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
