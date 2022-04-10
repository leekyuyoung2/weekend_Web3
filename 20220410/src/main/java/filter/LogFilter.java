package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName = "LogFilter")
public class LogFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LogFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest)request;
			currentPath = req.getContextPath();
			queryString = req.getQueryString();
			queryString = queryString == null? currentPath : "?" + queryString;
		}
		return queryString;
	}
	
	private String getCurrentTime() {
		DateFormat formmater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formmater.format(calendar.getTime());
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		long start = System.currentTimeMillis();
		System.out.println("접속한 클라이언트 IP :" + request.getRemoteAddr());
		System.out.println("접근한 URL 경로 : "+getURLPath(request));
		System.out.println("요청 처리 시작 시간 "+getCurrentTime());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println("요청 종료 시간 "+getCurrentTime());
		System.out.println("요청 처리 소요 시간 "+(end-start)+"ms");
		System.out.println("======================================================");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
