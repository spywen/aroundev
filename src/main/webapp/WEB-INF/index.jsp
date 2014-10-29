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
    <link rel="stylesheet" href="/app/js/lib/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/app/js/lib/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/app/js/lib/toastr/toastr.min.css">
    <!-- endinject -->

    <!-- flatly boostrap theme
    <link rel="stylesheet" href="/app/css/theme/bootstrap.min.css">-->

    <link rel="stylesheet" href="/app/css/all.min.css">
    <base href="/">
</head>
<body data-ng-cloak>

    <!--Menu directive-->
    <menu id="menu"></menu>

    <!-- Page views -->
    <div class="content {{ pageClass }} view-animation" data-ng-view></div>


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
