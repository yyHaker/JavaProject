package cn.yy.web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class adminFilter
 */
@WebFilter("/admin/admin.jsp")
public class adminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public adminFilter() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
         HttpServletRequest req=(HttpServletRequest)request;
         String name=(String)req.getSession().getAttribute("admin");
         if(name!=null){
        	 chain.doFilter(request, response);
         }else{
        	 req.setAttribute("msg","你不是管理员，无权登录");
        	 req.getRequestDispatcher("/Login.jsp").forward(request, response);
         }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
