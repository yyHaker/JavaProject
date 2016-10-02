page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchClassManage();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchClassManage();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchClassManage();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchClassManage();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchClassManage();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchClassManage();
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
	searchClassManage();
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
	//点击不同班制名称会显示不同的班制说明
	$("#name1").change(function(){
		if($("#name1").val()=="1"){
			$("#one").show();
			$("#two").hide();
			$("#three").hide();
			$("#four").hide();
		}
	else if($("#name1").val()=="2"){
			$("#two").show();
			$("#one").hide();
			$("#three").hide();
			$("#four").hide();
			return false;
		}
		else if($("#name1").val()=="3"){
			$("#three").show();
			$("#one").hide();
			$("#two").hide();
			$("#four").hide();
			return false;
		}
		else{
			$("#four").show();
			$("#one").hide();
			$("#two").hide();
			$("#three").hide();
			return false;
		}
	});
	
	//修改模态框里对班制名称的显示做判断
	$("#name2").change(function(){
		if($("#name2").val()=="正常班制"){
			$("#one1").show();
			$("#two1").hide();
			$("#three1").hide();
			$("#four1").hide();
		}
	else if($("#name2").val()=="两班倒班制"){
			$("#two1").show();
			$("#one1").hide();
			$("#three1").hide();
			$("#four1").hide();
			return false;
		}
		else if($("#name2").val()=="三班倒班制"){
			$("#three1").show();
			$("#one1").hide();
			$("#two1").hide();
			$("#four1").hide();
			return false;
		}
		else{
			$("#four1").show();
			$("#one1").hide();
			$("#two1").hide();
			$("#three1").hide();
			return false;
		}
	});
})

