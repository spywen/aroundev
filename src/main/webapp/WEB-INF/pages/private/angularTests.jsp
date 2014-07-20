<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Angular tests - Aroundev.com</title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/../app/img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/../app/css/plugins.app.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/../app/css/app.min.css"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="content">
    <div ng-app="angularTests">
        <h1>Test angular</h1>
        <div ng-controller="MainCtrl">
            {{ text }}
        </div>
        <p>
            <a ad-ok-btn></a>
            <a ad-cancel-btn></a>
        </p>
    </div>
</div>

<script src="<%=request.getContextPath()%>/../app/js/plugins.all.min.js"></script>
<script src="<%=request.getContextPath()%>/../app/js/app.min.js"></script>
</body>
</html>