<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>MyPortal</h1>
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
                                    <input type="button" value="Ajouter"/>
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
                                                    <td><input type="button" value="Modifier" /></td>
                                                    <td><input type="button" value="Supprimer" /></td>
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
        <script src="<c:url value='/static/js/material.js'/>"></script>
        <script src="<c:url value='/static/js/ripples.js'/>"></script>
    </body>
</html>


