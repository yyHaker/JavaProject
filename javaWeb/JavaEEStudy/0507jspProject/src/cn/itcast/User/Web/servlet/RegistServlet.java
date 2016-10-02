package cn.itcast.User.Web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.User.Service.UserException;
import cn.itcast.User.Service.UserService;
import cn.itcast.User.domain.User;
import cn.itcast.commons.CommonUtils;

public class RegistServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			//依赖userService
			UserService userservice=new UserService();
		  /**
		   * 1.封装表单数据（封装到user对象中）
		   */
		User form=CommonUtils.toBean(request.getParameterMap(),User.class);
		/**
		 * 添加新任务（表单校验）
		 * 1.创建一个map,用来装载所有的错误信息
		 *    在校验过程中,如果失败,向map中添加信息，其中key为表单字段名称
		 * 2.校验之后，查看map的长度是否大于0，如果大于0，即说明有错误信息，有错误 
		 *    保存map到request中，保存form到request中，转发到regist.jsp
		 *  3.如果map为空,说明没有错误信息,向下执行
		 *  
		 */
	     Map<String,String> errors=new HashMap<String,String>();
	     //对用户名进行校验
	     String username=form.getUsername();//获得表单的username
	     if(username==null||username.trim().isEmpty()){
	    	 errors.put("username","用户名不能为空");
	    	 
	     }else if (username.length()<3||username.length()>15) {
			errors.put("username","用户名长度必须在3-15之间");	
		}
	     //对密码进行校验
	     String password=form.getPassword();//获得表单的username
	     if(password==null||password.trim().isEmpty()){
	    	 errors.put("password","用户名不能为空");
	    	 
	     }else if (password.length()<3||password.length()>15) {
			errors.put("password","密码长度必须在3-15之间");	
		}
	     
	     //对验证码进行校验
	     String sessionVerifyCode=(String) request.getSession().getAttribute("session_vcode");
	     String VerifyCode=form.getVerifyCode();
//	     System.out.println(VerifyCode);该处Verifycode为空
//	     if (!sessionVerifyCode.equalsIgnoreCase(VerifyCode)) {
//	    	 errors.put("VerifyCode","验证码错误");
//		}
	     if(VerifyCode==null||VerifyCode.trim().isEmpty()){
	    	 errors.put("verifyCode","验证码不能为空");
	    	 
	     }else if (VerifyCode.length()!=4) {
			errors.put("verifyCode","验证码长度必须为4");	
		 }else if(!sessionVerifyCode.equalsIgnoreCase(VerifyCode)){
			 errors.put("verifyCode","验证码错误");
		 }
	     /**
	      * 判断map是否为空
	      */
	     if (errors!=null&&errors.size()>0) {
			/**
			 * 1.保存errors到request域
			 * 2.保存form到requst域,为了回显
			 * 3.转发到request.jsp
			 */
	    	 request.setAttribute("errors",errors);
	    	 request.setAttribute("user",form);
	    	 request.getRequestDispatcher("/User/regist.jsp").forward(request, response);
	    	 return;//不再往下执行
		}
		/**
		 * 新添加功能：校验验证码
		 * 1.用户填写的验证码已经封装到user中
		 * 2.从session中获得真正的验证码
		 * 3.比较两者,如果不同，保存用户信息，保存表单数据，转发到regist.jsp
		 * 4.如果相同，什么都不做，向下执行
		 * 
		 */
//		String sessionVerifyCode=(String) request.getSession().getAttribute("session_vcode");
//		if (!sessionVerifyCode.equalsIgnoreCase(form.getVerifyCode())) {
//			request.setAttribute("msg","验证码错误");
//			request.setAttribute("user",form);
//			request.getRequestDispatcher("/User/regist.jsp").forward(request, response);
//			return;
//			}
		
		/**
		 * 2.调用userService的regist方法,传递form过去
		 * 3.若遇到异常，获取异常信息,保存到request域，转发到regist.jsp
		 * 4.没有异常,输出注册成功
		 */
		try {
			userservice.regist(form);
			response.getWriter().print("<h1>注册成功</h1>"
					+ "<a href='" +request.getContextPath()
					+"/User/Login.jsp"+"'>点击这里去登陆</a>");
		} catch (UserException e) {
			// 获取异常信息,保存到request域
			request.setAttribute("msg",e.getMessage());
			//用来在页面回显示
			request.setAttribute("user",form);
			//转发到regist.jsp
		    request.getRequestDispatcher("/User/regist.jsp").forward(request, response);
		}
	}

}
