package cn.yy.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 装饰类实现request的调包
 * @author 57217
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper {
       private HttpServletRequest req;
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req=request;
	}
	//重写getParameter方法
	@Override
	public String getParameter(String name) {
		String value=req.getParameter(name);
		//处理编码问题
		 try {
			value=new String(value.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
}
