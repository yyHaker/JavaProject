<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script type="text/javascript">
     function change(){
         /**
         *1.得到img元素
         *2.修改其src为/0502jsp/VerifyCodeServlet
         */
         var imgEle=document.getElementById("img");
         imgEle.src="/0502jsp/VerifySevlet?a="+new Date().getTime();
     }
     </script>
  </head>
  
  <body>
  <!-- 页面提供登陆表单，还提供登录信息 -->
    <h1>登陆</h1>
     <%
     /**
     *读取cookie,获得uname
     * 把cookie中的用户名显示到文本框
     */
     String uname="";
      Cookie []cookies=request.getCookies();//获取请求中所有cookie
      if(cookies!=null)
      {
     
        for(Cookie c:cookies){
             if("uname".equals(c.getName())){
              //查找名为uname的cokie
                 uname=c.getValue();
             }
        }
      }
      
      %>
    <%
      String message="";
      String msg=(String)request.getAttribute("msg");
      if(msg!=null)
      {
        message=msg;
      }
     %>
    <font color="red"><b><%=message %></b></font>
     <form action="/0502jsp/LoginServlet" method="post">
            用户名:<input type="text" name="username" value="<%=uname %>"><br>
             密    码:<input type="text" name="password"><br>
             验证码:<input type="text" name="VertifyCode" size="3">
             <img id="img" src="/0502jsp/VerifySevlet">
             <a href="javascript:change()">换一张</a><br>
       <input type="submit" value="登录">        
     </form>
   
  </body>
</html>
