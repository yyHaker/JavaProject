page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchWorkManage();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchWorkManage();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchWorkManage();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchWorkManage();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchWorkManage();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchWorkManage();
	}
}

$(document).ready(function(){
	/*//引入时间控件
	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd',
		autoclose:true,
		language : 'zh-CN',
		minView : 2
	})*/
	//加载分页模板
	$('.pageDiv').load(path+'/module/common/page.jsp');
	searchWorkManage();
	//全选和反选
	$('#selectall').click(function(){
		$(".box-items").each(function(){
			$(this).prop("checked",!!$("#selectall").prop("checked"));
		});
	});
	//模态框关闭的方法
	/*$("#closeModal").click(function(){
		window.close();
	});*/		
	//点击增加模态框里的班制名称，就会有相对应的班制选择
	$("#wname1").change(function(){
		if($("#wname1").val()=="1"){
			$("#one").show();
			$("#two").hide();
			$("#three").hide();
			$("#four").hide();
		}
		else if($("#wname1").val()=="2"){
		$("#two").show();
		$("#one").hide();
		$("#three").hide();
		$("#four").hide();
		return false;
	    }
		else if($("#wname1").val()=="3"){
			$("#three").show();
			$("#one").hide();
			$("#two").hide();
			$("#four").hide();
			return false;	
		}
		else{
			$("#four").show();
			$("#one").hide();
			$("#three").hide();
			$("#two").hide();
			return false;
		}
	});
	
	//修改信息的change事件
	$("#wname2").change(function(){
		if($("#wname2").val()=="正常班制"){
			$("#one1").show();
			$("#two1").hide();
			$("#three1").hide();
			$("#four1").hide();
		}
		else if($("#wname2").val()=="两班倒班制"){
		$("#two1").show();
		$("#one1").hide();
		$("#three1").hide();
		$("#four1").hide();
		return false;
	    }
		else if($("#wname2").val()=="三班倒班制"){
			$("#three1").show();
			$("#one1").hide();
			$("#two1").hide();
			$("#four1").hide();
			return false;	
		}
		else{
			$("#four1").show();
			$("#one1").hide();
			$("#three1").hide();
			$("#two1").hide();
			return false;
		}
	});
})


function searchWorkManage(){
	var searchForm = $("#searchWorkManageForm").collect();//收集表单信息
	searchForm.page=page;//分页信息
	
	$.ajax({
		data:JSON.stringify(searchForm),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/workmanage/listsearchWorkManage.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('WorkManageHtml').innerHTML;
			laytpl(tpl).render(jsonData,function(render){
				$('.WorkManageArea').html(render);
				pageInfo(jsonData);
			});
			
		},
		error:function(data){
			BootstrapDialog.alert("success" + data.msg);
		}
	});
}
//重置
function addReset(){
	$("#workManageForm")[0].reset();
}
//弹出模态框
function insert(){
	$("#addModal").modal('show').css({top:'10%'});
}
function WorkManageSubmit(){
	if($("#wdepartment1").val()==""){
		BootstrapDialog.alert("部门名称不能为空！");
		return false;
	}
	else if($("#wclass_name1").val()==""){
		BootstrapDialog.alert("班组名称不能为空！");
		return false;
	}
	else if($('input:radio[name=tag]:checked').length==0){
		BootstrapDialog.alert("班制选项不能为空！");
		return false;
	}
	else if($("#wclass_group1").val()==""){
		BootstrapDialog.alert("班组人员不能为空！");
		return false;
	}
	else{
	var formdatas=$("#workManageForm").collect();
	formdatas.wclass_description=$('input:radio[name=tag]:checked').val();	                             
	console.log(formdatas);
	
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/workmanage/insert.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				BootstrapDialog.show({
					title:'提示信息',
					message:'班组排班成功',
					closeable:true
				});
				setTimeout(function(){
					BootstrapDialog.closeAll();
					document.location.reload();
				}, 2000)
			}
			else{
				BootstrapDialog.alert("班组排班失败" + data.msg);
			}
		},
		error  :function(data){
			BootstrapDialog.alert("班组排班失败" + data.msg);
		}
	});
	}
}

