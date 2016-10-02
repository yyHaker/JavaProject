<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>假期管理</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/vacation/vacation.js"
	charset="UTF-8">
</script>
<script id="vacationHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
								<td><a href="javascript:vacationInfo({{list[i].vacationId}});">{{list[i].vacationName }}</a></td>
								<td>{{list[i].vacationTypeName}}</td>
								<td>
								{{# if(list[i].vacationStatus=='1'){ }}  有效  {{# }  }}
								{{# if(list[i].vacationStatus=='0'){ }}  无效  {{# }  }}
								</td>
								<td title="{{list[i].vacationExplain }}">{{list[i].vacationExplain.length>4?list[i].vacationExplain.substring(0,26)+"...":list[i].vacationExplain}}</td>
								<td><button class="btn btn-primary btn-xs" onclick="javascript:selectVacation({{list[i].vacationId}});"><i class="fa fa-pencil"></i></button>
								</td>

    </tr>
{{# } }}
{{# if(list.length<=0){ }}
<tr>
        <td>没有相关数据</td>
    </tr>
{{# } }}
</script>
</head>
<body>
	<section id="main-content"> 
		<section class="wrapper">
			<div class="row mt">
			<div class="col-md-12">
				<div>
					<form class="form" id="searchForm" action=<%=request.getContextPath() + "/module/system/vacation.do"%> method="post">
						<div class="top">
							<p class="thick">
								<i class="fa fa-bookmark"></i> 假期列表
							</p>
						</div></br></br>
						<table class="table tb">
							<tr>
								<td><label>假期名称：</label> 
								<input placeholder="请输入文字" type="text" bindname="vacationName" name="vacationName" id="vacationName">
								</td>
								<td><label>假期类型：</label> 
								<select class="select" name="vacationType" bindname="vacationType" id="vacationType" class="select">
										<option value="">请选择</option>
										<c:forEach items="${vacationTypeList}" var="codelist">
											<option value="${codelist.codevalue}">${codelist.codename}
											</option>
										</c:forEach>
								</select></td>
								<td><label>是否有效：</label> 
								<select class="select" name="post" bindname="vacationStatus" id="vacationStatus" class="select">
										<option value="">请选择</option>
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>
							</tr>
							<tr>
								<td><label>假期说明：</label>
								<input placeholder="请输入文字" type="text" bindname="vacationExplain" name="vacationExplain" id="vacationExplain"></td>
								<td></td><td></td></tr>
								<tr>
								<td></td>
								<td>
								<a type="button" class="btn btn-info b" href="<%=path%>/module/system/holiday/holiday.jsp">法定假期维护</a>
								</td>
								<td>
									<button type="button" class="btn btn-info b" onclick="javascript:searchVacation();">查询</button>　
									<button type="button" class="btn btn-success b" name="add" id="add" onclick="addVacation()">新增</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<table class="table event-table table-striped table-advance table-hover">
					<thead>
						<tr>

							<th class="th">假期名称</th>
							<th class="th">假期类型</th>
							<th class="th">是否有效</th>
							<th class="th">假期说明</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="vacationArea"></tbody>
				</table>
				<div class="pageDiv"></div>

			<!-- Modal模态框 假期详细页面-->
			<div class="modal fade" id="infoModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<p id="userMessage" class="modal-title pmodal">假期信息</p>
						</div>

						<form action="<%=path%>/module/system/vacation/vacation.do" name="infoForm" id="infoForm" method="post">
 							<div class="modal-body1">
								<div class="row">
									<div class="col-md-5 jiangemodal" >
										<div class="trainer-group">
											<label for="field-1" class="control-label">假期名称：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacationName" id="name" value="">
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" style="margin-left:20px;"class="control-label">假期类型：</label>
											<input type="text" Disabled bindname="vacationTypeName" class="vacation-info modalinput" id="typeName" value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-3" class="control-label">是否有效：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacationStatus" id="status" value="">
										</div>
									</div>
									<div class="row">
										<div class="col-md-10">
											<div class="trainer-group">
												<label for="field-3" style="margin-left: 26px;" class="control-label">假期说明：</label>
												<textarea rows="8" cols="50" readonly style="width:500px;margin-left:29px;resize:none;text-indent: 2em" class="vacation-info" id="explain"
													bindname="vacationExplain" value="">
												</textarea>
											</div>
										</div>
									</div>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal模态框 新增假期页面-->
		<div class="modal fade" id="addModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">新增假期信息</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<form action="<%=path%>/module/system/vacation/save.do" name="vacationForm" id="vacationForm" method="post">
						<div class="modal-body">
							<div class="trainer_row">
								<div class="col-md-5 jiangemodal">
									<div class="trainer-group">
										<label for="field-1" class="control-label">假期名称：</label>
										<input type="text" placeholder="请输入文字" class="vacation-info modalinput" maxlength="10" bindname="vacationName" id="vacationname" name="vacationname" value="">
									</div>
								</div>

								<div class="col-md-5 jiangemodal">
									<div class="trainer-group">
										<label for="field-1" style="margin-left:49px;" class="control-label">假期类型：</label>
										<select class="form-control modalinput" name="vacationtype" id="vacationtype" bindname="vacationType" class="input_txt">
											<option value="">请选择</option>
											<c:forEach items="${vacationTypeList}" var="codelist">
												<option value="${codelist.codevalue}">${codelist.codename}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="trainer_row">
								<div class="col-md-5 jiangemodal">
									<div class="trainer-group">
										<label for="field-1" class="control-label">是否有效：</label>
										<select class="form-control modalinput" name="vacationstatus" id="vacationstatus" bindname="vacationStatus" class="input_txt">
											<option value="">请选择</option>
											<option value="1">是</option>
											<option value="0">否</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group" style="margin-left: 15px">
											<label for="field-1" class="control-label">假期说明：</label>
											<textarea rows="8" cols="60" class="form-control" style="width: 510px;margin-left: 9px;resize: none;text-indent:2em" name="vacationexplain" id="vacationexplain" maxlength="100"
												bindname="vacationExplain" value="">
											</textarea>
										</div>
									</div>
								</div>

							</div>
						</div>
					</form>

					<div class="modal-footer">
						<!-- onclick="javascript:selectTrainer(${trainer.employeenum});" -->
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:addReset(vacationForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:vacationInfoSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
		<!-- modal -->
		<!-- Modal模态框 修改假期页面-->
		<div class="modal fade" id="editModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">修改假期信息</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<form action="<%=path%>/module/system/vacation/updateVacation.do" name="editForm" id="editForm" method="post">
						<input type="hidden" name="vacationId" id="vacationId" value="${vacation.vacationId }" bindname="vacationId" />
							<div class="modal-body">
								<div class="trainer_row">
									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label">假期名称：</label>
											<input type="text" class="form-control modalinput" maxlength="10"bindname="vacationName" id="vname" name="vname" value="">
										</div>
									</div>

									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" style="margin-left:30px;" class="control-label">假期类型：</label>
											<select class="form-control modalinput" name="vtype" id="vtype" bindname="vacationType" class="input_txt">
												<option value="">请选择</option>
												<c:forEach items="${vacationTypeList}" var="codelist">
													<option value="${codelist.codevalue}">${codelist.codename}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="trainer_row">
									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label">是否有效：</label>
											<select class="form-control modalinput" name="vstatus" id="vstatus" bindname="vacationStatus" class="input_txt">
												<option value="">请选择</option>
												<option value="1">是</option>
												<option value="0">否</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-10 jiangemodal">
											<div class="form-group" style="margin-left:15px">
												<label for="field-1" class="control-label">假期说明：</label>
												<textarea rows="8" cols="60" class="form-control" name="vexplain" id="vexplain" maxlength="100" bindname="vacationExplain" value="" style="width:500px;resize:none;"></textarea>
											</div>
										</div>
									</div>

								</div>
							</div>
					</form>

					<div class="modal-footer">
						<!-- onclick="javascript:selectTrainer(${trainer.employeenum});" -->
						<button id="saveVacation" type="button" class="btn btn-success">提交</button>
						<button id="closeModal" type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- modal -->
	</div>
	</section> </section>
</body>
</html>
