<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
        <t:wrapper>
            <div class="container">
                <div class="row">
                    <div class="col-md-14">
                        <h1>MyPortal</h1>
                        <div class="well">
                            <div class="page-header">
                                <h2>Emploi de temps</h2>
                            </div>
                            <div class="page-header">
                                <h4>Date : ${today}</h4>
                            </div>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Lundi</th>
                                        <th>Mardi</th>
                                        <th>Mercredi</th>
                                        <th>Jeudi</th>
                                        <th>Vendredi</th>
                                        <th>Samedi</th>
                                        <th>Dimanche</th>
                                    </tr>
                                </thead>
                                <tbody>                               
                                    <tr>
                                        <c:forEach var="entry" begin="1" end="7">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${(entry >= jourDebut) && (entry <= jourFin) && (entry != 6)&& (entry != 7)&& (entry != 28) 
                                                                    && (entry != 13)&& (entry != 14)&& (entry != 20)&& (entry != 21) && (entry != 27)}">
                                                            <span class= "btn btn-raised btn-primary">
                                                                ${cours.libelle} </br> ${cours.plageHoraire}                                                   
                                                            </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${entry}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:forEach>
                                    <tr>
                                        <c:forEach var="entry" begin="8" end="14">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${(entry >= jourDebut) && (entry <= jourFin) && (entry != 6)&& (entry != 7)&& (entry != 28) 
                                                                    && (entry != 13)&& (entry != 14)&& (entry != 20)&& (entry != 21) && (entry != 27)}">
                                                            <span class= "btn btn-raised btn-primary">
                                                                ${cours.libelle} </br> ${cours.plageHoraire}                                                   
                                                            </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${entry}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:forEach>
                                    </tr>  
                                    <tr>
                                        <c:forEach var="entry" begin="15" end="21">
                                            <td>
                                               <c:choose>
                                                    <c:when test="${(entry >= jourDebut) && (entry <= jourFin) && (entry != 6)&& (entry != 7)&& (entry != 28) 
                                                                    && (entry != 13)&& (entry != 14)&& (entry != 20)&& (entry != 21) && (entry != 27)}">
                                                            <span class= "btn btn-raised btn-primary">
                                                                ${cours.libelle} </br> ${cours.plageHoraire}                                                   
                                                            </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${entry}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:forEach>
                                    </tr>  
                                    <tr>
                                        <c:forEach var="entry" begin="22" end="28">
                                            <td>
                                               <c:choose>
                                                    <c:when test="${(entry >= jourDebut) && (entry <= jourFin) && (entry != 6)&& (entry != 7)&& (entry != 28) 
                                                                    && (entry != 13)&& (entry != 14)&& (entry != 20)&& (entry != 21) && (entry != 27)}">
                                                            <span class= "btn btn-raised btn-primary">
                                                                ${cours.libelle} </br> ${cours.plageHoraire}                                                   
                                                            </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${entry}
                                                    </c:otherwise>
                                                </c:choose> 
                                            </td>
                                        </c:forEach>
                                    </tr>  
                                    <tr>
                                        <c:forEach var="entry" begin="29" end="31">
                                            <td>
                                               <c:choose>
                                                    <c:when test="${(entry >= jourDebut) && (entry <= jourFin) && (entry != 6)&& (entry != 7)&& (entry != 28) 
                                                                    && (entry != 13)&& (entry != 14)&& (entry != 20)&& (entry != 21) && (entry != 27)}">
                                                            <span class= "btn btn-raised btn-primary">
                                                                ${cours.libelle} </br> ${cours.plageHoraire}                                                   
                                                            </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${entry}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:forEach>
                                    </tr>  
                                </tbody>
                            </table>                        
                        </div>
                    </div>
                </div>
            </div>
            <!--jQuery--> 
            <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
            <!--Twitter Bootstrap--> 
            <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
            <script src="<c:url value='/static/js/material.js'/>"></script>
            <script src="<c:url value='/static/js/ripples.js'/>"></script>
        </t:wrapper>
    </body>
</html>


