<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<t:wrapper>
    <div class="row">               
        <div class="col-md-12">
            <div class="well">
                <div class="page-header">
                    <h1>Liste des Formations</h1>
                </div>
                <div class="panel-body">
                    <c:choose>
                        <c:when test="${empty formations}">
                            No data available
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Description</th>
                                        <th>Duree(en heures)</th>
                                        <th>Montant</th>
                                        <th>Date Creation</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${formations}" var="uneformation">
                                        <tr>
                                            <td>${uneformation.titre}</td>
                                            <td>${uneformation.description}</td>
                                            <td>${uneformation.duree}</td>
                                            <td>${uneformation.prix}</td>
                                            <td>${uneformation.dateCreation}</td> 

                                            <td>
                                                <a href="<c:url value="/allFormations/edit-${uneformation.id}-formation" />" class="btn btn-primary">
                                                    Voir Matieres
                                                    <div class="ripple-container"></div>
                                                </a>
                                            </td>                                                   
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




