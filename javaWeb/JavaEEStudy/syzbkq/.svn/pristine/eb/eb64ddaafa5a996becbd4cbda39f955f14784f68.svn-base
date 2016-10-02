<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">

    <title>沈币考勤系统</title>

    <!-- bootstrap 核心css文件 -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
        
    <!-- 模板样式 -->
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

<body>
	<div id="login-page">
		<div class="container">
		
	  		<form class="form-login" action="login.do" method="post" name="loginForm">
		    	<h2 class="form-login-heading">欢迎登陆沈币考勤系统 &copy;</h2>
		    	<div class="login-wrap">
		        	<input type="text" id="loginname" name="loginname" class="form-control" placeholder="请输入用户名" autofocus>
		            <br>
		            <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal">忘记密码?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i>进入</button>
		            <hr>
		            
		            <div class="login-social-link centered">
		            	<p class="validate words" style="display:inline;color:red;">${errInfo}</p>
		            </div>
		            
		            <div class="registration">
		                	还没有加入我们?<br/><br/>
		                <a class="" href="#">
                   			注册账号
		                </a>
		            </div>
		
		        </div>
		
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>请输入您的email地址以便重置密码.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">返回</button>
		                          <button class="btn btn-theme" type="button">提交</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- 引入jquery与bootstrap核心脚本, ps:在document最后引入运行会更快一些:)  -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--jquery 背景图片变换插件-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
        
    </script>


  </body>
</html>
