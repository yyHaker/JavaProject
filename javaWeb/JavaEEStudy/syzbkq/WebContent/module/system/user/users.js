$(document).ready(function() {
	
	//初始化下拉框
	initSelect();
	
	//模态框表单提交按钮绑定事件
	$("#saveUser").click(function(){
		saveUser();
	});
	
	$("#closeModal").click(function(){
		document.location.reload();
	});
	
});

/**
 * 初始化下拉列表信息,ajax交互获取信息并写入table,这里展示mutipleSelect插件使用方法
 */
function initSelect() {
	
	//这里用ajax交互获取数组对象字符串后,初始化到对应form表单中mutiple的select组件中
	
	//机构
	var orgDatas = [{"code":"96411b82-5dc1-474b-898f-f9c6636ab303","value":"沈阳分部"}];
	$('#userorgid').multipleSelect({width:'100%',single : true});
	$('#userorgid').multipleSelect("appendJson", orgDatas);
	
	//部门
	var deptDatas = [{"code":"eb76f24a-f81d-4662-a352-401b85ce6365","value":"开发二部"}];
	$('#userdeptid').multipleSelect({width:'100%',single: true});
	$('#userdeptid').multipleSelect("appendJson", deptDatas);
	
	
	//权限
	var roleDatas = [{"code":1,"value":"系统管理员1"},{"code":2,"value":"普通用户"}];
	$('#roleId').multipleSelect({width:'100%',single: true});
	$('#roleId').multipleSelect("appendJson", roleDatas);
	
}

function saveUser(){
	
	//收集表单信息
	var formDatas = $("#form").collect();
	
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
		            message: '修改用户成功!'
		        });
				
				//document.location.reload();
				
			}else{
				alert("修改数据失败," + data );
			}
		},
		error : function(data) {
			alert("error" + data.msg);
		}
	});
}

/**
 * ajax交互数据测试(根据userId查询表单数据,并绑定数据到form表单),并使用bootstrap模态框显示数据
 * 
 * @param userId
 */
function testAjax(userId) {
	
	var datas = [ {
		"userId" : userId, // 这里写入json对象传入后台
		"username" : "刘佳",
		"goods" : [ {
			"goodsId" : "1"
		}, {
			"goodsId" : "2"
		}, {
			"goodsId" : "3"
		} ]
	}];
	
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/user/testAjax.do",
		success : function(data) {
			
			////解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);
			if(obj.flag = 1){
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				
				$("#form").bindData(obj.data);
				
				//bootstrap的模态框(modal),jquery控制显示,且可控制css样式如下：
				$('#editModal').modal('show').css({ top: '10%' });
				
			}else{
				alert("获取数据失败," + data );
			}
		},
		error : function(data) {
			alert("success:" + data.msg);
		}
	});
}

// BootstrapDialog弹出层方法展示
function addUser() {
	BootstrapDialog.show({
		title: '添加用户',
		message: $('<div></div>').load('user/add.do'),
        buttons: [{
            label: '重置',
            cssClass: 'btn-primary',
            action: function(){
                alert('Hi!点击这里重置表单信息');
            }
        },{
            label: '添加',
            action: function(dialogItself){ // 这里参数为窗体obj
            	//直接写dialog弹出页面的方法即可调用
            	userInfoSubmit(dialogItself);
            }
        }]
    });
	
}

/**
 * 修改用户信息
 * 
 * @param userId
 */
function editUser(userId) {
	testAjax(userId);
}

function delUser(userId) {
	if (confirm("确定要删除该记录？")) {
		var url = "user/delete.do?userId=" + userId;
		$.get(url, function(data) {
			if (data == "success") {
				document.location.reload();
			}
		});
	}
}

function search() {
	$("#userForm").submit();
}
