<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'succ1.jsp' starting page</title>
    
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
   <h1>succ1</h1>
     <%
      String username=(String)session.getAttribute("username");
      if(username==null)
      {
      /**
      *向request域中保存错误信息，转发到Login.jsp
      */
        request.setAttribute("msg", "您还没有登陆，请不要冒充领导!");
          request.getRequestDispatcher("/session/Login.jsp").forward(request, response);
          return;//下面语句不再执行
      }
     %>
   欢迎欢迎，热烈欢迎<%=username%>领导指导工作
  </body>
</html>
