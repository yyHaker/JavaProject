$(document).ready(function(){
	var obj = jQuery.parseJSON(sessionStorage.dd);
    console.log(obj);
    $("#ban_department3").val(obj.data.ban_department);
    $("#ban_name3").val(obj.data.ban_name);
    $("#ban_group3").text(obj.data.ban_group);
    $("#infoFrom").bindData(obj.data);
})