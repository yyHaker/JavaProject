var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: 0
		}
	}
}; 
  
var zTree;  
var treeNodes;  
  
$(function(){  
    $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: path+"/form/getTree", 
        error: function (e) {//请求失败处理函数  
            alert(e.responseText+'请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
        }  
    });  
  
    /* zTree = $("#tree").zTree(setting, treeNodes); */
	zTree = $.fn.zTree.init($("#tree"), setting, treeNodes);
    
});  
