<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.BanTeam" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班组维护</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/banteam/banteam.js"
	charset="UTF-8">
</script>
<script id="BanTeamHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
                                
                                <td>{{i+1}}</td>
                                <td>{{list[i].ban_department}}</td>
                                <td><a href="javascript:banteamInfo({{list[i].banTeam_id}})">{{list[i].ban_name}}</a></td>
                                <td>{{list[i].ban_group}}</td>
								<td>
                                <button class="btn btn-primary btn-xs" onclick="javascript:selectBanteam({{list[i].banTeam_id}});"><i class="fa fa-pencil"></i></button>								                           
								<button class="btn btn-primary btn-xs" onclick="javascript:deleteBanteam({{list[i].banTeam_id}});"><i class="fa fa-trash-o "></i></button>
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
				<div class="col-md-12" id="delpath">
						<div>
							<form class="form" id="searchBanTeamForm" action=<%=request.getContextPath() + "/module/system/banteam.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 班组管理维护
									</p>
								</div></br></br>
							<table class="table tb">
								<tr>
									<td><label>部门名称：</label>
									<input type="text" placeholder="请输入文字" bindname="ban_department" name="ban_department" id="ban_department">
									</td>
									<td><label>班组名称：</label>
									<input type="text" placeholder="请输入文字" bindname="ban_name" name="ban_name" id="ban_name">
									</td>
									
									<td><label>班组人员：</label>
									<input type="text" placeholder="请输入文字" bindname="ban_group" name="ban_group" id="ban_group">
									</td>
								</tr>
								<!-- <tr>
									<td><label>班制说明：</label>
									<input type="text" placeholder="请输入文字" bindname="class_description" name="class_description" id="class_description">
									</td><td></td><td></td>
								</tr> -->
								<tr>
									<td></td>
									<td></td>
									<td>
									<button type="button" class="btn btn-info b" onclick="javascript:searchBanTeam();">查询</button>　
									<button type="button" class="btn btn-success b" name="add"id="add" onclick="insert()">新增</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
						<table class="table event-table table-striped table-advance table-hover">
						<thead>
							<tr>
							    
                                <th class="th">序号</th>
								<th class="th">部门名称</th>
								<th class="th">班组名称</th>
								<th class="th">班组人员</th>																																
								<th>操作</th> 
							</tr>
						</thead>
						<tbody class="BanTeamArea"></tbody>
						</table>
						<div class="pageDiv"></div>
				</div>
			</div>
<!-- Modal模态框班制新增页面-->
		<div class="modal fade" id="addModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">班制新增管理</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<div class="modal-body">
					<form action="<%=path%>/module/system/banteam/save.do"
						name="banteamForm" id="banteamForm" method="post">
							<div class="row">
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">部门名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="ban_department" id="ban_department1" name="ban_department" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 234px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								
							    <div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label" style="margin-left:15px;">班组名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="ban_name" id="ban_name1" name="ban_name" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 249px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div> 																
								
															
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label" style="margin-left: 15px;">班组人员：</label>
											<textarea placeholder="字数限制为200字" rows="8" cols="60" class="form-control" style="resize: none;width: 497px;margin-left: 15px;"" bindname="ban_group" name="ban_group" id="ban_group1" maxlength="200" value=""></textarea>
										</div>
										<span class="redStar" style="display:block; margin-left: 15px;float:left;margin-left: 527px;margin-bottom: -30px;margin-top: -118px;color: red;" ><font size="3">*</font></span>		
									</div>									
								</div>
						
											
																																																														
							</div>														
						</form>
					         
					         <div class="row">
					           <div class="form-group">
					            <div class="col-md-3" style="color:red;margin-left: 15px;height: 13px;margin-top: -12px;"><font size="3">*</font>为必填项</div>
					           </div>
					         </div>
					         
						</div>					

					<div class="modal-footer">
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:addReset(banteamForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:banteamSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>

<!-- Modal模态框班组修改信息页面-->
		<div class="modal fade" id="editModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">班制新增管理</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<div class="modal-body">
					<form action="<%=path%>/module/system/banteam/editandsave.do"
						name="editbanteamForm" id="editbanteamForm" method="post">
					  <input type="hidden" name="banTeam_id" id="banTeam_id" value="${BanTeam.banTeam_id }" bindname="banTeam_id" />
							<div class="row">
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">部门名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="ban_department" id="ban_department5" name="ban_department" value="">															
									</div>									
								</div>
								
								
							    <div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label" style="margin-left:15px;">班组名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="ban_name" id="ban_name5" name="ban_name" value="">															
									</div>									
								</div> 																
								
															
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label" style="margin-left: 15px;">班组人员：</label>
											<textarea placeholder="字数限制为200字" rows="8" cols="60" class="form-control" style="resize: none;width: 497px;margin-left: 15px;"" bindname="ban_group" name="ban_group" id="ban_group5" maxlength="200" value=""></textarea>
										</div>		
									</div>									
								</div>
						
											
																																																														
							</div>														
						</form>					         
					         
						</div>					

					<div class="modal-footer">
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:editReset(editbanteamForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:updateSubmit();">保存</button>
					</div>
				</div>
			</div>
		</div>

       </section>
     </section>
</body>
</html>