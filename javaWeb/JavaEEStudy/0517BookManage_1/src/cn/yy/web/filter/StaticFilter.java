package cn.yy.web.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(servletNames = { "BookServlet" })
public class StaticFilter implements Filter {
       private FilterConfig fconfig;
       

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		/*
		 * 1. 第一次访问时，查找请求对应的html页面是否存在，如果存在重定向到html
		 * 2. 如果不存在，放行！把servlet访问数据库后，输出给客户端的数据保存到一个html文件中
		 *   再重定向到html
		 */
		/*
		 * 一、获取category参数！
		 * category有四种可能：
		 * * null --> null.html
		 * * 1 --> 1.html
		 * * 2 --> 2.html
		 * * 3 --> 3.html
		 * 
		 * html页面的保存路径, htmls目录下
		 * 
		 * 判断对应的html文件是否存在，如果存在，直接重定向！
		 */
		String category=request.getParameter("category");
		String htmlpage=category+".html";
		String htmlpath=fconfig.getServletContext().getRealPath("/htmls");
		File destfile=new File(htmlpath,htmlpage);
		if(destfile.exists()){
			//重定向到这个文件
			res.sendRedirect(req.getContextPath()+"/htmls/"+htmlpage);
			return ;
		}
		/**
		 * 如果html文件不存在，我们要生成html
		 * 1.掉包response,让他的getWriter()与一个html文件绑定
		 */
		StaticResponse sr=new StaticResponse(res,destfile.getAbsolutePath());
		chain.doFilter(req,sr);//放行
		res.sendRedirect(req.getContextPath()+"/htmls/"+htmlpage);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fconfig=fConfig;
	}

}
