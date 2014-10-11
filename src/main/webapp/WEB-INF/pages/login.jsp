<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
<body id="bodyLogin" data-ng-app="aroundevApp">
    <jsp:include page="menu.jsp"/>

    <c:url value="/login" var="loginUrl"/>

    <div class="content">
        <div class="container login">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">{{'LOGIN_TITLE' | translate}}</h1>

                    <c:if test="${'fail' eq param.auth}">
                        <div class="alert alert-danger text-center">
                            {{ 'LOGIN_LOG_IN_FAILED' | translate }}
                        </div>
                    </c:if>

                    <c:if test="${not empty param.logout}">
                        <div class="alert alert-success text-center">
                            {{ 'LOGIN_LOG_OUT_SUCCESS' | translate }}
                        </div>
                    </c:if>
                    <div class="account-wall">
                        <form class="form-login" action="${loginUrl}" method="POST">
                            <input type="text" id="login" name="login" class="form-control" placeholder="{{ 'LOGIN_LOG_IN_FORM_PLACEHOLDER_LOGIN' | translate }}" required autofocus>
                            <input type="password" id="password" name="password" class="form-control" placeholder="{{ 'LOGIN_LOG_IN_FORM_PLACEHOLDER_PASSWORD' | translate }}" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                {{ 'LOGIN_LOG_IN_ACTION' | translate }}
                            </button>
                            <div class="divDecalRememberMe">
                                <label class="remember-me checkbox pull-left">
                                    <input type="checkbox" name="remember-me"/>
                                    {{ 'LOGIN_LOG_IN_REMEMBER_ME' | translate }}
                                </label>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="include/js.jsp"/>
</body>
</html>