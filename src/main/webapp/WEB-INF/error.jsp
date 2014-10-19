<%--
  Created by IntelliJ IDEA.
  User: laurent
  Date: 19/10/2014
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error - Aroundev.com</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="app/img/favicon.png" />

    <link rel="stylesheet" href="/app/js/lib/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/app/css/theme/bootstrap.min.css">
</head>
<body >
    <div style="width: 700px; margin: auto;">
        <div class="row">
            <div class="col-md-4" style="font-size: 90px">
                ${code}
            </div>
            <div class="col-md-8" style="margin-top: 100px">
                <h2>
                    ${message}
                </h2>
                <div style="font-weight: 100">
                    ${errorMessage}
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <i class="fa fa-thumbs-o-down" style="font-size:160px"></i>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="text-align: right;">
                <a href="/" class="btn btn-default">Return to Aroundev Home Page</a>
            </div>
        </div>
    </div>
</body>
</html>
