<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.WorkManage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/module/common/config.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班组排班设置</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/module/system/workmanage/workmanage.js"
	charset="UTF-8">
</script>

<style type="text/css">
.data_css{
	display:inline-block;
	width:220px;
	height:26px;
	border: 1px solid rgb(169,169,169);
}
.rdchicun{
	width: 35px;
    height: 15px;
}
</style>

<script id="WorkManageHtml" type="text/html">
{{# var list = d.data;  }}
{{# for(var i = 0, len = list.length; i < len; i++){ }}
    <tr>                        
                                
                                <td>{{i+1}}</td>
                                <td>{{list[i].wdepartment}}</td>
                                <td><a href="javascript:classManageInfo({{list[i].workmanage_id}})">{{list[i].wname}}</a></td>
                                <td>{{list[i].wclass_name}}</td>
								<td>{{list[i].wclass_description.length>8?list[i].wclass_description.substring(0,15)+"...":list[i].wclass_description}}</td>
                                <td>{{list[i].wclass_group}}</td>                           
								<td> 
                                <button class="btn btn-primary btn-xs" onclick="javascript:selectClassManage({{list[i].workmanage_id}});"><i class="fa fa-pencil"></i></button>
                                <button class="btn btn-primary btn-xs" onclick="javascript:deleteWorkManage({{list[i].workmanage_id}});"><i class="fa fa-trash-o "></i></button>
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
							<form class="form" id="searchWorkManageForm" action=<%=request.getContextPath() + "/module/system/workmanage.do"%> method="post">
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 班组排班管理
									</p>
								</div></br></br>
							<table class="table tb">
								<tr>
									<td><label>部　　门：</label>
									<input type="text" placeholder="请输入文字" bindname="wdepartment" name="wdepartment" id="wdepartment">
									</td>
									<td><label>班制名称：</label>
									<select type="text" bindname="wname" name="wname" id="wname">
									    <option value="">请选择</option>
									  		<c:forEach items="${BanSystemList}" var="codelist">
									    		<option value="${codelist.codevalue}">${codelist.codename}</option>
									  		</c:forEach>
									 </select>
									</td>
									
									<td><label>班组名称：</label>
									<input type="text" placeholder="请输入文字" bindname="wclass_name" name="wclass_name" id="wclass_name">
									</td>
								</tr>
								<tr>
									<td><label>班制说明：</label>
									<input type="text" placeholder="请输入文字" bindname="wclass_description" name="wclass_description" id="wclass_description">
									</td>
									
                                    <td><label>班组人员：</label>
									<input type="text" placeholder="请输入文字" bindname="wclass_group" name="wclass_group" id="wclass_group">
									</td>
                                    
                                    <td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
									<button type="button" class="btn btn-info b" onclick="javascript:searchWorkManage();">查询</button>　
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
								<th class="th">班制名称</th>
								<th class="th">班组名称</th>																																
								<th class="th">班制说明</th>
								<th class="th">班组人员</th>
								<th>操作</th> 
							</tr>
						</thead>
						<tbody class="WorkManageArea"></tbody>
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
						<p id="userMessage" class="modal-title pmodal">班组排班管理</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<div class="modal-body">
					<form action="<%=path%>/module/system/workManage/save.do"
						name="workManageForm" id="workManageForm" method="post">
							<div class="row">
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">部门名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="wdepartment" id="wdepartment1" name="wdepartment" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 234px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								
							    <div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label" style="margin-left:15px;">班组名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="wclass_name" id="wclass_name1" name="wclass_name" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 249px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div> 
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">班制名称：</label> 
										<select type="text" class="select" maxlength="10" bindname="wname" id="wname1" name="wname" style="height:26px; width:154px;">
										  <!-- <option value="">请选择</option> -->
										   <c:forEach items="${BanSystemList}" var="codelist">
										    <option value="${codelist.codevalue}">${codelist.codename}</option>
										   </c:forEach>
										</select>															
									</div>													
								</div>																
								
							    <div class="col-md-10 jiangemodal">
									<div class="form-group">
										<span id="one">
										   <input class="rdchicun" type="radio" name="tag" id="wclass_description" value="A:8:00-12:00  13:00-17:00">A:8:00-12:00  13:00-17:00　
									       <input class="rdchicun" type="radio" name="tag" id="wclass_description" value="B:9:00-12:00  13:00-18:00">B:9:00-12:00  13:00-18:00
									    </span>
									     <p><span id="two" hidden>
									     <input class="rdchicun" type="radio" name="tag" value="早：6:00—12:00 　13:00-14:30 　中：14:30-23:00 　晚：23:00-次日6:00">早：6:00—12:00 13:00-14:30　 中：14:30-23:00 　晚：23:00-次日6:00</span></p>
									    <span id="three" hidden>早：6:00-12:00  12:00-14:30  　 晚：14:30-23:00  　休：休息									 
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="A：6个早 3个休 6个晚 3个休" >A：6个早 3个休 6个晚 3个休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="B：3个休 6个晚 3个休 6个早" >B：3个休 6个晚 3个休 6个早</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="C：6个晚 3个休 6个早 3个休" >C：6个晚 3个休 6个早 3个休</span></p>
									    </span> 
									    <span id="four" hidden>早：8:00-12:00  12:00-20:00  　 晚：20:00-次日8:00									 
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description"  value="A：白 晚 休 休" >A：白 晚 休 休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="B：晚 休 休 白" >B：晚 休 休 白</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="C：休 白 晚 休" >C：休 白 晚 休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag" id="wclass_description" value="D：休 休 白 晚" >D：休 休 白 晚</span></p>
									     </span> 			
									</div>
								</div>
								
															
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label" style="margin-left: 15px;">班组人员：</label>
											<textarea placeholder="字数限制为200字" rows="8" cols="60" class="form-control" style="resize: none;width: 497px;margin-left: 15px;"" bindname="wclass_group" name="wclass_group" id="wclass_group1" maxlength="200" value=""></textarea>
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
						<a id="saveTrainer" class="btn btn-info" onclick="jacascript:addReset(workManageForm)">重置</a>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:WorkManageSubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
<!-- Modal模态框班制修改信息页面-->
		<div class="modal fade" id="editModal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<p id="userMessage" class="modal-title pmodal">班组排班的修改</p>
					</div>

					<!-- form 表单,制定input标签的bindname对应信息(collect.js)，并用bindData()方法绑定$("#form").bindData(row); -->

					<div class="modal-body">
					<form action="<%=path%>/module/system/workmanage/editandsave.do"
						name="editForm" id="editForm" method="post">
					  <input type="hidden" name="workmanage_id" id="workmanage_id" value="${WorkManage.workmanage_id }" bindname="workmanage_id" />
							<div class="row">
								
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">部门名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="wdepartment" id="wdepartment2" name="wdepartment" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 234px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div>
								
								
							    <div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label" style="margin-left:15px;">班组名称：</label> 
										<input type="text" placeholder="请输入文字" class="form-control modalinput" maxlength="10" bindname="wclass_name" id="wclass_name2" name="wclass_name" value="">															
									</div>
									<span class="redStar" style="display:block; float:left;margin-left: 249px;px;margin-bottom: -30px;margin-top: -38px;color: red;" ><font size="3">*</font></span>									
								</div> 																
								
															
								<div class="col-md-5 jiangemodal">
									<div class="form-group">
										<label for="field-1" class="control-label">班制名称：</label> 
										<select type="text" class="select" maxlength="10" bindname="wname" id="wname2" name="wname" style="height:26px; width:154px;">
										  <!-- <option value="">请选择</option> -->
										  <option value="正常班制">正常班制</option>
										  <option value="两班倒班制">两班倒班制</option>
										  <option value="三班倒班制">三班倒班制</option>
										  <option value="四班倒班制">四班倒班制</option>
										   
										</select>															
									</div>													
								</div>																
								
							    <div class="col-md-10 jiangemodal">
									<div class="form-group">
										<span id="one1">
										   <input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="A:8:00-12:00  13:00-17:00">A:8:00-12:00  13:00-17:00　
									       <input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="B:9:00-12:00  13:00-18:00">B:9:00-12:00  13:00-18:00
									    </span>
									     <p><span id="two1" hidden>
									     <input class="rdchicun" type="radio" name="tag1" value="早：6:00—12:00 　13:00-14:30 　中：14:30-23:00 　晚：23:00-次日6:00">早：6:00—12:00 13:00-14:30　 中：14:30-23:00 　晚：23:00-次日6:00</span></p>
									    <span id="three1" hidden>早：6:00-12:00  12:00-14:30  　 晚：14:30-23:00  　休：休息									 
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="A：6个早 3个休 6个晚 3个休" >A：6个早 3个休 6个晚 3个休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="B：3个休 6个晚 3个休 6个早" >B：3个休 6个晚 3个休 6个早</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="C：6个晚 3个休 6个早 3个休" >C：6个晚 3个休 6个早 3个休</span></p>
									    </span> 
									    <span id="four1" hidden>早：8:00-12:00  12:00-20:00  　 晚：20:00-次日8:00									 
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1"  value="A：白 晚 休 休" >A：白 晚 休 休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="B：晚 休 休 白" >B：晚 休 休 白</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="C：休 白 晚 休" >C：休 白 晚 休</span></p>
									     <p><span><input class="rdchicun" type="radio" name="tag1" id="wclass_description1" value="D：休 休 白 晚" >D：休 休 白 晚</span></p>
									     </span> 			
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-10 jiangemodal">
										<div class="form-group">
											<label for="field-1" class="control-label" style="margin-left: 15px;">班组人员：</label>
											<textarea placeholder="字数限制为200字" rows="8" cols="60" class="form-control" style="resize: none;width: 497px;margin-left: 15px;"" bindname="wclass_group" name="wclass_group" id="wclass_group2" maxlength="200" value=""></textarea>
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
						<button id="closeModal" type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
						<button id="closeModal" type="button" class="btn btn-success" onclick="javascript:updateSubmit();">保存</button>
					</div>
				</div>
			</div>
		</div>


   </section>
</section>

</body>
</html>