<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax1_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
     function CreateXmlHttpRequest(){
         try{
             return new XMLHttpRequest();
         }catch(e){
              try{
                 return  ActvieXObject("Msxml2.XMLHTTP");
              }catch(e){
                  try{
                      return ActvieXObject("Microsoft.XMLHTTP");
                  }catch(e){
                    alert("哥们儿，您用的是什么浏览器啊？");
				    throw e;
                  }
              }
         }
     }
      window.onload=function(){
        var btn=document.getElementById("btn");
        btn.onclick=function(){
         /*
		ajax四步操作，得到服务器的响应
		把响应结果显示到h1元素中
		*/
		  var xmlhttp=new CreateXmlHttpRequest();
		    xmlhttp.open("GET","<c:url value='/Aservlet'/>", true);
		    xmlhttp.send(null);
		    xmlhttp.onreadystatechange=function(){
		       if(xmlhttp.readyState==4&&xmlhttp.status==200){
		          var text=xmlhttp.responseText;
		          var h1=document.getElementById("h1");
		          h1.innerHTML=text;
		       }
		       
		    }
        }
      }
    </script>
  </head>
  
  <body>
    <button id="btn">点击我</button>
    <h1 id="h1"></h1>
  </body>
</html>
