<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <!-- 实现ajax用户名检验 
	    1:导入jQuery库
	 
	 -->
	<!--  <font color="red">该用户名已经存在</font> -->
      <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
      <script type="text/javascript">
          $(function(){
            alert("123");
              $(":input[name='username']").change(function(){
                 var username=$(this).val();
                 alert(username);
                 username=$.trim(username);
                 if(username!=""){
                    //准备发送ajax请求
                    var url="${pageContext.request.contextPath }/ValidateUsernameServlet";
                    var args={"username":username,"time":new Date()};
                    //发送请求
                    $.post(url,args,function(data){
                      $("#message").html(data);
                    });
                 }
                
              });
          })
      </script>
  </head>
  
  <body>
               用户名:<input type="text" id="username" name="username"> <label id="message"></label>
                  
        <br>
       <input type="submit" id="submit" value="提交">
  </body>
</html>
