<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤管理</title>
<script type="text/javascript" 
	src="<%=request.getContextPath()%>/module/system/attendance/attendance.js"
	charset="UTF-8">
</script>
<script id="attendanceHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
								<td>{{list[i].personno }}</td>
								<td>{{list[i].username}}</td>
								<td>{{list[i].telephone}}</td>
								<td>{{list[i].mobiletelephone}}</td>
								<td>{{list[i].activity==0?"挂失卡":(list[i].activity==1?"正常使用":(list[i].activity==2?"冻结卡":"报废卡"))}}</td>
								<td>{{list[i].createtime}}</td>
								<td>
									<button class="btn btn-primary btn-xs" onclick="javascript:modiAttendance({{list[i].userid}});"><i class="fa fa-pencil"></i></button>
								</td>

    </tr>
{{# } }}
{{# if(list.length<=0){ }}
<tr>
        <td colspan="15">没有相关数据</td>
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
					<form class="form" id="searchAttendanceForm" action=<%=request.getContextPath() + "/module/system/attendance.do"%> method="post">
						<div class="top">
							<p class="thick">
								<i class="fa fa-bookmark"></i> 考勤管理
							</p>
						</div></br></br>
						<table class="table tb">
							<tr>
								<td><label>人员编号：</label> 
								<input placeholder="请输入数字" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" type="text"
									bindname="personno" name="personno" id="personno" maxlength="15">
								</td>
								<td><label>用户名称：</label> 
								<input placeholder="请输入文字" type="text" bindname="username" name="username" id="username" maxlength="15">
								</td>
								<td ><label>登记日期：</label> 
								<input placeholder="请选择时间" class="select　 timechoose timechoose_fordate" bindname="createtime" name="createtime" id="createtime"></td>
							</tr>
							<tr>
							<td></td><td></td>
								<td>
									<button class="btn btn-info b" type="button" onclick="javascript:searchAttendance();">查询</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<table class="table event-table table-striped table-advance table-hover">
						<thead>
						<tr>

							<th class="text-center">人员编号</th>
							<th class="text-center">用户名称</th>
							<th class="text-center">电话</th>
							<th class="text-center">移动电话</th>
							<th class="text-center">卡状态</th>
							<th class="text-center">登记日期</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody class="attendanceArea"></tbody>
				</table>
				<div class="pageDiv"></div>
			</div>
		</div>
		
		<!-- Modal模态框 修改考勤管理页面-->
		<div class="modal fade" id="editModal">
			<div class="modal-dialog addModal" >
				<div class="modal-content"  style="width:500px;margin-left:100px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">修改考勤信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/attendance/updateattendance.do" name="editForm" id="editForm" method="post">

						<input type="hidden" name="userid_update" id="userid_update" bindname="userid" />
						<div class="modal-body">
							<div class="col-md-8" style="margin-bottom: -20px;">
								<div class="form-group">
									<label for="field-1" class="control-label">用户名称：</label> 
									<input type="text" placeholder="请输入文字" class="form-control" maxlength="15" readonly 
									bindname="username" id="username_update" name="username_update" value="">
								</div>
								<span class="redStar" style="position: relative;top: -37px;left: 300px;color: red;">*</span>
							</div>
							<div class="col-md-8" style="margin-bottom: 0px;">
								<div class="form-group">
									<label for="field-1" class="control-label">电话：</label> 
									<input placeholder="请输入数字" class="form-control" name="telephone_update" id="telephone_update" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
									bindname="telephone" class="input_txt" maxlength="15">
								</div>
								<!-- <span class="redStar" style="position: relative;top: -37px;left: 300px;color: red;">*</span> -->
							</div>
							<div class="col-md-8" style="margin-bottom: 0px;">
								<div class="form-group">
									<label for="field-1" class="control-label">移动电话：</label> 
									<input placeholder="请输入数字" class="form-control" name="mobiletelephone_update" id="mobiletelephone_update" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
									bindname="mobiletelephone" class="input_txt" maxlength="15">						
								</div>
								<!-- <span class="redStar" style="position: relative;top: -37px;left: 300px;color: red;">*</span> -->
							</div>
							<div class="col-md-8" style="margin-bottom: -20px;">
								<div class="form-group">
									<label for="field-1" class="control-label">卡状态：</label>
									<select class="form-control" name="activity_update" id="activity_update"
									bindname="activity" value="">
										<option value="">请选择</option>
										<option value="0">挂失卡</option>
										<option value="1">正常使用</option>
										<option value="2">冻结卡</option>
										<option value="3">报废卡</option>
									</select>
								</div>
								<span class="redStar" style="position: relative;top: -37px;left:300px;color: red;">*</span>
							</div>
							<div class="col-md-8" style="margin-bottom: -20px;">
								<div class="form-group">
									<label for="field-1" class="control-label">登记日期：</label>
									<input placeholder="请选择时间" class="form-control timechoose timechoose_fordate select"
									name="createtime_update" id="createtime_update" bindname="createtime" value="">
								</div>
								<span class="redStar" style="position: relative;top: -37px;left: 300px;color: red;">*</span>
							</div>
							<div class="row">
						  		<div class="form-group">
									<div class="col-md-8" style="padding-left:30px;color:red;">*号为必填项</div>
								</div>
							</div>	
						</div>
					</form>
					<div class="modal-footer">
						<button id="saveAttendance" type="button" class="btn btn-success">提交</button>
						<button id="closeModal" type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
					</div>					
				</div>
			</div>
		</div>
		<!-- modal -->		
</body>
</html>