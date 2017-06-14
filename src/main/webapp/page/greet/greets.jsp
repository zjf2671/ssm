<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/page/common/base.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>小型婚礼</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<script type="text/javascript" src="<%=basePath%>js/greets.js"></script>
	</head>
	<body>
		<div class="box">
			<!-- 场景七 -->
			<div class="seven-box">
				<div class="clickMe">点我送祝福</div>
				<div class="seven-content">
					<c:forEach items="${greetings }" var="greet" varStatus="status">
						<div id="${greet.id}" class="${greet.classes}"
							style="${greet.style}">${greet.text}</div>
					</c:forEach>
				</div>
			</div>
		</div>
		 <!-- 遮罩层 -->
        <div class="mask"></div>
        <div class="pop-box">
            <h1>送上祝福语</h1>
            <textarea id="write">写上您的祝福吧~</textarea>
            <div class="u-sure" id="uSure">确定</div>
        </div>
	</body>
</html>