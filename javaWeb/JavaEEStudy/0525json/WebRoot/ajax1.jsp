<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<c:url value='/ajax-lib/ajaxutils.js'/>"></script>
<script type="text/javascript">
    window.onload=function(){
          
           ajax(
                  {
                     url:"<c:url value='/ProvinceServlet'/>",
                     type:"json",
                     callback:function(data){
                         //执行服务器传来的json字符串，得到js对象
                         for(var i=0;i<data.length;i++){
                              //得到每个pro对象
                             var pro=data[i];
                            //创建option元素
                            var optionEle=document.createElement("option");
                            //给option元素的value属性赋值
                            optionEle.value=pro.pid;
                            //使用省名称创建textnode
                            var textNode=document.createTextNode(pro.name);
                            //把textNode添加到option元素中
                            optionEle.appendChild(textNode);
                            //把option元素添加到select元素中
                            document.getElementById("p").appendChild(optionEle);   
                         }
                     }
                  }
               );
      //给<select  id="p">注册onchange监听
    document.getElementById("p").onchange=function(){
          //异步请求服务器，得到选择的省下所有市
          ajax(
               {
                method:"POST",
                url:"<c:url value='/CityServlet'/>",
                type:"json",
                params:"proPid="+this.value,
                callback:function(data){
                    //1.清空原来option元素
                    //2.得到服务器发送过来的所有市
                    //3.使用每个市生成的option元素添加到<select id="c"/>当中
                    var citySelect=document.getElementById("c");
                    var cityOptionArray=citySelect.getElementsByTagName("option");
                    while(cityOptionArray.length>1){
                       citySelect.removeChild(cityOptionArray[1]); 
                    }
                   
                   //循环遍历每个city对象，用来生成option元素，添加到<select id="c"/>当中
                    for(var i=0;i<data.length;i++){
                              //得到每个pro对象
                             var pro=data[i];
                            //创建option元素
                            var optionEle=document.createElement("option");
                            //给option元素的value属性赋值
                            optionEle.value=pro.pid;
                            //使用省名称创建textnode
                            var textNode=document.createTextNode(pro.name);
                            //把textNode添加到option元素中
                            optionEle.appendChild(textNode);
                            //把option元素添加到select元素中
                            document.getElementById("c").appendChild(optionEle);   
                         }
                   }
                }
          
              );
      }
           
    }
</script>
  </head>
  
  <body>
    <h1>省市联动</h1>
<select name="province" id="p">
  <option>===请选择省===</option>
</select> 
　　　
<select name="city" id="c">
  <option>===请选择市===</option>
</select>
  </body>
</html>
