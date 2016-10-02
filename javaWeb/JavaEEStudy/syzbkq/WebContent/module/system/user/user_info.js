$(document).ready(function() {
	
	//$("#userForm").submit();
	
	// 绑定数据字典
	$("select[dataStore]").each(function(){
		var id = $(this).attr('id'); 
		if(document.getElementById(id)){
			var data = eval(document.getElementById(id).dataStore);
			if(data && data.items.length > 0){
				$.each(data.items,function(i,item){ 
			         $("<option value='"+item.codevalue+"'>"+item.codename+"</option>").appendTo("#"+id); 
			    });
			}
		}
	});
	
	if ($("#userId").val() != "") {
		$("#loginname").attr("readonly", "readonly");
		$("#loginname").css("color", "gray");
		var roleId = $("#userRoleId").val();
		if (roleId != "") {
			$("#roleId").val(roleId);
		}
		
		$("#userorgid").val($("#userOrgId").val());
		$("#userdeptid").val($("#userDeptId").val());
		$("#userlevel").val($("#personLevel").val());
	}
	
}); 

function userInfoSubmit(dialogItself){
	
	//提交修改表单
	//$("#userForm").submit();
	
	var formDatas = $("#userForm").collect();
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(formDatas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/user/save.do",
		success : function(data) {
			
			if(data.flag = 1){
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				
				BootstrapDialog.show({
		            message: '添加用户成功!',
	        		onhidden: function(dialogRef){
	        	        //alert('对话框已经关闭');
	        			dialogItself.close();
	        			document.location.reload();
	        	    }
		        });
				
			}else{
				alert("添加数据失败," + data );
			}
		},
		error : function(data) {
			alert("error" + data.msg);
		}
	});
}

function checkInfo() {
	if ($("#loginname").val() == "") {
		alert("请输入用户名!");
		$("#loginname").focus();
		return false;
	}
	if ($("#userId").val() == "" && $("#password").val() == "") {//新增
		alert("请输入密码!");
		$("#password").focus();
		return false;
	}
	if ($("#password").val() != $("#chkpwd").val()) {
		alert("确认密码与密码不一致!");
		$("#chkpwd").focus();
		return false;
	}
	if ($("#username").val() == "") {
		alert("请输入姓名!");
		$("#username").focus();
		return false;
	}
	
	if($("#userorgid").val() == ""){
		alert("请选择用户所属机构!");
		$("#userorgid").focus();
		return false;
	}
	
	if($("#userdeptid").val() == ""){
		alert("请选择用户所属部门!");
		$("#userdeptid").focus();
		return false;
	}
	
	if($("#userlevel").val() == ""){
		alert("请选择人员类别！");
		$("#userlevel").focus();
		return false;
	}
	
	return true;
}

function success() {
	if (dg.curWin.document.forms[0]) {
		dg.curWin.document.forms[0].action = dg.curWin.location + "";
		dg.curWin.document.forms[0].submit();
	} else {
		dg.curWin.location.reload();
	}
	dg.cancel();
}

function failed() {
	alert("新增失败，该用户名已存在！");
	$("#loginname").select();
	$("#loginname").focus();
}