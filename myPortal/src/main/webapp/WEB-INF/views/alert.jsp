<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>alert</title>
    </head>
    <body>
    <t:wrapper>

        Type: ${alert.type}<br/>
        Date: ${alert.date}<br/>
        De: ${userFrom.nom} ${userFrom.prenom} <br/>
        Contenu: ${alert.contenu}<br/>
        <a href="<c:url value='/alerts' />" class="btn btn-default">Retour</a>
        
    </t:wrapper>
</body>
</html>
