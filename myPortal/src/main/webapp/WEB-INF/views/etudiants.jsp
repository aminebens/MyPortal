<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<t:wrapper>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Les Etudiants</h2>
        </div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${empty etudiants}">
                    No data available
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>N.A.S</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${etudiants}" var="user">
                                <tr>
                                    <td>${etudiants.nom} ${etudiants.prenom}</td>
                                    <td>${etudiants.numeroAssuranceSociale}</td>
                                    <td><a href="<c:url value='/etudiants/edit-${etudiants.id}-etu' />">Inscrire</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise> 
            </c:choose>
        </div>
    </div>
</t:wrapper>
