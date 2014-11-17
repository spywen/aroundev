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

<html data-ng-app="configs">
<head>
    <title>Aroundev</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="app/img/favicon.png" />

    <!-- inject:css -->
    <link rel="stylesheet" href="/app/js/lib/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/app/js/lib/angular-toastr/dist/angular-toastr.min.css">
    <link rel="stylesheet" href="/app/js/lib/animate.css/animate.min.css">
    <link rel="stylesheet" href="/app/js/lib/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/app/js/lib/ladda/dist/ladda-themeless.min.css">
    <!-- endinject -->

    <!-- flatly boostrap theme
    <link rel="stylesheet" href="/app/css/theme/bootstrap.min.css">-->

    <link rel="stylesheet" href="/app/css/all.min.css">
    <base href="/">
</head>
<body data-ng-cloak data-ng-app="aroundev">

    <!--Menu directive-->
    <menu id="menu"></menu>

    <!-- Page views -->
    <div class="content {{ pageClass }} view-animation" data-ui-view></div>


    <!-- inject:js -->
    <script src="/app/js/lib/lodash/dist/lodash.compat.min.js"></script>
    <script src="/app/js/lib/angular/angular.min.js"></script>
    <script src="/app/js/lib/angular-bootstrap/ui-bootstrap.min.js"></script>
    <script src="/app/js/lib/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
    <script src="/app/js/lib/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="/app/js/lib/restangular/dist/restangular.min.js"></script>
    <script src="/app/js/lib/jquery/dist/jquery.js"></script>
    <script src="/app/js/lib/angular-cookies/angular-cookies.min.js"></script>
    <script src="/app/js/lib/angular-translate/angular-translate.min.js"></script>
    <script src="/app/js/lib/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js"></script>
    <script src="/app/js/lib/angular-translate-storage-cookie/angular-translate-storage-cookie.min.js"></script>
    <script src="/app/js/lib/angular-translate-loader-url/angular-translate-loader-url.min.js"></script>
    <script src="/app/js/lib/angular-animate/angular-animate.min.js"></script>
    <script src="/app/js/lib/angular-toastr/dist/angular-toastr.min.js"></script>
    <script src="/app/js/lib/angular-mocks/angular-mocks.js"></script>
    <script src="/app/js/lib/spin.js/spin.js"></script>
    <script src="/app/js/lib/moment/moment.js"></script>
    <script src="/app/js/lib/ladda/dist/ladda.min.js"></script>
    <script src="/app/js/lib/ladda/dist/spin.min.js"></script>
    <script src="/app/js/lib/angular-ladda/dist/angular-ladda.min.js"></script>
    <!-- endinject -->

    <script>
        window.user = ${userConnected};
        angular.module('configs',[
            'aroundev'
        ])
        .constant('configs', {
            defaultLanguage: '${defaultLanguage}',
            translateAllowed: ${translateAllowed}
        });
    </script>
    <script src="/app/js/all.min.js"></script>
</body>
</html>
