<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matiere Registration Form</title>
        <!-- Mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Matieres List</title>
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
        <t:wrapper>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10">
                    <form:form method="POST" modelAttribute="matiere" class="form-horizontal panel panel-default col-md-6">
                        <form:input type="hidden" path="id" id="id"/>
                        <fieldset>
                            <c:choose>
                                <c:when test="${edit==true}"><h1>Modifier une matiere</h1></c:when>
                                <c:when test="${edit==false}"><h1>Ajouter une matiere</h1></c:when>
                            </c:choose>  
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="no">No Cours: </label>
                                <div class="col-md-9">
                                    <form:input path="noCours" id="no" placeholder="Entrer no Cours" class="form-control"/>
                                    <form:errors path="noCours"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="titre">Titre: </label>
                                <div class="col-md-9">
                                    <form:input path="titre" id="titre" placeholder="Entrer un titre" class="form-control"/>
                                    <form:errors path="titre"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="descrip">Description </label>
                                <div class="col-md-9">
                                    <form:input path="description" id="descrip" placeholder="Entrer une description" class="form-control"/>
                                    <form:errors path="description"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="duree">Duree </label>
                                <div class="col-md-9">
                                    <form:input path="duree" id="duree" placeholder="Entrer une duree" class="form-control"/>
                                    <form:errors path="duree"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="prix">Montant: </label>
                                <div class="col-md-9">
                                    <form:input path="prix" id="prix" placeholder="Entrer un montant" class="form-control"/>
                                    <form:errors path="prix"/>
                                </div>
                            </div>                                                  
                            <div class="col-md-9 col-md-offset-6">
                                <c:choose>
                                    <c:when test="${edit}">
                                        <input type="submit" value="MODIFIER" class="btn btn-primary"/>
                                        <a href="<c:url value='/allMatieres' />" class="btn btn-default">
                                            Cancel
                                            <div class="ripple-container"></div>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="AJOUTER" class="btn btn-primary" />
                                        <a href="<c:url value='/allMatieres' />" class="btn btn-default">
                                            Cancel
                                            <div class="ripple-container"></div>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </fieldset>
                    </form:form>
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
        </t:wrapper>
    </body>
</html>




