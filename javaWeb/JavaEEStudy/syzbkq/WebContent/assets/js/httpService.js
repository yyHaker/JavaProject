
//后台ajax数据传输对象
function HttpService(){
	this.action = "default.do";
	this.moduleUrl = "";
	this.type="POST";
	this.contentType  = "multipart/form-data; charset=UTF-8";
	this.callback = [];
	this.errors = [];
	this.dataType = 'json';
	this.parameters = {};
	this.timeout = 180*1000;  //3分钟
	this.async = true;
	this.cache=false;
	this.global=false;
	this.processData=false;
	this.data;
}
HttpService.prototype.setAsync = function(value){
	this.async = value;
}
HttpService.prototype.putParameter = function(key,value){
	this.parameters[key] = value;
}
HttpService.prototype.setParameter = function(parameters){
	this.parameters = parameters;
}
HttpService.prototype.setModuleUrl = function(value){ 
	this.moduleUrl = value;
}
HttpService.prototype.setDataType = function(value){ 
	this.dataType = value;
}
HttpService.prototype.setAction = function(value){ 
	this.action = value;
}
HttpService.prototype.setCallback = function(fun){
	this.callback.push(fun);
}
HttpService.prototype.setErrorCallback = function(fun){
	this.errors.push(fun);
}
HttpService.prototype.error = function(XMLHttpRequest, textStatus, errorThrown){
	for(var i=0;i<this.errors.length;i++){
		this.errors[i].call(this, XMLHttpRequest, textStatus, errorThrown);
	}
}

HttpService.prototype.setSuccess = function(fun){
	this.success = fun;
}

HttpService.prototype.setData = function(data){
	this.data = jQuery.parseJSON(data);
}
HttpService.prototype.post = function(){
	this.url  = path +"/"+this.moduleUrl +"/"+ this.action;
	$.ajax(this);
}