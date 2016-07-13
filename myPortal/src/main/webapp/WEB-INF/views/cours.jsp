<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emploi de temps</title>
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
                            <h2>Liste des Cours</h2>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>NoCours</th>
                                    <th>NoMatiere</th>
                                    <th>Session</th>
                                    <th>plage Horaire</th>
                                    <th>date Debut</th>
                                    <th>date Fin</th>
                                    <th>No Prof</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${cours}" var="unCours">
                                    <tr>
                                        <td>${unCours.id}</td>
                                        <td>${unCours.idMatiere}</td>
                                        <td>${unCours.plageHoraire}</td>
                                        <td>${unCours.dateDebut}</td>
                                        <td>${unCours.dateFin}</td>
                                        <td>${unCours.maSession}</td>
                                        <td>${unCours.idProf}</td>
                                    
                                    </tr>  
                                </c:forEach>
                            </tbody>
                        </table>                        
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


