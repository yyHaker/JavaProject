<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="liu.jia_neu">

    <title>沈币考勤系统</title>
	
	<!-- 页面js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/module/common/index.js" charset="utf-8"></script>
	
    <!-- 外部 css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
  </head>

  <body>

  <section id="container" >
      <!--header start-->
      <header class="header black-bg">
      		<!-- 下拉框for手机端
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
             -->
             
            <!--logo start-->
            <a href="index.do" class="logo"><b>考勤系统</b></a>
            <!--logo end-->
            
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">4条计划在执行</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">SSM框架部署文档</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">jar包说明</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">学习资料收集</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">框架测试</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">您有7条未读信息</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    	<span class="subject">
                                    		<span class="from">朱海荣（政府第三事业部部长）</span>
                                    	</span>
                                    <span class="message">
                               			嗨,兄弟, java2级需求5人
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">查看所有信息</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
            		<li style="padding-top:22px;padding-right:10px;color: #fff"><span id="sysTime"></span></li>
            		<li style="padding-top:22px;padding-right:10px;color: #fff">欢迎您！${user.orgname}  ${user.deptname} ${user.username }</li>
                    <li><a class="logout" href="javascript:logout();">离开这里</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
                  
              <!-- sidebar menu start-->
              
              <ul class="sidebar-menu" id="nav-accordion">
              <li class="mt">
                  <a class="active" href="default.do" target="mainFrame">
                      <i class="fa fa-dashboard"></i>
                      <span>默认首页</span>
                  </a>
              </li>
              
              <c:forEach items="${menuList}" var="menu">
              	<c:if test="${menu.hasMenu}">
              		<c:choose>
              			<c:when test="${empty menu.menuUrl}">
              				
              				<li class="sub-menu">
              					<a href="javascript:;" >
		              				<i class="fa fa-desktop"></i>
		              				<span>${menu.menuName }</span>
              					</a>
              					<c:forEach items="${menu.subMenu}" var="sub">
	              					<c:if test="${sub.hasMenu}">
		              					<ul class="sub">
				                            <li><a href="${sub.menuUrl }" target="mainFrame">${sub.menuName }</a></li>
				                        </ul>
			                        </c:if>
		                        </c:forEach>
              				</li>
              				
              				
              			</c:when>
              		</c:choose>      
	          	</c:if>
              </c:forEach>
		       </ul>       
              
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
	  <iframe name="mainFrame" id="mainFrame" frameborder="0" src="default.do" style="width:100%;height:100%;"></iframe>	
      <!--main content end-->
  </section>

    
	<!--script for this page-->
	<script src="assets/js/zabuto_calendar.js"></script>

  </body>
</html>
