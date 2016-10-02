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
 * Servlet Filter implementation class usersFilter
 */
@WebFilter("/users/users.jsp")
public class usersFilter implements Filter {

    /**
     * Default constructor. 
     */
    public usersFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @throws IOException 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws  ServletException, IOException {
		// place your code here
          HttpServletRequest req=(HttpServletRequest) request;
          String username=(String)req.getSession().getAttribute("admin");
          if(username!=null){
        	  chain.doFilter(request, response);
        	  return;
          }
          
          String name=(String) req.getSession().getAttribute("user");
          if(name!=null){
        	  chain.doFilter(request, response);
          }else{
        	  req.setAttribute("msg","你什么都不是，无权登录");
        	  req.getRequestDispatcher("/Login.jsp").forward(request, response);
          }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
