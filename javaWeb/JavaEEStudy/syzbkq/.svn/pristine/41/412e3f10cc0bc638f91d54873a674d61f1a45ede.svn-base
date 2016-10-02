page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1// 总页数，默认1页
};

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchQuarters();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchQuarters();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchQuarters();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchQuarters();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchQuarters();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchQuarters();
	}
}

$(document).ready(function() {

	// 加载分页模板
	$('.pageDiv').load(path + '/module/common/page.jsp');
	// 查询列表渲染列表页面
	searchQuarters();

	//模态框表单提交按钮绑定事件
	$("#saveAttendance").click(function(){
		saveAttendance();
	});	
	$("#closeModal").click(function(){
		window.close();
		$("#x2").hide();
		$("#x").hide();
	});	
	
	$(".close").click(function(){
		$("#x2").hide();
		$("#x").hide();
	});

	
	$("#pname1").blur(function(){
		  var name = $("#pname1").val();
		  console.log(name);
		  if($.trim(name)=== ''){
			  $("#x2").show();
			  $("#pname1").addClass("warn");
		}

		});
		$("#pname1").focus(function(){
			  $("#x2").hide();
			  $("#pname1").removeClass("warn");
		});
		
		$("#pname2").blur(function(){
			  var name = $("#pname2").val();
			  console.log(name);
			  if($.trim(name)=== ''){
				  $("#x").show();
				  $("#pname2").addClass("warn");
			}

			});
			$("#pname2").focus(function(){
				  $("#x").hide();
				  $("#pname2").removeClass("warn");
			});
	
});

var boxlist={};
function searchQuarters() {
	// 收集表单信息
	var searchQuartersForm = $("#searchQuartersForm").collect();

	// 分页信息
	searchQuartersForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchQuartersForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/quarters/searchQuartersList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			boxlist=jsonData;
			// 加载列表数据
			var tpl = document.getElementById('quartersHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.quartersArea').html(render);
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

function addQuarters() {
	$('#addQuartersModal').modal({
		backdrop : 'static'
	});
	$('#addQuartersModal').modal('show').css( {top :'10%'});
}

function quartersInfoSubmit() {
	// 提交修改表单
	var formDatas = $("#quartersForm").collect();
	
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(formDatas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/quarters/insert.do",
		success : function(data) {
			var obj=$.parseJSON(data);
			if (obj.flag == "1") {
				// data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				BootstrapDialog.show({
					title : '提示信息',
					message : '添加岗位成功!(两秒后自动关闭)',
					closable : true
				});
				setTimeout(function() {
					BootstrapDialog.closeAll();
					document.location.reload();
				}, 2000);
			} else {
				alert("添加数据失败," + obj);
			}
		},
		error:function(data){
			BootstrapDialog.alert("必填项不能为空");
		}
	});
}

function getQuarters(index) {
	$("#editModal").bindData(boxlist.data[index]);
	$('#editModal').modal('show').css({ top: '10%' });
}

function updateQuarters() {

	var formDatas = $("#editForm").collect();
	
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(formDatas),
		type : "POST",
		dataType : 'JSON',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/quarters/update.do",
		success : function(data) {
			// //解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);
			if (obj.flag == "1") {
				BootstrapDialog.show({
					title:'提示',
		            message: '修改岗位成功!(两秒后提示消失)'
		        });setTimeout(function(){
					BootstrapDialog.closeAll();
					document.location.reload();
				},2000);
			}
		},
		error : function(data) {
			BootstrapDialog.alert("必填项不能为空");
		}
	});
}

function quartersInfo(pid){
	var datas={"pid":pid};
	$.ajax({
		data:JSON.stringify(datas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/quarters/getQuartersById.do",
		success:function(data){
			var jsonData = $.parseJSON(data);
			sessionStorage.cc=data;
			
			var obj = jQuery.parseJSON(sessionStorage.cc);
			//alert(obj.data);
			console.log(obj.data);
			console.log(jsonData.data);
			
			window.location.href="quarters/quarters_info.jsp"
			if(jsonData.flag=="1"){
				$("#infoForm").bindData(jsonData.data);
				$('#infoModal').modal({backdrop:'static'});
			}
			else{
				BootstrapDialog.confirm("获取数据失败");
			}
		},
		error  :function(data){
			BootstrapDialog.confirm("获取数据失败"+data.msg);
		}
	});
}

function deleteQuarters(pid) {
	BootstrapDialog.confirm('确认删除当前选中的记录吗?', function(result){
		if(result) {
		var url = "quarters/delete.do?pid=" + pid;
		$.get(url, function(data) {
			if (data == "success") {
				document.location.reload();
			}
		});
	}
	});
}