function searchClassManage(){
	var searchForm = $("#searchClassManageForm").collect();//收集表单信息
	searchForm.page=page;//分页信息
	
	$.ajax({
		data:JSON.stringify(searchForm),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/classManage/searchClassManageList.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('ClassManageHtml').innerHTML;
			laytpl(tpl).render(jsonData,function(render){
				$('.ClassManageArea').html(render);
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
	$("#classManageForm")[0].reset();
}

//弹出模态框
function insert(){
	$("#addModal").modal('show').css({top:'10%'});
	//$("#classManageForm").modal('show').css({top:'10%'});
}
//新增
function ClassManageSubmit(){
	if($("#department1").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($("#class_name1").val()==""){
		BootstrapDialog.alert("班组名称不能为空");
		return false;
	}
	else if($('input:radio[name=tag]:checked').length==0){
		BootstrapDialog.alert("班制选项不能为空");
		return false;
	}
	else if($("#class_group1").val()==""){
		BootstrapDialog.alert("班组人员不能为空");
		return false;
	}
	else{
	var ClassManageSubmitObj={
	department:$("#department1").val(),
	name:$("#name1").val(),
	class_name:$("#class_name1").val(),
	class_group:$("#class_group1").val(),
	class_description:$('input:radio[name=tag]:checked').val()
	};
	$.ajax({
		data:JSON.stringify(ClassManageSubmitObj),
		type:"POST",
		dataType:'json',
		contentType : "application/json; charset=utf-8",
		url:path+"/module/system/classManage/addClassManage.do",
		success:function(data){
		var jsonData = $.parseJSON(data);
		console.log(jsonData);
		if(jsonData.flag=="1"){
			BootstrapDialog.show({
				title:"提示信息",
				message:"成功新增一条班制！(两秒后自动关闭)",
				closeable:true
			});
			setTimeout(function(){
				BootstrapDialog.closeAll();
				document.location.reload();
			}, 2000);
		}
		},
		error:function(data){
			BootstrapDialog.confirm("班制新增失败"+data.msg);
		}
	});
	}
}

//详细信息的显示
function classManageInfo(class_system_id){
	var datas={"class_system_id":class_system_id};
	$.ajax({
		data:JSON.stringify(datas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/classManage/selectClassManage.do",
		success:function(data){
			var jsonData = $.parseJSON(data);
			sessionStorage.cc=data;
			
			var obj = jQuery.parseJSON(sessionStorage.cc);
			//alert(obj.data);
			console.log(obj.data);
			
			window.location.href="classManage/classManage_Info.jsp"
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

//删除数据
function deleteClassManage(class_system_id){
	BootstrapDialog.confirm("确定要删除当前选择的数据么？",function(result){
		if(result){
		var	url = "classManage/delete.do?class_system_id="+class_system_id;
		$.get(url,function(data){
			if(data=="success"){
				BootstrapDialog.show({
					title:"提示信息",
					message:"删除数据成功！(两秒后自动关闭)",
					closeable:true
				});
				setTimeout(function(data){
					BootstrapDialog.closeAll();
					document.location.reload();
				}, 2000);
			}
		})
		}
	});
}

//修改信息前先把信息显示到模态框上
function selectClassManage(class_system_id){
	var id={"class_system_id":class_system_id};
	$.ajax({
		data:JSON.stringify(id),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/classManage/selectClassManage.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				$("#editModal").bindData(obj.data);
				$("#editModal").modal("show").css({top:'10%'});
				//对班制名称判断
				if(obj.data.name === "正常班制"){
					$("#name2").val("正常班制");
				}
				else if(obj.data.name === "两班倒班制"){
					$("#name2").val("两班倒班制");
				}
				else if(obj.data.name === "三班倒班制"){
					$("#name2").val("三班倒班制");
				}
				else{
					$("#name2").val("四班倒班制");
				}
				//不同班制对应的不同班制描述
				if(obj.data.class_description==="A:8:00-12:00  13:00-17:00"){
					$("#one1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				else if(obj.data.class_description==="B:9:00-12:00  13:00-18:00"){
					$("#one1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				
				else if(obj.data.class_description==="早：6:00—12:00 　13:00-14:30 　中：14:30-23:00 　晚：23:00-次日6:00"){
					$("#two1").show();
					$("#one1").hide();
					$("#three1").hide();
					$("#four1").hide();
				}
				
				else if(obj.data.class_description==="A：6个早 3个休 6个晚 3个休"){
					$("#three1").show();
					$("#one1").hide();
					$("#two1").hide();
					$("#four1").hide();
					}
				else if(obj.data.class_description==="B：3个休 6个晚 3个休 6个早"){
					$("#three1").show();
					$("#two1").hide();
					$("#one1").hide();
					$("#four1").hide();
					}
				else if(obj.data.class_description==="C：6个晚 3个休 6个早 3个休"){
					$("#three1").show();
					$("#two1").hide();
					$("#one1").hide();
					$("#four1").hide();
					}
				
				else if(obj.data.class_description==="A：白 晚 休 休"){
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
				}
				else if(obj.data.class_description==="B：晚 休 休 白"){
					$("#four1").show();
					$("#two1").hide();
					$("#three1").hide();
					$("#one1").hide();
					}
				else if(obj.data.class_description==="C：休 白 晚 休"){
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
			BootstrapDialog.confirm("获取数据失败"+data.msg);
		}
	});
}

//修改好之后的保存方法
function updateSubmit(){
	//修改完成要保存之前做个判断
	if($("#department2").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($("#class_name2").val()==""){
		BootstrapDialog.alert("班组名称不能为空");
		return false;
	}
	else if($('input:radio[name=tag1]:checked').length==0){
		BootstrapDialog.alert("班制选项不能为空");
		return false;
	}		
	else if($("#class_group2").val()==""){
		BootstrapDialog.alert("班组人员不能为空");
		return false;
	}
	else{		
	var formdatas=$("#editForm").collect();
	formdatas.class_description = $('input:radio[name=tag1]:checked').val();
	console.log(formdatas);
	
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/classManage/updateClassManage.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				BootstrapDialog.show({
					title:"提示信息",
					message:"数据修改成功！(两秒后自动关闭)",
					closeable:true
				});
				setTimeout(function(){
					BootstrapDialog.closeAll();
					document.location.reload();
				}, 2000)
			}
		},
		error  :function(data){
			BootstrapDialog.confirm("修改数据失败"+data.msg);
		}
	})

}
	
}
