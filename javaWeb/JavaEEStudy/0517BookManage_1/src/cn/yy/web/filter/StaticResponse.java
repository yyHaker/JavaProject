package cn.yy.web.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper {
	private HttpServletResponse response;
	private PrintWriter pw;
	//path是html文件夹路径
    public StaticResponse(HttpServletResponse response,String path) {
		super(response);
		this.response=response;
		try {
			pw=new PrintWriter(path,"utf-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
    @Override
    public PrintWriter getWriter() throws IOException {
    	//返回一个与html绑定在一起的PrintWriter对象
    	
    	return pw;
    }
}
