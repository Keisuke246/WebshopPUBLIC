<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/style.css' />" rel="Stylesheet">
<link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="Stylesheet">

	<form:form id="loginForm"
		    	method="POST"
		    	action ="/webshop/connexion/send"
		    	modelAttribute="loginForm">
		<p><form:label path="email"><spring:message code="email"/>:</form:label> 
			<form:input type="text" path="email" />
			<form:errors path="email" class="required"/>
		</p>
		<p><form:label path="motDePasse"><spring:message code="password"/>:</form:label> 
			<form:input type="password" path="motDePasse" />
			<form:errors path="motDePasse" class="required"/>
		</p>
		
		<p><form:button type="submit"><spring:message code="login"/></form:button></p>
		<p><a href="/webshop/inscription"><spring:message code="registration"/></a></p>
	</form:form>
