package cn.yy.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.yy.web.dao.Dao;
import cn.yy.web.domain.City;

public class CityServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
    
	     /**
	      * 1.获取名为proPid的参数
	      * 2.使用这个pid名称查询数据库，得到List<City>
	      * 3.转换成json
	      * 4.发送给客户端 
	      */
        int  proPid=Integer.parseInt( request.getParameter("proPid")) ;
		Dao dao=new Dao();
		List<City> cityList=dao.findCityByProvincePid(proPid);
		String cityJson=JSONArray.fromObject(cityList).toString();
		response.getWriter().println(cityJson);
	}

}
