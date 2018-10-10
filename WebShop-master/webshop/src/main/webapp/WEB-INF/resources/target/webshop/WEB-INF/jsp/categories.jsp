<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">


<div id="center" class="column">
	<h1><spring:message code="productOfCategory"/> : ${categories[idcategorie-1].libelle}</h1>
	<table>
		<tr>
			<th><spring:message code="image"/></th><th><spring:message code="name"/></th><th><spring:message code="unitPrice"/> (&euro;)</th><th><spring:message code="availableStock"/></th><th><spring:message code="addToCart"/></th><th><spring:message code="details"/></th>
		</tr>
			<c:forEach items="${articles}" var="article">
		  		<tr>
		  			<td>Pas d'image</td>
		  			<td>${article.libelle}</td>
		  			<td>${article.prix}</td>
		  			<td>${article.quantiteStock}</td>
					<td><a href='<spring:url value="/panier/add/${article.id}/1"/>'><img src='<spring:url value="/images/carts.gif"/>'/></a></td>
		  			<td><a href ='<spring:url value="/boutique/${article.id}"/>'><img src='<spring:url value="/images/Magnifier.png"/>'/></a></td>
		  		</tr>	  		
			</c:forEach>
	</table>
</div>