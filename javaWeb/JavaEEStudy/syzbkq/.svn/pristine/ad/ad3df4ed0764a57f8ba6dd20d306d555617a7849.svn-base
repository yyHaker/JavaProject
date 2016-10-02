<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="liu.jia_neu">

<title>Thinking - Bootstrap Template</title>

<!-- 页面js -->
<script type="text/javascript"
	src="<%=path %>/module/system/user/user_info.js" charset="utf-8"></script>
</head>
<body>

			<form action="<%=path %>/module/system/user/save.do" name="userForm" id="userForm" target="mainFrame" method="post">
			
			<input type="hidden" name="userId" id="userId" value="${user.userId }" />
			<input type="hidden" name="userRoleId" id="userRoleId" value="${user.roleId }" />
			<input type="hidden" name="personLevel" id="personLevel" value="${user.userlevel }" />
			
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="field-1" class="control-label">用户名</label> 
						<input type="text" class="form-control" id="loginname" name="loginname" bindname="loginname" value="${user.loginname }">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="field-1" class="control-label">名称</label> 
						<input type="text" class="form-control" id="username" name="username" bindname="username" value="${user.username }">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="field-1" class="control-label">密码</label> 
						<input class="form-control" type="password" name="password" id="password" bindname="password" value="${user.password }" class="input_txt" maxlength="10" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="field-1" class="control-label">确认密码</label> 
						<input class="form-control" type="password" name="chkpwd" id="chkpwd" value="${user.password }" class="input_txt" maxlength="10" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<label for="field-3" class="control-label">所属机构</label> 
						<select class="form-control" name="userorgid" id="userorgid" bindname="userorgid" class="input_txt">
							<option value="">请选择</option>
					    	<c:forEach items="${unitList}" var="unit">
								<option value="${unit.orgId }">${unit.orgName }</option>
							</c:forEach>
					    </select>
					</div>

				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<label for="field-3" class="control-label">所属部门</label> 
						<select class="form-control" name="userdeptid" id="userdeptid" bindname="userdeptid" class="input_txt">
					    	<option value="">请选择</option>
					    	<c:forEach items="${deptList}" var="unit">
								<option value="${unit.orgId }" parentid="${unit.parentId }">${unit.orgName }</option>
							</c:forEach>
					    </select>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<label for="field-3" class="control-label">角色</label> 
						<select class="form-control" name="roleId" id="roleId"  bindname="roleId" class="input_txt">
								<option value="">请选择</option>
								<c:forEach items="${roleList}" var="role">
									<option value="${role.roleId }">${role.roleName }</option>
								</c:forEach>
						</select>
					</div>

				</div>
			</div>
			
			</form>
</body>
</html>