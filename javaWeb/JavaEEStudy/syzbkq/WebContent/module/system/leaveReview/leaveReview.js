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
	//全选和反选
	$("#selectall").click(function()
			{			
						$(".box-items").each(function(){
						  $(this).prop("checked",!!$("#selectall").prop("checked"));
						});				
			});
	
	/*$("input[type='checkbox']").click(function ()
			  {
			    $(this).attr('checked','checked');
			    $(this).parent().parent().siblings().find("input").removeAttr('checked');
			  }
			);*/
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
		url : path + "/module/system/leaveReview/searchLeaveReviewList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			// 加载列表数据
			var tpl = document.getElementById('leaveApplicationHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.leaveArea').html(render);
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
//休假审批前做个判断
function insert()
{
	if($('input:checkbox[name=box]:checked').length==0)
		{
		BootstrapDialog.alert("您没有选择，请选择待审批的数据项");
		}
	else if($('input:checkbox[name=box]:checked').attr('data-vacation_review')==1)
		{
		BootstrapDialog.alert("您选择的数据项中包已经含审批的数据，请选择待审批的数据项进行审批");
		}
	else
		{
		//$('input:checkbox[name=box]:checked').attr('data-vacation_cause')
		updateLeave();
		}
	}
//休假审批
function updateLeave()
{
	/*formDatas={vacation_cause:vacation_cause};*/
	formDatas={list:[]};
	
	$('input:checkbox[name=box]:checked').each(function(i){
		console.log($(this).attr("data-ID"));
		formDatas.list.push({ID:$(this).attr("data-ID")});
	})

	$.ajax({
		data:JSON.stringify(formDatas),
		type:"POST",
		dataType:'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/leaveReview/updateSave.do",
		success:function(data){
			var D=$.parseJSON(data);
			if(D.flag=="1")
				{
				//BootstrapDialog.confirm("休假审批通过");
				BootstrapDialog.show({
					title:'提示信息',
		            message: '休假审批通过!(两秒后自动关闭)',
		            closable:true
		        });
				setTimeout(function()
						{
					BootstrapDialog.closeAll();
					document.location.reload();
						}, 2000);
				}	
		},
		error : function(data) { 
			BootstrapDialog.alert("导入数据失败:" + data.msg);
		}
	})
}
//提前销假
function updateFlag(){
	//获取当前系统时间,创建对象，用对象的get方法把年月日时分秒拼接起来
	var date = new Date();
//	var now = date.getFullYear() + "-" + (parseInt(date.getMonth()) + 1) +"-"+((date.getDate() > 9) ? date.getDate() : "0" + date.getDate())+" "+(date.getHours()+":"+((date.getMinutes()>9)?date.getMinutes():"0"+date.getMinutes())+":"+((date.getSeconds()>9)?date.getSeconds():"0"+date.getSeconds()) );
//	alert(new Date(now));
	if($('input:checkbox[name=box]:checked').length==0)
	{ 
		//console.log((new Date()).SimpleDateFormat("yyyy-mm-dd"));
		BootstrapDialog.confirm("请选择要提前销假的数据");
		return false;
	}//选择的数据如果小于当前时间就是表示该条数据已经过期，假期过完了，不能销假了；反过来说如果数据大于当前时间的话就表示现在还在假期中，如果想要销假的话可以操作
	//因为字符串没办法比较大小，所以都转换成日期格式的数据类型再进行比较new Date()
	else if(new Date($('input:checkbox[name=box]:checked').attr('data-vacation_end'))<date)
	{
		BootstrapDialog.confirm("您选择的数据不可以提前销假");
		return false;
	}
	else{
		//声明参数ID
		var ID=$('input:checkbox[name=box]:checked').attr('data-ID');
		$.ajax({
			data:ID,
			type:"POST",
			dataType:'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/leaveReview/updateFlag.do",
			success:function(data){
				var tt=$.parseJSON(data);
				if(tt.flag=="1")
					{
					BootstrapDialog.show({
						title:'提示信息',
						message:'提前销假成功!(两秒后自动关闭)',
						closable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
					}
			},error:function(data)
			{
				BootstrapDialog.alert("提前销假失败:"+data.msg);
			  //BootstrapDialog.alert("导入数据失败:" + data.msg);
			}
		})
	}
}