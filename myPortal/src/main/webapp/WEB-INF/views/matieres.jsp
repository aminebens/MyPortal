<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des matieres</title>
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
                            <h1>Liste des Matieres</h1>
                        </div>
                        <div class="panel-body">
                            <c:choose>
                                <c:when test="${empty matieres}">
                                    No data available
                                </c:when>
                                <c:otherwise>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <a href="<c:url value='/allMatieres/new' />" class="btn btn-raised btn-primary">
                                            Create a new matiere
                                            <div class="ripple-container"></div>
                                        </a>
                                    </sec:authorize>
                                    <table class="table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>NoCours</th>
                                                <th>Titre</th>
                                                <th>Description</th>
                                                <th>Duree(en heures)</th>
                                                <th>Montant</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${matieres}" var="uneMatiere">
                                                <tr>
                                                    <td>${uneMatiere.noCours}</td>
                                                    <td>${uneMatiere.titre}</td>
                                                    <td>${uneMatiere.description}</td>
                                                    <td>${uneMatiere.duree}</td>
                                                    <td>${uneMatiere.prix}</td> 
                                                    <sec:authorize access="hasRole('ADMIN')">
                                                    <td>
                                                        <a href="<c:url value="/allMatieres/edit-${uneMatiere.id}-matiere" />" class="btn btn-primary">
                                                            MODIFIER
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </td>
                                                    </sec:authorize>
                                                    <sec:authorize access="hasRole('ADMIN')">
                                                    <td>
                                                        <a href="<c:url value="/allMatieres/delete-${uneMatiere.id}-matiere" />" class="btn btn-primary">
                                                            SUPPRIMER
                                                            <div class="ripple-container"></div>
                                                        </a>
                                                    </td>
                                                    </sec:authorize>
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


