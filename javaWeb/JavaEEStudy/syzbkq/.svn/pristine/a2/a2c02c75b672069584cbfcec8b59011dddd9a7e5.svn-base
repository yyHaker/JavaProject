<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<%@page import="cn.thinking.org.system.trainingplan.Trainingplan"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训计划</title>
<script type="text/javascript"
		 src="<%=request.getContextPath()%>/module/system/trainingplan/trainingplan.js" charset="UTF-8">
</script>
</head>
<body>
	<section id="main-content">
		<section class="wrapper">
			<div>
				<%String hostdepartment=request.getParameter("hostdepartment");%>
				<form id="searchForm" action=<%=request.getContextPath()+"/module/system/trainingplan.do"%> method="post">
					<table>
						<tr>
							<td>
								<label >主办部门: </label>
								<input  type="text" id="hostdepartment"  name="hostdepartment" value=<%=request.getParameter("hostdepartment")==null?"":request.getParameter("hostdepartment")%>>
							</td>
							<td>
								<label>培训内容:</label>
								<input type="text" id="tcontent" name="tcontent" value=<%=request.getParameter("tcontent")==null?"":request.getParameter("tcontent")%>>
							</td>
							<td>
								<label>培训对象: </label>
								<input type="text" id="tobject" name="tobject" value=<%=request.getParameter("tobject")==null?"":request.getParameter("tobject")%>>
							</td>
							<td>
								<label>培训日期: </label>
								<input type="text" id="trainingdate" name="trainingdate" value=<%=request.getParameter("trainingdate")==null?"":request.getParameter("trainingdate")%>>
							</td>
						</tr>
						<tr>
							<td>
								<label>培训地点: </label>
								<input type="text" id="tplaces" name="tplaces" value=<%=request.getParameter("tplaces")==null?"":request.getParameter("tplaces")%>>
							</td>
						
							<td>
								<label>讲师来源: </label>
								<input type="text" id="lecturesource" name="lecturesource" value=<%=request.getParameter("lecturesource")==null?"":request.getParameter("lecturesource")%>>
							</td>
						
							<td>
								<label>协助部门: </label>
								<input type="text" id="assistdepartment" name="assistdepartment" value=<%=request.getParameter("assistdepartment")==null?"":request.getParameter("assistdepartment")%>>
							</td>
							<td align="right">
								<button class="btn btn-default" onclick="javascript:searchTrainingplan();">查询</button>
							</td>
						</tr>
					</table>
				</form>
				</div>
			<div>		
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>操作</th>
  							<th>序号</th>
  							<th>培训目标</th>
  							<th>培训内容</th>
  							<th>培训对象</th>
  							<th>计划人数</th>
  							<th>计划课时</th>
  							<th>培训日期</th>
  							<th>培训地点</th>
  							<th>讲师及来源</th>
  							<th>主办部门</th>
  							<th>协助部门</th>			
						</tr>
					</thead>
					<c:choose>
						<c:when test="${not empty trainingplanList}">
							<c:forEach items="${trainingplanList}" var="trainingplan">
								<tr>
								<td><button class="btn btn-default">通过</button>
									<button class="btn btn-default">驳回</button>					
								</td>
								<td>${trainingplan.trainingplannum}</td>
								<td>${trainingplan.tobjectives }</td>
								<td>${trainingplan.tcontent }</td>
								<td>${trainingplan.tobject }</td>
								<td>${trainingplan.plannumber}</td>
								<td>${trainingplan.planperiod}</td>
								<td>${trainingplan.trainingdate}</td>
								<td>${trainingplan.tplaces }</td>
								<td>${trainingplan.lecturesource }</td>
								<td>${trainingplan.hostdepartment }</td>
								<td>${trainingplan.assistdepartment }</td>
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
		</section>
	</section>



</body>
</html>