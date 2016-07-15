<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<t:wrapper>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>List of Users</h2>
        </div>
        <div class="panel-body">
            <sec:authorize access="hasRole('ADMIN')">
                <a href="<c:url value='/users/new' />" class="btn btn-raised btn-primary">
                    Create a new user
                    <div class="ripple-container"></div>
                </a>
            </sec:authorize>
            <c:choose>
                <c:when test="${empty users}">
                    No data available
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Last Name</th>
                                <th>First Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>N.A.S</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.nom}</td>
                                    <td>${user.prenom}</td>
                                    <td>${user.email}</td>
                                    <td>${user.telephone}</td>
                                    <td>${user.numeroAssuranceSociale}</td>
                                    <td>${user.userRole.type}</td>
                                    <td>${user.active ? "Active" : "Deactivated"}</td>
                                    <td><a href="<c:url value='/users/edit-${user.id}-user' />">Edit</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise> 
            </c:choose>
        </div>
    </div>
</t:wrapper>
