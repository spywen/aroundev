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
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
<body id="index" data-ng-app="aroundevApp">

    <jsp:include page="menu.jsp"/>
    <div class="title">
        <h1>
            <img id="imgBrandLogo" src="<%=request.getContextPath()%>/app/img/aroundev_logo_200x200.png" title="" alt="Aroundev logo"/>
            Aroundev
        </h1>
    </div>

    <div class="content">
        <div class="row">
            <div class="col-md-4">
                <i class="fa fa-home"></i>
                <h2>{{ 'INDEX_POINT_1_TITLE' | translate }}</h2>
                <p>{{ 'INDEX_POINT_1_DESC' | translate }}</p>
            </div>
            <div class="col-md-4">
                <i class="fa fa-wrench"></i>
                <h2>{{ 'INDEX_POINT_2_TITLE' | translate }}</h2>
                <p>{{ 'INDEX_POINT_2_DESC' | translate }}</p>
            </div>
            <div class="col-md-4">
                <i class="fa fa-money"></i>
                <h2>{{ 'INDEX_POINT_3_TITLE' | translate }}</h2>
                <p>{{ 'INDEX_POINT_3_DESC' | translate }}</p>
            </div>
        </div>
    </div>

    <jsp:include page="include/js.jsp"/>
</body>
</html>
