<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Ajouter une Alerts</title>
    </head>
    <body>
        <h2>Registration Form</h2>

        <form:form method="POST" modelAttribute="alert">
            <form:input type="hidden" path="idUserFrom"/>
            <form:errors path="idUserFrom" cssClass="error"/>
            <table>
                <tr>
                    <td><label for="idUserTo">Utilisateur: </label> </td>
                    <td><form:select path="idUserTo" multiple="false">
                            <form:option value="">selectionez un user</form:option>
                            <form:options items="${users}" itemValue="id" itemLabel="nom" />
                        </form:select></td>
                    <td><form:errors path="idUserTo" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="idGroupe">Groupe: </label> </td>
                    <td>
                        <form:select path="idGroupe" multiple="false">
                            <form:option value="">selectionez un groupe</form:option>
                            <form:options items="${groups}" itemValue="id" itemLabel="nom" />
                        </form:select>
                    </td>
                    <td><form:errors path="idGroupe" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="type">Type: </label> </td>
                    <td><form:input path="type" /></td>
                    <td><form:errors path="type" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="contenu">Contenu: </label> </td>
                    <td><form:input path="contenu"/></td>
                    <td><form:errors path="contenu" cssClass="error"/></td>
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
