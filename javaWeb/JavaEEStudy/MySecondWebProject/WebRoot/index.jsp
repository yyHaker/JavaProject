<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    Hello Jsp<br>
     您好！<br>
     <!-- 我是html格式，在客户端可见 -->
     <%--我是JSP格式，在客户端不可见 --%>
       <%!
           String s="张三";    
           int add(int x,int y)
          {
           return x+y;
          }
       
        %>
     <%
       //单行注释
     /*
                         我是JSP脚本多行注释，在客户端不可见
     */
        out.println("Welcom to study JavaEE!");
      %>
     <br>
       您好，<%=s %> <br>
       x+y=<%=add(10,6) %> <br>
  </body>
</html>
