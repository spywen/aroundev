<%--
  Created by IntelliJ IDEA.
  User: laurent
  Date: 06/07/2014
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil - Aroundev.com</title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/app/img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/boostrap-flatly.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/style.css"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>

    <script src="<%=request.getContextPath()%>/app/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/app/js/bootstrap.js"></script>
</body>
</html>
