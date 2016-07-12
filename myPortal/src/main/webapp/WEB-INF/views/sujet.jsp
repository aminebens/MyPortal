<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>${sujet.titre}e</title>
    </head>
    <body>
        titre: ${sujet.titre}
        <br>
        type: ${sujet.type}
        <br>
        de: ${sujet.user.nom}${"  "}${sujet.user.prenom}
        <br>
        date de creation: ${sujet.date_creation}
        <br>
        description: ${sujet.titre}
        <br>
        resolu: ${sujet.isResolu?"oui":"non"}
        <br>
        <c:if test="${!sujet.isResolu}">
            <a href="<c:url value='/sujet/resolu/${sujet.id}'/>">resolu</a>
        </c:if>
    </body>
</html>
