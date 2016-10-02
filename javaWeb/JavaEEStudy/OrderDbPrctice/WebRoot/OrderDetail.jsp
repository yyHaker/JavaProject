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
    
    <title>OrderDetail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
    #top{
        background: lightskyblue;
        height:80px;
        width: 100%;
    margin-bottom: 1px;
    }
    #left{
        background: pink;
        height:600px;
        width: 20%;
        float: left;
    }
    #right{
        background: papayawhip;
        width: 80%;
        height: 600px;
        float: right;
        font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;  
        color: #4f6b72;  
   
    }
    #right table{
        width:1000px;
    }
    #right th {  
    font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;  
    color: #4f6b72;  
    border-right: 1px solid #C1DAD7;  
    border-bottom: 1px solid #C1DAD7;  
    border-top: 1px solid #C1DAD7;  
    letter-spacing: 2px;  
    text-transform: uppercase;  
    text-align: left;  
    padding: 6px 6px 6px 12px;  
    background: #CAE8EA url(images/bg_header.jpg) no-repeat;  
      }  
    #right td {  
    border-right: 1px solid #C1DAD7;  
    border-bottom: 1px solid #C1DAD7;  
    background: #fff;  
    padding: 6px 6px 6px 12px;  
    color: #4f6b72;  
  }   
  #right td.alt {  
    background: #F5FAFA;  
    color: #797268;  
}  


</style>
  </head>
  
  <body>
   <div id="top">
         <h1 align="center">Customer Order System</h1>
     </div>
     <div id="left">
        <br>
       <a  href="<c:url value='/OrderDetailServlet?method=findAll'></c:url>">显示所有订单信息</a><br><br>
       
         <br>
         <br>
           <form action="<c:url value='/OrderDetailServlet?method=findOrderDetailByParams'></c:url>" method="post">
	                   订单编号<input type="text" id="orderNo" name="orderNo"><br><br>
	                    商品编号<input type="text" id="productNo" name="productNo"><br><br>
	                    销售数量<input type="text" id="quantity" name="quantity"><br><br>
	                    成交单价<input type="text" id="price" name="price"><br><br>        
	         <input type="submit" id="submit" name="submit" value="查询">
        
            </form>  
            <br>
          <a  href="<c:url value='/Main.jsp'></c:url>">返回主页</a><br>    
     </div>
     <div id="right">
			            <h1 align="center">OrderDetail</h1>
			    <table border="1" width="70%" align="center" cellspacing="0">
				<tr>
					<th>订单编号</th>
					<th>商品编号</th>
					<th>销售数量</th>
					<th>成交单价</th>
					
					
				</tr>
				
			<c:forEach items="${requestScope.orderdetaillist}" var="OrderDetail">
				<tr>
					<td class="alt">${OrderDetail.orderNo }</td>
					<td class="alt">${OrderDetail.productNo }</td>
					<td class="alt">${OrderDetail.quantity }</td>
					<td class="alt">${OrderDetail.price }</td>
						
				</tr>
			</c:forEach>
			</table>
     </div>
  </body>
</html>
