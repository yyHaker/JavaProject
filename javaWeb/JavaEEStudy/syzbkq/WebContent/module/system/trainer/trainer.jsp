<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内训师管理</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/trainer/trainer.js" charset="UTF-8">
</script>
</head>
<body>
	<section id="main-content">
		<section class="wrapper">
			<div>
				<div align="right">				
					<%String name=request.getParameter("name");%>				
					<form id="searchForm" action=<%=request.getContextPath()+"/module/system/trainer.do"%> method="post">	
						<button class="btn btn-default" onclick="javascript:addTrainer();">新增</button> 		
						<input type="text" name="name" id="name" placeholder="姓名" value=<%=request.getParameter("name")==null?"":request.getParameter("name")%>>						
						<button class="btn btn-default" onclick="javascript:searchTrainer();">查询</button> 														
					</form>					
				</div>		
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>操作</th>
							<th>人员编号</th>
							<th>姓名</th>
							<th>年龄</th>
							<th>性别</th>
							<th>政治面貌</th>
							<th>学历</th>
							<th>工龄</th>
							<th>部门</th>
							<th>专业</th>
							<th>岗位</th>				
						</tr>
					</thead>
					<c:choose>
						<c:when test="${not empty trainerList}">
							<c:forEach items="${trainerList}" var="trainer">
								<tr>
								<td><button class="btn btn-default" onclick="javascript:selectTrainer(${trainer.employeenum});">编辑</button>
									<button class="btn btn-default" onclick="javascript:delUser(${trainer.employeenum});" >删除</button>					
								</td>
								<td>${trainer.employeenum}</td>
								<td><a href="javascript:trainerInfo(${trainer.employeenum});">${trainer.name }</a></td>
								<td>${trainer.age }</td>
								<td>${trainer.sex }</td>
								<td>${trainer.politicalstatus}</td>
								<td>${trainer.education}</td>
								<td>${trainer.seniority}</td>
								<td>${trainer.department }</td>
								<td>${trainer.major }</td>
								<td>${trainer.post }</td>
							</c:forEach>
						</c:when>
					<c:otherwise>
					<tr>
						<td>没有相关数据</td>
					</tr>
					</c:otherwise>
				</c:choose>
			</table>
			</div>
			
			<!-- Modal模态框 -->
			<div class="modal fade" id="infoModal">
				<div class="modal-dialog">
					<div class="modal-content">
					
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 id="userMessage" class="modal-title">内训师信息</h4>
						</div>
												
						<form action="<%=path %>/module/system/trainer/trainer.do" name="infoForm" id="infoForm" method="post">
						
						<div class="modal-body">
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">姓名：</label>
										<input type="text" class="form-control-form" Disabled bindname="name" id="name" value="">
									</div>	
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">年龄：</label>
										<input type="text" class="form-control-form" Disabled bindname="age" id="age" value="">
									</div>	
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">									
									<div class="form-group">
										<label for="field-3" class="control-label">岗位：</label>
										<input type="text" class="form-control-form" Disabled bindname="post" id="post" value="">
									</div>										
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">			
									<div class="form-group">
										<label for="field-3" class="control-label">部门：</label>
										<input type="text" class="form-control-form" Disabled bindname="department" id="department" value="">
									</div>	
								</div>
							</div>
							
							<td>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-3" class="control-label">工龄：</label>
										<input type="text" class="form-control-form" Disabled bindname="seniority" id="seniority" value="">
									</div>										
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">	
									<div class="form-group">
										<label for="field-3" class="control-label">学历：</label>
										<input type="text" class="form-control-form" Disabled bindname="education" id="education" value="">
									</div>									
								</div>
							</div>
							
						</div>
						</form>
					</div>
				</div>
			</div>
			
			
			<!-- Modal模态框 -->
			<div class="modal fade" id="editModal">
				<div class="modal-dialog">
					<div class="modal-content">
					
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 id="userMessage" class="modal-title">修改内训师信息</h4>
						</div>
						
						<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
						
						<form action="<%=path %>/module/system/trainer/updatesave.do" name="editForm" id="editForm" method="post">
			
						<input type="hidden" name="employeenum" id="employeenum" value="${trainer.employeenum }" bindname="employeenum"/>
						
						<div class="modal-body">
							<div class="row">	
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">姓名：</label>
										<input type="text" class="form-control" Disabled bindname="name" id="name" value="">
									</div>	
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<label for="field-1" class="control-label">年龄：</label>
										
										<input type="text" class="form-control" bindname="age" id="age" value="">
									</div>	
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-1" class="control-label">岗位：</label>
										
										<input type="text" class="form-control" bindname="post" id="post" value="">
									</div>	
									
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-1" class="control-label">部门：</label>
										
										<input type="text" class="form-control" bindname="department" id="department" value="">
									</div>	
									
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-1" class="control-label">工龄：</label>
										
										<input type="text" class="form-control" bindname="seniority" id="seniority" value="">
									</div>	
									
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									
									<div class="form-group">
										<label for="field-1" class="control-label">学历：</label>
										
										<input type="text" class="form-control" bindname="education" id="education" value="">
									</div>	
									
								</div>
							</div>
							
						</div>
						</form>
						
						<div class="modal-footer">
							<!-- onclick="javascript:selectTrainer(${trainer.employeenum});" -->
							<button id="closeModal" type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
							<button id="saveTrainer" type="button" class="btn btn-info">提交</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			<!-- modal -->
		</section>
	</section>
</body>
</html>