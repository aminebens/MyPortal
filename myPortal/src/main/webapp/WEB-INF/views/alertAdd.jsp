<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Ajouter une Alert</title>
    </head>
    <body>
        <t:wrapper>
            <h2></h2>
            <form:form method="POST" modelAttribute="alert" class="form-horizontal panel panel-default col-md-6">
                <fieldset>
                    <legend>Ajouter une Alert</legend>
                    <form:input type="hidden" path="idUserFrom" />
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="idUserTo">Utilisateur: </label>
                        <div class="col-md-9">
                            <form:select path="idUserTo" multiple="false" class="form-control">
                                <form:option value="">selectionez une personne</form:option>
                                <form:options items="${users}" itemValue="id" itemLabel="nom" />
                            </form:select>
                            <form:errors path="idUserTo" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="idGroupe">Groupe: </label>
                        <div class="col-md-9">
                            <form:select path="idGroupe" multiple="false" class="form-control">
                                <form:option value="">selectionez un groupe</form:option>
                                <form:options items="${groups}" itemValue="id" itemLabel="nom" />
                            </form:select>
                            <form:errors path="idGroupe" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="type">Type: </label>
                        <div class="col-md-9">
                            <form:input path="type" class="form-control"/>
                            <form:errors path="type" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="contenu">Contenu: </label>
                            <div class="col-md-9">
                                <form:input path="contenu" class="form-control"/>
                                <form:errors path="contenu" cssClass="error"/>
                            </div>
                        </div>
                        <div class="col-md-9 col-md-offset-6">
                            <input type="submit" value="${edit!=true?'Enregister':'Metre a jour'}" class="btn btn-primary"/>
                            <a href="<c:url value='/alerts' />" class="btn btn-default">Annuler</a>
                            <div class="ripple-container"></div>
                        </div>
                    </form:form>
                </t:wrapper>
                </body>
                </html>
