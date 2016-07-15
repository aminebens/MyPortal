<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<t:wrapper>
    <form:form method="POST" modelAttribute="profile" class="form-horizontal col-md-8">        
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3>Profile - ${profile.userRole.type}</h3>
            </div>
            <div class="panel-body list-group">
                <div class="form-group">
                    <label class="col-md-3 control-label" for="name">Nom: </label>
                    <div class="col-md-9">
                        <input class="form-control" type="text" disabled="disabled" value="${profile.prenom} ${profile.nom}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label" for="name">Login: </label>
                    <div class="col-md-9">
                        <input class="form-control" type="text" disabled="disabled" value="${profile.login}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label" for="name">N.A.S </label>
                    <div class="col-md-9">
                        <input class="form-control" type="text" disabled="disabled" value="${profile.numeroAssuranceSociale}" />
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3>Information Personnel</h3>
            </div>
            <div class="panel-body">
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
                    <label class="col-md-3 control-label" for="address">Adresse: </label>
                    <div class="col-md-9">
                        <form:input path="adresse" id="address" placeholder="Your Address" class="form-control"/>
                        <form:errors path="adresse"/>
                    </div>
                </div>
                <div class="col-md-9 col-md-offset-9">
                    <input type="submit" value="Sauvegarder" class="btn btn-warning"/>
                    <div class="ripple-container"></div>
                </div>
            </div>
        </div>
    </form:form>
</t:wrapper>
