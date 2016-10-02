package cn.yy.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.CommonDataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		/*
		 * 上传三步
		 * 1. 得到工厂
		 * 2. 通过工厂创建解析器
		 * 3. 解析request，得到FileItem集合
		 * 4. 遍历FileItem集合，调用其API完成文件的保存
		 */
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList=sfu.parseRequest(request);
			FileItem file1=fileItemList.get(0);
			FileItem file2=fileItemList.get(1);
			
			System.out.println("普通表单项演示"+file1.getFieldName()+"="
			     +file1.getString("utf-8"));
			System.out.println("文件表单项演示:");
			System.out.println("Content-type"+" " +file2.getContentType());
			System.out.println("size"+"="+file2.getSize()+"byte");
			System.out.println("filename"+" " +file2.getName());
			
			//保存文件
			File destfile=new File("E:/riven.jpg");
			try {
				file2.write(destfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

}
