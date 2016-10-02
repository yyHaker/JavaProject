<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">


<title>系统用户管理</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/user/users.js" charset="UTF-8"></script>

</head>
<body>
	<section id="main-content">
		<section class="wrapper">
			<!-- 
		<h4><i class="fa fa-angle-right"></i> 系统管理 <i class="fa fa-angle-right"></i> 用户管理</h4>
		 -->
			<div class="row mt">
				<div class="col-md-12">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<h4>
								<i class="fa fa-angle-right"></i> 用户信息列表
							</h4>
							<hr>

							<thead>
								<tr>
									<th>序号</th>
									<th>用户名</th>
									<th>名称</th>
									<th>角色</th>
									<th>机构</th>
									<th>部门</th>
									<th>最近登录</th>
									<th><i class="fa fa-edit"></i>操作</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${not empty userList}">
									<c:forEach items="${userList}" var="user" varStatus="vs">
										<tr>
											<td>${vs.index+1}</td>
											<td>${user.loginname }</td>
											<td>${user.username }</td>
											<td>${user.role.roleName }</td>
											<td>${user.orgname}</td>
											<td>${user.deptname}</td>
											<td><fmt:formatDate value="${user.lastLogin}"
													pattern="yyyy-MM-dd HH:mm:ss" />
											</td>
											<td>
												<button class="btn btn-primary btn-xs"
													onclick="javascript:editUser(${user.userId });">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs"
													onclick="javascript:delUser(${user.userId });">
													<i class="fa fa-trash-o "></i>
												</button>
												
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="7">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							
							
						</table>
						<h4>
							<i class="fa fa-angle-right"></i> <a href="javascript:addUser();" class="myBtn"><em>新增</em></a>
						</h4>
					</div>
				</div>
				<!-- /col-md-12 -->
			</div>

			<!-- Modal模态框 -->
			<div class="modal fade" id="editModal">
				<div class="modal-dialog">
					<div class="modal-content">
					
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 id="userMessage" class="modal-title">用户信息</h4>
						</div>
						
						<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
						
						<form action="<%=path %>/module/system/user/save.do" name="form" id="form" method="post">
			
						<input type="hidden" name="userId" id="userId" value="${user.userId }" bindname="userId"/>
						<input type="hidden" name="userRoleId" id="userRoleId" value="${user.roleId }" bindname="userRoleId"/>
						<input type="hidden" name="password" id="password" value="${user.password }" bindname="password"/>
						<input type="hidden" name="personLevel" id="personLevel" value="${user.userlevel }" bindname="personLevel"/>
						
						<div class="modal-body">
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">用户名</label>
										
										<input type="text" class="form-control" Disabled bindname="loginname" id="loginname" value="">
									</div>	
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">名称</label>
										
										<input type="text" class="form-control" bindname="username" id="username" value="">
									</div>	
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-3" class="control-label">所属机构</label>
											<select id="userorgid" name="userorgid" bindname="userorgid" multiple="multiple">
									
											</select>
									</div>	
									
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-3" class="control-label">所属部门</label>
											<select id="userdeptid" name="userdeptid" bindname="userdeptid" multiple="multiple">
									
											</select>
									</div>	
									
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-3" class="control-label">角色</label>
											<select id="roleId" name="roleId" bindname="roleId" multiple="multiple">
									
											</select>
									</div>	
									
								</div>
							</div>
							
						</div>
						</form>
						
						<div class="modal-footer">
							<button id="closeModal" type="button" class="btn btn-white" data-dismiss="modal">Close</button>
							<button id="saveUser" type="button" class="btn btn-info">保存</button>
						</div>
					</div>
				</div>
			</div>
			<!-- modal -->
			<!-- /row -->
		</section>
	</section>

</body>
</html>
