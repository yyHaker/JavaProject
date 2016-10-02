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
	src="<%=request.getContextPath()%>/module/system/quarters/quarters.js"
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
.yanse[placeholder]{ 
	color:#666 !important; 
}
.redStar{
	color:red;
}
#x2{
	color:red;
	margin-top:-27px;
}
#x{
	color:red;
	margin-top:-27px;
}
</style>
<script id="quartersHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                     <td><a href="javascript:quartersInfo({{list[i].pid}});">{{list[i].pid}}</a></td>
								<td>{{list[i].pname}}</td>
								<td>{{list[i].pdescribe}}</td>
								<td>
									<a class="btn btn-primary btn-xs" type="button" onclick="getQuarters({{i}});"><i class="fa fa-pencil"></i></a>
									<button class="btn btn-danger btn-xs" onclick="deleteQuarters({{list[i].pid}})"><i class="fa fa-trash-o "></i></button>
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
					<form class="form" id="searchQuartersForm" action=<%=request.getContextPath() + "/module/system/quarters.do"%> method="post">
						<div class="top">
							<p class="thick">
								<i class="fa fa-bookmark"></i> 岗位管理
							</p>
						</div></br></br>
						<table style="text-align: right" class="table tb">
							<tr>
								<td><label>岗位名称：</label> 
								<input placeholder="请输入文字" type="text" bindname="pname" name="pname" id="pname">
								</td>
								<td><label>岗位描述：</label> 
								<input placeholder="请输入文字" type="text" bindname="pdescribe" name="pdescribe" id="pdescribe">
								</td>
								<td>　
									<a class="btn btn-info b" onclick="javascript:searchQuarters()">查询</a>　
									<button type="button" class="btn btn-success b" name="add" id="add" onclick="addQuarters()">新增</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<table class="table event-table table-striped table-advance table-hover">
					<thead>
						<tr>

							<th class="th">岗位编号</th>
							<th class="th">岗位名称</th>
							<th class="th">岗位描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="quartersArea"></tbody>
				</table>
				<div class="pageDiv"></div>
		</div>
		
		
		<!-- 修改岗位信息 -->
		<div class="modal fade" id="editModal">
			<div class="modal-dialog addModal" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">修改岗位信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/quarters/update.do" name="editForm" id="editForm" method="post">
						<input type="hidden" name="pid" id="pid2" value="" bindname="pid"/>
						<div class="modal-body">
							<div class="col-md-8" style="padding-top: 15px">
								<div class="form-group">
									<label for="field-1" class="control-label">岗位名称</label>
									<input type="text" class="form-control "  bindname="pname" id="pname2" value="" maxlength="10">
								</div>	
								<span class="redStar" style="position: relative;top: -37px;left: 493px;">*</span><div id="x" hidden>岗位名称不能为空</div>
						    </div>
						    	<div class="col-md-8" style="padding-top: 15px">
								<div class="form-group">
									<label for="field-1" class="control-label">岗位描述</label>
									<input type="text" class="form-control "  bindname="pdescribe" id="pdescribe2" value=""
									onblur="if(this.value == '')this.value='岗位描述不允许超过50字';;" 
									onclick="if(this.value == '岗位描述不允许超过50字')this.value='';" placeholder="岗位描述不允许超过50字" maxlength="50">
								</div>	
						    </div>
						    
						    <div class="row">
						  				<div class="form-group">
											<div class="col-md-8" style="padding-left:92px;color:red;">*号为必填项</div>
										</div>
									</div>	
						</div>
					</form>
					<div class="modal-footer" style="border:none;padding-right:85px;">
						<button onclick="updateQuarters()" type="button" class="btn btn-success">提交</button>
						<button id="closeModal" type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Modal模态框 新增岗位页面-->
		<div class="modal fade" id="addQuartersModal">
			<div class="modal-dialog addModal" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">新增岗位信息</p>
					</div>
					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->
					<form action="<%=path%>/module/system/quarters/insert.do" name="quartersForm" id="quartersForm" method="post">
						<div class="modal-body">
							<div class="col-md-8" style="padding-top: 15px">
								<div class="form-group">
									<label for="field-1" class="control-label">岗位名称</label>
									<input type="text" class="form-control "  bindname="pname" id="pname1" value="" maxlength="10">
								</div>	
								<span class="redStar" style="position: relative;top: -37px;left: 493px;">*</span><div id="x2" hidden>岗位名称不能为空</div>
						    </div>
						    	<div class="col-md-8" style="padding-top: 15px">
								<div class="form-group">
									<label for="field-1" class="control-label">岗位描述</label>
									<input type="text" class="form-control "  bindname="pdescribe" id="pdescribe1" value=""
									onblur="if(this.value == '')this.value='岗位描述不允许超过50字';;" 
									onclick="if(this.value == '岗位描述不允许超过50字')this.value='';" placeholder="岗位描述不允许超过50字" maxlength="50">
								</div>	
						    </div>
						    
						    <div class="row">
						  				<div class="form-group">
											<div class="col-md-8" style="padding-left:92px;color:red;">*号为必填项</div>
										</div>
									</div>	
						</div>
					</form>
					<div class="modal-footer" style="border:none;padding-right:85px;">
						<a id="closeModal" class="btn btn-info" onclick="jacascript:addReset(holidayForm)">重置</a>
						<button id="saveTrainer" type="button" class="btn btn-success" onclick="quartersInfoSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
			<!-- model -->
		</div>
	</section> </section>
</body>
</html>
