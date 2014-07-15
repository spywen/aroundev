<%--
  Created by IntelliJ IDEA.
  User: laurent
  Date: 06/07/2014
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Plannin poker - Aroundev.com</title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/app/img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/boostrap-flatly.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/app/css/style.css"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div id="planningPoker" class="content">
        <h1>Planning poker</h1>

        <div class="panel panel-default">
            <div class="panel-heading">Planning poker</div>
            <div class="panel-body">
                <div class="cardsSelection">
                    <button class="btn btn-primary">0</button>
                    <button class="btn btn-primary">0.5</button>
                    <button class="btn btn-primary">1</button>
                    <button class="btn btn-primary">2</button>
                    <button class="btn btn-primary">3</button>
                    <button class="btn btn-primary">5</button>
                    <button class="btn btn-primary">8</button>
                    <button class="btn btn-primary">13</button>
                    <button class="btn btn-primary">21</button>
                    <button class="btn btn-primary">34</button>
                    <button class="btn btn-primary">55</button>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/app/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/app/js/bootstrap.js"></script>
</body>
</html>
