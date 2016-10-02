<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.entity.baseinfo.Quarters" %>
<%@ include file="/module/common/config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位详细信息</title>
<script type="text/javascript"
src="<%=request.getContextPath()%>/module/system/quarters/quarters_info.js"
	charset="UTF-8">  
</script>
</head>
<body>


	<section id="main-content"> 
		<section class="wrapper">
			<div class="row mt">
				<div class="col-md-12" id="delpath">
						<div>
							<form class="form" id="infoForm" name="infoForm" action=<%=request.getContextPath() + "/module/system/getQuartersById.do"%> method="post">
								<div><input type="hidden"  bindname="pid" id="pid3" name="pid"/></div>
								<div class="top">
									<p class="thick">
										<i class="fa fa-bookmark"></i> 岗位详细信息维护
									</p>
								</div></br></br>
							<table class="table tb">								
							  <tr>
								 <td>
									 <label>岗位名称：</label> 
                                     <input type="text" bindname="pname" name="pname" id="pname3" value="" Disabled>									
								 </td>
								 <td>
									 <label>岗位描述：</label> 
									 <input type="text" bindname="pdescribe" name="pdescribe" id="pdescribe3" value="" Disabled>
								  </td>	
						
							</tr></br>

							</table>
						</form>
					</div>

				</div>
			</div>
  </section>
  </section>
</body>
</html>