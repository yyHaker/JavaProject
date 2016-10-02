<!-- THE-NODE-OF-RELOGIN-SUCCESSFUL -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>房地产一体化信息交换平台</title>
</head>
<script>
    var width=1024;
    var height=768 -57;
    
    if(screen.width <=1024){
        width = screen.availWidth;
    }
    
    if(screen.height <= 768){           
        height = screen.availHeight -57;//减去状态栏高度
    }
    
    var screenX=0;
    var screenY=0;
   
    if(screen.width > 1024){
        screenX = (screen.availWidth -width)/2;
    }
    if(screen.height>768){
        screenY = (screen.availHeight-768)/2;
    }
            
    var sFeatures = "toolbar=0,location=0,directories=0,status=1,menubar=0";
    sFeatures += ",scrollbars=0,resizable=1,left="+screenX+"px,top="+screenY+"px,width="+width+"px,height="+height+"px channelmode";
    
    //随机产生窗口的名字
    var sName = new Date().getTime(); 
    var requestPath = "<%=request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort()+ request.getContextPath()%>";
	var newLocation = requestPath + "/index.do";
	var selfWin = window.open(newLocation, sName, sFeatures);
	window.opener = null;
       window.open('','_self');
       self.close();
	
	//window.location.href = newLocation;
</script>
<body>
</body>
</html>
