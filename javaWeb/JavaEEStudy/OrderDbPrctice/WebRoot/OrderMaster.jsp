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
    
    <title>OrderMaster.jsp</title>
    
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
       <a  href="<c:url value='/OrderMasterServlet?method=findAll'></c:url>">显示所有订单</a><br><br>
       
         <br>
         <br>
        <form action="<c:url value='/OrderMasterServlet?method=findOrderMasterByParams'></c:url>" method="post">
	                   订单编号<input type="text" id="orderNo" name="orderNo"><br><br>
	                    客户编号<input type="text" id="customerNo" name="customerNo"><br><br>
	                    员工编号<input type="text" id="employeeNo" name="employeeNo"><br><br>
	                    订单日期<input type="text" id="orderDate" name="orderDate"><br><br>
	                    订单金额<input type="text" id="orderSum" name="orderSum"><br><br>
	                    发票号码<input type="text" id="invoiceNo" name="invoiceNo"><br><br>          
	         <input type="submit" id="submit" name="submit" value="查询">
        </form>
          <br>
             <form action="<c:url value='/OrderMasterServlet?method=deleteOrderNo'></c:url>" method="post">
	                    订单编号<input type="text" id="orderNo" name="orderNo"><br><br>          
	         <input type="submit" id="submit" name="submit" value="删除订单">
        </form>
          <br>
               <form action="<c:url value='/OrderMasterServlet?method=addOrder'></c:url>" method="post">
			                    商品名称<input type="text" id="productName" name="productName"><br>          
			                    商品数量<input type="text" id="quantity" name="quantity"><br>          
			                    顾客编号<input type="text" id="customerNo_1" name="customerNo_1"><br>          
			                    员工编号<input type="text" id="employeeNo" name="employeeNo"><br>          
	         <input type="submit" id="submit" name="submit" value="增加订单">
              </form>
          <br>
          <a  href="<c:url value='/Main.jsp'></c:url>">返回主页</a><br>  
     </div>
     <div id="right">
			            <h1 align="center">OrderMaster</h1>
			    <table border="1" width="70%" align="center" id="table" cellspacing="0">
				<tr>
					<th>订单编号</th>
					<th>客户号</th>
					<th>业务员编号</th>
					<th>订单日期</th>
					<th>订单金额</th>
					<th>发票号码</th>
					
				</tr>
				
			<c:forEach items="${requestScope.ordermasterlist}" var="OrderMaster">
				<tr>
					<td class="alt">${OrderMaster.orderNo }</td>
					<td class="alt">${OrderMaster.customerNo }</td>
					<td class="alt">${OrderMaster.employeeNo }</td>
					<td class="alt">${OrderMaster.orderDate }</td>
					<td class="alt">${OrderMaster.orderSum }</td>
					<td class="alt">${OrderMaster.invoiceNo }</td>
						
				</tr>
			</c:forEach>
			</table>
     </div>
  </body>
</html>