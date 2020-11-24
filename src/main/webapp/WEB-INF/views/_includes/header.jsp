<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LibraryOC</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/heroic-features.css" rel="stylesheet">
    <link rel = "stylesheet" href = "https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/home"/>">
            <img src="<c:url value="/resources/img/navbar_icon.png"/>" alt="Library icon" style="width: 50px; height:auto">
        </a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarTogglerDemo02" >
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <c:choose>
                <c:when test="${!empty userInSessionUsername}">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/personalSpace/${userInSessionUsername}"/>">${ userInSessionUsername }</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/bookSearch"/>">Rechercher un livre</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout"/>">Se déconnecter</a>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/register"/>">S'inscrire</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login"/>">Se connecter</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/bookSearch"/>">Rechercher un livre</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
</body>
</html>
