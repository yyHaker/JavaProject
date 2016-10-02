<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.attendance.entity.Departure" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>离岗申请维护</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/departure/departure.js"
	charset="UTF-8">
</script>

<style type="text/css">
.data_css{
	display:inline-block;
	width:220px;
	height:26px;
	border: 1px solid rgb(169,169,169);
}
.thinput{
	width:40px;
	height:15px;
}
.zuoyi{
	margin-left:25px;
}
</style>
<script id="DepartureHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
                                <td>
                                 <input type="checkbox" class="box-items  thinput" name="box" data-d="{{i}}"
                                   data-departure_status="{{list[i].departure_status}}"
                                    data-ID="{{list[i].ID}}">
                                </td>
                                <td>{{list[i].departure_name}}</td>
                                <td>{{list[i].departure_department}}</td>
                                <td>{{list[i].departure_group}}</td>
								<td>{{list[i].departure_class}}</td>
								<td>{{list[i].departure_date}}</td>
                                <td>{{list[i].departure_time}}</td>
								<td title="{{list[i].departure_reason}}">{{list[i].departure_reason.length>8?list[i].departure_reason.substring(0,8)+"...":list[i].departure_reason}}</td>
								<td>{{list[i].departure_status=='2'?"已审批":"待审批"}}</td>
								
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
							<form class="form" id="searchDepartureForm" action=<%=request.getContextPath() + "/module/system/departure.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 离岗申请维护
									</p>
								</div></br></br>
								<table class="table tb">
								<tr>
									<td><label>离岗人：</label>
									<input placeholder="请输入文字" type="text" bindname="departure_name" name="departure_name" id="departure_name">
									</td>
									
									<td><label>所在部门：</label>
									<input placeholder="请输入文字" type="text" bindname="departure_department" name="departure_department" id="departure_department">
									</td>
									<td><label>离岗申请时间：</label> 
										<input placeholder="请选择时间" type="text" class="form-control timechoose timechoose_fordate data_css" bindname="departure_time" name="departure_time" id="departure_time">
									</td>
								</tr>
								<tr>
									<td><label>班组　：</label>
									<input placeholder="请输入文字" type="text" bindname="departure_group" name="departure_group" id="departure_group">
									</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td><td></td>
									<td>
									<button type="button" class="btn btn-info b"onclick="javascript:updateDeparture();">离岗审批</button>　
									<button type="button" class="btn btn-info b"onclick="javascript:searchDeparture();">查询</button>　
									<button type="button" class="btn btn-success b" name="add"id="add" onclick="insert()">申请离岗</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						<table class="table event-table table-striped table-advance table-hover">
						<thead>
							<tr >
							    <th class="th"><input class="thinput" type="checkbox" name="all" id="selectall"></th>
								<th class="th">离岗人</th>
								<th class="th">所在部门</th>
								<th class="th">班组</th>
								<th class="th">班制</th>								
								<th class="th">离岗时长(天)</th>
								<th class="th">离岗申请时间</th>
								<th class="th">离岗原因</th>
								<th>审批状态</th>
							</tr>
						</thead>
						<tbody class="DepartureArea"></tbody>
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

					<form action="<%=path%>/module/system/departure/save.do"
						name="departureForm" id="departureForm" method="post">
						<div class="modal-body">
							<div class="trainer_row">
							<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">所在部门：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="departure_department" id="departure_department1" name="departure_department" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">离岗申请人　：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="departure_name" id="departure_name1" name="departure_name" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">班组　　：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="departure_group" id="departure_group1" name="departure_group" value="">														
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">离岗时长(天) ：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="departure_date" id="departure_date1" name="departure_date" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>
								 <div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">班制　　：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="departure_class" id="departure_class1" name="departure_class" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 230px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div> 
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label zuoyi">离岗申请时间：</label> 
										<input type="text" placeholder="请选择时间" class="form-control modalinput timechoose timechoose_fordate date_css" maxlength="10" bindname="departure_time" id="departure_time1" name="departure_time" value="">	
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 283px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>
								</div>																															
							</div>

							<div class="trainer_row">							
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group" style="margin-left: 15px">
											<label for="field-1" class="control-label">离岗原因：</label>
											<textarea placeholder="字数限制为200字" rows="8" cols="60" class="form-control" style="resize: none;width: 523px;" bindname="departure_reason" name="departure_reason" id="departure_reason1" maxlength="200" value=""></textarea>
										</div>
										<span class="redStar" style="display:block; float:left;margin-left: 540px;margin-bottom: -30px;margin-top: -118px;color: red;" ><font size="3">*</font></span>		
									</div>									
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
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:addReset(departureForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:departureSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>		

		</section>
	</section>
	</body>
	</html>