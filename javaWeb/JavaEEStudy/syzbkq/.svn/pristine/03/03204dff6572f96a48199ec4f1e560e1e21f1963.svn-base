/**
 * multiple-select-master 控件扩展类
 * 功能描述：动态加载json数据
 */

	multipleSelectData= function(selectId,json) {
        var jsonObj = jQuery.parseJSON(json);
        var options = $(this);
		$.each(jsonObj,function(n,item){
			$("#"+selectId).append("<option value='"+item["code"]+"'>"+item["value"]+"</option>");
		});
    }