<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">
	<h1>${pageTitle}</h1>
	<div id="produit">
			<c:forEach items="${articles}" var="articles">
		  		<div>
		  			<img class='main' src='<spring:url value="/images/categories/${articles.categorie.id}.png"/>' height="70">
		  			
		  			<a href='<spring:url value="/panier/add/${articles.id}/1"/>'><img src='<spring:url value="/images/addcart.png" />' width="20"/></a>
	  				<a href ='<spring:url value="/boutique/${articles.id}"/>'><img src='<spring:url value="/images/look.png"/>' width="20"/></a>
	  			
		  			<p>${articles.prix} XBT</p>
		  			<h2>${articles.libelle}</h2>
		  			<p>${articles.quantiteStock} <spring:message code="available"/></p>
		  		</div>	  		
			</c:forEach>
	</div>
