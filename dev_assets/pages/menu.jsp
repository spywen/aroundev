<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="menu" data-ng-app="aroundevApp">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/">
                    <img id="imgBrandLogo" src="<%=request.getContextPath()%>/app/img/aroundev_logo_200x200.png" title="Aroundev" alt="Aroundev logo"/>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">{{ MENU_SUPPORT | translate }}</a></li>
                    <li class="dropdown" ng-controller="translateCtrl">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">{{ 'MENU_LANGUAGE' | translate }}<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a ng-click="changeLanguage('fr')"><i class="fa fa-check" data-ng-show="fr"></i> {{ 'MENU_FR' | translate }}</a></li>
                            <li><a ng-click="changeLanguage('en')"><i class="fa fa-check" data-ng-show="en"></i> {{ 'MENU_EN' | translate }}</a> </li>
                        </ul>
                    </li>
                    <sec:authorize ifAllGranted="AUTHENTICATED">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i> <sec:authentication property="principal.username"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">{{ 'MENU_MY_ACCOUNT' | translate }}</a></li>
                            <li class="divider"></li>
                            <li><a href="/logout">{{ 'MENU_LOGOUT' | translate }}</a></li>
                        </ul>
                    </li>
                    </sec:authorize>
                    <sec:authorize ifNotGranted="AUTHENTICATED">
                        <li><a href="<%=request.getContextPath()%>/login">{{ 'MENU_LOGIN' | translate }}</a></li>
                    </sec:authorize>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>