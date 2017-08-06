<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/page/common/base.jsp"%>
<!doctype html>
<html>
<head>
<title>测试</title>
<style type="text/css">
input[readonly] {
	background-color: #f8f8f8;
}
</style>
</head>
<body>
	${test}

	<div>
		<label>Ueditor：</label>
		<div>
			<script id="editor" type="text/plain"
				style="width: 1024px; height: 500px;"></script>
		</div>
		<script type="text/javascript">
			//实例化编辑器
			//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
			var ue = UE.getEditor('editor');
			
			function  getContent(){
				alert(ue.getContent());
			}
			
		</script>
	</div>
	
	<div>
		<input type="button" value="取值" onclick="getContent()"/>
	</div>

</body>
</html>
