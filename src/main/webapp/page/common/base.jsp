<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var ctx = '${ctx }';
</script>

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css">

<script src="<%=basePath%>js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-ui-1.10.2.custom.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=basePath%>css/index.css" />
<script type="text/javascript" charset="utf-8" src="<%=basePath%>statics/ueditor1_4_3_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>statics/ueditor1_4_3_3/ueditor.all.min.js"> </script>
<style type="text/css">
    body {
        font-family: "微软雅黑";
    }

    #line-chart {
        height: 300px;
        width: 800px;
        margin: 0px auto;
        margin-top: 1em;
    }

    .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
        color: #fff;
    }
</style>

<script type="text/javascript">
    $(function () {
		
    });
</script>