//删除
function deleteWorkManage(workmanage_id){
	BootstrapDialog.confirm("确定要删除当前选择的数据么？",function(result){
		if(result){
			var url = "workmanage/delete.do?workmanage_id="+workmanage_id;
			$.get(url,function(data){
				if(data=="success"){
					BootstrapDialog.show({
						title:"提示信息",
						message:"删除数据成功！(两秒后自动关闭)",
						closeable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000)
				}
			});
		}
	});
}
//修改信息之先找到一套信息
function selectClassManage(workmanage_id){
	var formdatas= {"workmanage_id":workmanage_id};
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/workmanage/getWorkManage.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				$("#editModal").bindData(obj.data);
				$("#editModal").modal("show").css({top:'10%'});
			//对班制名称赋值	
				if(obj.data.wname==="1"){
					$("#wname2").val("正常班制");
				}
				else if(obj.data.wname==="2"){
					$("#wname2").val("两班倒班制");
				}
				else if(obj.data.wname==="3"){
					$("#wname2").val("三班倒班制");
				}
				else{
					$("#wname2").val("四班倒班制");
				}
		   //对班制说明赋值
				if(obj.data.wclass_description==="A:8:00-12:00  13:00-17:00"){
					$("#one1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				else if(obj.data.wclass_description==="B:9:00-12:00  13:00-18:00"){
					$("#one1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				
				else if(obj.data.wclass_description==="早：6:00—12:00 　13:00-14:30 　中：14:30-23:00 　晚：23:00-次日6:00"){
					$("#two1").show();
					$("#one1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				
				else if(obj.data.wclass_description==="A：6个早 3个休 6个晚 3个休"){
					$("#three1").show();
					$("#one1").hide();
					$("#two1").hide();
					$("#four1").hide();
					}
				else if(obj.data.wclass_description==="B：3个休 6个晚 3个休 6个早"){
					$("#three1").show();
					$("#two1").hide();
					$("#one1").hide();
					$("#four1").hide();
					}
				else if(obj.data.wclass_description==="C：6个晚 3个休 6个早 3个休"){
					$("#three1").show();
					$("#two1").hide();
					$("#one1").hide();
					$("#four1").hide();
					}
				
				else if(obj.data.wclass_description==="A：白 晚 休 休"){
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
				}
				else if(obj.data.wclass_description==="B：晚 休 休 白"){
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
					}
				else if(obj.data.wclass_description==="C：休 白 晚 休"){
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
					}
				else{
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
				}
				
			}
			else{
				BootstrapDialog.confirm("获取数据失败"+data.msg);
			}
		},
		error  :function(data){
			BootstrapDialog.alert("获取信息失败" + data.msg);
		}
	});
}
//修改之后的保存事件
function updateSubmit(){
	if($("#wdepartment2").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($("#wname2").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($("#wclassname2").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($('input:radio[name=tag1]:checked').length==0){
		BootstrapDialog.alert("班制选项不能为空");
		return false;
	}
	else if($("#wclass_group2").val()==""){
		BootstrapDialog.alert("班组人员不能为空");
		return false;
	}
	else{
	var formdatas = $("#editForm").collect();
	formdatas.wclass_description=$('input:radio[name=tag1]:checked').val();
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/workmanage/addWorkManage.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				BootstrapDialog.show({
					title:"提示信息",
					message:"修改数据成功！(两秒后自动关闭)",
					closeable:true
				});
				setTimeout(function(){
					BootstrapDialog.closeAll();
					document.location.reload();
				}, 2000)
			}
		},
		error  :function(data){
			BootstrapDialog.alert("获取信息失败" + data.msg);
		}
	});
	}
}