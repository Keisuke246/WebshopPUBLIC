<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">

<div id="center" class="column">
	<h1><spring:message code="allProducts"/></h1>
	<table>
		<tr>
			<th>#</th><th><spring:message code="name"/></th><th><spring:message code="unitPrice" /></th><th><spring:message code="availableStock"/></th>
		</tr>
			<c:forEach items="${articles}" var="articles">
		  		<tr>
		  			<td>${articles.id}</td>
		  			<td>${articles.libelle}</td>
		  			<td>${articles.prix}</td>
		  			<td>${articles.quantiteStock}</td>
		  		</tr>	  		
			</c:forEach>
	</table>
</div>