page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1// 总页数，默认1页
};

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchAttendance();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchAttendance();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchAttendance();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchAttendance();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchAttendance();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchAttendance();
	}
}

$(document).ready(function() {

	// 加载分页模板
	$('.pageDiv').load(path + '/module/common/page.jsp');
	// 查询列表渲染列表页面
	searchAttendance();

	//模态框表单提交按钮绑定事件
	$("#saveAttendance").click(function(){
		saveAttendance();
	});	
	$("#closeModal").click(function(){
		window.close();
	});	
	
});

/**
 * 假期基本信息列表查詢
 */
function searchAttendance() {
	// 收集表单信息
	var searchAttendanceForm = $("#searchAttendanceForm").collect();

	// 分页信息
	searchAttendanceForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchAttendanceForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/attendance/searchAttendanceList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			// 加载列表数据
			var tpl = document.getElementById('attendanceHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.attendanceArea').html(render);
				// 分页模板数据整理方法,在/module/common/page2.jsp页面引入的
				// 如：点击【尾页】时，“第几页”的输入域会修改为最后一页的页码
				pageInfo(jsonData);
			});
		},
		error : function(data) {
			BootstrapDialog.alert("error" + data.msg);
		}
	});
}

//时间控件
$(document).ready(function() {
	
	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd',
		autoclose:true,
		todayBtn: true,
		language : 'zh-CN',
		minView : 2
	});	
});

function saveAttendance(){	
	var myDate = new Date();
	var myday=myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();//获取当前日期
	var day = new Date(myday.replace(/\-/gi,"/")).getTime();
	var createtime = new Date($("#createtime_update").val().replace(/\-/gi,"/")).getTime();
	/*
	if($("#telephone_update").val()==""){
		BootstrapDialog.alert("电话不能为空！");
		return false;
	}
	
	else if($("#mobiletelephone_update").val()==""){
		BootstrapDialog.alert("移动电话不能为空！");
		return false;
	}
	else */if($("#activity_update").val()==""){
		BootstrapDialog.alert("卡状态不能为空！");
		return false;
	}
	
	else if($("#createtime_update").val()==""){
		BootstrapDialog.alert("登记日期不能为空！");
		return false;
	}
	else if(createtime>day){
		BootstrapDialog.alert("登记日期不能大于当前日期！");
		return false;
	}
	else{	
	//收集表单信息
	var formDatas = $("#editForm").collect();	
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(formDatas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/attendance/updatAttendance.do",
		success : function(data) {
			//var obj = jQuery.parseJSON(data);
			if(data.flag = 1){
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				BootstrapDialog.show({
					title:'提示信息',
		            message: '修改考勤信息成功!(两秒后自动关闭)',
		            closable:true
				});
				setTimeout(function()
				{
					BootstrapDialog.closeAll();   
					document.location.reload();
				}, 2000);	 
			}else{ 
				alert("修改数据失败," + data );
			}
		},
		error : function(data) {
			BootstrapDialog.alert("error" + data.msg);
		}
	});
}
}


/**
 * 修改考勤信息
 * 
 * @param userid
 */
function modiAttendance(userid) {
	
	var datas = [ {
		"userid":userid
	}];
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'JSON',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/attendance/searchAttendanceInfo.do",
		success : function(data) {
			////解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);
			
			if(obj.flag = 1){
				//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson				
				$("#editForm").bindData(obj.data);			
				//bootstrap的模态框(modal),jquery控制显示,且可控制css样式如下：
				//$('#editModal').modal('show').css({ top: '10%' });
				$('#editModal').modal('show').css({top:'10%'});
				
			}else{
				alert("获取数据失败," + data );
			}
		},
		error : function(data) {
			BootstrapDialog.alert("error:" + data.msg);
		}
	});
}