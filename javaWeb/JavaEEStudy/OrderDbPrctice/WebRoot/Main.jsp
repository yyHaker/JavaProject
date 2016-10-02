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
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  
	
	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
  <script type="text/javascript" src="jquery.easing.1.3.js"></script>
<script type="text/javascript" src="jquery.hoverIntent.minified.js"></script>
<script type="text/javascript" src="jquery.naviDropDown.1.0.js"></script>
	<script type="text/javascript">
$(function(){
	
	$('#navigation_horiz').naviDropDown({
		dropDownWidth: '300px'
	});
	
	$('#navigation_vert').naviDropDown({
		dropDownWidth: '300px',
		orientation: 'vertical'
	});
});
</script>
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


    /** {margin:0; padding:0; font-family:Arial, Helvetica, sans-serif; font-size:11px; font-weight:bold; line-height:16px}
    .container {margin:10px auto; width:950px; height:300px; background:#eee; padding:50px 0 0 0}

    /* ----------------------------------------------------- */
	/* navigation styles - BEGIN */ 
	
	/* style for horizontal nav */	
	#navigation_horiz {width:820px; clear:both; padding:0 0 0 0; margin:0 auto}
	#navigation_horiz  ul {height:50px; display:block}
	#navigation_horiz  ul li {display:block; float:left; width:200px; height:50px; background:#999; margin:0 1px 0 0; position:relative}
	#navigation_horiz  ul li a.navlink {display:block; width:200px; height:30px; padding: 20px 0 0 0; text-align:center; color:#fff; text-decoration:none}
	#navigation_horiz .dropdown {position:absolute; padding:20px; border-bottom-right-radius:10px; border-bottom-left-radius:10px; -moz-border-radius-bottomright:10px; -moz-border-radius-bottomleft:10px}
	
	/* style for vertical nav */	
	#navigation_vert {width:820px; clear:both; padding:0 0 0 0; margin:0 auto}
	#navigation_vert  ul {height:50px; display:block}
	#navigation_vert  ul li {display:block; width:200px; height:50px; background:#999; margin:0 0 1px 0; position:relative}
	#navigation_vert  ul li a.navlink {display:block; *display:inline-block; width:200px; height:30px; padding: 20px 0 0 0; text-align:center; color:#fff; text-decoration:none}
	#navigation_vert .dropdown {position:absolute; padding:20px; border-bottom-right-radius:10px; border-top-right-radius:10px; -moz-border-radius-bottomright:10px; -moz-border-radius-topright:10px}
	
		/* style for each drop down - horizontal */
		#navigation_horiz ul li #dropdown_one {background:#ccc; color:#fff}
		#navigation_horiz ul li #dropdown_one a {color:red}
		#navigation_horiz ul li #dropdown_two {background:#ccc; color:#fff}
		#navigation_horiz ul li #dropdown_two a {color:black}
		#navigation_horiz ul li #dropdown_three {background:#ccc; color:#fff}	
		#navigation_horiz ul li #dropdown_three a {color:gray}
		
		/* style for each drop down - vertical */
		#navigation_vert ul li #dropdown_four {background:#333; color:#fff}
		#navigation_vert ul li #dropdown_four a {color:red}
		#navigation_vert ul li #dropdown_five {background:#666; color:#fff}
		#navigation_vert ul li #dropdown_five a {color:black}
		#navigation_vert ul li #dropdown_six {background:#777; color:#fff}	
		#navigation_vert ul li #dropdown_six a {color:orange}

	/* navigation styles - END */ 
	/* ----------------------------------------------------- */
	
</style>
        
  </head>
  <body>
         <div id="top">
    <h1 align="center">Customer System</h1>
</div>
<div class="container" id="left">
    <br>
    <br>
    <div id="navigation_vert" >
        <ul>
            <li>
                <a href="<c:url value='/Customer.jsp'></c:url>" class="navlink">Customer</a>
                <div class="dropdown" id="dropdown_four">
                    <p><a href="#">顾客信息</a></p>
                    <p>主要表现了顾客的客户编号、客户姓名、客户电话、
                                                           客户地址、客户邮编等信息 </p>
                </div><!-- .dropdown_menu -->
            </li>
            <li>
                <a href="<c:url value='/Employee.jsp'></c:url>" class="navlink">Employee</a>
                <div class="dropdown" id="dropdown_five">
                    <p><a href="#">员工信息</a></p>
                    <p>主要表现了员工的员工编号、员工性别、出生日期、住址、电话、雇佣日期、
                                                            所属部门、职务、薪水</p>
                </div><!-- .dropdown_menu -->
            </li>
            <li>
                <a href="<c:url value='/OrderDetail.jsp'></c:url>" class="navlink">OrderDetail</a>
                 
            </li>
            <li>
                <a href="<c:url value='/OrderMaster.jsp'></c:url>" class="navlink">OrderMaster</a>
                <div class="dropdown" id="dropdown_six">
                    <p><a href="#">订单主要信息</a></p>
                    <p>主要展现了订单的订单编号、客户号、业务员编号、订单日期、订单金额、发票号码
                     </p>
                </div><!-- .dropdown_menu -->
            </li>
            <li>
               <a href="<c:url value='/Product.jsp'></c:url>" class="navlink">Product</a>
                 
            </li>
            <li>
               <a href="<c:url value='/CustomerOrder.jsp'></c:url>" class="navlink">CustomerOrder</a>
                 
            </li>
        </ul>
    </div><!-- #navigation_vert -->

</div><!-- .container -->


<div id="right">
          <img alt="" src="./a.jpg">
</div>
         
  </body>
</html>
