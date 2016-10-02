$(document).ready(
	function() {
		getTime();
		window.setInterval(getTime, 1000);
	
		/*
		 * 收缩菜单
		 */
		/*
		$(".content_center").bind("click", function() {
			$(".content_left").slideToggle("fast", function() {
				if ($(this).is(":hidden")) {
					$(".content_left").width(0);
				} else {
					$(".content_left").width(182);
				}
	
				initRightContentHeightAndWidth();
			});
		});
		*/
		
		$('.sidebar-menu a').bind('click', function(){ 
			
			$('.sidebar-menu a:not(this)').removeClass('active'); 
			
			$(this).addClass('active'); 
		}); 
		
		/*
		$(".sidebar-menu li a").bind("click",function() {
				//$(".content_title").html($(this).html());
				if($(this).attr("href") == "javascript:void(0);"){
					$("#mainFrame").attr("src", "");
				}
			
				$(".sidebar-menu li a").bind({mouseover : function() {
								$(this).css("font-weight", "bold");
							},
							mouseout : function() {
								$(this).css("font-weight", "normal");
							}
						});
				
				$(this).unbind("mouseout");
			}
		);
		/**/
		initRightContentHeightAndWidth();
	}
);

/**
 * 设置页面布局长度宽度
 */
function initRightContentHeightAndWidth() {
	var height = $(window).height() < $(document).height() ? $(window).height()
			: $(document).height();
	var width = $(window).width() < $(document).width() ? $(window).width(): $(document).width();
	$(".content_right table").width(width - $(".content_left").width() - $(".content_center").width());
	$(".content_right table tr:eq(1) td").height(height - $(".main_header").height() - $(".sys_bottom").height()- 46);

	$(".content_center").height(height - $(".main_header").height());
	$(".sys_bottom").width(width - $(".content_left").width() - $(".content_center").width());
}

/**
 * 显示系统时间
 */
function getTime() {
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	var h = date.getHours();
	var i = date.getMinutes();
	var s = date.getSeconds();
	$("#sysTime").html(
			y + "年" + (m > 9 ? m : ("0" + m)) + "月" + (d > 9 ? d : ("0" + d))
					+ "日 " + (h > 9 ? h : ("0" + h)) + ":"
					+ (i > 9 ? i : ("0" + i)) + ":" + (s > 9 ? s : ("0" + s))
					+ '&nbsp;星期'
					+ '日一二三四五六'.charAt(date.getDay()));
}

/**
 * 退出操作
 */
function logout() {
	BootstrapDialog.confirm('确定要退出吗？', function(result){
		if(result){
		document.location = path + "/logout.do";
		}});
}