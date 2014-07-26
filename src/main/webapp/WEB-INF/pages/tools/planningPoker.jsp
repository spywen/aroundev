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
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/../app/img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/../app/css/plugins.app.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/../app/css/app.min.css"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../menu.jsp"/>
    <div id="planningPoker" class="content" data-ng-app="planningPoker">
        <h1>Planning poker</h1>

        <div class="row">
            <div class="col-md-4" data-ng-controller="grooming">
                <div class="panel panel-primary">
                    <div class="panel-heading">Grooming session</div>
                    <div class="panel-body">
                        <div>
                            <button class="btn btn-default btn-sm" data-ng-click="toggle = !toggle">New grooming session</button>
                            <div data-ng-show="toggle">
                                New grooming session
                            </div>
                        </div>
                        <div>
                            <a>URL</a>
                        </div>
                        <div>
                            <h3>Participants</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading">Stories</div>
                    <div class="panel-body">
                        <div class="panel panel-default cards">
                            <div class="panel-heading">Current story</div>
                            <div class="panel-body">
                                <div class="cardsChoose">
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                </div>
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
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!---->

    </div>

    <script src="<%=request.getContextPath()%>/../app/js/plugins.all.min.js"></script>
    <script src="<%=request.getContextPath()%>/../app/js/app.min.js"></script>
</body>
</html>
