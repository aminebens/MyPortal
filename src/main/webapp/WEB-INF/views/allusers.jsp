<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Mobile support -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap-material-design.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/ripples.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
    <!-- Material Design fonts -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>MyPortal</h1>
                <div class="well">
                    <div class="page-header">
                        <h2>List of Users</h2>
                    </div>
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
                                    <td><a href="<c:url value='/edit-${user.id}-user' />">Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </c:otherwise> 
                    </c:choose>
                    <br/>
                    <a href="<c:url value='/new' />" class="btn btn-primary btn-fab">
                        <i class="material-icons">person_add</i><div class="ripple-container"></div>
                    </a>
                </div>
            </div>
        </div>
    </div>
<!-- jQuery -->
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- Twitter Bootstrap -->
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="<c:url value='/static/js/material.js'/>"></script>
<script src="<c:url value='/static/js/ripples.js'/>"></script>
<script>
  $.material.init();
</script>
</body>
</html>
