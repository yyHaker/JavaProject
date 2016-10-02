page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchOvertime();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchOvertime();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchOvertime();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchOvertime();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchOvertime();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchOvertime();
	}
}

$(document).ready(function(){
	//引入时间控件
	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd',
		autoclose:true,
		language : 'zh-CN',
		minView : 2
	})
	//加载分页模板
	$('.pageDiv').load(path+'/module/common/page.jsp');
	searchOvertime();
	//全选和反选
	$('#selectall').click(function(){
		$(".box-items").each(function(){
			$(this).prop("checked",!!$("#selectall").prop("checked"));
		});
	});
	//模态框关闭的方法
	$("#closeModal").click(function(){
		window.close();
	});
})
//重置
function addReset(){
	$("#rejectForm")[0].reset();
}

function searchOvertime(){
	var searchForm = $("#searchOvertimeForm").collect();//收集表单信息
	searchForm.page=page;//分页信息
	
	$.ajax({
		data:JSON.stringify(searchForm),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/approval/searchOvertimeList.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('OvertimeHtml').innerHTML;
			laytpl(tpl).render(jsonData,function(render){
				$('.OvertimeArea').html(render);
				pageInfo(jsonData);
			});	
		},
		error:function(data){
			BootstrapDialog.alert("error" + data.msg);
		}
	});
}

//更改加班申请的审批状态(同意)
function updateApproval(){
	//把所有的state封装到一个list集合中
	state={list:[]};
	//对每一个checkbox中的审批状态进行遍历
	$('input:checkbox[name=box]:checked').each(function(){
		state.list.push({state:$(this).attr("data-state")});
	});
	for(var i=0;i<state.list.length;i++)
	{
		dataList1=state.list[i];
		if(dataList1.state!=="未审批"){
			BootstrapDialog.alert("您选择的数据项中已经含审批过的数据，请选择待审批的数据进行审批");
			return false;
		}
	}
	if($('input:checkbox[name=box]:checked').length==0){
		BootstrapDialog.alert("您没有选择，请选择待审批的数据");
		return false;
	}	
	else{
		//声明参数，参数可以是一条也可以是多条，多以list集合来装
		overtime_id={list:[]};

		$('input:checkbox[name=box]:checked').each(function(i){
			overtime_id.list.push({overtime_id:$(this).attr("data-overtime_id")});
		});
		$.ajax({
			data:JSON.stringify(overtime_id),
			type:"POST",
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			url : path + "/module/system/approval/updateApproval.do",
			success:function(data){
				var jsonData = $.parseJSON(data);
				if(jsonData.flag=="1")
					{
					BootstrapDialog.show({
						title:"提示信息",
						message:"加班审批成功！(两秒后自动审批)",
						closable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
					}
				
			},error:function(data){
				BootstrapDialog.confirm("加班审批失败"+data.msg);
			}
		});
	}
}

//加班审批驳回
function ApprovalN(){
	//把所有的state封装到一个list集合中
	state={list:[]};
	//对每一个checkbox中的审批状态进行遍历
	$('input:checkbox[name=box]:checked').each(function(){
		state.list.push({state:$(this).attr("data-state")});
	});
	for(var i=0;i<state.list.length;i++)
	{
		dataList1=state.list[i];
		if(dataList1.state!=="未审批"){
			BootstrapDialog.alert("您选择的数据项中已经含审批过的数据，请选择待审批的数据进行审批");
			return false;
		}
	}
	if($('input:checkbox[name=box]:checked').length==0){
		BootstrapDialog.alert("您没有选择，请选择待审批的数据");
		return false;
	}
	else{
		$("#updateModal").modal('show').css({top:'10%'});
	}		
}
function rejectApproval(){
	if($("#reject_reason-update").val()==""){
		   BootstrapDialog.confirm("驳回原因不能为空");
		   return false;
	}
	else{
		//声明参数，参数可以是一条也可以是多条，多以list集合来装
		overtime_id={list:[]};
		//var reject_reason=$("#reject_reason-update").val();	
		$('input:checkbox[name=box]:checked').each(function(i){
			overtime_id.list.push({overtime_id:$(this).attr("data-overtime_id"),approver:$("#approver").val(),reject_reason:$("#reject_reason-update").val()});
		});
		
		$.ajax({
			data:JSON.stringify(overtime_id),
			type:"POST",
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			url : path + "/module/system/approval/rejectApproval.do",
			success:function(data){
				var jsonData = $.parseJSON(data);
				if(jsonData.flag=="1")
					{
					BootstrapDialog.show({
						title:"提示信息",
						message:"加班驳回成功！",
						closable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
					}
				
			},error:function(data){
				BootstrapDialog.confirm("加班驳回失败"+data.msg);
			}
		});
	}
}

