page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchVacation();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchVacation();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchVacation();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchVacation();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchVacation();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchVacation();
	}
}

/**
 * 假期基本信息列表查詢
 */
function searchVacation() {
	// 收集表单信息
	var searchForm = $("#searchForm").collect();
	// console.log(searchForm);
	// 分页信息
	searchForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/vacation/searchVacationList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			// console.log(jsonData);
			// 加载列表数据
			var tpl = document.getElementById('vacationHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.vacationArea').html(render);
				// 分页模板数据整理方法,在/module/common/page2.jsp页面引入的
				// 如：点击【尾页】时，“第几页”的输入域会修改为最后一页的页码
				pageInfo(jsonData);
			});
		},
		error : function(data) {
			BootstrapDialog.alert("success" + data.msg);
		}
	});
}

$(document).ready(function() {
	// 加载分页模板
	$('.pageDiv').load(path + '/module/common/page.jsp');
	// 查询列表渲染列表页面
	searchVacation();

	// 模态框表单提交按钮绑定事件
	$("#saveVacation").click(function() {
		saveVacation();
	});
	$("#closeModal").click(function() {
		window.close();
	});

});

function vacationInfo(vacationid){
	var datas = [{
		"vacationid" : vacationid 
	}];

	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/vacation/searchVacationInfo.do",
		success : function(data) {
			
			var obj = jQuery.parseJSON(data);
			if(obj.flag == "1"){				
				$("#infoForm").bindData(obj.data);
				$('#infoModal').modal({backdrop:'static'});
				$('#infoModal').modal('show').css({ top: '10%' });
				if ($("#status").val() == "1") {
					$("#status").val("有效");
				} else {
					$("#status").val("无效");
				}
			}else{
				alert("获取数据失败," + data );
			}
		},
		error : function(data) {
			BootstrapDialog.alert("success:" + data.msg);
		}
	});
}


/**
 * 修改假期信息
 * 
 * @param employeenum
 */
function selectVacation(vacationId) {
	// testAjax(employeenum);
	selectAjax(vacationId);
}

function selectAjax(vacationId) {

	var datas = [ {
		"vacationId" : vacationId
	} ];
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'JSON',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/vacation/searchVacationInfo.do",
		success : function(data) {

			// //解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);

			if (obj.flag == "1") {
				// data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson

				$("#editForm").bindData(obj.data);
				$('#editModal').modal({backdrop:'static'});
				$('#editModal').modal('show').css({ top: '10%' });
				$("#vtype").val(obj.data.vacationType);
				$("#vstatus").val(obj.data.vacationStatus);
				$("#vname").val(obj.data.vacationName);
				$("#vexplain").val(obj.data.vacationExplain);
				// bootstrap的模态框(modal),jquery控制显示,且可控制css样式如下：
				
			} else {
				alert("获取数据失败," + data);
			}
		},
		error : function(data) {
			BootstrapDialog.alert("success:" + data.msg);
		}
	});
}

function saveVacation(){
	if ($("#vname").val() == "") {
		BootstrapDialog.alert("假期名称不能为空！");
		return false;
	} else if ($("#vtype").val() == "") {
		BootstrapDialog.alert("假期类型不能为空！");
		return false;
	} else if ($("#vstatus").val() == "") {
		BootstrapDialog.alert("是否有效不能为空！");
		return false;
	} else if ($("#vexplain").val() == "") {
		BootstrapDialog.alert("假期说明不能为空！");
		return false;
	} else {
		//收集表单信息
		var formDatas = $("#editForm").collect();
		
		// ajax异步调用springMVC的controller
		$.ajax({
			data : JSON.stringify(formDatas),
			type : "POST",
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/vacation/updatVacation.do",
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if(obj.flag === "1"){
					//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
					BootstrapDialog.show({
						title:'提示信息',
			            message: '修改假期信息成功!(两秒后自动关闭)',
			            closable:true
					});
					setTimeout(function()
					{
						BootstrapDialog.closeAll();   
						document.location.reload();
					}, 2000);	 
				}else{ 

										alert("修改数据失败," + data);
				}
			},
			error : function(data) {
				BootstrapDialog.alert("error" + data.msg);
			}
		});
	}
}

// 新增假期模态窗口弹出层方法
function addVacation() {
	$('#addModal').modal({ backdrop : 'static'});
	$('#addModal').modal('show').css({ top: '10%' });
}

// 重置方法
function addReset() {
	$('#vacationForm')[0].reset();
	BootstrapDialog.alert('重置成功！');
}
// 添加按钮方法
function vacationInfoSubmit() {
	if ($("#vacationname").val() == "") {
		BootstrapDialog.alert("假期名称不能为空！");
		return false;
	} else if ($("#vacationtype").val() == "") {
		BootstrapDialog.alert("假期类型不能为空！");
		return false;
	} else if ($("#vacationstatus").val() == "") {
		BootstrapDialog.alert("是否有效不能为空！");
		return false;
	} else if ($("#vacationexplain").val() == "") {
		BootstrapDialog.alert("假期说明不能为空！");
		return false;
	} else {
		// 提交修改表单
		var formDatas = $("#vacationForm").collect();
		// ajax异步调用springMVC的controller
		$.ajax({
			data : JSON.stringify(formDatas),
			type : "POST",
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/vacation/save.do",
			success : function(data) {
				/* alert(data); */
				if (data.flag === "1") {
					// data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
					BootstrapDialog.show({
						title : '提示信息',
						message : '添加假期成功!(两秒后自动关闭)',
						closable : true
					});
					setTimeout(function() {
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
				} else {
					alert("添加数据失败," + data);

				}
			}
		});
	}
}
