<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des formations</title>
        <!-- Mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" />
        <link href="<c:url value='/static/css/bootstrap-material-design.css' />" rel="stylesheet" />
        <link href="<c:url value='/static/css/ripples.css' />" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <link href="<c:url value='/static/css/main.css' />" rel="stylesheet" />
        <!-- Material Design fonts -->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>
        <t:wrapper>
        <div class="container-fluid">
            <div class="row">
                
                <div class="col-md-8">
                    <div class="well">
                        <div class="page-header">
                            <h1>Liste des Formations</h1>
                        </div>
                        <div class="panel-body">
                            <c:choose>
                                <c:when test="${empty matieres}">
                                    No data available
                                </c:when>
                                <c:otherwise>
                                    <table class="table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Titre</th>
                                                <th>Description</th>
                                                <th>Duree</th>
                                                <th>Montant</th>
                                                <th>Date Creation</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${formations}" var="uneformation">
                                                <tr>
                                                    <td>${uneformation.titre}</td>
                                                    <td>${uneformation.description}</td>
                                                    <td>${uneformation.duree}</td>
                                                    <td>${uneformation.prix}</td>
                                                    <td>${uneformation.dateCreation}</td> 
                                                   
                                                    <td>
                                                        <a href="<c:url value="/allFormations/edit-${uneformation.id}-formation" />" class="btn btn-primary">
                                                            Voir Matieres
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </td>                                                   
                                                </tr>  
                                            </c:forEach>
                                        </tbody>
                                    </table> 
                                </c:otherwise> 
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        jQuery 
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        Twitter Bootstrap 
        <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="<c:url value='/static/js/material.js'/>"></script>
        <script src="<c:url value='/static/js/ripples.js'/>"></script>
        </t:wrapper>
    </body>
</html>



