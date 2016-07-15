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
                    <th>Date</th>
                    <th>Montant</th>
                    <th>Type de paiement</th>
                </tr>

                <c:forEach items="${facture}" var="facture">
                    <tr>
                        <td>${loggedinuser.getLogedInUserFullName()}</td>
                        <td>${facture.date}</td>
                        <td>${facture.montant}</td>
                        <td>${facture.typePaiement}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </t:wrapper>
