page = {
	"currentPage" : 1,// 第几页，默认第一页
	"showCount" : 10,// 每页显示多少条，默认10条
	"totalPage" : 1
};// 总页数，默认1页

// 首页，执行该方法
function goFirstPage() {
	page.currentPage = 1;
	searchUser();
}
// 上页，执行该方法
function goPrePage() {
	page.currentPage = page.currentPage - 1;
	searchUser();
}
// 下页，执行该方法
function goNextPage() {
	page.currentPage = page.currentPage + 1;
	console.log(page.currentPage);
	searchUser();
}
// 尾页，执行该方法
function goLastPage() {
	page.currentPage = page.totalPage;
	searchUser();
}

// 每页显示多少条改变时，执行该方法
function showCountChange(showCountTmp) {
	page.showCount = showCountTmp;
	searchUser();
}
// 输入域填写跳转到第几页时，执行该方法
function currentPageChange(currentPageTmp) {
	if (!isNaN(currentPageTmp) && currentPageTmp > 0
			&& currentPageTmp <= page.totalPage) {
		page.currentPage = currentPageTmp;
		searchUser();
	}
}

//加班申请页面加载初始化所需的一些方法
$(document).ready(function(){	
	//引入时间控件
	$(".timeselect").datetimepicker({
		format: "yyyy-mm-dd hh:ii",
        autoclose: true,
        language : 'zh-CN',
        todayBtn: true,
        startDate:new Date()
	})
	
	$(".timechoose_fordate").datetimepicker({
		format:'yyyy-mm-dd',
		autoclose:true,
		language : 'zh-CN',
		minView : 2,
		startDate:new Date()
	})
	
	//加载分页模板
	$('.pageDiv').load(path+'/module/common/page.jsp');
	   //打印字符串？？
     console.log(page);
     
	 //给全选和反选添加响应时间
     //思路：遍历所有items，将#selkectall的select属性值设置为items.select属性
	$('#selectall').click(function(){
		$(".box-items").each(function(){
			$(this).prop("checked",!!$("#selectall").prop("checked"));
		});
	});

	//给模态框添加关闭的方法
	$("#closeModal").click(function(){
		window.close();
	});

})

 //实现向加班申请的表单中添加申请人姓名(从列表中直接选择来添加)
function searchUser(){		
	//点击按钮弹出模态框，用以添加加班申请
	$("#addModal").modal('show').css({top:'5%'});
	
	//var pcstart=$("#personnelcode-search").val().indexOf("1106");
	//if(pcstart==0){
		var personnelcode=$("#personnelcode-search").val();
	//}
	//else{
		//var personnelcode="1106"+$("#personnelcode-search").val();
	//}
	var username=$("#name-search").val();
	var nameofdepartment=$("#nameofdepartment_search").val();
	//一个对象数组
	var datas = [{
		"personnelcode":personnelcode,
		"username" : username,
		"nameofdepartment":nameofdepartment,
		"page":page
	}];
	$.ajax({
		data:JSON.stringify(datas),
		type:"POST",
		dataType:'json',
		contentType:"application/json;charset=utf-8",
		url:path+"/module/system/overtime/listPageName.do",
		success: function(data){
			var jsonData = $.parseJSON(data);
			//加载数据列表
			var tpl = document.getElementById('userHtml').innerHTML;
			//laytpl:精妙的js引擎用法
			  //第一步：编写模版。你可以使用一个script标签存放模板
			  //第二步：建立视图。用于呈现渲染结果。
			  //第三步:渲染模版
			
			laytpl(tpl).render(jsonData,function(render){
				$('.userArea').html(render);
				//pageInfor？？？，将要显示的jsonData数据传给pageInfor,即可自动显示并分页
				pageInfo(jsonData);
			});					
		},
		error:function(data){
			BootstrapDialog.alert("error" + data.msg);
		}
	});					
}

