<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.neuedu.overtime.entity.Overtime" %>
     <%@ page import="cn.thinking.org.system.user.User" %>
    <%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加班审批</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/approval/approval.js"
	charset="UTF-8">
</script>
<script id="OvertimeHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
								<td>
                                <input type="checkbox" class="box-items thinput" name="box" data-d="{{i}}"
                                  data-overtime_id="{{list[i].overtime_id}}" data-state="{{list[i].state}}">
                                </td>
                                <td>{{list[i].applicant}}</td>
                                <td>{{list[i].apply_time}}</td>
                                <td>{{list[i].begin_time}}</td>
								<td>{{list[i].end_time}}</td>
								<td title="{{list[i].overtime_reason}}">{{list[i].overtime_reason.length>6?list[i].overtime_reason.substring(0,6)+"...":list[i].overtime_reason}}</td>
								<td title="{{list[i].reject_reason}}">{{list[i].reject_reason.length>6?list[i].reject_reason.substring(0,6)+"...":list[i].reject_reason}}</td>
								<td>{{list[i].approver}}</td>
								<td>{{list[i].state}}</td>									
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
							<form class="form" id="searchOvertimeForm" action=<%=request.getContextPath() + "/module/system/approval.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 加班审批
									</p>
						        </div></br></br>
								<table class="table tb">
								<tr>
									<td><label>申请人　：</label> 
									 	<input placeholder="请输入文字" type="text" bindname="applicant" name="applicant" id="applicant">
									 </td>
									
									<td><label>申请日期：</label> 
										<input placeholder="请选择时间" type="text" class="select timechoose timechoose_fordate" bindname="apply_time" name="apply_time" id="apply_time">
									</td>
									
									<td><label>审批人：</label> 
										<input placeholder="请输入文字" type="text" bindname="approver" name="approver" id="approver">
									</td>
								</tr>
								<tr>
									<td><label>审批状态：</label> 
										<select  name="state" id="state" bindname="state">
											<option value="">请选择</option>												
											<option value="已通过">已通过</option>	
											<option value="未通过">未通过</option>											
											<option value="未审批">未审批</option>	
										</select>
									</td>
									<td></td><td></td>
								</tr>
								<tr>
									<td></td><td></td>
									<td>
									<button class="btn btn-info b" type="button" onclick="javascript:searchOvertime();">查询</button>　
									<button class="btn btn-success b" type="button" name="update"id="update" onclick="updateApproval()">审批</button>　
									<button class="btn btn-danger b" type="button" name="update"id="update" onclick="ApprovalN()">驳回</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						<table class="table event-table table-striped table-advance table-hover">
						<thead>
							<tr>
								<th class="th">
									<input class="thinput" type="checkbox" name="all" id="selectall"></th>
								<th class="th">申请人</th>
								<th class="th">申请加班日期</th>
								<th class="th">申请起始时间</th>
								<th class="th">申请结束时间</th>								
								<th class="th">加班原由</th>
								<th class="th">驳回原因</th>
								<th class="th">审批人</th>								
								<th>审批状态</th>
							</tr>
						</thead>
						<tbody class="OvertimeArea"></tbody>
						</table>
						<div class="pageDiv"></div>
				</div>
			</div>
		<!-- Modal模态框申请加班新增页面-->
		<div class="modal fade" id="updateModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">驳回加班申请</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<form action="<%=path%>/module/system/approval/rejectApproval.do" name="rejectForm" id="rejectForm" method="post">
						<div class="modal-body">						
							<div>							
								<div class="row">
									<div class="col-md-10">
										<div class="form-group">											
											<label for="field-1" class="control-label">驳回原因：</label>
											<textarea placeholder="字数限制为200字" rows="5" cols="70" bindname="reject_reason" name="reject_reason" id="reject_reason-update" maxlength="200" style="resize: none" value=""></textarea>
										</div>	
										<span class="redStar" style="display:block; float:left;margin-left: 530px;margin-bottom: -20px;margin-top: -68px;color: red;" ><font size="3">*</font></span>
									</div>
									<div class="row">
		  		         				<div class="form-group">
					      					<div class="col-md-3" style="color:red;margin-left: 20px;"><font size="3">*</font>号为必填项</div>
				        				 </div>									
									</div>
								</div>													
							</div>	
						</div>							
						<div class="modal-footer">
							<a type="button" class="btn btn-info" onclick="javascript:addReset(rejectForm)">重置</a>
							<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:rejectApproval();">提交</button>
						</div>
					</form>
				</div>
			</div>
		</div>		
		<!--  -->	
		
		</section>
		</section>
	</body>
</html>