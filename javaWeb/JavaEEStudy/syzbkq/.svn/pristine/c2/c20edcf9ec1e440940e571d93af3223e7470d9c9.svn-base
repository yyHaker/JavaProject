page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchHoliday();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchHoliday();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchHoliday();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchHoliday();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchHoliday();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchHoliday();
	}
}

/**
 * 假期基本信息列表查詢
 */
function searchHoliday() {
	// 收集表单信息
	var searchHolidayForm = $("#searchHolidayForm").collect();
	//console.log(searchHolidayForm);
	// 分页信息
	searchHolidayForm.page = page;

	$.ajax({
		// 如果没有查询条件，直接传入page的json对象即可 JSON.stringify(page)
		data : JSON.stringify(searchHolidayForm),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/holiday/searchHolidayList.do",
		success : function(data) {
			var jsonData = $.parseJSON(data);
			// console.log(jsonData);
			// 加载列表数据
			var tpl = document.getElementById('holidayHtml').innerHTML;
			laytpl(tpl).render(jsonData, function(render) {
				$('.holidayArea').html(render);
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
	searchHoliday();

	// 模态框表单提交按钮绑定事件
	$("#saveHoliday").click(function() {
		saveHoliday();
	});
	$("#closeModal").click(function() {
		window.close();
	});

	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd',
		autoclose:true,
		todayBtn: true,
		language : 'zh-CN',
		minView : 2
	});	
	
});

// 新增假期模态窗口弹出层方法
function addHoliday() {
	$('#addHolidayModal').modal({
		backdrop : 'static'
	});
	$('#addHolidayModal').modal('show').css( {top :'10%'});
}

// 重置方法
function addReset() {
	$('#holidayForm')[0].reset();
	BootstrapDialog.alert('重置成功！');
}

//添加按钮方法
function holidayInfoSubmit() {
		// 提交修改表单
		var formDatas = $("#holidayForm").collect();
		var holidaylist=[];
		$(".add_item_row").each(function(i){
			var item = {
					vacationName:$(this).find("input[name=vacationName]").val(),
					hdYear:$(this).find("input[name=hdYear]").val(),
					startTime:$(this).find("input[name=startTime]").val(),
					endTime:$(this).find("input[name=endTime]").val(),
			};
			console.log(item);
			holidaylist.push(item);
			console.log(holidaylist);
		});
		
		// ajax异步调用springMVC的controller
		$.ajax({
			data : JSON.stringify(holidaylist),
			type : "POST",
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/holiday/save.do",
			success : function(data) {
				var obj=$.parseJSON(data);
				console.log(obj);
				/* alert(data); */
				if (obj.flag == "1") {
					// data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
					BootstrapDialog.show({
						title : '提示信息',
						message : '添加法定假期成功!(两秒后自动关闭)',
						closable : true
					});
					setTimeout(function() {
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000);
				} else {
					alert("添加数据失败," + obj);

				}
			}
		});
}

//删除方法
function delholiday(hdId) {
	BootstrapDialog.confirm('确认删除当前选中的记录吗?', function(result){
        if(result) {
            var  url = "holiday/deleteholida.do?hdId=" + hdId;
            var delobj={
            		hdId:hdId
            }
            $.ajax({
            	type:"GET",
            	data:delobj,
            	async:false,
            	contentType : "application/json; charset=utf-8",
            	url:path+"/module/system/holiday/deleteholida.do",
            	success:function(data){
            		document.location.reload();
            	},
            	error:function(data){
            		console.log(data);
            	},
            		
            })
            
        }});
};

//法定假期详细信息查询方法
function holidayInfo(hdId){
	var datas = [{
		"hdId" : hdId 
	}];

	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/holiday/searchHolidayInfo.do",
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			if(obj.flag == "1"){				
				$("#infoForm").bindData(obj.data);
				$('#infoModal').modal({backdrop:'static'});
				$('#infoModal').modal('show').css({ top: '10%' });
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
function selecholiday(hdId) {
	// testAjax(employeenum);
	selectAjax(hdId);
}

//根据id查询编辑法定假期信息
function selectAjax(hdId) {

	var datas = [ {
		"hdId" : hdId
	} ];
	// ajax异步调用springMVC的controller
	$.ajax({
		data : JSON.stringify(datas),
		type : "POST",
		dataType : 'JSON',
		contentType : "application/json; charset=utf-8",
		url : path + "/module/system/holiday/searchHolidayInfo.do",
		success : function(data) {
			// //解析json格式的字符串,data.flag = 1,为数据交互处理成功,否则(-1)失败
			var obj = jQuery.parseJSON(data);
			if (obj.flag == "1") {
				$('#editorModal').modal({backdrop : 'static'});
				// data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
				$('#editorModal').modal('show').css({ top: '10%' });
				$("#editorForm").bindData(obj.data);
				$("#hname").val(obj.data.vacationName);
			} else {
				alert("获取数据失败," + data);
			}
		},
		error : function(data) {
			BootstrapDialog.alert("success:" + data.msg);
		}
	});
}


//保存修改法定假期信息
function saveHoliday(){

		//收集表单信息
		var formDatas = $("#editorForm").collect();
		// ajax异步调用springMVC的controller
		$.ajax({
			data : JSON.stringify(formDatas),
			type : "POST",
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/holiday/updatHoliday.do",
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if(obj.flag === "1"){
					
					//data.data为内容json对象,对应封装参见：cn.thinking.common.baseeditor.BaseController的函数successJson与errorJson
					BootstrapDialog.show({
						title:'提示信息',
			            message: '修改法定假期信息成功!(两秒后自动关闭)',
			            closable:true
					});
					setTimeout(function()
					{
						BootstrapDialog.closeAll();   
						document.location.reload();
					}, 2000);	 
				}else{ 

					alert("修改数据失败," + obj);
				}
			},
			error : function(data) {
				BootstrapDialog.alert("error" + data.msg);
			}
		});
}


