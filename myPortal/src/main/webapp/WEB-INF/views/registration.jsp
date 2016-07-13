<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<t:wrapper>
    <form:form method="POST" modelAttribute="user" class="form-horizontal panel panel-default col-md-6">
        <fieldset>
            <legend>Registration Form</legend>
            <form:input type="hidden" path="id" id="id"/>
            <div class="form-group">
                <label class="col-md-3 control-label" for="name">Last Name: </label>
                <div class="col-md-9">
                    <form:input path="nom" id="name" placeholder="Last Name" class="form-control"/>
                    <form:errors path="nom"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="firstname">First Name: </label>
                <div class="col-md-9">
                    <form:input path="prenom" id="firstname" placeholder="Last Name" class="form-control"/>
                    <form:errors path="prenom"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="login">Login: </label>
                <div class="col-md-9">
                    <form:input path="login" id="login" placeholder="Login" class="form-control"/>
                    <form:errors path="login"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="pwd">Password: </label>
                <div class="col-md-9">
                    <form:input path="pwd" id="pwd" placeholder="Password" class="form-control"/>
                    <form:errors path="pwd"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="dob">Date of Birth: </label>
                <div class="col-md-9">
                    <form:input path="dateNaissance" id="dob" placeholder="DD/MM/YYYY" class="form-control"/>
                    <form:errors path="dateNaissance"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="telephone">Telephone: </label>
                <div class="col-md-9">
                    <form:input path="telephone" id="telephone" placeholder="Ex. 4381235555" class="form-control"/>
                    <form:errors path="telephone"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="email">Email: </label>
                <div class="col-md-9">
                    <form:input path="email" id="email" placeholder="Ex. email@domaine.com" class="form-control"/>
                    <form:errors path="email"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="address">Address: </label>
                <div class="col-md-9">
                    <form:input path="adresse" id="address" placeholder="Your Address" class="form-control"/>
                    <form:errors path="adresse"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="nas">N.A.S: </label>
                <div class="col-md-9">
                    <form:input path="numeroAssuranceSociale" id="nas" placeholder="333111444" class="form-control"/>
                    <form:errors path="numeroAssuranceSociale"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="userRole">Role: </label>
                <div class="col-md-9">
                    <form:select path="userRole" items="${roles}" multiple="false" itemValue="id" itemLabel="type" class="form-control"/>
                    <form:errors path="userRole" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-3 col-md-9">
                    <div class="togglebutton">
                        <label>
                            <form:checkbox path="active" id="active" />
                            <span id="activeSpan"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="col-md-9 col-md-offset-6">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary"/>
                        <a href="<c:url value='/users' />" class="btn btn-default">Cancel</a>
                        <div class="ripple-container"></div>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary"/>
                        <a href="<c:url value='/users' />" class="btn btn-default">Cancel</a>
                        <div class="ripple-container"></div>
                    </c:otherwise>
                </c:choose>
            </div>
        </fieldset>
    </form:form>
</t:wrapper>
