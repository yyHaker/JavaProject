
/**
 * 获取浏览器窗口宽度
 * @returns
 */
function commonGetHeight() {
	return top.document.body.clientHeight;
}

/**
 * 电话号码正则验证
 * @param obj
 * @returns {Boolean}
 */
function IsTelephone(obj){ 
	var pattern=/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/; 
	if(pattern.test(obj)){ 
		return true; 
	} 
	
	return false; 
} 