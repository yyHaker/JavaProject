package cn.yy.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * 从application中获取Map
 * 从request中得到当前客户端的IP
 * 进行统计工作，结果保存到Map中
 * @author 57217
 *
 */
@WebFilter("/a.jsp")
public class Afilter implements Filter {
  private FilterConfig config;
    public Afilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1. 得到application中的map
		 * 2. 从request中获取当前客户端的ip地址
		 * 3. 查看map中是否存在这个ip对应访问次数，如果存在，把次数+1再保存回去
		 * 4. 如果不存在这个ip，那么说明是第一次访问本站，设置访问次数为1
		 */
		System.out.println("拦截");
		ServletContext app=config.getServletContext();
		Map<String,Integer> map=(Map<String, Integer>)app.getAttribute("map");
		
		String ip=request.getRemoteAddr();
		if(map.containsKey(ip))
		{
			int count=map.get(ip);
			map.put(ip, count+1);
			
		}
		else
		{
			map.put(ip,1);
		}
		app.setAttribute("map",map);
		chain.doFilter(request, response);//放行
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
	}

}
