<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'js1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 演示javascript实现异步式刷新 -->
<script type="text/javascript">
   window.onload=function(){//在文档加载完成后马上执行、
    //得到btn元素
    var btn=document.getElementById("btn");
    //给btn注册监听事件
    btn.onclick=function(){//在按钮点击时执行
     var h1=document.getElementById("h1");
     h1.innerHTML="hello Ajax!";
      
    }
    
   
   }
   
</script>
  </head>
  
  <body>
    <button id="btn">点击我</button>
    <h1 id="h1"></h1>
  </body>
</html>
