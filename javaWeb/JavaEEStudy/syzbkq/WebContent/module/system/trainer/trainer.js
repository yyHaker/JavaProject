
/**
 * 用戶列表查詢
 */
function searchTrainer(){
	document.getElementById("searchForm").sumbit;
}
/**
 * 用戶個人信息查詢
 * @param employeenum
 */
function trainerInfo(employeenum){
	var datas = [{
		"employeenum" : employeenum 
	}];

	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/trainer/trainerInfo.do",
		success : function(data) {
			
			var obj = jQuery.parseJSON(data);
			if(obj.flag = 1){				
				$("#infoForm").bindData(obj.data);
				$('#infoModal').modal('show').css({ top: '10%' });
				
			}else{
				alert("获取数据失败," + data );
			}
		},
		error : function(data) {
			alert("success:" + data.msg);
		}
	});
}

/**
 * 刪除功能
 * @param userId
 */
function delUser(userId) {
	if (confirm("确定要删除该记录？")) {
		var url = "trainer/delete.do?employeenum=" + userId;
		$.get(url, function(data) {
			if (data == "success") {
				document.location.reload();
			}
		});
	}
}

$(document).ready(function() {
	
	//模态框表单提交按钮绑定事件
	$("#saveTrainer").click(function(){
		saveTrainer();
	});
	
	$("#closeModal").click(function(){
		document.location.reload();
	});
	
});

function saveTrainer(){
	
	//收集表单信息
	var formDatas = $("#editForm").collect();
	
	
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(formDatas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/trainer/updatesave.do",
		success : function(data) {
			//var obj = jQuery.parseJSON(data);
			if(data.flag = 1){
				//alert(data);	
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				BootstrapDialog.show({
		            message: '修改用户成功!'
		        });
				document.location.reload();
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
 * 修改内训师信息
 * 
 * @param employeenum
 */
function selectTrainer(employeenum) {

	//testAjax(employeenum);
	selectAjax(employeenum);
}

function selectAjax(employeenum) {
	
	//alert(1);
	
	var datas = [ {
		"employeenum":employeenum
	}];
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/trainer/selectAjax.do",
		success : function(data) {
			//alert(2);
			////解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);
			if(obj.flag = 1){
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				
				$("#editForm").bindData(obj.data);
				
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

