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
    <div id="pageTitleAroundev">
        <h1>
            <img id="imgBrandLogo" src="<%=request.getContextPath()%>/app/img/aroundev_logo_200x200.png" title="" alt="Aroundev logo"/>
            Aroundev
        </h1>
    </div>

    <div class="content">
        <!--<h1>${test}</h1>-->
    </div>

    <jsp:include page="include/js.jsp"/>
</body>
</html>
