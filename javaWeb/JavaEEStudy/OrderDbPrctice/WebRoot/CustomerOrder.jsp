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
    
    <title>My JSP 'CustomerOrder.jsp' starting page</title>
    
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
    }


</style>
  </head>
  
  <body>
       <div id="top">
         <h1 align="center">Customer Order System</h1>
     </div>
     <div id="left" >
         
        
                    
                <h3 align="center">查询客户订单</h3><br><br>
                      
               <form action="<c:url value='/CustomerOrderServlet?method=searchCustomerOrderInfor'></c:url>" method="post">
				                客户编号<input type="text" id="customerNo" name="customerNo"><br><br>
				                客户姓名<input type="text" id="customerName" name="customerName"><br><br>
				                产品名称<input type="text" id="productName" name="productName"><br><br>
	               <input type="submit" id="submit" name="submit" value="查询">
               </form>  
                 <br>
               <a  href="<c:url value='/Main.jsp'></c:url>">返回主页</a><br>  
         </div> 
      <div id="right">
		      <h1 align="center">CustomerOrder</h1>
			    <table border="1" width="70%" align="center" cellspacing="0">
				<tr>
					<th>客户编号</th>
					<th>客户姓名</th>
					<th>订单编号</th>
					<th>订单日期</th>
					<th>订单金额</th>
					<th>订单价格</th>
					<th>订单数量</th>
					<th>产品编号</th>
					<th>产品名称</th>
					
				</tr>
				
			<c:forEach items="${requestScope.customerOrderList}" var="CustomerOrder">
				<tr>
					<td class="alt">${CustomerOrder.customerNo }</td>
					<td class="alt">${CustomerOrder.customerName }</td>
					<td class="alt">${CustomerOrder.orderNo }</td>
					<td class="alt">${CustomerOrder.orderDate }</td>
					<td class="alt">${CustomerOrder.orderSum }</td>
					<td class="alt">${CustomerOrder.price }</td>
					<td class="alt">${CustomerOrder.quantity }</td>
					<td class="alt">${CustomerOrder.productNo }</td>
					<td class="alt">${CustomerOrder.productName }</td>
					
						
				</tr>
			</c:forEach>
			</table>	            
      </div>
  </body>
</html>
