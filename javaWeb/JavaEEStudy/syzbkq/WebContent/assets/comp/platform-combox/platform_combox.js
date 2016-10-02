+(function ($) {
	PlatformCombobox = function(inputId,treeId,menuDivId,nodes){
		this.inputId = inputId;
		this.treeId = treeId;
		this.menuDivId = menuDivId;
		this.nodes = nodes;
		/**
		 * 下拉框设置
		 * @type 
		 */
		this.setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onCheck: onCheck
			}
		};
	
	this.init= function(){
		$("#"+this.inputId).click(function(){showMenu();});
		$.fn.zTree.init($("#"+this.treeId), this.setting, this.nodes);
	}
	
	
	
	/**
	 * 计算下拉列表坐标位置
	 * @param {} e
	 * @return {}
	 */

	function getRealOffset(e)
		{
		    var t = e.offsetTop;
		    var l = e.offsetLeft;
		    var w = e.offsetWidth;
		    var h = e.offsetHeight;
		    while (e = e.offsetParent)
		    {
		        t += e.offsetTop;
		        l += e.offsetLeft;
		    }
		    return {
		        top: t,
		        left: l,
		        width: w,
		        height: h,
		        bottom: t + h,
		        right: l + w
		    }
		};
	

	
	function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj(treeId);
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}
	
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj(treeId),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		c = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			c += nodes[i].id + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (c.length > 0 ) c = c.substring(0, c.length-1);
		var cityObj = $("#"+this.inputId);
		cityObj.attr("value", v);
		cityObj.attr("code", c);
	}
	
	
	function showMenu() {
		var cityObj = $("#"+this.inputId);
		var cityOffset = getRealOffset(cityObj);
		$("#"+this.menuDivId).css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown);
	}
	
	function hideMenu() {
		$("#"+this.menuDivId).fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!( event.target.id == this.inputId || event.target.id == this.menuDivId || $(event.target).parents("#"+this.menuDivId).length>0)) {
			hideMenu();
		}
	}
}
})(jQuery);