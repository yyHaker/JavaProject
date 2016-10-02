package cn.yy.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.yy.web.dao.Dao;
import cn.yy.web.domain.Province;

public class ProvinceServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        /**
         * 1.通过Dao获得所有省
         * 2.将List<Province>转换成json
         * 3.发送给客户端
         */
	   Dao dao=new Dao();
	   List<Province> provinceList=dao.findAllProvince();
	   String provinceJson=JSONArray.fromObject(provinceList).toString();
	   response.getWriter().println(provinceJson);
	}

}
