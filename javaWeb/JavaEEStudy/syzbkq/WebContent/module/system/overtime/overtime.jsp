<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.neuedu.overtime.entity.Overtime" %>
    <%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加班调休管理</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/overtime/overtime.js"
	charset="UTF-8">
</script>

  <!-- 一种嵌入js与html的文本格式：
      {{#  }}  内部放代码即可
   -->
<script id="OvertimeHtml" type="text/html">
 
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
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
							<form class="form" id="searchOvertimeForm" action=<%=request.getContextPath() + "/module/system/overtime.do"%> method="post">
								
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 加班申请维护
									</p>
								</div></br></br>
								
								<table class="table tb">
									 <tr>
									 	<td><label>申请人　：</label> 
									 		<input placeholder="请输入文字" type="text" bindname="applicant" name="applicant" id="applicant" maxlength="10">
										 </td>
									    
									    <!-- 引入了一个日历选择挂件 -->
										<td><label>申请日期：</label> 
											<input placeholder="请选择时间" type="text" style="width:170px;height:28px;display:inline" class="form-control timechoose timechoose_fordate" bindname="apply_time" name="apply_time" id="apply_time">
										</td>
									
										<td><label>审批人：</label> 
											<input placeholder="请输入文字" type="text" bindname="approver" name="approver" id="approver" maxlength="10">
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
									<button class="btn btn-info b" style="margin-right:10px" type="button" onclick="javascript:searchOvertime();">查询</button>   
									<button class="btn btn-success b" type="button" onclick="javascript:changePage()">申请加班</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						
						<table class="table event-table table-striped table-advance table-hover">
						  <thead>
							<tr >
								<th class="text-center">申请人</th>
								<th class="text-center">申请加班日期</th>
								<th class="text-center">申请起始时间</th>
								<th class="text-center">申请结束时间</th>								
								<th class="text-center">加班原由</th>
								<th class="text-center">驳回原因</th>
								<th class="text-center">审批人</th>								
								<th class="text-center">审批状态</th>
							</tr>
						  </thead>
						 <tbody class="OvertimeArea"></tbody>
						</table>
						<div class="pageDiv"></div>
					</div>
				</div>
			</div>					
		<section>
	</section>
	</body>
</html>
