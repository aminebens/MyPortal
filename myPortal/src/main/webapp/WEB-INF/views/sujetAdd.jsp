<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>ajouter un sujet</title>
    </head>
    <body>
        <h2>ajouter un sujet</h2>

        <form:form method="POST" modelAttribute="sujet">
            <input style="display: none" type="text" id="date_creation" name="date_creation" value="${date}"/>
            <form:errors path="date_creation" cssClass="error"/>
            <input style="display: none" type="text" id="user" name="user" value="${idUser}"/>
            <form:errors path="user" cssClass="error"/>
            <input style="display: none" type="text" id="isResolu" name="isResolu" value="false"/>
            <form:errors path="isResolu" cssClass="error"/>
            <table>
                <tr>
                    <td><label for="type">Type: </label> </td>
                    <td><form:input path="type"/></td>
                    <td><form:errors path="type" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="description">Description: </label> </td>
                    <td><form:input path="description" /></td>
                    <td><form:errors path="description" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="titre">Titre: </label> </td>
                    <td><form:input path="titre"/></td>
                    <td><form:errors path="titre" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Register"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
