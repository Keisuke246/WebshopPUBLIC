<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">

<div id="center" class="column">
	<form:form id="inscriptionForm2"
			   method="POST"
			   action="/webshop/inscription/send"
			   modelAttribute="currentUser">
		<form:label path="nom"><spring:message code="name"/><span class="required"> *</span></form:label>
		<form:input path="nom"/>
		<br>
		<form:errors path="nom" class="required"/><br><br>
		
		<form:label path="prenom"><spring:message code="surname"/><span class="required"> *</span></form:label>
		<form:input path="prenom"/>
		<br>
		<form:errors path="prenom" class="required"/><br><br>
		
		<form:label path="telephone"><spring:message code="phone"/></form:label>
		<form:input path="telephone"/>
		<br>
		<form:errors path="telephone" class="required"/><br><br>
		
		<form:label path="email"><spring:message code="mail"/><span class="required"> *</span></form:label>
		<form:input path="email"/>
		<br>
		<form:errors path="email" class="required"/><br><br>
		
		<form:label path="motDePasse"><spring:message code="password"/><span class="required"> *</span></form:label>
		<form:input path="motDePasse" type="password"/>
		<br>
		<form:errors path="motDePasse" class="required"/><br><br>
		
		<form:label path="confirmationMotDePasse"><spring:message code="confirmPassword"/><span class="required"> *</span></form:label>
		<form:input path="confirmationMotDePasse" type="password"/>
		<br>
		<form:errors path="confirmationMotDePasse" class="required"/><br><br>
		
		<form:label path="rue"><spring:message code="streetName"/><span class="required"> *</span></form:label>
		<form:input path="rue"/>
		<br>
		<form:errors path="rue" class="required"/><br><br>
		
		<form:label path="numeroRue"><spring:message code="streetNumber"/><span class="required"> *</span></form:label>
		<form:input path="numeroRue" type="number" min="1" max="1000"/>
		<br>
		<form:errors path="numeroRue" class="required"/><br><br>
		
		<form:label path="etage"><spring:message code="floorNumber"/></form:label>
		<form:input path="etage" type="number" min="0" max="40"/>
		<br>
		<form:errors path="etage" class="required"/><br><br>
		
		<form:label path="localite"><spring:message code="locality"/><span class="required"> *</span></form:label>
		<form:input path="localite"/>
		<br>
		<form:errors path="localite" class="required"/><br><br>
		
		<form:label path="codePostal"><spring:message code="zipCode"/><span class="required"> *</span></form:label>
		<form:input path="codePostal" type="number" min="1" max="9999"/>
		<br>
		<form:errors path="codePostal" class="required"/><br><br>
		
		<form:label path="pays"><spring:message code="country"/><span class="required"> *</span></form:label>
		<form:input path="pays"/>
		<br>
		<form:errors path="pays" class="required"/><br><br>
		
		<form:button type="submit"><spring:message code="register"/></form:button>
	</form:form>
</div>
