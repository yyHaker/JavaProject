<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/module/common/config.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Form表单样例</title>

<script type="text/javascript">
	$(document).ready(function(){
		$("#insert").click(function(){post("insertSelective");});
		$("#select").click(function(){post("select");});
		$("#update").click(function(){post("updateByPrimaryKeySelective");});
		$("#delete").click(function(){post("delete");});
		$("[name='gender']").bootstrapSwitch({
			onText:'是',  
            offText:'否',
            size:'normal',
            onColor:'success',
            offColor:'warning'
            /* onSwitchChange: */
		});
	});
	
	function post(method){
		var ds = new DataStore();
		var formInfo = $("#form").collect();
		ds.setRowSet(formInfo);
		ds.setRowSetName("com.neusoft.web.user.vo.User");
		ds.setRowStatus(method);
		
		var hs = new HttpService();
		hs.setData(ds.toData());
		if(method == "insertSelective"){
			hs.setSuccess(function(){alert("添加成功")});
			
			hs.setErrorCallback(function(e) {
				alert(e.responseText + "添加异常")
			});
		} else if (method == "updateByPrimaryKeySelective") {
			hs.setSuccess(function() {
				alert("修改成功")
			});
			hs.setErrorCallback(function() {
				alert("修改异常")
			});
		}

		hs.post();
	}
</script>
</head>
<body>
	<h1 class="text-center">Form表单样例</h1>
	<form id="form" class="form-horizontal">
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">名称</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="请输入名称">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-4 control-label">Email</label>
			<div class="col-sm-2">
				<input type="email" class="form-control" id="email" name="email" placeholder="请输入Email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-4 control-label">Password</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">出生日期</label>
			<div class="col-sm-2">
			<div class="input-group date form_date">
			    <input class="form-control" size="16" type="text" value="" readonly>
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          	</div>
          	</div>
        </div>
        
        <div class="form-group">
			<label for="dtp_input2" class="col-sm-4 control-label">性别</label>
			<div class="col-sm-2">
			<div class="input-group date form_date"  data-link-field="dtp_input2">
			    <input class="form-control" size="16" type="text" value="" readonly>
			    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
          	</div>
          	</div>
			<input type="hidden" id="dtp_input2" value="" /><br/>
        </div>

		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-9">
			<label class="checkbox-inline"> 
			<input type="checkbox" id="checkbox1"  value="option1"> 选项 1 </label> 
			<label class="checkbox-inline"> 
			<input type="checkbox" id="checkbox2"  value="option2"> 选项 2 </label> 
			<label class="checkbox-inline"> 
			<input type="checkbox" id="checkbox3"  value="option3"> 选项 3 </label> 
			<label class="checkbox-inline"> 
			<input type="radio" name="gender" id="radios1" value="1" checked> 男 </label> 
			<label class="checkbox-inline"> 
			<input type="radio" name="gender" id="radios2" value="2"> 女</label>
			</div>
		</div>
		
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">年龄</label>
			<div class="col-sm-2">
				<select id="select1" name="age" class="form-control">
				   <option>1</option>
				   <option>2</option>
				   <option>3</option>
				   <option>4</option>
				   <option>5</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">可多选的选择列表</label>
			<div class="col-sm-2">
				<select id="select2"  multiple class="form-control">
				   <option>1</option>
				   <option>2</option>
				   <option>3</option>
				   <option>4</option>
				   <option>5</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">id</label>
			<div class="col-sm-2">
				<textarea class="form-control" id="text1" name="id" rows="3"></textarea>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button id="select" type="button" class="btn btn-default">查询</button>
				<button id="insert" type="button" class="btn btn-default">添加</button>
				<button id="update" type="button" class="btn btn-default">修改</button>
				<button id="delete" type="button" class="btn btn-default">删除</button>
			</div>
		</div>
	</form>
			<input type="checkbox" name="gender" checked>
			
<script type="text/javascript">
	$('.form_date').datetimepicker({
		format: 'yyyy-mm-dd',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
</script>

</body>
</html>