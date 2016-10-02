//收集表单信息
    //给jQuery类添加扩展方法
	$.fn.extend({
		/**
					 * 判断是否收集空字符串信息 
					 * @param hasval
					 * true  收集空串
					 * false  不收集空串
					 */
		collect: function(hasval){
			var parameters = {};
			var _unCheckName = {};
			$(":input",this).each(function(i){
				var item = $(this);
				if(item.attr("bindname")&&!_unCheckName[item.attr("bindname")]){
					if(item.attr("type")=='radio'){
						if(!item.prop("checked")){
							return;
						}
						if(parameters[item.attr("bindname")]==null||parameters[item.attr("bindname")]==''){
							parameters[item.attr("bindname")] = item.val();
						}
						return;	
					}
					if(item.attr("type")=='checkbox'){
						/**
						 * stand  check box
						 */
						if(!item.prop("checked")){
							return;
						}
						if(parameters[item.attr("bindname")]==null||parameters[item.attr("bindname")]==''){
							parameters[item.attr("bindname")] = this.checked?item.val():'';
						}else{
							parameters[item.attr("bindname")] += "," + $(this).val();
						}
						return;
					}
					if(item.attr("multiple")){
						parameters[item.attr("bindname")] = item.multipleSelect('getSelects').join(",");
						return;
					}
					if(item.attr("dateType")){
						var format = item.attr("dateType");
						if(format ==="YYYYMMDD"){
							var dd = (item.val().toString()).replaceAll(" ","").replaceAll("-","").replaceAll(":","").replaceAll("/","").replaceAll("年","").replaceAll("月","").replaceAll("日","").replaceAll("时","").replaceAll("分","");
							dd = dd.substr(0,8);
						}
						if(format ==="YYYYMMDDHHMISS"){
							var dd = (item.val().toString()).replaceAll(" ","").replaceAll("-","").replaceAll(":","").replaceAll("/","").replaceAll("年","").replaceAll("月","").replaceAll("日","").replaceAll("时","").replaceAll("分","");
							if(dd.length == 12){
								dd = dd+"00";
							}
						}
						parameters[item.attr("bindname")] = dd;
						return;
					}
					
					if(item.attr("listId")){
						parameters[item.attr("bindname")] = item.attr("listId");
						return;
					}
					
					if(hasval){
						if(item.val()!=null&&item.val()!=''){
							parameters[item.attr("bindname")] = item.val().toString();
						}else{
							parameters[item.attr("bindname")] = '';
						}
					}else{
						if(item.val()!=null&&item.val()!=''){
							parameters[item.attr("bindname")] = item.val().toString();
						}
					}
					
					
				}
			});
			return parameters;
		},
		bindData: function(parameters){
			$(":input",this).each(function(i){
				var item = $(this);
				if(item.attr("bindname")){
					if(item.attr("type")=='radio'){
						if(this.value == parameters[item.attr("bindname")]){
							item.iCheck('check');
						}
						return;	
					}
					if(item.attr("type")=='checkbox'){
						if(parameters[item.attr("bindname")] != null){
							var uiValue = this.value;
							var arrays = (parameters[item.attr("bindname")].split(","));
							item.iCheck('uncheck');
							$.each(arrays,function(n,vv){
								if(uiValue == vv){
									item.iCheck('check');
									return;
								}
							});
						}
						return;
					}
					if(item.attr("multiple")){
						//item.multipleSelect('setSelectValue',(parameters[item.attr("bindname")]));
						item.multipleSelect('setSelects',(parameters[item.attr("bindname")]||'').toString().split(","));
						return;
					}
					item.val(parameters[item.attr("bindname")]);
				}
			});
		},
		condition:function(){
			var parameters = [];
			var _unCheckName = {};
			$(":input",this).each(function(i){
				var item = $(this);
				if(item.attr("bindname")&&!_unCheckName[item.attr("bindname")]){
					if(item.val()!=null&&item.val()!=''){
						var tempCondition = {};
						tempCondition["cols"] = item.attr("bindname");
						tempCondition["oper"] = item.attr("operation");
						tempCondition["val"] = item.val().toString();
						parameters.push(tempCondition);
					}
				}
			});
			return parameters;
		}

		});