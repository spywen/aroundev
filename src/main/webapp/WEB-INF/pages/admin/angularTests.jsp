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
    <div data-ng-app="angularTests">
        <h1>Test angular</h1>
        <div data-ng-controller="MainCtrl">
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
            <a data-ad-ok-btn></a>
            <a data-ad-cancel-btn></a>
        </div>

        <div data-ng-controller="ngRepeatCtrl">
            <h2>ng-repeat</h2>
            <p>Type a few numbers below to watch the filter</p>
            <input type="text" data-ng-model="lowerBound" />
            <ul>
                <li data-ng-repeat="number in numbers | filter:greaterThanNum">
                    {{ number }}
                </li>
            </ul>
        </div>

        <div data-ng-controller="bindingCtrl">
            <h2>2 ways binding</h2>
            <input type="text" data-ng-model="myName" placeholder="type your name ..."/>
            <p>{{ myName }}</p>
        </div>

        <div data-ng-controller="webServiceCtrl">
            <h2>web service</h2>
            <p>{{ users.length > 0 && users.length + ' user(s)' || 'No user'}}</p>
            <p>
                <input data-ng-model="pseudoStringSearch[queryBy]" type="text" placeholder="search ..."/>
                <input type="hidden" value="$" data-ng-model="queryBy"/>
                <!--<td>
                    <select ng-model="queryBy">
                        <option value="$"></option>
                        <option value="name">NAME</option>
                        <option value="company">COMPANY</option>
                        <option value="designation">DESIGNATION</option>
                    </select>
                </td>-->
            </p>
            <ul>
                <li data-ng-repeat="user in users | filter:pseudoStringSearch">
                    {{user.firstname}} - {{user.lastname}} - {{user.pseudo}} - {{user.registerdate | date:'dd/MM/yyyy, HH:mm:ss'}}
                    <a data-ng-click="delete($index)" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a>
                </li>
            </ul>
        </div>

        <div>
            <h2>ng show toggle</h2>
            <a href="" data-ng-click="toggle = !toggle" class="btn btn-primary btn-sm">Afficher menu</a>
            <div data-ng-show="toggle">
                coucou !
            </div>
        </div>

        <div data-ng-controller="docSourceCtrl">
            <h4>doc sources : </h4>
            <ul>
                <li data-ng-repeat="doc in docs"><a href="{{doc.url}}" target="_blank">{{doc.name}}</a></li>
            </ul>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/../app/js/plugins.all.min.js"></script>
<script src="<%=request.getContextPath()%>/../app/js/app.min.js"></script>
</body>
</html>