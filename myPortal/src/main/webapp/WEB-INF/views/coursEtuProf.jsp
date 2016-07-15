<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<t:wrapper>
    <div class="row">
        <div class="col-md-8">
            <div class="well">
                <div class="page-header">
                    <h1>Liste des Cours</h1>
                </div>
                <div class="panel-body">
                    <c:choose>
                        <c:when test="${empty cours}">
                            No data available
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Libelle</th>
                                        <th>Session</th>
                                        <th>Plage horaire</th>
                                        <th>Date de debut</th>
                                        <th>Date de fin</th>
                                        <th>Titre matiere</th>
                                            <sec:authorize access="hasRole('EDUTIANT')">
                                            <th>Nom professeur</th>
                                            </sec:authorize>                                                      
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${cours}" var="unCours">
                                        <tr>
                                            <td>${unCours.libelle}</td>
                                            <td>${unCours.maSession}</td>
                                            <td>${unCours.plageHoraire}</td>
                                            <td>${unCours.dateDebut}</td>
                                            <td>${unCours.dateFin}</td>                                                                                                                  
                                            <td>${unCours.uneMat.titre}</td>
                                            <sec:authorize access="hasRole('EDUTIANT')">
                                                <td>${unCours.prof.user.nom}</td>
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
</t:wrapper>





