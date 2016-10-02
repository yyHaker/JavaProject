package cn.yy.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Savepoint;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

public class UploadServlet3 extends HttpServlet {

	
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
		//设置单个文件上传最大为100k
		sfu.setFileSizeMax(100*1024);
		//限制整个表单大小为5M
		sfu.setSizeMax(5*1024*1024);
		try {
			List<FileItem> list=sfu.parseRequest(request);
			FileItem file1=list.get(1);
			/**
			 * 1.得到文件的保存路径
			 */
			String root =this.getServletContext().getRealPath("/WEB-INF/files/");
			/**
			 * 2.生成2层目录
			 *  1）.得到文件名称
			 *  2）.得到Hashcode
			 *  3).转成16进制
			 *  4）.获取前两个字符
			 */
			String filename=file1.getName();
			//处理文件名的绝对路径问题
			int index=filename.lastIndexOf("\\");
			if(index!=-1){
				filename=filename.substring(index+1);
			}
			//处理同名问题,给文件名添加uuid，
			
			String savename=CommonUtils.uuid()+"_"+filename;
			//得到Hashcode
			 int hcode=filename.hashCode();
			 String hex=Integer.toHexString(hcode);
			 /**
			  * 2.获取hex的两个字符,与root连接在一起，生成一个完整的路径
			  */
			File dirfile=new File(root,hex.charAt(0)+"/"+hex.charAt(1));
			//创建一个目录链
			dirfile.mkdirs();
			//创建目录文件
			File  destfile=new File(dirfile,savename);
			//保存文件
			file1.write(destfile);
		} catch (FileUploadException e) {
			if(e instanceof  FileUploadBase.FileSizeLimitExceededException){
				request.setAttribute("msg","您上传的文件超过100k!");
				request.getRequestDispatcher("/form3.jsp").forward(request, response);
			}
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
