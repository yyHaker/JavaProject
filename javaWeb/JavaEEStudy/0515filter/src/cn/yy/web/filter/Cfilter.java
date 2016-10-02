package cn.yy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Cfilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("C过滤器出生");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * 多过滤器的执行顺序
         *FilterChain#doFilter()方法： 执行目标资源，或是执行下一个过滤器！
         * 如果没有下一个过滤器那么执行的是目标资源，如果有，那么就执行下一个过滤器！
         */                   
		
		//注意此处的执行顺序
		System.out.println("Cfilter拦截你");
          chain.doFilter(request, response);//放行
          System.out.println("Cfilter end");

	}

	@Override
	public void destroy() {
		System.out.println("C过滤器要死了");

	}

}
