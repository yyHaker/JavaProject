<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<%@ page import="cn.thinking.common.util.Const" %>
<%@ page import="cn.thinking.org.system.user.User" %>
<%@ page import="cn.thinking.common.util.CommonUtils" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String imgPath = basePath + "/resources/images";
	
%>

<script type="text/javascript" src="<%=path %>/assets/js/laytpl/laytpl.js"></script>

<script>

	var path = "<%=path %>";
	var basePath = "<%=basePath %>";

	//获取工程路径,例：http://localhost:8080/thinking
	function getRootPath(){
	    var curWwwPath=window.document.location.href;
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
	    var localhostPaht=curWwwPath.substring(0,pos);
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	    
	    return(localhostPaht+projectName);
	}

</script>

<!--  jquery 核心插件 version 1.9.1 -->
<script type="text/javascript" src="<%=path %>/assets/js/jquery.min.js"></script>

<!-- bootstrap 核心样式包 -->
<link rel="stylesheet" href="<%=path %>/assets/comp/bootstrap/css/bootstrap.css" type="text/css" />
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap/js/bootstrap.js"></script>

<!--  jQuery UI 插件  -->
<link href="<%=path %>/assets/comp/jquery-ui-1.11.4.custom/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/assets/comp/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script src="<%=path %>/assets/comp/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>

<!--  bootstrap 插件  -->
<link rel="stylesheet" href="<%=path %>/assets/comp/bootstrap/css/bootstrap-switch.min.css" type="text/css" />
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap/js/bootstrap-switch.min.js" charset="UTF-8"></script>
<link href="<%=path%>/assets/comp/bootstrap-dialog/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/assets/comp/bootstrap-dialog/js/bootstrap-dialog.js"></script>


<!-- datepicker & daterangepicker plugin 日期组件 -->
<link rel="stylesheet" href="<%=path %>/assets/comp/bootstrap/css/bootstrap-datetimepicker.css"  media="screen">
<link rel="stylesheet" href="<%=path %>/assets/comp/bootstrap/css/bootstrap-timepicker.min.css"  media="screen">
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/comp/bootstrap-daterangepicker/daterangepicker-bs3.css"/>
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap/js/bootstrap-timepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap-daterangepicker/moment.js"></script>
<script type="text/javascript" src="<%=path %>/assets/comp/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- menu 菜单组件
<link rel="stylesheet" href="<%=path %>/assets/comp/bootstrap-submenu-master/dist/css/bootstrap-submenu.min.css">
<script src="<%=path %>/assets/comp/bootstrap-submenu-master/dist/js/bootstrap-submenu.min.js" ></script>
<script src="<%=path %>/assets/comp/bootstrap-submenu-master/docs/assets/js/docs.js" ></script>
-->
 
<!-- ztree 树型菜单组件 -->
<link rel="stylesheet" href="<%=path %>/assets/comp/ztree/css/metro.css" type="text/css">
<script type="text/javascript" src="<%=path %>/assets/comp/ztree/js/jquery.ztree.all-3.5.min.js" charset="UTF-8"></script>

<!-- icheck 自定义复选框&单选框样式-->
<link rel="stylesheet" href="<%=path %>/assets/comp/icheck/css/icheck.css?v=1.0.2" type="text/css" />
<script type="text/javascript" src="<%=path %>/assets/comp/icheck/js/icheck.js?v=1.0.2" charset="UTF-8"></script>

<!-- bt-validate 验证组件 -->
<script src="<%=path %>/assets/comp/bt-validate-master/bt-validate.js" ></script>

<!-- multislect 下拉框选择插件 -->
<link rel="stylesheet" href="<%=path %>/assets/comp/multiple-select-master/multiple-select.css" type="text/css" />
<script src="<%=path %>/assets/comp/multiple-select-master/jquery.multiple.select.new.js" ></script>

<!-- echart 制图插件 -->
<script src="<%=path %>/assets/comp/echarts/build/dist/echarts.js"></script>


<!-- accordion 手风琴折叠插件 -->
<script class="include" type="text/javascript" src="<%=path %>/assets/js/jquery.dcjqaccordion.2.7.js"></script>

<!--common script for all pages-->
<script src="<%=path %>/assets/js/common-scripts.js"></script>

<script type="text/javascript" src="<%=path %>/assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/gritter-conf.js"></script>

<!-- 提示牌 -->
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/js/gritter/css/jquery.gritter.css" />

<!-- 实用工具：包括base64转码器、获取浏览器窗口大小等 -->
<script type="text/javascript" src="<%=path %>/assets/js/utils/commonUtils.js"></script>
<script type="text/javascript" src="<%=path %>/assets/js/utils/base64.js"></script>

<!-- 收集、绑定表单信息封装组件 -->
<script type="text/javascript" src="<%=path %>/assets/js/collect.js"></script>

<!-- HttpService封装的AJAX交互类 -->
<script type="text/javascript" src="<%=path %>/assets/js/httpService.js"></script>

<!-- 模板自定样式 by liu.jia_neu -->
<link href="<%=path %>/assets/css/style.css" rel="stylesheet">
<link href="<%=path %>/assets/css/page.css" rel="stylesheet">
<link href="<%=path %>/assets/css/style-responsive.css" rel="stylesheet">
<link href="<%=path %>/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />


