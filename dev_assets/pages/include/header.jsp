<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>${param.title} - Aroundev.com</title>
    <meta charset="utf-8"/>

    <!--Favicon-->
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/app/img/favicon.png" />

    <!--Style-->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/plugins.all.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/app.min.css"/>

    <!--Icons-->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <!--Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <!--Jquery 2.* <=> does not support IE < 9 !!! required by Angular JS !!!-->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <!--plugins-->
    <script src="<%=request.getContextPath()%>/app/js/plugins.all.min.js"></script>
    <!--aroundev scripts-->
    <script src="<%=request.getContextPath()%>/app/js/app.min.js"></script>
</head>