<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/page/admin/common/base.jsp" %>
<!doctype html>
<html>
<head>
    <title>日日煮后台管理系统</title>
</head>
<body>
<div id="loginPage">
        <div class="title"><img src="<%=basePath %>images/ddc.png" alt="">日日煮后台管理系统</div>
        <form action="" method="post">
            <div class="box">
                <label>用户名:</label>
                <input id="username" name="username" type="text">
            </div>
            <div class="box">
                <label>密 &nbsp; 码:</label>
                <input id="password" name="password" type="password">
            </div>
            <div  class="loginBtn"><a href="javascript:login();">登&nbsp;录</a></div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function(){
        $(document).keydown(function(e){
            if(e.keyCode == 13) {
                login();
            }
        });
        if('${login}' == '0'){
            window.top.location = '<%=basePath %>dologin.do';
        }
    });

    function login(){
        var username = $('#username').val();
        var password = $('#password').val();
        var url = '<%=basePath%>login.do?username=' + username + '&password=' + password;
        $.ajax({
            url: url,
            async: false,
            cache: false,
            type: 'POST',
            success: function (msg) {
                if (msg.type == 'success') {
                    location.href = "<%=basePath%>manager/index.do";
                } else {
                    alert(msg.content);
                }
            },
            error: function () {
                alert('系统错误');
            }
        });
    }
</script>
</html>
