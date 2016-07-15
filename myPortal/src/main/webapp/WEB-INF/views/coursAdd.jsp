<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<t:wrapper>
            <div class="row">
                <div class="col-md-12">
                    <form:form method="POST" modelAttribute="cours" class="form-horizontal panel panel-default col-md-6">
                        <fieldset>
                            <c:choose>
                                <c:when test="${edit==true}"><h1>Modifier un Cours</h1></c:when>
                                <c:when test="${edit==false}"><h1>Ajouter un Cours</h1></c:when>
                            </c:choose>  
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="libelle">Libelle :</label>
                                <div class="col-md-9">
                                    <form:input path="libelle" id="libelle" placeholder="Entrer un libelle" class="form-control"/>
                                    <form:errors path="libelle"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="session">Session :</label>
                                <div class="col-md-9">
                                    <form:input path="maSession" id="session" placeholder="Entrer la session" class="form-control"/>
                                    <form:errors path="maSession"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="plage">Plage Horaire :</label>
                                <div class="col-md-9">
                                    <form:input path="plageHoraire" placeholder="Entrer une description" class="form-control"/>
                                    <form:errors path="plageHoraire"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="dateD">Date de debut: </label>
                                <div class="col-md-9">
                                    <form:input path="dateDebut" id="dateD" placeholder="Entrer une date de debut" class="form-control"/>
                                    <form:errors path="dateDebut"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="dateF">Date de Fin: </label>
                                <div class="col-md-9">
                                    <form:input path="dateFin" id="dateF" placeholder="Entrer une date de fin" class="form-control"/>
                                    <form:errors path="dateFin"/>
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="nomProf">Nom professeur </label>
                                <div class="col-md-9">  
                                    <c:choose>
                                        <c:when test="${edit == false}">
                                            <form:select path="nomProf" id="nomProf">
                                                <c:forEach items="${profs}" var="prof">
                                                    <form:option value="${prof.user.nom}" label="${prof.user.nom}" />
                                                </c:forEach>  
                                            </form:select>
                                            <form:errors path="nomProf"/>
                                        </c:when>
                                        <c:otherwise>
                                            <form:input path="nomProf" id="nomProf" class="form-control" />
                                            <form:errors path="nomProf"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="titreMat">Titre Matiere </label>
                                <div class="col-md-9">
                                    <c:choose>
                                        <c:when test="${edit == false}">
                                            <form:select path="titreMatiere" id="titreMat">
                                                <c:forEach items="${matiere}" var="mat">
                                                    <form:option value="${mat.titre}" label="${mat.titre}" />
                                                </c:forEach>
                                            </form:select>                                                                    
                                            <form:errors path="titreMatiere"/>
                                        </c:when>
                                        <c:otherwise>
                                            <form:input path="titreMatiere" id="titreMatiere" class="form-control" />
                                            <form:errors path="titreMatiere"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div> 
                            <div class="col-md-9 col-md-offset-6">
                                <c:choose>
                                    <c:when test="${edit}">
                                        <input type="submit" value="ENREGISTRER" class="btn btn-primary"/>
                                        <a href="<c:url value='/allCours' />" class="btn btn-default">
                                            Cancel
                                            <div class="ripple-container"></div>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="AJOUTER" class="btn btn-primary" />
                                        <a href="<c:url value='/allCours' />" class="btn btn-default">
                                            Cancel
                                            <div class="ripple-container"></div>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
</t:wrapper>




