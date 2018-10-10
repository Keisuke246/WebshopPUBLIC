<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='style.css' />" rel="Stylesheet">

<div id="center" class="column">
	<form:form id="loginForm"
		    	method="POST"
		    	action ="/webshop/connexion/send"
		    	modelAttribute="loginForm">
		<p class="line"><span><spring:message code="email"/>:</span> 
			<form:input type="text" path="email" />
		</p>
		<p class="line"><span><spring:message code="password"/>:</span> 
			<form:input type="password" path="motDePasse" />
		</p>
		<p class="line center"><a href="/webshop/inscription" class="reg"><spring:message code="registration"/></a></p>
		<p class="line center pad20"><form:button type="submit"><spring:message code="login"/></form:button></p>
	</form:form>
</div>