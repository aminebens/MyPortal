<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login | MyPortal</title>
        <!-- Mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Users List</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/bootstrap-material-design.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/ripples.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
        <!-- Material Design fonts -->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>
        <div id="login" class="fullscreen">
            <div class="align-vertical-center">
                <div class="container">
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6">
                            <div class="panel-body">
                                <div class="alert alert-dismissible alert-danger denied">
                                    <strong>Oups!</strong>
                                    <span><strong>${loggedinuser}</strong>, Vous n'êtes pas autorisé à accéder à cette page.</span> <span class="floatRight"><a class="deconnect" href="<c:url value="/logout" />">Deconnexion</a></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <!-- Twitter Bootstrap -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="<c:url value='/static/js/material.js'/>"></script>
        <script src="<c:url value='/static/js/ripples.js'/>"></script>
        <script src="<c:url value='/static/js/app.js'/>"></script>
    </body>
</html>