function addUser(){
	//把所有的username封装到一个list集合中
	username={list:[]};
	personnelcode={list:[]};
	//对每一个checkbox中的审批状态进行遍历
	$('input:checkbox[name=box]:checked').each(function(){
		username.list.push({username:$(this).attr("data-name")});
		personnelcode.list.push({personnelcode:$(this).attr("data-personnelcode")});
	});
	
	if($('input:checkbox[name=box]:checked').length==0){
		BootstrapDialog.alert("您没有选择，请选择申请加班的人员姓名");
		return false;
	}
	else{
		var bb=$("#name-add").attr('value');	
		var cc=$("#personnelcode-add").attr('value');
		
		for(var i=0;i<username.list.length;i++){
			var username1=username.list[i].username; 
			if(bb!=""){
				for(var j=0;j<personnelcode.list.length;j++){
					var personnelcode1=personnelcode.list[j].personnelcode;
					dd=[];
					dd=cc.split("、");
					for(var k=0;k<dd.length;k++){
						if(personnelcode1==dd[k]){
							BootstrapDialog.alert("员工添加重复！");
							return false;
						}
					}
				}
			}	
			bb+="、"+username1;
		}		
		for(var j=0;j<personnelcode.list.length;j++){
			var personnelcode1=personnelcode.list[j].personnelcode;
			cc+="、"+personnelcode1;
		}
				
		if($("#name-add").attr('value')==="")
		$("#name-add").attr('value',bb.substring(1,bb.length));
		else
		$("#name-add").attr('value',bb);
		
		if($("#personnelcode-add").attr('value')==="")
		$("#personnelcode-add").attr('value',cc.substring(1,cc.length));
		else
		$("#personnelcode-add").attr('value',cc);
		$(".close").click();
	}			
}

//加班申请表单的提交
function overtimeSubmit(){
	//必填项校验	
	var myDate = new Date();
	var myday=myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();//获取当前日期
	var day = new Date(myday.replace(/\-/gi,"/")).getTime();
	var mytime=myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate()+" "+myDate.getHours()+":"+myDate.getMinutes();//获取当前时间
	var time = new Date(mytime.replace(/\-/gi,"/")).getTime();
	var apply_time = new Date($("#apply_time-add").val().replace(/\-/gi,"/")).getTime();
	var begin_time = new Date($("#begin_time-add").val().replace(/\-/gi,"/")).getTime();
	var end_time = new Date($("#end_time-add").val().replace(/\-/gi,"/")).getTime();
	
	var begin_time1 = new Date($("#begin_time-add").val().substr(0,10).replace(/\-/gi,"/")).getTime();
	var end_time1 = new Date($("#end_time-add").val().substr(0,10).replace(/\-/gi,"/")).getTime();
		
		if($("#name-add").val()==""){
			 BootstrapDialog.confirm("姓名不能为空");
			 return false;
		}
	    else if($("#apply_time-add").val()==""){
	    	 BootstrapDialog.confirm("申请日期不能为空");
		     return false;
		}	
		/*else if(apply_time<day){
			BootstrapDialog.confirm("申请时间不能小于当前时间");
			return false;
		}*/
		else if($("#begin_time-add").val()==""){
			   BootstrapDialog.confirm("申请起始时间不能为空");
			   return false;
		}
		/*else if(begin_time<time){
			BootstrapDialog.confirm("申请起始时间不能小于当前时间");
			return false;
		}*/
		else if($("#end_time-add").val()==""){
			   BootstrapDialog.confirm("申请结束时间不能为空");
			   return false;
		}
		/*else if(end_time<time){
			BootstrapDialog.confirm("申请结束时间不能小于当前时间");
			return false;
		}*/
		else if($("#overtime_reason-add").val()==""){
			   BootstrapDialog.confirm("加班原由不能为空");
			   return false;
		}
		else if(begin_time>=end_time){
			BootstrapDialog.confirm("结束时间不能小于开始时间");
			return false;
		}
		else if(apply_time!=begin_time1||apply_time!=end_time1||begin_time1!=end_time1){
			BootstrapDialog.confirm("申请日期、申请开始时间、申请结束时间必须为同一天");
			   return false;
		}	
	if($('input:checkbox[name=box]:checked').length==0){
		BootstrapDialog.alert("您没有选择，请选择申请加班的员工");
		return false;
	}	
	else{
		//声明参数，参数可以是一条也可以是多条，多以list集合来装
		//？？？
		overtimeList={list:[]};
		var overtime=$("#overtimeForm").collect();	
		var username1=$("#name-add").attr('value');
		 //将多个申请人用、分隔
		var s=username1.split('、');
		for(var i = 0;i<s.length;i++){
			s1=s[i];
			overtimeList.list.push({username:s[i],apply_time:$("#apply_time-add").val(),begin_time:$("#begin_time-add").val(),end_time:$("#end_time-add").val(),overtime_reason:$("#overtime_reason-add").val()});
		}
		$.ajax({
			data:JSON.stringify(overtimeList),
			type:"POST",
			dataType:'json',
			contentType : "application/json; charset=utf-8",
			url : path + "/module/system/overtime/insertOvertime.do",
			success:function(data){
				var jsonData = $.parseJSON(data);
			    if(jsonData.flag=="1")
			    	{
			    	BootstrapDialog.show({
			    		title:"提示信息",
			    		message:"加班申请成功，请等待审批！(两秒后自动关闭)",
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
		window.location.href=path+"/module/system/overtime/overtime.jsp";
		}
	}