<%--
  Created by IntelliJ IDEA.
  User: laurent
  Date: 18/10/2014
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html data-ng-app="aroundev">
<head>
    <title>Aroundev</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="app/img/favicon.png" />

    <!-- inject:css -->
    <link rel="stylesheet" href="/app/js/lib/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/app/js/lib/toastr/toastr.min.css">
    <!-- endinject -->

    <!-- flatly boostrap theme -->
    <link rel="stylesheet" href="/app/css/theme/bootstrap.min.css">

    <link rel="stylesheet" href="/app/css/all.min.css">
    <base href="/">
</head>
<body data-ng-cloak>

    <div id="menu" data-ng-controller="menuCtrl">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">
                        <img id="imgBrandLogo" src="/app/img/aroundev_logo_200x200.png" title="Aroundev" alt="Aroundev logo"/>
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">{{ MENU_SUPPORT | translate }}</a></li>
                        <li class="dropdown" data-ng-controller="translateCtrl">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">{{ 'MENU_LANGUAGE' | translate }} <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a data-ng-click="changeLanguage('fr')" class="pointer"><i class="fa fa-check" data-ng-show="fr"></i> {{ 'MENU_FR' | translate }}</a></li>
                                <li><a data-ng-click="changeLanguage('en')" class="pointer"><i class="fa fa-check" data-ng-show="en"></i> {{ 'MENU_EN' | translate }}</a> </li>
                            </ul>
                        </li>
                        <sec:authorize ifAllGranted="AUTHENTICATED">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i> <sec:authentication property="principal.username"/> <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">{{ 'MENU_MY_ACCOUNT' | translate }}</a></li>
                                    <li class="divider"></li>
                                    <li><a data-ng-click="logOut()" href="#">{{ 'MENU_LOGOUT' | translate }}</a></li>
                                </ul>
                            </li>
                        </sec:authorize>
                        <sec:authorize ifNotGranted="AUTHENTICATED">
                            <li><a href="/login">{{ 'MENU_LOGIN' | translate }}</a></li>
                        </sec:authorize>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

    <div class="content {{ pageClass }} animation" data-ng-view>

    </div>

    <!-- inject:js -->
    <script src="/app/js/lib/jquery/dist/jquery.min.js"></script>
    <script src="/app/js/lib/lodash/dist/lodash.compat.min.js"></script>
    <script src="/app/js/lib/angular/angular.min.js"></script>
    <script src="/app/js/lib/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
    <script src="/app/js/lib/restangular/dist/restangular.min.js"></script>
    <script src="/app/js/lib/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/app/js/lib/angular-cookies/angular-cookies.min.js"></script>
    <script src="/app/js/lib/angular-route/angular-route.min.js"></script>
    <script src="/app/js/lib/angular-translate/angular-translate.min.js"></script>
    <script src="/app/js/lib/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js"></script>
    <script src="/app/js/lib/angular-translate-storage-cookie/angular-translate-storage-cookie.min.js"></script>
    <script src="/app/js/lib/angular-translate-loader-url/angular-translate-loader-url.min.js"></script>
    <script src="/app/js/lib/toastr/toastr.min.js"></script>
    <script src="/app/js/lib/angular-animate/angular-animate.min.js"></script>
    <!-- endinject -->

    <script src="/app/js/all.min.js"></script>
</body>
</html>
