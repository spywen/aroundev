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
    <link rel="stylesheet" href="/app/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="/app/lib/angular-toastr/dist/angular-toastr.css">
    <link rel="stylesheet" href="/app/lib/animate.css/animate.css">
    <link rel="stylesheet" href="/app/lib/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="/app/lib/ladda/dist/ladda-themeless.min.css">
    <!-- endinject -->

    <link rel="stylesheet" href="/app/css/all.css">
    <base href="/">
</head>
<body data-ng-cloak data-ng-app="aroundev">

    <!--Menu directive-->
    <menu id="menu"></menu>

    <!-- Page views -->
    <div class="content {{ pageClass }} view-animation" data-ui-view></div>


    <!-- inject:js -->
    <script src="/app/lib/lodash/dist/lodash.compat.js"></script>
    <script src="/app/lib/angular/angular.js"></script>
    <script src="/app/lib/angular-bootstrap/ui-bootstrap.js"></script>
    <script src="/app/lib/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <script src="/app/lib/angular-ui-router/release/angular-ui-router.js"></script>
    <script src="/app/lib/restangular/dist/restangular.js"></script>
    <script src="/app/lib/jquery/dist/jquery.js"></script>
    <script src="/app/lib/angular-cookies/angular-cookies.js"></script>
    <script src="/app/lib/angular-translate/angular-translate.js"></script>
    <script src="/app/lib/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
    <script src="/app/lib/angular-translate-storage-cookie/angular-translate-storage-cookie.js"></script>
    <script src="/app/lib/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="/app/lib/angular-animate/angular-animate.js"></script>
    <script src="/app/lib/angular-toastr/dist/angular-toastr.js"></script>
    <script src="/app/lib/angular-mocks/angular-mocks.js"></script>
    <script src="/app/lib/spin.js/spin.js"></script>
    <script src="/app/lib/moment/moment.js"></script>
    <script src="/app/lib/ladda/dist/ladda.min.js"></script>
    <script src="/app/lib/ladda/dist/spin.min.js"></script>
    <script src="/app/lib/angular-ladda/dist/angular-ladda.min.js"></script>
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
    <script src="/app/views/partials.js"></script>
    <script src="/app/js/all.js"></script>
</body>
</html>
