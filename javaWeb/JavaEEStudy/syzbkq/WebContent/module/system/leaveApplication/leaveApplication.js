page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchLeave();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchLeave();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchLeave();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchLeave();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchLeave();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchLeave();
	}
}

$(document).ready(function(){
	//加入时间控件
	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd hh:ii:ss',
		autoclose:true,
		language : 'zh-CN',
		minView : 2
	})
	// 加载分页模板
	$('.pageDiv').load(path + '/module/common/page.jsp');
	// 查询列表渲染列表页面
	searchLeave();
	
	
	//点击假期名字能显示相对应的假期说明,必须写在加载模板里边
	$("#vacation_name1").change(function(){
		formDates=$("#vacation_name1").find("option:selected").text();
	    console.log(formDates);
	     $.ajax({
	    	 data:formDates,
	    	 type:"POST",
	    	 dataType:'json',
	    	 contentType : "application/json; charset=utf-8",
	    	 url : path + "/module/system/leaveApplication/searchVacation_explain.do",
	    	 success:function(data){
	    		var DD= $.parseJSON(data);
	    		console.log(DD.data);
	    		if(DD.flag=="1")
	    			{
	    			$("#vacation_explain").val(DD.data);
	    			}
	    	 },
	    	 error:function(data)
	    	 {
	    		 BootstrapDialog.alert("数据加载失败" + data.msg);
	    	 }
	     })
	});
	//模态框的关闭方法
	$("#closeModal").click(function(){
		window.close();
	});
});

/**
 * 假期基本信息列表查詢
 */
function searchLeave() {
	// 收集表单信息
	var searchHolidayForm = $("#searchLeaveForm").collect();
	//console.log(searchHolidayForm);
	// 分页信息
	searchHolidayForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchHolidayForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/leaveApplication/searchLeaveList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			// 加载列表数据
			var tpl = document.getElementById('leaveApplicationHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.leaveApplicationArea').html(render);
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


//点击申请的时候回弹出一个假期申请的模态框
function addLeave()
{
    $.ajax({
    	data:null,
    	type : "POST",
    	dataType : 'json',
    	contentType : "application/json; charset=utf-8",
    	url : path + "/module/system/leaveApplication/searchVacation.do",
    	success:function(data){
    		console.log(data);
    		//关闭模态框的时候，关闭几次，在点开模态框的时候就会多几条假期名，所以在每次点开模态框的时候就先移除所有假期名字
    		$("#vacation_name1").empty();
    		$("#vacation_name1").append("<option value=''>请选择</option>");
    		for(var i=0;i<data.length;i++)
    			{
    			  $("#vacation_name1").append("<option value='"+data[i].vacation_name+"' >"+data[i].vacation_name+"</option>");
    			  //$('#vacation_type').val(data[i].vacation_type);"+data[i].vacation_id+"
    			  //$('#vacation_explain').append(data[i].vacation_explain);
    			 
    			}
  			    $('#vacationForm').bindData(data);
    			$('#addModal').modal('show').css({ top: '10%' });   		
    	}
    });
}


//点击添加走的方法
function leaveSubmit()
{
	//alert($("#vacation_name").find("option:selected").text()); 
	if($("#vacation_user1").val()=="")
		{
		BootstrapDialog.confirm("申请人不能为空");
		return false;
		}
	else if($("#vacation_department1").val()=="")
	   {
	   BootstrapDialog.confirm("所在部门不能为空");
	   return false;
	   }
	else if($("#vacation_name1").val()=="")
		{
		BootstrapDialog.confirm("假期名称不能为空");
		return false;
		}
	else if($("#vacation_data1").val()=="")
		{
			BootstrapDialog.confirm("假期时长不能为空");
			return false;
		}
	else if($("#vacation_start1").val()=="")
	{
		BootstrapDialog.confirm("休假开始时间不能为空");
		return false;
	}
	else if($("#vacation_end1").val()=="")
	{
		BootstrapDialog.confirm("休假结束时间不能为空");
		return false;
	}
	else if($("#vacation_cause1").val()=="")
	{
		BootstrapDialog.confirm("假期原因不能为空");
		return false;
	}
	else{
  var formdate=$('#vacationForm').collect();
  $.ajax({
	  data:JSON.stringify(formdate),
	  type:"POST",
	  dataType:'json',
	  contentType : "application/json; charset=utf-8",
	  url : path + "/module/system/leaveApplication/insertLeave.do",
	  success:function(data){
		  console.log(data);
		  var jsonData = $.parseJSON(data);
		  console.log(jsonData);
		  if(jsonData.flag==="1")
			  {
			  BootstrapDialog.show({
					title:'提示信息',
		            message: '休假申请成功，请等待审批!(两秒后自动关闭)',
		            closable:true
				});
			  setTimeout(function(){
				  BootstrapDialog.closeAll();
				  document.location.reload();
			  },2000);
			  }
		     else
		    	 {
		    	 BootstrapDialog.confirm("休假申请失败");
		    	 }
	  },error:function(data)
	  {
		  BootstrapDialog.confirm("error"+data.msg);
	  }
  });
	}
}

//重置
function addReset()
{
  $('#vacationForm')[0].reset();
  //BootstrapDialog.confirm("重置成功!");
}
//信息查询
function leaveApplicationInfo(ID){
	var dates=[{"ID":ID}];
	$.ajax({
		data:JSON.stringify(dates),
		type : "POST",
		dataType:'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/leaveApplication/searchLeaveInfo.do",
		success:function(data){
			var obj = jQuery.parseJSON(data);
			if(obj.flag=="1")
				{
				$("#infoForm").bindData(obj.data);
				$("#infoModal").modal({backdrop:'static'});
				$("#infoModal").modal('show').css({ top: '10%' });
				}
			else
			{
				BootstrapDialog.confirm("获取数据失败");
			}
		},
		error:function(data){
			BootstrapDialog.alert("success:" + data.msg);
		}
	});
}
