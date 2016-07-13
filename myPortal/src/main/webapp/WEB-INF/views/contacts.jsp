<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<t:wrapper>
    <div class="panel panel-default">

        <div class="panel-heading">
            <h2>List of Contacts</h2>
        </div>

        <div class="panel-body">
            <table class="table table-striped table-hover">
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Telephone</th>
                    <th>...</th>
                </tr>

                <c:forEach items="${contacts}" var="contact">
                    <tr>
                        <td>${contact.nom}</td>
                        <td>${contact.prenom}</td>
                        <td>${contact.email}</td>
                        <td>${contact.telephone}</td>
                        <td><img src="${contact.photo}" alt="${contact.prenom}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </t:wrapper>
