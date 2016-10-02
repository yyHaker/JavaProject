page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchDepartment();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchDepartment();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchDepartment();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchDepartment();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchDepartment();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchDepartment();
	}
}


$(document).ready(function(){
	// 加载分页模板
	$('.pageDiv').load(path + '/module/common/page.jsp');
	// 查询列表渲染列表页面
	searchDepartment();
	//模态框的关闭方法
	$("#closeModal").click(function(){
		window.close();
	});
});


function searchDepartment() {
	// 收集表单信息
	var searchDepartmentForm = $("#searchDepartmentForm").collect();
	// 分页信息
	searchDepartmentForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchDepartmentForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/department/searchDepartmentList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			
			// 加载列表数据
			var tpl = document.getElementById('departmentHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.departmentArea').html(render);
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
