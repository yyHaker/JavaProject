page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchDeparture();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchDeparture();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchDeparture();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchDeparture();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchDeparture();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchDeparture();
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
	searchDeparture();
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

function searchDeparture(){
	var searchForm = $("#searchDepartureForm").collect();//收集表单信息
	searchForm.page=page;//分页信息
	
	$.ajax({
		data:JSON.stringify(searchForm),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/departure/searchDepartureList.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('DepartureHtml').innerHTML;
			laytpl(tpl).render(jsonData,function(render){
				$('.DepartureArea').html(render);
				pageInfo(jsonData);
			});
			
		},
		error:function(data){
			BootstrapDialog.alert("success" + data.msg);
		}
	});
}

//点击按钮弹出模态框，用以添加离岗申请
function insert(){
	$("#addModal").modal('show').css({top:'10%'});
}
//添加前做一下必填的判断
function departureSubmit(){
	if($("#departure_name1").val()==""){
	   BootstrapDialog.confirm("离岗申请人不能为空");
	   return false;
	}
	else if($("#departure_department1").val()==""){
	   BootstrapDialog.confirm("所在部门不能为空");
	   return false;
	}
	else if($("#departure_group1").val()==""){
		   BootstrapDialog.confirm("班组不能为空");
		   return false;
		}
	else if($("#departure_class1").val()==""){
		   BootstrapDialog.confirm("班制不能为空");
		   return false;
		}
	else if($("#departure_date1").val()==""){
		   BootstrapDialog.confirm("离岗时长不能为空");
		   return false;
		}
	else if($("#departure_time1").val()==""){
		   BootstrapDialog.confirm("离岗申请时间不能为空");
		   return false;
		}
	else if($("#departure_reason1").val()==""){
		   BootstrapDialog.confirm("离岗原因不能为空");
		   return false;
		}
	else{
		//alert(0);
		departureInsert();
	}		
}
function departureInsert(){
	var formdate=$("#departureForm").collect();
	$.ajax({
		data:JSON.stringify(formdate),
		type:"POST",
		dataType:'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/departure/insertDeparture.do",
		success:function(data){
			console.log(data);
		var jsonData = $.parseJSON(data);
		    console.log(jsonData);
		    if(jsonData.flag=="1")
		    	{
		    	BootstrapDialog.show({
		    		title:"提示信息",
		    		message:"离岗申请成功，请等待审批！(两秒后自动关闭)",
		    		closable:true
		    	});
		    	setTimeout(function(){
		    		BootstrapDialog.closeAll();
		    		document.location.reload();
		    	},2000);
		    	}
		},
		error:function(data){
			BootstrapDialog.confirm("error"+data.msg);
		}
	});
}
//重置
function addReset(){
	$("#departureForm")[0].reset();
}
//更改离岗申请的审批状态
function updateDeparture(){
	//把所有的departure_status封装到一个list集合中
	departure_status={list:[]};
	//对每一个checkbox中的审批状态进行遍历
	$('input:checkbox[name=box]:checked').each(function(){
		departure_status.list.push({departure_status:$(this).attr("data-departure_status")});
	});
	console.log(departure_status);
	for(var i=0;i<departure_status.list.length;i++)
		{
		dataList1=departure_status.list[i];
		//把对数据的判断拿到循环中，这样的话就会避免再循环外每次都拿循环后的最后一个结果进行比较
		if(dataList1.departure_status==="2"){
			BootstrapDialog.alert("您选择的数据项中已经含审批过的数据，请选择待审批的数据进行审批");
			return false;
		}
		}
	
	if($('input:checkbox[name=box]:checked').length==0){
		BootstrapDialog.alert("您没有选择，请选择待审批的数据");
		return false;
		}
	    else{
		//声明参数，参数可以是一条也可以是多条，多以勇哥list集合来装
		ID={list:[]};
	    
		$('input:checkbox[name=box]:checked').each(function(i){
			ID.list.push({ID:$(this).attr("data-ID")});
		});
		$.ajax({
			data:JSON.stringify(ID),
			type:"POST",
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			url : path + "/module/system/departure/updateStatus.do",
			success:function(data){
				var jsonData = $.parseJSON(data);
				if(jsonData.flag=="1")
					{
					BootstrapDialog.show({
						title:"提示信息",
						message:"离岗审批成功！(两秒后自动关闭)",
						closable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
					}
				
			},error:function(data){
				BootstrapDialog.confirm("离岗审批失败"+data.msg);
			}
		});
	}
}