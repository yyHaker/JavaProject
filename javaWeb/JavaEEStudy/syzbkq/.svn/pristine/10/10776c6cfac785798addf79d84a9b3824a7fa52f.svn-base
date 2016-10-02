<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.ClassManage" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班制详细信息</title>
<script type="text/javascript"
src="<%=request.getContextPath()%>/module/system/classManage/classMange_Info.js"
	charset="UTF-8">  
</script>
</head>
<body>

</body>
	<section id="main-content"> 
		<section class="wrapper">
			<div class="row mt">
				<div class="col-md-12" id="delpath">
						<div>
							<form class="form" id="infoForm" name="infoForm" action=<%=request.getContextPath() + "/module/system/classManage.do"%> method="post">
								<div><input type="hidden"  bindname="class_system_id" id="class_system_id" name="class_system_id"/></div>
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 班制详细信息维护
									</p>
								</div></br></br>
							<table class="table tb">								
							  <tr>
								 <td>
									 <label>部门名称：</label> 
                                     <input type="text" bindname="department" name="department" id="department2" value="">									
								 </td>
								 <td>
									 <label>班制名称：</label> 
									 <input type="text" bindname="name" name="name" id="name2" value="">
								  </td>	
								  <td>
									<label>班组名称：</label> 
									<input type="text" bindname="class_name" name="class_name" id="class_name2" value="">
								  </td>								
							</tr></br>
							<tr>
								<td>
								 <label>班制说明：</label> 
								     <textarea style="height: 80px;position: relative;top: 35px; width: 220px;outline: none;padding-left: 5px;resize: none;" type="text" bindname="class_description" name="class_description" id="class_description2" value="">
								 </textarea>
								</td>
								
								<td>
								 <label>班组人员：</label> 
								     <textarea style="height: 80px;position: relative;top: 35px; width: 220px;outline: none;padding-left: 5px;resize: none;" type="text" bindname="class_group" name="class_group" id="class_group2" value="">
								 </textarea>
								</td><td></td>
							</tr>

							</table>
						</form>
					</div>

				</div>
			</div>
  </section>
  </section>

</html>