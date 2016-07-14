<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ajouter un sujet</title>
    </head>
    <body>
    <t:wrapper>
        <form:form method="POST" modelAttribute="sujet" class="form-horizontal panel panel-default col-md-6">
            <fieldset>
                <legend>ajouter un sujet</legend>
                <form:input cssStyle="display: none" path="date_creation"/>
                <form:input cssStyle="display: none" path="isResolu"/>
                <div class="form-group">
                    <label class="col-md-3 control-label" for="type">Type: </label>
                    <div class="col-md-9">
                        <form:input path="type" class="form-control"/>
                        <form:errors path="type" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label" for="titre">Titre: </label>
                    <div class="col-md-9">
                        <form:input path="titre" class="form-control"/>
                        <form:errors path="titre" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label" for="description">Description: </label>
                    <div class="col-md-9">
                        <form:textarea path="description" class="form-control" />
                        <form:errors path="description" cssClass="error"/>
                    </div>
                </div>
                <div class="col-md-9 col-md-offset-6">
                    <input type="submit" value="Enregistrer" class="btn btn-primary"/>
                    <a href="<c:url value='/sujets' />" class="btn btn-default">Annuler</a>
                    <div class="ripple-container"></div>
                </div>
            </fieldset>
        </form:form>
    </t:wrapper>
</body>
</html>
