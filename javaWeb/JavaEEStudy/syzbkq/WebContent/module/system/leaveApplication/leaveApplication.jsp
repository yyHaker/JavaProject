<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.Leave" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>申请休假维护</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/leaveApplication/leaveApplication.js"
	charset="UTF-8">
</script>

<style type="text/css">
.data_css{
	display:inline-block;
	width:220px;
	height:26px;
	border: 1px solid rgb(169,169,169);
	padding-left: 5px;
}
.zuoyi{
	margin-left:25px;
}
.dingwei2{
	position: relative;
    left: 241px;
    top: -62px;
}
.dingwei{
	position: relative;
    left: -241px;
}
</style>
</script>
<script id="leaveApplicationHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        <td>{{i+1}}</td>
                                <td>{{list[i].vacation_user}}</td>
                                <td>{{list[i].vacation_department}}</td>
                                <td><a href="javascript:leaveApplicationInfo({{list[i].ID}});">{{list[i].vacation_name}}</a></td>
								<td>{{list[i].vacation_type=='002'?"自定义假期":"法定假期"}}</td>
								<td>{{list[i].vacation_start}}</td>
								<td>{{list[i].vacation_end}}</td>
								
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
						<div>
							<form class="form" id="searchLeaveForm" action=<%=request.getContextPath() + "/module/system/leaveApplication.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 休假申请维护
									</p>
						</div></br></br>
								<table class="table tb">
								<tr>
									<td ><label>申请人　：</label>
									<input type="text" placeholder="请输入文字" bindname="vacation_user" name="vacation_user" id="vacation_user">
									</td>
									<td><label>所在部门：</label>
									<input type="text" placeholder="请输入文字" bindname="vacation_department" name="vacation_department" id="vacation_department">
									</td>
									<td><label>假期名称：</label>
									<input type="text" placeholder="请输入文字" bindname="vacation_name" name="vacation_name" id="vacation_name">
									</td>
								</tr>
								<tr>
									<td><label>开始时间：</label> 
										<input type="text" placeholder="请选择时间" class="form-control timechoose timechoose_fordate data_css" bindname="vacation_start" name="vacation_start" id="vacation_start">
									</td>
									<td>结束时间：</label>
								        <input type="text" placeholder="请选择时间" class="form-control timechoose timechoose_fordate data_css" bindname="vacation_end" name="vacation_end" id="vacation_end">
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td><td></td>									
									<td>
									<button type="button" class="btn btn-info b" onclick="javascript:searchLeave();" >查询</button>　
									<button type="button" class="btn btn-success b" name="add" id="add" onclick="addLeave()">申请</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						<table class="table event-table table-striped table-advance table-hover">
						<thead>
							<tr>
							    <th class="th">序号</th>
								<th class="th">申请人</th>
								<th class="th">所在部门</th>
								<th class="th">假期名称</th>
								<th class="th">假期类型</th>
								<th class="th">开始时间</th>
								<th>结束时间</th>
							</tr>
						</thead>
						<tbody class="leaveApplicationArea"></tbody>
						</table>
						<div class="pageDiv"></div>
				</div>
			</div>
			
<!-- Modal模态框申请假期新增页面-->
		<div class="modal fade" id="addModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">填写假期申请信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/vacation/save.do" name="vacationForm" id="vacationForm" method="post">
						<div class="modal-body">
							<div class="trainer_row">
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">申请人　：</label> 
										<input type="text"  placeholder="请输入文字" class="vacation-info modalinput" maxlength="10" bindname="vacation_user" id="vacation_user1" name="vacation_user" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">请假时长(天) ：</label> 
										<input type="text"  placeholder="请输入文字" class="vacation-info modalinput" maxlength="10" bindname="vacation_data" id="vacation_data1" name="vacation_data" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">假期名称：</label> 
										<select type="text" placeholder="请输入文字" class="vacation-info modalinput" maxlength="10" bindname="vacation_name" id="vacation_name1" name="vacation_name" value="">				
										</select>	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">休假开始时间：</label> 
										<input type="text" style="width:154px;height:26px;display:inline-block;" placeholder="请选择时间" class="form-control timechoose timechoose_fordate date_css" maxlength="10" bindname="vacation_start" id="vacation_start1" name="vacation_start" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>
							<div class=dingwei>
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">所在部门：</label> 
										<input type="text" placeholder="请输入文字" class="vacation-info modalinput" maxlength="10" bindname="vacation_department" id="vacation_department1" name="vacation_department" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
							</div>
							<div class="dingwei2">
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">休假结束时间：</label> 
										<input type="text" style="width:154px;height:26px; display:inline-block;" placeholder="请选择时间" class="form-control timechoose timechoose_fordate date_css" maxlength="10" bindname="vacation_end" id="vacation_end1" name="vacation_end" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left:283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>
							</div>																															
							</div>

							<div class="trainer_row">							
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group" style="margin-left: 15px">
											<label for="field-1" style="position: relative; top: -222px;" class="control-label">假期原因：</label>
											<textarea rows="8" cols="60" class="form-control  modalinput" style="resize: none;position: relative;resize: none; width: 522px; left: -74px; top: -33px;"
												name="vacation_cause" id="vacation_cause1" maxlength="200" bindname="vacation_cause" value="" placeholder="字数限制为200字" 
												onblur="if(this.value==''){this.value='字数限制为200字';this.style.color='#737e73';}"
												onfocus="if(this.value=='字数限制为200字'){this.value='';this.style.color='#737e73';}">
											</textarea>
										</div>
										<span class="redStar" style="display:block; float:left;margin-left: 539px;margin-bottom: -30px;margin-top: -145px;color: red;" ><font size="3">*</font></span>		
									</div>									
								</div>
							</div>
							
							<div class="col-md-10">
									<div class="form-group" style="top: -46px; left: 5px; position: relative;">
										<label for="field-1" class="control-label">假期说明：</label> 
										<input style="width: 527px;" type="text" class="form-control" maxlength="10" bindname="vacation_explain" id="vacation_explain" name="vacation_explain" value="" disabled>	
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
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:addReset(vacationForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:leaveSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
<!-- Modal模态框 假期信息详细页面-->
			<div class="modal fade" id="infoModal">
				<div class="modal-dialog">
					<div class="modal-content" style="width: 600px;height: 450px;">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<p id="userMessage" class="modal-title pmodal">假期信息</p>
						</div>

						<form action="<%=path%>/module/system/vacation/vacation.do"
							name="infoForm" id="infoForm" method="post">

							<div class="modal-body1">
								<div class="row">
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">申请人　：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_user" id="vacation_user" value="">
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">所在部门　　：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_department" id="vacation_department" value="">
										</div>
									</div>
									
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">假期名称：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_name" id="vacation_name" value="">
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">休假开始时间：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_start" id="vacation_start" value="">
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">请假时长：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_data" id="vacation_data" value="">
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" class="control-label">休假结束时间：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacation_end" id="vacation_end" value="">
										</div>
									</div>
																											
								</div>
									
									<div class="row">
										<div class="col-md-10 jiangemodal">
											<div class="trainer-group">
												<label for="field-3" class="control-label">假期原因：</label></br>
												<textarea rows="8" cols="50" readonly style="width:512px;resize: none;" class="vacation-info" id="vacation_cause"
													bindname="vacation_cause" style="text-indent: 2em" value=""></textarea>
												
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