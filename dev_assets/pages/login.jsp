<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
<body>
    <jsp:include page="menu.jsp"/>

    <c:url value="/login" var="loginUrl"/>

    <div class="content">
        <div class="container login">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Authentification</h1>

                    <c:if test="${'fail' eq param.auth}">
                        <div class="alert alert-danger text-center">
                            Authentification échouée.<br/>
                            Le couple Identifiant / Mot de passe est incorrecte
                        </div>
                    </c:if>

                    <c:if test="${not empty param.logout}">
                        <div class="alert alert-success text-center">
                            Déconnexion effectuée avec succès
                        </div>
                    </c:if>
                    <div class="account-wall">
                        <!--<img class="profile-img" src="/img/logoMDM.png" width="150"  alt="">-->

                        <form class="form-signin" action="${loginUrl}" method="POST">
                            <input type="text" id="login" name="login" class="form-control" placeholder="Identifiant" required
                                   autofocus>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Mot de Passe"
                                   required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Se connecter
                            </button>
                            <label class="remember-me checkbox pull-left">
                                <input type="checkbox" name="remember-me">
                                Se souvenir de moi
                            </label>
                        <span class="clearfix"></span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="include/js.jsp"/>
</body>
</html>