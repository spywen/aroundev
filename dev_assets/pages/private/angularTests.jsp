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
            <div>
                <h2>controllers</h2>
                {{ text }}
            </div>
            <div>
                <h2>filtres</h2>
                <p>Without filter : {{text}}</p>
                <p>With filter : {{text | reverse }}</p>
            </div>
        </div>
        <div>
            <h2>directives</h2>
            <a ad-ok-btn></a>
            <a ad-cancel-btn></a>
        </div>
        <div ng-controller="ngRepeatCtrl">
            <h2>ng-repeat</h2>
            <p>Type a few numbers below to watch the filter</p>
            <input type="text" ng-model="lowerBound" />
            <ul>
                <li ng-repeat="number in numbers | filter:greaterThanNum">
                    {{ number }}
                </li>
            </ul>
        </div>
        <div ng-controller="bindingCtrl">
            <h2>2 ways binding</h2>
            <input type="text" ng-model="myName" placeholder="type your name ..."/>
            <p>{{ myName }}</p>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/../app/js/plugins.all.min.js"></script>
<script src="<%=request.getContextPath()%>/../app/js/app.min.js"></script>
</body>
</html>