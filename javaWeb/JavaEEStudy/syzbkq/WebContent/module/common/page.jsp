<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- <link href="<%=path %>/assets/css/page.css" rel="stylesheet" /> -->
	 <script type="text/javascript">
		
		 function pageInfo(jsonData){
		 	 var condition = jsonData.condition;
		 	 if(condition.page != undefined){  
		 		page = condition.page;  
		 	 } else { 
		 		 page = condition; 
		 	 } 
		 	 //当前页为第一页时，首页、上页不可点击
		 	 if(page.currentPage == 1){ 
		 		 document.getElementById("firstPage").style.display = "inline";
		 		 document.getElementById("prePage").style.display = "inline";
		 		 document.getElementById("firstPageLink").style.display = "none";
		 		 document.getElementById("prePageLink").style.display = "none";
		 	 } else {
		 		 document.getElementById("firstPage").style.display = "none";
		 		 document.getElementById("prePage").style.display = "none";
		 		 document.getElementById("firstPageLink").style.display = "inline";
		 		 document.getElementById("prePageLink").style.display = "inline";
		 	 }
		 	//当前页为最后一页时，下页、尾页不可点击
		 	 if(page.currentPage >= page.totalPage){ 
		 		 document.getElementById("nextPage").style.display = "inline";
		 		 document.getElementById("lastPage").style.display = "inline";
		 		 document.getElementById("nextPageLink").style.display = "none";
		 		 document.getElementById("lastPageLink").style.display = "none";
		 	 } else {
		 		 document.getElementById("nextPage").style.display = "none";
		 		 document.getElementById("lastPage").style.display = "none";
		 		 document.getElementById("nextPageLink").style.display = "inline";
		 		 document.getElementById("lastPageLink").style.display = "inline";
		 	 }
		 	 //当前页赋值
		 	 document.getElementById("page.currentPage").value = page.currentPage;
		 	 //总页数赋值
		 	 document.getElementById("totalPageDiv").innerText = page.totalPage;
		 	 
		 }
	 </script>
	 <style type="text/css">
	 .pageDiv{
		font-size: 18px;
		text-align:center;
		font-family:'妤蜂綋';
	}
	.pageDiv li{
		list-style-type:none;  
	    display:inline;  
	    margin-right: 10px;
	   
	    
	 }
	.pageDiv li input{
		width:35px;
		height:24px;
		text-align:center;
		border-radius: 0px !important;
	}
	
	.pageDiv li select{
	    width: 50px;
	    border-radius: 0px !important;
	}
	 </style>
   </head>

	<body>
		<div class="pageDiv">
			<ul>
				<li id="firstPage">首页</li>
				<li id="prePage">上页</li>
				<li id="firstPageLink"><a href="#@" onclick="goFirstPage()">首页</a></li>
				<li id="prePageLink"><a href="#@" onclick="goPrePage()">上页</a></li>
				
				<li id="nextPage">下页</li>
				<li id="lastPage">尾页</li>
				<li id="nextPageLink"><a href="#@" onclick="goNextPage();">下页</a></li>
				<li id="lastPageLink"><a href="#@" onclick="goLastPage()">尾页</a></li>
				<li>
					第<input type="text" id="page.currentPage" value="1" onchange="currentPageChange(this.value)">页/<span id="totalPageDiv">1</span>页
					<input type="hidden" id="page.totalPage"/>
				</li>
				<li>
					每页显示<select id="page.showCount" onchange="showCountChange(this.value)" style="width: 50px">
								<option value="10" selected="selected">10</option>
								<option value="20">20</option>
								<option value="50">50</option>
								<option value="100">100</option>
							</select>条
				</li>
			</ul>
		</div>
	</body>
</html>