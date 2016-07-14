<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Alerts</title>
    </head>
    <body>
        <t:wrapper>
            <div class="page-header">
                <h2>List des alerts </h2>
            </div>
            <div class="panel-body">
                <c:choose>
                    <c:when test="${empty alerts}">
                        pas d'alert
                    </c:when>
                    <c:otherwise>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Type</th>
                                    <th>Date</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${alerts}" var="alert">
                                    <tr>
                                        <td>${alert.type}</td>
                                        <td>${alert.date}</td>
                                        <td><a href="<c:url value='/alert/${alert.id}' />">voir</a>
                                            <c:if test="${admin}">
                                                <a href="<c:url value='/alert/update/${alert.id}' />">metre a jour</a>
                                                <a href="<c:url value='/alert/supp/${alert.id}' />">supprimer</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise> 
                </c:choose>
            </div>

            <c:if test="${!empty vosAlerts}">
                <div class="page-header">
                    <h2>List de vos alertes </h2>
                </div>
                <div class="panel-body">

                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Type</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vosAlerts}" var="alert">
                                <tr>
                                    <td>${alert.type}</td>
                                    <td>${alert.date}</td>
                                    <td><a href="<c:url value='/alert/${alert.id}' />">voir</a>
                                        <a href="<c:url value='/alert/update/${alert.id}' />">metre a jour</a>
                                        <a href="<c:url value='/alert/supp/${alert.id}' />">supprimer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <c:if test="${!empty alertsGroup}">
                <div class="page-header">
                    <h2> List de votre groupe </h2>
                </div>
                <div class="panel-body">

                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Type</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${alertsGroup}" var="alert">
                                <tr>
                                    <td>${alert.type}</td>
                                    <td>${alert.date}</td>
                                    <td>
                                        <a href="<c:url value='/alert/${alert.id}' />">voir</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${!etu}">
                <a href="<c:url value='/alert/add' />" class="btn btn-raised btn-primary">
                    cree une alerte<div class="ripple-container"></div>
                </a>
            </c:if>

        </div>
    </t:wrapper>
</body>
</html>
