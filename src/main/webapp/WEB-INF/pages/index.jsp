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
<body id="index">

    <jsp:include page="menu.jsp"/>
    <div class="title">
        <h1>
            <img id="imgBrandLogo" src="<%=request.getContextPath()%>/app/img/aroundev_logo_200x200.png" title="" alt="Aroundev logo"/>
            Aroundev
        </h1>
    </div>

    <div class="content">
        <!--<h1>${test}</h1>-->
        <div class="row">
            <div class="col-md-4">
                <i class="fa fa-home"></i>
                <h2>Home sweet home</h2>
                <p>Ô developers all around the world this platform is dedicated to you. Consider Aroundev like your home.</p>
                <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div>
            <div class="col-md-4">
                <i class="fa fa-wrench"></i>
                <h2>Dev tooling</h2>
                <p>Find here all the tooling you need to dev well and simple with all your collaborator.</p>
                <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div>
            <div class="col-md-4">
                <i class="fa fa-money"></i>
                <h2>Free solution</h2>
                <p>Aroundev is a platform solution which will give you all your, free of charges, weapons.</p>
                <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div>
        </div>
    </div>

    <jsp:include page="include/js.jsp"/>
</body>
</html>
