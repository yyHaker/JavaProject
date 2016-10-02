package cn.yy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bfilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("B过滤器出生了");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//注意此处的执行顺序
				System.out.println("Bfilter拦截你");
//		          chain.doFilter(request, response);//放行
		          System.out.println("Bfilter end");

	}

	@Override
	public void destroy() {
		
		System.out.println("B过滤器要死了");
	}

}
