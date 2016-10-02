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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
     <link href="icheck.css" rel="stylesheet">
    <link href="icommon.css" rel="stylesheet">

    <script src="jquery-1.11.3.min.js"></script>
    <script src="icheck.js?v=1.0.2"></script>
    <script>
        $(document).ready(function(){
            $('.user-sex input').each(function(){
                var self = $(this),
                        label = self.next(),
                        label_text = label.text();

                label.remove();
                self.iCheck({
                    checkboxClass: 'icheckbox_sm-blue',
                    radioClass: 'radio_sm-blue',
                    insert: label_text
                });
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


</style>
  <body>
      <div id="top">
         <h1 align="center">Customer Order System</h1>
     </div>
     <div id="left" >
         
        <div class="user-sex"> 
             <div>
                 <input type="radio" id="line-radio-disabled" disabled>
                   <label for="line-radio-disabled">选择所需的表</label>
                        </div>
                        <!--<div>-->
                            <!--<input type="radio" id="line-radio-disabled-checked"   disabled>-->
                            <!--<label for="line-radio-disabled-checked">Disabled &amp; checked</label>-->
                        <!--</div>-->
                        <div>
                            <input type="checkbox" id="check1" name="checkbox" value="000" />
                            <label for="check1">Customer</label>
                        </div>
                        <div>
                            <input type="checkbox" id="check2" name="checkbox" value="111" />
                            <label for="check2">Employee</label>
                        </div>
                        <div>
                        <input type="checkbox" id="check3" name="checkbox" value="222" />
                        <label for="check3">OrderMaster</label>
                        </div>
                        <div>
                            <input type="checkbox" id="check4" name="checkbox" value="222" />
                            <label for="check3">OrderDetail</label>
                        </div>
                         <div>
                            <input type="checkbox" id="check4" name="checkbox" value="222" />
                            <label for="check3">Product</label>
                        </div>
                        <br>
                                                          查询条件<br>
                      
                      <form action="<c:url value='/CustomerServlet?method=editCustomer'></c:url>" method="post">
	                         <textarea rows="4" cols="30" name="sqlinfor"></textarea>  
	                  <input type="submit" id="submit" name="submit" value="查询">
                </form>   
         </div>
          <br>
          <a  href="<c:url value='/Main.jsp'></c:url>">返回主页</a><br>  
        </div> 
     <div id="right">
			            
		
     </div>
  </body>
</html>
