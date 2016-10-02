<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'json1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}
   window.onload=function(){
      var btn=document.getElementById("btn");
      btn.onclick=function(){
          //使用ajax得到服务器的响应，将结果显示到h1中
          //1.得到request
          var xmlHttp=createXMLHttpRequest();
          //2.连接
          xmlHttp.open("GET","<c:url value='/Aservlet'/>",true);
          //3.发送
          xmlHttp.send(null);
          //4.给xmlHttp的状态事件注册监听
          xmlHttp.onreadystatechange=function(){
             if(xmlHttp.readyState==4&&xmlHttp.status==200){
                var text =xmlHttp.responseText;
                var person=eval("("+text+")");
                var s=person.name+","+person.age+","+person.sex;
                document.getElementById("h1").innerHTML=s;
                alert(s);
             }
          }
      }
   }
</script>
  </head>
  
  <body>
    <h1>json hello !</h1>
    <button id="btn">点击我</button>
     <h1 id="h1"></h1>
  </body>
</html>
