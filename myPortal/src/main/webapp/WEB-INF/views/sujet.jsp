<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <title>${sujet.titre}</title>
    </head>
    <body style="font-family:Verdana">
        <t:wrapper>
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

        <div>
            <div class="row " style="padding-top:40px;">
                <div class="col-md-8">
                    <div class="panel panel-info">
                        <c:if test="${!sujet.messages.isEmpty()}">
                            <div class="panel-heading" style="background-color: #3f51b5;">
                                MESSAGES
                            </div>
                            <div class="panel-body">
                                <ul class="media-list">
                                    <c:forEach var="message" items="${sujet.messages}">
                                        <li class="media">
                                            <div class="media-body">
                                                <div class="media">
                                                    <div class="pull-left">
                                                        <img class="media-object img-circle " src="assets/img/user.png" />
                                                    </div>
                                                    <div class="media-body" >
                                                        ${message.message}
                                                        <br />
                                                        <small class="text-muted">${message.userFrom.nom} ${" "} ${message.userFrom.prenom} | ${message.date} </small>
                                                        <hr />
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${!sujet.isResolu}">
                            <div class="panel-body">
                                <form:form class="input-group" method="POST" modelAttribute="message">
                                    <form:input cssStyle="display: none" path="date"/>
                                    <form:input class="form-control" placeholder="Enter Message" path="message"/>
                                    <form:errors path="message" cssClass="error"/>
                                    <span class="input-group-btn">
                                        <input class="btn btn-info" type="submit" value="envoyer"/>
                                    </span>
                                </form:form>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
            </t:wrapper>
    </body>
</html>
