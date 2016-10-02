<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.BanTeam" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班组详细信息</title>
<script type="text/javascript"
src="<%=request.getContextPath()%>/module/system/banteam/banteam_Info.js"
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
							<form class="form" id="infoForm" name="infoForm" action=<%=request.getContextPath() + "/module/system/banteam.do"%> method="post">
								<div><input type="hidden"  bindname="banteam_id" id="banteam_id" name="banteam_id"/></div>
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 班组详细信息维护
									</p>
								</div></br></br>
							<table class="table tb">								
							  <tr>
								 <td>
									 <label>部门名称：</label> 
                                     <input type="text" bindname="ban_department" name="ban_department" id="ban_department3" value="">									
								 </td>
								 	
								  <td>
									<label>班组名称：</label> 
									<input type="text" bindname="ban_name" name="ban_name" id="ban_name3" value="">
								  </td>								
							</tr></br>
							<tr>
								<td>
								 <label>班组人员：</label> 
								     <textarea style="height: 80px;position: relative;top: 35px; width: 220px;outline: none;padding-left: 5px;resize: none;" type="text" bindname="ban_group" name="ban_group" id="ban_group3" value="">
								</textarea>
								</td><td></td><td></td>
							</tr>

							</table>
						</form>
					</div>

				</div>
			</div>
  </section>
  </section>

</html>