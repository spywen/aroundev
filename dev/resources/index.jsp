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
    <!-- endinject -->

    <link rel="stylesheet" href="/app/css/all@MINIFY@css">
    <base href="/">
</head>
<body data-ng-cloak data-ng-app="aroundev">

    <!--Menu directive-->
    <menu id="menu"></menu>

    <!-- Page views -->
    <div class="content {{ pageClass }} view-animation" data-ui-view></div>


    <!-- inject:js -->
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
    <script src="/app/views/partials@MINIFY@js"></script>
    <script src="/app/js/all@MINIFY@js"></script>
</body>
</html>
