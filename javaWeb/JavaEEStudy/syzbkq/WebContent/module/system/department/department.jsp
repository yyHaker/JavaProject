<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.Department" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>部门信息</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/department/department.js"
	charset="UTF-8">
</script>

<style type="text/css">
.data_css{
	display:inline-block;
	width:auto;
	height:28px;
	border-radius: 8px;
	font-size:16px;
	outline:none;
	padding:1px 0 1px 5px;
	-webkit-appearance: textfield;
    background-color: white;
    border-image-source: initial;
    border-image-slice: initial;
    border-image-width: initial;
    border-image-outset: initial;
    border-image-repeat: initial;
    -webkit-rtl-ordering: logical;
    -webkit-user-select: text;
    cursor: auto;
    margin-left: -1px;
    border-width: 2px;
    border-style: inset;
    border-color: initial;
}
#infoModal label {
	color: black;
	font-weight: 10px;
}
</style>
</script>
<script id="departmentHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        <td>{{list[i].dname}}</td>
                                <td>{{list[i].parentdepartment}}</td>
                                <td>{{list[i].createtime}}</td>
								
    </tr>
{{# } }}
{{# if(list.length<=0){ }}
<tr>
        <td colspan="11">没有相关数据</td>
    </tr>
{{# } }}
</script>
</head>
<body>
	<section id="main-content"> 
		<section class="wrapper">
			<div class="row mt">
				<div class="col-md-12" id="delpath">
					<div class="content-panel">
						<div>
							<form class="form" id="searchDepartmentForm" action=<%=request.getContextPath() + "/module/system/department.do"%> method="post">
								<table style="text-align: right" class="table  table-advance ">
									<h4 class="thick" style="font-weight: 600; margin-left: 10px">
										<i class="fa fa-angle-right"></i> 部门信息
									</h4>
								<tr>
									<td style="padding-top: 15px;"><label>上级部门编号：</label> <input
									 style="border-radius: 8px; width: 165px;outline: none;padding-left: 5px;" type="text"
									 bindname="parentdepartment" name="parentdepartment" id="parentdepartment">
									</td>
									
									<td style="padding-top: 15px;"><label>创建时间：</label> <input
									 style="border-radius: 8px; width: 165px;outline: none;padding-left: 5px;" type="text"
									 bindname="createtime" name="createtime" id="createtime">
									</td>
									<td style="padding-top: 15px;"><label>部门名称：</label> 
										<input type="text" style="border-radius: 8px; width: 165px;outline: none;padding-left: 5px;height: 28px;" 
										class="form-control timechoose timechoose_fordate data_css" bindname="dname" name="dname" id="dname">
									</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td style="padding-right: 70px">
									<button type="button" class="btn btn-info"
										onclick="javascript:searchDepartment()"
										style="margin-top: 8px;">查询</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						<hr noshade="noshade" color="#FF0000" width="100%" size="1">
						<table style="text-align: center"
							class="table table-striped table-advance table-hover">
						<thead>
							<tr style="text-align: center; margin-left: 20px">
								<th class="text-center">部门名称</th>
								<th class="text-center">上级部门编号</th>
								<th class="text-center">创建时间</th>
							</tr>
						</thead>
						<tbody class="departmentArea"></tbody>
						</table>
						<div class="pageDiv"></div>
					</div>
				</div>
			</div>
			
<!-- Modal模态框申请假期新增页面-->
		<div class="modal fade" id="addModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 id="userMessage" class="modal-title">填写假期申请信息</h4>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<form action="<%=path%>/module/system/vacation/save.do"
						name="vacationForm" id="vacationForm" method="post">
						<div class="modal-body">
							<div class="trainer_row">
								
								<div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">申请人：</label> 
										<input type="text" class="form-control" maxlength="10" bindname="vacation_user" id="vacation_user1" name="vacation_user" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								<div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">所在部门：</label> 
										<input type="text" class="form-control" maxlength="10" bindname="vacation_department" id="vacation_department1" name="vacation_department" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								<div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">假期名称：</label> 
										<select type="text" class="form-control" maxlength="10" bindname="vacation_name" id="vacation_name1" name="vacation_name" value="">				
										</select>	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								 <div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">请假时长(天)：</label> 
										<input type="text" class="form-control" maxlength="10" bindname="vacation_data" id="vacation_data1" name="vacation_data" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div> 
								
								<div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">休假开始时间：</label> 
										<input type="text" class="form-control  timechoose timechoose_fordate date_css" maxlength="10" bindname="vacation_start" id="vacation_start1" name="vacation_start" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>
								
								<div class="col-md-5">
									<div class="form-group">
										<label for="field-1" class="control-label">休假结束时间：</label> 
										<input type="text" class="form-control  timechoose timechoose_fordate date_css" maxlength="10" bindname="vacation_end" id="vacation_end1" name="vacation_end" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 213px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>																															
							</div>

							<div class="trainer_row">							
								<div class="row">
									<div class="col-md-10">
										<div class="form-group" style="margin-left: 15px">
											<label for="field-1" class="control-label">假期原因：</label>
											<textarea rows="8" cols="60" class="form-control" style="resize: none;width: 443px;"
												name="vacation_cause" id="vacation_cause1" maxlength="200"
												bindname="vacation_cause" value="" placeholder="字数限制为200字" 
												onblur="if(this.value==''){this.value='字数限制为200字';this.style.color='#737e73';}"
												onfocus="if(this.value=='字数限制为200字'){this.value='';this.style.color='#737e73';}">
											</textarea>
										</div>
										<span class="redStar" style="display:block; float:left;margin-left: 464px;margin-bottom: -30px;margin-top: -118px;color: red;" ><font size="3">*</font></span>		
									</div>									
								</div>
							</div>
							
							<div class="col-md-10">
									<div class="form-group">
										<label for="field-1" class="control-label">假期说明：</label> 
										<input type="text" class="form-control" maxlength="10" bindname="vacation_explain" id="vacation_explain" name="vacation_explain" value="" disabled>	
									</div>
								</div>
							
						</div>
						
					<div class="row">
		  		         <div class="form-group">
					      <div class="col-md-3" style="color:red;margin-left: 30px;"><font size="3">*</font>号为必填项</div>
				         </div>
			        </div>
					</form>

					<div class="modal-footer">
						<!-- onclick="javascript:selectTrainer(${trainer.employeenum});" -->
						<a id="saveTrainer" class="btn btn-info"
							onclick="jacascript:addReset(vacationForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-white"
							onclick="javascript:leaveSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
<!-- Modal模态框 假期信息详细页面-->
			<div class="modal fade" id="infoModal">
				<div class="modal-dialog">
					<div class="modal-content" style="width: 600px;height: 435px;">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 id="userMessage" class="modal-title">假期信息</h4>
						</div>

						<form action="<%=path%>/module/system/vacation/vacation.do"
							name="infoForm" id="infoForm" method="post">

							<div class="modal-body1">
								<div class="row">
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">申请人：</label> <input
											     style="margin-left: 38px;"
												type="text" Disabled class="vacation-info"
												bindname="vacation_user" id="vacation_user" value="">
										</div>
									</div>
									
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">所在部门：</label> <input												
												style="margin-left: 26px;"
												type="text" Disabled class="vacation-info"
												bindname="vacation_department" id="vacation_department" value="">
										</div>
									</div>
									
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">假期名称：</label> <input
												style="margin-left: 25px;"
												type="text" Disabled class="vacation-info"
												bindname="vacation_name" id="vacation_name" value="">
										</div>
									</div>
									
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">请假时长：</label> <input
												style="margin-left: 26px;"
												type="text" Disabled class="vacation-info"
												bindname="vacation_data" id="vacation_data" value="">
										</div>
									</div>
									
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">休假开始时间：</label> <input
												type="text" Disabled class="vacation-info"
												bindname="vacation_start" id="vacation_start" value="">
										</div>
									</div>
									
									<div class="col-md-5"
										style="white-space: nowrap; margin: 10px -5px 10px 10px">
										<div class="trainer-group">
											<label for="field-1" class="control-label">休假结束时间：</label> <input
												type="text" Disabled class="vacation-info"
												bindname="vacation_end" id="vacation_end" value="">
										</div>
									</div>
																											
								</div>
									
									<div class="row">
										<div class="col-md-10" Style="margin: 10px -5px 10px 10px">
											<div class="trainer-group">
												<label for="field-3" style="margin-left: 13px;"
													class="control-label">假期原因：</label>
												<textarea rows="8" cols="50" readonly
													style="width: 396px; margin-left: 93px;resize: none;"
													class="vacation-info" id="vacation_cause"
													bindname="vacation_cause" style="text-indent: 2em"
													value=""></textarea>
											</div>
										</div>
									</div>
								</div>
					</form>
								</div>
						
					</div>
				</div>
			
		</section>
	</section>
	</body>
	</html>