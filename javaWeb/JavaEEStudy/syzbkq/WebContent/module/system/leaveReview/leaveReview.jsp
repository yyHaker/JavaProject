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
	src="<%=request.getContextPath()%>/module/system/leaveReview/leaveReview.js"
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
</style>

<script id="leaveApplicationHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
                                <td>
                                 <input type="checkbox" class="box-items thinput" name="box" data-d="{{i}}" 
                                  data-vacation_review="{{list[i].vacation_review}}"
                                  data-ID="{{list[i].ID}}" data-vacation_end="{{list[i].vacation_end}}">
                                </td>
                                <td>{{list[i].vacation_user}}</td>
                                <td>{{list[i].vacation_department}}</td>
                                <td>{{list[i].vacation_name}}</td>
								<td>{{list[i].vacation_type=='002'?"自定义假期":"法定假期"}}</td>
								<td>{{list[i].vacation_start}}</td>
								<td>{{list[i].vacation_end}}</td>
                                <td title="{{list[i].vacation_cause}}">{{list[i].vacation_cause.length>8?list[i].vacation_cause.substring(0,8)+"...":list[i].vacation_cause}}</td>
                                <td>{{list[i].vacation_review=='1'?"审批通过":"待审批"}}</td>
								
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
							<form class="form" id="searchLeaveForm" action=<%=request.getContextPath() + "/module/system/leaveReview.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 休假申请维护
									</p>
						</div></br></br>
								<table class="table tb">
								<tr>
									<td><label>申请人　：</label>
									<input placeholder="请输入文字" type="text" bindname="vacation_user" name="vacation_user" id="vacation_user">
									</td>
									
									<td><label>所在部门：</label>
									<input placeholder="请输入文字" type="text" bindname="vacation_department" name="vacation_department" id="vacation_department">
									</td>
									
									<td><label>假期名称：</label>
									<input placeholder="请输入文字" type="text"  bindname="vacation_name" name="vacation_name" id="vacation_name">
									</td>
								</tr>
								<tr>
									<td><label>开始时间：</label> 
										<input placeholder="请选择时间" type="text" class="form-control timechoose timechoose_fordate data_css" bindname="vacation_start" name="vacation_start" id="vacation_start">
									</td>
									 <td><label>结束时间：</label>
								        <input placeholder="请选择时间" type="text" class="form-control timechoose timechoose_fordate data_css" bindname="vacation_end" name="vacation_end" id="vacation_end">
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td><td></td>
									<td>
									<button type="button" class="btn btn-success b" onclick="javascript:updateFlag()">提前销假</button>　
									<button type="button" class="btn btn-info b" onclick="javascript:searchLeave();">查询</button>　
									<button type="button" class="btn btn-success b" name="add" id="add" onclick="insert()">审批</button>
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
								<th class="th">所在部门</th>
								<th class="th">假期名称</th>
								<th class="th">假期类型</th>
								<th class="th">开始时间</th>
								<th class="th">结束时间</th>
								<th class="th">休假原因</th>
								<th>审批状态</th>
								<!-- <th class="text-center">操作</th> -->
							</tr>
						</thead>
						<tbody class="leaveArea"></tbody>
						</table>
						<div class="pageDiv"></div>
				</div>
			</div>
			
<!-- Modal模态框申请假期新增页面-->

		</section>
	</section>
	</body>
	</html>