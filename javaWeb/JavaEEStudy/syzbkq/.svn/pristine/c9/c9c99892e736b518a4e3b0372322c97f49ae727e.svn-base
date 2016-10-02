<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/module/common/config.jsp"%>
<link href="<%=path%>/assets/css/demo.css" rel="stylesheet" media="screen">
<title>Dialog控件样例</title>
<style>
.login-dialog .modal-dialog {
	width: 300px;
}
</style>
</head>
<body>

	<header class="jumbotron subhead">
		<div class="container">
			<h1>
				<a href="javascript:void(0);">Dialog控件样例</a>
			</h1>
			<p class="lead">基于Bootstrap模态框的组件封装。</p>
		</div>
	</header>

	<div class="container">

		<div class="row">
			<div class="col-md-3 bs-docs-sidebar">
				<ul class="nav nav-list bs-docs-sidenav">
					<li><a href="#instructions"><i class="icon-chevron-right"></i>
							说明</a></li>
					<li><a href="#simplest"><i class="icon-chevron-right"></i>
							简单的dialog</a></li>
					<li><a href="#title"><i class="icon-chevron-right"></i>
							Title设置</a></li>
					<li><a href="#ManipulatingTitle"><i class="icon-chevron-right"></i>
							操作Dialog Title</a></li>
					<li><a href="#ManipulatingMessage"><i class="icon-chevron-right"></i>
							操作Dialog内容</a></li>
					<li><a href="#LoadingPage1"><i class="icon-chevron-right"></i>
							远程加载页面(1)</a></li>
					<li><a href="#LoadingPage2"><i class="icon-chevron-right"></i>
							远程加载页面(2)</a></li>
					<li><a href="#Button"><i class="icon-chevron-right"></i> 
							添加按钮</a></li>
					<li><a href="#ButtonHotKey"><i class="icon-chevron-right"></i> 
							按钮快捷键</a></li>
					<li><a href="#MultipleDialogs"><i class="icon-chevron-right"></i> 
							打开多对话框</a></li>
					<li><a href="#DialogInstances"><i class="icon-chevron-right"></i> 
							实例化Dialog</a></li>
					<li><a href="#OpenCloseMultipleDialogs"><i class="icon-chevron-right"></i> 
							打开/关闭多个Dialog</a></li>
					<li><a href="#MessageTypes"><i class="icon-chevron-right"></i> 
							消息类型</a></li>
					<li><a href="#ChangingType"><i class="icon-chevron-right"></i> 
							改变对话框类型</a></li>
					<li><a href="#ChangingSizes"><i class="icon-chevron-right"></i> 
							改变对话框尺寸</a></li>
					<li><a href="#DialogClosable"><i class="icon-chevron-right"></i> 
							对话框是否可关闭</a></li>
					<li><a href="#moreCloseControls"><i class="icon-chevron-right"></i> 
							更多关闭控制</a></li>
					<li><a href="#DisablingAnimation"><i class="icon-chevron-right"></i> 
							禁用动画</a></li>
					<li><a href="#AutoSpinningIcon"><i class="icon-chevron-right"></i> 
							自动旋转图标</a></li>
					<li><a href="#DialogDraggable"><i class="icon-chevron-right"></i> 
							对话框拖拽</a></li>
					<li><a href="#DialogEvents"><i class="icon-chevron-right"></i> 
							事件</a></li>
					<li><a href="#Alert"><i class="icon-chevron-right"></i> 
							Alert</a></li>
					<li><a href="#AlertWithCallback"><i class="icon-chevron-right"></i> 
							Alert with callback</a></li>
					<li><a href="#CustomizingAlert"><i class="icon-chevron-right"></i> 
							自定义Alert</a></li>
					<li><a href="#Confirm"><i class="icon-chevron-right"></i> 
							Confirm</a></li>
					<li><a href="#ConfirmWithCallback"><i class="icon-chevron-right"></i> 
							ConfirmWithCallback</a></li>
					
				</ul>
			</div>

			<div class="col-md-9">

				<!-- instructions-->
				<section id="instructions">
					<div class="page-header">
						<h2>说明</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<p>原生调用一个bootstrap模态弹出框需要构造以下元素</p>
							<div class="source-code">
		<!--
	<div class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h4 class="modal-title">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        <p>One fine body…</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
      	-->
							</div>
						</div>
					</div>
				</section>

				<!-- simplest-->
				<section id="simplest">
					<div class="page-header">
						<h2>简单的dialog</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<p>只提供消息内容，其他默认</p>
							<div class="source-code runnable">
		<!--
        BootstrapDialog.show({
            message: 'Hello World!'
        });
      		-->
							</div>
						</div>

					</div>

				</section>

				<!-- title-->
				<section id="title">
					<div class="page-header">
						<h2>Title设置</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
		<!--
        BootstrapDialog.show({
            title: '你好',
            message: 'Hello World!'
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- Manipulating Dialog Title-->
				<section id="ManipulatingTitle">
					<div class="page-header">
						<h2>操作Dialog Title</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            title: '设置',
            message: '点击按钮进行操作',
            buttons: [{
                label: '下一步',
                action: function(dialog) {
                    dialog.setTitle('继续');
                }
            }, {
                label: '完成',
                action: function(dialog) {
                    dialog.setTitle('完成');
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- Manipulating Dialog Message-->
				<section id="ManipulatingMessage">
					<div class="page-header">
						<h2>操作Dialog内容</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            title: '默认标题',
            message: '点击按钮进行操作',
            buttons: [{
                label: 'Message 1',
                action: function(dialog) {
                    dialog.setMessage('消息1');
                }
            }, {
                label: 'Message 2',
                action: function(dialog) {
                    dialog.setMessage('消息2');
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>			
				
				<!-- loading page-->
				<section id="LoadingPage1">
					<div class="page-header">
						<h2>远程加载页面(1)</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: $('<div></div>').load('../assets/pages/test.html')
        });
        -->
							</div>
						</div>
					</div>
				</section>				

				<!-- loading page-->
				<section id="LoadingPage2">
					<div class="page-header">
						<h2>远程加载页面(2)</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<p>远程加载页面的另一种实现方式，更加灵活和可定制化，但较前一种方式写法复杂一些</p>
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: function(dialog) {
                var $message = $('<div></div>');
                var pageToLoad = dialog.getData('pageToLoad');
                $message.load(pageToLoad);
        
                return $message;
            },
            data: {
                'pageToLoad': '../assets/pages/test.html'
            }
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- button -->
				<section id="Button">
					<div class="page-header">
						<h2>添加按钮</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'Hi Apple!',
            buttons: [{
                label: 'Button 1'
            }, {
                label: 'Button 2',
                cssClass: 'btn-primary',
                action: function(){
                    alert('Hi Orange!');
                }
            }, {
                icon: 'glyphicon glyphicon-ban-circle',
                label: 'Button 3',
                cssClass: 'btn-warning'
            }, {
                label: 'Close',
                action: function(dialogItself){
                    dialogItself.close();
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- buttonHotKey -->
				<section id="ButtonHotKey">
					<div class="page-header">
						<h2>按钮快捷键</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            title: 'Button Hotkey',
            message: '试着按一下快捷键',
            onshow: function(dialog) {
                dialog.getButton('button-c').disable();
            },
            buttons: [{
                label: '(A) Button A',
                hotkey: 65, // Keycode of keyup event of key 'A' is 65.
                action: function() {
                    alert('Hello, 这是按钮A.');
                }
            }, {
                label: '(B) Button B',
                hotkey: 66,
                action: function() {
                    alert('Hello, 这是按钮B!');
                }
            }, {
                id: 'button-c',
                label: '(C) Button C',
                hotkey: 67,
                action: function(){
                    alert('这是按钮C,但是被禁用了.');
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- Opening multiple dialogs -->
				<section id="MultipleDialogs">
					<div class="page-header">
						<h2>打开多对话框</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        var shortContent = '<p>文本123456789.</p>';
        var longContent = 'hello';
        for(var i = 1; i <= 3; i++) {
            longContent += shortContent;
        }
        BootstrapDialog.show({
            title: '对话框C',
            message: longContent
        });
        BootstrapDialog.show({
            title: '对话框B',
            message: shortContent,
            draggable: true
        });
        BootstrapDialog.show({
            title: '对话框A',
            message: longContent,
            draggable: true
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- Creating dialog instances -->
				<section id="DialogInstances">
					<div class="page-header">
						<h2>实例化Dialog</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        // Using init options
        var dialogInstance1 = new BootstrapDialog({
            title: 'Dialog instance 1',
            message: 'Hi Apple!'
        });
        dialogInstance1.open();
        
        // Construct by using setters
        var dialogInstance2 = new BootstrapDialog();
        dialogInstance2.setTitle('Dialog instance 2');
        dialogInstance2.setMessage('Hi Orange!');
        dialogInstance2.setType(BootstrapDialog.TYPE_SUCCESS);
        dialogInstance2.open();
        
        // Using chain callings
        var dialogInstance3 = new BootstrapDialog()
            .setTitle('Dialog instance 3')
            .setMessage('Hi Everybody!')
            .setType(BootstrapDialog.TYPE_INFO)
            .open();
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- Message types -->
				<section id="MessageTypes">
					<div class="page-header">
						<h2>消息类型</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        var types = [BootstrapDialog.TYPE_DEFAULT, 
                     BootstrapDialog.TYPE_INFO, 
                     BootstrapDialog.TYPE_PRIMARY, 
                     BootstrapDialog.TYPE_SUCCESS, 
                     BootstrapDialog.TYPE_WARNING, 
                     BootstrapDialog.TYPE_DANGER];
                     
        $.each(types, function(index, type){
            BootstrapDialog.show({
                type: type,
                title: 'Message type: ' + type,
                message: 'What to do next?',
                buttons: [{
                    label: 'I do nothing.'
                }]
            });     
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- changing-dialog-type -->
				<section id="ChangingType">
					<div class="page-header">
						<h2>改变对话框类型</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        var types = [BootstrapDialog.TYPE_DEFAULT, 
                     BootstrapDialog.TYPE_INFO, 
                     BootstrapDialog.TYPE_PRIMARY, 
                     BootstrapDialog.TYPE_SUCCESS, 
                     BootstrapDialog.TYPE_WARNING, 
                     BootstrapDialog.TYPE_DANGER];
                     
        var buttons = [];
        $.each(types, function(index, type) {
            buttons.push({
                label: type,
                cssClass: 'btn-default btn-sm',
                action: function(dialog) {
                    dialog.setType(type);
                }
            });
        });

        BootstrapDialog.show({
            title: 'Changing dialog type',
            message: '点击下面按钮...',
            buttons: buttons
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- More dialog sizes -->
				<section id="ChangingSizes">
					<div class="page-header">
						<h2>改变对话框尺寸</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        var types = [BootstrapDialog.TYPE_DEFAULT, 
                     BootstrapDialog.TYPE_INFO, 
                     BootstrapDialog.TYPE_PRIMARY, 
                     BootstrapDialog.TYPE_SUCCESS, 
                     BootstrapDialog.TYPE_WARNING, 
                     BootstrapDialog.TYPE_DANGER];
                     
        var buttons = [];
        $.each(types, function(index, type) {
            buttons.push({
                label: type,
                cssClass: 'btn-default btn-sm',
                action: function(dialog) {
                    dialog.setType(type);
                }
            });
        });

        BootstrapDialog.show({
            title: 'Changing dialog type',
            message: '点击下面按钮...',
            buttons: buttons
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- Dialog closable / unclosable -->
				<section id="DialogClosable">
					<div class="page-header">
						<h2>对话框是否可关闭</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'Hi Apple!',
            closable: false,
            buttons: [{
                label: '可关闭!',
                cssClass: 'btn-success',
                action: function(dialogRef){
                    dialogRef.setClosable(true);
                }
            }, {
                label: '不可关闭!',
                cssClass: 'btn-warning',
                action: function(dialogRef){
                    dialogRef.setClosable(false);
                }
            }, {
                label: '关闭对话框',
                action: function(dialogRef){
                    dialogRef.close();
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- more-close-controls -->
				<section id="moreCloseControls">
					<div class="page-header">
						<h2>更多关闭控制</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<p>默认情况下，'closable'选项为'true'，除此之外还有两种关闭方式：ESC键和点击空白位置，默认都为'true'</p>
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'Hi Apple!',
            message: '不可通过ESC键和点击对话框外的方式关闭对话框.',
            closable: true,
            closeByBackdrop: false,
            closeByKeyboard: false,
            buttons: [{
                label: '关闭对话框',
                action: function(dialogRef){
                    dialogRef.close();
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- dialog-animate -->
				<section id="DisablingAnimation">
					<div class="page-header">
						<h2>禁用动画</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<p>设置'animate'选项，默认为'true'</p>
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'There is no fading effects on this dialog.',
            animate: false,
            buttons: [{
                label: 'Close the dialog',
                action: function(dialogRef){
                    dialogRef.close();
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>

				<!-- Auto spinning icon -->
				<section id="AutoSpinningIcon">
					<div class="page-header">
						<h2>自动旋转图标</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'I send ajax request!',
            buttons: [{
                icon: 'glyphicon glyphicon-send',
                label: 'Send ajax request',
                cssClass: 'btn-primary',
                autospin: true,
                action: function(dialogRef){
                    dialogRef.enableButtons(false);
                    dialogRef.setClosable(false);
                    dialogRef.getModalBody().html('Dialog closes in 5 seconds.');
                    setTimeout(function(){
                        dialogRef.close();
                    }, 5000);
                }
            }, {
                label: 'Close',
                action: function(dialogRef){
                    dialogRef.close();
                }
            }]
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- dialog-draggable -->
				<section id="DialogDraggable">
					<div class="page-header">
						<h2>对话框拖拽</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            title: 'Draggable Dialog',
            message: 'Try to drag on dialog title to move your dialog.',
            draggable: true
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- Dialog events -->
				<section id="DialogEvents">
					<div class="page-header">
						<h2>事件</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.show({
            message: 'Hello world!',
            onshow: function(dialogRef){
                alert('对话框弹出前执行，内容 ' + dialogRef.getMessage());
            },
            onshown: function(dialogRef){
                alert('对话框已经弹出');
            },
            onhide: function(dialogRef){
                alert('对话框关闭前执行，内容' + dialogRef.getMessage());
            },
            onhidden: function(dialogRef){
                alert('对话框已经关闭');
            }
        });
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- Alert -->
				<section id="Alert">
					<div class="page-header">
						<h2>Alert</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.alert('Hi Apple!');
        -->
							</div>
						</div>
					</div>
				</section>
				
				<!-- Alert with callback -->
				<section id="AlertWithCallback">
					<div class="page-header">
						<h2>Alert with callback</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.alert('Hi Apple!', function(){
            alert('Hi Orange!');
        });
        -->
							</div>
						</div>
					</div>
				</section>				
				
				<!-- Customizing dialog type, title, and more. -->
				<section id="CustomizingAlert">
					<div class="page-header">
						<h2>自定义Alert</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.alert({
            title: 'WARNING',
            message: 'Warning! No Banana!',
            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
            closable: true, // <-- Default value is false
            draggable: true, // <-- Default value is false
            buttonLabel: 'Roar! Why!', // <-- Default value is 'OK',
            callback: function(result) {
                // result will be true if button was click, while it will be false if users close the dialog directly.
                alert('Result is: ' + result);
            }
        });
        -->
							</div>
						</div>
					</div>
				</section>					
				
				<!-- Confirm -->
				<section id="Confirm">
					<div class="page-header">
						<h2>Confirm</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.confirm('Hi Apple, are you sure?');
        -->
							</div>
						</div>
					</div>
				</section>					
				
				<!-- Confirm with callback -->
				<section id="ConfirmWithCallback">
					<div class="page-header">
						<h2>Confirm with callback</h2>
					</div>

					<div>
						<div class="bs-docs-example">
							<div class="source-code runnable">
        <!--
        BootstrapDialog.confirm('Hi Apple, are you sure?', function(result){
            if(result) {
                alert('Yup.');
            }else {
                alert('Nope.');
            }
        });
        -->
							</div>
						</div>
					</div>
				</section>					
				
			</div>
		</div>

	</div>

	<script type="text/javascript">
		$(function() {
			$('.source-code').each(
				function(index) {
					var $section = $(this);
					var code = $(this).html().replace('<!--', '').replace('-->', '');
					// Code preview
					var $codePreview = $('<pre class="prettyprint lang-javascript"></pre>');
					$codePreview.text(code);
					$section.html($codePreview);
					// Run code
					if ($section.hasClass('runnable')) {
						var $button = $('<button class="btn btn-primary">运行实例</button>');
						$button.on('click', {
							code : code
						}, function(event) {
							eval(event.data.code);
						});
						$button.insertAfter($section);
						$('<div class="clearfix" style="margin-bottom: 10px;"></div>').insertAfter($button);
					}
				});
		});
	</script>

</body>
</html>