<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <jsp:include page="header.jsp"/>
        <div class="container-fluid"> 
            <div class="row">
                <jsp:include page="sidemenu.jsp"/> 
                <div class="col-md-10">
                    <jsp:doBody/>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <!-- Twitter Bootstrap -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="<c:url value='/static/js/material.js'/>"></script>
        <script src="<c:url value='/static/js/ripples.js'/>"></script>
        <script src="<c:url value='/static/js/app.js'/>"></script>
    </body>
</html>