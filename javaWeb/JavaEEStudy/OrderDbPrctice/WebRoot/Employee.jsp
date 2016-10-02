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
    
    <title>Employee</title>
    
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
        height:1000px;
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
         <h1 align="center">Customer Order   System</h1>
     </div>
     <div id="left">
        <br>
       <a  href="<c:url value='/EmployeeServlet?method=findAll'></c:url>">显示所有员工</a><br><br>
      
         <br>
         <br>
        <form action="<c:url value='/EmployeeServlet?method=findEmployeeByParams'></c:url>" method="post">
	                    员工编号<input type="text" id="employeeNo" name="employeeNo"><br>
	                    员工姓名<input type="text" id="employeeName" name="employeeName"><br>
	                    员工性别<input type="text" id="gender" name="gender"><br>
	                    出生日期<input type="text" id="birthday" name="birthday"><br>
	                    员工住址<input type="text" id="address" name="address"><br>
	                    员工电话<input type="text" id="telephone" name="telephone"><br>
	                    雇佣日期<input type="text" id="hireDate" name="hireDate"><br>
	                    所属部门<input type="text" id="department" name="department"><br>
	                    员工职务<input type="text" id="headShip" name="headShip"><br>
	                    员工薪水<input type="text" id="salary" name="salary"><br>
	         <input type="submit" id="submit" name="submit" value="查询">
        </form>
          <br>
           <form action="<c:url value='/EmployeeServlet?method=editEmployee'></c:url>" method="post">
	                   员工编号<input type="text" id="employeeNo" name="employeeNo"><br>
	                    员工姓名<input type="text" id="employeeName" name="employeeName"><br>
	                    员工性别<input type="text" id="gender" name="gender"><br>
	                    出生日期<input type="text" id="birthday" name="birthday"><br>
	                    员工住址<input type="text" id="address" name="address"><br>
	                    员工电话<input type="text" id="telephone" name="telephone"><br>
	                    雇佣日期<input type="text" id="hireDate" name="hireDate"><br>
	                    所属部门<input type="text" id="department" name="department"><br>
	                    员工职务<input type="text" id="headShip" name="headShip"><br>
	                    员工薪水<input type="text" id="salary" name="salary"><br>
	         <input type="submit" id="submit" name="submit" value="编辑">
        </form>
         <br>
          <a  href="<c:url value='/Main.jsp'></c:url>">返回主页</a><br>   
     </div>
     <div id="right">
			            <h1 align="center">Employee</h1>
			    <table border="1" width="70%" align="center" cellspacing="0">
				<tr>
					<th>员工编号</th>
					<th>员工姓名</th>
					<th>性      别</th>
					<th>出生日期</th>
					<th>住      址</th>
					<th>电     话</th>
					<th>雇佣日期</th>
					<th>所属部门</th>
					<th>职      务</th>
					<th>薪      水</th>
					
				</tr>
				
			<c:forEach items="${requestScope.employeelist}" var="Employee">
				<tr>
					<td class="alt">${Employee.employeeNo }</td>
					<td class="alt">${Employee.employeeName }</td>
					<td class="alt">${Employee.gender }</td>
					<td class="alt">${Employee.birthday }</td>
					<td class="alt">${Employee.address }</td>
					<td class="alt">${Employee.telephone }</td>
					<td class="alt">${Employee.hireDate }</td>
					<td class="alt">${Employee.department }</td>
					<td class="alt">${Employee.headShip }</td>
					<td class="alt">${Employee.salary }</td>
						
				</tr>
			</c:forEach>
			</table>
     </div>
  </body>
</html>
