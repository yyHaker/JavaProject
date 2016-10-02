page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchBanTeam();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchBanTeam();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	searchBanTeam();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchBanTeam();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchBanTeam();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchBanTeam();
	}
}

$(document).ready(function(){
	//加载分页模板
	$('.pageDiv').load(path+'/module/common/page.jsp');
	searchBanTeam();
})

//增加模态框的重置
function addReset(){
	$("#banteamForm")[0].reset();
}
//修改信息模态框的重置
function editReset(){
	$("#editbanteamForm")[0].reset();
}

//主页显示、分页、查询功能
function searchBanTeam(){
	var searchForm = $("#searchBanTeamForm").collect();//收集表单信息
	searchForm.page=page;//分页信息
	
	$.ajax({
		data:JSON.stringify(searchForm),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/banteam/searchBanTeamList.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('BanTeamHtml').innerHTML;
			laytpl(tpl).render(jsonData,function(render){
				$('.BanTeamArea').html(render);
				pageInfo(jsonData);
			});
			
		},
		error:function(data){
			BootstrapDialog.alert("success" + data.msg);
		}
	});
}
//删除
function deleteBanteam(banteam_id){
	BootstrapDialog.confirm("确认删除当前选择的数据么？",function(result){
		if(result){
			var url= "banteam/delete.do?banteam_id=" + banteam_id;
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
			})
		}
	});
}

//新增
function insert(){
	$("#addModal").modal("show").css({top:'10%'});
}
function banteamSubmit(){
	if($("#ban_department1").val()==""){
		BootstrapDialog.alert("部门名称不能为空");
		return false;
	}
	else if($("#ban_name1").val()==""){
		BootstrapDialog.alert("班组名称不能为空");
		return false;
	}
	else if($("#ban_group1").val()==""){
		BootstrapDialog.alert("班组人员不能为空");
		return false;
	}
	else{
		var formadates = {
		ban_department:$("#ban_department1").val(),
		ban_name:$("#ban_name1").val(),
		ban_group:$("#ban_group1").val()
		};
		$.ajax({
			data:JSON.stringify(formadates),
			type:"POST",
			dataType:'json',
			contentType : "application/json; charset=utf-8",
			url:path+"/module/system/banteam/addBanteam.do",
			success:function(data){
				var jsonData = $.parseJSON(data);
				if(jsonData.flag=="1"){
					BootstrapDialog.show({
						title:"提示信息",
						message:"成功增加一条班组！(两秒后自动关闭)",
						closeable:true
					});
					setTimeout(function(){
						BootstrapDialog.closeAll();
						document.location.reload();
					}, 2000)
				}
			},
			error  :function(data){
				BootstrapDialog.confirm("班组新增失败"+data.msg);
			}
		});
	}
}

//点击单条信息名字的时候显示详细信息
function banteamInfo(banteam_id){
	var id = {"banteam_id":banteam_id};
	$.ajax({
		data:JSON.stringify(id),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/banteam/findBanteam.do",
		success:function(data){
			var jsonData = $.parseJSON(data);
			sessionStorage.dd=data;
			var obj = jQuery.parseJSON(sessionStorage.dd);
			window.location.href="banteam/banteam_Info.jsp";
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

//修改信息:查出信息，显示模态框
function selectBanteam(banteam_id){
	var formdatas = {"banteam_id":banteam_id};
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/banteam/findBanteam.do",
		success:function(data){
			var obj = $.parseJSON(data);
			if(obj.flag=="1"){
				$("#editModal").bindData(obj.data);
				$("#editModal").modal("show").css({top:'10%'});
			}
		},
		error  :function(data){
			BootstrapDialog.confirm("获取数据失败"+data.msg);
		}
	});
}

//修改后的保存动作
function updateSubmit(){
	if($("#ban_department5").val()==""){
		BootstrapDialog.alert("部门名称不能为空！");
		return false;
	}
	else if($("#ban_name5").val()==""){
		BootstrapDialog.alert("班组名称不能为空！");
		return false;
	}
	else if($("#ban_group5").val()==""){
		BootstrapDialog.alert("班组人员不能为空！");
		return false;
	}
	else{
	var formdatas = $("#editbanteamForm").collect();
	$.ajax({
		data:JSON.stringify(formdatas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/banteam/updateBanteam.do",
		success:function(data){
			var obo = $.parseJSON(data);
			if(obo.flag=="1"){
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
			else{
				BootstrapDialog.confirm("数据修改失败"+data.msg);
			}
		},
		error  :function(data){
			BootstrapDialog.confirm("数据修改失败"+data.msg);
		}
	});
	}
}