package cn.yy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Afilter implements Filter {
     /**
      * 创建之后马上执行，用来初始化（服务器启动）
      */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("A过滤器出生了");

	}
     /**
      * 每次过滤都会执行
      */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//注意此处的执行顺序
		System.out.println("Afilter拦截你");
          chain.doFilter(request, response);//放行
          System.out.println("Afilter end");
	}
      /**
       * 销毁之前执行，用来对内存资源进行释放（服务器关闭）
       */
	@Override
	public void destroy() {
		System.out.println("A过滤器要死了");

	}

}
