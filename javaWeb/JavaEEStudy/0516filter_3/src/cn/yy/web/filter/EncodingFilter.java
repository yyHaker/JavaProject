package cn.yy.web.filter;

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
 * 注意:tomcat8默认get请求编码是utf-8;
 *               post请求编码是iso-
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
       
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest) request;
		
		//处理post请求编码问题
          request.setCharacterEncoding("utf-8");
          chain.doFilter(httprequest, response);
      /**
       * 调包request(装饰着模型)
       * 1.写一个reauest的装饰类
       * 2.在放行时，使用我们自己的request
       */
          //若tomcat默认get请求方式不是utf-8采用以下处理
//          if(httprequest.getMethod().equals("GET")){
//        	  EncodingRequest er=new EncodingRequest(httprequest);
//              chain.doFilter(er, response);
//          }else if(httprequest.getMethod().equals("POST")){
//        	  chain.doFilter(request, response);
//          }
        
          
          
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
