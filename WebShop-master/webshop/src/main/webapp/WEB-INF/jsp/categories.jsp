<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link type="text/css" href="<spring:url value='/css/boutique.css' />" rel="Stylesheet">

	
	<div id="produit">
		
		<c:forEach items="${articles}" var="article">
	  		<div>
	  			<img class='main' src='<spring:url value="/images/categories/${idcategorie}.png"/>' height="70">
	  			
				<a href='<spring:url value="/panier/add/${article.id}/1"/>'><img src='<spring:url value="/images/addcart.png" />' width="20"/></a>
	  			<a href ='<spring:url value="/boutique/${article.id}"/>'><img src='<spring:url value="/images/look.png"/>' width="20"/></a>
	  			
	  			<p>${article.prix} XBT</p>
	  			
	  			<h2>${article.libelle}</h2>
	  			<p>${article.quantiteStock} disponibles</p>
				
	  		</div>	  		
		</c:forEach>
	</div>