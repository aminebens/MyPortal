<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Alerts</title>
    </head>
    <body>
        <div class="page-header">
            <h2>List of Users</h2>
        </div>
        <c:choose>
            <c:when test="${empty alertsUser}">
                pas d'alert
            </c:when>
            <c:otherwise>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${alertsUser}" var="alert">
                            <tr>
                                <td>${alert.type}</td>
                                <td>${alert.date}</td>
                                <td><a href="<c:url value='/edit-${alert.id}-user' />">voir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise> 
        </c:choose>
    </body>
</html>
