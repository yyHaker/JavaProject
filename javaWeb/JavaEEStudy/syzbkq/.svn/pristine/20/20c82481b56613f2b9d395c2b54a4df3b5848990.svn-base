<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.holiday.entity.Holiday" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>法定假期维护</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/holiday/holiday.js"
	charset="UTF-8">
	
</script>

<style type="text/css">
.addModal{
	width:800px;
}
.title_center{
	text-align: center;
    line-height: 40px;
    height: 40px;
    font-size: 14px;
    font-weight: 700;
}
.add_item_row{
    margin: 0 0 10px 0;
    border-bottom: 1px solid #e5e5e5;
    padding: 0 0 10px 0;
}
</style>
<script id="holidayHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        <td><a href="javascript:holidayInfo({{list[i].hdId}});">{{list[i].vacationName}}</a></td>
								<td>{{list[i].hdYear}}</td>
								<td>{{list[i].startTime}}</td>
								<td>{{list[i].endTime}}</td>
								<td>
									<button class="btn btn-primary btn-xs" type="button" onclick="selecholiday({{list[i].hdId}});"><i class="fa fa-pencil"></i></button>
									<button class="btn btn-danger btn-xs" onclick="delholiday({{list[i].hdId}})"><i class="fa fa-trash-o "></i></button>
								</td>
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
	
		<div class="col-md-12" id="delpath" value="<%=path %>>">
				<div>
					<form class="form" id="searchHolidayForm" action=<%=request.getContextPath() + "/module/system/holiday.do"%> method="post">
						<div class="top">
							<p class="thick">
								<i class="fa fa-bookmark"></i> 法定假期维护
							</p>
						</div></br></br>
						<table style="text-align: right" class="table tb">
							<tr>
								<td><label>假期名称：</label> 
								<input placeholder="请输入文字" type="text" bindname="vacationName" name="vacationName" id="vacationName">
								</td>
								<td><label>所属年份：</label> 
								<input placeholder="请输入文字" type="text" bindname="hdYear" name="hdYear" id="hdYear">
								</td>
								<td><label>开始时间：</label> 
									<input placeholder="请选择时间" class="select　 timechoose timechoose_fordate"bindname="startTime" name="startTime" id="startTime">
								</td>
								</tr>
								<tr>
								<td><label>结束时间：</label>
								<input placeholder="请选择时间" class="select　 timechoose timechoose_fordate" bindname="endTime" name="endTime" id="endTime"></td>
								<td></td><td></td>
							</tr>
							<tr><td></td><td></td>
								<td>
									<a href="<%=path%>/module/system/vacation/vacation.jsp" type="button" class="btn btn-danger b">返回</a>　
									<a class="btn btn-info b" onclick="javascript:searchHoliday();">查询</a>　
									<button type="button" class="btn btn-success b" name="add" id="add" onclick="addHoliday()">新增</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<table class="table event-table table-striped table-advance table-hover">
					<thead>
						<tr>

							<th class="th">假期名称</th>
							<th class="th">所属年份</th>
							<th class="th">开始时间</th>
							<th class="th">结束时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="holidayArea"></tbody>
				</table>
				<div class="pageDiv"></div>
		</div>
		
		
		<!-- Modal模态框 修改法定假期页面-->
		<div class="modal fade" id="editorModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">修改假期信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/holiday/updatHoliday.do" name="editorForm" id="editorForm" method="post">
						<input type="hidden" name="hdId" id="hdId" value="${holiday.hdId }" bindname="hdId"/>
						<div class="modal-body">
							<div class="modal-body">
								<div class="trainer_row">
									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label">假期名称：</label>
											<input type="text" class="form-control modalinput" maxlength="10" bindname="holidayName" id="hname" name="hname" value="${holiday.vacationName}"/>
										</div>
									</div>

									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label" style="margin-left: 40px;">所属年份：</label>
											<input class="form-control modalinput" bindname="hdYear" name="hdYear" id="hdYear" value="${holiday.hdYear}" />
										</div>
									</div>
								</div>
								<div class="trainer_row">
									<div class="col-md-5 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label">开始时间：</label>
											<input class="select timechoose timechoose_fordate modalinput" bindname="startTime" name="startTime" id="startTime" value="${holiday.startTime}" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-10 jiangemodal">
											<div class="form-group" style="margin-left: 15px">
												<label for="field-1" class="control-label">结束时间：</label>
												<input class="select timechoose timechoose_fordate modalinput" bindname="endTime" name="endTime" id="endTime" value="${holiday.endTime}" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button onclick="saveHoliday()" type="button" class="btn btn-success">提交</button>
						<button id="closeModal" type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- modal -->
		
		<!-- Modal模态框 新增法定假期页面-->
		<div class="modal fade" id="addHolidayModal">
			<div class="modal-dialog addModal" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">新增法定假期信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/holiday/save.do" name="holidayForm" id="holidayForm" method="post">
						<div class="modal-body">
							<div class="row">
								<div class="col-md-3 title_center">
									假期名称
								</div>
								<div class="col-md-3 title_center">
									所属年份
								</div>
								<div class="col-md-3 title_center">
									开始时间
								</div>
								<div class="col-md-3 title_center">
									结束时间
								</div> 
							</div> 
							<div class="row add_item_row" >
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="元旦"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select　 timechoose timechoose_fordate modalinput" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select　modalinput timechoose timechoose_fordate modalinput" bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div>
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="春节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select　 timechoose timechoose_fordate modalinput" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate modalinput" bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="清明节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;"bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="五一国际劳动节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="端午节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="中秋节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select　 timechoose timechoose_fordate modalinput" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;"bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
							<div class="row add_item_row">
								<div class="col-md-3" align="center">
									<input type="text" maxlength="10" class="addModal_input modalinput" bindname="vacationName" id="vacationname" Disabled name="vacationName" value="国庆节"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input modalinput" bindname="hdYear" id="hdYear"  name="hdYear"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="startTime" id="startTime"  name="startTime"/>
								</div>
								<div class="col-md-3" align="center">
									<input class="addModal_input select timechoose timechoose_fordate　modalinput" style="width:154px;" bindname="endTime" id="endTime"  name="endTime"/>
								</div>
							</div> 
						</div>
					</form>
					<div class="modal-footer" style="border:none;padding-top:5px;">
						<a id="closeModal" class="btn btn-info" onclick="jacascript:addReset(holidayForm)">重置</a>
						<button id="saveTrainer" type="button" class="btn btn-success" onclick="holidayInfoSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
		<!-- modal -->
		
		<!-- Modal模态框 法定假期详细页面-->
			<div class="modal fade" id="infoModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<p id="userMessage" class="modal-title pmodal">法定假期信息</p>
						</div>
						<form action="<%=path%>/module/system/holiday/holiday.do" name="infoForm" id="infoForm" method="post">
							<div class="modal-body1">
								<div class="row">
									<div class="col-md-5 jiangemodal" >
										<div class="trainer-group">
											<label for="field-1" class="control-label">假期名称：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="vacationName" id="vacationName" name="vacationName" value=""/>
										</div>
									</div>
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-1" style="margin-left: 20px;" class="control-label">所属年份：</label>
											<input type="text"Disabled bindname="hdYear" class="vacation-info modalinput"id="hdYearName" name="hdYear" value=""/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-5 jiangemodal">
										<div class="trainer-group">
											<label for="field-3" class="control-label">开始时间：</label>
											<input type="text" Disabled class="vacation-info modalinput" bindname="startTime" name="startTime" id="status" value=""/>
										</div>
									</div>
									<div class="row">
										<div class="col-md-10 jiangemodal">
											<div class="trainer-group">
												<label for="field-3" style="margin-left: 13px;" class="control-label">结束时间：</label>
												<input type="text" Disabled class="vacation-info modalinput" bindname="endTime" name="endTime" id="status" value=""/>
											</div>
										</div>
									</div>
								</div>
						</form>
					</div>
				</div>
			</div>
			<!-- model -->
		</div>
	</section> </section>
</body>
</html>
