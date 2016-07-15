<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<t:wrapper>
    <form:form method="POST" modelAttribute="etudiant" class="form-horizontal panel panel-default col-md-6">
        <form:input type="hidden" path="id" id="id"/>
        <form:input type="hidden" path="idPersonne" id="idPersonne"/>
        <fieldset>
            <legend>Registration Form</legend>
            <form:input type="hidden" path="id" id="id"/>
            <div class="form-group">
                <label class="col-md-3 control-label" for="name">Last Name: </label>
                <div class="col-md-9">
                    <form:input path="codePermanent" id="codePermanent" placeholder="Code Permanent" class="form-control"/>
                    <form:errors path="codePermanent"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-3 col-md-9">
                    <label>
                        Etudiant International
                        <form:checkbox path="isInternational" id="isInternational" />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="groupe">Groupe: </label>
                <div class="col-md-9">
                    <form:select path="groupe" items="${goupes}" multiple="false" itemValue="id" itemLabel="nom" class="form-control"/>
                    <form:errors path="groupe" cssClass="error"/>
                </div>
            </div>
            <div class="col-md-9 col-md-offset-6">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Modifier" class="btn btn-primary"/>
                        <a href="<c:url value='/users' />" class="btn btn-default">Cancel</a>
                        <div class="ripple-container"></div>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Ajouter" class="btn btn-primary"/>
                        <a href="<c:url value='/users' />" class="btn btn-default">Cancel</a>
                        <div class="ripple-container"></div>
                    </c:otherwise>
                </c:choose>
            </div>
        </fieldset>
    </form:form>
</t:wrapper>