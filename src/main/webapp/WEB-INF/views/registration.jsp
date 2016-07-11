<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration Form</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
    <h2>Registration Form</h2>

    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">Last Name: </label> </td>
                <td><form:input path="nom" id="name"/></td>
                <td><form:errors path="nom" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="firstname">First Name: </label> </td>
                <td><form:input path="prenom" id="firstname"/></td>
                <td><form:errors path="prenom" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="login">Login: </label> </td>
                <td><form:input path="login" id="login"/></td>
                <td><form:errors path="login" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="pwd">Password: </label> </td>
                <td><form:input path="pwd" id="pwd"/></td>
                <td><form:errors path="pwd" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="dob">Date of Birth: </label> </td>
                <td><form:input path="dateNaissance" id="dob"/></td>
                <td><form:errors path="dateNaissance" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="telephone">Telephone: </label> </td>
                <td><form:input path="telephone" id="telephone"/></td>
                <td><form:errors path="telephone" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="address">Address: </label> </td>
                <td><form:input path="adresse" id="address"/></td>
                <td><form:errors path="adresse" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="nas">N.A.S: </label> </td>
                <td><form:input path="numeroAssuranceSociale" id="nas"/></td>
                <td><form:errors path="numeroAssuranceSociale" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="userRole">Role: </label> </td>
                <td>
                    <form:select path="userRole" items="${roles}" multiple="false" itemValue="id" itemLabel="type"/>
                </td>
                <td><form:errors path="userRole" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="active">Active: </label> </td>
                <td><form:checkbox path="active" id="active" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Users</a>
</body>
</html>
