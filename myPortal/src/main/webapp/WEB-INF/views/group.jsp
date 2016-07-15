<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title><c:choose><c:when test="${faire=='ajouter'}">ajouter un groupe </c:when><c:when test="${faire == 'modifier'}">modifier un groupe </c:when> <c:otherwise>groupes</c:otherwise></c:choose> </title>
            </head>
            <body>
        <t:wrapper>
            <c:choose>
                <c:when test="${faire == 'ajouter'}">
                    <h1>ajouter un groupe</h1>

                    <form:form method="POST" modelAttribute="groupe">
                        <table>
                            <tr>
                                <td><label for="nom">nom du groupe </label> </td>
                                <td><form:input path="nom" /></td>
                                <td><form:errors path="nom" cssClass="error"/></td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <input type="submit" value="ajouter"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </c:when>
                <c:when test="${faire == 'modifier'}">
                    <h1>modifier un groupe </h1>
                    <form:form method="POST" modelAttribute="groupe">
                        <table>
                            <tr>
                                <td><label for="nom">nom du groupe </label> </td>
                                <td><form:input path="nom" /></td>
                                <td><form:errors path="nom" cssClass="error"/></td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <input type="submit" value="Modifier"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </c:when> 
                <c:otherwise>
                    <h1>liste des groupes</h1>
                    <c:choose>
                        <c:when test="${empty groupes}">
                            No data available
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>nom du groupe</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${groupes}" var="groupe">
                                        <tr>
                                            <td>${groupe.id}</td>
                                            <td>${groupe.nom}</td>
                                            <td><a href="<c:url value='/group/${groupe.id}' />">Edit</a></td>
                                        </tr>
                                    </c:forEach>
                                        
                                </tbody>
                            </table>
                            <a href="<c:url value='/group/add' />" class="btn btn-raised btn-primary">
                    ajouter un groupe
                    <div class="ripple-container"></div>
                </a>
                        </c:otherwise> 
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </t:wrapper>
    </body>
</html>
